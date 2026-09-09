package kr.dogfoot.hwplib.reader.bodytext.paragraph;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.ForControl;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.form.ForFormControl;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.ForGsoControl;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 하나의 문단을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForParagraph {
    /**
     * 스트림 리더
     */
    private StreamReader sr;

    /**
     * 문단 헤더의 level
     */
    private short paraHeaderLevel;

    /**
     * 문단 객체
     */
    private Paragraph paragraph;

    /**
     * 생성자
     */
    public ForParagraph() {
    }

    /**
     * 하나의 문단을 읽는다.
     *
     * @param paragraph 문단 객체
     * @param sr        스트림 리더
     * @throws Exception
     */
    public void read(Paragraph paragraph, StreamReader sr) throws Exception {
        if (sr.getCurrentRecordHeader().getTagID() != HWPTag.PARA_HEADER) {
            throw new Exception("This is not paragraph.");
        }

        this.sr = sr;
        this.paragraph = paragraph;
        this.paraHeaderLevel = sr.getCurrentRecordHeader().getLevel();
        paraHeaderBody();
        paraText();
        paraCharShape();
        paraLineSeg();
        paraRangeTag();

        long lastPosition = -1;
        while (sr.isEndOfStream() == false) {
            // 한 바퀴에 스트림이 한 바이트도 나아가지 않으면 다음 바퀴도 똑같다 —
            // 그 상태로 두면 조건이 영원히 성립해 스레드가 CPU 를 태운다.
            //
            // 실제로 일어난다: 레코드 내용을 예상보다 적게 읽어 위치가 어긋나면,
            // 어긋난 자리에서 크기 0 인 헤더로 읽힐 수 있다. 그러면
            // skipETCRecord() 가 0 바이트를 읽고, readAfterHeader 가 0 이라
            // isImmediatelyAfterReadingHeader() 가 계속 참이 되어 헤더조차 다시
            // 읽지 않는다 — 완전한 정지다(진행 없음, 종료 없음).
            //
            // 파서는 잘못된 입력에 **멈춰야지 돌면 안 된다**. 여기서 끊고 알린다.
            long position = sr.getCurrentPosition();
            if (position == lastPosition) {
                throw new IOException(String.format(
                        "문단을 읽는 중 진행이 멈췄습니다 — position=%d tagID=%d level=%d size=%d."
                                + " 앞선 레코드를 예상보다 적게 읽어 위치가 어긋났을 수 있습니다.",
                        position,
                        sr.getCurrentRecordHeader().getTagID(),
                        sr.getCurrentRecordHeader().getLevel(),
                        sr.getCurrentRecordHeader().getSize()));
            }
            lastPosition = position;

            if (sr.isImmediatelyAfterReadingHeader() == false) {
                sr.readRecordHeader();
            }
            if (isOutOfParagraph(sr)
                    || isFollowLastBatangPageInfo(sr)
                    || isFollowMemo(sr)) {
                break;
            }
            if (sr.getCurrentRecordHeader().getTagID() == HWPTag.CTRL_HEADER) {
                control();
            } else {
                skipETCRecord();
            }
        }
    }

    /**
     * 문단 헤더 레코드를 읽는다.
     *
     * @throws Exception
     */
    private void paraHeaderBody() throws Exception {
        ForParaHeader.read(paragraph.getHeader(), sr);
    }

    /**
     * 문단의 텍스트 레코드을 읽는다.
     *
     * @throws Exception
     */
    private void paraText() throws Exception {
        if (sr.isEndOfStream()) {
            return;
        }

        if (sr.isImmediatelyAfterReadingHeader() == false) {
            sr.readRecordHeader();
        }
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.PARA_TEXT) {
            ForParaText.read(paragraph, sr);
        }
    }

    /**
     * 문단의 문자 모양 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void paraCharShape() throws IOException {
        if (sr.isEndOfStream()) {
            return;
        }

        if (sr.isImmediatelyAfterReadingHeader() == false) {
            sr.readRecordHeader();
        }
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.PARA_CHAR_SHAPE) {
            ForParaCharShape.read(paragraph, sr);
        }
    }

    /**
     * 문단의 레이아웃 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void paraLineSeg() throws IOException {
        if (sr.isEndOfStream()) {
            return;
        }

        if (sr.isImmediatelyAfterReadingHeader() == false) {
            sr.readRecordHeader();
        }
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.PARA_LINE_SEG) {
            ForParaLineSeg.read(paragraph, sr);
        }
    }

    /**
     * 문단의 영역 태그 레코드를 읽는다.
     *
     * @throws Exception
     */
    private void paraRangeTag() throws Exception {
        if (sr.isEndOfStream()) {
            return;
        }

        if (sr.isImmediatelyAfterReadingHeader() == false) {
            sr.readRecordHeader();
        }
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.PARA_RANGE_TAG) {
            ForParaRangeTag.read(paragraph, sr);
        }
    }

    /**
     * 읽은 레코드 헤더가 문단 바깥쪽인지 여부를 반환한다.
     *
     * @param sr 스트림 리더
     * @return 읽은 레코드 헤더가 문단 바깥쪽인지 여부
     */
    private boolean isOutOfParagraph(StreamReader sr) {
        return this.paraHeaderLevel >= sr.getCurrentRecordHeader().getLevel();
    }

    /**
     * 마지막 바탕쪽 정보가 뒤에 붙어 있는지 여부를 반환한다.
     *
     * @param sr 스트림 리더
     * @return 마지막 바탕쪽 정보가 뒤에 붙어 있는지 여부
     */
    private boolean isFollowLastBatangPageInfo(StreamReader sr) {
        return this.paraHeaderLevel == 0
                && sr.getCurrentRecordHeader().getTagID() == HWPTag.LIST_HEADER
                && sr.getCurrentRecordHeader().getLevel() == 1;
    }


    private boolean isFollowMemo(StreamReader sr) {
        return this.paraHeaderLevel == 0
                && sr.getCurrentRecordHeader().getTagID() == HWPTag.MEMO_LIST
                && sr.getCurrentRecordHeader().getLevel() == 1;
    }

    /**
     * 문단에 포함된 컨트롤을 읽는다.
     *
     * @throws Exception
     */
    private void control() throws Exception {
        long id = sr.readUInt4();
        if (id == ControlType.Gso.getCtrlId()) {
           ForGsoControl fgc = new ForGsoControl();
            fgc.read(paragraph, sr);
        } else if (id == ControlType.Form.getCtrlId()) {
            ForFormControl ffc = new ForFormControl();
            ffc.read(paragraph, sr);
        } else {
            Control c = paragraph.addNewControl(id);
            ForControl.read(c, sr);
        }
    }

    /**
     * 기타 레코드를 스킵한다.
     *
     * @throws IOException
     */
    private void skipETCRecord() throws IOException {
        byte[] buffer = new byte[(int) sr.getCurrentRecordHeader().getSize()];
        sr.readBytes(buffer);
    }
}

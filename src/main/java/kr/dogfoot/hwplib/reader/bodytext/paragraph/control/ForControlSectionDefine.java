package kr.dogfoot.hwplib.reader.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlSectionDefine;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.bookmark.ForCtrlData;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.secd.*;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 구역 정의 컨트롤을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForControlSectionDefine {
    /**
     * 구역 정의 컨트롤
     */
    private ControlSectionDefine secd;
    /**
     * 스트림 리더
     */
    private StreamReader sr;

    /**
     * 컨트롤헤더의 레벨
     */
    private short ctrlHeaderLevel;
    /**
     * 미/각주모양 레코드 인덱스
     */
    private int endFootnoteShapeIndex;
    /**
     * 쪽 테두리/배경 레코드 인덱스
     */
    private int pageBorderFillIndex;

    /**
     * 생성자
     */
    public ForControlSectionDefine() {
        endFootnoteShapeIndex = 0;
        pageBorderFillIndex = 0;
    }

    /**
     * 구역 정의 컨트롤을 읽는다.
     *
     * @param secd 구역 정의 컨트롤 객체
     * @param sr   스트림 리더
     * @throws Exception
     */
    public void read(ControlSectionDefine secd, StreamReader sr)
            throws Exception {
        this.secd = secd;
        this.sr = sr;
        this.ctrlHeaderLevel = sr.getCurrentRecordHeader().getLevel();

        ctrlHeader();

        while (sr.isEndOfStream() == false) {
            if (sr.isImmediatelyAfterReadingHeader() == false) {
                sr.readRecordHeder();
            }

            if (ctrlHeaderLevel >= sr.getCurrentRecordHeader().getLevel()) {
                break;
            }
            readBody();
        }
    }

    /**
     * 구역 정의 컨트롤의 컨트롤 헤더 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void ctrlHeader() throws IOException {
        ForCtrlHeaderSecd.read(secd.getHeader(), sr);
    }

    /**
     * 이미 읽은 레코드 헤더에 따른 레코드 내용을 읽는다.
     *
     * @throws Exception
     */
    private void readBody() throws Exception {
        switch (sr.getCurrentRecordHeader().getTagID()) {
            case HWPTag.PAGE_DEF:
                pageDef();
                break;
            case HWPTag.FOOTNOTE_SHAPE:
                endFootnoteShapes();
                break;
            case HWPTag.PAGE_BORDER_FILL:
                pageBorderFills();
                break;
            case HWPTag.LIST_HEADER:
                batangPageInfo();
                break;
            case HWPTag.CTRL_DATA:
                ctrlData();
                break;
        }
    }

    /**
     * 용지 설정 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void pageDef() throws IOException {
        ForPageDef.read(secd.getPageDef(), sr);
    }

    /**
     * 각주/미주 모양 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void endFootnoteShapes() throws IOException {
        if (endFootnoteShapeIndex == 0) {
            footNoteShape();
        } else if (endFootnoteShapeIndex == 1) {
            endNoteShape();
        }
        endFootnoteShapeIndex++;
    }

    /**
     * 각주 모양 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void footNoteShape() throws IOException {
        ForFootEndNoteShape.read(secd.getFootNoteShape(), sr);
    }

    /**
     * 미주 모양 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void endNoteShape() throws IOException {
        ForFootEndNoteShape.read(secd.getEndNoteShape(), sr);
    }

    /**
     * 쪽 테두리/배경 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void pageBorderFills() throws IOException {
        if (pageBorderFillIndex == 0) {
            bothPageBorderFill();
        } else if (pageBorderFillIndex == 1) {
            evenPageBorderFill();
        } else if (pageBorderFillIndex == 2) {
            oddPageBorderFill();
        }

        pageBorderFillIndex++;
    }

    /**
     * 양쪽 페이지를 위한 쪽 테두리/배경 레코드를 읽느다.
     *
     * @throws IOException
     */
    private void bothPageBorderFill() throws IOException {
        ForPageBorderFill.read(secd.getBothPageBorderFill(), sr);
    }

    /**
     * 짝수쪽 페이지를 위한 쪽 테두리/배경 레코드를 읽느다.
     *
     * @throws IOException
     */
    private void evenPageBorderFill() throws IOException {
        ForPageBorderFill.read(secd.getEvenPageBorderFill(), sr);
    }

    /**
     * 홀수쪽 페이지를 위한 쪽 테두리/배경 레코드를 읽느다.
     *
     * @throws IOException
     */
    private void oddPageBorderFill() throws IOException {
        ForPageBorderFill.read(secd.getOddPageBorderFill(), sr);
    }

    /**
     * 바탕쪽 정보를 읽는다.
     *
     * @throws Exception
     */
    private void batangPageInfo() throws Exception {
        ForBatangPageInfo.read(secd.addNewBatangPageInfo(), sr);
    }

    /**
     * 컨트롤 데이터를 읽는다.
     *
     * @throws IOException
     */
    private void ctrlData() throws IOException {
        secd.createCtrlData();
        ForCtrlData.read(secd.getCtrlData(), sr);
    }
}

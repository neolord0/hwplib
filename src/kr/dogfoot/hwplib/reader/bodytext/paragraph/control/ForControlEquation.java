package kr.dogfoot.hwplib.reader.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlEquation;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.eqed.ForEQEdit;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForCaption;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForCtrlHeaderGso;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 수식 컨트롤을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForControlEquation {
    /**
     * 수식 컨트롤
     */
    private ControlEquation eqed;
    /**
     * 스트림 리더
     */
    private StreamReader sr;
    /**
     * 컨트롤 헤더 레코드의 레벨
     */
    private int ctrlHeaderLevel;

    /**
     * 생성자
     */
    public ForControlEquation() {
    }

    /**
     * 수식 컨트롤을 읽는다.
     *
     * @param eqed 수식 컨트롤
     * @param sr   스트림 리더
     * @throws Exception
     */
    public void read(ControlEquation eqed, StreamReader sr) throws Exception {
        this.eqed = eqed;
        this.sr = sr;
        this.ctrlHeaderLevel = sr.getCurrentRecordHeader().getLevel();

        ctrlHeader();
        caption();

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
     * 수식 컨트롤의 컨트롤 헤더 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void ctrlHeader() throws IOException {
        ForCtrlHeaderGso.read(eqed.getHeader(), sr);
    }

    /**
     * 캡션 정보를 읽는다.
     *
     * @throws Exception
     */
    private void caption() throws Exception {
        sr.readRecordHeder();
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.LIST_HEADER) {
            eqed.createCaption();
            ForCaption.read(eqed.getCaption(), sr);
        }
    }

    /**
     * 이미 읽은 레코드 헤더에 따른 레코드 내용을 읽는다.
     *
     * @throws IOException
     */
    private void readBody() throws IOException {
        switch (sr.getCurrentRecordHeader().getTagID()) {
            case HWPTag.EQEDIT:
                eqEdit();
                break;
        }
    }

    /**
     * 수식 정보 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void eqEdit() throws IOException {
        ForEQEdit.read(eqed.getEQEdit(), sr);
    }
}

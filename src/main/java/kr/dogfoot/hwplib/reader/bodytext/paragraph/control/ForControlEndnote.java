package kr.dogfoot.hwplib.reader.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.bodytext.control.ControlEndnote;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderEndnote;
import kr.dogfoot.hwplib.object.bodytext.control.footnoteendnote.ListHeaderForFootnodeEndnote;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.NumberShape;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.bodytext.ForParagraphList;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 미주 컨트롤을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForControlEndnote {
    /**
     * 미주 컨트롤
     */
    private ControlEndnote en;
    /**
     * 스트림 리더
     */
    private StreamReader sr;

    /**
     * 생성자
     */
    public ForControlEndnote() {
    }

    /**
     * 미주 컨트롤을 읽는다.
     *
     * @param en 미주 컨트롤
     * @param sr 스트림 리더
     * @throws Exception
     */
    public void read(ControlEndnote en, StreamReader sr) throws Exception {
        this.en = en;
        this.sr = sr;

        ctrlHeader();
        listHeader();
        paragraphList();
    }

    /**
     * 미주 컨트롤의 컨트롤 헤더 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void ctrlHeader() throws IOException {
        CtrlHeaderEndnote h = en.getHeader();
        h.setNumber(sr.readUInt4());
        h.setBeforeDecorationLetter(sr.readWChar());
        h.setAfterDecorationLetter(sr.readWChar());
        h.setNumberShape(NumberShape.valueOf((short) sr.readUInt4()));

        if (sr.isEndOfRecord() == false) {
            h.setInstanceId(sr.readUInt4());
        }
    }

    /**
     * 미주 컨트롤의 문단 리스트 헤더 레코드를 읽는다.
     *
     * @throws Exception
     */
    private void listHeader() throws Exception {
        RecordHeader rh = sr.readRecordHeder();
        if (rh.getTagID() == HWPTag.LIST_HEADER) {
            ListHeaderForFootnodeEndnote lh = en.getListHeader();
            lh.setParaCount(sr.readSInt4());
            lh.getProperty().setValue(sr.readUInt4());
            sr.skipToEndRecord();
        } else {
            throw new Exception("List header must be located.");
        }
    }

    /**
     * 문단 리스트를 읽는다.
     *
     * @throws Exception
     */
    private void paragraphList() throws Exception {
        ForParagraphList.read(en.getParagraphList(), sr);
    }
}

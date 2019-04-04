package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlEndnote;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderEndnote;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.ForParagraphList;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.endnote.ForListHeaderForFootnodeEndnote;

import java.io.IOException;

/**
 * 미주 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlEndnote {
    /**
     * 미주 컨트롤을 쓴다.
     *
     * @param en 미주 컨트롤
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(ControlEndnote en, StreamWriter sw)
            throws Exception {
        ctrlHeader(en.getHeader(), sw);

        sw.upRecordLevel();

        ForListHeaderForFootnodeEndnote.write(en.getListHeader(), sw);
        ForParagraphList.write(en.getParagraphList(), sw);

        sw.downRecordLevel();
    }

    /**
     * 미주 컨트롤의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h  미주 컨트롤의 컨트롤 헤더 레코드
     * @param sw 스트림 헤더
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderEndnote h, StreamWriter sw)
            throws IOException {
        recordHeader(h, sw);
        sw.writeUInt4(h.getCtrlId());

        sw.writeUInt4(h.getNumber());
        sw.writeWChar(h.getBeforeDecorationLetter());
        sw.writeWChar(h.getAfterDecorationLetter());
        sw.writeUInt4(h.getNumberShape().getValue());
        sw.writeUInt4(h.getInstanceId());
    }

    /**
     * 컨트롤 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param h  컨트롤 헤더 레코드
     * @param sw 스트림 헤더
     * @throws IOException
     */
    private static void recordHeader(CtrlHeaderEndnote h, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.CTRL_HEADER, 20);
    }
}

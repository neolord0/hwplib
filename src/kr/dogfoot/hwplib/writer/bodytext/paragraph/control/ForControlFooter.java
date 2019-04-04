package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlFooter;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderFooter;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.ForParagraphList;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.headerfooter.ForListHeaderForHeaderFooter;

import java.io.IOException;

/**
 * 꼬리말 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlFooter {
    /**
     * 꼬리말 컨트롤을 쓴다.
     *
     * @param f  꼬리말 컨트롤
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(ControlFooter f, StreamWriter sw) throws Exception {
        ctrlHeader(f.getHeader(), sw);

        sw.upRecordLevel();

        ForListHeaderForHeaderFooter.write(f.getListHeader(), sw);
        ForParagraphList.write(f.getParagraphList(), sw);

        sw.downRecordLevel();
    }

    /**
     * 꼬리말 컨트롤의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h
     * @param sw
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderFooter h, StreamWriter sw)
            throws IOException {
        recordHeader(h, sw);
        sw.writeUInt4(h.getCtrlId());

        sw.writeUInt4(h.getApplyPage().getValue());
        sw.writeSInt4(h.getCreateIndex());
    }

    /**
     * 컨트롤 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param h  컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(CtrlHeaderFooter h, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.CTRL_HEADER, 12);
    }
}

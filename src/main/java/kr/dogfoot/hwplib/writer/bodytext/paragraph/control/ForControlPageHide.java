package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlPageHide;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderPageHide;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 감추기 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlPageHide {
    /**
     * 감추기 컨트롤을 쓴다.
     *
     * @param ph 감추기 컨트롤
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ControlPageHide ph, StreamWriter sw)
            throws IOException {
        ctrlHeader(ph.getHeader(), sw);
    }

    /**
     * 감추기 컨트롤의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h  감추기 컨트롤의 컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderPageHide h, StreamWriter sw)
            throws IOException {
        recordHeader(sw);
        sw.writeUInt4(h.getCtrlId());

        sw.writeUInt4(h.getProperty().getValue());
    }

    /**
     * 컨트롤 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.CTRL_HEADER, 8);
    }
}

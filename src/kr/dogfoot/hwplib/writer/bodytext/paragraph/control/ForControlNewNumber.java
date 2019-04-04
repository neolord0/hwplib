package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlNewNumber;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderNewNumber;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 새 번호 지정 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlNewNumber {
    /**
     * 새 번호 지정 컨트롤을 쓴다.
     *
     * @param nn 새 번호 지정 컨트롤
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ControlNewNumber nn, StreamWriter sw)
            throws IOException {
        ctrlHeader(nn.getHeader(), sw);
    }

    /**
     * 새 번호 지정 컨트롤의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h  새 번호 지정 컨트롤의 컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderNewNumber h, StreamWriter sw)
            throws IOException {
        recordHeader(sw);
        sw.writeUInt4(h.getCtrlId());

        sw.writeUInt4(h.getProperty().getValue());
        sw.writeUInt2(h.getNumber());
    }

    /**
     * 컨트롤 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.CTRL_HEADER, 10);
    }
}

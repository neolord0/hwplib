package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlPageOddEvenAdjust;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderPageOddEvenAdjust;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 홀/짝수 조정(페이지 번호 제어) 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlPageOddEvenAdjust {
    /**
     * 홀/짝수 조정(페이지 번호 제어) 컨트롤을 쓴다.
     *
     * @param pgoea  홀/짝수 조정(페이지 번호 제어) 컨트롤
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ControlPageOddEvenAdjust pgoea, StreamWriter sw) throws IOException {
        ctrlHeader(pgoea.getHeader(), sw);
    }

    /**
     * 홀/짝수 조정(페이지 번호 제어) 컨트롤의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h 홀/짝수 조정(페이지 번호 제어) 컨트롤의 컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderPageOddEvenAdjust h, StreamWriter sw) throws IOException {
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

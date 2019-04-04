package kr.dogfoot.hwplib.reader.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlAutoNumber;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderAutoNumber;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 자동 번호 컨트롤을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForControlAutoNumber {
    /**
     * 자동 번호 컨트롤을 읽는다.
     *
     * @param an 자동번호 컨트롤
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(ControlAutoNumber an, StreamReader sr)
            throws IOException {
        ctrlHeader(an.getHeader(), sr);
    }

    /**
     * 자동 번호 컨트롤의 컨트롤 헤더 레코드를 읽는다.
     *
     * @param h  자동 번호 컨트롤의 컨트롤 헤더 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderAutoNumber h, StreamReader sr)
            throws IOException {
        h.getProperty().setValue(sr.readUInt4());
        h.setNumber(sr.readUInt2());
        h.setUserSymbol(sr.readWChar());
        h.setBeforeDecorationLetter(sr.readWChar());
        h.setAfterDecorationLetter(sr.readWChar());
    }
}

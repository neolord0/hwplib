package kr.dogfoot.hwplib.reader;

import kr.dogfoot.hwplib.object.etc.UnknownRecord;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 알수 없는 레코드를 읽기 위한 객체
 *
 * @author 박성균
 */
public class ForUnknown {
    /**
     * 알수 없는 레코드를 읽는다.
     *
     * @param unknown 알 수 없는 레코드
     * @param sr      스트림 리더
     * @throws IOException
     */
    public static void read(UnknownRecord unknown, StreamReader sr)
            throws IOException {
        byte[] body = new byte[(int) unknown.getHeader().getSize()];
        sr.readBytes(body);
        unknown.setBody(body);
    }
}

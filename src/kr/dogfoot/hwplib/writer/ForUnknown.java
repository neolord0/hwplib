package kr.dogfoot.hwplib.writer;

import kr.dogfoot.hwplib.object.etc.UnknownRecord;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 알수 없는 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForUnknown {
    /**
     * 알수 없는 레코드를 쓴다.
     *
     * @param ur    알수 없는 레코드
     * @param tagID 테그 아이디
     * @param sw    스트림 라이터
     * @throws IOException
     */
    public static void write(UnknownRecord ur, int tagID, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(tagID, ur.getBody().length);
        sw.writeBytes(ur.getBody());
    }
}

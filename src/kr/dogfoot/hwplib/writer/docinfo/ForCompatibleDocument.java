package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.CompatibleDocument;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 호환 문서 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForCompatibleDocument {
    /**
     * 호환 문서 레코드를 쓴다.
     *
     * @param cd 호환 문서 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(CompatibleDocument cd, StreamWriter sw)
            throws IOException {
        recordHeader(sw);

        sw.writeUInt4(cd.getTargetProgream().getValue());
    }

    /**
     * 호환 문서 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.COMPATIBLE_DOCUMENT, 4);
    }
}

package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.LayoutCompatibility;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 레이아웃 호환 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForLayoutCompatibility {
    /**
     * 레이아웃 호환 레코드를 쓴다.
     *
     * @param lc 레이아웃 호환 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(LayoutCompatibility lc, StreamWriter sw)
            throws IOException {
        recordHeader(sw);

        sw.writeUInt4(lc.getLetterLevelFormat());
        sw.writeUInt4(lc.getParagraphLevelFormat());
        sw.writeUInt4(lc.getSectionLevelFormat());
        sw.writeUInt4(lc.getObjectLevelFormat());
        sw.writeUInt4(lc.getFieldLevelFormat());
    }

    /**
     * 레이아웃 호환 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이더
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.LAYOUT_COMPATIBILITY, 20);
    }
}

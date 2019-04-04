package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.headerfooter;

import kr.dogfoot.hwplib.object.bodytext.control.headerfooter.ListHeaderForHeaderFooter;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 머리말/꼬리말 컨트롤의 리스트 헤더 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForListHeaderForHeaderFooter {
    /**
     * 머리말/꼬리말 컨트롤의 리스트 헤더 레코드를 쓴다.
     *
     * @param lh 머리말/꼬리말 컨트롤의 리스트 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ListHeaderForHeaderFooter lh, StreamWriter sw)
            throws IOException {
        recordHeader(sw);

        sw.writeSInt4(lh.getParaCount());
        sw.writeUInt4(lh.getProperty().getValue());
        sw.writeUInt4(lh.getTextWidth());
        sw.writeUInt4(lh.getTextHeight());
        sw.writeZero(18);
    }

    /**
     * 머리말/꼬리말 컨트롤의 리스트 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.LIST_HEADER, 34);
    }
}

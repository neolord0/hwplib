package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.Style;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 스타일 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForStyle {
    /**
     * 스타일 레코드를 쓴다.
     *
     * @param s  스타일 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(Style s, StreamWriter sw) throws IOException {
        recordHeader(s, sw);

        sw.writeUTF16LEString(s.getHangulName());
        sw.writeUTF16LEString(s.getEnglishName());
        sw.writeUInt1(s.getProeprty().getValue());
        sw.writeUInt1(s.getNextStyleId());
        sw.writeUInt2(s.getLanguageId());
        sw.writeUInt2(s.getParaShapeId());
        sw.writeUInt2(s.getCharShapeId());
        sw.writeZero(2);
    }

    /**
     * 스타일 레코드의 레코드 헤더를 쓴다.
     *
     * @param s  스타일 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(Style s, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.STYLE, getSize(s));
    }

    /**
     * 스타일 레코드의 크기를 반환한다.
     *
     * @param s 스타일 레코드
     * @return 스타일 레코드의 크기
     */
    private static int getSize(Style s) {
        int size = 0;
        size += StringUtil.getUTF16LEStringSize(s.getHangulName());
        size += StringUtil.getUTF16LEStringSize(s.getEnglishName());
        size += 8 + 2;
        return size;
    }
}

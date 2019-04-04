package kr.dogfoot.hwplib.reader.docinfo;

import kr.dogfoot.hwplib.object.docinfo.Style;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 스타일 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForStyle {
    /**
     * 스타일 레코드를 읽는다.
     *
     * @param s  스타일 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(Style s, StreamReader sr) throws IOException {
        s.setHangulName(sr.readUTF16LEString());
        s.setEnglishName(sr.readUTF16LEString());
        s.getProeprty().setValue(sr.readUInt1());
        s.setNextStyleId(sr.readUInt1());
        s.setLanguageId(sr.readSInt2());
        s.setParaShapeId(sr.readUInt2());
        s.setCharShapeId(sr.readUInt2());
        unknown2Bytes(sr);
    }

    /**
     * 알려지지 않은 2 바이트를 처리한다.
     *
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void unknown2Bytes(StreamReader sr) throws IOException {
        sr.skip(2);
    }
}

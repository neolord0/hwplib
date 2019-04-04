package kr.dogfoot.hwplib.reader.docinfo;

import kr.dogfoot.hwplib.object.docinfo.FaceName;
import kr.dogfoot.hwplib.object.docinfo.facename.FontType;
import kr.dogfoot.hwplib.object.docinfo.facename.FontTypeInfo;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 글꼴 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForFaceName {
    /**
     * 글꼴 레코드를 읽는다.
     *
     * @param fn 글꼴 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(FaceName fn, StreamReader sr) throws IOException {
        fn.getProperty().setValue(sr.readUInt1());
        fn.setName(sr.readUTF16LEString());

        if (fn.getProperty().hasSubstituteFont()) {
            substituteFontInfo(fn, sr);
        }

        if (fn.getProperty().hasFontInfo()) {
            fontTypeInfo(fn.getFontTypeInfo(), sr);
        }

        if (fn.getProperty().hasBaseFont()) {
            fn.setBaseFontName(sr.readUTF16LEString());
        }
    }

    /**
     * 대체 글꼴 정보 부분을 읽는다.
     *
     * @param fn 대체 글꼴 정보 부분을 나타내는 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void substituteFontInfo(FaceName fn, StreamReader sr)
            throws IOException {
        FontType substituteFontType = FontType.valueOf((byte) sr.readUInt1());
        fn.setSubstituteFontType(substituteFontType);
        fn.setSubstituteFontName(sr.readUTF16LEString());
    }

    /**
     * 글꼴 유형 정보 부분을 읽는다.
     *
     * @param fti 글꼴 유형 정보 부분을 나타내는 객체
     * @param sr  스트림 리더
     * @throws IOException
     */
    private static void fontTypeInfo(FontTypeInfo fti, StreamReader sr)
            throws IOException {
        fti.setFontType(sr.readUInt1());
        fti.setSerifType(sr.readUInt1());
        fti.setThickness(sr.readUInt1());
        fti.setRatio(sr.readUInt1());
        fti.setContrast(sr.readUInt1());
        fti.setStrokeDeviation(sr.readUInt1());
        fti.setCharacterStrokeType(sr.readUInt1());
        fti.setCharacterShape(sr.readUInt1());
        fti.setMiddleLine(sr.readUInt1());
        fti.setxHeight(sr.readUInt1());
    }
}

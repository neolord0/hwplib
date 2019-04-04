package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.FaceName;
import kr.dogfoot.hwplib.object.docinfo.facename.FontTypeInfo;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 글꼴 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForFaceName {
    /**
     * 글꼴 레코드를 쓴다.
     *
     * @param fn 글꼴 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(FaceName fn, StreamWriter sw) throws IOException {
        recordHeader(fn, sw);

        sw.writeUInt1(fn.getProperty().getValue());
        sw.writeUTF16LEString(fn.getName());
        if (fn.getProperty().hasSubstituteFont()) {
            sw.writeUInt1(fn.getSubstituteFontType().getValue());
            sw.writeUTF16LEString(fn.getSubstituteFontName());
        }
        if (fn.getProperty().hasFontInfo()) {
            fontTypeInfo(fn.getFontTypeInfo(), sw);
        }
        if (fn.getProperty().hasBaseFont()) {
            sw.writeUTF16LEString(fn.getBaseFontName());
        }

    }

    /**
     * 글꼴 레코드의 레코드 헤더를 쓴다.
     *
     * @param fn 글꼴 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(FaceName fn, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.FACE_NAME, getSize(fn));
    }

    /**
     * 글꼴 레코드의 크기를 반환한다.
     *
     * @param fn 글꼴 레코드
     * @return 글꼴 레코드의 크기
     */
    private static int getSize(FaceName fn) {
        int size = 0;
        size += 1;

        size += StringUtil.getUTF16LEStringSize(fn.getName());
        if (fn.getProperty().hasSubstituteFont()) {
            size += 1;
            size += StringUtil.getUTF16LEStringSize(fn.getSubstituteFontName());
        }

        if (fn.getProperty().hasFontInfo()) {
            size += 10;
        }

        if (fn.getProperty().hasBaseFont()) {
            size += StringUtil.getUTF16LEStringSize(fn.getBaseFontName());
        }
        return size;
    }

    /**
     * 글꼴 유형 정보를 쓴다.
     *
     * @param fti 글꼴 유형 정보
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void fontTypeInfo(FontTypeInfo fti, StreamWriter sw)
            throws IOException {
        sw.writeUInt1(fti.getFontType());
        sw.writeUInt1(fti.getSerifType());
        sw.writeUInt1(fti.getThickness());
        sw.writeUInt1(fti.getRatio());
        sw.writeUInt1(fti.getContrast());
        sw.writeUInt1(fti.getStrokeDeviation());
        sw.writeUInt1(fti.getCharacterStrokeType());
        sw.writeUInt1(fti.getCharacterShape());
        sw.writeUInt1(fti.getMiddleLine());
        sw.writeUInt1(fti.getxHeight());
    }
}

package kr.dogfoot.hwplib.writer.docinfo.borderfill;

import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.*;
import kr.dogfoot.hwplib.object.etc.Color4Byte;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 테두리/배경 레코드의 채우기 정보를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForFillInfo {
    /**
     * 테두리/배경 레코드의 채우기 정보를 쓴다.
     *
     * @param fi 테두리/배경 레코드의 채우기 정보
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(FillInfo fi, StreamWriter sw) throws IOException {
        sw.writeUInt4(fi.getType().getValue());
        if (fi.getType().getValue() != 0) {
            if (fi.getType().hasPatternFill()) {
                writePatternFill(fi.getPatternFill(), sw);
            }
            if (fi.getType().hasGradientFill()) {
                writeGradientFill(fi.getGradientFill(), sw);
            }
            if (fi.getType().hasImageFill()) {
                writeImageFill(fi.getImageFill(), sw);
            }
            additionalProperty(fi, sw);
            unknownBytes(fi, sw);
        } else {
            sw.writeZero(4);
        }
    }

    /**
     * 패턴 채움 정보를 쓴다.
     *
     * @param pf 패턴 채움 정보
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void writePatternFill(PatternFill pf, StreamWriter sw)
            throws IOException {
        sw.writeUInt4(pf.getBackColor().getValue());
        sw.writeUInt4(pf.getPatternColor().getValue());
        sw.writeUInt4(pf.getPatternType().getValue());
    }

    /**
     * 그라데이션 채움 정보를 쓴다.
     *
     * @param gf 그라데이션 채움 정보
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void writeGradientFill(GradientFill gf, StreamWriter sw)
            throws IOException {
        sw.writeSInt1(gf.getGradientType().getValue());
        sw.writeUInt4(gf.getStartAngle());
        sw.writeUInt4(gf.getCenterX());
        sw.writeUInt4(gf.getCenterY());
        sw.writeUInt4(gf.getBlurringDegree());

        long colorCount = gf.getColorList().size();
        sw.writeUInt4(colorCount);
        if (colorCount > 2) {
            for (int cp : gf.getChangePointList()) {
                sw.writeSInt4(cp);
            }
        }
        for (Color4Byte c : gf.getColorList()) {
            sw.writeUInt4(c.getValue());
        }
    }

    /**
     * 이미지 채움 정보을 쓴다.
     *
     * @param imf 이미지 채움 정보
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void writeImageFill(ImageFill imf, StreamWriter sw)
            throws IOException {
        sw.writeUInt1(imf.getImageFillType().getValue());
        pictureInfo(imf.getPictureInfo(), sw);
    }

    /**
     * 그림 정보을 쓴다.
     *
     * @param pi 그림 정보
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void pictureInfo(PictureInfo pi, StreamWriter sw)
            throws IOException {
        sw.writeSInt1(pi.getBrightness());
        sw.writeSInt1(pi.getContrast());
        sw.writeUInt1(pi.getEffect().getValue());
        sw.writeUInt2(pi.getBinItemID());
    }

    /**
     * 추가적인 속성을 쓴다.
     *
     * @param fi 테두리/배경 레코드의 채우기 정보
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void additionalProperty(FillInfo fi, StreamWriter sw)
            throws IOException {
        if (fi.getType().hasGradientFill() == true) {
            sw.writeUInt4(1);
            sw.writeUInt1(fi.getGradientFill().getBlurringCenter());
        } else {
            sw.writeUInt4(0);
        }
    }

    /**
     * 알려지지 않은 바이트를 쓴다.
     *
     * @param fi 테두리/배경 레코드의 채우기 정보
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void unknownBytes(FillInfo fi, StreamWriter sw)
            throws IOException {
        if (fi.getType().hasPatternFill()) {
            sw.writeZero(1);
        }
        if (fi.getType().hasGradientFill()) {
            sw.writeZero(1);
        }
        if (fi.getType().hasImageFill()) {
            sw.writeZero(1);
        }
    }

    /**
     * 테두리/배경 레코드의 채우기 정보의 크기를 반환한다.
     *
     * @param fi 테두리/배경 레코드의 채우기 정보
     * @return 테두리/배경 레코드의 채우기 정보의 크기
     */
    public static int getSize(FillInfo fi) {
        int size = 0;
        size += 4;
        if (fi.getType().getValue() != 0) {
            if (fi.getType().hasPatternFill()) {
                size += 12;
            }
            if (fi.getType().hasGradientFill()) {
                size += 17;

                size += 4;
                long colorCount = fi.getGradientFill().getColorList().size();
                if (colorCount > 2) {
                    size += colorCount * 4;
                }
                size += colorCount * 4;
            }
            if (fi.getType().hasImageFill()) {
                size += 6;
            }

            // additionalProperty
            if (fi.getType().hasGradientFill() == true) {
                size += 4;
                size += 1;
            } else {
                size += 4;
            }

            // unknownBytes
            if (fi.getType().hasPatternFill()) {
                size += 1;
            }
            if (fi.getType().hasGradientFill()) {
                size += 1;
            }
            if (fi.getType().hasImageFill()) {
                size += 1;
            }
        } else {
            size += 4;
        }
        return size;
    }
}

package kr.dogfoot.hwplib.reader.docinfo.borderfill;

import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.*;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 테두리/배경 레코드의 채우기 정보를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForFillInfo {
    /**
     * 테두리/배경 레코드의 채우기 정보를 읽는다.
     *
     * @param fi 테두리/배경 레코드의 채우기 정보
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(FillInfo fi, StreamReader sr) throws IOException {
        fi.getType().setValue(sr.readUInt4());
        if (fi.getType().getValue() != 0) {
            if (fi.getType().hasPatternFill()) {
                fi.createPatternFill();
                patternFill(fi.getPatternFill(), sr);
            }

            if (fi.getType().hasGradientFill()) {
                fi.createGradientFill();
                gradientFill(fi.getGradientFill(), sr);
            }

            if (fi.getType().hasImageFill()) {
                fi.createImageFill();
                imageFill(fi.getImageFill(), sr);
            }
            additionalProperty(fi, sr);
            if (sr.isEndOfRecord() == false) {
                unknownBytes(fi, sr);
            }
        } else {
            sr.skip(4);
        }
    }

    /**
     * 패턴 채움 정보를 읽는다.
     *
     * @param pf 패턴 채움 정보
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void patternFill(PatternFill pf, StreamReader sr)
            throws IOException {
        pf.getBackColor().setValue(sr.readUInt4());
        pf.getPatternColor().setValue(sr.readUInt4());
        pf.setPatternType(PatternType.valueOf((byte) sr.readSInt4()));
    }

    /**
     * 그라데이션 채움 정보를 읽는다.
     *
     * @param gf 그라데이션 정보
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void gradientFill(GradientFill gf, StreamReader sr)
            throws IOException {
        gf.setGradientType(GradientType.valueOf(sr.readSInt1())); // 문서오류 2byte
        // -> 1 byte
        gf.setStartAngle(sr.readUInt4()); // 문서오류 2byte -> 4 byte
        gf.setCenterX(sr.readUInt4()); // 문서오류 2byte -> 4 byte
        gf.setCenterY(sr.readUInt4()); // 문서오류 2byte -> 4 byte
        gf.setBlurringDegree(sr.readUInt4()); // 문서오류 2byte -> 4 byte

        long colorCount = sr.readUInt4(); // 문서오류 2byte -> 4 byte
        if (colorCount > 2) {
            for (int index = 0; index < colorCount; index++) {
                gf.addChangePoint(sr.readSInt4());
            }
        }
        for (int index = 0; index < colorCount; index++) {
            gf.addNewColor().setValue(sr.readUInt4());
        }
    }

    /**
     * 이미지 채움 정보을 읽는다.
     *
     * @param imf 이미지 채움 정보
     * @param sr  스트림 러더
     * @throws IOException
     */
    private static void imageFill(ImageFill imf, StreamReader sr)
            throws IOException {
        imf.setImageFillType(ImageFillType.valueOf((byte) sr.readUInt1()));
        pictureInfo(imf.getPictureInfo(), sr);
    }

    /**
     * 그림 정보을 읽는다.
     *
     * @param pi 그림 정보
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void pictureInfo(PictureInfo pi, StreamReader sr)
            throws IOException {
        pi.setBrightness(sr.readSInt1());
        pi.setContrast(sr.readSInt1());
        pi.setEffect(PictureEffect.valueOf((byte) sr.readUInt1()));
        pi.setBinItemID(sr.readUInt2());
    }

    /**
     * 추가적인 속성을 읽는다.
     *
     * @param fi 채우기 정보
     * @param sr 스트림 러더
     * @throws IOException
     */
    private static void additionalProperty(FillInfo fi, StreamReader sr)
            throws IOException {
        long size = sr.readUInt4();
        if (size == 1) {
            if (fi.getType().hasGradientFill()) {
                fi.getGradientFill().setBlurringCenter(sr.readUInt1());
            }
        } else {
            sr.skip(size);
        }
    }

    /**
     * 알려지지 않은 바이트를 읽는다.
     *
     * @param fi 채우기 정보
     * @param sr 스트림 러더
     * @throws IOException
     */
    private static void unknownBytes(FillInfo fi, StreamReader sr)
            throws IOException {
        if (fi.getType().hasPatternFill()) {
            sr.skip(1);
        }
        if (fi.getType().hasGradientFill()) {
            sr.skip(1);
        }
        if (fi.getType().hasImageFill()) {
            sr.skip(1);
        }
    }
}

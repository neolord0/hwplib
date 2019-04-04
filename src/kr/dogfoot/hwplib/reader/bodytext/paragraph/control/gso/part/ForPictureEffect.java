package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture.*;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 그림 개체 속성 레코드의 그림 효과 부분을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForPictureEffect {
    /**
     * 그림 개체 속성 레코드의 그림 효과 부분을 읽는다.
     *
     * @param pe 그림 개체 속성 레코드의 그림 효과를 나타내는 객체
     * @param sr 스트림 리더
     * @throws Exception
     */
    public static void read(PictureEffect pe, StreamReader sr) throws Exception {
        pe.getProperty().setValue(sr.readUInt4());
        if (pe.getProperty().hasShadowEffect()) {
            pe.createShadowEffect();
            shadowEffect(pe.getShadowEffect(), sr);
        }
        if (pe.getProperty().hasNeonEffect()) {
            pe.createNeonEffect();
            neonEffect(pe.getNeonEffect(), sr);
        }
        if (pe.getProperty().hasSoftBorderEffect()) {
            pe.createSoftEdgeEffect();
            softEdgeEffect(pe.getSoftEdgeEffect(), sr);
        }
        if (pe.getProperty().hasReflectionEffect()) {
            pe.createReflectionEffect();
            reflectionEffect(pe.getReflectionEffect(), sr);
        }
    }

    /**
     * 그림자 효과 부분을 읽는다.
     *
     * @param se 그림자 효과 부분을 나타내는 객체
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void shadowEffect(ShadowEffect se, StreamReader sr)
            throws Exception {
        se.setStyle(sr.readSInt4());
        se.setTransparency(sr.readFloat());
        se.setCloudy(sr.readFloat());
        se.setDirection(sr.readFloat());
        se.setDistance(sr.readFloat());
        se.setSort(sr.readSInt4());
        se.setTiltAngleX(sr.readFloat());
        se.setTiltAngleY(sr.readFloat());
        se.setZoomRateX(sr.readFloat());
        se.setZoomRateY(sr.readFloat());
        se.setRotateWithShape(sr.readSInt4());

        colorPropery(se.getColor(), sr);
    }

    /**
     * 색상 속성 부분을 읽는다.
     *
     * @param cp 색상 속성을 나타내는  객체
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void colorPropery(ColorWithEffect cp, StreamReader sr)
            throws Exception {
        cp.setType(sr.readSInt4());
        if (cp.getType() == 0) {
            byte[] color = new byte[4];
            sr.readBytes(color);
            cp.setColor(color);
        } else {
            throw new Exception("not supported color type !!!");
        }
        int colorEffectCount = (int) sr.readUInt4();
        for (int index = 0; index < colorEffectCount; index++) {
            ColorEffect ce = cp.addNewColorEffect();
            ce.setSort(sr.readSInt4());
            ce.setValue(sr.readFloat());
        }
    }

    /**
     * 네온 효과 부분을 읽는다.
     *
     * @param ne 네온 효과을 나타내는 객체
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void neonEffect(NeonEffect ne, StreamReader sr)
            throws Exception {
        ne.setTransparency(sr.readFloat());
        ne.setRadius(sr.readFloat());
        colorPropery(ne.getColor(), sr);
    }

    /**
     * 부드러운 가장자리 효과 부분을 읽는다.
     *
     * @param see 부드러운 가장자리 효과을 나타내는 객체
     * @param sr  스트림 리더
     * @throws IOException
     */
    private static void softEdgeEffect(SoftEdgeEffect see, StreamReader sr)
            throws IOException {
        see.setRadius(sr.readFloat());
    }

    /**
     * 반사 효과 부분을 읽는다.
     *
     * @param re 반사 효과을 나타내는 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void reflectionEffect(ReflectionEffect re, StreamReader sr)
            throws IOException {
        re.setStyle(sr.readSInt4());
        re.setRadius(sr.readFloat());
        re.setDirection(sr.readFloat());
        re.setDistance(sr.readFloat());
        re.setTiltAngleX(sr.readFloat());
        re.setTiltAngleY(sr.readFloat());
        re.setZoomRateX(sr.readFloat());
        re.setZoomRateY(sr.readFloat());
        re.setRotationStyle(sr.readSInt4());
        re.setStartTransparency(sr.readFloat());
        re.setStartPosition(sr.readFloat());
        re.setEndTransparency(sr.readFloat());
        re.setEndPosition(sr.readFloat());
        re.setOffsetDirection(sr.readFloat());
    }
}

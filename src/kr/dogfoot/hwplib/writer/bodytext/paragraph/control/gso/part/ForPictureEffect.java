package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture.*;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 그림 개체 속성 레코드의 그림 효과 부분을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForPictureEffect {
    /**
     * 그림 개체 속성 레코드의 그림 효과 부분을 쓴다.
     *
     * @param pe 그림 개체 속성 레코드의 그림 효과를 나타내는 객체
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(PictureEffect pe, StreamWriter sw)
            throws Exception {
        sw.writeUInt4(pe.getProperty().getValue());

        shadowEffect(pe.getShadowEffect(), sw);
        neonEffect(pe.getNeonEffect(), sw);
        softEdgeEffect(pe.getSoftEdgeEffect(), sw);
        reflectionEffect(pe.getReflectionEffect(), sw);
    }

    /**
     * 그림자 효과 부분을 쓴다.
     *
     * @param se 그림자 효과를 나타내는 객체
     * @param sw 스트림 라이터
     * @throws Exception
     */
    private static void shadowEffect(ShadowEffect se, StreamWriter sw)
            throws Exception {
        if (se == null) {
            return;
        }
        sw.writeSInt4(se.getStyle());
        sw.writeFloat(se.getTransparency());
        sw.writeFloat(se.getCloudy());
        sw.writeFloat(se.getDirection());
        sw.writeFloat(se.getDistance());
        sw.writeSInt4(se.getSort());
        sw.writeFloat(se.getTiltAngleX());
        sw.writeFloat(se.getTiltAngleY());
        sw.writeFloat(se.getZoomRateX());
        sw.writeFloat(se.getZoomRateY());
        sw.writeSInt4(se.getRotateWithShape());
        colorPropery(se.getColor(), sw);
    }

    /**
     * 색상 속성 부분을 쓴다.
     *
     * @param cp 색상 속성을 나타내는 객체
     * @param sw 스트림 라이터
     * @throws Exception
     */
    private static void colorPropery(ColorWithEffect cp, StreamWriter sw)
            throws Exception {
        sw.writeSInt4(cp.getType());
        if (cp.getType() == 0) {
            sw.writeBytes(cp.getColor());
        } else {
            throw new Exception("not supported color type !!!");
        }

        int colorEffectCount = cp.getColorEffectList().size();
        sw.writeUInt4(colorEffectCount);

        for (ColorEffect ce : cp.getColorEffectList()) {
            sw.writeSInt4(ce.getSort());
            sw.writeFloat(ce.getValue());
        }
    }

    /**
     * 네온 효과 부분을 쓴다.
     *
     * @param ne 네온 효과를 나타내는 겍체
     * @param sw 스트림 라이터
     * @throws Exception
     */
    private static void neonEffect(NeonEffect ne, StreamWriter sw)
            throws Exception {
        if (ne == null) {
            return;
        }
        sw.writeFloat(ne.getTransparency());
        sw.writeFloat(ne.getRadius());
        colorPropery(ne.getColor(), sw);
    }

    /**
     * 부드러운 가장자리 효과 부분을 쓴다.
     *
     * @param see 부드러운 가장자리 효과를 나타내는 객체
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void softEdgeEffect(SoftEdgeEffect see, StreamWriter sw)
            throws IOException {
        if (see == null) {
            return;
        }
        sw.writeFloat(see.getRadius());
    }

    /**
     * 반사 효과 부분을 쓴다.
     *
     * @param re 반사 효과를 나타내는 객체
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void reflectionEffect(ReflectionEffect re, StreamWriter sw)
            throws IOException {
        if (re == null) {
            return;
        }
        sw.writeSInt4(re.getStyle());
        sw.writeFloat(re.getRadius());
        sw.writeFloat(re.getDirection());
        sw.writeFloat(re.getDistance());
        sw.writeFloat(re.getTiltAngleX());
        sw.writeFloat(re.getTiltAngleY());
        sw.writeFloat(re.getZoomRateX());
        sw.writeFloat(re.getZoomRateY());
        sw.writeSInt4(re.getRotationStyle());
        sw.writeFloat(re.getStartTransparency());
        sw.writeFloat(re.getStartPosition());
        sw.writeFloat(re.getEndTransparency());
        sw.writeFloat(re.getEndPosition());
        sw.writeFloat(re.getOffsetDirection());
    }

    /**
     * 그림 개체 속성 레코드의 그림 효과 부분의 크기를 반환한다.
     *
     * @param pe 그림 개체 속성 레코드의 그림 효과을 나타내는 객체
     * @return 그림 개체 속성 레코드의 그림 효과 부분의 크기
     */
    public static int getSize(PictureEffect pe) {
        int size = 0;
        size += 4;
        if (pe.getShadowEffect() != null) {
            size += 44;
            size += getSize(pe.getShadowEffect().getColor());
        }
        if (pe.getNeonEffect() != null) {
            size += 8;
            size += getSize(pe.getNeonEffect().getColor());
        }
        if (pe.getSoftEdgeEffect() != null) {
            size += 4;
        }
        if (pe.getReflectionEffect() != null) {
            size += 56;
        }
        return size;
    }

    /**
     * 색상 속성을 나타내는 객체의 크기를 반환한다.
     *
     * @param color 색상 속성을 나타내는 객체
     * @return 색상 속성을 나타내는 객체의 크기
     */
    private static int getSize(ColorWithEffect color) {
        int size = 0;
        size += 8;
        size += 4;
        size += 8 * color.getColorEffectList().size();
        return size;
    }

}

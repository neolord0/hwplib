package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.shapecomponent;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponent;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.renderingnfo.Matrix;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.renderingnfo.RenderingInfo;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.renderingnfo.ScaleRotateMatrixPair;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 그리기 개체의 객체 공통 속성 레코드의 공통 부분을 쓰기 위한 객체
 *
 * @author neolord
 */
public class CommonPart {
    /**
     * 그리기 개체의 객체 공통 속성 레코드의 공통 부분을 쓴다.
     *
     * @param sc 그리기 개체의 객체 공통 속성 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ShapeComponent sc, StreamWriter sw)
            throws IOException {
        sw.writeSInt4(sc.getOffsetX());
        sw.writeSInt4(sc.getOffsetY());
        sw.writeUInt2(sc.getGroupingCount());
        sw.writeUInt2(sc.getLocalFileVersion());
        sw.writeUInt4(sc.getWidthAtCreate());
        sw.writeUInt4(sc.getHeightAtCreate());
        sw.writeUInt4(sc.getWidthAtCurrent());
        sw.writeUInt4(sc.getHeightAtCurrent());
        sw.writeUInt4(sc.getProperty());
        sw.writeUInt2(sc.getRotateAngle());
        sw.writeSInt4(sc.getRotateXCenter());
        sw.writeSInt4(sc.getRotateYCenter());

        renderingInfo(sc.getRenderingInfo(), sw);
    }

    /**
     * Rendering 정보를 쓴다.
     *
     * @param ri Rendering 정보
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void renderingInfo(RenderingInfo ri, StreamWriter sw)
            throws IOException {
        int scaleRotateMatrixCount = ri.getScaleRotateMatrixPairList().size();
        sw.writeUInt2(scaleRotateMatrixCount);
        matrix(ri.getTranslationMatrix(), sw);
        for (ScaleRotateMatrixPair srmp : ri.getScaleRotateMatrixPairList()) {
            matrix(srmp.getScaleMatrix(), sw);
            matrix(srmp.getRotateMatrix(), sw);
        }
    }

    /**
     * 행렬 객체를 쓴다.
     *
     * @param m  행렬 객체
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void matrix(Matrix m, StreamWriter sw) throws IOException {
        for (int index = 0; index < 6; index++) {
            sw.writeDouble(m.getValue(index));
        }
    }

    /**
     * 그리기 개체의 객체 공통 속성 레코드의 공통 부분의 크기를 반환한다.
     *
     * @param sc 그리기 개체의 객체 공통 속성 레코드
     * @return 그리기 개체의 객체 공통 속성 레코드의 공통 부분의 크기
     */
    public static int getSize(ShapeComponent sc) {
        int size = 0;
        size += 42;

        size += 2;
        size += 48;
        size += 48 * 2 * sc.getRenderingInfo().getScaleRotateMatrixPairList()
                .size();
        return size;
    }
}

package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlEllipse;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentEllipse;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.ForTextBox;

import java.io.IOException;

/**
 * 타원 컨트롤의 나머지 부분을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlEllipse {
    /**
     * 타원 컨트롤의 나머지 부분을 쓴다.
     *
     * @param ell 타원 컨트롤
     * @param sw  스트림 라이터
     * @throws Exception
     */
    public static void writeRest(ControlEllipse ell, StreamWriter sw)
            throws Exception {
        sw.upRecordLevel();

        ForTextBox.write(ell.getTextBox(), sw);
        shapeComponentEllipse(ell.getShapeComponentEllipse(), sw);

        sw.downRecordLevel();
    }

    /**
     * 타원 개체 속성 레코드를 쓴다.
     *
     * @param sce 타원 개체 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void shapeComponentEllipse(ShapeComponentEllipse sce,
                                              StreamWriter sw) throws IOException {
        recordHeader(sw);

        sw.writeUInt4(sce.getProperty().getValue());
        sw.writeSInt4(sce.getCenterX());
        sw.writeSInt4(sce.getCenterY());
        sw.writeSInt4(sce.getAxis1X());
        sw.writeSInt4(sce.getAxis1Y());
        sw.writeSInt4(sce.getAxis2X());
        sw.writeSInt4(sce.getAxis2Y());
        sw.writeSInt4(sce.getStartX());
        sw.writeSInt4(sce.getStartY());
        sw.writeSInt4(sce.getEndX());
        sw.writeSInt4(sce.getEndY());
        sw.writeSInt4(sce.getStartX2());
        sw.writeSInt4(sce.getStartY2());
        sw.writeSInt4(sce.getEndX2());
        sw.writeSInt4(sce.getEndY2());
    }

    /**
     * 타원 개체 속성 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT_ELLIPSE, 60);
    }
}

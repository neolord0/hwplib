package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlArc;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentArc;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.ForTextBox;

import java.io.IOException;

/**
 * 호 컨트롤의 나머지 부분을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlArc {
    /**
     * 호 컨트톨의 나머지 부분를 쓴다.
     *
     * @param arc 호 컨트롤
     * @param sw
     * @throws Exception
     */
    public static void writeRest(ControlArc arc, StreamWriter sw)
            throws Exception {
        sw.upRecordLevel();

        ForTextBox.write(arc.getTextBox(), sw);
        shapeComponentArc(arc.getShapeComponentArc(), sw);

        sw.downRecordLevel();
    }

    /**
     * 호 개체 속성 레코드를 쓴다.
     *
     * @param sca 호 개체 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void shapeComponentArc(ShapeComponentArc sca, StreamWriter sw)
            throws IOException {
        recordHeader(sw);

        sw.writeUInt1(sca.getArcBorder().getValue());
        sw.writeSInt4(sca.getCenterX());
        sw.writeSInt4(sca.getCenterY());
        sw.writeSInt4(sca.getAxis1X());
        sw.writeSInt4(sca.getAxis1Y());
        sw.writeSInt4(sca.getAxis2X());
        sw.writeSInt4(sca.getAxis2Y());
    }

    /**
     * 호 개체 속성 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT_ARC, 25);
    }

}

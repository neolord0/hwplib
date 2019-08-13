package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlCurve;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentCurve;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.curve.CurveSegmentType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.ForTextBox;

import java.io.IOException;

/**
 * 곡선 컨트롤의 나머지 부분을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlCurve {
    /**
     * 곡선 컨트롤의 나머지 부분을 쓴다.
     *
     * @param curv 곡선 컨트롤
     * @param sw   스트림 라이터
     * @throws Exception
     */
    public static void writeRest(ControlCurve curv, StreamWriter sw)
            throws Exception {
        sw.upRecordLevel();

        ForTextBox.write(curv.getTextBox(), sw);
        shapeComponentCurve(curv.getShapeComponentCurve(), sw);

        sw.downRecordLevel();
    }

    /**
     * 곡선 개체 속성 레코드을 쓴다.
     *
     * @param scc 곡선 개체 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void shapeComponentCurve(ShapeComponentCurve scc,
                                            StreamWriter sw) throws IOException {
        recordHeader(scc, sw);

        int positionCount = scc.getPositionList().size();
        sw.writeSInt4(positionCount);
        for (PositionXY p : scc.getPositionList()) {
            sw.writeSInt4((int) p.getX());
            sw.writeSInt4((int) p.getY());
        }
        for (int index = 0; index < positionCount - 1; index++) {
            CurveSegmentType cst = scc.getSegmentTypeList().get(index);
            sw.writeUInt1(cst.getValue());
        }
        sw.writeZero(4);
    }

    /**
     * 곡선 개체 속성 레코드의 레코드 헤더를 쓴다.
     *
     * @param scc 곡선 개체 속성 레코드
     * @param sw  스트림 리더
     * @throws IOException
     */
    private static void recordHeader(ShapeComponentCurve scc, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT_CURVE, getSize(scc));
    }

    /**
     * 곡선 개체 속성 레코드의 크기를 반환한다.
     *
     * @param scc 곡선 개체 속성 레코드
     * @return 곡선 개체 속성 레코드의 크기
     */
    private static int getSize(ShapeComponentCurve scc) {
        int size = 0;
        size += 4;
        size += scc.getPositionList().size() * 8;
        size += scc.getPositionList().size() - 1;
        size += 4;
        return size;
    }
}

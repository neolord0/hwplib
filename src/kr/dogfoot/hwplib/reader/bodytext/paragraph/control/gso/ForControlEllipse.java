package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlEllipse;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentEllipse;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForTextBox;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 타원 컨트롤의 나머지 부분을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForControlEllipse {
    /**
     * 타원 컨트롤의 나머지 부분을 읽는다.
     *
     * @param ellipse 타원 컨트롤
     * @param sr      스트림 리더
     * @throws Exception
     */
    public static void readRest(ControlEllipse ellipse, StreamReader sr)
            throws Exception {
        RecordHeader rh = sr.readRecordHeder();
        if (rh.getTagID() == HWPTag.LIST_HEADER) {
            ellipse.createTextBox();
            ForTextBox.read(ellipse.getTextBox(), sr);
            if (sr.isImmediatelyAfterReadingHeader() == false) {
                rh = sr.readRecordHeder();
            }
        }
        if (rh.getTagID() == HWPTag.SHAPE_COMPONENT_ELLIPSE) {
            shapeComponentEllipse(ellipse.getShapeComponentEllipse(), sr);
        }
    }

    /**
     * 타원 개체 속성 레코드를 읽는다.
     *
     * @param sce 타원 개체 속성 레코드
     * @param sr  스트림 리더
     * @throws IOException
     */
    private static void shapeComponentEllipse(ShapeComponentEllipse sce,
                                              StreamReader sr) throws IOException {
        sce.getProperty().setValue(sr.readUInt4());
        sce.setCenterX(sr.readSInt4());
        sce.setCenterY(sr.readSInt4());
        sce.setAxis1X(sr.readSInt4());
        sce.setAxis1Y(sr.readSInt4());
        sce.setAxis2X(sr.readSInt4());
        sce.setAxis2Y(sr.readSInt4());
        sce.setStartX(sr.readSInt4());
        sce.setStartY(sr.readSInt4());
        sce.setEndX(sr.readSInt4());
        sce.setEndY(sr.readSInt4());
        sce.setStartX2(sr.readSInt4());
        sce.setStartY2(sr.readSInt4());
        sce.setEndX2(sr.readSInt4());
        sce.setEndY2(sr.readSInt4());
    }
}

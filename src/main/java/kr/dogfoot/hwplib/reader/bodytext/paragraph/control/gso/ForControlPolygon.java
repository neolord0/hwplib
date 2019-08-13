package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlPolygon;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentPolygon;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForTextBox;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 다각형 컨트롤의 나머지 부분을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForControlPolygon {
    /**
     * 다각형 컨트롤의 나머지 부분을 읽는다.
     *
     * @param polygon 다각형 컨트롤
     * @param sr      스트림 리더
     * @throws Exception
     */
    public static void readRest(ControlPolygon polygon, StreamReader sr) throws Exception {
        RecordHeader rh = sr.readRecordHeder();
        if (rh.getTagID() == HWPTag.LIST_HEADER) {
            polygon.createTextBox();
            ForTextBox.read(polygon.getTextBox(), sr);
            if (sr.isImmediatelyAfterReadingHeader() == false) {
                rh = sr.readRecordHeder();
            }
        }
        if (rh.getTagID() == HWPTag.SHAPE_COMPONENT_POLYGON) {
            shapeComponentPolygon(polygon.getShapeComponentPolygon(), sr);
        }
    }

    /**
     * 다각형 개체 속성 레코드을 읽는다.
     *
     * @param scp 다각형 개체 속성 레코드
     * @param sr  스트림 리더
     * @throws IOException
     */
    private static void shapeComponentPolygon(
            ShapeComponentPolygon scp, StreamReader sr) throws IOException {
        int positionCount = sr.readSInt4();
        for (int index = 0; index < positionCount; index++) {
            PositionXY p = scp.addNewPosition();
            p.setX(sr.readSInt4());
            p.setY(sr.readSInt4());
        }
        sr.skip(4);
    }
}

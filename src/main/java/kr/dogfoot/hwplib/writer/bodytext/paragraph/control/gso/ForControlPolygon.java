package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlPolygon;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentPolygon;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.ForTextBox;

import java.io.IOException;

/**
 * 다각형 컨트롤의 나머지 부분을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlPolygon {
    /**
     * 다각형 컨트롤의 나머지 부분을 쓴다.
     *
     * @param poly 다각형 컨트롤
     * @param sw   스트림 라이터
     * @throws Exception
     */
    public static void writeRest(ControlPolygon poly, StreamWriter sw)
            throws Exception {
        sw.upRecordLevel();

        ForTextBox.write(poly.getTextBox(), sw);
        shapeComponentPolygon(poly.getShapeComponentPolygon(), sw);

        sw.downRecordLevel();
    }

    /**
     * 다각형 개체 속성 레코드을 쓴다.
     *
     * @param scp 다각형 개체 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void shapeComponentPolygon(ShapeComponentPolygon scp,
                                              StreamWriter sw) throws IOException {
        recordHeader(scp, sw);

        sw.writeSInt4(scp.getPositionList().size());
        for (PositionXY p : scp.getPositionList()) {
            sw.writeSInt4((int) p.getX());
            sw.writeSInt4((int) p.getY());
        }
        sw.writeZero(4);
    }

    /**
     * 다각형 개체 속성 레코드의 레코드 헤더를 쓴다.
     *
     * @param scp 다각형 개체 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(ShapeComponentPolygon scp, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT_POLYGON, getSize(scp));
    }

    /**
     * 다각형 개체 속성 레코드의 크기를 반환한다.
     *
     * @param scp 다각형 개체 속성 레코드
     * @return 다각형 개체 속성 레코드의 크기
     */
    private static int getSize(ShapeComponentPolygon scp) {
        int size = 0;
        size += 4;
        size += 8 * scp.getPositionList().size();
        size += 4;
        return size;
    }
}

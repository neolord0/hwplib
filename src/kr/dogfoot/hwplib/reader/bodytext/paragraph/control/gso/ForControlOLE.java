package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlOLE;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentOLE;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * OLE 컨트롤의 나머지 부분을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForControlOLE {
    /**
     * OLE 컨트롤의 나머지 부분을 읽는다.
     *
     * @param ole OLE 컨트롤
     * @param sr  스트림 리더
     * @throws IOException
     */
    public static void readRest(ControlOLE ole, StreamReader sr) throws IOException {
        RecordHeader rh = sr.readRecordHeder();
        if (rh.getTagID() == HWPTag.SHAPE_COMPONENT_OLE) {
            shapeComponentOLE(ole.getShapeComponentOLE(), sr);
        }
    }

    /**
     * OLE 개체 속성 레코드를 읽는다.
     *
     * @param sco OLE 개체 속성 레코드
     * @param sr  스트림 리더
     * @throws IOException
     */
    private static void shapeComponentOLE(ShapeComponentOLE sco, StreamReader sr)
            throws IOException {
        sco.getProperty().setValue(sr.readUInt4());
        sco.setExtentWidth(sr.readSInt4());
        sco.setExtentHeight(sr.readSInt4());
        sco.setBinDataId(sr.readUInt2());
        sco.getBorderColor().setValue(sr.readUInt4());
        sco.setBorderThickness(sr.readSInt4());
        sco.getBorderProperty().setValue(sr.readUInt4());
    }
}

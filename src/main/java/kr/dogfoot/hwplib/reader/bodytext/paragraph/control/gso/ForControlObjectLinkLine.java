package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlObjectLinkLine;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentLineForObjectLinkLine;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.objectlinkline.ControlPoint;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.objectlinkline.LinkLineType;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 객체 연결선 컨트롤의 나머지 부분을 읽기 위한 객체
 *
 * @author 박성균
 */
public class ForControlObjectLinkLine {
    /**
     * 객체 연결선 컨트롤의 나머지 부분을 읽는다.
     *
     * @param objectLinkerLine 객체 연결선 컨트롤
     * @param sr               스트림 리더
     * @throws IOException
     */
    public static void readRest(ControlObjectLinkLine objectLinkerLine,
                                StreamReader sr) throws IOException {
        RecordHeader rh = sr.readRecordHeader();
        if (rh.getTagID() == HWPTag.SHAPE_COMPONENT_LINE) {
            shapeComponentLine(objectLinkerLine.getShapeComponentLine(), sr);
        }

    }

    /**
     * 선 개체 속성 레코드를 읽는다.
     *
     * @param scl 선 개체 속성 레코드
     * @param sr  스트림 리더
     * @throws IOException
     */
    private static void shapeComponentLine(
            ShapeComponentLineForObjectLinkLine scl, StreamReader sr)
            throws IOException {
        scl.setStartX(sr.readSInt4());
        scl.setStartY(sr.readSInt4());
        scl.setEndX(sr.readSInt4());
        scl.setEndY(sr.readSInt4());

        scl.setType(LinkLineType.valueOf((byte) sr.readUInt4()));
        scl.setStartSubjectID(sr.readUInt4());
        scl.setStartSubjectIndex(sr.readUInt4());
        scl.setEndSubjectID(sr.readUInt4());
        scl.setEndSubjectIndex(sr.readUInt4());

        int countOfCP = (int) sr.readUInt4();
        for (int index = 0; index < countOfCP;index++) {
            ControlPoint cp = scl.addNewControlPoint();
            cp.setX(sr.readUInt4());
            cp.setY(sr.readUInt4());
            cp.setType(sr.readUInt2());
        }

        if (sr.isEndOfRecord()) return;

        unknownBytes(sr);
    }

    private static void unknownBytes(StreamReader sr) throws IOException {
        sr.skipToEndRecord();
    }
}

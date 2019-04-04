package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlObjectLinkLine;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentLineForObjectLinkLine;
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
        RecordHeader rh = sr.readRecordHeder();
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
        unknownData(scl, sr);
    }

    /**
     * 알 수 없는 데이터 블럭을 읽는다.
     *
     * @param scl 선 개체 속성 레코드
     * @param sr  스트림 리더
     * @throws IOException
     */
    private static void unknownData(ShapeComponentLineForObjectLinkLine scl,
                                    StreamReader sr) throws IOException {
        int unknownSize = (int) (sr.getCurrentRecordHeader().getSize() - sr
                .getCurrentPositionAfterHeader());
        if (unknownSize > 0) {
            byte[] unknown = new byte[unknownSize];
            sr.readBytes(unknown);
            scl.setUnknown(unknown);
        }
    }

}

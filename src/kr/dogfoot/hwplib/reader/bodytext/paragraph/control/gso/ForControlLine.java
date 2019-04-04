package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlLine;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentLine;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 선 컨트롤의 나머지 부분을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForControlLine {
    /**
     * 선 컨트롤의 나머지 부분을 읽는다.
     *
     * @param line 선 컨트롤
     * @param sr   스트림 리더
     * @throws IOException
     */
    public static void readRest(ControlLine line, StreamReader sr)
            throws IOException {
        RecordHeader rh = sr.readRecordHeder();
        if (rh.getTagID() == HWPTag.SHAPE_COMPONENT_LINE) {
            shapeComponentLine(line.getShapeComponentLine(), sr);
        }
    }

    /**
     * 선 개체 속성 레코드를 읽는다.
     *
     * @param scl 선 개체 속성 레코드
     * @param sr  스트림 리더
     * @throws IOException
     */
    private static void shapeComponentLine(ShapeComponentLine scl,
                                           StreamReader sr) throws IOException {
        scl.setStartX(sr.readSInt4());
        scl.setStartY(sr.readSInt4());
        scl.setEndX(sr.readSInt4());
        scl.setEndY(sr.readSInt4());
        int temp = sr.readSInt4();
        if (temp == 1) {
            scl.setStartedRightOrBottom(true);
        }
    }
}

package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlLine;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentLine;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 선 컨트롤의 나머지 부분을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlLine {
    /**
     * 선 컨트롤의 나머지 부분을 쓴다.
     *
     * @param line 선 컨트롤
     * @param sw   스트림 라이터
     * @throws IOException
     */
    public static void writeRest(ControlLine line, StreamWriter sw)
            throws IOException {
        sw.upRecordLevel();

        shapeComponentLine(line.getShapeComponentLine(), sw);

        sw.downRecordLevel();
    }

    /**
     * 선 개체 속성 레코드를 쓴다.
     *
     * @param scl 선 개체 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void shapeComponentLine(ShapeComponentLine scl,
                                           StreamWriter sw) throws IOException {
        recordHeader(sw);

        sw.writeSInt4(scl.getStartX());
        sw.writeSInt4(scl.getStartY());
        sw.writeSInt4(scl.getEndX());
        sw.writeSInt4(scl.getEndY());
        sw.writeSInt4(getStartedRightOrBottom(scl));
    }

    /**
     * 선 개체 속성 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT_LINE, 20);
    }

    /**
     * 오른쪽/아래쪽 시작인지 여부에 대한 값을 반환한다.
     *
     * @param scl 선 개체 속성 레코드
     * @return 오른쪽/아래쪽 시작인지 여부에 대한 값
     */
    private static int getStartedRightOrBottom(ShapeComponentLine scl) {
        int temp = 0;
        if (scl.isStartedRightOrBottom()) {
            temp = 1;
        }
        return temp;
    }
}

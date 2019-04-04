package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlRectangle;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentRectangle;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.bookmark.ForCtrlData;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.ForTextBox;

import java.io.IOException;

/**
 * 사각형 컨트롤의 나머지 부분을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlRectangle {
    /**
     * 사각형 컨트롤의 나머지 부분을 쓴다.
     *
     * @param rect 사각형 컨트롤
     * @param sw   스트림 라이터
     * @throws Exception
     */
    public static void writeRest(ControlRectangle rect, StreamWriter sw)
            throws Exception {
        sw.upRecordLevel();

        ctrlData(rect, sw);
        ForTextBox.write(rect.getTextBox(), sw);
        shapeComponentRectangle(rect.getShapeComponentRectangle(), sw);

        sw.downRecordLevel();
    }

    /**
     * 컨트롤 데이터 레코드를 쓴다.
     *
     * @param rect 사각형 컨트롤
     * @param sw   스트림 라이터
     */
    private static void ctrlData(ControlRectangle rect, StreamWriter sw)
            throws IOException {
        if (rect.getCtrlData() != null) {
            ForCtrlData.write(rect.getCtrlData(), sw);
        }
    }

    /**
     * 사각형 개체 속성 레코드를 쓴다.
     *
     * @param scr 사각형 개체 속성 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void shapeComponentRectangle(ShapeComponentRectangle scr,
                                                StreamWriter sw) throws IOException {
        recordHeader(sw);

        sw.writeSInt1(scr.getRoundRate());
        sw.writeSInt4(scr.getX1());
        sw.writeSInt4(scr.getY1());
        sw.writeSInt4(scr.getX2());
        sw.writeSInt4(scr.getY2());
        sw.writeSInt4(scr.getX3());
        sw.writeSInt4(scr.getY3());
        sw.writeSInt4(scr.getX4());
        sw.writeSInt4(scr.getY4());
    }

    /**
     * 사각형 개체 속성 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT_RECTANGLE, 33);
    }
}

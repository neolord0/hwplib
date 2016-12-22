package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import java.io.IOException;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlRectangle;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentRectangle;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.RecordHeader;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForTextBox;
import kr.dogfoot.hwplib.util.compoundFile.StreamReader;

/**
 * 사각형 컨트롤을 읽기 위한 객체
 * 
 * @author neolord
 */
public class ForControlRectangle {
	/**
	 * 사각형 컨트롤을 읽는다.
	 * 
	 * @param rectangle
	 *            사각형 컨트롤
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	public static void read(ControlRectangle rectangle, StreamReader sr)
			throws Exception {
		RecordHeader rh = sr.readRecordHeder();
		if (rh.getTagID() == HWPTag.LIST_HEADER) {
			rectangle.createTextBox();
			ForTextBox.read(rectangle.getTextBox(), sr);
			if (sr.isImmediatelyAfterReadingHeader() == false) {
				rh = sr.readRecordHeder();
			}
		}
		if (rh.getTagID() == HWPTag.SHAPE_COMPONENT_RECTANGLE) {
			shapeComponentRectangle(rectangle.getShapeComponentRectangle(), sr);
		}
	}

	/**
	 * 사각형 개체 속성 레코드를 읽는다.
	 * 
	 * @param scr
	 *            사각형 개체 속성 레코드
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void shapeComponentRectangle(ShapeComponentRectangle scr,
			StreamReader sr) throws IOException {
		scr.setRoundRate(sr.readSInt1());
		scr.setX1(sr.readSInt4());
		scr.setY1(sr.readSInt4());
		scr.setX2(sr.readSInt4());
		scr.setY2(sr.readSInt4());
		scr.setX3(sr.readSInt4());
		scr.setY3(sr.readSInt4());
		scr.setX4(sr.readSInt4());
		scr.setY4(sr.readSInt4());
	}
}

package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import java.io.IOException;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlCurve;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentCurve;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.curve.CurveSegmentType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.RecordHeader;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForTextBox;
import kr.dogfoot.hwplib.util.compoundFile.StreamReader;

/**
 * 곡선 컨트롤을 읽기 위한 객체
 * 
 * @author neolord
 */
public class ForControlCurve {
	/**
	 * 곡선 컨트롤을 읽는다.
	 * 
	 * @param curve
	 *            곡선 컨트롤
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	public static void read(ControlCurve curve, StreamReader sr)
			throws Exception {
		RecordHeader rh = sr.readRecordHeder();
		if (rh.getTagID() == HWPTag.LIST_HEADER) {
			curve.createTextBox();
			ForTextBox.read(curve.getTextBox(), sr);
			if (sr.isImmediatelyAfterReadingHeader() == false) {
				rh = sr.readRecordHeder();
			}
		}
		if (rh.getTagID() == HWPTag.SHAPE_COMPONENT_CURVE) {
			shapeComponentCurve(curve.getShapeComponentCurve(), sr);
		}
	}

	/**
	 * 곡선 개체 속성 레코드를 읽는다.
	 * 
	 * @param scc
	 *            곡선 개체 속성 레코드
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void shapeComponentCurve(ShapeComponentCurve scc,
			StreamReader sr) throws IOException {
		int positionCount = sr.readSInt4();
		for (int i = 0; i < positionCount; i++) {
			PositionXY p = scc.addNewPosition();
			p.setX(sr.readSInt4());
			p.setY(sr.readSInt4());
		}
		for (int i = 0; i < positionCount - 1; i++) {
			CurveSegmentType cst = CurveSegmentType.valueOf((byte) sr
					.readUInt1());
			scc.addCurveSegmentType(cst);
		}
		long rest = sr.readUInt4();
		if (rest != 0) {
			scc.setClosed(true);
		}
	}
}

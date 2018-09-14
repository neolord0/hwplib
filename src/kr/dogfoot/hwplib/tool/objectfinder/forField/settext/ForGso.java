package kr.dogfoot.hwplib.tool.objectfinder.forField.settext;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlArc;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlContainer;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlCurve;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlEllipse;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlPolygon;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlRectangle;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.tool.objectfinder.forField.ForParagraphList;

/**
 * 그리기 개체에 포함된 필드의 텍스트를 설정하는 기능을 포함한 클래스
 * 
 * @author 박성균
 */
public class ForGso {
	/**
	 * 그리기 개체에 포함된 필드의 텍스트를 설정한다.
	 * 
	 * @param gc
	 *            그리기 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	public static boolean setFieldText(GsoControl gc, ControlType fieldType, String fieldName, String text)
			throws Exception {
		switch (gc.getGsoType()) {
		case Line:
			break;
		case Rectangle:
			return rectangle((ControlRectangle) gc, fieldType, fieldName, text);
		case Ellipse:
			return ellipse((ControlEllipse) gc, fieldType, fieldName, text);
		case Arc:
			return arc((ControlArc) gc, fieldType, fieldName, text);
		case Polygon:
			return polygon((ControlPolygon) gc, fieldType, fieldName, text);
		case Curve:
			return curve((ControlCurve) gc, fieldType, fieldName, text);
		case Picture:
			break;
		case OLE:
			break;
		case Container:
			return container((ControlContainer) gc, fieldType, fieldName, text);
		default:
			break;
		}
		return false;
	}

	/**
	 * 사각형 개체에 포함된 필드의 텍스트를 설정한다.
	 * 
	 * @param rectangle
	 *            사각형 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean rectangle(ControlRectangle rectangle, ControlType fieldType, String fieldName, String text)
			throws Exception {
		return textBox(rectangle.getTextBox(), fieldType, fieldName, text);
	}

	/**
	 * 텍스트 박스 안에 포함된 필드의 텍스트를 설정한다.
	 * 
	 * @param textBox
	 *            텍스트 박스
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean textBox(TextBox textBox, ControlType fieldType, String fieldName, String text)
			throws Exception {
		return ForParagraphList.setFieldText(textBox.getParagraphList(), fieldType, fieldName, text);
	}

	/**
	 * 타원 개체에 포함된 필드의 텍스트를 설정한다.
	 * 
	 * @param ellipse
	 *            타원 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean ellipse(ControlEllipse ellipse, ControlType fieldType, String fieldName, String text)
			throws Exception {
		return textBox(ellipse.getTextBox(), fieldType, fieldName, text);
	}

	/**
	 * 호 개체에 포함된 필드의 텍스트를 설정한다.
	 * 
	 * @param arc
	 *            호 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean arc(ControlArc arc, ControlType fieldType, String fieldName, String text) throws Exception {
		return textBox(arc.getTextBox(), fieldType, fieldName, text);
	}

	/**
	 * 다각형 개체에 포함된 필드의 텍스트를 설정한다.
	 * 
	 * @param polygon
	 *            다각형 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean polygon(ControlPolygon polygon, ControlType fieldType, String fieldName, String text)
			throws Exception {
		return textBox(polygon.getTextBox(), fieldType, fieldName, text);
	}

	/**
	 * 곡선 개체에 포함된 필드의 텍스트를 설정한다.
	 * 
	 * @param curve
	 *            곡선 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean curve(ControlCurve curve, ControlType fieldType, String fieldName, String text)
			throws Exception {
		return textBox(curve.getTextBox(), fieldType, fieldName, text);
	}

	/**
	 * 묶음 개체에 포함된 필드의 텍스트를 설정한다.
	 * 
	 * @param container
	 *            묶음 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean container(ControlContainer container, ControlType fieldType, String fieldName, String text)
			throws Exception {
		for (GsoControl child : container.getChildControlList()) {
			if (setFieldText(child, fieldType, fieldName, text)) {
				return true;
			}
		}
		return false;
	}
}

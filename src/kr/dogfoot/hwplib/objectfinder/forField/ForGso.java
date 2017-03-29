package kr.dogfoot.hwplib.objectfinder.forField;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlArc;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlContainer;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlCurve;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlEllipse;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlPolygon;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlRectangle;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;

/**
 * 그리기 개체에서 필드 객체를 찾는 기능을 포함하는 클래스
 * 
 * @author neolord
 */
public class ForGso {
	/**
	 * 그리기 개체에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param gc
	 *            그리기 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	public static String getFieldText(GsoControl gc, ControlType fieldType,
			String fieldName) {
		switch (gc.getGsoType()) {
		case Line:
			break;
		case Rectangle:
			return rectangle((ControlRectangle) gc, fieldType, fieldName);
		case Ellipse:
			return ellipse((ControlEllipse) gc, fieldType, fieldName);
		case Arc:
			return arc((ControlArc) gc, fieldType, fieldName);
		case Polygon:
			return polygon((ControlPolygon) gc, fieldType, fieldName);
		case Curve:
			return curve((ControlCurve) gc, fieldType, fieldName);
		case Picture:
			break;
		case OLE:
			break;
		case Container:
			return container((ControlContainer) gc, fieldType, fieldName);
		}
		return null;
	}

	/**
	 * 사각형 개체에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param rectangle
	 *            사각형 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String rectangle(ControlRectangle rectangle,
			ControlType fieldType, String fieldName) {
		return textBox(rectangle.getTextBox(), fieldType, fieldName);
	}

	/**
	 * 글상자 객체에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param textBox
	 *            글상자 객체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String textBox(TextBox textBox, ControlType fieldType,
			String fieldName) {
		return ForParagraphList.getFieldText(textBox.getParagraphList(),
				fieldType, fieldName);
	}

	/**
	 * 타원 개체에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param ellipse
	 *            타원 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String ellipse(ControlEllipse ellipse,
			ControlType fieldType, String fieldName) {
		return textBox(ellipse.getTextBox(), fieldType, fieldName);
	}

	/**
	 * 호 개체에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param arc
	 *            호 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String arc(ControlArc arc, ControlType fieldType,
			String fieldName) {
		return textBox(arc.getTextBox(), fieldType, fieldName);
	}

	/**
	 * 다각형 개체에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param polygon
	 *            다각형 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String polygon(ControlPolygon polygon,
			ControlType fieldType, String fieldName) {
		return textBox(polygon.getTextBox(), fieldType, fieldName);
	}

	/**
	 * 곡선 개체에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param curve
	 *            곡선 개체
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String curve(ControlCurve curve, ControlType fieldType,
			String fieldName) {
		return textBox(curve.getTextBox(), fieldType, fieldName);
	}

	/**
	 * 묶음 개체에서  필드 객체의 텍스트를 찾아 반환한다.
	 * @param container 컨테이터 개체
	 * @param fieldType 필드 타입
	 * @param fieldName 필드 이름
	 * @return 필드 텍스트
	 */
	private static String container(ControlContainer container,
			ControlType fieldType, String fieldName) {
		for (GsoControl child : container.getChildControlList()) {
			String text = getFieldText(child, fieldType, fieldName);
			if (text != null) {
				return text;
			}
		}
		return null;
	}
}

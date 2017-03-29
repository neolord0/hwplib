package kr.dogfoot.hwplib.objectfinder.forField;

import java.util.ArrayList;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;

/**
 * 문단리스트, 문단에서 필드 객체를 찾는 기능을 포함하는 클래스
 * 
 * @author neolord
 */
public class ForParagraphList {
	/**
	 * 문단리스트에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param paragraphList
	 *            문단리스트
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	public static String getFieldText(ParagraphList paragraphList,
			ControlType fieldType, String fieldName) {
		return getFieldText(paragraphList.getParagraphList(), fieldType,
				fieldName);
	}

	/**
	 * 문단리스트에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param paragraphList
	 *            문단리스트
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	public static String getFieldText(ArrayList<Paragraph> paragraphList,
			ControlType fieldType, String fieldName) {
		if (paragraphList == null) {
			return null;
		}
		String text = null;
		for (Paragraph p : paragraphList) {
			text = paragraph(p, fieldType, fieldName);
			if (text != null) {
				break;
			}
		}
		return text;
	}

	/**
	 * 문단과 문단의 포함된 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param p
	 *            문단
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String paragraph(Paragraph p, ControlType fieldType,
			String fieldName) {
		String text = getFieldText(p, fieldType, fieldName);
		if (text == null) {
			text = controls(p.getControlList(), fieldType, fieldName);
		}
		return text;
	}

	/**
	 * 문단에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param p
	 *            문단
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String getFieldText(Paragraph p, ControlType fieldType,
			String fieldName) {
		ControlField cf = findField(p, fieldType, fieldName);
		if (cf != null) {
			int indexOfControl = p.getControlIndex(cf);
			int indexOfStartField = p.getText()
					.getCharIndexFromExtendCharIndex(indexOfControl);
			int indexOfEndField = p.getText().getInlineCharIndex(
					indexOfStartField + 1, (short) 0x04);
			if (indexOfStartField != -1 && indexOfEndField != -1) {
				return p.getText().getNormalString(indexOfStartField + 1,
						indexOfEndField - 1);
			}
		}
		return null;
	}

	/**
	 * 문단에 포함된 필드 컨트롤을 찾는다.
	 * 
	 * @param p
	 *            문단
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 컨트롤
	 */
	private static ControlField findField(Paragraph p, ControlType fieldType,
			String fieldName) {
		if (p.getControlList() == null) {
			return null;
		}
		for (Control c : p.getControlList()) {
			if (c.getType() == fieldType) {
				ControlField cf = (ControlField) c;
				if (cf.getName() != null && cf.getName().equals(fieldName)) {
					return cf;
				}
			}
		}
		return null;
	}

	/**
	 * 문단의 포함된 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param controlList
	 *            컨트롤 리스트
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String controls(ArrayList<Control> controlList,
			ControlType fieldType, String fieldName) {
		String text = null;
		if (controlList != null) {
			for (Control c : controlList) {
				text = ForControl.getFieldText(c, fieldType, fieldName);
				if (text != null) {
					break;
				}
			}
		}
		return text;
	}
}

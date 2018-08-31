package kr.dogfoot.hwplib.objectfinder;

import java.io.UnsupportedEncodingException;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.objectfinder.forField.ForParagraphList;
import kr.dogfoot.hwplib.textextractor.TextExtractMethod;

/**
 * 필드 객체를 찾는 기능을 포함하는 클래스
 * 
 * @author neolord
 */
public class FieldFinder {
	/**
	 * 누름틀 컨트롤(ClickHere 필드)를 찾는다.
	 * 
	 * @param hwpFile
	 *            한글 파일 객체
	 * @param fieldName
	 *            필드 이름
	 * @param temInField
	 *            필드 안에 텍스트의 텍스트 추출 방법
	 * @return 필드 텍스트
	 * @throws UnsupportedEncodingException
	 */
	public static String getClickHereText(HWPFile hwpFile, String fieldName, TextExtractMethod temInField)
			throws UnsupportedEncodingException {
		String strText = null;
		for (Section s : hwpFile.getBodyText().getSectionList()) {
			strText = ForParagraphList.getFieldText(s, ControlType.FIELD_CLICKHERE, fieldName, temInField);
			if (strText != null) {
				break;
			}
		}
		return strText;
	}

	/**
	 * 누름틀 컨트롤(ClickHere 필드)를 찾아 텍스트를 설정한다.
	 * 
	 * @param hwpFile
	 *            한글 파일 객체
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            택스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	public static boolean setClickHereText(HWPFile hwpFile, String fieldName, String text) throws Exception {
		for (Section s : hwpFile.getBodyText().getSectionList()) {
			if (ForParagraphList.setFieldText(s, ControlType.FIELD_CLICKHERE, fieldName, text)) {
				return true;
			}
		}
		return false;
	}
}

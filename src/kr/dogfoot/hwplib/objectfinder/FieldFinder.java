package kr.dogfoot.hwplib.objectfinder;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.objectfinder.forField.ForParagraphList;

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
	 * @return 필드 텍스트
	 */
	public static String getClickHereText(HWPFile hwpFile, String fieldName) {
		String strText = null;
		for (Section s : hwpFile.getBodyText().getSectionList()) {
			strText = ForParagraphList.getFieldText(s.getParagraphList(),
					ControlType.FIELD_CLICKHERE, fieldName);
			if (strText != null) {
				break;
			}
		}
		return strText;
	}
}

package kr.dogfoot.hwplib.objectfinder.forField;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlEndnote;
import kr.dogfoot.hwplib.object.bodytext.control.ControlFooter;
import kr.dogfoot.hwplib.object.bodytext.control.ControlFootnote;
import kr.dogfoot.hwplib.object.bodytext.control.ControlHeader;
import kr.dogfoot.hwplib.object.bodytext.control.ControlHiddenComment;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;

/**
 * 컨트롤에서 필드 객체를 찾는 기능을 포함하는 클래스
 * 
 * @author neolord
 */
public class ForControl {
	/**
	 * 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param c
	 *            컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	public static String getFieldText(Control c, ControlType fieldType,
			String fieldName) {
		if (c.isField()) {
		} else {
			switch (c.getType()) {
			case Table:
				return table((ControlTable) c, fieldType, fieldName);
			case Gso:
				return ForGso
						.getFieldText((GsoControl) c, fieldType, fieldName);
			case Equation:
				break;
			case SectionDefine:
				break;
			case ColumnDefine:
				break;
			case Header:
				return header((ControlHeader) c, fieldType, fieldName);
			case Footer:
				return footer((ControlFooter) c, fieldType, fieldName);
			case Footnote:
				return footnote((ControlFootnote) c, fieldType, fieldName);
			case Endnote:
				return endnote((ControlEndnote) c, fieldType, fieldName);
			case AutoNumber:
				break;
			case NewNumber:
				break;
			case PageHide:
				break;
			case PageOddEvenAdjust:
				break;
			case PageNumberPositon:
				break;
			case IndexMark:
				break;
			case Bookmark:
				break;
			case OverlappingLetter:
				break;
			case AdditionalText:
				break;
			case HiddenComment:
				return hiddenComment((ControlHiddenComment) c, fieldType,
						fieldName);
			}
		}
		return null;
	}

	/**
	 * 표 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param table
	 *            표 컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String table(ControlTable table, ControlType fieldType,
			String fieldName) {
		for (Row r : table.getRowList()) {
			for (Cell c : r.getCellList()) {
				String text = ForParagraphList.getFieldText(
						c.getParagraphList(), fieldType, fieldName);
				if (text != null) {
					return text;
				}
			}
		}
		return null;
	}

	/**
	 * 머리말 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param header
	 *            머리말 컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String header(ControlHeader header, ControlType fieldType,
			String fieldName) {
		return ForParagraphList.getFieldText(header.getParagraphList(),
				fieldType, fieldName);
	}

	/**
	 * 꼬리말 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param footer
	 *            꼬리말 컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String footer(ControlFooter footer, ControlType fieldType,
			String fieldName) {
		return ForParagraphList.getFieldText(footer.getParagraphList(),
				fieldType, fieldName);
	}

	/**
	 * 각주 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param footnote
	 *            각주 컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String footnote(ControlFootnote footnote,
			ControlType fieldType, String fieldName) {
		return ForParagraphList.getFieldText(footnote.getParagraphList(),
				fieldType, fieldName);
	}

	/**
	 * 미주 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param endnote
	 *            미주 컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String endnote(ControlEndnote endnote,
			ControlType fieldType, String fieldName) {
		return ForParagraphList.getFieldText(endnote.getParagraphList(),
				fieldType, fieldName);
	}

	/**
	 * 숭은 설명 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
	 * 
	 * @param hiddenComment
	 *            숨은 설명 컨트롤 숨
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @return 필드 텍스트
	 */
	private static String hiddenComment(ControlHiddenComment hiddenComment,
			ControlType fieldType, String fieldName) {
		return ForParagraphList.getFieldText(hiddenComment.getParagraphList(),
				fieldType, fieldName);
	}
}

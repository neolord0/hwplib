package kr.dogfoot.hwplib.tool.objectfinder.forField.settext;

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
import kr.dogfoot.hwplib.tool.objectfinder.forField.ForParagraphList;

/**
 * 컨트롤에 포함된 필드의 텍스트를 설정하는 기능을 포함한 클래스
 * 
 * @author 박성균
 */
public class ForControl {
	/**
	 * 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
	 * 
	 * @param c
	 *            컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	public static boolean setFieldText(Control c, ControlType fieldType, String fieldName, String text)
			throws Exception {
		if (c.isField()) {
		} else {
			switch (c.getType()) {
			case Table:
				return table((ControlTable) c, fieldType, fieldName, text);
			case Gso:
				return ForGso.setFieldText((GsoControl) c, fieldType, fieldName, text);
			case Equation:
				break;
			case SectionDefine:
				break;
			case ColumnDefine:
				break;
			case Header:
				return header((ControlHeader) c, fieldType, fieldName, text);
			case Footer:
				return footer((ControlFooter) c, fieldType, fieldName, text);
			case Footnote:
				return footnote((ControlFootnote) c, fieldType, fieldName, text);
			case Endnote:
				return endnote((ControlEndnote) c, fieldType, fieldName, text);
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
				return hiddenComment((ControlHiddenComment) c, fieldType, fieldName, text);
			default:
				break;
			}
		}
		return false;
	}

	/**
	 * 표 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
	 * 
	 * @param table
	 *            표 컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean table(ControlTable table, ControlType fieldType, String fieldName, String text)
			throws Exception {
		for (Row r : table.getRowList()) {
			for (Cell c : r.getCellList()) {
				if (ForParagraphList.setFieldText(c.getParagraphList(), fieldType, fieldName, text)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 머리말 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
	 * 
	 * @param header
	 *            머리말 컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean header(ControlHeader header, ControlType fieldType, String fieldName, String text)
			throws Exception {
		return ForParagraphList.setFieldText(header.getParagraphList(), fieldType, fieldName, text);
	}

	/**
	 * 꼬리말 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
	 * 
	 * @param footer
	 *            꼬리말 컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean footer(ControlFooter footer, ControlType fieldType, String fieldName, String text)
			throws Exception {
		return ForParagraphList.setFieldText(footer.getParagraphList(), fieldType, fieldName, text);
	}

	/**
	 * 각주 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
	 * 
	 * @param footnote
	 *            각주 컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean footnote(ControlFootnote footnote, ControlType fieldType, String fieldName, String text)
			throws Exception {
		return ForParagraphList.setFieldText(footnote.getParagraphList(), fieldType, fieldName, text);
	}

	/**
	 * 미주 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
	 * 
	 * @param endnote
	 *            미주 컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean endnote(ControlEndnote endnote, ControlType fieldType, String fieldName, String text)
			throws Exception {
		return ForParagraphList.setFieldText(endnote.getParagraphList(), fieldType, fieldName, text);
	}

	/**
	 * 숨은 설명 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
	 * 
	 * @param hiddenComment
	 *            숨은 설명 컨트롤
	 * @param fieldType
	 *            필드 타입
	 * @param fieldName
	 *            필드 이름
	 * @param text
	 *            텍스트
	 * @return 설정 성공 여부
	 * @throws Exception
	 */
	private static boolean hiddenComment(ControlHiddenComment hiddenComment, ControlType fieldType, String fieldName,
			String text) throws Exception {
		return ForParagraphList.setFieldText(hiddenComment.getParagraphList(), fieldType, fieldName, text);
	}
}

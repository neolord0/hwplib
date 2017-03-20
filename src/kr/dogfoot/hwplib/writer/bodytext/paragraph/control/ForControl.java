package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlAdditionalText;
import kr.dogfoot.hwplib.object.bodytext.control.ControlBookmark;
import kr.dogfoot.hwplib.object.bodytext.control.ControlColumnDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ControlEndnote;
import kr.dogfoot.hwplib.object.bodytext.control.ControlEquation;
import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ControlFooter;
import kr.dogfoot.hwplib.object.bodytext.control.ControlFootnote;
import kr.dogfoot.hwplib.object.bodytext.control.ControlHeader;
import kr.dogfoot.hwplib.object.bodytext.control.ControlHiddenComment;
import kr.dogfoot.hwplib.object.bodytext.control.ControlIndexMark;
import kr.dogfoot.hwplib.object.bodytext.control.ControlNewNumber;
import kr.dogfoot.hwplib.object.bodytext.control.ControlOverlappingLetter;
import kr.dogfoot.hwplib.object.bodytext.control.ControlPageHide;
import kr.dogfoot.hwplib.object.bodytext.control.ControlPageNumberPosition;
import kr.dogfoot.hwplib.object.bodytext.control.ControlSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.ForControlGso;

public class ForControl {
	public static void write(Control c, StreamWriter sw) {
		if (ControlType.isField(c.getType().getCtrlId())) {
			field(c, sw); // 필드
			return;
		}
		switch (c.getType()) {
		case Table: // 표
			table(c, sw);
			break;
		case Equation: // 수식
			equation(c, sw);
			break;
		case SectionDefine: // 구역 정의
			sectionDefine(c, sw);
			break;
		case ColumnDefine: // 단 정의
			columnDefine(c, sw);
			break;
		case Header: // 머리말
			header(c, sw);
			break;
		case Footer: // 꼬리말
			footer(c, sw);
			break;
		case Footnote: // 각주
			footnote(c, sw);
			break;
		case Endnote: // 미주
			endnote(c, sw);
			break;
		case AutoNumber: // 자동 번호
			newNumber(c, sw);
			break;
		case NewNumber: // 새 번호 지정
			newNumber(c, sw);
			break;
		case PageHide: // 감추기
			pageHide(c, sw);
			break;
		case PageNumberPositon: // 쪽 번호 위치
			pageNumberPositon(c, sw);
			break;
		case IndexMark: // 찾아보기 표식
			indexMark(c, sw);
			break;
		case Bookmark: // 책갈피
			bookmark(c, sw);
			break;
		case OverlappingLetter: // 글자 겹침
			overlappingLetter(c, sw);
			break;
		case AdditionalText: // 덧말
			additionalText(c, sw);
			break;
		case HiddenComment: // 숨은 설명
			hiddenComment(c, sw);
			break;
		case Gso:
			gso(c, sw);
			break;
		}

	}

	private static void field(Control c, StreamWriter sw) {
		ForControlField.write((ControlField)c, sw);
	}

	private static void table(Control c, StreamWriter sw) {
		ForControlTable.write((ControlTable)c, sw);
	}

	private static void equation(Control c, StreamWriter sw) {
		ForControlEquation.write((ControlEquation)c, sw);
	}

	private static void sectionDefine(Control c, StreamWriter sw) {
		ForControlSectionDefine.write((ControlSectionDefine)c, sw);
	}

	private static void columnDefine(Control c, StreamWriter sw) {
		ForControlColumnDefine.write((ControlColumnDefine)c, sw);
	}

	private static void header(Control c, StreamWriter sw) {
		ForControlHeader.write((ControlHeader)c, sw);
	}

	private static void footer(Control c, StreamWriter sw) {
		ForControlFooter.write((ControlFooter)c, sw);
	}

	private static void footnote(Control c, StreamWriter sw) {
		ForControlFootnote.write((ControlFootnote)c, sw);
	}

	private static void endnote(Control c, StreamWriter sw) {
		ForControlEndnote.write((ControlEndnote)c, sw);
	}

	private static void newNumber(Control c, StreamWriter sw) {
		ForControlNewNumber.write((ControlNewNumber)c, sw);
	}

	private static void pageHide(Control c, StreamWriter sw) {
		ForControlPageHide.write((ControlPageHide)c, sw);
	}

	private static void pageNumberPositon(Control c, StreamWriter sw) {
		ForControlPageNumberPosition.write((ControlPageNumberPosition)c, sw);
	}

	private static void indexMark(Control c, StreamWriter sw) {
		ForControlIndexMark.write((ControlIndexMark)c, sw);
	}

	private static void bookmark(Control c, StreamWriter sw) {
		ForControlBookmark.write((ControlBookmark)c, sw);
	}

	private static void overlappingLetter(Control c, StreamWriter sw) {
		ForControlOverlappingLetter.write((ControlOverlappingLetter)c, sw);
	}

	private static void additionalText(Control c, StreamWriter sw) {
		ForControlAdditionalText.write((ControlAdditionalText)c, sw);
	}

	private static void hiddenComment(Control c, StreamWriter sw) {
		ForControlHiddenComment.write((ControlHiddenComment)c, sw);
	}

	private static void gso(Control c, StreamWriter sw) {
		ForControlGso.write((GsoControl)c, sw);
	}

}

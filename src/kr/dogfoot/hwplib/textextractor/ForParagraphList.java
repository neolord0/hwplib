package kr.dogfoot.hwplib.textextractor;

import java.util.ArrayList;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharNormal;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;

/**
 * 문단 리스트를 위한 텍스트 추출기 객체
 * 
 * @author neolord
 */
public class ForParagraphList {
	/**
	 * 문단 리스트에서 텍스트를 추출한다.
	 * 
	 * @param paragraphList
	 *            문단 리스트
	 * @param tem
	 *            텍스트 추출 방법
	 * @param sb
	 *            추출된 텍스트를 저정할 StringBuffer 객체
	 */
	public static void extract(ParagraphList paragraphList,
			TextExtractMethod tem, StringBuffer sb) {
		if (paragraphList != null) {
			extract(paragraphList.getParagraphList(), tem, sb);
		}
	}

	/**
	 * 문단 리스트에서 텍스트를 추출한다.
	 * 
	 * @param paragraphList
	 *            문단 리스트
	 * @param tem
	 *            텍스트 추출 방법
	 * @param sb
	 *            추출된 텍스트를 저정할 StringBuffer 객체
	 */
	public static void extract(ArrayList<Paragraph> paragraphList,
			TextExtractMethod tem, StringBuffer sb) {
		if (paragraphList == null) {
			return;
		}
		for (Paragraph p : paragraphList) {
			paragraph(p, tem, sb);
		}
	}

	/**
	 * 문단의 텍스트를 추출한다.
	 * 
	 * @param p
	 *            문단
	 * @param tem
	 *            텍스트 추출 방법
	 * @param sb
	 *            추출된 텍스트를 저정할 StringBuffer 객체
	 */
	private static void paragraph(Paragraph p, TextExtractMethod tem,
			StringBuffer sb) {
		ParaText pt = p.getText();
		if (pt != null) {
			int controlIndex = 0;
			for (HWPChar ch : pt.getCharList()) {
				switch (ch.getType()) {
				case Normal:
					normalText(ch, sb);
					break;
				case ControlExtend:
					if (tem == TextExtractMethod.InsertControlTextBetweenParagraphText) {
						sb.append("\n");
						ForControl.extract(
								p.getControlList().get(controlIndex), tem, sb);
						controlIndex++;
					}
				}
			}
			sb.append("\n");
		}
		if (tem == TextExtractMethod.AppendControlTextAfterParagraphText) {
			controls(p.getControlList(), tem, sb);
		}
	}

	/**
	 * 일반 문자에서 문자를 추출한다.
	 * 
	 * @param ch
	 *            한글 문자
	 * @param sb
	 *            추출된 텍스트를 저정할 StringBuffer 객체
	 */
	private static void normalText(HWPChar ch, StringBuffer sb) {
		sb.append(((HWPCharNormal) ch).getCh());
	}

	/**
	 * 컨트롤 리스트에 포함된 컨트롤에서 텍스트를 추출한다.
	 * 
	 * @param controlList
	 *            컨트롤 리스트
	 * @param tem
	 *            텍스트 추출 방법
	 * @param sb
	 *            추출된 텍스트를 저정할 StringBuffer 객체
	 */
	private static void controls(ArrayList<Control> controlList,
			TextExtractMethod tem, StringBuffer sb) {
		if (controlList != null) {
			for (Control c : controlList) {
				ForControl.extract(c, tem, sb);
			}
		}
	}

}

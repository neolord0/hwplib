package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

import java.util.ArrayList;

/**
 * 문단의 텍스트 레코드
 * 
 * @author neolord
 */
public class ParaText {
	/**
	 * 글자(Character) 리스트
	 */
	private ArrayList<HWPChar> charList;

	/**
	 * 생성자
	 */
	public ParaText() {
		charList = new ArrayList<HWPChar>();
	}

	/**
	 * 새로운 [일반 Character]를 생성하고 리스트에 추가한다.
	 * 
	 * @return 새로 생성된 [일반 Character]
	 */
	public HWPCharNormal addNewNormalChar() {
		HWPCharNormal nc = new HWPCharNormal();
		charList.add(nc);
		return nc;
	}

	/**
	 * 새로운 [문자 컨트롤 Character]를 생성하고 리스트에 추가한다.
	 * 
	 * @return 새로 생성된 [문자 컨트롤 Character]
	 */
	public HWPCharControlChar addNewCharControlChar() {
		HWPCharControlChar ccc = new HWPCharControlChar();
		charList.add(ccc);
		return ccc;
	}

	/**
	 * 새로운 [인라인 컨트롤 Character]를 생성하고 리스트에 추가한다.
	 * 
	 * @return 새로 생성된 [인라인 컨트롤 Character]
	 */
	public HWPCharControlInline addNewInlineControlChar() {
		HWPCharControlInline icc = new HWPCharControlInline();
		charList.add(icc);
		return icc;
	}

	/**
	 * 새로운 [확장 컨트롤 Character]를 생성하고 리스트에 추가한다.
	 * 
	 * @return 새로 생성된 [확장 컨트롤 Character]
	 */
	public HWPCharControlExtend addNewExtendControlChar() {
		HWPCharControlExtend ecc = new HWPCharControlExtend();
		charList.add(ecc);
		return ecc;
	}

	/**
	 * 글자(Character) 리스트를 반환한다.
	 * 
	 * @return 글자(Character) 리스트
	 */
	public ArrayList<HWPChar> getCharList() {
		return charList;
	}
}

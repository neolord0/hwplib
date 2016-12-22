package kr.dogfoot.hwplib.object.bodytext;

import java.util.ArrayList;

import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;

/**
 * 문단 리스트 인터페이스
 * 
 * @author neolord
 */
public interface ParagraphListInterface {
	/**
	 * 새로운 문단를 생성하고 리스트에 추가한다.
	 * 
	 * @return 새로 생성된 문단
	 */
	public Paragraph addNewParagraph();

	/**
	 * 문단 리스트를 반환한다.
	 * 
	 * @return 문단 리스트
	 */
	public ArrayList<Paragraph> getParagraphList();
}

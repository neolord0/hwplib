package kr.dogfoot.hwplib.object.bodytext.paragraph;

import java.util.ArrayList;
import java.util.Iterator;

import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;

/**
 * 문단 리스트를 나타내는 객체
 * 
 * @author neolord
 */
public class ParagraphList implements ParagraphListInterface {
	/**
	 * 문단 리스트
	 */
	private ArrayList<Paragraph> paragraphList;

	/**
	 * 생성자
	 */
	public ParagraphList() {
		paragraphList = new ArrayList<Paragraph>();
	}

	/**
	 * 새로운 문단를 생성하고 리스트에 추가한다.
	 * 
	 * @return 새로 생성된 문단
	 */
	@Override
	public Paragraph addNewParagraph() {
		Paragraph p = new Paragraph();
		paragraphList.add(p);
		return p;
	}

	/**
	 * 문단 개수를 반환한다.
	 * 
	 * @return 문단 개수
	 */
	@Override
	public int getParagraphCount() {
		return paragraphList.size();
	}

	/**
	 * index 번째의 문단을 반환한다.
	 * 
	 * @param index
	 *            찾고자 하는 문단의 순번
	 * @return index 번째의 문단
	 */
	@Override
	public Paragraph getParagraph(int index) {
		return paragraphList.get(index);
	}

	/**
	 * Iterator<Paragraph> 객체를 반환한다.
	 * 
	 * @return Iterator<Paragraph> 객체
	 */
	@Override
	public Iterator<Paragraph> iterator() {
		return paragraphList.iterator();
	}

	/**
	 * 문단 리스트의 일반 문자열을 반환한다.
	 * 
	 * @return 문단 리스트의 일반 문자열
	 */
	public String getNormalString() {
		StringBuffer sb = new StringBuffer();
		for (Paragraph p : paragraphList) {
			sb.append(p.getNormalString());
			sb.append("\n");
		}
		return sb.toString();
	}
}

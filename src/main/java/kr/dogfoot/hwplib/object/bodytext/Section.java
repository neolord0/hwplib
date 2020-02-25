package kr.dogfoot.hwplib.object.bodytext;

import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.BatangPageInfo;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 문단 구역(섹션)를 나타내는 객체. HWP 파일내의 "BodyText" storage 안에 "Section[번호]" stream에
 * 저장된다.
 *
 * @author neolord
 */
public class Section implements ParagraphListInterface {
    /**
     * 문단 리스트
     */
    private ArrayList<Paragraph> paragraphList;
    /**
     * 마지막 바탕쪽 정보
     */
    private BatangPageInfo lastBatangPageInfo;

    /**
     * 생성자
     */
    public Section() {
        paragraphList = new ArrayList<Paragraph>();
        lastBatangPageInfo = null;
    }

    /**
     * 새로운 문단를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 문단
     */
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
    public int getParagraphCount() {
        return paragraphList.size();
    }

    /**
     * index 번째의 문단을 반환한다.
     *
     * @param index 찾고자 하는 문단의 순번
     * @return index 번째의 문단
     */
    public Paragraph getParagraph(int index) {
        return paragraphList.get(index);
    }

    /**
     * Iterator<Paragraph> 객체를 반환한다.
     *
     * @return Iterator<Paragraph> 객체
     */
    public Iterator<Paragraph> iterator() {
        return paragraphList.iterator();
    }

    /**
     * 마지막 바탕쪽 정보 객체를 생성한다.
     */
    public void createLastBatangPageInfo() {
        lastBatangPageInfo = new BatangPageInfo();
    }

    /**
     * 마지막 바탕쪽 정보를 리턴한다.
     *
     * @return 마지막 바탕쪽 정보
     */
    public BatangPageInfo getLastBatangPageInfo() {
        return lastBatangPageInfo;
    }
}

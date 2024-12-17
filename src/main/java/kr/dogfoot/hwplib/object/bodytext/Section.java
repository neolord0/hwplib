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
     * 임의의 바탕쪽 정보
     */
    private BatangPageInfo anyBatangPageInfo;

    /**
     * 생성자
     */
    public Section() {
        paragraphList = new ArrayList<Paragraph>();
        lastBatangPageInfo = null;
        anyBatangPageInfo = null;
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
     * @param index 찾고자 하는 문단의 순번
     * @return index 번째의 문단
     */
    @Override
    public Paragraph getParagraph(int index) {
        return paragraphList.get(index);
    }

    @Override
    public Paragraph[] getParagraphs() {
        return paragraphList.toArray(Paragraph.Zero_Array);
    }

    /**
     * index 번째의 문단을 삭제한다.
     *
     * @param index 삭제할 문단의 순번
     */
    @Override
    public void deleteParagraph(int index) {
        paragraphList.remove(index);
    }

    @Override
    public void deleteAllParagraphs() {
        paragraphList.clear();
    }

    @Override
    public void insertParagraph(int index, Paragraph para) {
        paragraphList.add(index, para);
    }

    @Override
    public Paragraph insertNewParagraph(int index) {
        Paragraph p = new Paragraph();
        paragraphList.add(index, p);
        return p;
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

    public Paragraph getLastParagraph() {
        if (paragraphList.size() > 0) {
            return paragraphList.get(paragraphList.size() - 1);
        }
        return null;
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

    /**
     * 임의의 바탕쪽 정보 객체를 생성한다.
     */
    public void createAnyBatangPageInfo() {
        anyBatangPageInfo = new BatangPageInfo();
    }

    /**
     * 임의의 바탕쪽 정보를 리턴한다.
     *
     * @return 마지막 바탕쪽 정보
     */
    public BatangPageInfo getAnyBatangPageInfo() {
        return anyBatangPageInfo;
    }


    public Section clone() {
        Section cloned = new Section();

        cloned.paragraphList.clear();
        for (Paragraph paragraph : paragraphList) {
            cloned.paragraphList.add(paragraph.clone());
        }

        if (lastBatangPageInfo != null) {
            cloned.lastBatangPageInfo = lastBatangPageInfo.clone();
        } else {
            cloned.lastBatangPageInfo = null;
        }

        if (anyBatangPageInfo != null) {
            cloned.anyBatangPageInfo = anyBatangPageInfo.clone();
        } else {
            cloned.anyBatangPageInfo = null;
        }

        return cloned;
    }
}

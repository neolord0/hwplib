package kr.dogfoot.hwplib.object.bodytext.control.table;

import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;

/**
 * 표의 셀을 나타내는 객체
 *
 * @author neolord
 */
public class Cell {
    /**
     * 문단 리스트 헤더
     */
    private ListHeaderForCell listHeader;
    /**
     * 문단 리스트
     */
    private ParagraphList paragraphList;

    /**
     * 생성자
     */
    public Cell() {
        listHeader = new ListHeaderForCell();
        paragraphList = new ParagraphList();
    }

    /**
     * 문단 리스트 헤더를 반환한다.
     *
     * @return 문단 리스트 헤더
     */
    public ListHeaderForCell getListHeader() {
        return listHeader;
    }

    /**
     * 문단 리스트를 반환한다.
     *
     * @return 문단 리스트
     */
    public ParagraphList getParagraphList() {
        return paragraphList;
    }
}

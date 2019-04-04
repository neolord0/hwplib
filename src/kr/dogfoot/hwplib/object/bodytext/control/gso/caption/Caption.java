package kr.dogfoot.hwplib.object.bodytext.control.gso.caption;

import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;

/**
 * 캡션 정보을 나타내는 객체
 *
 * @author neolord
 */
public class Caption {
    /**
     * 문단 리스트 헤더
     */
    private ListHeaderForCaption listHeader;
    /**
     * 문단 리스트
     */
    private ParagraphList paragraphList;

    /**
     * 생성자
     */
    public Caption() {
        listHeader = new ListHeaderForCaption();
        paragraphList = new ParagraphList();
    }

    /**
     * 문단 리스트 헤더를 반환한다.
     *
     * @return 문단 리스트 헤더
     */
    public ListHeaderForCaption getListHeader() {
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

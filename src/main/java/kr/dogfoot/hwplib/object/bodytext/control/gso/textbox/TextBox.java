package kr.dogfoot.hwplib.object.bodytext.control.gso.textbox;

import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;

/**
 * 글상자을 나타내는 객체
 *
 * @author neolord
 */
public class TextBox {
    /**
     * 문단 리스트 헤더
     */
    private ListHeaderForTextBox listHeader;
    /**
     * 문단 리스트
     */
    private ParagraphList paragraphList;

    /**
     * 생성자
     */
    public TextBox() {
        listHeader = new ListHeaderForTextBox();
        paragraphList = new ParagraphList();
    }

    /**
     * 문단 리스트 헤더 객체를 반환한다.
     *
     * @return 문단 리스트 헤더 객체
     */
    public ListHeaderForTextBox getListHeader() {
        return listHeader;
    }

    /**
     * 문단 리스트 객체를 반환한다.
     *
     * @return 문단 리스트 객체
     */
    public ParagraphList getParagraphList() {
        return paragraphList;
    }

    public void copy(TextBox from) {
        listHeader.copy(from.listHeader);
        paragraphList.copy(from.paragraphList);
    }
}

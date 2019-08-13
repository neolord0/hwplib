package kr.dogfoot.hwplib.object.bodytext.control.hiddencomment;

import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.ListHeaderProperty;

/**
 * 숨은 설명을 위한 문단 리스트 헤더
 *
 * @author neolord
 */
public class ListHeaderForHiddenComment {
    /**
     * 문단 개수
     */
    private int paraCount;
    /**
     * 속성
     */
    private ListHeaderProperty property;

    /**
     * 생성자
     */
    public ListHeaderForHiddenComment() {
        property = new ListHeaderProperty();
    }

    /**
     * 문단 개수를 반환한다.
     *
     * @return 문단 개수
     */
    public int getParaCount() {
        return paraCount;
    }

    /**
     * 문단 개수를 설정한다.
     *
     * @param paraCount 문단 개수
     */
    public void setParaCount(int paraCount) {
        this.paraCount = paraCount;
    }

    /**
     * 속성 객체를 반환한다.
     *
     * @return 속성 객체
     */
    public ListHeaderProperty getProperty() {
        return property;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.headerfooter;

import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.ListHeaderProperty;

/**
 * 머리말/꼬리말을 위한 문단 리스트 헤더 레코드
 *
 * @author neolord
 */
public class ListHeaderForHeaderFooter {
    /**
     * 문단 개수
     */
    private int paraCount;
    /**
     * 속성
     */
    private ListHeaderProperty property;
    /**
     * 텍스트 영역의 폭
     */
    private long textWidth;
    /**
     * 텍스트 영역의 높이
     */
    private long textHeight;

    /**
     * 생성자
     */
    public ListHeaderForHeaderFooter() {
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

    /**
     * 텍스트 영역의 폭을 반환한다.
     *
     * @return 텍스트 영역의 폭
     */
    public long getTextWidth() {
        return textWidth;
    }

    /**
     * 텍스트 영역의 폭을 설정한다.
     *
     * @param textWidth 텍스트 영역의 폭
     */
    public void setTextWidth(long textWidth) {
        this.textWidth = textWidth;
    }

    /**
     * 텍스트 영역의 높이를 반환한다.
     *
     * @return 텍스트 영역의 높이
     */
    public long getTextHeight() {
        return textHeight;
    }

    /**
     * 텍스트 영역의 높이를 설정한다.
     *
     * @param textHeight 텍스트 영역의 높이
     */
    public void setTextHeight(long textHeight) {
        this.textHeight = textHeight;
    }

    public void copy(ListHeaderForHeaderFooter from) {
        paraCount = from.paraCount;
        property.copy(from.property);
        textWidth = from.textWidth;
        textHeight = from.textHeight;
    }
}

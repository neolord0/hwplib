package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.pagehide;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 감추기 컨트롤의 속성을 나타내는 객체
 *
 * @author neolord
 */
public class PageHideHeaderProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public PageHideHeaderProperty() {
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public long getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값을 설정한다.
     *
     * @param value 파일에 저장되는 정수값
     */
    public void setValue(long value) {
        this.value = value;
    }

    /**
     * 머리말 숨김 여부를 반환한다. (0 bit)
     *
     * @return 머리말 숨김 여부
     */
    public boolean isHideHeader() {
        return BitFlag.get(value, 0);
    }

    /**
     * 머리말 숨김 여부를 설정한다. (0 bit)
     *
     * @param hideHeader 머리말 숨김 여부
     */
    public void setHideHeader(boolean hideHeader) {
        value = BitFlag.set(value, 0, hideHeader);
    }

    /**
     * 꼬리말 숨김 여부를 반환한다. (1 bit)
     *
     * @return 꼬리말 숨김 여부
     */
    public boolean isHideFooter() {
        return BitFlag.get(value, 1);
    }

    /**
     * 꼬리말 숨김 여부를 설정한다. (1 bit)
     *
     * @param hideFooter 꼬리말 숨김 여부
     */
    public void setHideFooter(boolean hideFooter) {
        value = BitFlag.set(value, 1, hideFooter);
    }

    /**
     * 바탕 쪽 숨김 여부를 반환한다. (2 bit)
     *
     * @return 바탕 쪽 숨김 여부
     */
    public boolean isHideBatangPage() {
        return BitFlag.get(value, 2);
    }

    /**
     * 바탕 쪽 숨김 여부를 설정한다. (2 bit)
     *
     * @param hideBatangPage 바탕 쪽 숨김 여부
     */
    public void setHideBatangPage(boolean hideBatangPage) {
        value = BitFlag.set(value, 2, hideBatangPage);
    }

    /**
     * 테두리 숨김 여부를 반환하다. (3 bit)
     *
     * @return 테두리 숨김 여부
     */
    public boolean isHideBorder() {
        return BitFlag.get(value, 3);
    }

    /**
     * 테두리 숨김 여부를 설정한다. (3 bit)
     *
     * @param hideBorder 테두리 숨김 여부
     */
    public void setHideBorder(boolean hideBorder) {
        value = BitFlag.set(value, 3, hideBorder);
    }

    /**
     * 페이지 번호 숨김 여부를 반환한다. (4 bit)
     *
     * @return 페이지 번호 숨김 여부
     */
    public boolean isHidePageNumber() {
        return BitFlag.get(value, 4);
    }

    /**
     * 페이지 번호 숨김 여부를 설정한다. (4 bit)
     *
     * @param hidePageNumber 페이지 번호 숨김 여부
     */
    public void setHidePageNumber(boolean hidePageNumber) {
        value = BitFlag.set(value, 4, hidePageNumber);
    }

    public void copy(PageHideHeaderProperty from) {
        value = from.value;
    }
}

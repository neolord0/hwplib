package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.sectiondefine;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 구역 정의 컨트롤의 속성 객체
 *
 * @author neoloed
 */
public class SectionDefineHeaderProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public SectionDefineHeaderProperty() {
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
     * 머리말을 감출지 여부를 반환한다. (0 bit)
     *
     * @return 머리말을 감출지 여부
     */
    public boolean isHideHeader() {
        return BitFlag.get(value, 0);
    }

    /**
     * 머리말을 감출지 여부를 설정한다. (0 bit)
     *
     * @param hideHeader 머리말을 감출지 여부
     */
    public void setHideHeader(boolean hideHeader) {
        value = BitFlag.set(value, 0, hideHeader);
    }

    /**
     * 꼬리말을 감출지 여부를 반환한다. (1 bit)
     *
     * @return 꼬리말을 감출지 여부
     */
    public boolean isHideFooter() {
        return BitFlag.get(value, 1);
    }

    /**
     * 꼬리말을 감출지 여부를 반환한다. (1 bit)
     *
     * @param hideFooter 꼬리말을 감출지 여부
     */
    public void setHideFooter(boolean hideFooter) {
        value = BitFlag.set(value, 1, hideFooter);
    }

    /**
     * 바탕쪽을 감출지 여부를 반환한다. (2 bit)
     *
     * @return 바탕쪽을 감출지 여부
     */
    public boolean isHideBatangPage() {
        return BitFlag.get(value, 2);
    }

    /**
     * 바탕쪽을 감출지 여부를 설정한다. (2 bit)
     *
     * @param hideBatangPage 바탕쪽을 감출지 여부
     */
    public void setHideBatangPage(boolean hideBatangPage) {
        value = BitFlag.set(value, 2, hideBatangPage);
    }

    /**
     * 테두리를 감출지 여부를 반환한다. (3 bit)
     *
     * @return 테두리를 감출지 여부
     */
    public boolean isHideBorder() {
        return BitFlag.get(value, 3);
    }

    /**
     * 테두리를 감출지 여부를 설정한다. (3 bit)
     *
     * @param hideBorder 테두리를 감출지 여부
     */
    public void setHideBorder(boolean hideBorder) {
        value = BitFlag.set(value, 3, hideBorder);
    }

    /**
     * 배경을 감출지 여부를 반환한다. (4 bit)
     *
     * @return 배경을 감출지 여부
     */
    public boolean isHideBackground() {
        return BitFlag.get(value, 4);
    }

    /**
     * 배경을 감출지 여부를 설정한다. (4 bit)
     *
     * @param hideBackground 배경을 감출지 여부
     */
    public void setHideBackground(boolean hideBackground) {
        value = BitFlag.set(value, 4, hideBackground);
    }

    /**
     * 쪽 번호 위치를 감출지 여부를 반환한다. (5 bit)
     *
     * @return 쪽 번호 위치를 감출지 여부
     */
    public boolean isHidePageNumberPosition() {
        return BitFlag.get(value, 5);
    }

    /**
     * 쪽 번호 위치를 감출지 여부를 설정한다. (5 bit)
     *
     * @param hidePageNumberPosition 쪽 번호 위치를 감출지 여부
     */
    public void setHidePageNumberPosition(boolean hidePageNumberPosition) {
        value = BitFlag.set(value, 5, hidePageNumberPosition);
    }

    /**
     * 구역의 첫 쪽에만 테두리 표시 여부를 반환한다. (8 bit)
     *
     * @return 구역의 첫 쪽에만 테두리 표시 여부
     */
    public boolean isDisplayBorderAtFirstPageOfSection() {
        return BitFlag.get(value, 8);
    }

    /**
     * 구역의 첫 쪽에만 테두리 표시 여부를 설정한다. (8 bit)
     *
     * @param displayBorderAtFirstPageOfSection 구역의 첫 쪽에만 테두리 표시 여부
     */
    public void setDisplayBorderAtFirstPageOfSection(
            boolean displayBorderAtFirstPageOfSection) {
        value = BitFlag.set(value, 8, displayBorderAtFirstPageOfSection);
    }

    /**
     * 구역의 첫 쪽에만 배경 표시 여부를 반환한다. (9 bit)
     *
     * @return 구역의 첫 쪽에만 배경 표시 여부
     */
    public boolean isDisplayBackgroundAtFirstPageOfSection() {
        return BitFlag.get(value, 9);
    }

    /**
     * 구역의 첫 쪽에만 배경 표시 여부를 설정한다. (9 bit)
     *
     * @param displayBackgroundAtFirstPageOfSection 구역의 첫 쪽에만 배경 표시 여부
     */
    public void setDisplayBackgroundAtFirstPageOfSection(
            boolean displayBackgroundAtFirstPageOfSection) {
        value = BitFlag.set(value, 9, displayBackgroundAtFirstPageOfSection);
    }

    /**
     * 텍스트 방향을 반환한다. (16~18 bit)
     *
     * @return 텍스트 방향
     */
    public TextDirection getTextDirection() {
        return TextDirection.valueOf((byte) BitFlag.get(value, 16, 18));
    }

    /**
     * 텍스트 방향을 설정한다. (16~18 bit)
     *
     * @param textDirection 텍스트 방향
     */
    public void setTextDirection(TextDirection textDirection) {
        value = BitFlag.set(value, 16, 18, textDirection.getValue());
    }

    /**
     * 빈 줄 감춤 여부를 반환한다. (19 bit)
     *
     * @return 빈 줄 감춤 여부
     */
    public boolean isHideEmptyLine() {
        return BitFlag.get(value, 19);
    }

    /**
     * 빈 줄 감춤 여부를 설정한다. (19 bit)
     *
     * @param hideEmptyLine 빈 줄 감춤 여부
     */
    public void setHideEmptyLine(boolean hideEmptyLine) {
        value = BitFlag.set(value, 19, hideEmptyLine);
    }

    /**
     * 구역 나눔으로 새 페이지가 생길 때의 페이지 번호 적용할지 여부를 반환한다. (20~21 bit)
     *
     * @return 구역 나눔으로 새 페이지가 생길 때의 페이지 번호 적용할지 여부
     */
    public boolean isApplyPageNumberByDivideSection() {
        return BitFlag.get(value, 20) | BitFlag.get(value, 21);
    }

    /**
     * 구역 나눔으로 새 페이지가 생길 때의 페이지 번호 적용할지 여부를 설정한다. (20~21 bit)
     *
     * @param applyPageNumberByDivideSection 구역 나눔으로 새 페이지가 생길 때의 페이지 번호 적용할지 여부
     */
    public void setApplyPageNumberByDivideSection(
            boolean applyPageNumberByDivideSection) {
        value = BitFlag.set(value, 20, applyPageNumberByDivideSection);
        value = BitFlag.set(value, 21, applyPageNumberByDivideSection);
    }

    /**
     * 원고지 정서법 적용 여부를 반환한다. (22 bit)
     *
     * @return 원고지 정서법 적용 여부
     */
    public boolean isApplyWongoji() {
        return BitFlag.get(value, 22);
    }

    /**
     * 원고지 정서법 적용 여부를 설정한다. (22 bit)
     *
     * @param applyWongoji 원고지 정서법 적용 여부
     */
    public void setApplyWongoji(boolean applyWongoji) {
        value = BitFlag.set(value, 22, applyWongoji);
    }

    public void copy(SectionDefineHeaderProperty from) {
        value = from.value;
    }
}

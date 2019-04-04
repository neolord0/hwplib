package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 쪽 테두리/배경 정보의 속성에 대한 객체
 *
 * @author neolord
 */
public class PageBorderFillProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public PageBorderFillProperty() {
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
     * 위치 기준을 반환한다. (0 bit)
     *
     * @return 위치 기준
     */
    public PositionCriterion getPositionCriterion() {
        if (BitFlag.get(value, 0) == true) {
            return PositionCriterion.Paper;
        } else {
            return PositionCriterion.MainText;
        }
    }

    /**
     * 위치 기준을 설정한다. (0 bit)
     *
     * @param positionCriterion
     */
    public void setPositionCriterion(PositionCriterion positionCriterion) {
        if (positionCriterion == PositionCriterion.MainText) {
            value = BitFlag.set(value, 0, false);
        } else if (positionCriterion == PositionCriterion.Paper) {
            value = BitFlag.set(value, 0, true);
        }
    }

    /**
     * 머리말 포홤 여부를 반환한다. (1 bit)
     *
     * @return 머리말 포홤 여부
     */
    public boolean isIncludeHeader() {
        return BitFlag.get(value, 1);
    }

    /**
     * 머리말 포홤 여부를 설정한다. (1 bit)
     *
     * @param includeHeader 머리말 포홤 여부
     */
    public void setIncludeHeader(boolean includeHeader) {
        value = BitFlag.set(value, 1, includeHeader);
    }

    /**
     * 꼬리말 포함 여부를 반환한다. (2 bit)
     *
     * @return 꼬리말 포함 여부
     */
    public boolean isIncludeFooter() {
        return BitFlag.get(value, 2);
    }

    /**
     * 꼬리말 포함 여부를 설정한다. (2 bit)
     *
     * @param includeFooter 꼬리말 포함 여부
     */
    public void setIncludeFooter(boolean includeFooter) {
        value = BitFlag.set(value, 2, includeFooter);
    }

    /**
     * 채워질 영역의 종류를 반환한다. (3~4 bit)
     *
     * @return 채워질 영역의 종류
     */
    public FillArea getFillArea() {
        return FillArea.valueOf((byte) BitFlag.get(value, 3, 4));
    }

    /**
     * 채워질 영역의 종류를 설정한다. (3~4 bit)
     *
     * @param fillArea 채워질 영역의 종류
     */
    public void setFillArea(FillArea fillArea) {
        value = BitFlag.set(value, 3, 4, fillArea.getValue());
    }
}

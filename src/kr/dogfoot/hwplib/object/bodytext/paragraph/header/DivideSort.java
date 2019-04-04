package kr.dogfoot.hwplib.object.bodytext.paragraph.header;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 단 나누기의 종류에 대한 객체
 *
 * @author neolord
 */
public class DivideSort {
    /**
     * 파일에 저장되는 값 (unsigned 1 byte)
     */
    private short value;

    /**
     * 생성자
     */
    public DivideSort() {
    }

    /**
     * 파일에 저장되는 값을 반환한다.
     *
     * @return 파일에 저장되는 값
     */
    public short getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 값을 설정한다.
     *
     * @param value 파일에 저장되는 값
     */
    public void setValue(short value) {
        this.value = value;
    }

    /**
     * 구역 나누기가 적용되었는지 여부를 반환한다. (0 bit)
     *
     * @return 구역 나누기가 적용되었는지 여부
     */
    public boolean isDivideSection() {
        return BitFlag.get(value, 0);
    }

    /**
     * 구역 나누기가 적용되었는지 여부를 설정한다. (0 bit)
     *
     * @param divideSection
     */
    public void setDivideSection(boolean divideSection) {
        value = BitFlag.set(value, 0, divideSection);
    }

    /**
     * 다단 나누기가 적용되었는지 여부를 반환한다. (1 bit)
     *
     * @return 다단 나누기가 적용되었는지 여부
     */
    public boolean isDivideMultiColumn() {
        return BitFlag.get(value, 1);
    }

    /**
     * 다단 나누기가 적용되었는지 여부를 설정한다. (1 bit)
     *
     * @param divideMultiColumn 다단 나누기가 적용되었는지 여부
     */
    public void setDivideMultiColumn(boolean divideMultiColumn) {
        value = BitFlag.set(value, 1, divideMultiColumn);
    }

    /**
     * 쪽 나누기가 적용되었는지 여부를 반환한다. (2 bit)
     *
     * @return 쪽 나누기가 적용되었는지 여부
     */
    public boolean isDividePage() {
        return BitFlag.get(value, 2);
    }

    /**
     * 쪽 나누기가 적용되었는지 여부를 설정한다. (2 bit)
     *
     * @param dividePage 쪽 나누기가 적용되었는지 여부
     */
    public void setDividePage(boolean dividePage) {
        value = BitFlag.set(value, 2, dividePage);
    }

    /**
     * 단 나누기가 적용되었는지 여부를 반환한다. (3 bit)
     *
     * @return 단 나누기가 적용되었는지 여부
     */
    public boolean isDivideColumn() {
        return BitFlag.get(value, 3);
    }

    /**
     * 단 나누기가 적용되었는지 여부를 설정한다. (3 bit)
     *
     * @param divideColumn 단 나누기가 적용되었는지 여부
     */
    public void setDivideColumn(boolean divideColumn) {
        value = BitFlag.set(value, 3, divideColumn);
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.columndefine;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 단 정의 컨트롤의 속성 객체
 *
 * @author neolord
 */
public class ColumnDefineHeaderProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 2 byte)
     */
    private int value;

    /**
     * 생성자
     */
    public ColumnDefineHeaderProperty() {
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public int getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값을 설정한다.
     *
     * @param value 파일에 저장되는 정수값
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 단 종류를 반환한다. (0~1 bit)
     *
     * @return 단 종류
     */
    public ColumnSort getColumnSort() {
        return ColumnSort.valueOf((byte) BitFlag.get(value, 0, 1));
    }

    /**
     * 단 종류를 설정한다. (0~1 bit)
     *
     * @param columnSort 단 종류
     */
    public void setColumnSort(ColumnSort columnSort) {
        value = BitFlag.set(value, 0, 1, columnSort.getValue());
    }

    /**
     * 단 개수를 반환한다. (2~9 bit)
     *
     * @return 단 개수
     */
    public short getColumnCount() {
        return (short) BitFlag.get(value, 2, 9);
    }

    /**
     * 단 개수를 설정한다. (2~9 bit)
     *
     * @param columnCount 단 개수
     */
    public void setColumnCount(short columnCount) {
        value = BitFlag.set(value, 2, 9, columnCount);
    }

    /**
     * 단 방향을 반환한다. (10~11 bit)
     *
     * @return 단 방향
     */
    public ColumnDirection getColumnDirection() {
        return ColumnDirection.valueOf((byte) BitFlag.get(value, 10, 11));
    }

    /**
     * 단 방향을 설정한다. (10~11 bit)
     *
     * @param columnDirection 단 방향
     */
    public void setColumnDirection(ColumnDirection columnDirection) {
        value = BitFlag.set(value, 10, 11, columnDirection.getValue());
    }

    /**
     * 단 너비 동일하게 여부를 반환한다. (12 bit)
     *
     * @return 단 너비 동일하게 여부
     */
    public boolean isSameWidth() {
        return BitFlag.get(value, 12);
    }

    /**
     * 단 너비 동일하게 여부를 설정한다. (12 bit)
     *
     * @param sameWidth 단 너비 동일하게 여부
     */
    public void setSameWidth(boolean sameWidth) {
        value = BitFlag.set(value, 12, sameWidth);
    }
}

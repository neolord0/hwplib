package kr.dogfoot.hwplib.object.bodytext.control.table;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 표의 속성을 나타내는 객체
 *
 * @author neolord
 */
public class TableProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public TableProperty() {
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
     * 쪽 경계에서 나눔 방법를 반환한다. (0~1 bit)
     *
     * @return 쪽 경계에서 나눔 방법
     */
    public DivideAtPageBoundary getDivideAtPageBoundary() {
        return DivideAtPageBoundary.valueOf((byte) BitFlag.get(value, 0, 1));
    }

    /**
     * 쪽 경계에서 나눔 방법을 설정한다. (0~1 bit)
     *
     * @param divideAtPageBoundary 쪽 경계에서 나눔 방법
     */
    public void setDivideAtPageBoundary(
            DivideAtPageBoundary divideAtPageBoundary) {
        value = BitFlag.set(value, 0, 1, divideAtPageBoundary.getValue());
    }

    /**
     * 제목 줄 자동 반복 여부을 반환한다. (2 bit)
     *
     * @return 제목 줄 자동 반복 여부
     */
    public boolean isAutoRepeatTitleRow() {
        return BitFlag.get(value, 2);
    }

    /**
     * 제목 줄 자동 반복 여부를 설정한다. (2 bit)
     *
     * @param autoRepeatTitleRow 제목 줄 자동 반복 여부
     */
    public void setAutoRepeatTitleRow(boolean autoRepeatTitleRow) {
        value = BitFlag.set(value, 2, autoRepeatTitleRow);
    }
}

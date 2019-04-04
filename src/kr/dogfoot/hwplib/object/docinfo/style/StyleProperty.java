package kr.dogfoot.hwplib.object.docinfo.style;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 스타일의 속성 객체
 *
 * @author neolord
 */
public class StyleProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 1 byte)
     */
    private short value;

    /**
     * 생성자
     */
    public StyleProperty() {
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public short getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값을 설정한다.
     *
     * @param value 파일에 저장되는 정수값
     */
    public void setValue(short value) {
        this.value = value;
    }

    /**
     * 스타일 종류를 반환한다. (0~2 bit)
     *
     * @return 스타일 종류
     */
    public StyleSort getStyleSort() {
        return StyleSort.valueOf((byte) BitFlag.get(value, 0, 2));
    }

    /**
     * 스타일 종류를 설정한다. (0~2 bit)
     *
     * @param styleSort 스타일 종류
     */
    public void setStyleSort(StyleSort styleSort) {
        value = BitFlag.set(value, 0, 2, styleSort.getValue());
    }
}

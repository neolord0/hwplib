package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.newnumber;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.autonumber.NumberSort;
import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 새 번호 지정 컨트롤의 속성을 나타내는 객체
 *
 * @author neolord
 */
public class NewNumberHeaderProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public NewNumberHeaderProperty() {
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
     * 번호 종류를 반환한다. (0~3 bit)
     *
     * @return 번호 종류
     */
    public NumberSort getNumberSort() {
        return NumberSort.valueOf((byte) BitFlag.get(value, 0, 3));
    }

    /**
     * 번호 종류를 설정한다. (0~3 bit)
     *
     * @param numberSort 번호 종류
     */
    public void setNumberSort(NumberSort numberSort) {
        value = BitFlag.set(value, 0, 3, numberSort.getValue());
    }
}

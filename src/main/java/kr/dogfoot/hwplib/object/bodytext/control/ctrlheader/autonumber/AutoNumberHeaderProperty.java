package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.autonumber;

import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.NumberShape;
import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 자동번호 컨트롤의 속성 객체
 *
 * @author neolord
 */
public class AutoNumberHeaderProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public AutoNumberHeaderProperty() {
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

    /**
     * 번호 모양을 반환한다. (4~11 bit)
     *
     * @return 번호 모양
     */
    public NumberShape getNumberShape() {
        return NumberShape.valueOf((short) BitFlag.get(value, 4, 11));
    }

    /**
     * 번호 모양을 설정한다. (4~11 bit)
     *
     * @param numberShape 번호 모양
     */
    public void setNumberShape(NumberShape numberShape) {
        value = BitFlag.set(value, 4, 11, numberShape.getValue());
    }

    /**
     * 각주 내용 중 번호 코드의 모양을 윗 첨자 형식으로 할지 여부을 반환한다. (12 bit)
     *
     * @return 각주 내용 중 번호 코드의 모양을 윗 첨자 형식으로 할지 여부
     */
    public boolean isSuperScript() {
        return BitFlag.get(value, 12);
    }

    /**
     * 각주 내용 중 번호 코드의 모양을 윗 첨자 형식으로 할지 여부를 설정한다. (12 bit)
     *
     * @param superScript 각주 내용 중 번호 코드의 모양을 윗 첨자 형식으로 할지 여부
     */
    public void setSuperScript(boolean superScript) {
        value = BitFlag.set(value, 12, superScript);
    }
}

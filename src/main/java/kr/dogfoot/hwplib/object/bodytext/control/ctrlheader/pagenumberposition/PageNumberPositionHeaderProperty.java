package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.pagenumberposition;

import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.NumberShape;
import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 쪽 번호 위치 컨트롤의 속성을 나타내는 객체
 *
 * @author neolord
 */
public class PageNumberPositionHeaderProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public PageNumberPositionHeaderProperty() {
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
     * 번호 모양을 반환한다. (0~7 bit)
     *
     * @return 번호 모양
     */
    public NumberShape getNumberShape() {
        return NumberShape.valueOf((short) BitFlag.get(value, 0, 7));
    }

    /**
     * 번호 모양을 설정한다. (0~7 bit)
     *
     * @param numberShape 번호 모양
     */
    public void setNumberShape(NumberShape numberShape) {
        value = BitFlag.set(value, 0, 7, numberShape.getValue());
    }

    /**
     * 번호의 표시 위치를 반환한다. (8~11 bit)
     *
     * @return 번호의 표시 위치
     */
    public NumberPosition getNumberPosition() {
        return NumberPosition.valueOf((byte) BitFlag.get(value, 8, 11));
    }

    /**
     * 번호의 표시 위치를 설정한다. (8~11 bit)
     *
     * @param numberPosition 번호의 표시 위치
     */
    public void setNumberPosition(NumberPosition numberPosition) {
        value = BitFlag.set(value, 8, 11, numberPosition.getValue());
    }

    public void copy(PageNumberPositionHeaderProperty from) {
        value = from.value;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.gso.caption;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 캡션 정보의 속성을 나태내는 객체
 *
 * @author neolord
 */
public class ListHeaderCaptionProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public ListHeaderCaptionProperty() {
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
     * 캡션 방향을 반환한다. (0~1 bit)
     *
     * @return 캡션 방향
     */
    public CaptionDirection getDirection() {
        return CaptionDirection.valueOf((byte) BitFlag.get(value, 0, 1));
    }

    /**
     * 캡션 방향을 설정한다. (0~1 bit)
     *
     * @param direction 캡션 방향
     */
    public void setDirection(CaptionDirection direction) {
        value = BitFlag.set(value, 0, 1, direction.getValue());
    }

    /**
     * 캡션 폭에 여백을 포함할 것인지 여부를 반환한다. (2 bit)
     *
     * @return 캡션 폭에 여백을 포함할 것인지 여부
     */
    public boolean isIncludeMargin() {
        return BitFlag.get(value, 2);
    }

    /**
     * 캡션 폭에 여백을 포함할 것인지 여부를 설정한다. (2 bit)
     *
     * @param includeMargin 캡션 폭에 여백을 포함할 것인지 여부
     */
    public void setIncludeMargin(boolean includeMargin) {
        value = BitFlag.set(value, 2, includeMargin);
    }
}

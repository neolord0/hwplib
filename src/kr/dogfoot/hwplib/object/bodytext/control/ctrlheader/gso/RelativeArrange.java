package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso;

/**
 * 상대적인 배열 방식
 *
 * @author neolord
 */
public enum RelativeArrange {
    /**
     * VerRelTo이 ‘paper’나 ‘page’ 이면 top, 그렇지 않으면 left
     */
    TopOrLeft((byte) 0),
    /**
     * VerRelTo이 ‘paper’나 ‘page’ 이면 center
     */
    Center((byte) 1),
    /**
     * VerRelTo이 ‘paper’나 ‘page’ 이면 bottom, 그렇지 않으면 right
     */
    BottomOrRight((byte) 2),
    /**
     * VerRelTo이 ‘paper’나 ‘page’ 이면 inside
     */
    Inside((byte) 3),
    /**
     * VerRelTo이 ‘paper’나 ‘page’ 이면 outsides
     */
    Outside((byte) 4);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    RelativeArrange(byte value) {
        this.value = value;
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public byte getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값에 해당되는 enum 값을 반환한다.
     *
     * @param value 파일에 저장되는 정수값
     * @return enum 값
     */
    public static RelativeArrange valueOf(byte value) {
        for (RelativeArrange vrta : values()) {
            if (vrta.value == value) {
                return vrta;
            }
        }
        return TopOrLeft;
    }
}

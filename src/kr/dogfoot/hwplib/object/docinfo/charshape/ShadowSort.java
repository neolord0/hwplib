package kr.dogfoot.hwplib.object.docinfo.charshape;

/**
 * 그림자 종류
 *
 * @author neolord
 */
public enum ShadowSort {
    /**
     * 없음
     */
    None((byte) 0),
    /**
     * 비연속
     */
    Discontinuous((byte) 1),
    /**
     * 연속
     */
    Continuous((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ShadowSort(byte value) {
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
    public static ShadowSort valueOf(byte value) {
        for (ShadowSort ss : values()) {
            if (ss.value == value) {
                return ss;
            }
        }
        return None;
    }
}

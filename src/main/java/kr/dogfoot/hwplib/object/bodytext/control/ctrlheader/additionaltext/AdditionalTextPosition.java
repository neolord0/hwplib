package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.additionaltext;

/**
 * 덧말의 위치
 *
 * @author neolord
 */
public enum AdditionalTextPosition {
    /**
     * 위
     */
    Top((byte) 0),
    /**
     * 아래
     */
    Bottom((byte) 1),
    /**
     * 가운데
     */
    Center((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    AdditionalTextPosition(byte value) {
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
    public static AdditionalTextPosition valueOf(byte value) {
        for (AdditionalTextPosition atp : values()) {
            if (atp.value == value) {
                return atp;
            }
        }
        return Top;
    }
}
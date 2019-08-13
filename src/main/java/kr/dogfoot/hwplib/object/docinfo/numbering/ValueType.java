package kr.dogfoot.hwplib.object.docinfo.numbering;

/**
 * 수준별 본문과의 거리 종류
 *
 * @author neolord
 */
public enum ValueType {
    /**
     * 글자 크기에 대한 상대 비율
     */
    RatioForLetter((byte) 0),
    /**
     * 값
     */
    Value((byte) 1);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ValueType(byte value) {
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
    public static ValueType valueOf(byte value) {
        for (ValueType vt : values()) {
            if (vt.value == value) {
                return vt;
            }
        }
        return RatioForLetter;
    }
}

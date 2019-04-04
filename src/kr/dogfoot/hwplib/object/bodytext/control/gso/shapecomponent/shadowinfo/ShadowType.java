package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.shadowinfo;

/**
 * 그림자 종류
 *
 * @author neolord
 */
public enum ShadowType {
    /**
     * 없음
     */
    None((byte) 0),
    /**
     * 왼쪽 위
     */
    LeftTop((byte) 1),
    /**
     * 오른쪽 위
     */
    RightTop((byte) 2),
    /**
     * 왼쪽 아래
     */
    LeftBottom((byte) 3),
    /**
     * 오른쪽 아래
     */
    RightBottom((byte) 4),
    /**
     * 왼쪽 뒤
     */
    LeftBack((byte) 5),
    /**
     * 오른쪽 뒤
     */
    RightBack((byte) 6),
    /**
     * 왼쪽 앞
     */
    LeftFront((byte) 7),
    /**
     * 오른쪽 앞
     */
    RightFront((byte) 8),
    /**
     * 작게
     */
    Small((byte) 13),
    /**
     * 크게
     */
    Large((byte) 14);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ShadowType(byte value) {
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
    public static ShadowType valueOf(byte value) {
        for (ShadowType st : values()) {
            if (st.value == value) {
                return st;
            }
        }
        return None;
    }
}

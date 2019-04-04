package kr.dogfoot.hwplib.object.docinfo.borderfill;

/**
 * 테두리선 종류
 *
 * @author neolord
 */
public enum BorderType {
    /**
     * 선없음
     */
    None((byte) 0),
    /**
     * 실선
     */
    Solid((byte) 1),
    /**
     * 긴 점선 (쇄선)
     */
    Dash((byte) 2),
    /**
     * 점선
     */
    Dot((byte) 3),
    /**
     * -.-.-.-.(일점 쇄선)
     */
    DashDot((byte) 4),
    /**
     * -..-..-..(이점 쇄선)
     */
    DashDotDot((byte) 5),
    /**
     * Dash보다 긴 선분의 반복
     */
    LongDash((byte) 6),
    /**
     * Dot보다 큰 동그라미의 반복
     */
    CircleDot((byte) 7),
    /**
     * 2중선
     */
    Double((byte) 8),
    /**
     * 가는선 + 굵은선 2중선
     */
    ThinThick((byte) 9),
    /**
     * 굵은선 + 가는선 2중선
     */
    ThickThin((byte) 10),
    /**
     * 가는선 + 굵은선 + 가는선 3중선
     */
    ThinThickThn((byte) 11),
    /**
     * 물결
     */
    Wave((byte) 12),
    /**
     * 물결 2중선
     */
    DoubleWave((byte) 13),
    /**
     * 두꺼운 3D
     */
    Thick3D((byte) 14),
    /**
     * 두꺼운 3D(광원 반대)
     */
    Thick3DReverseLighting((byte) 15),
    /**
     * 3D 단선
     */
    Solid3D((byte) 16),
    /**
     * 3D 단선(광원 반대)
     */
    Solid3DReverseLighting((byte) 17);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    BorderType(byte value) {
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
    public static BorderType valueOf(byte value) {
        for (BorderType bt : values()) {
            if (bt.value == value) {
                return bt;
            }
        }
        return Solid;
    }
}

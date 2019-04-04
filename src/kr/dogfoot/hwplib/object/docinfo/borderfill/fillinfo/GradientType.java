package kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo;

/**
 * 그러데이션 유형
 *
 * @author neolord
 */
public enum GradientType {
    /**
     * 줄무늬형
     */
    Stripe((byte) 1),
    /**
     * 원형
     */
    Circle((byte) 2),
    /**
     * 원뿔형
     */
    Cone((byte) 3),
    /**
     * 사각형
     */
    Square((byte) 4);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    GradientType(byte value) {
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
    public static GradientType valueOf(byte value) {
        for (GradientType gt : values()) {
            if (gt.value == value) {
                return gt;
            }
        }
        return Stripe;
    }
}

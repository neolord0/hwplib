package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo;

/**
 * 선 종류
 *
 * @author neolord
 */
public enum LineType {
    /**
     * 없음
     */
    None((byte) 0),
    /**
     * 실선
     */
    Solid((byte) 1),
    /**
     * 파선(쇄선)
     */
    Dash((byte) 2),
    /**
     * 점선
     */
    Dot((byte) 3),
    /**
     * 일점쇄선
     */
    DashDot((byte) 4),
    /**
     * 이점쇄선
     */
    DashDotDot((byte) 5),
    /**
     * 긴  파선
     */
    LongDash((byte) 6),
    /**
     * 원형 점선
     */
    CircleDot((byte) 7),
    /**
     * 이중선
     */
    Double((byte) 8),
    /**
     * 얋고 굵은 이중선
     */
    ThinBold((byte) 9),
    /**
     * 굵고 얋은 이중선
     */
    BoldThin((byte) 10),
    /**
     * 얋고 굵고 얋은 삼중선
     */
    ThinBoldThin((byte) 11);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    LineType(byte value) {
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
    public static LineType valueOf(byte value) {
        for (LineType bt2 : values()) {
            if (bt2.value == value) {
                return bt2;
            }
        }
        return None;
    }
}

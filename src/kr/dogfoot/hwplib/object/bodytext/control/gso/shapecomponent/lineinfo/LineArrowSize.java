package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo;

/**
 * 화살표 크기 (가로크기-세로크기)
 *
 * @author neolord
 */
public enum LineArrowSize {
    /**
     * 작은-작은
     */
    SmallSmall((byte) 0),
    /**
     * 작은-중간
     */
    SmallMiddle((byte) 1),
    /**
     * 작은-큰
     */
    SmallBig((byte) 2),
    /**
     * 중간-작은
     */
    MiddleSmall((byte) 3),
    /**
     * 중간-중간
     */
    MiddleMiddle((byte) 4),
    /**
     * 중간-큰
     */
    MiddleBig((byte) 5),
    /**
     * 큰-작은
     */
    BigSmall((byte) 6),
    /**
     * 큰-중간
     */
    BigMiddle((byte) 7),
    /**
     * 큰-큰
     */
    BigBig((byte) 8);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    LineArrowSize(byte value) {
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
    public static LineArrowSize valueOf(byte value) {
        for (LineArrowSize las : values()) {
            if (las.value == value) {
                return las;
            }
        }
        return SmallSmall;
    }
}

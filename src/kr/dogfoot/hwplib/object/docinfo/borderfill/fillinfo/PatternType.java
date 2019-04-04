package kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo;

/**
 * 채우기 무늬 종류
 *
 * @author neolord
 */
public enum PatternType {
    /**
     * 단색 (solid)
     */
    None((byte) -1),
    /**
     * 수평선 (- - - -)
     */
    HorizontalLine((byte) 0),
    /**
     * 수직선 (|||||)
     */
    VerticalLine((byte) 1),
    /**
     * 하향 대각선 (\\\\\)
     */
    BackDiagonalLine((byte) 2),
    /**
     * 상향 대각선 (/////)
     */
    FrontDiagonalLine((byte) 3),
    /**
     * 심자선 (+++++)
     */
    CrossLine((byte) 4),
    /**
     * 체크 (xxxxx)
     */
    CrossDiagonalLine((byte) 5);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    PatternType(byte value) {
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
    public static PatternType valueOf(byte value) {
        for (PatternType pt : values()) {
            if (pt.value == value) {
                return pt;
            }
        }
        return None;
    }
}

package kr.dogfoot.hwplib.object.docinfo.charshape;

/**
 * 외곽선 종류
 *
 * @author neolord
 */
public enum OutterLineSort {
    /**
     * 없음
     */
    None((byte) 0),
    /**
     * 실선
     */
    Solid((byte) 1),
    /**
     * 점선
     */
    Dot((byte) 2),
    /**
     * 굵은 실선(두꺼운 선)
     */
    BoldSolid((byte) 3),
    /**
     * 쇄선(긴 점선)
     */
    Dash((byte) 4),
    /**
     * 일점쇄선 (-.-.-.-.)
     */
    DashDot((byte) 5),
    /**
     * 이점쇄선 (-..-..-..)
     */
    DashDotDot((byte) 6);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    OutterLineSort(byte value) {
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
    public static OutterLineSort valueOf(byte value) {
        for (OutterLineSort ols : values()) {
            if (ols.value == value) {
                return ols;
            }
        }
        return None;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso;

/**
 * 오브젝트 폭의 기준
 *
 * @author neolord
 */
public enum WidthCriterion {
    /**
     * 종이
     */
    Paper((byte) 0),
    /**
     * 쪽
     */
    Page((byte) 1),
    /**
     * 단
     */
    Column((byte) 2),
    /**
     * 문단
     */
    Para((byte) 3),
    /**
     * 절대값
     */
    Absolute((byte) 4);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    WidthCriterion(byte value) {
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
    public static WidthCriterion valueOf(byte value) {
        for (WidthCriterion wc : values()) {
            if (wc.value == value) {
                return wc;
            }
        }
        return Paper;
    }
}

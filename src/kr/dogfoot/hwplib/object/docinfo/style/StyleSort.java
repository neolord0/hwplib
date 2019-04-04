package kr.dogfoot.hwplib.object.docinfo.style;

/**
 * 스타일 종류
 *
 * @author neolord
 */
public enum StyleSort {
    /**
     * 문단 스타일
     */
    ParaStyle((byte) 0),
    /**
     * 글자 스타일
     */
    CharStyle((byte) 1);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    StyleSort(byte value) {
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
    public static StyleSort valueOf(byte value) {
        for (StyleSort ss : values()) {
            if (ss.value == value) {
                return ss;
            }
        }
        return ParaStyle;
    }
}

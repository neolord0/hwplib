package kr.dogfoot.hwplib.object.docinfo.parashape;

/**
 * 세로 정렬
 *
 * @author neolord
 */
public enum VerticalAlignment {
    /**
     * 글꼴기준
     */
    ByFont((byte) 0),
    /**
     * 위쪽
     */
    Top((byte) 1),
    /**
     * 가운데
     */
    Center((byte) 2),
    /**
     * 아래
     */
    Bottom((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    VerticalAlignment(byte value) {
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
    public static VerticalAlignment valueOf(byte value) {
        for (VerticalAlignment va : values()) {
            if (va.value == value) {
                return va;
            }
        }
        return ByFont;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.gso.textbox;

/**
 * 텍스트 세로 정렬 방법
 *
 * @author neolord
 */
public enum TextVerticalAlignment {
    /**
     * 위쪽
     */
    Top((byte) 0),
    /**
     * 가운데
     */
    Center((byte) 1),
    /**
     * 아래쪽
     */
    Bottom((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    TextVerticalAlignment(byte value) {
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
    public static TextVerticalAlignment valueOf(byte value) {
        for (TextVerticalAlignment tva : values()) {
            if (tva.value == value) {
                return tva;
            }
        }
        return Top;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo;

/**
 * Outline style
 *
 * @author neolord
 */
public enum OutlineStyle {
    /**
     * 일반
     */
    Normal((byte) 0),
    /**
     * 외부
     */
    Outter((byte) 1),
    /**
     * 내부
     */
    Inner((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    OutlineStyle(byte value) {
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
    public static OutlineStyle valueOf(byte value) {
        for (OutlineStyle os : values()) {
            if (os.value == value) {
                return os;
            }
        }
        return Normal;
    }
}

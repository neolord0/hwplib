package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ole;

/**
 * windows API DVASPECT enumeration
 *
 * @author neolord
 */
public enum DVASPECT {
    /**
     * CONTENT
     */
    CONTENT((byte) 1),
    /**
     * THUMBNAIL
     */
    THUMBNAIL((byte) 2),
    /**
     * ICON
     */
    ICON((byte) 4),
    /**
     * DOCPRINT
     */
    DOCPRINT((byte) 8);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    DVASPECT(byte value) {
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
    public static DVASPECT valueOf(byte value) {
        for (DVASPECT d : values()) {
            if (d.value == value) {
                return d;
            }
        }
        return CONTENT;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ole;

/**
 * OLE 객체 종류
 *
 * @author neolord
 */
public enum ObjectSort {
    /**
     * Unknown
     */
    Unknown((byte) 0),
    /**
     * Embedded
     */
    Embedded((byte) 1),
    /**
     * Link
     */
    Link((byte) 2),
    /**
     * Static
     */
    Static((byte) 3),
    /**
     * Equation
     */
    Equation((byte) 4);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ObjectSort(byte value) {
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
    public static ObjectSort valueOf(byte value) {
        for (ObjectSort os : values()) {
            if (os.value == value) {
                return os;
            }
        }
        return Unknown;
    }
}

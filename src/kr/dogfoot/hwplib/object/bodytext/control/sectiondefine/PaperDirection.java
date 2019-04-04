package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

/**
 * 용지 방향
 *
 * @author neolord
 */
public enum PaperDirection {
    /**
     * 좁게
     */
    Potrait((byte) 0),
    /**
     * 넓게
     */
    Landscape((byte) 1);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    PaperDirection(byte value) {
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
    public static PaperDirection valueOf(byte value) {
        for (PaperDirection pd : values()) {
            if (pd.value == value) {
                return pd;
            }
        }
        return Potrait;
    }
}

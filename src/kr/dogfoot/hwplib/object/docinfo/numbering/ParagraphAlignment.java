package kr.dogfoot.hwplib.object.docinfo.numbering;

/**
 * 문단의 정렬 종류
 *
 * @author neolord
 */
public enum ParagraphAlignment {
    /**
     * 왼쪽
     */
    Left((byte) 0),
    /**
     * 가운데
     */
    Center((byte) 1),
    /**
     * 오른쪽
     */
    Right((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ParagraphAlignment(byte value) {
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
    public static ParagraphAlignment valueOf(byte value) {
        for (ParagraphAlignment pa : values()) {
            if (pa.value == value) {
                return pa;
            }
        }
        return Left;
    }
}

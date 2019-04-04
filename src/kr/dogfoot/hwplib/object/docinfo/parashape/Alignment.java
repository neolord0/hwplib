package kr.dogfoot.hwplib.object.docinfo.parashape;

/**
 * 정렬 방식
 *
 * @author neolord
 */
public enum Alignment {
    /**
     * 양쪽 정렬
     */
    Justify((byte) 0),
    /**
     * 왼쪽 정렬
     */
    Left((byte) 1),
    /**
     * 오른쪽 정렬
     */
    Right((byte) 2),
    /**
     * 가운데 정렬
     */
    Center((byte) 3),
    /**
     * 배분 정렬
     */
    Distribute((byte) 4),
    /**
     * 나눔 정렬
     */
    Divide((byte) 5);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    Alignment(byte value) {
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
    public static Alignment valueOf(byte value) {
        for (Alignment a : values()) {
            if (a.value == value) {
                return a;
            }
        }
        return Justify;
    }
}

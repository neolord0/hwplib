package kr.dogfoot.hwplib.object.docinfo.charshape;

/**
 * 강조점 종류
 *
 * @author neolord
 */
public enum EmphasisSort {
    /**
     * 없음
     */
    None((byte) 0),
    DotAbove((byte) 1),
    RingAbove((byte) 2),
    Tilde((byte) 3),
    Caron((byte) 4),
    Side((byte) 5),
    Colon((byte) 6),
    GraveAccent((byte) 7),
    AcuteAccent((byte) 8),
    Circumflex((byte) 9),
    Macron((byte) 10),
    HookAbove((byte) 11),
    DotBelow((byte) 12);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    EmphasisSort(byte value) {
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
    public static EmphasisSort valueOf(byte value) {
        for (EmphasisSort es : values()) {
            if (es.value == value) {
                return es;
            }
        }
        return None;
    }
}

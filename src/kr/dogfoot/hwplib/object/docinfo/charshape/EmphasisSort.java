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
    /**
     * 검정 동그라미 강조점
     */
    Circle((byte) 1),
    /**
     * 속 빈 동그라미 강조점
     */
    EmptyCircle((byte) 2),
    /**
     * v
     */
    Type3((byte) 3),
    /**
     * "
     */
    Type4((byte) 4),
    /**
     * .
     */
    Type5((byte) 5),
    /**
     * :
     */
    Type6((byte) 6);

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

package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso;

/**
 * 개체가 속하는 번호 범주
 *
 * @author neolord
 */
public enum ObjectNumberSort {
    /**
     * 없음
     */
    None((byte) 0),
    /**
     * 그림
     */
    Figure((byte) 1),
    /**
     * 표
     */
    Table((byte) 2),
    /**
     * 수식
     */
    Equation((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ObjectNumberSort(byte value) {
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
    public static ObjectNumberSort valueOf(byte value) {
        for (ObjectNumberSort ons : values()) {
            if (ons.value == value) {
                return ons;
            }
        }
        return None;
    }
}

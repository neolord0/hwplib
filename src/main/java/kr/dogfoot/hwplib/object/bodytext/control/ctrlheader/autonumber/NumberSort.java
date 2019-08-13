package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.autonumber;

/**
 * 번호 종류
 *
 * @author neolord
 */
public enum NumberSort {
    /**
     * 쪽 번호
     */
    Page((byte) 0),
    /**
     * 각주 번호
     */
    FootNote((byte) 1),
    /**
     * 미주 번호
     */
    EndNote((byte) 2),
    /**
     * 그림 번호
     */
    Picture((byte) 3),
    /**
     * 표 번호
     */
    Table((byte) 4),
    /**
     * 수식 번호
     */
    Equation((byte) 5);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    NumberSort(byte value) {
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
    public static NumberSort valueOf(byte value) {
        for (NumberSort ns : values()) {
            if (ns.value == value) {
                return ns;
            }
        }
        return Page;
    }
}

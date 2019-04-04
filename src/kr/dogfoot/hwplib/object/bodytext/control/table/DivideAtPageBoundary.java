package kr.dogfoot.hwplib.object.bodytext.control.table;

/**
 * 쪽 경계에서 나눔 방법
 *
 * @author neolord
 */
public enum DivideAtPageBoundary {
    /**
     * 나누지 않음
     */
    NoDivide((byte) 0),
    /**
     * 셀 단위로 나눔
     */
    DivideByCell((byte) 1),
    /**
     * 나눔
     */
    Divide((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    DivideAtPageBoundary(byte value) {
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
    public static DivideAtPageBoundary valueOf(byte value) {
        for (DivideAtPageBoundary dapb : values()) {
            if (dapb.value == value) {
                return dapb;
            }
        }
        return NoDivide;
    }
}

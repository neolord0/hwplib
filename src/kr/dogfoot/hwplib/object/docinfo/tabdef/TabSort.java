package kr.dogfoot.hwplib.object.docinfo.tabdef;

/**
 * 탭의 종류
 *
 * @author neolord
 */
public enum TabSort {
    /**
     * 왼쪽
     */
    Left((byte) 0),
    /**
     * 오른쪽
     */
    Right((byte) 1),
    /**
     * 가운데
     */
    Center((byte) 2),
    /**
     * 소수점
     */
    DecimalPoint((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    TabSort(byte value) {
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
    public static TabSort valueOf(byte value) {
        for (TabSort ts : values()) {
            if (ts.value == value) {
                return ts;
            }
        }
        return Left;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.columndefine;

/**
 * 단 종류
 *
 * @author neolord
 */
public enum ColumnSort {
    /**
     * 일반 다단
     */
    Normal((byte) 0),
    /**
     * 배분 다단
     */
    Distribution((byte) 1),
    /**
     * 평행 다단
     */
    Parallel((byte) 1);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ColumnSort(byte value) {
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
    public static ColumnSort valueOf(byte value) {
        for (ColumnSort cs : values()) {
            if (cs.value == value) {
                return cs;
            }
        }
        return Normal;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.columndefine;

/**
 * 단 방향
 *
 * @author neolord
 */
public enum ColumnDirection {
    /**
     * 왼쪽부터
     */
    FromLeft((byte) 0),
    /**
     * 오른쪽부터
     */
    FromRight((byte) 1),
    /**
     * 맞쪽
     */
    Both((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ColumnDirection(byte value) {
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
    public static ColumnDirection valueOf(byte value) {
        for (ColumnDirection cd : values()) {
            if (cd.value == value) {
                return cd;
            }
        }
        return FromLeft;
    }
}

package kr.dogfoot.hwplib.object.docinfo.charshape;

/**
 * 밑줄 종류
 *
 * @author neolord
 */
public enum UnderLineSort {
    /**
     * 없음
     */
    None((byte) 0),
    /**
     * 글자 아래
     */
    Bottom((byte) 1),
    /**
     * 글자 위
     */
    Top((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    UnderLineSort(byte value) {
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
    public static UnderLineSort valueOf(byte value) {
        for (UnderLineSort uls : values()) {
            if (uls.value == value) {
                return uls;
            }
        }
        return None;
    }
}

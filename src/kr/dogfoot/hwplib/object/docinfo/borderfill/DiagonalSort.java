package kr.dogfoot.hwplib.object.docinfo.borderfill;

/**
 * 대각선 종류
 *
 * @author neolord
 */
public enum DiagonalSort {
    /**
     * Slash
     */
    Slash((byte) 0),
    /**
     * BackSlash
     */
    BackSlash((byte) 1),
    /**
     * CrookedSlash
     */
    CrookedSlash((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    DiagonalSort(byte value) {
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
    public static DiagonalSort valueOf(byte value) {
        for (DiagonalSort ds : values()) {
            if (ds.value == value) {
                return ds;
            }
        }
        return Slash;
    }
}

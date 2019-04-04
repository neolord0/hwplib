package kr.dogfoot.hwplib.object.docinfo.borderfill;

/**
 * BackSlash의 대각선 모양
 *
 * @author neolord
 */
public enum BackSlashDiagonalShape {
    /**
     * none
     */
    None((byte) 0),
    /**
     * back slash
     */
    BackSlash((byte) 2),
    /**
     * RightTop --> Bottom Edge
     */
    RightTopToBottomEdge((byte) 3),
    /**
     * RightTop --> Left Edge
     */
    RightTopToLeftEdge((byte) 6),
    /**
     * RightTop --> Bottom & Left Edge
     */
    RightTopToBottomLeftEdge((byte) 7);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    BackSlashDiagonalShape(byte value) {
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
    public static BackSlashDiagonalShape valueOf(byte value) {
        for (BackSlashDiagonalShape bsds : values()) {
            if (bsds.value == value) {
                return bsds;
            }
        }
        return None;
    }
}

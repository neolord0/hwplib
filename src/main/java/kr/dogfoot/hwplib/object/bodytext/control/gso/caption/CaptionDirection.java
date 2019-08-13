package kr.dogfoot.hwplib.object.bodytext.control.gso.caption;

/**
 * 캡션 방향
 *
 * @author neolord
 */
public enum CaptionDirection {
    /**
     * 왼쪽
     */
    Left((byte) 0),
    /**
     * 오른쪽
     */
    Right((byte) 1),
    /**
     * 위쪽
     */
    Top((byte) 2),
    /**
     * 아래쪽
     */
    Bottom((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    CaptionDirection(byte value) {
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
    public static CaptionDirection valueOf(byte value) {
        for (CaptionDirection cd : values()) {
            if (cd.value == value) {
                return cd;
            }
        }
        return Left;
    }
}

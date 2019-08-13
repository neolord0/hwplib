package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso;

/**
 * 오브젝트의 좌/우 어느 쪽에 글을 배치할지 지정하는 옵션
 *
 * @author neolord
 */
public enum TextHorzArrange {
    /**
     * 양쪽
     */
    BothSides((byte) 0),
    /**
     * 왼쪽
     */
    LeftOnly((byte) 1),
    /**
     * 오른쪽
     */
    RightOnly((byte) 2),
    /**
     * 큰 쪽
     */
    LargestOnly((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    TextHorzArrange(byte value) {
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
    public static TextHorzArrange valueOf(byte value) {
        for (TextHorzArrange tha : values()) {
            if (tha.value == value) {
                return tha;
            }
        }
        return BothSides;
    }
}

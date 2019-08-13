package kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo;

/**
 * 그림 효과
 *
 * @author neolord
 */
public enum PictureEffect {
    /**
     * 실제이미지(REAL_PIC)
     */
    RealPicture((byte) 0),
    /**
     * 회색톤 (GRAY_SCALE)
     */
    GrayScale((byte) 1),
    /**
     * 흑백 (BLACK_WHITE)
     */
    BlackWhite((byte) 2),
    /**
     * PATTERN8x8
     */
    Pattern8x8((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    PictureEffect(byte value) {
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
    public static PictureEffect valueOf(byte value) {
        for (PictureEffect pe : values()) {
            if (pe.value == value) {
                return pe;
            }
        }
        return RealPicture;
    }
}

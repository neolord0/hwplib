package kr.dogfoot.hwplib.object.docinfo.facename;

/**
 * 대체 글꼴 유형
 *
 * @author neolord
 */
public enum FontType {
    /**
     * 원래 종류를 알 수 없을 때
     */
    Unknown((byte) 0),
    /**
     * 트루타입 글꼴(TTF)
     */
    TTF((byte) 1),
    /**
     * 한글 전용 글꼴(HFT)
     */
    HFT((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    FontType(byte value) {
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
    public static FontType valueOf(byte value) {
        for (FontType ft : values()) {
            if (ft.value == value) {
                return ft;
            }
        }
        return Unknown;
    }
}

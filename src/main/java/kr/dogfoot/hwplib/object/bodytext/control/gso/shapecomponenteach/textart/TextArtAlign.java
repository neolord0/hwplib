package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.textart;

public enum TextArtAlign {
    LEFT((byte) 0),
    RIGHT((byte) 1),
    CENTER((byte) 2),
    FULL((byte) 3),
    TABLE((byte) 4);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    TextArtAlign(byte value) {
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
    public static TextArtAlign valueOf(byte value) {
        for (TextArtAlign tas : values()) {
            if (tas.value == value) {
                return tas;
            }
        }
        return LEFT;
    }

}

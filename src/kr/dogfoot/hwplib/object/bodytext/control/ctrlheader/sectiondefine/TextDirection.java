package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.sectiondefine;

/**
 * 텍스트 진행방향
 *
 * @author neolord
 */
public enum TextDirection {
    /**
     * 가로
     */
    Horizontal((byte) 0),
    /**
     * 세로(영어 눕힘)
     */
    VerticalWithEnglishLayDown((byte) 1),
    /**
     * 세로(영어 세움)
     */
    VerticalWithEnglishStanding((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    TextDirection(byte value) {
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
    public static TextDirection valueOf(byte value) {
        for (TextDirection td : values()) {
            if (td.value == value) {
                return td;
            }
        }
        return Horizontal;
    }
}

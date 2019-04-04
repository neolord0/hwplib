package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

/**
 * 채워질 영역의 종류
 *
 * @author neolord
 */
public enum FillArea {
    /**
     * 종이
     */
    Paper((byte) 0),
    /**
     * 쪽
     */
    Page((byte) 1),
    /**
     * 테두리
     */
    Border((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    FillArea(byte value) {
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
    public static FillArea valueOf(byte value) {
        for (FillArea fa : values()) {
            if (fa.value == value) {
                return fa;
            }
        }
        return Paper;
    }
}

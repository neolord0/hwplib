package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso;

/**
 * 가로 위치의 기준
 *
 * @author neolord
 */
public enum HorzRelTo {
    /**
     * 종이
     */
    Paper((byte) 0),
    /**
     * 쪽
     */
    Page((byte) 1),
    /**
     * 단
     */
    Column((byte) 2),
    /**
     * 문단
     */
    Para((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    HorzRelTo(byte value) {
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
    public static HorzRelTo valueOf(byte value) {
        for (HorzRelTo hrt : values()) {
            if (hrt.value == value) {
                return hrt;
            }
        }
        return Paper;
    }
}

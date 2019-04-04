package kr.dogfoot.hwplib.object.bodytext.control.gso.textbox;

/**
 * 문단의 줄바꿈 방법
 *
 * @author neolord
 */
public enum LineChange {
    /**
     * 일반적인 줄바꿈
     */
    Normal((byte) 0),
    /**
     * 자간을 조종하여 한 줄을 유지
     */
    KeepOneLineByAdjustWordSpace((byte) 1),
    /**
     * 내용에 따라 폭이 늘어남
     */
    IncreaseWidthByContent((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    LineChange(byte value) {
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
    public static LineChange valueOf(byte value) {
        for (LineChange lc : values()) {
            if (lc.value == value) {
                return lc;
            }
        }
        return Normal;
    }
}

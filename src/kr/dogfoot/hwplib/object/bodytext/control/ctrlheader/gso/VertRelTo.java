package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso;

/**
 * 세로 위치의 기준
 *
 * @author neolord
 */
public enum VertRelTo {
    /**
     * 종이
     */
    Paper((byte) 0),
    /**
     * 쪽
     */
    Page((byte) 1),
    /**
     * 문단
     */
    Para((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    VertRelTo(byte value) {
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
    public static VertRelTo valueOf(byte value) {
        for (VertRelTo vrt : values()) {
            if (vrt.value == value) {
                return vrt;
            }
        }
        return Paper;
    }
}

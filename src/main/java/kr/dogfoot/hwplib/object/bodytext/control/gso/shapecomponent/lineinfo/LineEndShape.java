package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo;

/**
 * 선 끝 모양
 *
 * @author neolord
 */
public enum LineEndShape {
    /**
     * 둥근 선 끝
     */
    Round((byte) 0),
    /**
     * 각진 선 끝
     */
    Flat((byte) 1);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    LineEndShape(byte value) {
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
    public static LineEndShape valueOf(byte value) {
        for (LineEndShape les : values()) {
            if (les.value == value) {
                return les;
            }
        }
        return Round;
    }
}

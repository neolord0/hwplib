package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.curve;

/**
 * 곡선의 Segment Type
 *
 * @author neolord
 */
public enum CurveSegmentType {
    /**
     * line
     */
    Line((byte) 0),
    /**
     * curve
     */
    Curve((byte) 1);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    CurveSegmentType(byte value) {
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
    public static CurveSegmentType valueOf(byte value) {
        for (CurveSegmentType cst : values()) {
            if (cst.value == value) {
                return cst;
            }
        }
        return Line;
    }
}

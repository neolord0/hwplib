package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo;

/**
 * 선 끝에 화살표 모양
 *
 * @author neolord
 */
public enum LineArrowShape {
    /**
     * 모양 없음
     */
    None((byte) 0),
    /**
     * 화살표
     */
    Arrow((byte) 1),
    /**
     * 선형 화살표
     */
    LinedArrow((byte) 2),
    /**
     * 오목한 화살표
     */
    ConcaveArrow((byte) 3),
    /**
     * 속이 빈 다이아몬드 모양
     */
    Diamond((byte) 4),
    /**
     * 속이 빈 원 모양
     */
    Circle((byte) 5),
    /**
     * 속이 빈 사각형 모양
     */
    Rectangle((byte) 6);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    LineArrowShape(byte value) {
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
    public static LineArrowShape valueOf(byte value) {
        for (LineArrowShape las : values()) {
            if (las.value == value) {
                return las;
            }
        }
        return None;
    }
}

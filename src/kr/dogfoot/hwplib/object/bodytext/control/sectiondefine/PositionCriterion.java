package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

/**
 * 위치 기준
 *
 * @author neolord
 */
public enum PositionCriterion {
    /**
     * 본문 기준
     */
    MainText((byte) 0),
    /**
     * 종이 기준
     */
    Paper((byte) 1);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    PositionCriterion(byte value) {
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
    public static PositionCriterion valueOf(byte value) {
        for (PositionCriterion pc : values()) {
            if (pc.value == value) {
                return pc;
            }
        }
        return MainText;
    }
}

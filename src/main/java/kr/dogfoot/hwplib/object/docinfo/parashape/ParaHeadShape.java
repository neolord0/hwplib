package kr.dogfoot.hwplib.object.docinfo.parashape;

/**
 * 문단 머리 모양의 종류
 *
 * @author neolord
 */
public enum ParaHeadShape {
    /**
     * 없음
     */
    None((byte) 0),
    /**
     * 개요
     */
    Outline((byte) 1),
    /**
     * 번호
     */
    Numbering((byte) 2),
    /**
     * 글머리표(bullet)
     */
    Bullet((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ParaHeadShape(byte value) {
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
    public static ParaHeadShape valueOf(byte value) {
        for (ParaHeadShape phs : values()) {
            if (phs.value == value) {
                return phs;
            }
        }
        return None;
    }
}
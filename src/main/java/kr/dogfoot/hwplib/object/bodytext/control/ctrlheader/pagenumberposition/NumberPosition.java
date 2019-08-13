package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.pagenumberposition;

/**
 * 번호의 표시 위치
 *
 * @author neolord
 */
public enum NumberPosition {
    /**
     * 쪽 번호 없음
     */
    None((byte) 0),
    /**
     * 왼쪽 위
     */
    LeftTop((byte) 1),
    /**
     * 가운데 위
     */
    CenterTop((byte) 2),
    /**
     * 오른쪽 위
     */
    RightTop((byte) 3),
    /**
     * 왼쪽 아래
     */
    LeftBottom((byte) 4),
    /**
     * 가운데 아래
     */
    CenterBottom((byte) 5),
    /**
     * 오른쪽 아래
     */
    RightBottom((byte) 6),
    /**
     * 바깥쪽 위
     */
    OutsideTop((byte) 7),
    /**
     * 바깥쪽 아래
     */
    OutsideBottom((byte) 8),
    /**
     * 안쪽 위
     */
    InsideTop((byte) 9),
    /**
     * 안쪽 아래
     */
    InsideBottom((byte) 10);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    NumberPosition(byte value) {
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
    public static NumberPosition valueOf(byte value) {
        for (NumberPosition np : values()) {
            if (np.value == value) {
                return np;
            }
        }
        return None;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

/**
 * 번호매김 방법
 *
 * @author neolord
 */
public enum NumberingMethod {
    /**
     * 앞 구역에 이어서
     */
    Continue((byte) 0),
    /**
     * 현재 구역부터 새로 시작
     */
    Restart((byte) 1),
    /**
     * 쪽마다 새로 시작(각주 전용)
     */
    RestartAtEachPage((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    NumberingMethod(byte value) {
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
    public static NumberingMethod valueOf(byte value) {
        for (NumberingMethod nm : values()) {
            if (nm.value == value) {
                return nm;
            }
        }
        return Continue;
    }
}

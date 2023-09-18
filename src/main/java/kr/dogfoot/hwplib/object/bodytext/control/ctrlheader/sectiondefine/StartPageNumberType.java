package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.sectiondefine;

/**
 * 사작 쪽번호 타입
 */
public enum StartPageNumberType {
    /**
     * 이어서
     */
    Continue((byte) 0),
    /**
     * 짝수
     */
    Even((byte) 1),
    /**
     * 홀수
     */
    Odd((byte) 2),
    /**
     * 사용자 정의
     */
    Custom((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    StartPageNumberType(byte value) {
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
    public static StartPageNumberType valueOf(byte value) {
        for (StartPageNumberType spnt : values()) {
            if (spnt.value == value) {
                return spnt;
            }
        }
        return Continue;
    }
}

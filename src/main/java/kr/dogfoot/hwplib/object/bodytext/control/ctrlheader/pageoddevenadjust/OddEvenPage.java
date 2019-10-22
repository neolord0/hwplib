package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.pageoddevenadjust;

public enum OddEvenPage {
    /**
     * 양쪽
     */
    Both((byte) 0),
    /**
     * 짝수
     */
    Even((byte) 1),
    /**
     * 홀수
     */
    Odd((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    OddEvenPage(byte value) {
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
    public static OddEvenPage valueOf(byte value) {
        for (OddEvenPage oep : values()) {
            if (oep.value == value) {
                return oep;
            }
        }
        return Both;
    }
}

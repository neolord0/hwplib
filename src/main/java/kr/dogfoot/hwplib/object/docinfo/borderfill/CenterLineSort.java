package kr.dogfoot.hwplib.object.docinfo.borderfill;

public enum CenterLineSort {
    /**
     * 선없음
     */
    None((byte) 0),
    /**
     * 수평선
     */
    Horizontal((byte) 1),
    /**
     * 수직선
     */
    Vertical((byte) 2),
    /**
     * 교차
     */
    Cross((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    CenterLineSort(byte value) {
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
    public static CenterLineSort valueOf(byte value) {
        for (CenterLineSort bt : values()) {
            if (bt.value == value) {
                return bt;
            }
        }
        return None;
    }
}

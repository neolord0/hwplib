package kr.dogfoot.hwplib.object.docinfo.parashape;

/**
 * 줄 간격 종류(한글 2007이하 버전에만 사용)
 *
 * @author neolord
 */
public enum LineSpaceSort {
    /**
     * 글자에 따라(%)
     */
    RatioForLetter((byte) 0),
    /**
     * 고정값
     */
    FixedValue((byte) 1),
    /**
     * 여백만 지정
     */
    OnlyMargin((byte) 2),
    /**
     * 최소
     */
    Minimum((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    LineSpaceSort(byte value) {
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
    public static LineSpaceSort valueOf(byte value) {
        for (LineSpaceSort lss : values()) {
            if (lss.value == value) {
                return lss;
            }
        }
        return RatioForLetter;
    }
}

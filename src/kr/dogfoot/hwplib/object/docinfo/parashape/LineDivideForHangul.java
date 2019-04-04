package kr.dogfoot.hwplib.object.docinfo.parashape;

/**
 * 줄 나눔 기준 한글 단위
 *
 * @author neolord
 */
public enum LineDivideForHangul {
    /**
     * 어절
     */
    ByWord((byte) 0),
    /**
     * 글자
     */
    ByLetter((byte) 1);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    LineDivideForHangul(byte value) {
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
    public static LineDivideForHangul valueOf(byte value) {
        for (LineDivideForHangul ldh : values()) {
            if (ldh.value == value) {
                return ldh;
            }
        }
        return ByWord;
    }
}

package kr.dogfoot.hwplib.object.docinfo.parashape;

/**
 * 줄 나눔 기준 영어 단위
 *
 * @author neolord
 */
public enum LineDivideForEnglish {
    /**
     * 단어
     */
    ByWord((byte) 0),
    /**
     * 하이픈
     */
    ByHypen((byte) 1),
    /**
     * 글자
     */
    ByLetter((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    LineDivideForEnglish(byte value) {
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
    public static LineDivideForEnglish valueOf(byte value) {
        for (LineDivideForEnglish lde : values()) {
            if (lde.value == value) {
                return lde;
            }
        }
        return ByWord;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

/**
 * 미주를 위치시킬 방법
 *
 * @author neolord
 */
public enum EndNoteDisplayMethod {
    /**
     * 문서의 마지막
     */
    DocumentEnd((byte) 0),
    /**
     * 구역의 마지막
     */
    SectionEnd((byte) 1);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    EndNoteDisplayMethod(byte value) {
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
    public static EndNoteDisplayMethod valueOf(byte value) {
        for (EndNoteDisplayMethod endm : values()) {
            if (endm.value == value) {
                return endm;
            }
        }
        return DocumentEnd;
    }
}

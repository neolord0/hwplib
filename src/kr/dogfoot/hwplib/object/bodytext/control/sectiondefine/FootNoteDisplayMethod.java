package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

/**
 * 한 페이지 내에서 각주를 다단에 위치시킬 방법
 *
 * @author neolord
 */
public enum FootNoteDisplayMethod {
    /**
     * 각 단마다 따로 배열
     */
    EachColumn((byte) 0),
    /**
     * 통단으로 배열
     */
    AllColumn((byte) 1),
    /**
     * 가장 오른쪽 단에 배열
     */
    RightColumn((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    FootNoteDisplayMethod(byte value) {
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
    public static FootNoteDisplayMethod valueOf(byte value) {
        for (FootNoteDisplayMethod fndm : values()) {
            if (fndm.value == value) {
                return fndm;
            }
        }
        return EachColumn;
    }
}

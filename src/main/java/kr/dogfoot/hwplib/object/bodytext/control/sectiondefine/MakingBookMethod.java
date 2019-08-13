package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

/**
 * 제책 방법
 *
 * @author neolord
 */
public enum MakingBookMethod {
    /**
     * 한쪽 편집
     */
    OneSideEditing((byte) 0),
    /**
     * 맞쪽 편집
     */
    BothSideEditing((byte) 1),
    /**
     * 위로 넘기기
     */
    BackFlip((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    MakingBookMethod(byte value) {
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
    public static MakingBookMethod valueOf(byte value) {
        for (MakingBookMethod mbm : values()) {
            if (mbm.value == value) {
                return mbm;
            }
        }
        return OneSideEditing;
    }
}

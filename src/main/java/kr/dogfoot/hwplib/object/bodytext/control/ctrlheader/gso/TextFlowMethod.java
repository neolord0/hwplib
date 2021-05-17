package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso;

/**
 * 오브젝트 주위를 텍스트가 어떻게 흘러갈지 지정하는 옵션
 *
 * @author neolord
 */
public enum TextFlowMethod {
    /**
     * 어울림
     */
    FitWithText((byte) 0),
    /**
     * 자리 차치
     */
    TakePlace((byte)1),
    /**
     * 글 뒤로
     */
    BehindText((byte) 2),
    /**
     * 글 앞으로
     */
    InFrontOfText((byte) 3);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    TextFlowMethod(byte value) {
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
    public static TextFlowMethod valueOf(byte value) {
        for (TextFlowMethod tfm : values()) {
            if (tfm.value == value) {
                return tfm;
            }
        }
        return FitWithText;
    }
}

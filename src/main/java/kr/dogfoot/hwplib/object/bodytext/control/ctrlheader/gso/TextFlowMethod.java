package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso;

/**
 * 오브젝트 주위를 텍스트가 어떻게 흘러갈지 지정하는 옵션
 *
 * @author neolord
 */
public enum TextFlowMethod {
    /**
     * bound rect를 따라
     */
    Square((byte) 0),
    /**
     * 오브젝트의 outline을 따라
     */
    Tight((byte) 1),
    /**
     * 오브젝트 내부의 빈 공간까지
     */
    Through((byte) 2),
    /**
     * 좌, 우에는 텍스트를 배치하지 않음
     */
    TopAndBottom((byte) 3),
    /**
     * 글과 겹치게 하여 글 뒤로
     */
    BehindText((byte) 4),
    /**
     * 글과 겹치게 하여 글 앞으로
     */
    InFrontOfText((byte) 5);

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
        return Square;
    }
}

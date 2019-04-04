package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.header;

/**
 * 머리글/꼬리글 적용 페이지 종류
 *
 * @author neolord
 */
public enum HeaderFooterApplyPage {
    /**
     * 양 쪽
     */
    BothPage((byte) 0),
    /**
     * 짝수 쪽만
     */
    EvenPage((byte) 1),
    /**
     * 홀수 족만
     */
    OddPage((byte) 2);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    HeaderFooterApplyPage(byte value) {
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
    public static HeaderFooterApplyPage valueOf(byte value) {
        for (HeaderFooterApplyPage ap : values()) {
            if (ap.value == value) {
                return ap;
            }
        }
        return BothPage;
    }
}

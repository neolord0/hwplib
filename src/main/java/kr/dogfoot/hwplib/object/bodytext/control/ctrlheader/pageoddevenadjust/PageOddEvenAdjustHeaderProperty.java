package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.pageoddevenadjust;


import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 홀/짝수 조정(페이지 번호 제어) 컨트롤의 속성을 나타내는 객체
 *
 * @author neolord
 */
public class PageOddEvenAdjustHeaderProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public PageOddEvenAdjustHeaderProperty() {
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public long getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값을 설정한다.
     *
     * @param value 파일에 저장되는 정수값
     */
    public void setValue(long value) {
        this.value = value;
    }

    /**
     * 홀/짝수 구분을 반환한다. (0~1 bit)
     *
     * @return 홀/짝수 구분
     */
    public OddEvenPage getOldEvenPage() {
        return OddEvenPage.valueOf((byte) BitFlag.get(value, 0, 1));
    }

    /**
     * 홀/짝수 구분를 설정한다. (0~1 bit)
     *
     * @param oldEvenPage 홀/짝수 구분
     */
    public void setOldEvenPage(OddEvenPage oldEvenPage) {
        value = BitFlag.set(value, 0, 1, oldEvenPage.getValue());
    }

    public void copy(PageOddEvenAdjustHeaderProperty from) {
        value = from.value;
    }
}

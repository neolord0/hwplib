package kr.dogfoot.hwplib.object.docinfo.tabdef;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 탭 정의의 속성 객체
 *
 * @author neolord
 */
public class TabDefProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public TabDefProperty() {
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
     * 문단 왼쪽 끝 자동 탭(내어 쓰기용 자동 탭) 유무를 반환한다. (0 bit)
     *
     * @return 문단 왼쪽 끝 자동 탭(내어 쓰기용 자동 탭) 유무
     */
    public boolean isAutoTabAtParagraphLeftEnd() {
        return BitFlag.get(value, 0);
    }

    /**
     * 문단 왼쪽 끝 자동 탭(내어 쓰기용 자동 탭) 유무를 설정한다. (0 bit)
     *
     * @param autoTabAtParagraphLeftEnd 문단 왼쪽 끝 자동 탭(내어 쓰기용 자동 탭) 유무
     */
    public void setAutoTabAtParagraphLeftEnd(boolean autoTabAtParagraphLeftEnd) {
        value = BitFlag.set(value, 0, autoTabAtParagraphLeftEnd);
    }

    /**
     * 문단 오른쪽 끝 자동 탭 유무를 반환한다. (1 bit)
     *
     * @return 문단 오른쪽 끝 자동 탭 유무
     */
    public boolean isAutoTabAtParagraphRightEnd() {
        return BitFlag.get(value, 1);
    }

    /**
     * 문단 오른쪽 끝 자동 탭 유무를 설정한다. (1 bit)
     *
     * @param autoTabAtParagraphRightEnd 문단 오른쪽 끝 자동 탭 유무
     */
    public void setAutoTabAtParagraphRightEnd(boolean autoTabAtParagraphRightEnd) {
        value = BitFlag.set(value, 1, autoTabAtParagraphRightEnd);
    }

    public void copy(TabDefProperty from) {
        value = from.value;
    }
}

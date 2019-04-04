package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;

/**
 * 찾아보기 표식 컨트롤을 위한 컨트롤 헤더 레코드
 *
 * @author neolord
 */
public class CtrlHeaderIndexMark extends CtrlHeader {
    /**
     * 키워드 1
     */
    private String keyword1;
    /**
     * 키워드 2
     */
    private String keyword2;

    /**
     * 생성자
     */
    public CtrlHeaderIndexMark() {
        super(ControlType.IndexMark.getCtrlId());
    }

    /**
     * 키워드 1을 반환한다.
     *
     * @return 키워드 1
     */
    public String getKeyword1() {
        return keyword1;
    }

    /**
     * 키워드 1를 설정한다.
     *
     * @param keyword1 키워드 1
     */
    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }

    /**
     * 키워드 2을 반환한다.
     *
     * @return 키워드 2
     */
    public String getKeyword2() {
        return keyword2;
    }

    /**
     * 키워드 2을 설정한다.
     *
     * @param keyword2 키워드 2
     */
    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2;
    }
}

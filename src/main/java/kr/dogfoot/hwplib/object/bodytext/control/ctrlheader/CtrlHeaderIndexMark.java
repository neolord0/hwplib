package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.etc.HWPString;

/**
 * 찾아보기 표식 컨트롤을 위한 컨트롤 헤더 레코드
 *
 * @author neolord
 */
public class CtrlHeaderIndexMark extends CtrlHeader {
    /**
     * 키워드 1
     */
    private HWPString keyword1;
    /**
     * 키워드 2
     */
    private HWPString keyword2;

    /**
     * 생성자
     */
    public CtrlHeaderIndexMark() {
        super(ControlType.IndexMark.getCtrlId());
        keyword1 = new HWPString();
        keyword2 = new HWPString();
    }

    /**
     * 키워드 1을 반환한다.
     *
     * @return 키워드 1
     */
    public HWPString getKeyword1() {
        return keyword1;
    }

    /**
     * 키워드 2을 반환한다.
     *
     * @return 키워드 2
     */
    public HWPString getKeyword2() {
        return keyword2;
    }

    @Override
    public void copy(CtrlHeader from) {
        CtrlHeaderIndexMark from2 = (CtrlHeaderIndexMark) from;
        keyword1.copy(from2.keyword1);
        keyword2.copy(from2.keyword2);
    }
}

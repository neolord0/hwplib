package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.pageoddevenadjust.PageOddEvenAdjustHeaderProperty;

/**
 * 홀/짝수 조정(페이지 번호 제어) 컨트롤을 위한 컨트롤 헤더 레코드
 *
 * @author neolord
 */
public class CtrlHeaderPageOddEvenAdjust extends CtrlHeader {
    /**
     * 속성
     */
    private PageOddEvenAdjustHeaderProperty property;

    /**
     * 생성자
     */
    public CtrlHeaderPageOddEvenAdjust() {
        super(ControlType.PageOddEvenAdjust.getCtrlId());

        property = new PageOddEvenAdjustHeaderProperty();
    }

    /**
     * 홀/짝수 조정(페이지 번호 제어) 컨트롤의 속성 객체를 반환한다.
     *
     * @return 홀/짝수 조정(페이지 번호 제어) 컨트롤의 속성 객체
     */
    public PageOddEvenAdjustHeaderProperty getProperty() {
        return property;
    }

    public void copy(CtrlHeaderPageOddEvenAdjust from) {
        property.copy(from.property);
    }

    @Override
    public void copy(CtrlHeader from) {
        CtrlHeaderPageOddEvenAdjust from2 = (CtrlHeaderPageOddEvenAdjust) from;
        property.copy(from2.property);
    }
}

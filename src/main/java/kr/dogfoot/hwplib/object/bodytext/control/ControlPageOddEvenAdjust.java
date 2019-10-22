package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderPageOddEvenAdjust;

/**
 *
 */
public class ControlPageOddEvenAdjust extends Control {
    /**
     * 생성자
     */
    public ControlPageOddEvenAdjust() {
        super(new CtrlHeaderPageOddEvenAdjust());
    }

    /**
     * 홀/짝수 조정(페이지 번호 제어) 컨트롤 용 컨트롤 헤더를 반환한다.
     *
     * @return 홀/짝수 조정(페이지 번호 제어) 컨트롤 헤더
     */
    public CtrlHeaderPageOddEvenAdjust getHeader() {
        return (CtrlHeaderPageOddEvenAdjust) header;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderAutoNumber;

/**
 * 자동번호 컨트롤에 대한 객체
 *
 * @author neolord
 */
public class ControlAutoNumber extends Control {
    /**
     * 생성자
     */
    public ControlAutoNumber() {
        super(new CtrlHeaderAutoNumber());
    }

    /**
     * 자동번호 컨트롤용 컨트롤 헤더를 반환한다.
     *
     * @return 자동번호 컨트롤용 컨트롤 헤더
     */
    public CtrlHeaderAutoNumber getHeader() {
        return (CtrlHeaderAutoNumber) header;
    }
}

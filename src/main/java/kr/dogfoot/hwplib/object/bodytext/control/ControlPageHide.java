package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderPageHide;

/**
 * 감추기 컨트롤
 *
 * @author neolord
 */
public class ControlPageHide extends Control {
    /**
     * 생성자
     */
    public ControlPageHide() {
        super(new CtrlHeaderPageHide());
    }

    /**
     * 감추기 컨트롤 용 컨트롤 헤더를 반환한다.
     *
     * @return 감추기 컨트롤 용 컨트롤 헤더
     */
    public CtrlHeaderPageHide getHeader() {
        return (CtrlHeaderPageHide) header;
    }

    @Override
    public Control clone() {
        ControlPageHide cloned = new ControlPageHide();
        cloned.copyControlPart(this);
        return cloned;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderColumnDefine;

/**
 * 단 정의 컨트롤에 대한 객체
 *
 * @author neolord
 */
public class ControlColumnDefine extends Control {
    /**
     * 생상자
     */
    public ControlColumnDefine() {
        super(new CtrlHeaderColumnDefine());
    }

    /**
     * 단 정의용 컨트롤 헤더를 반환한다.
     *
     * @return 단 정의용 컨트롤 헤더
     */
    public CtrlHeaderColumnDefine getHeader() {
        return (CtrlHeaderColumnDefine) header;
    }

    @Override
    public Control clone() {
        ControlColumnDefine cloned = new ControlColumnDefine();
        cloned.copyControlPart(this);
        return cloned;
    }
}

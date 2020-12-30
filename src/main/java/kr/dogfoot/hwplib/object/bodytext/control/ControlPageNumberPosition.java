package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderPageNumberPosition;

/**
 * 쪽 번호 위치 컨트롤
 *
 * @author neolord
 */
public class ControlPageNumberPosition extends Control {
    /**
     * 생성자
     */
    public ControlPageNumberPosition() {
        super(new CtrlHeaderPageNumberPosition());
    }

    /**
     * 쪽 번호 위치 컨트롤 용 컨트롤 헤더를 반환한다.
     *
     * @return 쪽 번호 위치 컨트롤 용 컨트롤 헤더
     */
    public CtrlHeaderPageNumberPosition getHeader() {
        return (CtrlHeaderPageNumberPosition) header;
    }

    @Override
    public Control clone() {
        ControlPageNumberPosition cloned = new ControlPageNumberPosition();
        cloned.copyControlPart(this);
        return cloned;
    }
}

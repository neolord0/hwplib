package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderBookmark;

/**
 * 책갈피 컨트롤에 대한 객체
 *
 * @author neolord
 */
public class ControlBookmark extends Control {
    /**
     * 생성자
     */
    public ControlBookmark() {
        super(new CtrlHeaderBookmark());
    }

    /**
     * 책갈피용 컨트롤 헤더를 반환한다.
     *
     * @return 책갈피용 컨트롤 헤더
     */
    public CtrlHeaderBookmark getHeader() {
        return (CtrlHeaderBookmark) header;
    }

    @Override
    public Control clone() {
        ControlBookmark cloned = new ControlBookmark();
        cloned.copyControlPart(this);
        return cloned;
    }
}

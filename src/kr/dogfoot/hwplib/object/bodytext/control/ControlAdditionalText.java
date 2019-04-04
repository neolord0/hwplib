package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderAdditionalText;

/**
 * 덧말 컨트롤
 *
 * @author neolord
 */
public class ControlAdditionalText extends Control {
    /**
     * 생성자
     */
    public ControlAdditionalText() {
        super(new CtrlHeaderAdditionalText());
    }

    /**
     * 덧말 용 컨트롤 헤더를 반환한다.
     *
     * @return 덧말 용 컨트롤 헤더
     */
    public CtrlHeaderAdditionalText getHeader() {
        return (CtrlHeaderAdditionalText) header;
    }
}

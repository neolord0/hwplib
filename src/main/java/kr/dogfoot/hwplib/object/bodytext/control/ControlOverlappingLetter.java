package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderOverlappingLetter;

/**
 * 글자 겹침 컨트롤
 *
 * @author neolord
 */
public class ControlOverlappingLetter extends Control {
    /**
     * 생성자
     */
    public ControlOverlappingLetter() {
        super(new CtrlHeaderOverlappingLetter());
    }

    /**
     * 글자 겹침 용 컨트롤 헤더를 반환한다.
     *
     * @return 글자 겹침 용 컨트롤 헤더
     */
    public CtrlHeaderOverlappingLetter getHeader() {
        return (CtrlHeaderOverlappingLetter) header;
    }
}

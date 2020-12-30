package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlHeader;

/**
 * 컨트롤 헤더 객체들을 위한 부모 클래스
 *
 * @author neolord
 */
public abstract class CtrlHeader {
    /**
     * 컨트롤 아이디
     */
    protected long ctrlId;

    /**
     * 생성자
     *
     * @param ctrlId 컨트롤 아이디
     */
    public CtrlHeader(long ctrlId) {
        this.ctrlId = ctrlId;
    }

    /**
     * 컨트롤 아이디를 반환한다.
     *
     * @return 컨트롤 아이디
     */
    public long getCtrlId() {
        return ctrlId;
    }

    public abstract void copy(CtrlHeader from);
}

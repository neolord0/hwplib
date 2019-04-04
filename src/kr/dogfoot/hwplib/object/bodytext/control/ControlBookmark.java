package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.CtrlData;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderBookmark;

/**
 * 책갈피 컨트롤에 대한 객체
 *
 * @author neolord
 */
public class ControlBookmark extends Control {
    /**
     * 임의 데이터 객체
     */
    private CtrlData ctrlData;

    /**
     * 생성자
     */
    public ControlBookmark() {
        super(new CtrlHeaderBookmark());

        ctrlData = null;
    }

    /**
     * 책갈피용 컨트롤 헤더를 반환한다.
     *
     * @return 책갈피용 컨트롤 헤더
     */
    public CtrlHeaderBookmark getHeader() {
        return (CtrlHeaderBookmark) header;
    }

    /**
     * 임의 데이터 객체를 생성한다.
     */
    public void createCtrlData() {
        ctrlData = new CtrlData();
    }

    /**
     * 임의 데이터 객체를 반환한다.
     *
     * @return 임의 데이터 객체
     */
    public CtrlData getCtrlData() {
        return ctrlData;
    }
}

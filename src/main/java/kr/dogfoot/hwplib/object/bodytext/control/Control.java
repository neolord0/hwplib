package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.CtrlData;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeader;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlArc;

/**
 * 컨트롤에 대한 추상 객체
 *
 * @author neolord
 */
public abstract class Control {
    /**
     * 컨트롤 헤더 객체
     */
    protected CtrlHeader header;
    /**
     * 컨트롤 데이터
     */
    protected CtrlData ctrlData;

    /**
     * 생성자
     *
     * @param header 컨트롤 헤더 객체
     */
    public Control(CtrlHeader header) {
        this.header = header;
        ctrlData = null;
    }

    /**
     * 컨트롤 헤더 객체를 반환한다.
     *
     * @return 컨트롤 헤더 객체
     */
    public ControlType getType() {
        return ControlType.ctrlIdOf(header.getCtrlId());
    }

    /**
     * 필드 컨트롤인지 여부를 반환한다.
     *
     * @return 필드 컨트롤인지 여부
     */
    public boolean isField() {
        return ControlType.isField(header.getCtrlId());
    }

    /**
     * 컨트롤 데이터(??)를 생성한다.
     */
    public void createCtrlData() {
        ctrlData = new CtrlData();
    }

    public void deleteCtrlData() {
        ctrlData = null;
    }
    /**
     * 컨트롤 데이터(??)를 반환한다.
     *
     * @return 컨트롤 데이터 객체
     */
    public CtrlData getCtrlData() {
        return ctrlData;
    }

    /**
     * 컨트롤 데이터를 설정한다.
     *
     * @param ctrlData 컨트롤 데이터
     */
    public void setCtrlData(CtrlData ctrlData) {
        this.ctrlData = new CtrlData();
    }

    public abstract Control clone();

    public void copyControlPart(Control from) {
        if (from.header != null) {
            header.copy(from.header);
        } else {
            from.header = null;
        }

        if (from.ctrlData != null) {
            createCtrlData();
            ctrlData.copy(from.ctrlData);
        } else {
            ctrlData = null;
        }
    }
}

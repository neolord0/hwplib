package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.CtrlData;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterItem;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderField;

/**
 * 필드 컨트롤
 *
 * @author neolord
 */
public class ControlField extends Control {
    /**
     * 임의 데이터 객체
     */
    private CtrlData ctrlData;

    /**
     * 생성자
     */
    public ControlField() {
        super(new CtrlHeaderField());

        ctrlData = null;
    }

    /**
     * 생성자
     *
     * @param ctrlId : ctrl header의 ctrl-id.
     */
    public ControlField(long ctrlId) {
        super(new CtrlHeaderField(ctrlId));

        ctrlData = null;
    }

    /**
     * 필드용 컨트롤 헤더를 반환한다.
     *
     * @return 필드용 컨트롤 헤더
     */
    public CtrlHeaderField getHeader() {
        return (CtrlHeaderField) header;
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

    /**
     * 필드 컨트롤의 이름응 반환한다.
     *
     * @return 필드 컨트롤의 이름
     */
    public String getName() {
        if (ctrlData != null) {
            if (ctrlData.getParameterSet().getId() == 0x021B) {
                ParameterItem pi = ctrlData.getParameterSet().getParameterItem(
                        0x4000);
                if (pi != null && pi.getType() == ParameterType.String) {
                    return pi.getValue_BSTR();
                }
            }
        }
        return null;
    }
}

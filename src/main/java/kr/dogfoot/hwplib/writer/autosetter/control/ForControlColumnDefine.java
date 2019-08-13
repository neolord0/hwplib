package kr.dogfoot.hwplib.writer.autosetter.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlColumnDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderColumnDefine;

/**
 * 단 정의 컨트롤을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForControlColumnDefine {
    /**
     * 단 정의 컨트롤을 자동 설정한다.
     *
     * @param cd 단 정의 컨트롤
     */
    public static void autoSet(ControlColumnDefine cd) {
        CtrlHeaderColumnDefine h = cd.getHeader();

        if (h.getProperty().isSameWidth() == false) {
            if (h.getColumnInfoList().size() > 1) {
                h.getProperty()
                        .setColumnCount((short) h.getColumnInfoList().size());
            } else {
                h.getProperty().setColumnCount((short) 1);
            }
        }
    }
}

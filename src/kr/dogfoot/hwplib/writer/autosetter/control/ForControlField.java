package kr.dogfoot.hwplib.writer.autosetter.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderField;
import kr.dogfoot.hwplib.writer.autosetter.InstanceID;

/**
 * 필드 컨트롤을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForControlField {
    /**
     * 필드 컨트롤을 자동 설정한다.
     *
     * @param f   필드 컨트롤
     * @param iid 인스턴스 id
     */
    public static void autoSet(ControlField f, InstanceID iid) {
        ctrlHeader(f.getHeader(), iid);
    }

    /**
     * 컨트롤 헤더 레코드를 자동 설정한다.
     *
     * @param h   컨트롤 헤더
     * @param iid 인스턴스 id
     */
    private static void ctrlHeader(CtrlHeaderField h, InstanceID iid) {
        h.setInstanceId(iid.get());
    }

}

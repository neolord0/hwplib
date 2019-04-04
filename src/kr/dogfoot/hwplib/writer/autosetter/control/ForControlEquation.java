package kr.dogfoot.hwplib.writer.autosetter.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlEquation;
import kr.dogfoot.hwplib.writer.autosetter.InstanceID;
import kr.dogfoot.hwplib.writer.autosetter.control.gso.part.ForCaption;
import kr.dogfoot.hwplib.writer.autosetter.control.gso.part.ForCtrlHeaderGso;

/**
 * 수식 컨트롤을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForControlEquation {
    /**
     * 수식 컨트롤을 자동 설정한다.
     *
     * @param eq  수식 컨트롤
     * @param iid 인스턴스 id
     */
    public static void autoSet(ControlEquation eq, InstanceID iid) {
        ForCtrlHeaderGso.autoSet(eq.getHeader(), iid);
        ForCaption.autoSet(eq.getCaption(), iid);
    }
}

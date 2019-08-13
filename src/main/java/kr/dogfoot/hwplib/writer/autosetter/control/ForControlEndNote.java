package kr.dogfoot.hwplib.writer.autosetter.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlEndnote;
import kr.dogfoot.hwplib.writer.autosetter.ForParagraphList;
import kr.dogfoot.hwplib.writer.autosetter.InstanceID;

/**
 * 미주 컨트롤을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForControlEndNote {
    /**
     * 미주 컨트롤을 자동 설정한다.
     *
     * @param en  미주 컨트롤
     * @param iid 인스턴스 id
     */
    public static void autoSet(ControlEndnote en, InstanceID iid) {
        listHeader(en);
        ForParagraphList.autoSet(en.getParagraphList(), iid);
    }

    /**
     * 리스트 헤더 레코드를 자동 설정한다.
     *
     * @param en 미주 컨트롤
     */
    private static void listHeader(ControlEndnote en) {
        en.getListHeader().setParaCount(
                en.getParagraphList().getParagraphCount());
    }
}

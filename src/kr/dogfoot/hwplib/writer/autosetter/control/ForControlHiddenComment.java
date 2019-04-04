package kr.dogfoot.hwplib.writer.autosetter.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlHiddenComment;
import kr.dogfoot.hwplib.writer.autosetter.ForParagraphList;
import kr.dogfoot.hwplib.writer.autosetter.InstanceID;

/**
 * 숨은 설명 컨트롤을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForControlHiddenComment {
    /**
     * 숨은 설명 컨트롤을 자동 설정한다.
     *
     * @param hc  숨은 설명 컨트롤
     * @param iid 인스턴스 id
     */
    public static void autoSet(ControlHiddenComment hc, InstanceID iid) {
        listHeader(hc);
        ForParagraphList.autoSet(hc.getParagraphList(), iid);
    }

    /**
     * 리스트 헤더 레코드를 자동 설정한다.
     *
     * @param hc 숨은 설명 컨트롤
     */
    private static void listHeader(ControlHiddenComment hc) {
        hc.getListHeader().setParaCount(
                hc.getParagraphList().getParagraphCount());
    }
}

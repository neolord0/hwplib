package kr.dogfoot.hwplib.writer.autosetter.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlHeader;
import kr.dogfoot.hwplib.writer.autosetter.ForParagraphList;
import kr.dogfoot.hwplib.writer.autosetter.InstanceID;

/**
 * 머리말 컨트롤을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForControlHeader {
    /**
     * 머리말 컨트롤을 자동 설정한다.
     *
     * @param h   머리말 컨트롤
     * @param iid 인스턴스 id
     */
    public static void autoSet(ControlHeader h, InstanceID iid) {
        listHeader(h);
        ForParagraphList.autoSet(h.getParagraphList(), iid);
    }

    /**
     * 리스트 헤더 레코드를 자동 설정한다.
     *
     * @param h 머리말 컨트롤
     */
    private static void listHeader(ControlHeader h) {
        h.getListHeader()
                .setParaCount(h.getParagraphList().getParagraphCount());
    }
}

package kr.dogfoot.hwplib.writer.autosetter.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlFootnote;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderFootnote;
import kr.dogfoot.hwplib.writer.autosetter.ForParagraphList;
import kr.dogfoot.hwplib.writer.autosetter.InstanceID;

/**
 * 각주 컨트롤을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForControlFootnote {
    /**
     * 각주 컨트롤을 자동 설정한다.
     *
     * @param fn  각주 컨트롤
     * @param iid 인스턴스 id
     */
    public static void autoSet(ControlFootnote fn, InstanceID iid) {
        ctrlHeader(fn.getHeader(), iid);
        listHeader(fn);
        ForParagraphList.autoSet(fn.getParagraphList(), iid);
    }

    /**
     * 컨트롤 헤더 레코드를 자동 설정한다.
     *
     * @param h   컨트롤 헤더 레코드
     * @param iid 인스턴스 id
     */
    private static void ctrlHeader(CtrlHeaderFootnote h, InstanceID iid) {
        h.setInstanceId(iid.get());
    }

    /**
     * 리스트 헤더 레코드를 자동 설정한다.
     *
     * @param fn 각주 컨트롤
     */
    private static void listHeader(ControlFootnote fn) {
        fn.getListHeader().setParaCount(
                fn.getParagraphList().getParagraphCount());
    }
}

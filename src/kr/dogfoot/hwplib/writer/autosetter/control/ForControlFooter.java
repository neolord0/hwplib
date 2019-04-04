package kr.dogfoot.hwplib.writer.autosetter.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlFooter;
import kr.dogfoot.hwplib.writer.autosetter.ForParagraphList;
import kr.dogfoot.hwplib.writer.autosetter.InstanceID;

/**
 * 꼬리말 컨트롤을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForControlFooter {
    /**
     * 꼬리말 컨트롤을 자동 설정한다.
     *
     * @param f   꼬리말 컨트롤
     * @param iid 인스턴스 id
     */
    public static void autoSet(ControlFooter f, InstanceID iid) {
        listHeader(f);
        ForParagraphList.autoSet(f.getParagraphList(), iid);
    }

    /**
     * 리스트 헤더 레코드를 자동 설정한다.
     *
     * @param f 꼬리말 컨트롤
     */
    private static void listHeader(ControlFooter f) {
        f.getListHeader()
                .setParaCount(f.getParagraphList().getParagraphCount());
    }
}

package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderFootnote;
import kr.dogfoot.hwplib.object.bodytext.control.footnoteendnote.ListHeaderForFootnodeEndnote;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;

/**
 * 각주(FootNote) 컨트롤
 *
 * @author neolord
 */
public class ControlFootnote extends Control {
    /**
     * 각주/미주용 리스트 헤더
     */
    private ListHeaderForFootnodeEndnote listHeader;
    /**
     * 문단 리스트
     */
    private ParagraphList paragraphList;

    /**
     * 생성자
     */
    public ControlFootnote() {
        super(new CtrlHeaderFootnote());

        listHeader = new ListHeaderForFootnodeEndnote();
        paragraphList = new ParagraphList();
    }

    /**
     * 각주용 컨트롤 헤더를 반환한다.
     *
     * @return 각주용 컨트롤 헤더
     */
    public CtrlHeaderFootnote getHeader() {
        return (CtrlHeaderFootnote) header;
    }

    /**
     * 각주/미주용 리스트 헤더를 반환한다.
     *
     * @return 각주/미주용 리스트 헤더
     */
    public ListHeaderForFootnodeEndnote getListHeader() {
        return listHeader;
    }

    /**
     * 문단 리스트를 반환한다.
     *
     * @return 문단 리스트
     */
    public ParagraphList getParagraphList() {
        return paragraphList;
    }
}

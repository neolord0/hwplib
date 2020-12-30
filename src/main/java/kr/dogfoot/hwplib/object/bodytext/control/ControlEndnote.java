package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderEndnote;
import kr.dogfoot.hwplib.object.bodytext.control.footnoteendnote.ListHeaderForFootnodeEndnote;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;

/**
 * 미주(endnote) 컨트롤
 *
 * @author neolord
 */
public class ControlEndnote extends Control {
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
    public ControlEndnote() {
        super(new CtrlHeaderEndnote());

        listHeader = new ListHeaderForFootnodeEndnote();
        paragraphList = new ParagraphList();
    }

    /**
     * 미주 컨트롤용 컨트롤 헤더를 반환한다.
     *
     * @return 미주 컨트롤용 컨트롤 헤더
     */
    public CtrlHeaderEndnote getHeader() {
        return (CtrlHeaderEndnote) header;
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

    @Override
    public Control clone() {
        ControlEndnote cloned = new ControlEndnote();
        cloned.copyControlPart(this);
        cloned.listHeader.copy(listHeader);
        cloned.paragraphList.copy(paragraphList);
        return cloned;
    }
}

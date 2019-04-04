package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderHeader;
import kr.dogfoot.hwplib.object.bodytext.control.headerfooter.ListHeaderForHeaderFooter;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;

/**
 * 머리말 컨트롤
 *
 * @author neolord
 */
public class ControlHeader extends Control {
    /**
     * 머리말/꼬리말용 리스트 헤더
     */
    private ListHeaderForHeaderFooter listHeader;
    /**
     * 문단 리스트
     */
    private ParagraphList paragraphList;

    /**
     * 생성자
     */
    public ControlHeader() {
        super(new CtrlHeaderHeader());

        listHeader = new ListHeaderForHeaderFooter();
        paragraphList = new ParagraphList();
    }

    /**
     * 머리말용 컨트롤 헤더를 반환한다.
     *
     * @return 머리말용 컨트롤 헤더
     */
    public CtrlHeaderHeader getHeader() {
        return (CtrlHeaderHeader) header;
    }

    /**
     * 머리말/꼬리말용리스트 헤더를 반환한다.
     *
     * @return 머리말/꼬리말용 리스트 헤더
     */
    public ListHeaderForHeaderFooter getListHeader() {
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

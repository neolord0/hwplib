package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.BatangPageInfo;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.FootEndNoteShape;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.PageBorderFill;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.PageDef;

import java.util.ArrayList;

/**
 * 구역 정의 컨트롤
 *
 * @author neolord
 */
public class ControlSectionDefine extends Control {
    /**
     * 용지설정 정보
     */
    private PageDef pageDef;
    /**
     * 각주 모양 정보
     */
    private FootEndNoteShape footNoteShape;
    /**
     * 미주 모양 정보
     */
    private FootEndNoteShape endNoteShape;
    /**
     * 쪽 테두리/배경 정보 - 양 쪽
     */
    private PageBorderFill bothPageBorderFill;
    /**
     * 쪽 테두리/배경 정보 - 짝수 쪽
     */
    private PageBorderFill evenPageBorderFill;
    /**
     * 쪽 테두리/배경 정보 - 홀수 쪽
     */
    private PageBorderFill oddPageBorderFill;
    /**
     * 바탕쪽 정보(양 쪽, 짝수 쪽, 홀수 쪽) 리스트
     */
    private ArrayList<BatangPageInfo> batangPageInfoList;

    /**
     * 생성자
     */
    public ControlSectionDefine() {
        super(new CtrlHeaderSectionDefine());

        pageDef = new PageDef();
        footNoteShape = new FootEndNoteShape();
        endNoteShape = new FootEndNoteShape();
        bothPageBorderFill = new PageBorderFill();
        evenPageBorderFill = new PageBorderFill();
        oddPageBorderFill = new PageBorderFill();
        batangPageInfoList = new ArrayList<BatangPageInfo>();
    }

    /**
     * 구역 정의 컨트롤 용 컨트롤 헤더를 반환한다.
     *
     * @return 구역 정의 컨트롤 용 컨트롤 헤더
     */
    public CtrlHeaderSectionDefine getHeader() {
        return (CtrlHeaderSectionDefine) header;
    }

    /**
     * 용지설정 정보를 반환한다.
     *
     * @return 용지설정 정보
     */
    public PageDef getPageDef() {
        return pageDef;
    }

    /**
     * 각주 모양 정보를 반환한다.
     *
     * @return 각주 모양 정보
     */
    public FootEndNoteShape getFootNoteShape() {
        return footNoteShape;
    }

    /**
     * 미주 모양 정보를 반환한다.
     *
     * @return 미주 모양 정보
     */
    public FootEndNoteShape getEndNoteShape() {
        return endNoteShape;
    }

    /**
     * 쪽 테두리/배경 정보(양 쪽)를 반환한다.
     *
     * @return 쪽 테두리/배경 정보(양 쪽)
     */
    public PageBorderFill getBothPageBorderFill() {
        return bothPageBorderFill;
    }

    /**
     * 쪽 테두리/배경 정보(짝수 쪽)를 반환한다.
     *
     * @return 쪽 테두리/배경 정보(짝수 쪽)
     */
    public PageBorderFill getEvenPageBorderFill() {
        return evenPageBorderFill;
    }

    /**
     * 쪽 테두리/배경 정보(홀수 쪽)를 반환한다.
     *
     * @return 쪽 테두리/배경 정보(홀수 쪽)
     */
    public PageBorderFill getOddPageBorderFill() {
        return oddPageBorderFill;
    }

    /**
     * 새로운 바탕 쪽 정보 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 바탕 쪽 정보 객체
     */
    public BatangPageInfo addNewBatangPageInfo() {
        BatangPageInfo bpi = new BatangPageInfo();
        batangPageInfoList.add(bpi);
        return bpi;
    }

    /**
     * 바탕쪽 정보 리스트를 반환한다.
     *
     * @return 바탕쪽 정보 리스트
     */
    public ArrayList<BatangPageInfo> getBatangPageInfoList() {
        return batangPageInfoList;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.equation.EQEdit;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.Caption;

/**
 * 수식 컨트롤
 *
 * @author neolord
 */
public class ControlEquation extends Control {
    /**
     * 캡션
     */
    private Caption caption;
    /**
     * 수식 정보
     */
    private EQEdit eqEdit;

    /**
     * 생성자
     */
    public ControlEquation() {
        super(new CtrlHeaderGso(ControlType.Equation));

        eqEdit = new EQEdit();
    }

    /**
     * 그리기 객체용 컨트롤 헤더를 반환한다.
     *
     * @return 그리기 객체용 컨트롤 헤더
     */
    public CtrlHeaderGso getHeader() {
        return (CtrlHeaderGso) header;
    }

    /**
     * 캡션 객체를 생성한다.
     */
    public void createCaption() {
        caption = new Caption();
    }

    /**
     * 캡션 객체를 삭제한다.
     */
    public void deleteCaption() {
        caption = null;
    }

    /**
     * 캡션 객체를 반환한다.
     *
     * @return 캡션 객체
     */
    public Caption getCaption() {
        return caption;
    }

    /**
     * 수식 정보 객체를 반환한다.
     *
     * @return 수식 정보 객체
     */
    public EQEdit getEQEdit() {
        return eqEdit;
    }
}

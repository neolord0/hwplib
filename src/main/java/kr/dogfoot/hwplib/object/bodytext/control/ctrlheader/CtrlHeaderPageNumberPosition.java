package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.pagenumberposition.PageNumberPositionHeaderProperty;
import kr.dogfoot.hwplib.object.etc.HWPString;

/**
 * 쪽 번호 위치 컨트롤을 위한 컨트롤 헤더 레코드
 *
 * @author neolord
 */
public class CtrlHeaderPageNumberPosition extends CtrlHeader {
    /**
     * 속성
     */
    private PageNumberPositionHeaderProperty property;
    /**
     * 번호
     */
    private int number;
    /**
     * 사용자 기호
     */
    private HWPString userSymbol;
    /**
     * 얖 장식 문자
     */
    private HWPString beforeDecorationLetter;
    /**
     * 뒤 장식 문자
     */
    private HWPString afterDecorationLetter;

    /**
     * 생성자
     */
    public CtrlHeaderPageNumberPosition() {
        super(ControlType.PageNumberPositon.getCtrlId());

        property = new PageNumberPositionHeaderProperty();
        userSymbol = new HWPString();
        beforeDecorationLetter = new HWPString();
        afterDecorationLetter = new HWPString();
    }

    /**
     * 쪽 번호 위치 컨트롤의 속성 객체를 반환한다.
     *
     * @return 쪽 번호 위치 컨트롤의 속성 객체
     */
    public PageNumberPositionHeaderProperty getProperty() {
        return property;
    }

    /**
     * 번호를 반환한다.
     *
     * @return 번호
     */
    public int getNumber() {
        return number;
    }

    /**
     * 번호를 설정한다.
     *
     * @param number 번호
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * 사용자 기호를 반환한다.
     *
     * @return 사용자 기호
     */
    public HWPString getUserSymbol() {
        return userSymbol;
    }

    /**
     * 얖 장식 문자를 반환한다.
     *
     * @return 얖 장식 문자
     */
    public HWPString getBeforeDecorationLetter() {
        return beforeDecorationLetter;
    }

    /**
     * 뒤 장식 문자를 반환한다.
     *
     * @return 뒤 장식 문자
     */
    public HWPString getAfterDecorationLetter() {
        return afterDecorationLetter;
    }

    public void copy(CtrlHeaderPageNumberPosition from) {
        property.copy(from.property);
        number = from.number;
        userSymbol.copy(from.userSymbol);
        beforeDecorationLetter.copy(from.beforeDecorationLetter);
        afterDecorationLetter.copy(from.afterDecorationLetter);
    }

    @Override
    public void copy(CtrlHeader from) {
        CtrlHeaderPageNumberPosition from2 = (CtrlHeaderPageNumberPosition) from;
        property.copy(from2.property);
        number = from2.number;
        userSymbol = from2.userSymbol;
        beforeDecorationLetter = from2.beforeDecorationLetter;
        afterDecorationLetter = from2.afterDecorationLetter;
    }
}

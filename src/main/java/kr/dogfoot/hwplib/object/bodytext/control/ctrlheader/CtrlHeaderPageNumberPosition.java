package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.pagenumberposition.PageNumberPositionHeaderProperty;

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
    private String userSymbol;
    /**
     * 얖 장식 문자
     */
    private String beforeDecorationLetter;
    /**
     * 뒤 장식 문자
     */
    private String afterDecorationLetter;

    /**
     * 생성자
     */
    public CtrlHeaderPageNumberPosition() {
        super(ControlType.PageNumberPositon.getCtrlId());

        property = new PageNumberPositionHeaderProperty();
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
    public String getUserSymbol() {
        return userSymbol;
    }

    /**
     * 사용자 기호를 설정한다.
     *
     * @param userSymbol 사용자 기호
     */
    public void setUserSymbol(String userSymbol) {
        this.userSymbol = userSymbol;
    }

    /**
     * 얖 장식 문자를 반환한다.
     *
     * @return 얖 장식 문자
     */
    public String getBeforeDecorationLetter() {
        return beforeDecorationLetter;
    }

    /**
     * 얖 장식 문자를 설정한다.
     *
     * @param beforeDecorationLetter 얖 장식 문자
     */
    public void setBeforeDecorationLetter(String beforeDecorationLetter) {
        this.beforeDecorationLetter = beforeDecorationLetter;
    }

    /**
     * 뒤 장식 문자를 반환한다.
     *
     * @return 뒤 장식 문자
     */
    public String getAfterDecorationLetter() {
        return afterDecorationLetter;
    }

    /**
     * 뒤 장식 문자를 설정한다.
     *
     * @param afterDecorationLetter 뒤 장식 문자
     */
    public void setAfterDecorationLetter(String afterDecorationLetter) {
        this.afterDecorationLetter = afterDecorationLetter;
    }

    public void copy(CtrlHeaderPageNumberPosition from) {
        property.copy(from.property);
        number = from.number;
        userSymbol = from.userSymbol;
        beforeDecorationLetter = from.beforeDecorationLetter;
        afterDecorationLetter = from.afterDecorationLetter;
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

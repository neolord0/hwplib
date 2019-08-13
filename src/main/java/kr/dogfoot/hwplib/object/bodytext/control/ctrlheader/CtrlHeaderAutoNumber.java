package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.autonumber.AutoNumberHeaderProperty;

/**
 * 자동번호 컨트롤을 위한 컨트롤 헤더 레코드
 *
 * @author neolord
 */
public class CtrlHeaderAutoNumber extends CtrlHeader {
    /**
     * 속성
     */
    private AutoNumberHeaderProperty property;
    /**
     * 번호
     */
    private int number;
    /**
     * 사용자 기호
     */
    private String userSymbol;
    /**
     * 앞 장식 문자
     */
    private String beforeDecorationLetter;
    /**
     * 뒤 장식 문자
     */
    private String afterDecorationLetter;

    /**
     * 생성자
     */
    public CtrlHeaderAutoNumber() {
        super(ControlType.AutoNumber.getCtrlId());

        property = new AutoNumberHeaderProperty();
    }

    /**
     * 자동번호 컨트롤의 속성 객체를 반환한다.
     *
     * @return 자동번호 컨트롤의 속성 객체
     */
    public AutoNumberHeaderProperty getProperty() {
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
     * 앞 장식 문자를 반환한다.
     *
     * @return 앞 장식 문자
     */
    public String getBeforeDecorationLetter() {
        return beforeDecorationLetter;
    }

    /**
     * 앞 장식 문자를 설정한다.
     *
     * @param beforeDecorationLetter 앞 장식 문자
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
}

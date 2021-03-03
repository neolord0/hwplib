package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.autonumber.AutoNumberHeaderProperty;
import kr.dogfoot.hwplib.object.etc.HWPString;

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
    private HWPString userSymbol;
    /**
     * 앞 장식 문자
     */
    private HWPString beforeDecorationLetter;
    /**
     * 뒤 장식 문자
     */
    private HWPString afterDecorationLetter;

    /**
     * 생성자
     */
    public CtrlHeaderAutoNumber() {
        super(ControlType.AutoNumber.getCtrlId());

        property = new AutoNumberHeaderProperty();
        userSymbol = new HWPString();
        beforeDecorationLetter = new HWPString();
        afterDecorationLetter = new HWPString();
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
    public HWPString getUserSymbol() {
        return userSymbol;
    }

    /**
     * 앞 장식 문자를 반환한다.
     *
     * @return 앞 장식 문자
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

    @Override
    public void copy(CtrlHeader from) {
        CtrlHeaderAutoNumber from2 = (CtrlHeaderAutoNumber) from;
        property.copy(from2.property);
        number = from2.number;
        userSymbol.copy(from2.userSymbol);
        beforeDecorationLetter.copy(from2.beforeDecorationLetter);
        afterDecorationLetter.copy(from2.afterDecorationLetter);

    }
}

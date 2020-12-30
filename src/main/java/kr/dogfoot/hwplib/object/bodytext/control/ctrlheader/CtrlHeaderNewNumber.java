package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.newnumber.NewNumberHeaderProperty;

/**
 * 새 번호 지정 컨트롤을 위한 컨트롤 헤더 레코드
 *
 * @author neolord
 */
public class CtrlHeaderNewNumber extends CtrlHeader {
    /**
     * 속성
     */
    private NewNumberHeaderProperty property;
    /**
     * 번호
     */
    private int number;

    /**
     * 생성자
     */
    public CtrlHeaderNewNumber() {
        super(ControlType.NewNumber.getCtrlId());

        property = new NewNumberHeaderProperty();
    }

    /**
     * 새 번호 지정 컨트롤의 속성 객체를 반환한다.
     *
     * @return 새 번호 지정 컨트롤의 속성 객체
     */
    public NewNumberHeaderProperty getProperty() {
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
    @Override
    public void copy(CtrlHeader from) {
        CtrlHeaderNewNumber from2 = (CtrlHeaderNewNumber) from;
        property.copy(from2.property);
        number = from2.number;
    }
}

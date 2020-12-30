package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 각주 모양에 대한 속성을 나타내는 객체
 *
 * @author neolord
 */
public class FootNoteShapeProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public FootNoteShapeProperty() {
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public long getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값을 설정한다.
     *
     * @param value 파일에 저장되는 정수값
     */
    public void setValue(long value) {
        this.value = value;
    }

    /**
     * 번호 모양을 반환한다. (0~7 bit) (0~16 은 범용. 0x80, 0x81은 각주/미주 전용)
     *
     * @return 번호 모양
     */
    public NumberShape getNumberShape() {
        return NumberShape.valueOf((short) BitFlag.get(value, 0, 7));
    }

    /**
     * 번호 모양을 설정한다. (0~7 bit) (0~16 은 범용. 0x80, 0x81은 각주/미주 전용)
     *
     * @param numberShape 번호 모양
     */
    public void setNumberShape(NumberShape numberShape) {
        value = BitFlag.set(value, 0, 7, numberShape.getValue());
    }

    /**
     * 한 페이지 내에서 각주를 다단에 위치시킬 방법을 반환한다.(각주 일 경우) (8~9 bit)
     *
     * @return 한 페이지 내에서 각주를 다단에 위치시킬 방법
     */
    public FootNoteDisplayMethod getFootNoteDisplayMethod() {
        return FootNoteDisplayMethod.valueOf((byte) BitFlag.get(value, 8, 9));
    }

    /**
     * 한 페이지 내에서 각주를 다단에 위치시킬 방법를 설정한다. (각주 일 경우) (8~9 bit)
     *
     * @param footNoteDisplayMethod 한 페이지 내에서 각주를 다단에 위치시킬 방법
     */
    public void setFootNoteDisplayMethod(
            FootNoteDisplayMethod footNoteDisplayMethod) {
        value = BitFlag.set(value, 8, 9, footNoteDisplayMethod.getValue());
    }

    /**
     * 미주를 위치시킬 방법을 반환한다.(미주 일 경우) (8~9 bit)
     *
     * @return 미주를 위치시킬 방법
     */
    public EndNoteDisplayMethod getEndNoteDisplayMethod() {
        return EndNoteDisplayMethod.valueOf((byte) BitFlag.get(value, 8, 9));
    }

    /**
     * 미주를 위치시킬 방법을 설정한다.(미주 일 경우) (8~9 bit)
     *
     * @param endNoteDisplayMethod 미주를 위치시킬 방법
     */
    public void setEndNoteDisplayMethod(
            EndNoteDisplayMethod endNoteDisplayMethod) {
        value = BitFlag.set(value, 8, 9, endNoteDisplayMethod.getValue());
    }

    /**
     * 번호 매김 방법을 반환한다. (10~11 bit)
     *
     * @return 번호 매김 방법
     */
    public NumberingMethod getNumberingMethod() {
        return NumberingMethod.valueOf((byte) BitFlag.get(value, 10, 11));
    }

    /**
     * 번호 매김 방법을 설정한다. (10~11 bit)
     *
     * @param numberingMethod 번호 매김 방법
     */
    public void setNumberingMethod(NumberingMethod numberingMethod) {
        value = BitFlag.set(value, 10, 11, numberingMethod.getValue());
    }

    /**
     * 각주 내용 중 번호 코드의 모양을 위 첨자 형식으로 할지 여부을 반환한다. (12 bit)
     *
     * @return 각주 내용 중 번호 코드의 모양을 위 첨자 형식으로 할지 여부
     */
    public boolean isDisplayWithSupscript() {
        return BitFlag.get(value, 12);
    }

    /**
     * 각주 내용 중 번호 코드의 모양을 위 첨자 형식으로 할지 여부를 설정한다. (12 bit)
     *
     * @param displayWithSupscript 각주 내용 중 번호 코드의 모양을 위 첨자 형식으로 할지 여부
     */
    public void setDisplayWithSupscript(boolean displayWithSupscript) {
        value = BitFlag.set(value, 12, displayWithSupscript);
    }

    /**
     * 텍스트에 이어 바로 출력할지 여부를 반환한다. (13 bit)
     *
     * @return 텍스트에 이어 바로 출력할지 여부
     */
    public boolean isContinueFromText() {
        return BitFlag.get(value, 13);
    }

    /**
     * 텍스트에 이어 바로 출력할지 여부를 설정한다. (13 bit)
     *
     * @param continueFromText 텍스트에 이어 바로 출력할지 여부
     */
    public void setContinueFromText(boolean continueFromText) {
        value = BitFlag.set(value, 13, continueFromText);
    }

    public void copy(FootNoteShapeProperty from) {
        value = from.value;

    }
}

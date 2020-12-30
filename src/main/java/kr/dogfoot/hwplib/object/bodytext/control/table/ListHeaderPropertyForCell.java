package kr.dogfoot.hwplib.object.bodytext.control.table;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.sectiondefine.TextDirection;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.LineChange;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextVerticalAlignment;
import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 셀의 문단 리스트 헤더의 속성을 나타내는 객체
 *
 * @author neolord
 */
public class ListHeaderPropertyForCell {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public ListHeaderPropertyForCell() {
    }

    /**
     * 파일에 저장되는 정수값을 설정한다.
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
     * 텍스트 방향을 반환한다. (0~2 bit)
     *
     * @return 텍스트 방향
     */
    public TextDirection getTextDirection() {
        return TextDirection.valueOf((byte) BitFlag.get(value, 0, 2));
    }

    /**
     * 텍스트 방향을 설정한다. (0~2 bit)
     *
     * @param textDirection 텍스트 방향
     */
    public void setTextDirection(TextDirection textDirection) {
        value = BitFlag.set(value, 0, 2, textDirection.getValue());
    }

    /**
     * 문단의 줄바꿈을 반환한다. (3~4 bit)
     *
     * @return 문단의 줄바꿈 방법
     */
    public LineChange getLineChange() {
        return LineChange.valueOf((byte) BitFlag.get(value, 3, 4));
    }

    /**
     * 문단의 줄바꿈을 설정한다. (3~4 bit)
     *
     * @param lineChange 문단의 줄바꿈 방법
     */
    public void setLineChange(LineChange lineChange) {
        value = BitFlag.set(value, 3, 4, lineChange.getValue());
    }

    /**
     * 세로 정렬을 반환한다. (5~6 bit)
     *
     * @return 세로 정렬
     */
    public TextVerticalAlignment getTextVerticalAlignment() {
        return TextVerticalAlignment.valueOf((byte) BitFlag.get(value, 5, 6));
    }

    /**
     * 세로 정렬을 설정한다. (5~6 bit)
     *
     * @param textVerticalAlignment 세로 정렬
     */
    public void setTextVerticalAlignment(
            TextVerticalAlignment textVerticalAlignment) {
        value = BitFlag.set(value, 5, 6, textVerticalAlignment.getValue());
    }

    /**
     * 안 여백 지정 여부를 반환한다. (16 bit)
     *
     * @return 안 여백 지정 여부
     */
    public boolean isApplyInnerMagin() {
        return BitFlag.get(value, 16);
    }

    /**
     * 안 여백 지정 여부를 설정한다. (16 bit)
     *
     * @param applyInnerMagin 안 여백 지정 여부
     */
    public void setApplyInnerMagin(boolean applyInnerMagin) {
        value = BitFlag.set(value, 16, applyInnerMagin);
    }

    /**
     * 셀 보호 여부를 반환한다. (17 bit)
     *
     * @return 셀 보호 여부
     */
    public boolean isProtectCell() {
        return BitFlag.get(value, 17);
    }

    /**
     * 셀 보호 여부를 설정한다. (17 bit)
     *
     * @param protectCell 셀 보호 여부
     */
    public void setProtectCell(boolean protectCell) {
        value = BitFlag.set(value, 17, protectCell);
    }

    /**
     * 양식 모드에서 편집 가능 여부를 반환한다. (19 bit)
     *
     * @return 양식 모드에서 편집 가능 여부
     */
    public boolean isEditableAtFormMode() {
        return BitFlag.get(value, 19);
    }

    /**
     * 양식 모드에서 편집 가능 여부를 설정한다. (19 bit)
     *
     * @param editableAtFormMode 양식 모드에서 편집 가능 여부
     */
    public void setEditableAtFormMode(boolean editableAtFormMode) {
        value = BitFlag.set(value, 19, editableAtFormMode);
    }

    public void copy(ListHeaderPropertyForCell from) {
        value = from.value;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.gso.textbox;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.sectiondefine.TextDirection;
import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 문단 리스트 헤더의 속성을 나타내는 객체
 *
 * @author neolord
 */
public class ListHeaderProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생상자
     */
    public ListHeaderProperty() {
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
     * @param textDirection
     */
    public void setTextDirection(TextDirection textDirection) {
        value = BitFlag.set(value, 0, 2, textDirection.getValue());
    }

    /**
     * 문단의 줄바꿈 방법을 반환한다. (3~4 bit)
     *
     * @return 문단의 줄바꿈 방법
     */
    public LineChange getLineChange() {
        return LineChange.valueOf((byte) BitFlag.get(value, 3, 4));
    }

    /**
     * 문단의 줄바꿈 방법을 설정한다. (3~4 bit)
     *
     * @param lineChange 문단의 줄바꿈 방법
     */
    public void setLineChange(LineChange lineChange) {
        value = BitFlag.set(value, 3, 4, lineChange.getValue());
    }

    /**
     * 세로 정렬 방법을 반환한다. (5~6 bit)
     *
     * @return 세로 정렬 방법
     */
    public TextVerticalAlignment getTextVerticalAlignment() {
        return TextVerticalAlignment.valueOf((byte) BitFlag.get(value, 5, 6));
    }

    /**
     * 세로 정렬 방법을 설정한다. (5~6 bit)
     *
     * @param textVerticalAlignment 세로 정렬 방법
     */
    public void setTextVerticalAlignment(
            TextVerticalAlignment textVerticalAlignment) {
        value = BitFlag.set(value, 5, 6, textVerticalAlignment.getValue());
    }
}

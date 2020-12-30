package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 테두리 선 정보의 속성을 나타내는 객체
 *
 * @author neolord
 */
public class LineInfoProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public LineInfoProperty() {
    }

    /**
     * 생성자를 반환한다.
     *
     * @return 생성자
     */
    public long getValue() {
        return value;
    }

    /**
     * 생성자를 설정한다.
     *
     * @param value 생성자
     */
    public void setValue(long value) {
        this.value = value;
    }

    /**
     * 선 종류를 반환한다. (0~5 bit)
     *
     * @return 선 종류
     */
    public LineType getLineType() {
        return LineType.valueOf((byte) BitFlag.get(value, 0, 5));
    }

    /**
     * 선 종류를 설정한다. (0~5 bit)
     *
     * @param lineType 선 종류
     */
    public void setLineType(LineType lineType) {
        value = BitFlag.set(value, 0, 5, lineType.getValue());
    }

    /**
     * 선 끝 모양을 반환한다. (6~9 bit)
     *
     * @return 선 끝 모양
     */
    public LineEndShape getLineEndShape() {
        return LineEndShape.valueOf((byte) BitFlag.get(value, 6, 9));
    }

    /**
     * 선 끝 모양을 설정한다. (6~9 bit)
     *
     * @param lineEndShape 선 끝 모양
     */
    public void setLineEndShape(LineEndShape lineEndShape) {
        value = BitFlag.set(value, 6, 9, lineEndShape.getValue());
    }

    /**
     * 화살표 시작 모양을 반환한다. (10~15 bit)
     *
     * @return 화살표 시작 모양
     */
    public LineArrowShape getStartArrowShape() {
        return LineArrowShape.valueOf((byte) BitFlag.get(value, 10, 15));
    }

    /**
     * 화살표 시작 모양을 설정한다. (10~15 bit)
     *
     * @param startArrowShape 화살표 시작 모양
     */
    public void setStartArrowShape(LineArrowShape startArrowShape) {
        value = BitFlag.set(value, 10, 15, startArrowShape.getValue());
    }

    /**
     * 화살표 끝 모양을 반환한다. (16~21 bit)
     *
     * @return 화살표 끝 모양
     */
    public LineArrowShape getEndArrowShape() {
        return LineArrowShape.valueOf((byte) BitFlag.get(value, 16, 21));
    }

    /**
     * 화살표 끝 모양을 설정한다. (16~21 bit)
     *
     * @param endArrowShape 화살표 끝 모양
     */
    public void setEndArrowShape(LineArrowShape endArrowShape) {
        value = BitFlag.set(value, 16, 21, endArrowShape.getValue());
    }

    /**
     * 화살표 시작 크기를 반환한다. (22~25 bit)
     *
     * @return 화살표 시작 크기
     */
    public LineArrowSize getStartArrowSize() {
        return LineArrowSize.valueOf((byte) BitFlag.get(value, 22, 25));
    }

    /**
     * 화살표 시작 크기를 설정한다. (22~25 bit)
     *
     * @param startArrowSize 화살표 시작 크기
     */
    public void setStartArrowSize(LineArrowSize startArrowSize) {
        value = BitFlag.set(value, 22, 25, startArrowSize.getValue());
    }

    /**
     * 화살표 끝 크기를 반환한다. (26~29 bit)
     *
     * @return 화살표 끝 크기
     */
    public LineArrowSize getEndArrowSize() {
        return LineArrowSize.valueOf((byte) BitFlag.get(value, 26, 29));
    }

    /**
     * 화살표 끝 크기를 설정한다. (26~29 bit)
     *
     * @param endArrowSize 화살표 끝 크기
     */
    public void setEndArrowSize(LineArrowSize endArrowSize) {
        value = BitFlag.set(value, 26, 29, endArrowSize.getValue());
    }

    /**
     * 시작부분 화살표 채움 여부를 반환한다. (30 bit)
     *
     * @return 시작부분 화살표 채움 여부
     */
    public boolean isFillStartArrow() {
        return BitFlag.get(value, 30);
    }

    /**
     * 시작부분 화살표 채움 여부를 섷정한다. (30 bit)
     *
     * @param fillStartArrow 시작부분 화살표 채움 여부
     */
    public void setFillStartArrow(boolean fillStartArrow) {
        value = BitFlag.set(value, 30, fillStartArrow);
    }

    /**
     * 끝부분 화살표 채움 여부를 반환한다. (31 bit)
     *
     * @return 끝부분 화살표 채움 여부
     */
    public boolean isFillEndArrow() {
        return BitFlag.get(value, 31);
    }

    /**
     * 끝부분 화살표 채움 여부를 설정한다. (31 bit)
     *
     * @param fillEndArrow 끝부분 화살표 채움 여부
     */
    public void setFillEndArrow(boolean fillEndArrow) {
        value = BitFlag.set(value, 31, fillEndArrow);
    }

    public void copy(LineInfoProperty from) {
        value = from.value;
    }
}

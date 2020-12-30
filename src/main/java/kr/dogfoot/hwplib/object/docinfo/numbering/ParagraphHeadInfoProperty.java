package kr.dogfoot.hwplib.object.docinfo.numbering;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 문단 머리 정보의 속성 객체
 *
 * @author neolord
 */
public class ParagraphHeadInfoProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public ParagraphHeadInfoProperty() {
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
     * 문단의 정렬 종류를 반환한다. (0~1 bit)
     *
     * @return 문단의 정렬 종류
     */
    public ParagraphAlignment getParagraphAlignment() {
        return ParagraphAlignment.valueOf((byte) BitFlag.get(value, 0, 1));
    }

    /**
     * 문단의 정렬 종류를 설정한다. (0~1 bit)
     *
     * @param paragraphAlignment 문단의 정렬 종류
     */
    public void setParagraphAlignment(ParagraphAlignment paragraphAlignment) {
        value = BitFlag.set(value, 0, 1, paragraphAlignment.getValue());
    }

    /**
     * 번호 너비를 실제 인스턴스 문자열의 너비에 따를지 여부를 반환한다. (2 bit)
     *
     * @return 번호 너비를 실제 인스턴스 문자열의 너비에 따를지 여부
     */
    public boolean isFollowStringWidth() {
        return BitFlag.get(value, 2);
    }

    /**
     * 번호 너비를 실제 인스턴스 문자열의 너비에 따를지 여부를 설정한다. (2 bit)
     *
     * @param followStringWidth 번호 너비를 실제 인스턴스 문자열의 너비에 따를지 여부
     */
    public void setFollowStringWidth(boolean followStringWidth) {
        value = BitFlag.set(value, 2, followStringWidth);
    }

    /**
     * 자동 내어 쓰기 여부를 반환한다. (3 bit)
     *
     * @return 자동 내어 쓰기 여부
     */
    public boolean isAutoIndent() {
        return BitFlag.get(value, 3);
    }

    /**
     * 자동 내어 쓰기 여부를 설정한다. (3 bit)
     *
     * @param autoIndent 자동 내어 쓰기 여부
     */
    public void setAutoIndent(boolean autoIndent) {
        value = BitFlag.set(value, 3, autoIndent);
    }

    /**
     * 수준별 본문과의 거리 종류를 반환한다. (4 bit)
     *
     * @return 수준별 본문과의 거리 종류
     */
    public ValueType getValueTypeForDistanceFromBody() {
        if (BitFlag.get(value, 4) == false) {
            return ValueType.RatioForLetter;
        } else {
            return ValueType.Value;
        }
    }

    /**
     * 수준별 본문과의 거리 종류를 설정한다. (4 bit)
     *
     * @param valueType 수준별 본문과의 거리 종류
     */
    public void setValueTypeForDistanceFromBody(ValueType valueType) {
        if (valueType == ValueType.RatioForLetter) {
            value = BitFlag.set(value, 4, false);
        } else {
            value = BitFlag.set(value, 4, true);
        }
    }

    public void copy(ParagraphHeadInfoProperty from) {
        value = from.value;
    }
}

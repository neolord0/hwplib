package kr.dogfoot.hwplib.object.docinfo.charshape;

import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;
import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 글자 모양 객체의 속성
 *
 * @author neolord
 */
public class CharShapeProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public CharShapeProperty() {
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
     * 글꼴 기울임 여부를 반환한다. (0 bit)
     *
     * @return 글꼴 기울임 여부
     */
    public boolean isItalic() {
        return BitFlag.get(value, 0);
    }

    /**
     * 글꼴 기울임 여부를 설정한다. (0 bit)
     *
     * @param italic 글꼴 기울임 여부
     */
    public void setItalic(boolean italic) {
        value = BitFlag.set(value, 0, italic);
    }

    /**
     * 글꼴 진하게 여부를 반환한다. (1 bit)
     *
     * @return 글꼴 진하게 여부
     */
    public boolean isBold() {
        return BitFlag.get(value, 1);
    }

    /**
     * 글꼴 진하게 여부를 설정한다. (1 bit)
     *
     * @param bold 글꼴 진하게 여부
     */
    public void setBold(boolean bold) {
        value = BitFlag.set(value, 1, bold);
    }

    /**
     * 밑줄의 종류를 반환한다. (2~3 bit)
     *
     * @return 밑줄의 종류
     */
    public UnderLineSort getUnderLineSort() {
        return UnderLineSort.valueOf((byte) BitFlag.get(value, 2, 3));
    }

    /**
     * 밑줄의 종류를 설정한다. (2~3 bit)
     *
     * @param underLineSort 밑줄의 종류
     */
    public void setUnderLineSort(UnderLineSort underLineSort) {
        value = BitFlag.set(value, 2, 3, underLineSort.getValue());
    }

    /**
     * 밑줄의 모양을 반환한다. (4~7 bit)
     *
     * @return 밑줄의 모양
     */
    public BorderType getUnderLineShape() {
        return BorderType.valueOf((byte) BitFlag.get(value, 4, 7));
    }

    /**
     * 밑줄의 모양을 설정한다. (4~7 bit)
     *
     * @param underLineShape 밑줄의 모양
     */
    public void setUnderLineShape(BorderType underLineShape) {
        value = BitFlag.set(value, 4, 7, underLineShape.getValue());
    }

    /**
     * 외곽선의 종류를 반환한다. (8~10 bit)
     *
     * @return 외곽선의 종류
     */
    public OutterLineSort getOutterLineSort() {
        return OutterLineSort.valueOf((byte) BitFlag.get(value, 8, 10));
    }

    /**
     * 외곽선의 종류를 설정한다. (8~10 bit)
     *
     * @param outterLineSort 외곽선의 종류
     */
    public void setOutterLineSort(OutterLineSort outterLineSort) {
        value = BitFlag.set(value, 8, 10, outterLineSort.getValue());
    }

    /**
     * 그림자의 종류를 반환한다. (11~12 bit)
     *
     * @return 그림자의 종류
     */
    public ShadowSort getShadowSort() {
        return ShadowSort.valueOf((byte) BitFlag.get(value, 11, 12));
    }

    /**
     * 그림자의 종류를 설정한다. (11~12 bit)
     *
     * @param shadowSort 그림자의 종류
     */
    public void setShadowSort(ShadowSort shadowSort) {
        value = BitFlag.set(value, 11, 12, shadowSort.getValue());
    }

    /**
     * 양각 여부를 반환한다. (13 bit)
     *
     * @return 양각 여부
     */
    public boolean isEmboss() {
        return BitFlag.get(value, 13);
    }

    /**
     * 양각 여부를 설정한다. (13 bit)
     *
     * @param emboss 양각 여부
     */
    public void setEmboss(boolean emboss) {
        value = BitFlag.set(value, 13, emboss);
    }

    /**
     * 음각 여부를 반환한다. (14 bit)
     *
     * @return 음각 여부
     */
    public boolean isEngrave() {
        return BitFlag.get(value, 14);
    }

    /**
     * 음각 여부를 설정한다. (14 bit)
     *
     * @param engrave 음각 여부
     */
    public void setEngrave(boolean engrave) {
        value = BitFlag.set(value, 14, engrave);
    }

    /**
     * 위 첨자 여부를 반환한다. (15 bit)
     *
     * @return 위 첨자 여부
     */
    public boolean isSuperScript() {
        return BitFlag.get(value, 15);
    }

    /**
     * 위 첨자 여부를 설정한다. (15 bit)
     *
     * @param superScript 위 첨자 여부
     */
    public void setSuperScript(boolean superScript) {
        value = BitFlag.set(value, 15, superScript);
    }

    /**
     * 아래 첨자 여부를 반환한다. (16 bit)
     *
     * @return 아래 첨자 여부
     */
    public boolean isSubScript() {
        return BitFlag.get(value, 16);
    }

    /**
     * 아래 첨자 여부를 설정한다. (16 bit)
     *
     * @param subScript 아래 첨자 여부
     */
    public void setSubScript(boolean subScript) {
        value = BitFlag.set(value, 16, subScript);
    }

    /**
     * 취소선 여부를 반환한다. (18~20 bit)
     *
     * @return 취소선 여부
     */
    public boolean isStrikeLine() {
        return BitFlag.get(value, 18) | BitFlag.get(value, 19)
                | BitFlag.get(value, 20);
    }

    /**
     * 취소선 여부를 설정한다. (18~20 bit)
     *
     * @param strikeLine 취소선 여부
     */
    public void setStrikeLine(boolean strikeLine) {
        value = BitFlag.set(value, 18, strikeLine);
        value = BitFlag.set(value, 19, strikeLine);
        value = BitFlag.set(value, 20, strikeLine);
    }

    /**
     * 강조점의 종류를 반환한다. (21~24 bit)
     *
     * @return 강조점의 종류
     */
    public EmphasisSort getEmphasisSort() {
        return EmphasisSort.valueOf((byte) BitFlag.get(value, 21, 24));
    }

    /**
     * 강조점의 종류를 설정한다. (21~24 bit)
     *
     * @param emphasisSort 강조점의 종류
     */
    public void setEmphasisSort(EmphasisSort emphasisSort) {
        value = BitFlag.set(value, 21, 24, emphasisSort.getValue());
    }

    /**
     * 글꼴에 어울리는 빈칸 사용 여부를 반환한다. (25 bit)
     *
     * @return 글꼴에 어울리는 빈칸 사용 여부
     */
    public boolean isUsingSpaceAppropriateForFont() {
        return BitFlag.get(value, 25);
    }

    /**
     * 글꼴에 어울리는 빈칸 사용 여부를 설정한다. (25 bit)
     *
     * @param usingSpaceAppropriateForFont 글꼴에 어울리는 빈칸 사용 여부
     */
    public void setUsingSpaceAppropriateForFont(
            boolean usingSpaceAppropriateForFont) {
        value = BitFlag.set(value, 25, usingSpaceAppropriateForFont);
    }

    /**
     * 취소선의 모양을 반환한다. (26~29 bit)
     *
     * @return 취소선의 모양
     */
    public BorderType getStrikeLineShape() {
        return BorderType.valueOf((byte) BitFlag.get(value, 26, 29));
    }

    /**
     * 취소선의 모양을 설정한다. (26~29 bit)
     *
     * @param strikeLineShape 취소선의 모양
     */
    public void setStrikeLineShape(BorderType strikeLineShape) {
        value = BitFlag.set(value, 26, 29, strikeLineShape.getValue());
    }

    /**
     * Kerning 여부를 반환한다. (30 bit)
     *
     * @return Kerning 여부
     */
    public boolean isKerning() {
        return BitFlag.get(value, 30);
    }

    /**
     * Kerning 여부를 설정한다. (30 bit)
     *
     * @param kerning Kerning 여부
     */
    public void setKerning(boolean kerning) {
        value = BitFlag.set(value, 30, kerning);
    }

    public void copy(CharShapeProperty from) {
        value = from.value;
    }
}

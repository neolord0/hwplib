package kr.dogfoot.hwplib.object.docinfo.parashape;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 문단 모양의 속성1 객체
 *
 * @author neolord
 */
public class ParaShapeProperty1 {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    public ParaShapeProperty1() {
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
     * 줄 간격의 종류를 반환한다. (0~1 bit, 한글 2007 이하 버전에서 사용.)
     *
     * @return 줄 간격의 종류
     */
    public LineSpaceSort getLineSpaceSort() {
        return LineSpaceSort.valueOf((byte) BitFlag.get(value, 0, 1));
    }

    /**
     * 줄 간격의 종류를 설정한다. (0~1 bit, 한글 2007 이하 버전에서 사용.)
     *
     * @param lineSpaceSort 줄 간격의 종류
     */
    public void setLineSpaceSort(LineSpaceSort lineSpaceSort) {
        value = BitFlag.set(value, 0, 1, lineSpaceSort.getValue());
    }

    /**
     * 정렬 방식을 반환한다. (2~4 bit)
     *
     * @return 정렬 방식
     */
    public Alignment getAlignment() {
        return Alignment.valueOf((byte) BitFlag.get(value, 2, 4));
    }

    /**
     * 정렬 방식을 설정한다. (2~4 bit)
     *
     * @param alignment 정렬 방식
     */
    public void setAlignment(Alignment alignment) {
        value = BitFlag.set(value, 2, 4, alignment.getValue());
    }

    /**
     * 줄 나눔 기준 영어 단위를 반환한다. (5~6 bit)
     *
     * @return 줄 나눔 기준 영어 단위
     */
    public LineDivideForEnglish getLineDivideForEnglish() {
        return LineDivideForEnglish.valueOf((byte) BitFlag.get(value, 5, 6));
    }

    /**
     * 줄 나눔 기준 영어 단위를 설정한다. (5~6 bit)
     *
     * @param lineDivideForEnglish 줄 나눔 기준 영어 단위
     */
    public void setLineDivideForEnglish(LineDivideForEnglish lineDivideForEnglish) {
        value = BitFlag.set(value, 5, 6, lineDivideForEnglish.getValue());
    }

    /**
     * 줄 나눔 기준 한글 단위를 반환한다. (7 bit)
     *
     * @return 줄 나눔 기준 한글 단위
     */
    public LineDivideForHangul getLineDivideForHangul() {
        if (BitFlag.get(value, 7) == true) {
            return LineDivideForHangul.ByLetter;
        } else {
            return LineDivideForHangul.ByWord;
        }
    }

    /**
     * 줄 나눔 기준 한글 단위를 설정한다. (7 bit)
     *
     * @param lineDivideForHangul 줄 나눔 기준 한글 단위
     */
    public void setLineDivideForHangul(LineDivideForHangul lineDivideForHangul) {
        if (lineDivideForHangul == LineDivideForHangul.ByLetter) {
            value = BitFlag.set(value, 7, true);
        } else {
            value = BitFlag.set(value, 7, false);
        }
    }

    /**
     * 편집 용지의 줄 격자 사용 여부를 반환한다. (8 bit)
     *
     * @return 편집 용지의 줄 격자 사용 여부
     */
    public boolean isUseGrid() {
        return BitFlag.get(value, 8);
    }

    /**
     * 편집 용지의 줄 격자 사용 여부를 설정한다. (8 bit)
     *
     * @param useGrid 편집 용지의 줄 격자 사용 여부
     */
    public void setUseGrid(boolean useGrid) {
        value = BitFlag.set(value, 8, useGrid);
    }

    /**
     * 공백 최소값 (0%～75%)을 반환한다. (9~15 bit)
     *
     * @return 공백 최소값 (0%～75%)
     */
    public byte getMinimumSpace() {
        return (byte) BitFlag.get(value, 9, 15);
    }

    /**
     * 공백 최소값 (0%～75%)을 설정한다. (9~15 bit)
     *
     * @param minimumSpace 공백 최소값 (0%～75%)
     */
    public void setMinimumSpace(byte minimumSpace) {
        value = BitFlag.set(value, 9, 15, minimumSpace);
    }

    /**
     * 외톨이줄 보호 여부를 반환한다. (16 bit)
     *
     * @return 외톨이줄 보호 여부
     */
    public boolean isProtectLoner() {
        return BitFlag.get(value, 16);
    }

    /**
     * 외톨이줄 보호 여부를 설정한다. (16 bit)
     *
     * @param protectLoner 외톨이줄 보호 여부
     */
    public void setProtectLoner(boolean protectLoner) {
        value = BitFlag.set(value, 16, protectLoner);
    }

    /**
     * 다음 문단과 함께 여부를 반환한다. (17 bit)
     *
     * @return 다음 문단과 함께 여부
     */
    public boolean isTogetherNextPara() {
        return BitFlag.get(value, 17);
    }

    /**
     * 다음 문단과 함께 여부를 설정한다. (17 bit)
     *
     * @param togetherNextPara 다음 문단과 함께 여부
     */
    public void setTogetherNextPara(boolean togetherNextPara) {
        value = BitFlag.set(value, 17, togetherNextPara);
    }

    /**
     * 문단 보호 여부를 반환한다. (18 bit)
     *
     * @return 문단 보호 여부
     */
    public boolean isProtectPara() {
        return BitFlag.get(value, 18);
    }

    /**
     * 문단 보호 여부를  설정한다. (18 bit)
     *
     * @param protectPara 문단 보호 여부
     */
    public void setProtectPara(boolean protectPara) {
        value = BitFlag.set(value, 18, protectPara);
    }

    /**
     * 문단 앞에서 항상 쪽 나눔 여부를 반환한다. (19 bit)
     *
     * @return 문단 앞에서 항상 쪽 나눔 여부
     */
    public boolean isSplitPageBeforePara() {
        return BitFlag.get(value, 19);
    }

    /**
     * 문단 앞에서 항상 쪽 나눔 여부를 설정한다. (19 bit)
     *
     * @param splitPageBeforePara 문단 앞에서 항상 쪽 나눔 여부
     */
    public void setSplitPageBeforePara(boolean splitPageBeforePara) {
        value = BitFlag.set(value, 19, splitPageBeforePara);
    }

    /**
     * 세로 정렬을 반환한다. (20~21 bit)
     *
     * @return 세로 정렬
     */
    public VerticalAlignment getVerticalAlignment() {
        return VerticalAlignment.valueOf((byte) BitFlag.get(value, 20, 21));
    }

    /**
     * 세로 정렬을 설정한다. (20~21 bit)
     *
     * @param verticalAlignment 세로 정렬
     */
    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        value = BitFlag.set(value, 20, 21, verticalAlignment.getValue());
    }

    /**
     * 글꼴에 어울리는 줄 높이 여부를 반환한다. (22 bit)
     *
     * @return 글꼴에 어울리는 줄 높이 여부
     */
    public boolean isLineHeightForFont() {
        return BitFlag.get(value, 22);
    }

    /**
     * 글꼴에 어울리는 줄 높이 여부를 설정한다. (22 bit)
     *
     * @param lineHeightForFont 글꼴에 어울리는 줄 높이 여부
     */
    public void setLineHeightForFont(boolean lineHeightForFont) {
        value = BitFlag.set(value, 22, lineHeightForFont);
    }

    /**
     * 문단 머리의 모양을 반환한다. (23~24 bit)
     *
     * @return 문단 머리의 모양
     */
    public ParaHeadShape getParaHeadShape() {
        return ParaHeadShape.valueOf((byte) BitFlag.get(value, 23, 24));
    }

    /**
     * 문단 머리의 모양을 설정한다. (23~24 bit)
     *
     * @param paraHeadShape 문단 머리의 모양
     */
    public void setParaHeadShape(ParaHeadShape paraHeadShape) {
        value = BitFlag.set(value, 23, 24, paraHeadShape.getValue());
    }

    /**
     * 문단 수준(1수준～7수준)을 반화한다. (25~27 bit)
     *
     * @return 문단 수준
     */
    public byte getParaLevel() {
        return (byte) BitFlag.get(value, 25, 27);
    }

    /**
     * 문단 수준을 설정한다. (25~27 bit)
     *
     * @param paraLevel 문단 수준
     */
    public void setParaLevel(byte paraLevel) {
        value = BitFlag.set(value, 25, 27, paraLevel);
    }

    /**
     * 문단 테두리 연결 여부를 반환한다. (28 bit)
     *
     * @return 문단 테두리 연결 여부
     */
    public boolean isLinkBorder() {
        return BitFlag.get(value, 28);
    }

    /**
     * 문단 테두리 연결 여부를 설정한다. (28 bit)
     *
     * @param linkBorder 문단 테두리 연결 여부
     */
    public void setLinkBorder(boolean linkBorder) {
        value = BitFlag.set(value, 28, linkBorder);
    }

    /**
     * 문단 여백 무시 여부를 반환한다. (29 bit)
     *
     * @return 문단 여백 무시 여부
     */
    public boolean isIgnoreParaMargin() {
        return BitFlag.get(value, 29);
    }

    /**
     * 문단 여백 무시 여부를 설정한다. (29 bit)
     *
     * @param ignoreParaMargin 문단 여백 무시 여부
     */
    public void setIgnoreParaMargin(boolean ignoreParaMargin) {
        value = BitFlag.set(value, 29, ignoreParaMargin);
    }

    /**
     * 문단 꼬리 모양(??)을 반환한다. (30 bit)
     *
     * @return 문단 꼬리 모양(??)
     */
    public boolean isParaTailShape() {
        return BitFlag.get(value, 30);
    }

    /**
     * 문단 꼬리 모양(??)을 설정한다. (30 bit)
     *
     * @param paraTailShape 문단 꼬리 모양(??)
     */
    public void setParaTailShape(boolean paraTailShape) {
        value = BitFlag.set(value, 30, paraTailShape);
    }
}

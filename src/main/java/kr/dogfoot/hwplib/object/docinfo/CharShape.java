package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.charshape.*;
import kr.dogfoot.hwplib.object.etc.Color4Byte;

/**
 * 글자 모양을 나타내는 레코드
 *
 * @author neolord
 */
public class CharShape {
    /**
     * 언어별 글꼴 ID(FaceID) 참조 값
     */
    private FaceNameIds faceNameIds;
    /**
     * 언어별 장평, 50%~200%
     */
    private Ratios ratios;
    /**
     * 언어별 자간, -50%~50%
     */
    private CharSpaces charSpaces;
    /**
     * 언어별 상대 크기, 10%~250%
     */
    private RelativeSizes relativeSizes;
    /**
     * 언어별 글자 위치, -100%~100%
     */
    private CharOffsets charOffsets;
    /**
     * 기준 크기
     */
    private int baseSize;
    /**
     * 속성
     */
    private CharShapeProperty property;
    /**
     * 그림자 간격1, -100%~100%
     */
    private byte shadowGap1;
    /**
     * 그림자 간격2, -100%～100%
     */
    private byte shadowGap2;
    /**
     * 글자 색
     */
    private Color4Byte charColor;
    /**
     * 밑줄 색
     */
    private Color4Byte underLineColor;
    /**
     * 음영 색
     */
    private Color4Byte shadeColor;
    /**
     * 그림자 색
     */
    private Color4Byte shadowColor;
    /**
     * 글자의 테두리/배경 ID 참조 값
     */
    private int borderFillId;
    /**
     * 취소선 색 (5.0.3.0 이상)
     */
    private Color4Byte strikeLineColor;

    /**
     * 생성자
     */
    public CharShape() {
        faceNameIds = new FaceNameIds();
        ratios = new Ratios();
        charSpaces = new CharSpaces();
        relativeSizes = new RelativeSizes();
        charOffsets = new CharOffsets();
        property = new CharShapeProperty();
        charColor = new Color4Byte();
        underLineColor = new Color4Byte();
        shadeColor = new Color4Byte();
        shadowColor = new Color4Byte();
        strikeLineColor = new Color4Byte();
    }

    /**
     * 언어별로 참조된 글꼴 ID(FaceID)에 대한 객체를 반환한다.
     *
     * @return 언어별로 참조된 글꼴 ID(FaceID)에 대한 객체
     */
    public FaceNameIds getFaceNameIds() {
        return faceNameIds;
    }

    /**
     * 언어별 장평에 대한 객체를 반환한다.
     *
     * @return 언어별 장평에 대한 객체
     */
    public Ratios getRatios() {
        return ratios;
    }

    /**
     * 언어별 자간에 대한 객체를 반환한다.
     *
     * @return 언어별 자간에 대한 객체
     */
    public CharSpaces getCharSpaces() {
        return charSpaces;
    }

    /**
     * 언어별 상대 크기에 대한 객체를 반환한다.
     *
     * @return 언어별 상대 크기
     */
    public RelativeSizes getRelativeSizes() {
        return relativeSizes;
    }

    /**
     * 언어별 글자 위치에 대한 객체를 반환한다.
     *
     * @return 언어별 글자 위치에 대한 객체
     */
    public CharOffsets getCharOffsets() {
        return charOffsets;
    }

    /**
     * 기준 크기를 반환한다.
     *
     * @return 기준 크기
     */
    public int getBaseSize() {
        return baseSize;
    }

    /**
     * 기준 크기를 설정한다.
     *
     * @param baseSize 기준 크기
     */
    public void setBaseSize(int baseSize) {
        this.baseSize = baseSize;
    }

    /**
     * 글자모양 속성에 대한 객체를 반환한다.
     *
     * @return 글자모양 속성에 대한 객체
     */
    public CharShapeProperty getProperty() {
        return property;
    }

    /**
     * 그림자 간격1을 반한한다.
     *
     * @return 그림자 간격1
     */
    public byte getShadowGap1() {
        return shadowGap1;
    }

    /**
     * 그림자 간격1를 설정한다.
     *
     * @param shadowGap1 그림자 간격1
     */
    public void setShadowGap1(byte shadowGap1) {
        this.shadowGap1 = shadowGap1;
    }

    /**
     * 그림자 간격2를 반환한다.
     *
     * @return 그림자 간격2ㅁ
     */
    public byte getShadowGap2() {
        return shadowGap2;
    }

    /**
     * 그림자 간격2를 설정한다.
     *
     * @param shadowGap2 그림자 간격2
     */
    public void setShadowGap2(byte shadowGap2) {
        this.shadowGap2 = shadowGap2;
    }

    /**
     * 글자 색 객체를 반환한다.
     *
     * @return 글자 색 객체
     */
    public Color4Byte getCharColor() {
        return charColor;
    }

    /**
     * 밑줄 색 객체를 반환한다.
     *
     * @return 밑줄 색 객체
     */
    public Color4Byte getUnderLineColor() {
        return underLineColor;
    }

    /**
     * 음영 색 객체를 반환한다.
     *
     * @return 음영 색 객체
     */
    public Color4Byte getShadeColor() {
        return shadeColor;
    }

    /**
     * 그림자 색 객체를 반환한다.
     *
     * @return 그림자 색 객체
     */
    public Color4Byte getShadowColor() {
        return shadowColor;
    }

    /**
     * 참조된 테두리/배경 의 id를 반환한다.
     *
     * @return 참조된 테두리/배경 의 id
     */
    public int getBorderFillId() {
        return borderFillId;
    }

    /**
     * 참조된 테두리/배경 의 id를 설정한다.
     *
     * @param borderFillId 참조된 테두리/배경 의 id
     */
    public void setBorderFillId(int borderFillId) {
        this.borderFillId = borderFillId;
    }

    /**
     * 취소선 색 객체를 반환한다.
     *
     * @return 취소선 색 객체 (5.0.3.0 이상)
     */
    public Color4Byte getStrikeLineColor() {
        return strikeLineColor;
    }
}

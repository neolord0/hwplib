package kr.dogfoot.hwplib.object.docinfo.facename;

/**
 * 글꼴 유형 정보에 대한 객체
 *
 * @author neolord
 */
public class FontTypeInfo {
    /**
     * 글꼴 계열
     */
    private short fontType;
    /**
     * 세리프 유형
     */
    private short serifType;
    /**
     * 굵기
     */
    private short thickness;
    /**
     * 비례
     */
    private short ratio;
    /**
     * 대조
     */
    private short contrast;
    /**
     * 스트로크 편차
     */
    private short strokeDeviation;
    /**
     * 자획 유형
     */
    private short characterStrokeType;
    /**
     * 글자형
     */
    private short characterShape;
    /**
     * 중간선
     */
    private short middleLine;
    /**
     * X-높이
     */
    private short xHeight;

    /**
     * 생성자
     */
    public FontTypeInfo() {
    }

    /**
     * 글꼴 계열 값을 반환한다.
     *
     * @return 글꼴 계열 값
     */
    public short getFontType() {
        return fontType;
    }

    /**
     * 글꼴 계열 값을 설정한다.
     *
     * @param fontType 글꼴 계열 값
     */
    public void setFontType(short fontType) {
        this.fontType = fontType;
    }

    /**
     * 세리프 유형 값을 반환한다.
     *
     * @return 세리프 유형 값
     */
    public short getSerifType() {
        return serifType;
    }

    /**
     * 세리프 유형 값을 설정한다.
     *
     * @param serifType 세리프 유형 값
     */
    public void setSerifType(short serifType) {
        this.serifType = serifType;
    }

    /**
     * 굵기 값을 반환한다.
     *
     * @return 굵기 값
     */
    public short getThickness() {
        return thickness;
    }

    /**
     * 굵기 값을 설정한다.
     *
     * @param thickness 굵기 값
     */
    public void setThickness(short thickness) {
        this.thickness = thickness;
    }

    /**
     * 비례 값을 반환한다.
     *
     * @return 비례 값
     */
    public short getRatio() {
        return ratio;
    }

    /**
     * 비례 값을 설정한다.
     *
     * @param ratio 비례 값
     */
    public void setRatio(short ratio) {
        this.ratio = ratio;
    }

    /**
     * 대조 값을 반환한다.
     *
     * @return 대조 값
     */
    public short getContrast() {
        return contrast;
    }

    /**
     * 대조 값을 설정한다.
     *
     * @param contrast 대조 값
     */
    public void setContrast(short contrast) {
        this.contrast = contrast;
    }

    /**
     * 스트로크 편차 값을 반환한다.
     *
     * @return 스트로크 편차 값
     */
    public short getStrokeDeviation() {
        return strokeDeviation;
    }

    /**
     * 스트로크 편차 값을 설정한다.
     *
     * @param strokeDeviation 스트로크 편차 값
     */
    public void setStrokeDeviation(short strokeDeviation) {
        this.strokeDeviation = strokeDeviation;
    }

    /**
     * 자획 유형 값을 반환한다.
     *
     * @return 자획 유형 값
     */
    public short getCharacterStrokeType() {
        return characterStrokeType;
    }

    /**
     * 자획 유형 값을 설정한다.
     *
     * @param characterStrokeType 자획 유형 값
     */
    public void setCharacterStrokeType(short characterStrokeType) {
        this.characterStrokeType = characterStrokeType;
    }

    /**
     * 글자형 값을 반환한다.
     *
     * @return 글자형 값
     */
    public short getCharacterShape() {
        return characterShape;
    }

    /**
     * 글자형 값을 설정한다.
     *
     * @param characterShape 글자형 값
     */
    public void setCharacterShape(short characterShape) {
        this.characterShape = characterShape;
    }

    /**
     * 중간선 값을 반환한다.
     *
     * @return 중간선 값
     */
    public short getMiddleLine() {
        return middleLine;
    }

    /**
     * 중간선 값을 설정한다.
     *
     * @param middleLine 중간선 값
     */
    public void setMiddleLine(short middleLine) {
        this.middleLine = middleLine;
    }

    /**
     * X-높이를 반환한다.
     *
     * @return X-높이
     */
    public short getxHeight() {
        return xHeight;
    }

    /**
     * X-높이를 설정한다.
     *
     * @param xHeight X-높이
     */
    public void setxHeight(short xHeight) {
        this.xHeight = xHeight;
    }
}

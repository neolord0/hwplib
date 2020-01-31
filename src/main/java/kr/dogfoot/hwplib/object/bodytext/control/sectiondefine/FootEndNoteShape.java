package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderThickness;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;
import kr.dogfoot.hwplib.object.etc.Color4Byte;

/**
 * 미주/각주 모양 정보에 대한 레코드
 *
 * @author neolord
 */
public class FootEndNoteShape {
    /**
     * 속성
     */
    private FootNoteShapeProperty property;
    /**
     * 사용자 기호
     */
    private String userSymbol;
    /**
     * 앞 장식 문자
     */
    private String beforeDecorativeLetter;
    /**
     * 뒤 장식 문자
     */
    private String afterDecorativeLetter;
    /**
     * 시작 번호
     */
    private int startNumber;
    /**
     * 구분선 길이
     */
    private long divideLineLength;
    /**
     * 구분선 위 여백
     */
    private int divideLineTopMargin;
    /**
     * 구분선 아래 여백
     */
    private int divideLineBottomMargin;
    /**
     * 주석 사이 여백
     */
    private int betweenNotesMargin;
    /**
     * 구분선 종류
     */
    private BorderType divideLineSort;
    /**
     * 구분선 굵기
     */
    private BorderThickness divideLineThickness;
    /**
     * 구분선 색상
     */
    private Color4Byte divideLineColor;
    /**
     * 알수 없는 4 byte;
     */
    private long unknown;

    /**
     * 생성자
     */
    public FootEndNoteShape() {
        property = new FootNoteShapeProperty();
        divideLineColor = new Color4Byte();
    }

    /**
     * 속성 객체를 반환한다.
     *
     * @return 속성 객체
     */
    public FootNoteShapeProperty getProperty() {
        return property;
    }

    /**
     * 사용자 기호를 반환한다.
     *
     * @return 사용자 기호
     */
    public String getUserSymbol() {
        return userSymbol;
    }

    /**
     * 사용자 기호를 설정한다.
     *
     * @param userSymbol 사용자 기호
     */
    public void setUserSymbol(String userSymbol) {
        this.userSymbol = userSymbol;
    }

    /**
     * 앞 장식 문자를 반환한다.
     *
     * @return 앞 장식 문자
     */
    public String getBeforeDecorativeLetter() {
        return beforeDecorativeLetter;
    }

    /**
     * 앞 장식 문자를 설정한다.
     *
     * @param beforeDecorativeLetter 앞 장식 문자
     */
    public void setBeforeDecorativeLetter(String beforeDecorativeLetter) {
        this.beforeDecorativeLetter = beforeDecorativeLetter;
    }

    /**
     * 뒤 장식 문자를 반환한다.
     *
     * @return 뒤 장식 문자
     */
    public String getAfterDecorativeLetter() {
        return afterDecorativeLetter;
    }

    /**
     * 뒤 장식 문자를 설정한다.
     *
     * @param afterDecorativeLetter 뒤 장식 문자
     */
    public void setAfterDecorativeLetter(String afterDecorativeLetter) {
        this.afterDecorativeLetter = afterDecorativeLetter;
    }

    /**
     * 시작 번호를 반환한다.
     *
     * @return 시작 번호
     */
    public int getStartNumber() {
        return startNumber;
    }

    /**
     * 시작 번호를 설정한다.
     *
     * @param startNumber 시작 번호
     */
    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    /**
     * 구분선 길이를 반환한다.
     *
     * @return 구분선 길이
     */
    public long getDivideLineLength() {
        return divideLineLength;
    }

    /**
     * 구분선 길이를 설정한다.
     *
     * @param divideLineLength 구분선 길이
     */
    public void setDivideLineLength(long divideLineLength) {
        this.divideLineLength = divideLineLength;
    }

    /**
     * 구분선 위 여백의 크기를 반환한다.
     *
     * @return 구분선 위 여백의 크기
     */
    public int getDivideLineTopMargin() {
        return divideLineTopMargin;
    }

    /**
     * 구분선 위 여백의 크기를 설정한다.
     *
     * @param divideLineTopMargin 구분선 위 여백의 크기
     */
    public void setDivideLineTopMargin(int divideLineTopMargin) {
        this.divideLineTopMargin = divideLineTopMargin;
    }

    /**
     * 구분선 아래 여백의 크기를 반환한다.
     *
     * @return 구분선 아래 여백의 크기
     */
    public int getDivideLineBottomMargin() {
        return divideLineBottomMargin;
    }

    /**
     * 구분선 아래 여백의 크기를 설정한다.
     *
     * @param divideLineBottomMargin 구분선 아래 여백의 크기
     */
    public void setDivideLineBottomMargin(int divideLineBottomMargin) {
        this.divideLineBottomMargin = divideLineBottomMargin;
    }

    /**
     * 주석 사이 여백의 크기를 반환한다.
     *
     * @return 주석 사이 여백의 크기
     */
    public int getBetweenNotesMargin() {
        return betweenNotesMargin;
    }

    /**
     * 주석 사이 여백의 크기를 설정한다.
     *
     * @param betweenNotesMargin 주석 사이 여백의 크기
     */
    public void setBetweenNotesMargin(int betweenNotesMargin) {
        this.betweenNotesMargin = betweenNotesMargin;
    }

    /**
     * 구분선 종류를 반환한다.
     *
     * @return 구분선 종류
     */
    public BorderType getDivideLineSort() {
        return divideLineSort;
    }

    /**
     * 구분선 종류를 설정한다.
     *
     * @param divideLineSort 구분선 종류
     */
    public void setDivideLineSort(BorderType divideLineSort) {
        this.divideLineSort = divideLineSort;
    }

    /**
     * 구분선 굵기를 반환한다.
     *
     * @return 구분선 굵기
     */
    public BorderThickness getDivideLineThickness() {
        return divideLineThickness;
    }

    /**
     * 구분선 굵기를 설정한다.
     *
     * @param divideLineThickness 구분선 굵기
     */
    public void setDivideLineThickness(BorderThickness divideLineThickness) {
        this.divideLineThickness = divideLineThickness;
    }

    /**
     * 구분선 색상 객체를 반환한다.
     *
     * @return 구분선 색상 객체
     */
    public Color4Byte getDivideLineColor() {
        return divideLineColor;
    }

    /**
     * 알수 없는 4byte를 반환한다.
     * @return 알수 없는 4byte
     */
    public long getUnknown() {
        return unknown;
    }

    /**
     * 알수 없는 4byte를 설정한다.
     * @param unknown 알수 없는 4byte
     */
    public void setUnknown(long unknown) {
        this.unknown = unknown;
    }
}

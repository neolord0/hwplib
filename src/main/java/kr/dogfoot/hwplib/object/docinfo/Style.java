package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.style.StyleProperty;

/**
 * 스타일에 대한  레코드
 *
 * @author neolord
 */
public class Style {
    /**
     * 한글 이름
     */
    private String hangulName;
    /**
     * 영문 이름
     */
    private String englishName;
    /**
     * 속성
     */
    private StyleProperty proeprty;
    /**
     * 다음 스타일 아이디
     */
    private short nextStyleId;
    /**
     * 언어 아이디
     */
    private short languageId;
    /**
     * 참조된 문단 모양 아이디
     */
    private int paraShapeId;
    /**
     * 참조된 글자 모양 아이디
     */
    private int charShapeId;

    /**
     * 생성자
     */
    public Style() {
        proeprty = new StyleProperty();
    }

    /**
     * 한글 이름을 반환한다.
     *
     * @return 한글 이름
     */
    public String getHangulName() {
        return hangulName;
    }

    /**
     * 한글 이름을 설정한다.
     *
     * @param hangulName 한글 이름
     */
    public void setHangulName(String hangulName) {
        this.hangulName = hangulName;
    }

    /**
     * 영문 이름을 반환한다.
     *
     * @return 영문 이름
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * 영문 이름을 설정한다.
     *
     * @param englishName 영문 이름
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    /**
     * 스타일의 속성 객체를 반환한다.
     *
     * @return 스타일의 속성 객체
     */
    public StyleProperty getProeprty() {
        return proeprty;
    }

    /**
     * 다음 스타일 아이디를 반환한다.
     *
     * @return 다음 스타일 아이디
     */
    public short getNextStyleId() {
        return nextStyleId;
    }

    /**
     * 다음 스타일 아이디를 설정한다.
     *
     * @param nextStyleId 다음 스타일 아이디
     */
    public void setNextStyleId(short nextStyleId) {
        this.nextStyleId = nextStyleId;
    }

    /**
     * 언어 아이디를 반환한다.
     *
     * @return 언어 아이디
     */
    public short getLanguageId() {
        return languageId;
    }

    /**
     * 언어 아이디를 설정한다.
     *
     * @param languageId
     */
    public void setLanguageId(short languageId) {
        this.languageId = languageId;
    }

    /**
     * 참조된 문단 모양 아이디를 반환한다.
     *
     * @return 참조된 문단 모양 아이디
     */
    public int getParaShapeId() {
        return paraShapeId;
    }

    /**
     * 참조된 문단 모양 아이디를 설정한다.
     *
     * @param paraShapeId 참조된 문단 모양 아이디
     */
    public void setParaShapeId(int paraShapeId) {
        this.paraShapeId = paraShapeId;
    }

    /**
     * 참조된 글자 모양 아이디를 반환한다.
     *
     * @return 참조된 글자 모양 아이디
     */
    public int getCharShapeId() {
        return charShapeId;
    }

    /**
     * 참조된 글자 모양 아이디를 설정한다.
     *
     * @param charShapeId 참조된 글자 모양 아이디
     */
    public void setCharShapeId(int charShapeId) {
        this.charShapeId = charShapeId;
    }

    public Style clone() {
        Style cloned = new Style();
        cloned.hangulName = hangulName;
        cloned.englishName = englishName;
        cloned.proeprty.copy(proeprty);
        cloned.nextStyleId = nextStyleId;
        cloned.languageId = languageId;
        cloned.paraShapeId = paraShapeId;
        cloned.charShapeId = charShapeId;
        return cloned;
    }
}

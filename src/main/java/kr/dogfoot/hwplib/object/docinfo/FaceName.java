package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.facename.FaceNameProperty;
import kr.dogfoot.hwplib.object.docinfo.facename.FontType;
import kr.dogfoot.hwplib.object.docinfo.facename.FontTypeInfo;

/**
 * 글꼴 레코드
 *
 * @author neolord
 */
public class FaceName {
    /**
     * 속성
     */
    private FaceNameProperty property;
    /**
     * 글꼴 이름
     */
    private String name;
    /**
     * 대체 글꼴 유형
     */
    private FontType substituteFontType;
    /**
     * 대체 글꼴 이름
     */
    private String substituteFontName;
    /**
     * 글꼴 유형 정보
     */
    private FontTypeInfo fontTypeInfo;
    /**
     * 기본 글꼴 이름
     */
    private String baseFontName;

    /**
     * 생성자
     */
    public FaceName() {
        property = new FaceNameProperty();
        fontTypeInfo = new FontTypeInfo();
    }

    /**
     * 글꼴 속성에 대한 객체를 반환한다.
     *
     * @return 글꼴 속성에 대한 객체
     */
    public FaceNameProperty getProperty() {
        return property;
    }

    /**
     * 글꼴 이름을 반환한다.
     *
     * @return 글꼴 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 글꼴 이름을 설정한다.
     *
     * @param name 글꼴 이름
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 대체 글꼴 유형을 반환한다.
     *
     * @return 대체 글꼴 유형
     */
    public FontType getSubstituteFontType() {
        return substituteFontType;
    }

    /**
     * 대체 글꼴 유형을 설정한다.
     *
     * @param substituteFontType 대체 글꼴 유형
     */
    public void setSubstituteFontType(FontType substituteFontType) {
        this.substituteFontType = substituteFontType;
    }

    /**
     * 대체 글꼴 이름을 반환한다.
     *
     * @return 대체 글꼴 이름
     */
    public String getSubstituteFontName() {
        return substituteFontName;
    }

    /**
     * 대체 글꼴 이름을 설정한다.
     *
     * @param substituteFontName 대체 글꼴 이름
     */
    public void setSubstituteFontName(String substituteFontName) {
        this.substituteFontName = substituteFontName;
    }

    /**
     * 글꼴 유형 정보 객체를 반환한다.
     *
     * @return 글꼴 유형 정보 객체
     */
    public FontTypeInfo getFontTypeInfo() {
        return fontTypeInfo;
    }

    /**
     * 기본 글꼴 이름을 반환한다.
     *
     * @return 기본 글꼴 이름
     */
    public String getBaseFontName() {
        return baseFontName;
    }

    /**
     * 기본 글꼴 이름을 설정한다.
     *
     * @param baseFontName 기본 글꼴 이름
     */
    public void setBaseFontName(String baseFontName) {
        this.baseFontName = baseFontName;
    }

    public FaceName clone() {
        FaceName cloned = new FaceName();
        cloned.property.copy(property);
        cloned.name = name;
        cloned.substituteFontType = substituteFontType;
        cloned.substituteFontName = substituteFontName;
        cloned.fontTypeInfo.copy(fontTypeInfo);
        cloned.baseFontName = baseFontName;
        return cloned;
    }
}

package kr.dogfoot.hwplib.object.docinfo;

/**
 * 레이아웃 호환성에 대한  레코드
 *
 * @author neolord
 */
public class LayoutCompatibility {
    /**
     * 글자 단위 서식
     */
    private long letterLevelFormat;
    /**
     * 문단 단위 서식
     */
    private long paragraphLevelFormat;
    /**
     * 구역 단위 서식
     */
    private long sectionLevelFormat;
    /**
     * 개체 단위 서식
     */
    private long objectLevelFormat;
    /**
     * 필드 단위 서식
     */
    private long fieldLevelFormat;

    /**
     * 생성자
     */
    public LayoutCompatibility() {
    }

    /**
     * 글자 단위 서식을 반환한다.
     *
     * @return 글자 단위 서식
     */
    public long getLetterLevelFormat() {
        return letterLevelFormat;
    }

    /**
     * 글자 단위 서식을 설정한다.
     *
     * @param letterLevelFormat 글자 단위 서식
     */
    public void setLetterLevelFormat(long letterLevelFormat) {
        this.letterLevelFormat = letterLevelFormat;
    }

    /**
     * 문단 단위 서식을 반환한다.
     *
     * @return 문단 단위 서식
     */
    public long getParagraphLevelFormat() {
        return paragraphLevelFormat;
    }

    /**
     * 문단 단위 서식을 설정한다.
     *
     * @param paragraphLevelFormat 문단 단위 서식
     */
    public void setParagraphLevelFormat(long paragraphLevelFormat) {
        this.paragraphLevelFormat = paragraphLevelFormat;
    }

    /**
     * 구역 단위 서식을 반환한다.
     *
     * @return 구역 단위 서식
     */
    public long getSectionLevelFormat() {
        return sectionLevelFormat;
    }

    /**
     * 구역 단위 서식을 설정한다.
     *
     * @param sectionLevelFormat 구역 단위 서식
     */
    public void setSectionLevelFormat(long sectionLevelFormat) {
        this.sectionLevelFormat = sectionLevelFormat;
    }

    /**
     * 개체 단위 서식을 반환한다.
     *
     * @return 개체 단위 서식
     */
    public long getObjectLevelFormat() {
        return objectLevelFormat;
    }

    /**
     * 개체 단위 서식을 설정한다.
     *
     * @param objectLevelFormat 개체 단위 서식
     */
    public void setObjectLevelFormat(long objectLevelFormat) {
        this.objectLevelFormat = objectLevelFormat;
    }

    /**
     * 필드 단위 서식을 반환한다.
     *
     * @return 필드 단위 서식
     */
    public long getFieldLevelFormat() {
        return fieldLevelFormat;
    }

    /**
     * 필드 단위 서식을 설정한다.
     *
     * @param fieldLevelFormat 필드 단위 서식
     */
    public void setFieldLevelFormat(long fieldLevelFormat) {
        this.fieldLevelFormat = fieldLevelFormat;
    }

    public LayoutCompatibility clone() {
        LayoutCompatibility cloned = new LayoutCompatibility();
        cloned.letterLevelFormat = letterLevelFormat;
        cloned.paragraphLevelFormat = paragraphLevelFormat;
        cloned.sectionLevelFormat = sectionLevelFormat;
        cloned.objectLevelFormat = objectLevelFormat;
        cloned.fieldLevelFormat = fieldLevelFormat;
        return cloned;
    }
}

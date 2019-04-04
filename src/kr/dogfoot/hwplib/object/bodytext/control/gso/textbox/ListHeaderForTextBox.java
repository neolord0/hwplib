package kr.dogfoot.hwplib.object.bodytext.control.gso.textbox;

/**
 * 글상자를 위한 문단 리스트 헤더 레코드
 *
 * @author neolord
 */
public class ListHeaderForTextBox {
    /**
     * 문단 개수
     */
    private int paraCount;
    /**
     * 속성
     */
    private ListHeaderProperty property;
    /**
     * 글상자 텍스트 왼쪽 여백
     */
    private int leftMargin;
    /**
     * 글상자 텍스트 오른쪽 여백
     */
    private int rightMargin;
    /**
     * 글상자 텍스트 위쪽 여백
     */
    private int topMargin;
    /**
     * 글상자 텍스트 아래쪽 여백
     */
    private int bottomMargin;
    /**
     * 텍스트 문자열의 최대 폭
     */
    private long textWidth;
    /**
     * 양식 모드에서 편집 가능
     */
    private boolean editableAtFormMode;
    /**
     * 필드 이름
     */
    private String fieldName;

    /**
     * 생성자
     */
    public ListHeaderForTextBox() {
        property = new ListHeaderProperty();
    }

    /**
     * 문단 개수를 반환한다.
     *
     * @return 문단 개수
     */
    public int getParaCount() {
        return paraCount;
    }

    /**
     * 문단 개수를 설정한다.
     *
     * @param paraCount
     */
    public void setParaCount(int paraCount) {
        this.paraCount = paraCount;
    }

    /**
     * 속성 객체를 반환한다.
     *
     * @return 속성 객체
     */
    public ListHeaderProperty getProperty() {
        return property;
    }

    /**
     * 글상자 텍스트 왼쪽 여백의 크기를 반환한다.
     *
     * @return 글상자 텍스트 왼쪽 여백의 크기
     */
    public int getLeftMargin() {
        return leftMargin;
    }

    /**
     * 글상자 텍스트 왼쪽 여백의 크기를 설정한다.
     *
     * @param leftMargin 글상자 텍스트 왼쪽 여백의 크기
     */
    public void setLeftMargin(int leftMargin) {
        this.leftMargin = leftMargin;
    }

    /**
     * 글상자 텍스트 오른쪽 여백의 크기를 반환한다.
     *
     * @return 글상자 텍스트 오른쪽 여백의 크기
     */
    public int getRightMargin() {
        return rightMargin;
    }

    /**
     * 글상자 텍스트 오른쪽 여백의 크기를 설정한다.
     *
     * @param rightMargin 글상자 텍스트 오른쪽 여백의 크기
     */
    public void setRightMargin(int rightMargin) {
        this.rightMargin = rightMargin;
    }

    /**
     * 글상자 텍스트 위쪽 여백의 크기를 반환한다.
     *
     * @return 글상자 텍스트 위쪽 여백의 크기
     */
    public int getTopMargin() {
        return topMargin;
    }

    /**
     * 글상자 텍스트 위쪽 여백의 크기를 설정한다.
     *
     * @param topMargin 글상자 텍스트 위쪽 여백의 크기
     */
    public void setTopMargin(int topMargin) {
        this.topMargin = topMargin;
    }

    /**
     * 글상자 텍스트 아래쪽 여백의 크기를 반환한다.
     *
     * @return 글상자 텍스트 아래쪽 여백의 크기
     */
    public int getBottomMargin() {
        return bottomMargin;
    }

    /**
     * 글상자 텍스트 아래쪽 여백의 크기를 설정한다.
     *
     * @param bottomMargin 글상자 텍스트 아래쪽 여백의 크기
     */
    public void setBottomMargin(int bottomMargin) {
        this.bottomMargin = bottomMargin;
    }

    /**
     * 텍스트 문자열의 최대 폭을 반환한다.
     *
     * @return 텍스트 문자열의 최대 폭
     */
    public long getTextWidth() {
        return textWidth;
    }

    /**
     * 텍스트 문자열의 최대 폭을 설정한다.
     *
     * @param textWidth 텍스트 문자열의 최대 폭
     */
    public void setTextWidth(long textWidth) {
        this.textWidth = textWidth;
    }

    /**
     * 양식 모드에서 편집 가능 여부를 반환한다.
     *
     * @return 양식 모드에서 편집 가능 여부
     */
    public boolean isEditableAtFormMode() {
        return editableAtFormMode;
    }

    /**
     * 양식 모드에서 편집 가능 여부를 설정한다.
     *
     * @param editableAtFormMode 양식 모드에서 편집 가능 여부
     */
    public void setEditableAtFormMode(boolean editableAtFormMode) {
        this.editableAtFormMode = editableAtFormMode;
    }

    /**
     * 필드 이름을 반환한다.
     *
     * @return 필드 이름
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 필드 이름을 설정한다.
     *
     * @param fieldName 필드 이름
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}

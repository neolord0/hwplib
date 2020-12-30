package kr.dogfoot.hwplib.object.bodytext.control.table;

/**
 * 셀의 문단 리스트 헤더 레코드
 *
 * @author neolord
 */
public class ListHeaderForCell {
    /**
     * 문단 개수
     */
    private int paraCount;
    /**
     * 속성
     */
    private ListHeaderPropertyForCell property;
    /**
     * 셀 주소(Column)
     */
    private int colIndex;
    /**
     * 셀 주소(Row)
     */
    private int rowIndex;
    /**
     * 열의 병합 개수
     */
    private int colSpan;
    /**
     * 행의 병합 개수
     */
    private int rowSpan;
    /**
     * 셀의 폭
     */
    private long width;
    /**
     * 셀의 높이
     */
    private long height;
    /**
     * 왼쪽 여백
     */
    private int leftMargin;
    /**
     * 오른쪽 여백
     */
    private int rightMargin;
    /**
     * 위쪽 여백
     */
    private int topMargin;
    /**
     * 아래쪽 여백
     */
    private int bottomMargin;
    /**
     * 참조된 테두리/배경 id
     */
    private int borderFillId;
    /**
     * 텍스트 폭
     */
    private long textWidth;
    /**
     * 필드 이름
     */
    private String fieldName;

    /**
     * 생성자
     */
    public ListHeaderForCell() {
        property = new ListHeaderPropertyForCell();
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
     * @param paraCount 문단 개수
     */
    public void setParaCount(int paraCount) {
        this.paraCount = paraCount;
    }

    /**
     * 속성 객체를 반환한다.
     *
     * @return 속성 객체
     */
    public ListHeaderPropertyForCell getProperty() {
        return property;
    }

    /**
     * 셀 주소(Column)을 반환한다.
     *
     * @return 셀 주소(Column)
     */
    public int getColIndex() {
        return colIndex;
    }

    /**
     * 셀 주소(Column)를 설정한다.
     *
     * @param colIndex 셀 주소(Column)
     */
    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }

    /**
     * 셀 주소(Row)를 반환한다.
     *
     * @return 셀 주소(Row)
     */
    public int getRowIndex() {
        return rowIndex;
    }

    /**
     * 셀 주소(Row)를 설정한다.
     *
     * @param rowIndex 셀 주소(Row)
     */
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    /**
     * 열의 병합 개수를 반환한다.
     *
     * @return 열의 병합 개수
     */
    public int getColSpan() {
        return colSpan;
    }

    /**
     * 열의 병합 개수를 설정한다.
     *
     * @param colSpan 열의 병합 개수
     */
    public void setColSpan(int colSpan) {
        this.colSpan = colSpan;
    }

    /**
     * 행의 병합 개수를 반환한다.
     *
     * @return 행의 병합 개수
     */
    public int getRowSpan() {
        return rowSpan;
    }

    /**
     * 행의 병합 개수를 설정한다.
     *
     * @param rowSpan 행의 병합 개수
     */
    public void setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
    }

    /**
     * 셀의 폭을 반환한다.
     *
     * @return 셀의 폭
     */
    public long getWidth() {
        return width;
    }

    /**
     * 셀의 폭을 설정한다.
     *
     * @param width 셀의 폭
     */
    public void setWidth(long width) {
        this.width = width;
    }

    /**
     * 셀의 높이를 반환한다.
     *
     * @return 셀의 높이
     */
    public long getHeight() {
        return height;
    }

    /**
     * 셀의 높이을 설정한다.
     *
     * @param height 셀의 높이
     */
    public void setHeight(long height) {
        this.height = height;
    }

    /**
     * 왼쪽 여백의 크기를 반환한다.
     *
     * @return 왼쪽 여백의 크기
     */
    public int getLeftMargin() {
        return leftMargin;
    }

    /**
     * 왼쪽 여백의 크기를 설정한다.
     *
     * @param leftMargin 왼쪽 여백의 크기
     */
    public void setLeftMargin(int leftMargin) {
        this.leftMargin = leftMargin;
    }

    /**
     * 오른쪽 여백의 크기를 반환한다.
     *
     * @return 오른쪽 여백의 크기
     */
    public int getRightMargin() {
        return rightMargin;
    }

    /**
     * 오른쪽 여백의 크기를 설정한다.
     *
     * @param rightMargin 오른쪽 여백의 크기
     */
    public void setRightMargin(int rightMargin) {
        this.rightMargin = rightMargin;
    }

    /**
     * 위쪽 여백의 크기를 반환한다.
     *
     * @return 위쪽 여백의 크기
     */
    public int getTopMargin() {
        return topMargin;
    }

    /**
     * 위쪽 여백의 크기를 설정한다.
     *
     * @param topMargin 위쪽 여백의 크기
     */
    public void setTopMargin(int topMargin) {
        this.topMargin = topMargin;
    }

    /**
     * 아래쪽 여백의 크기를 반환한다.
     *
     * @return 아래쪽 여백의 크기
     */
    public int getBottomMargin() {
        return bottomMargin;
    }

    /**
     * 아래쪽 여백의 크기를 설정한다.
     *
     * @param bottomMargin 아래쪽 여백의 크기
     */
    public void setBottomMargin(int bottomMargin) {
        this.bottomMargin = bottomMargin;
    }

    /**
     * 참조된 테두리/배경 id를 반환한다.
     *
     * @return 참조된 테두리/배경 id
     */
    public int getBorderFillId() {
        return borderFillId;
    }

    /**
     * 참조된 테두리/배경 id를 설정한다.
     *
     * @param borderFillId 참조된 테두리/배경 id
     */
    public void setBorderFillId(int borderFillId) {
        this.borderFillId = borderFillId;
    }

    /**
     * 텍스트 폭을 반환한다.
     *
     * @return 텍스트 폭
     */
    public long getTextWidth() {
        return textWidth;
    }

    /**
     * 텍스트 폭을 설정한다.
     *
     * @param textWidth 텍스트 폭
     */
    public void setTextWidth(long textWidth) {
        this.textWidth = textWidth;
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

    public void copy(ListHeaderForCell from) {
        paraCount = from.paraCount;
        property.copy(from.property);
        colIndex = from.colIndex;
        rowIndex = from.rowIndex;
        colSpan = from.colSpan;
        rowSpan = from.rowSpan;
        width = from.width;
        height = from.height;
        leftMargin = from.leftMargin;
        rightMargin = from.rightMargin;
        topMargin = from.topMargin;
        bottomMargin = from.bottomMargin;
        borderFillId = from.borderFillId;
        textWidth = from.textWidth;
        fieldName = from.fieldName;
    }
}

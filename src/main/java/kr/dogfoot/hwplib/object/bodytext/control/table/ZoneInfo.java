package kr.dogfoot.hwplib.object.bodytext.control.table;

/**
 * 영역 속성
 *
 * @author neolord
 */
public class ZoneInfo {
    /**
     * 시작 열 주소
     */
    private int startColumn;
    /**
     * 시작 행 주소
     */
    private int startRow;
    /**
     * 끝 열 주소
     */
    private int endColumn;
    /**
     * 끝 행 주소
     */
    private int endRow;
    /**
     * 참조된 테두리/배경 Id
     */
    private int borderFillId;

    /**
     * 생성자
     */
    public ZoneInfo() {
    }

    /**
     * 시작 열 주소를 반환한다.
     *
     * @return 시작 열 주소
     */
    public int getStartColumn() {
        return startColumn;
    }

    /**
     * 시작 열 주소를 설정한다.
     *
     * @param startColumn 시작 열 주소
     */
    public void setStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }

    /**
     * 시작 행 주소를 반환한다.
     *
     * @return 시작 행 주소
     */
    public int getStartRow() {
        return startRow;
    }

    /**
     * 시작 행 주소를 설정한다.
     *
     * @param startRow 시작 행 주소
     */
    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    /**
     * 끝 열 주소를 반환한다.
     *
     * @return 끝 열 주소
     */
    public int getEndColumn() {
        return endColumn;
    }

    /**
     * 끝 열 주소를 설정한다.
     *
     * @param endColumn 끝 열 주소
     */
    public void setEndColumn(int endColumn) {
        this.endColumn = endColumn;
    }

    /**
     * 끝 행 주소를 반환한다.
     *
     * @return 끝 행 주소
     */
    public int getEndRow() {
        return endRow;
    }

    /**
     * 끝 행 주소를 설정한다.
     *
     * @param endRow 끝 행 주소
     */
    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    /**
     * 참조된 테두리/배경 Id를 반환한다.
     *
     * @return 참조된 테두리/배경 Id
     */
    public int getBorderFillId() {
        return borderFillId;
    }

    /**
     * 참조된 테두리/배경 Id를 설정한다.
     *
     * @param borderFillId 참조된 테두리/배경 Id
     */
    public void setBorderFillId(int borderFillId) {
        this.borderFillId = borderFillId;
    }
}

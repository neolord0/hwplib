package kr.dogfoot.hwplib.tool;

import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.ListHeaderForCell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;

import java.util.Vector;

/**
 * 표의 셀을 병합하는 클래스
 *
 * @author neolord
 */
public class TableCellMerger {
    /**
     * 표의 셀을 병합한다.
     *
     * @param table    병합할 표
     * @param startRow 행의 시작 인덱스
     * @param startCol 열의 시작 인덱스
     * @param rowSpan  행의 span
     * @param colSpan  열의 span
     * @return 병합 성공 여부
     */
    public static boolean mergeCell(ControlTable table, int startRow, int startCol, int rowSpan, int colSpan) {
        TableCellMerger merger = new TableCellMerger(table, startRow, startCol, rowSpan, colSpan);
        return merger.merge();
    }

    /**
     * 병합할 표
     */
    private ControlTable table;
    /**
     * 행의 시작 인덱스
     */
    private int startRow;
    /**
     * 열의 시작 인덱스
     */
    private int startCol;
    /**
     * 행의 span
     */
    private int rowSpan;
    /**
     * 열의 span
     */
    private int colSpan;

    /**
     * 생성자
     *
     * @param table    병합할 표
     * @param startRow 행의 시작 인덱스
     * @param startCol 열의 시작 인덱스
     * @param rowSpan  행의 span
     * @param colSpan  열의 span
     */
    private TableCellMerger(ControlTable table, int startRow, int startCol, int rowSpan, int colSpan) {
        this.table = table;
        this.startRow = startRow;
        this.startCol = startCol;
        this.rowSpan = rowSpan;
        this.colSpan = colSpan;
    }

    /**
     * 셀을 병합한다.
     *
     * @return 병합 성공 여부
     */
    private boolean merge() {
        if (possible()) {
            resetMergedCell();
            removeRestCell();
            resetCellCountOfRow();
            return true;
        }
        return false;
    }

    /**
     * 병합 할 수 있는지 체크한다.
     *
     * @return 병합 할 수 있는지 여부
     */
    private boolean possible() {
        return isInTable() && checkAreaLeft() && checkAreaTop() && checkAreaRight() && checkAreaBottom();
    }

    /**
     * 병합할 셀의 위치가 테이블 안에 있는지 체크한다.
     *
     * @return 병합할 셀의 위치가 테이블 안에 있는지 여부
     */
    private boolean isInTable() {
        return 0 <= startRow && getEndRow() < table.getTable().getRowCount() && 0 <= startCol
                && getEndCol() < table.getTable().getColumnCount();
    }

    /**
     * 행의 끝 인덱스를 반환한다.
     *
     * @return 행의 끝 인덱스
     */
    private int getEndRow() {
        return startRow + rowSpan - 1;
    }

    /**
     * 열의 끝 인덱스를 반환한다.
     *
     * @return 열의 끝 인덱스
     */
    private int getEndCol() {
        return startCol + colSpan - 1;
    }

    /**
     * 병합 영역의 왼쪽 부분이 병합 가능한지 체크한다.
     *
     * @return 병합 영역의 왼쪽 부분이 병합 가능한지 여부
     */
    private boolean checkAreaLeft() {
        for (int rowIndex = startRow; rowIndex <= getEndRow(); rowIndex++) {
            Cell cell = findCell(rowIndex, startCol);
            if (cell == null) {
                return false;
            }
            ListHeaderForCell lhc = cell.getListHeader();
            if (lhc.getColIndex() != startCol) {
                return false;
            }
        }
        return true;
    }

    /**
     * rowIndex의 행과 colIndex의 열을 포함하고 있는 셀을 찾는다.
     *
     * @param rowIndex 찾을 행의 인덱스
     * @param colIndex 찾을 열의 인덱스
     * @return rowIndex의 행과 colIndex의 열을 포함하고 있는 셀
     */
    private Cell findCell(int rowIndex, int colIndex) {
        for (Row row : table.getRowList()) {
            for (Cell cell : row.getCellList()) {
                ListHeaderForCell lhc = cell.getListHeader();
                if (lhc.getRowIndex() <= rowIndex && rowIndex <= lhc.getRowIndex() + lhc.getRowSpan() - 1
                        && lhc.getColIndex() <= colIndex && colIndex <= lhc.getColIndex() + lhc.getColSpan() - 1) {
                    return cell;
                }
            }
        }
        return null;
    }

    /**
     * 병합 영역의 위쪽 부분이 병합 가능한지 체크한다.
     *
     * @return 병합 영역의 위쪽 부분이 병합 가능한지 여부
     */
    private boolean checkAreaTop() {
        for (int colIndex = startCol; colIndex <= getEndCol(); colIndex++) {
            Cell cell = findCell(startRow, colIndex);
            if (cell == null) {
                return false;
            }
            ListHeaderForCell lhc = cell.getListHeader();
            if (lhc.getRowIndex() != startRow) {
                return false;
            }
        }
        return true;
    }

    /**
     * 병합 영역의 오른쪽 부분이 병합 가능한지 체크한다.
     *
     * @return 병합 영역의 오른쪽 부분이 병합 가능한지 여부
     */
    private boolean checkAreaRight() {
        for (int rowIndex = startRow; rowIndex <= getEndRow(); rowIndex++) {
            Cell cell = findCell(rowIndex, getEndCol());
            if (cell == null) {
                return false;
            }
            ListHeaderForCell lhc = cell.getListHeader();
            if (lhc.getColIndex() + lhc.getRowSpan() - 1 != getEndCol()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 병합 영역의 아래쪽 부분이 병합 가능한지 체크한다.
     *
     * @return 병합 영역의 아래쪽 부분이 병합 가능한지 여부
     */
    private boolean checkAreaBottom() {
        for (int colIndex = startCol; colIndex <= getEndCol(); colIndex++) {
            Cell cell = findCell(getEndRow(), colIndex);
            if (cell == null) {
                return false;
            }
            ListHeaderForCell lhc = cell.getListHeader();
            if (lhc.getRowIndex() + lhc.getRowSpan() - 1 != getEndRow()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 마스터 셀를 설정한다.
     */
    private void resetMergedCell() {
        Cell cell = findCell(startRow, startCol);
        ListHeaderForCell lhc = cell.getListHeader();
        lhc.setRowSpan(rowSpan);
        lhc.setColSpan(colSpan);
        lhc.setWidth(getMergedWidth());
        lhc.setHeight(getMergedHeight());
    }

    /**
     * 병합된 셀의 너비를 계산한다.
     *
     * @return 병합된 셀의 너비
     */
    private long getMergedWidth() {
        int width = 0;
        Row row = table.getRowList().get(startRow);
        for (Cell cell : row.getCellList()) {
            ListHeaderForCell lhc = cell.getListHeader();
            if (lhc.getColSpan() >= startCol && lhc.getColIndex() + lhc.getColSpan() - 1 <= getEndCol()) {
                width += lhc.getWidth();
            }
        }
        return width;
    }

    /**
     * 병합된 셀의 높이를 계산한다.
     *
     * @return 병합된 셀의 높이
     */
    private int getMergedHeight() {
        int height = 0;
        for (int rowIndex = startRow; rowIndex <= getEndRow(); rowIndex++) {
            Row row = table.getRowList().get(rowIndex);
            for (Cell cell : row.getCellList()) {
                ListHeaderForCell lhc = cell.getListHeader();
                if (lhc.getColIndex() == startCol) {
                    height += lhc.getHeight();
                }
            }
        }
        return height;
    }

    /**
     * 병합된 영역의 나머지 셀들을 제거한다.
     */
    private void removeRestCell() {
        Vector<Cell> removeCells = new Vector<Cell>();
        for (int rowIndex = startRow; rowIndex <= getEndRow(); rowIndex++) {
            Row row = table.getRowList().get(rowIndex);
            for (Cell cell : row.getCellList()) {
                ListHeaderForCell lhc = cell.getListHeader();
                if (lhc.getRowIndex() == startRow && lhc.getColIndex() == startCol) {
                    continue;
                } else if (lhc.getColIndex() >= startCol && lhc.getColIndex() + lhc.getColSpan() - 1 <= getEndCol()) {
                    removeCells.add(cell);
                }
            }

            for (Cell c : removeCells) {
                row.getCellList().remove(c);
            }
            removeCells.clear();
        }
    }

    /**
     * 행 별로 셀의 갯수를 다시 설정한다.
     */
    private void resetCellCountOfRow() {
        table.getTable().getCellCountOfRowList().clear();

        int rowCount = table.getRowList().size();
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            int cellCount = table.getRowList().get(rowIndex).getCellList().size();
            table.getTable().addCellCountOfRow(cellCount);
        }
    }
}

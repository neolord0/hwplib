package kr.dogfoot.hwplib.object.bodytext.control.table;

import java.util.ArrayList;

/**
 * 표의 행을 나타내는 객체
 *
 * @author neolord
 */
public class Row {
    /**
     * 셀 리스트
     */
    private ArrayList<Cell> cellList;

    /**
     * 생성자
     */
    public Row() {
        cellList = new ArrayList<Cell>();
    }

    /**
     * 새로운 셀 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 셀 객체
     */
    public Cell addNewCell() {
        Cell c = new Cell();
        cellList.add(c);
        return c;
    }

    /**
     * 셀 리스트를 반환한다.
     *
     * @return 셀 리스트
     */
    public ArrayList<Cell> getCellList() {
        return cellList;
    }
}

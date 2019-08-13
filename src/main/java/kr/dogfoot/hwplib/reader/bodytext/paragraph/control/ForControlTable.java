package kr.dogfoot.hwplib.reader.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.bookmark.ForCtrlData;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForCaption;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForCtrlHeaderGso;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.tbl.ForCell;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.tbl.ForTable;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 표 컨트롤을 읽기 위한 객체
 *
 * @author 박성균
 */
public class ForControlTable {
    /**
     * 표 컨트롤
     */
    private ControlTable table;
    /**
     * 스트림 리더
     */
    private StreamReader sr;

    /**
     * 생성자
     */
    public ForControlTable() {
    }

    /**
     * 표 컨트롤을 읽는다.
     *
     * @param table 표 컨트롤 객체
     * @param sr    스트림 리더
     * @throws Exception
     */
    public void read(ControlTable table, StreamReader sr) throws Exception {
        this.table = table;
        this.sr = sr;

        ctrlHeader();
        ctrlData();
        caption();
        table();
        rows();
    }

    /**
     * 표 컨트롤의 컨트롤 헤더 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void ctrlHeader() throws IOException {
        ForCtrlHeaderGso.read(table.getHeader(), sr);
    }


    /**
     * 컨트롤 데이터를 읽는다.
     *
     * @throws Exception
     */
    private void ctrlData() throws Exception {
        sr.readRecordHeder();
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.CTRL_DATA) {
            table.createCtrlData();
            ForCtrlData.read(table.getCtrlData(), sr);
        }
    }


    /**
     * 캡션 정보를 읽는다.
     *
     * @throws Exception
     */
    private void caption() throws Exception {
        if (sr.isImmediatelyAfterReadingHeader() == false) {
            sr.readRecordHeder();
        }
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.LIST_HEADER) {
            table.createCaption();
            ForCaption.read(table.getCaption(), sr);
        }
    }

    /**
     * 표 정보 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void table() throws IOException {
        if (sr.isImmediatelyAfterReadingHeader() == false) {
            sr.readRecordHeder();
        }
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.TABLE) {
            ForTable.read(table.getTable(), sr);
        }
    }

    /**
     * 행들을 읽는다.
     *
     * @throws Exception
     */
    private void rows() throws Exception {
        int rowCount = table.getTable().getRowCount();
        ArrayList<Integer> cellCountOfRow = table.getTable()
                .getCellCountOfRowList();
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            Row r = table.addNewRow();
            row(r, cellCountOfRow.get(rowIndex));
        }
    }

    /**
     * 하나의 행 안에 셀들을 읽는다.
     *
     * @param r         행
     * @param cellCount 행에 포함된 셀 개수
     * @throws Exception
     */
    private void row(Row r, int cellCount) throws Exception {
        for (int cellIndex = 0; cellIndex < cellCount; cellIndex++) {
            Cell c = r.addNewCell();
            ForCell.read(c, sr);
        }
    }
}

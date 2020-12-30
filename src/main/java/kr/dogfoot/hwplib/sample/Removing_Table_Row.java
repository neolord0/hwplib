package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

/**
 * 표의 열을 삭제하는 샘플 프로그램.
 */
public class Removing_Table_Row {
    public static void main(String[] args) throws Exception {
        String filename = "sample_hwp" + File.separator + "removing-row.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            ControlTable table = findTable(hwpFile);
            removeSecondRowObject(table);
            adjustTableRowCount(table);
            removeCellCountOfRow(table);
            adjustCellRowIndex(table);

            String writePath = "sample_hwp" + File.separator + "result-removing-row.hwp";
            HWPWriter.toFile(hwpFile, writePath);
        }
    }


    private static void removeSecondRowObject(ControlTable table) {
        table.getRowList().remove(1);
    }

    private static void adjustTableRowCount(ControlTable table) {
        table.getTable().setRowCount(table.getRowList().size());
    }

    private static void removeCellCountOfRow(ControlTable table) {
        table.getTable().getCellCountOfRowList().remove(1);
    }

    private static void adjustCellRowIndex(ControlTable table) {
        int rowCount = table.getRowList().size();
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            if (rowIndex > 0) {
                Row row = table.getRowList().get(rowIndex);
                for(Cell cell : row.getCellList()) {
                   cell.getListHeader().setRowIndex(cell.getListHeader().getRowIndex() - 1);
                }
            }
        }
    }

    private static ControlTable findTable(HWPFile hwpFile) {
        Section s = hwpFile.getBodyText().getSectionList().get(0);
        Paragraph firstParagraph = s.getParagraph(0);
        assert (firstParagraph.getControlList().get(2).getType() == ControlType.Table);
        return (ControlTable) (firstParagraph.getControlList().get(2));
    }
}


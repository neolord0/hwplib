import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test6 {
    public static void main(String[] args) throws Exception {
        test2();
    }

    private static void test2() throws Exception {
        String filename = "test" + File.separator + "테이블 테스트.hwp";
        HWPFile hwpFile = HWPReader.fromFile(filename);
        ControlTable table = getTable(hwpFile);

        // Column 삭제와 셀의 colIndex 조정
        for(Row row : table.getRowList()) {
            Cell deletingCell = null;
            for (Cell cell : row.getCellList()) {
                if (cell.getListHeader().getColIndex() == 1) {
                    deletingCell = cell;
                } else if (cell.getListHeader().getColIndex() > 1) {
                    cell.getListHeader().setColIndex(cell.getListHeader().getColIndex() - 1);
                }
            }

            if (deletingCell != null) {
                row.getCellList().remove(deletingCell);
            }
        }

        // 각 Row 당 삭제할 row 를 제외한 Column 개수 저장
        List<Integer> newCellCountOfRow = new ArrayList<Integer>();
        for (int cellCount : table.getTable().getCellCountOfRowList()) {
            newCellCountOfRow.add(cellCount - 1);
        }

        // Table cell count list 초기화
        table.getTable().getCellCountOfRowList().clear();

        // Table에 각 Row마다 cell 개수 추가
        for (int cellCount : newCellCountOfRow) {
            table.getTable().addCellCountOfRow(cellCount);
        }

        // Table 전체 cell 개수 업데이트
        table.getTable().setColumnCount(table.getTable().getColumnCount() - 1);

        HWPWriter.toFile(hwpFile, "test" + File.separator + "a.hwp");
    }

    private static ControlTable getTable(HWPFile hwpFile) {
        return (ControlTable) hwpFile
                .getBodyText()
                .getSectionList().get(0)
                .getParagraph(0)
                .getControlList().get(2);
    }
}

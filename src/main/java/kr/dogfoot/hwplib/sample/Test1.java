package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.reader.HWPReader;

import java.io.File;

public class Test1 {
    public static void main(String[] args) throws Exception {
        String filename = "sample_hwp" + File.separator + "2010 1 무리수와 실수(고난이도)_1회 3-1 중간.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);

        Control c = hwpFile.getBodyText().getSectionList().get(0).getParagraph(0).getControlList().get(2);
        ControlTable table = (ControlTable) c;
        for(Row r : table.getRowList()) {
            for (Cell cell : r.getCellList()) {
                System.out.print("   " + cell.getListHeader().getRowIndex() + ";" + cell.getListHeader().getColIndex());
            }
            System.out.println("");
        }
    }
}

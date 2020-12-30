package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.TableCellMerger;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

/**
 * 표의 셀을 병합하는 샘플 프로그램.
 */
public class Merging_Cell {
    public static void main(String[] args) throws Exception {
        String filename = "sample_hwp" + File.separator + "merging-cell.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            Control control = hwpFile.getBodyText().getSectionList().get(0).getParagraph(0).getControlList().get(2);
            if (control.getType() == ControlType.Table) {
                ControlTable table = (ControlTable) control;
                TableCellMerger.mergeCell(table, 2, 2, 4, 3);
            }

            String writePath = "sample_hwp" + File.separator + "result-merging-cell.hwp";
            HWPWriter.toFile(hwpFile, writePath);
        }
    }
}

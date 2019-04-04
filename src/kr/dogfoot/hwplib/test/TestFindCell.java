package kr.dogfoot.hwplib.test;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.objectfinder.CellFinder;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class TestFindCell {
    public static void main(String[] args) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile("sample_hwp" + File.separator + "test-findcell.hwp");

        setCellTestByFieldName(hwpFile, "필드명1", "ABCD");
        setCellTestByFieldName(hwpFile, "필드명2", "가나다라");
        setCellTestByFieldName(hwpFile, "필드명3", "1234");

        HWPWriter.toFile(hwpFile, "sample_hwp" + File.separator + "edit_test-findcell.hwp");
    }

    private static void setCellTestByFieldName(HWPFile hwpFile, String fieldName, String fieldText) throws UnsupportedEncodingException {
        ArrayList<Cell> cellList = CellFinder.findAll(hwpFile, fieldName);
        for (Cell c : cellList) {
            Paragraph firstPara = c.getParagraphList().getParagraph(0);
            ParaText paraText = firstPara.getText();
            if (paraText == null) {
                firstPara.createText();
                paraText = firstPara.getText();
            }

            paraText.addString(fieldText);
        }
    }
}

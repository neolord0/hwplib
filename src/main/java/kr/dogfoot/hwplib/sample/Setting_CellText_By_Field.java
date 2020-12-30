package kr.dogfoot.hwplib.sample;

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

/**
 * 필드 이름으로 표의 셀을 찾아서, 텍스트를 설정하는 샘플 프로그램.
 */
public class Setting_CellText_By_Field {
    public static void main(String[] args) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile("sample_hwp" + File.separator + "setting-celltext-by-field.hwp");

        setCellTextByField(hwpFile, "필드명1", "ABCD");
        setCellTextByField(hwpFile, "필드명2", "가나다라");
        setCellTextByField(hwpFile, "필드명3", "1234");

        HWPWriter.toFile(hwpFile, "sample_hwp" + File.separator + "result-setting-celltext-by-field.hwp");
    }

    private static void setCellTextByField(HWPFile hwpFile, String fieldName, String fieldText) throws UnsupportedEncodingException {
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

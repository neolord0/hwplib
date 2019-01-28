package kr.dogfoot.hwplib.test;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.objectfinder.FieldFinder;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;

import javax.xml.soap.Text;
import java.io.File;
import java.util.ArrayList;

public class TestFindAllField {

    public static void main(String[] args) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile("sample_hwp" + File.separator + "test-find-allfield.hwp");
        if (hwpFile != null) {
            ArrayList<String> result = FieldFinder.getAllClickHereText(hwpFile,
                    "필드A", TextExtractMethod.OnlyMainParagraph);
            for (String text : result) {
                System.out.println("\"필드A\"= " + text);
            }
            ArrayList<String> result2 = FieldFinder.getAllFieldText(hwpFile, ControlType.FIELD_CLICKHERE,
                    "필드B", TextExtractMethod.OnlyMainParagraph);
            for (String text : result2) {
                System.out.println("\"필드B\" =" + text);
            }
        }
    }
}

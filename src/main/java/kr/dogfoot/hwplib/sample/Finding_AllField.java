package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.objectfinder.FieldFinder;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;

import java.io.File;
import java.util.ArrayList;


/**
 * 파일에 있는 모든 필드 컨트롤의 텍스트를 찾는 샘플 프로그램.
 */
public class Finding_AllField {
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

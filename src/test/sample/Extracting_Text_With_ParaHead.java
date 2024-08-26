package sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractor;

import java.io.File;

public class Extracting_Text_With_ParaHead {
    public static void main(String[] args) throws Exception {
        String filename = "sample_hwp" + File.separator + "extracting_ParaHead.hwp";
        HWPFile hwpFile = HWPReader.fromFile(filename);

        String str = TextExtractor.extract(hwpFile, TextExtractMethod.AppendControlTextAfterParagraphText);
        System.out.println(str);
    }
}

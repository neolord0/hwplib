import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;

import java.io.File;

public class Test {
    public static void main(String[] args) throws Exception {
//        HWPFile hwpFile = HWPReader.fromFile("test" + File.separator + "HF.hwp");
        HWPFile hwpFile2 = HWPReader.fromFile("sample_hwp" + File.separator + "result-inserting-headerfooter.hwp");
    }
}

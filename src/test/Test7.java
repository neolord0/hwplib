import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

public class Test7 {
    public static void main(String[] args) throws Exception {
        String filename = "test" + File.separator + "20230427.hwp";
        HWPFile hwpFile = HWPReader.fromFile(filename);
        HWPWriter.toFile(hwpFile, "test" + File.separator + "20230427_re.hwp");
    }
}
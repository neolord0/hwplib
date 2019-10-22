import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

public class PageNumberControl {
    public static void main(String[] args) throws Exception {

        String filename = "sample_hwp" + File.separator + "20010_sample.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);

        String writePath = filename.substring(0, 11) + "re-" + filename.substring(11);
        HWPWriter.toFile(hwpFile, writePath);


    }
}

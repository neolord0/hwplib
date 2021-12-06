import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlTextArt;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

public class Test_imsi {
    public static void main(String[] args) throws Exception {
        String filename = "test" + File.separator + "test44.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);

        /*
        String filename = "test" + File.separator + "테스트.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            ControlTextArt textArt = (ControlTextArt) hwpFile.getBodyText().getSectionList().get(0).getParagraph(0).getControlList().get(2);
            System.out.println(textArt.getHeader().getProperty().getHeightCriterion());
            System.out.println(textArt.getHeader().getProperty().getWidthCriterion());

            String filename2 = "test" + File.separator + "테스트_re.hwp";
            HWPWriter.toFile(hwpFile, filename2);

            HWPFile hwpFile2 = HWPReader.fromFile(filename2);
        }

         */
    }
}

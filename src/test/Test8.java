import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;

public class Test8 {
    public static void main(String[] args) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile("test/test.hwp");
    }

}

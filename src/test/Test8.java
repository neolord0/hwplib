import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;

import java.io.File;

public class Test8 {
    public static void main(String[] args) throws Exception {
        File dir = new File("test/테스트문서1116");
        File files[] = dir.listFiles();

        for (File file : files) {
            System.out.print("file: " + file);
            try  {
                HWPFile hwpFile = HWPReader.fromFile(file);
            } catch (Exception e) {
                System.out.print(" - error");
            }
            System.out.println("");
        }
    }
}

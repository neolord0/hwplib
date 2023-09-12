import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.docinfo.FaceName;
import kr.dogfoot.hwplib.object.docinfo.ParaShape;
import kr.dogfoot.hwplib.reader.HWPReader;

public class Test8 {
    public static void main(String[] args) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile("test/test22.hwp");
        for (ParaShape paraShape : hwpFile.getDocInfo().getParaShapeList()) {
            System.out.println(paraShape.getLineSpace() + " " + paraShape.getProperty1().getLineDivideForHangul() + " " + paraShape.getProperty1().getLineDivideForEnglish());
        }
    }
}

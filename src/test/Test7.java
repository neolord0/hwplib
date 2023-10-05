import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ControlSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlRectangle;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItemTag;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;
import kr.dogfoot.hwplib.object.docinfo.Style;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.util.binary.BitFlag;

public class Test7 {
    public static void main(String[] args) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile("test/y15_부가46015-869_19960504.hwp");
    }
}

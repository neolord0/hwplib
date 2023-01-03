import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphAdder;

import java.io.File;

public class Test7 {
    public static void main(String[] args) throws Exception {
/*
        File sourcePath = new File("test/02merge전본문.hwp");
        File targetPath = new File("test/bad-target.hwp");
        HWPFile targetHWPFile = HWPReader.fromFile(targetPath.getAbsolutePath());

        addHWPFile(targetHWPFile, sourcePath.getAbsolutePath());

 */
        HWPFile hwpFile = HWPReader.fromFile("test/hwp1.hwp");
    }
    private static void addHWPFile(HWPFile targetHWPFile, String sourceHWPFilePath) throws Exception {
        ParagraphListInterface targetFirstSection = targetHWPFile.getBodyText().getSectionList().get(0);

        HWPFile sourceHWPFile = HWPReader.fromFile(sourceHWPFilePath);

        {
            Paragraph sourceParagraph = sourceHWPFile.getBodyText().getSectionList().get(0).getParagraph(0);

            ParagraphAdder paraAdder = new ParagraphAdder(targetHWPFile, targetFirstSection, 0);
            paraAdder.add(sourceHWPFile, sourceParagraph);
        }
    }
}

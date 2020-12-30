package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphAdder;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

/**
 * 다른 파일에 문단을 복사하여 복사된 한글 파일 객체에 추가하는 샘플 프로그램.
 */
public class Adding_Paragraph_Between_Cloned_HWPFIle {
    public static void main(String[] args) throws Exception {
        HWPFile targetHWPFile = HWPReader.fromFile("sample_hwp" + File.separator + "target.hwp");
        HWPFile clonedTargetHWPFile = targetHWPFile.clone(false);

        addHWPFile(targetHWPFile, "sample_hwp" + File.separator + "source.hwp");
        HWPWriter.toFile(targetHWPFile, "sample_hwp" + File.separator +"result-adding-paragraph.hwp");

        addHWPFile(clonedTargetHWPFile, "sample_hwp" + File.separator + "merging-cell.hwp");
        HWPWriter.toFile(clonedTargetHWPFile, "sample_hwp" + File.separator +"result-dding-paragraph-to-cloned-hwpfile.hwp");
    }

    private static void addHWPFile(HWPFile targetHWPFile, String sourceHWPFilePath) throws Exception {
        ParagraphListInterface targetFirstSection = targetHWPFile.getBodyText().getSectionList().get(0);

        HWPFile sourceHWPFile = HWPReader.fromFile(sourceHWPFilePath);
        {
            Paragraph sourceParagraph = sourceHWPFile.getBodyText().getSectionList().get(0).getParagraph(0);

            ParagraphAdder paraAdder = new ParagraphAdder(targetHWPFile, targetFirstSection);
            paraAdder.add(sourceHWPFile, sourceParagraph);
        }
        {
            Paragraph sourceParagraph = sourceHWPFile.getBodyText().getSectionList().get(0).getParagraph(1);

            ParagraphAdder paraAdder = new ParagraphAdder(targetHWPFile, targetFirstSection);
            paraAdder.add(sourceHWPFile, sourceParagraph);
        }
    }
}

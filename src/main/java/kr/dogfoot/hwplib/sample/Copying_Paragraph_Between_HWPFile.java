package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphAdder;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

/**
 * 다른 파일 사이에 문단을 복사하는 샘플 프로그램.
 */
public class Copying_Paragraph_Between_HWPFile {
    public static void main(String[] args) throws Exception {
        HWPFile sourceHWPFile = HWPReader.fromFile("sample_hwp" + File.separator + "test-source.hwp");
        HWPFile targetHWPFile = HWPReader.fromFile("sample_hwp" + File.separator + "test-target.hwp");

        if (sourceHWPFile != null && targetHWPFile != null) {

            ParagraphListInterface targetFirstSection = targetHWPFile.getBodyText().getSectionList().get(0);
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
            {
                Paragraph sourceParagraph = sourceHWPFile.getBodyText().getSectionList().get(0).getParagraph(5);

                ParagraphAdder paraAdder = new ParagraphAdder(targetHWPFile, targetFirstSection);
                paraAdder.add(sourceHWPFile, sourceParagraph);
            }

            HWPWriter.toFile(targetHWPFile, "sample_hwp" + File.separator +"test-target-add-paragraph.hwp");
        }
   }
}
package kr.dogfoot.hwplib.test;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphAdder;
import kr.dogfoot.hwplib.writer.HWPWriter;

public class TestParagraphAdder {
	public static void main(String[] args) throws Exception {
		HWPFile sourceHWPFile = HWPReader.fromFile("sample_hwp\\test-source.hwp");
		HWPFile targetHWPFile = HWPReader.fromFile("sample_hwp\\test-target.hwp");
		
		if (sourceHWPFile != null && targetHWPFile != null) {
			// test-source.hwp의  두번째 문단을 구한다
			Paragraph sourceParagraph = sourceHWPFile.getBodyText().getSectionList().get(0).getParagraph(1);
	
			// test-target.hwp의 첫번째 섹션을 구한다. 
			ParagraphListInterface targetFirstSection = targetHWPFile.getBodyText().getSectionList().get(0);
			
			ParagraphAdder paraAdder = new ParagraphAdder(targetHWPFile, targetFirstSection);
			paraAdder.add(sourceHWPFile, sourceParagraph);
			
			HWPWriter.toFile(targetHWPFile, "sample_hwp\\\\test-target-add-paragraph.hwp");
		}
	}
}
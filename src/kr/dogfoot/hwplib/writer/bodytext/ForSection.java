package kr.dogfoot.hwplib.writer.bodytext;

import java.io.IOException;
import java.util.ArrayList;

import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.ForParagraph;

public class ForSection {
	public static void write(Section s, StreamWriter sw) throws IOException {
		paragraphList(s.getParagraphList(), sw);
		if (s.getLastBatangPageInfo() != null) {
			ForBatangPageInfo.write(s.getLastBatangPageInfo(), sw);
		}
	}

	private static void paragraphList(ArrayList<Paragraph> paragraphList,
			StreamWriter sw) throws IOException {
		for (Paragraph p : paragraphList) {
			sw.setCurrentParagraphLevel(0);
			ForParagraph.write(p, sw);
		}
	}
}

package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import java.io.IOException;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.ForControl;

public class ForParagraph {
	public static void write(Paragraph p, StreamWriter sw) throws IOException {
		ForParaHeader.write(p.getHeader(), sw);
		ForParaText.write(p.getText(), sw);
		ForParaCharShape.write(p.getCharShape(), sw);
		ForParaLineSeq.write(p.getLineSeg(), sw);
		ForParaRangeTag.write(p.getRangeTag(), sw);
		controls(p, sw);
	}

	private static void controls(Paragraph p, StreamWriter sw) {
		for (Control c : p.getControlList()) {
			ForControl.write(c, sw);
		}
	}

}

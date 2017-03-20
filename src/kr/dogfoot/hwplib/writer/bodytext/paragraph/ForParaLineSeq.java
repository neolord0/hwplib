package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import java.io.IOException;

import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForParaLineSeq {
	public static void write(ParaLineSeg pls, StreamWriter sw) throws IOException {
		if (pls == null) {
			return;
		}
		
		recordHeader(pls, sw);
		
		for (LineSegItem lsi : pls.getLineSegItemList()) {
			lineSegItem(lsi, sw);
		}
	}

	private static void recordHeader(ParaLineSeg pls, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.PARA_LINE_SEG, sw.getCurrentParagraphLevel() + 1, getSize(pls));
	}

	private static int getSize(ParaLineSeg pls) {
		return pls.getLineSegItemList().size() * 36;
	}

	private static void lineSegItem(LineSegItem lsi, StreamWriter sw) throws IOException {
		sw.writeUInt4(lsi.getTextStartPositon());
		sw.writeSInt4(lsi.getLineVerticalPosition());
		sw.writeSInt4(lsi.getLineHeight());
		sw.writeSInt4(lsi.getTextPartHeight());
		sw.writeSInt4(lsi.getDistanceBaseLineToLineVerticalPosition());
		sw.writeSInt4(lsi.getLineSpace());
		sw.writeSInt4(lsi.getStartPositionFromColumn());
		sw.writeSInt4(lsi.getSegmentWidth());
		sw.writeUInt4(lsi.getTag().getValue());
	}
}

package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.LayoutCompatibility;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForLayoutCompatibility {
	public static void write(LayoutCompatibility lc, StreamWriter sw)
			throws IOException {
		recordHeader(sw);

		sw.writeUInt4(lc.getLetterLevelFormat());
		sw.writeUInt4(lc.getParagraphLevelFormat());
		sw.writeUInt4(lc.getSectionLevelFormat());
		sw.writeUInt4(lc.getObjectLevelFormat());
		sw.writeUInt4(lc.getFieldLevelFormat());
	}

	private static void recordHeader(StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.LAYOUT_COMPATIBILITY, 1, 20);
	}
}

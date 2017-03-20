package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import java.io.IOException;

import kr.dogfoot.hwplib.object.bodytext.paragraph.header.ParaHeader;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForParaHeader {
	public static void write(ParaHeader ph, StreamWriter sw) throws IOException {
		recordHeader(ph, sw);
		
		lastInList_TextCount(ph, sw);
		sw.writeUInt4(ph.getControlMask().getValue());
		sw.writeUInt2(ph.getParaShapeId());
		sw.writeUInt1(ph.getStyleId());
		sw.writeUInt1(ph.getDivideSort().getValue());
		sw.writeUInt2(ph.getCharShapeCount());
		sw.writeUInt2(ph.getRangeTagCount());
		sw.writeUInt2(ph.getLineAlignCount());
		sw.writeUInt4(ph.getInstanceID());
		if(sw.getFileVersion().isOver(5, 0, 3, 2)) {
			sw.writeUInt2(ph.getIsMergedByTrack());
		}
	}
	
	private static void recordHeader(ParaHeader ph, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.PARA_HEADER, sw.getCurrentParagraphLevel(), getSize(sw));
	}

	private static int getSize(StreamWriter sw) {
		int size = 0;
		size += 22;
		if (sw.getFileVersion().isOver(5, 0, 3, 2)) {
			size += 2;
		}
		return size;
	}
	
	private static void lastInList_TextCount(ParaHeader ph, StreamWriter sw) throws IOException {
		long value = 0;
		if (ph.isLastInList()) {
			value += 0x80000000;
		}
		value += ph.getCharacterCount() & 0x7fffffff;
		sw.writeUInt4(value);
 	}
}

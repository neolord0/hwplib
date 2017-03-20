package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import java.io.IOException;

import kr.dogfoot.hwplib.object.bodytext.paragraph.rangetag.ParaRangeTag;
import kr.dogfoot.hwplib.object.bodytext.paragraph.rangetag.RangeTagItem;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForParaRangeTag {
	public static void write(ParaRangeTag prt, StreamWriter sw) throws IOException {
		if (prt == null) {
			return;
		}
		
		recordHeader(prt, sw);
		
		for (RangeTagItem rti : prt.getRangeTagItemList()) {
			rangeTagItem(rti, sw);
		}
	}

	private static void recordHeader(ParaRangeTag prt, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.PARA_RANGE_TAG, sw.getCurrentParagraphLevel(), getSize(prt));
	}

	private static int getSize(ParaRangeTag prt) {
		return prt.getRangeTagItemList().size() * 12;
	}

	private static void rangeTagItem(RangeTagItem rti, StreamWriter sw) throws IOException {
		sw.writeUInt4(rti.getRangeStart());
		sw.writeUInt4(rti.getRangeEnd());
		sw.writeBytes(rti.getData());
		sw.writeUInt1(rti.getSort());
	}

}

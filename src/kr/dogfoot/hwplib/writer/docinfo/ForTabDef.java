package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.TabDef;
import kr.dogfoot.hwplib.object.docinfo.tabdef.TabInfo;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForTabDef {
	public static void write(TabDef td, StreamWriter sw) throws IOException {
		recordHeader(td, sw);
		
		sw.writeUInt4(td.getProperty().getValue());
		
		long tabInfoCount = td.getTabInfoList().size();
		sw.writeUInt4(tabInfoCount);
		if (tabInfoCount > 0) {
			tabInfos(td, sw);
		}
	}

	private static void recordHeader(TabDef td, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.TAB_DEF, 1, getSize(td));
	}

	private static int getSize(TabDef td) {
		int size = 0;
		size += 8;
		size += 8 * td.getTabInfoList().size();
		return size;
	}

	private static void tabInfos(TabDef td, StreamWriter sw) throws IOException {
		for (TabInfo ti : td.getTabInfoList()) {
			sw.writeUInt4(ti.getPosition());
			sw.writeUInt1(ti.getTabSort().getValue());
			sw.writeUInt1(ti.getFillSort().getValue());
			sw.writeZero(2);
		}
	}
}

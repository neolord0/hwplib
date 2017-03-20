package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.CompatibleDocument;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForCompatibleDocument {
	public static void write(CompatibleDocument cd,
			StreamWriter sw) throws IOException {
		recordHeader(cd, sw);
		
		sw.writeUInt4(cd.getTargetProgream().getValue());
	}

	private static void recordHeader(CompatibleDocument cd, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.COMPATIBLE_DOCUMENT, 0, 4);
	}

}

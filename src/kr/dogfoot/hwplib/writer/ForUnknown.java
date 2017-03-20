package kr.dogfoot.hwplib.writer;

import java.io.IOException;

import kr.dogfoot.hwplib.object.etc.UnknownRecord;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForUnknown {
	public static void write(UnknownRecord ur, int tagID, int level, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(tagID, level, ur.getBody().length);
		
		sw.writeBytes(ur.getBody());
	}
}

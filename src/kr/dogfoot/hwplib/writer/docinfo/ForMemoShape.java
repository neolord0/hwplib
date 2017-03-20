package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.object.etc.UnknownRecord;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForMemoShape {
	public static void write(UnknownRecord memoShape, StreamWriter sw) throws IOException {
		recordHeader(memoShape, sw);
		
		sw.writeBytes(memoShape.getBody());
	}

	private static void recordHeader(UnknownRecord memoShape, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.MEMO_SHAPE, 1, memoShape.getBody().length);
	}
}

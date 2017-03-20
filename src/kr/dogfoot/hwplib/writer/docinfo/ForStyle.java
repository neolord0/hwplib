package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.Style;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForStyle {
	public static void write(Style s, StreamWriter sw) throws IOException {
		recordHeader(s, sw);

		sw.writeUTF16LEString(s.getHangulName());
		sw.writeUTF16LEString(s.getEnglishName());
		sw.writeUInt1(s.getProeprty().getValue());
		sw.writeUInt1(s.getNextStyleId());
		sw.writeUInt2(s.getLanguageId());
		sw.writeUInt2(s.getParaShapeId());
		sw.writeUInt2(s.getCharShapeId());
		sw.writeZero(2);
	}

	private static void recordHeader(Style s, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.STYLE, 1, getSize(s));
	}

	private static int getSize(Style s) {
		int size = 0;
		size += StringUtil.getUTF16LEStringSize(s.getHangulName());
		size += StringUtil.getUTF16LEStringSize(s.getEnglishName());
		size += 8 + 2;
		return size;
	}
}

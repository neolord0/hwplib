package kr.dogfoot.hwplib.test;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.objectfinder.FieldFinder;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

public class TestSetClickHereFieldText {
	public static void main(String[] args) throws Exception {
		HWPFile hwpFile = HWPReader.fromFile("sample_hwp\\test-필드_누름틀.hwp");
		if (hwpFile != null) {
			FieldFinder.setClickHereText(hwpFile, "필드1", "필드값abc123");
			FieldFinder.setClickHereText(hwpFile, "필드2", "필드 값def456789");
			
			HWPWriter.toFile(hwpFile, "sample_hwp\\test-필드_누름틀_saved.hwp");
			
		}
	}
}

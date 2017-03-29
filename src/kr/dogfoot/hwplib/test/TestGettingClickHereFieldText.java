package kr.dogfoot.hwplib.test;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.objectfinder.FieldFinder;
import kr.dogfoot.hwplib.reader.HWPReader;

public class TestGettingClickHereFieldText {
	public static void main(String[] args) throws Exception {
		HWPFile hwpFile = HWPReader.fromFile("sample_hwp\\test-필드_누름틀.hwp");
		String text1 = FieldFinder.getClickHereText(hwpFile, "필드1");
		String text2 = FieldFinder.getClickHereText(hwpFile, "필드2");
		String text3 = FieldFinder.getClickHereText(hwpFile, "Table필드1");
		String text4 = FieldFinder.getClickHereText(hwpFile, "xxx");
		System.out.println("필드1 ==> " + text1);
		System.out.println("필드2 ==> " + text2);
		System.out.println("필드3 ==> " + text3);
		System.out.println("xxx ==> " + text4);
		
	}
}

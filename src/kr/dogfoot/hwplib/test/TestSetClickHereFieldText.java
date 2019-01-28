package kr.dogfoot.hwplib.test;

import java.io.File;
import java.util.ArrayList;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.objectfinder.FieldFinder;
import kr.dogfoot.hwplib.tool.objectfinder.SetFieldResult;
import kr.dogfoot.hwplib.writer.HWPWriter;

public class TestSetClickHereFieldText {
	public static void main(String[] args) throws Exception {
		HWPFile hwpFile = HWPReader.fromFile("sample_hwp" + File.separator + "test-필드_누름틀.hwp");
		if (hwpFile != null) {
			{
				ArrayList<String> textList = new ArrayList<String>();
				textList.add("필드1 값1");
				SetFieldResult sfr = FieldFinder.setClickHereText(hwpFile, "필드1", textList);
				System.out.println("필드1 설정경과  = " + sfr);
			}
			{
				ArrayList<String> textList = new ArrayList<String>();
				textList.add("필드2 값1");
				SetFieldResult sfr = FieldFinder.setClickHereText(hwpFile, "필드2", textList);
				System.out.println("필드2 설정경과  = " + sfr);
			}

			HWPWriter.toFile(hwpFile, "sample_hwp" + File.separator + "test-필드_누름틀_saved.hwp");
		}
	}
}

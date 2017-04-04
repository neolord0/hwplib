package kr.dogfoot.hwplib.test;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;

public class TestReadingHWPFile {
	public static void main(String[] args) throws Exception {
		test("sample_hwp\\test-blank.hwp");
		test("sample_hwp\\test-etc.hwp");
		test("sample_hwp\\test-ole.hwp");
		test("sample_hwp\\test-각주미주.hwp");
		test("sample_hwp\\test-그림.hwp");
		test("sample_hwp\\test-글상자.hwp");
		test("sample_hwp\\test-글상자-압축.hwp");
		test("sample_hwp\\test-글자겹침.hwp");
		test("sample_hwp\\test-덧말.hwp");
		test("sample_hwp\\test-머리글꼬리글.hwp");
		test("sample_hwp\\test-묶음.hwp");
		test("sample_hwp\\test-바탕쪽.hwp");
		test("sample_hwp\\test-새번호지정.hwp");
		test("sample_hwp\\test-선-사각형.hwp");
		test("sample_hwp\\test-수식.hwp");
		test("sample_hwp\\test-숨은설명.hwp");
		test("sample_hwp\\test-이미지추가.hwp");
		test("sample_hwp\\test-차트.hwp");
		test("sample_hwp\\test-책갈피.hwp");
		test("sample_hwp\\test-페이지숨김.hwp");
		test("sample_hwp\\test-필드.hwp");
		test("sample_hwp\\test-필드_누름틀.hwp");
	}

	private static void test(String filename) throws Exception {
		HWPFile hwpFile = HWPReader.fromFile(filename);
		if (hwpFile.getBodyText().getSectionList().size() > 0){
			System.out.println(filename + "  읽기 성공 !!");
		}
	}
}

package kr.dogfoot.hwplib.test;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.textextractor.TextExtractMethod;
import kr.dogfoot.hwplib.textextractor.TextExtractor;

public class TestExtractingText {

	public static void main(String[] args) throws Exception {
		TextExtractMethod tem = TextExtractMethod.InsertControlTextBetweenParagraphText;
		test("sample_hwp\\test-blank.hwp", tem);
		test("sample_hwp\\test-etc.hwp", tem);
		test("sample_hwp\\test-ole.hwp", tem);
		test("sample_hwp\\test-각주미주.hwp", tem);
		test("sample_hwp\\test-그림.hwp", tem);
		test("sample_hwp\\test-글상자.hwp", tem);
		test("sample_hwp\\test-글상자-압축.hwp", tem);
		test("sample_hwp\\test-글자겹침.hwp", tem);
		test("sample_hwp\\test-덧말.hwp", tem);
		test("sample_hwp\\test-머리글꼬리글.hwp", tem);
		test("sample_hwp\\test-묶음.hwp", tem);
		test("sample_hwp\\test-바탕쪽.hwp", tem);
		test("sample_hwp\\test-새번호지정.hwp", tem);
		test("sample_hwp\\test-선-사각형-타원.hwp", tem);
		test("sample_hwp\\test-수식.hwp", tem);
		test("sample_hwp\\test-숨은설명.hwp", tem);
		test("sample_hwp\\test-이미지추가.hwp", tem);
		test("sample_hwp\\test-차트.hwp", tem);
		test("sample_hwp\\test-책갈피.hwp", tem);
		test("sample_hwp\\test-페이지숨김.hwp", tem);
		test("sample_hwp\\test-표.hwp", tem);
		test("sample_hwp\\test-필드.hwp", tem);
		test("sample_hwp\\test-필드_누름틀.hwp", tem);
		test("sample_hwp\\test-호 곡선.hwp", tem);
		test("sample_hwp\\[붙임1]정부포상 추천 구비서류 서식.hwp", tem);
	}

	private static void test(String filename, TextExtractMethod tem)
			throws Exception {
		HWPFile hwpFile = HWPReader.fromFile(filename);
		System.out.println(filename + "  읽기 성공 !!");
		System.out.println("");
		String hwpText = TextExtractor.extract(hwpFile, tem);
		System.out.println(hwpText);
		System.out
				.println("========================================================");
	}
}

package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractor;

import java.io.File;


/**
 * 파일에 전체 텍스트를 추출하는 샘플 프로그램
 */
public class Extracting_Text {
    public static void main(String[] args) throws Exception {
        TextExtractMethod tem = TextExtractMethod.InsertControlTextBetweenParagraphText;
        test("sample_hwp" + File.separator + "big_file.hwp", tem);
     /*
        test("sample_hwp" + File.separator + "test-etc.hwp", tem);
        test("sample_hwp" + File.separator + "test-ole.hwp", tem);
        test("sample_hwp" + File.separator + "test-각주미주.hwp", tem);
        test("sample_hwp" + File.separator + "test-그림.hwp", tem);
        test("sample_hwp" + File.separator + "test-글상자.hwp", tem);
        test("sample_hwp" + File.separator + "test-글상자-압축.hwp", tem);
        test("sample_hwp" + File.separator + "test-글자겹침.hwp", tem);
        test("sample_hwp" + File.separator + "test-덧말.hwp", tem);
        test("sample_hwp" + File.separator + "test-머리글꼬리글.hwp", tem);
        test("sample_hwp" + File.separator + "test-묶음.hwp", tem);
        test("sample_hwp" + File.separator + "test-바탕쪽.hwp", tem);
        test("sample_hwp" + File.separator + "test-새번호지정.hwp", tem);
        test("sample_hwp" + File.separator + "test-선-사각형-타원.hwp", tem);
        test("sample_hwp" + File.separator + "test-수식.hwp", tem);
        test("sample_hwp" + File.separator + "test-숨은설명.hwp", tem);
        test("sample_hwp" + File.separator + "test-이미지추가.hwp", tem);
        test("sample_hwp" + File.separator + "test-차트.hwp", tem);
        test("sample_hwp" + File.separator + "test-책갈피.hwp", tem);
        test("sample_hwp" + File.separator + "test-페이지숨김.hwp", tem);
        test("sample_hwp" + File.separator + "test-표.hwp", tem);
        test("sample_hwp" + File.separator + "test-필드.hwp", tem);
        test("sample_hwp" + File.separator + "test-필드_누름틀.hwp", tem);
        test("sample_hwp" + File.separator + "test-호 곡선.hwp", tem);
        test("sample_hwp" + File.separator + "test-[붙임1]정부포상 추천 구비서류 서식.hwp", tem);

      */
    }

    private static void test(String filename, TextExtractMethod tem)
            throws Exception {
        HWPFile hwpFile = HWPReader.fromFile(filename);
        System.out.println(filename + "  읽기 성공 !!");
        System.out.println();
        String hwpText = TextExtractor.extract(hwpFile, tem);
        System.out.println(hwpText);
        System.out
                .println("========================================================");
    }
}

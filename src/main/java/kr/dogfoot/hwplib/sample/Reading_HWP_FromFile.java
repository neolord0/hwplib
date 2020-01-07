package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;

import java.io.File;

/**
 * 파잂 읽기 테스트 프로그램.
 */
public class Reading_HWP_FromFile {
    public static void main(String[] args) throws Exception {
        test("sample_hwp" + File.separator + "test-blank.hwp");
        test("sample_hwp" + File.separator + "test-etc.hwp");
        test("sample_hwp" + File.separator + "test-ole.hwp");
        test("sample_hwp" + File.separator + "test-각주미주.hwp");
        test("sample_hwp" + File.separator + "test-그림.hwp");
        test("sample_hwp" + File.separator + "test-글상자.hwp");
        test("sample_hwp" + File.separator + "test-글상자-압축.hwp");
        test("sample_hwp" + File.separator + "test-글자겹침.hwp");
        test("sample_hwp" + File.separator + "test-덧말.hwp");
        test("sample_hwp" + File.separator + "test-머리글꼬리글.hwp");
        test("sample_hwp" + File.separator + "test-묶음.hwp");
        test("sample_hwp" + File.separator + "test-바탕쪽.hwp");
        test("sample_hwp" + File.separator + "test-새번호지정.hwp");
        test("sample_hwp" + File.separator + "test-선-사각형-타원.hwp");
        test("sample_hwp" + File.separator + "test-수식.hwp");
        test("sample_hwp" + File.separator + "test-숨은설명.hwp");
        test("sample_hwp" + File.separator + "test-이미지추가.hwp");
        test("sample_hwp" + File.separator + "test-차트.hwp");
        test("sample_hwp" + File.separator + "test-책갈피.hwp");
        test("sample_hwp" + File.separator + "test-페이지숨김.hwp");
        test("sample_hwp" + File.separator + "test-필드.hwp");
        test("sample_hwp" + File.separator + "test-필드_누름틀.hwp");
        test("sample_hwp" + File.separator + "test-호 곡선.hwp");
        test("sample_hwp" + File.separator + "test-구버전(5.0.2.2) Picture 컨트롤.hwp");
    }

    private static void test(String filename) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile.getBodyText().getSectionList().size() > 0) {
            System.out.println(filename + "  읽기 성공 !!");
        }
    }
}

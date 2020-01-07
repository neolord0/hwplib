package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;


/**
 * 파일을 읽어서 다시 쓰는 기능을 테스트하는 프로그램.
 */
public class ReWriting_HWPFile {
    public static void main(String[] args) throws Exception {
        test("sample_hwp" + File.separator + "test-blank.hwp");
        test("sample_hwp" + File.separator + "test-etc.hwp");
        test("sample_hwp" + File.separator + "test-ole.hwp");
        test("sample_hwp" + File.separator + "test-각주미주.hwp");
        test("sample_hwp" + File.separator + "test-글상자.hwp");
        test("sample_hwp" + File.separator + "test-글상자-압축.hwp");
        test("sample_hwp" + File.separator + "test-글자겹침.hwp");
        test("sample_hwp" + File.separator + "test-다각형.hwp");
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
        test("sample_hwp" + File.separator + "test-표.hwp");
        test("sample_hwp" + File.separator + "test-필드.hwp");
        test("sample_hwp" + File.separator + "test-호 곡선.hwp");
        test("sample_hwp" + File.separator + "test-필드_누름틀.hwp");
        test("sample_hwp" + File.separator + "test-구버전(5.0.2.2) Picture 컨트롤.hwp");
        test("sample_hwp" + File.separator + "test-문단번호 1-10 수준.hwp");
    }

    private static void test(String filename) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            String writePath = filename.substring(0, 11) + "re-" + filename.substring(11);
            HWPWriter.toFile(hwpFile, writePath);

        }
    }
}

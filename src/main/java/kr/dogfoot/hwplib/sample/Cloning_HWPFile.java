package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

public class Cloning_HWPFile {
    public static void main(String[] args) throws Exception {
        test("blank.hwp");
        test("etc.hwp");
        test("ole.hwp");
        test("각주미주.hwp");
        test("구버전(5.0.2.2) Picture 컨트롤.hwp");
        test("그림.hwp");
        test("글상자.hwp");
        test("글상자-압축.hwp");
        test("글자겹침.hwp");
        test("다각형.hwp");
        test("덧말.hwp");
        test("머리글꼬리글.hwp");
        test("묶음.hwp");
        test("문단번호 1-10 수준.hwp");
        test("바탕쪽.hwp");
        test("새번호지정.hwp");
        test("선-사각형-타원.hwp");
        test("수식.hwp");
        test("숨은설명.hwp");
        test("이미지추가.hwp");
        test("차트.hwp");
        test("책갈피.hwp");
        test("페이지숨김.hwp");
        test("표.hwp");
        test("필드.hwp");
        test("필드-누름틀.hwp");
        test("호-곡선.hwp");
    }

    private static void test(String filename) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile(fullPath(filename));
        if (hwpFile != null) {
            HWPFile clonedHWPFile = hwpFile.clone(false);
            String filename2 =  "result-clone-" + filename;
            HWPWriter.toFile(clonedHWPFile, fullPath(filename2));
            System.out.println(filename + " ok !!!");
        }
    }

    private static String fullPath(String filename) {
        return "sample_hwp" + File.separator + "basic" + File.separator + filename;
    }

}

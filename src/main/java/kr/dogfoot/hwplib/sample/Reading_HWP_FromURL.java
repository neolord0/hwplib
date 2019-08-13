package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;

/**
 * URL로 부터 파일을 읽는 테스트 프로그램.
 */
public class Reading_HWP_FromURL {
    public static void main(String[] args) throws Exception {
        test("http://ocwork.haansoft.com/sample/sample.hwp");
    }

    private static void test(String url) throws Exception {
        HWPFile hwpFile = HWPReader.fromURL(url);
        if (hwpFile.getBodyText().getSectionList().size() > 0) {
            System.out.println(url + "  읽기 성공 !!");
        }
    }

}

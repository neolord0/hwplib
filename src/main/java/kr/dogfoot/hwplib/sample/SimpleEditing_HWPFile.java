package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

/**
 * 기존 파일을 변경하는 샘플 프로그램.
 */
public class SimpleEditing_HWPFile {
    public static void main(String[] args) throws Exception {
        String filename = "sample_hwp" + File.separator + "blank.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            Section s = hwpFile.getBodyText().getSectionList().get(0);
            Paragraph firstParagraph = s.getParagraph(0);
            firstParagraph.getText().addString("이것은 추가된 문자열입니다.");

            String writePath = filename.substring(0, 11) + "result-editing-" + filename.substring(11);
            HWPWriter.toFile(hwpFile, writePath);
        }
    }
}

package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterItem;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterSet;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.blankfilemaker.BlankFileMaker;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class Inserting_HyperLink {
    public static void main(String[] args) throws Exception {
        HWPFile hwpFile = BlankFileMaker.make();
        if (hwpFile != null) {
            Section s = hwpFile.getBodyText().getSectionList().get(0);
            int count = s.getParagraphCount();
            for (int index = 0; index < count; index++) {
                insertHyperLink(hwpFile.getBodyText().getSectionList().get(0).getParagraph(index));
            }

            String writePath = "sample_hwp" + File.separator + "result-inserting-hyperlink.hwp";
            HWPWriter.toFile(hwpFile, writePath);
        }
    }

    private static void insertHyperLink(Paragraph paragraph) throws UnsupportedEncodingException {
        paragraph.getText().addString("이것은 ");
        paragraph.getText().addExtendCharForHyperlinkStart();
        paragraph.getText().addString("다음 사이트");
        paragraph.getText().addExtendCharForHyperlinkEnd();
        paragraph.getText().addString("로 가는 링크입니다.");

        ControlField field = (ControlField) paragraph.addNewControl(ControlType.FIELD_HYPERLINK.getCtrlId());
        field.getHeader().setCommand("https\\://www.dogfoot.kr/aaa.jsp\\?aaa=bb&ccc=dd" + ";1;0;0;");
   }
}

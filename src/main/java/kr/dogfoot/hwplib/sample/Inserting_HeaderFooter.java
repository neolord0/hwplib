package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.ControlFooter;
import kr.dogfoot.hwplib.object.bodytext.control.ControlHeader;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.header.HeaderFooterApplyPage;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharControlChar;
import kr.dogfoot.hwplib.tool.blankfilemaker.BlankFileMaker;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class Inserting_HeaderFooter {
    public static void main(String[] args) throws Exception {
        HWPFile hwpFile = BlankFileMaker.make();
        if (hwpFile != null) {
            Paragraph firstPara = hwpFile.getBodyText().getSectionList().get(0).getParagraph(0);
            insertHeader(firstPara);
            insertFooter(firstPara);

            String writePath = "sample_hwp" + File.separator + "result-inserting-headerfooter.hwp";
            HWPWriter.toFile(hwpFile, writePath);
        }
    }

    private static void insertHeader(Paragraph para) throws UnsupportedEncodingException {
        para.getText().addExtendCharForHeader();

        ControlHeader header = (ControlHeader) para.addNewControl(ControlType.Header);
        header.getHeader().setCreateIndex(1);
        header.getHeader().setApplyPage(HeaderFooterApplyPage.BothPage);
        header.getListHeader().setParaCount(1);
        header.getListHeader().setTextWidth(42520);
        header.getListHeader().setTextHeight(4252);

        Paragraph paragraph = header.getParagraphList().addNewParagraph();
        paragraph.getHeader().setParaShapeId(1);
        paragraph.getHeader().setStyleId((short) 1);
        paragraph.createText();
        paragraph.getText().addString("머리글 입니다.");
        paragraph.createCharShape();
        paragraph.getCharShape().addParaCharShape(0, 2);
    }



    private static void insertFooter(Paragraph para) throws UnsupportedEncodingException {
        para.getText().addExtendCharForFooter();

        ControlFooter footer = (ControlFooter) para.addNewControl(ControlType.Footer);
        footer.getHeader().setCreateIndex(1);
        footer.getHeader().setApplyPage(HeaderFooterApplyPage.BothPage);
        footer.getListHeader().setParaCount(1);
        footer.getListHeader().setTextWidth(42520);
        footer.getListHeader().setTextHeight(4252);

        Paragraph paragraph = footer.getParagraphList().addNewParagraph();
        paragraph.getHeader().setParaShapeId(1);
        paragraph.getHeader().setStyleId((short) 1);
        paragraph.createText();
        paragraph.getText().addString("꼬리글 입니다.");
        paragraph.createCharShape();
        paragraph.getCharShape().addParaCharShape(0, 2);
    }
}

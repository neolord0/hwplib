package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlRectangle;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.Caption;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.CaptionDirection;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.ListHeaderForCaption;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.object.bodytext.paragraph.header.ParaHeader;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class Making_Caption {
    public static void main(String[] args) throws Exception {
        HWPFile hwpFile = HWPReader.fromFile("sample_hwp" + File.separator + "making_caption.hwp");
        if (hwpFile != null) {
            Paragraph para = hwpFile.getBodyText().getSectionList().get(0).getParagraph(0);
            ControlRectangle ctrlRect = (ControlRectangle) para.getControlList().get(2);
            Caption caption = ctrlRect.getCaption();
            if (caption == null) {
                ctrlRect.createCaption();
                caption = ctrlRect.getCaption();
            }
            setListHeader(caption.getListHeader());
            setPara(caption.getParagraphList().addNewParagraph(), "이것은 caption 입니다");
        }

        HWPWriter.toFile(hwpFile, "sample_hwp" + File.separator + "result_making_caption.hwp");
    }

    private static void setListHeader(ListHeaderForCaption listHeader) {
        listHeader.getCaptionProperty().setDirection(CaptionDirection.Bottom);
        listHeader.setSpaceBetweenCaptionAndFrame(850);
    }


    private static void setPara(Paragraph emptyPara, String text) {
        setParaHeader(emptyPara);
        setParaText(emptyPara, text);
        setParaCharShape(emptyPara);
    }

    private static void setParaHeader(Paragraph p) {
        ParaHeader ph = p.getHeader();
        ph.setLastInList(true);
        // 셀의 문단 모양을 이미 만들어진 문단 모양으로 사용함
        ph.setParaShapeId(1);
        // 셀의 스타일을이미 만들어진 스타일으로 사용함
        ph.setStyleId((short) 1);
        ph.getDivideSort().setDivideSection(false);
        ph.getDivideSort().setDivideMultiColumn(false);
        ph.getDivideSort().setDividePage(false);
        ph.getDivideSort().setDivideColumn(false);
        ph.setCharShapeCount(1);
        ph.setRangeTagCount(0);
        ph.setLineAlignCount(1);
        ph.setInstanceID(0);
        ph.setIsMergedByTrack(0);
    }

    private static void setParaText(Paragraph p, String text2) {
        p.createText();
        ParaText pt = p.getText();
        try {
            pt.addString(text2);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void setParaCharShape(Paragraph p) {
        p.createCharShape();

        ParaCharShape pcs = p.getCharShape();
        // 셀의 글자 모양을 이미 만들어진 글자 모양으로 사용함
        pcs.addParaCharShape(0, 1);
    }


    private static void setParaLineSeg(Paragraph p) {
        p.createLineSeg();

        ParaLineSeg pls = p.getLineSeg();
        LineSegItem lsi = pls.addNewLineSegItem();

        lsi.setTextStartPosition(0);
        lsi.setLineVerticalPosition(0);
        lsi.setLineHeight(ptToLineHeight(10.0));
        lsi.setTextPartHeight(ptToLineHeight(10.0));
        lsi.setDistanceBaseLineToLineVerticalPosition(ptToLineHeight(10.0 * 0.85));
        lsi.setLineSpace(ptToLineHeight(6.0));
        lsi.setStartPositionFromColumn(0);
        lsi.setSegmentWidth((int) mmToHwp(50.0));
        lsi.getTag().setFirstSegmentAtLine(true);
        lsi.getTag().setLastSegmentAtLine(true);
    }

    private static int ptToLineHeight(double pt) {
        return (int) (pt * 100.0f);
    }

    private static long mmToHwp(double mm) {
        return (long) (mm * 72000.0f / 254.0f + 0.5f);
    }

}

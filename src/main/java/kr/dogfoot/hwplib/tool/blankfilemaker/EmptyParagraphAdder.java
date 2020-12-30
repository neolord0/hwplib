package kr.dogfoot.hwplib.tool.blankfilemaker;

import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.object.bodytext.paragraph.header.ParaHeader;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharControlChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;

public class EmptyParagraphAdder {
    public static void add(Section section) {
        Paragraph paragraph = section.addNewParagraph();
        header(paragraph.getHeader());
        text(paragraph);
        charShape(paragraph);
        lineSeg(paragraph);
        SectionDefineAdder.add(paragraph);
        ColumnDefineAdder.add(paragraph);
    }

    private static void header(ParaHeader header) {
        header.setLastInList(true);
        header.setCharacterCount(17);
        header.getControlMask().setValue(4);
        header.setParaShapeId(3);
        header.setStyleId((short) 0);
        header.getDivideSort().setValue((short) 3);
        header.setCharShapeCount(1);
        header.setRangeTagCount(0);
        header.setLineAlignCount(1);
        header.setInstanceID(0);
        header.setIsMergedByTrack(0);
    }

    private static void text(Paragraph paragraph) {
        paragraph.createText();
        ParaText paraText = paragraph.getText();

        paraText.addExtendCharForSectionDefine();
        ;
        paraText.addExtendCharForColumnDefine();
        HWPCharControlChar controlChar = paraText.addNewCharControlChar();
        controlChar.setCode((short) 13);
    }

    private static void charShape(Paragraph paragraph) {
        paragraph.createCharShape();
        ParaCharShape charShape = paragraph.getCharShape();
        charShape.addParaCharShape(0, 0);
    }

    private static void lineSeg(Paragraph paragraph) {
        paragraph.createLineSeg();
        ParaLineSeg lineSeg = paragraph.getLineSeg();
        LineSegItem item = lineSeg.addNewLineSegItem();
        item.setTextStartPosition(0);
        item.setLineVerticalPosition(0);
        item.setLineHeight(1000);
        item.setTextPartHeight(1000);
        item.setDistanceBaseLineToLineVerticalPosition(850);
        item.setLineSpace(600);
        item.setStartPositionFromColumn(0);
        item.setSegmentWidth(42520);
        item.getTag().setValue(393216);
    }
}

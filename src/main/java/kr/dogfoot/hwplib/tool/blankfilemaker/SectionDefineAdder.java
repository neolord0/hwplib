package kr.dogfoot.hwplib.tool.blankfilemaker;

import kr.dogfoot.hwplib.object.bodytext.control.ControlSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.FootEndNoteShape;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.PageBorderFill;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.PageDef;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderThickness;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;

public class SectionDefineAdder {
    public static void add(Paragraph paragraph) {
        ControlSectionDefine sectionDefine = (ControlSectionDefine) paragraph.addNewControl(ControlType.SectionDefine);
        header(sectionDefine.getHeader());
        pageDef(sectionDefine.getPageDef());
        footNoteShape(sectionDefine.getFootNoteShape());
        endNoteShape(sectionDefine.getEndNoteShape());
        pageBorderFill(sectionDefine.getBothPageBorderFill());
        pageBorderFill(sectionDefine.getEvenPageBorderFill());
        pageBorderFill(sectionDefine.getOddPageBorderFill());
    }


    private static void header(CtrlHeaderSectionDefine header) {
        header.getProperty().setValue(0);
        header.setColumnGap(1134);
        header.setVerticalLineAlign(0);
        header.setHorizontalLineAlign(0);
        header.setDefaultTabGap(8000);
        header.setNumberParaShapeId(1);
        header.setPageStartNumber(0);
        header.setImageStartNumber(0);
        header.setTableStartNumber(0);
        header.setEquationStartNumber(0);
        header.setDefaultLanguage(0);
    }

    private static void pageDef(PageDef pageDef) {
        pageDef.setPaperWidth(59528);
        pageDef.setPaperHeight(84188);
        pageDef.setLeftMargin(8504);
        pageDef.setRightMargin(8504);
        pageDef.setTopMargin(5668);
        pageDef.setBottomMargin(4252);
        pageDef.setHeaderMargin(4252);
        pageDef.setFooterMargin(4252);
        pageDef.setGutterMargin(0);
        pageDef.getProperty().setValue(0);
    }

    private static void footNoteShape(FootEndNoteShape footNoteShape) {
        footNoteShape.getProperty().setValue(0);
        footNoteShape.setUserSymbol("\u0000");
        footNoteShape.setBeforeDecorativeLetter("\u0000");
        footNoteShape.setAfterDecorativeLetter(")");
        footNoteShape.setStartNumber(1);
        footNoteShape.setDivideLineLength(-1);
        footNoteShape.setDivideLineTopMargin(850);
        footNoteShape.setDivideLineBottomMargin(567);
        footNoteShape.setBetweenNotesMargin(283);
        footNoteShape.setDivideLineSort(BorderType.Solid);
        footNoteShape.setDivideLineThickness(BorderThickness.MM0_12);
        footNoteShape.getDivideLineColor().setValue(0);
        footNoteShape.setUnknown(0);
    }

    private static void endNoteShape(FootEndNoteShape endNoteShape) {
        endNoteShape.getProperty().setValue(0);
        endNoteShape.setUserSymbol("\u0000");
        endNoteShape.setBeforeDecorativeLetter("\u0000");
        endNoteShape.setAfterDecorativeLetter(")");
        endNoteShape.setStartNumber(1);
        endNoteShape.setDivideLineLength(14692344);
        endNoteShape.setDivideLineTopMargin(850);
        endNoteShape.setDivideLineBottomMargin(567);
        endNoteShape.setBetweenNotesMargin(0);
        endNoteShape.setDivideLineSort(BorderType.Solid);
        endNoteShape.setDivideLineThickness(BorderThickness.MM0_12);
        endNoteShape.getDivideLineColor().setValue(0);
        endNoteShape.setUnknown(0);
    }

    private static void pageBorderFill(PageBorderFill pageBorderFill) {
        pageBorderFill.getProperty().setValue(1);
        pageBorderFill.setLeftGap(1417);
        pageBorderFill.setRightGap(1417);
        pageBorderFill.setTopGap(1417);
        pageBorderFill.setBorderFillId(1417);
        pageBorderFill.setBorderFillId(1);
    }

}

package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.ListHeaderProperty;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.*;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphCopier;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class SectionDefineCopier {
    public static void copy(ControlSectionDefine source, ControlSectionDefine target, DocInfoAdder docInfoAdder) {
        header(source.getHeader(), target.getHeader(), docInfoAdder);
        pageDef(source.getPageDef(), target.getPageDef(), docInfoAdder);
        footEndNoteShape(source.getFootNoteShape(), target.getFootNoteShape(), docInfoAdder);
        footEndNoteShape(source.getEndNoteShape(), target.getEndNoteShape(), docInfoAdder);
        pageBorderFill(source.getBothPageBorderFill(), target.getBothPageBorderFill(), docInfoAdder);
        pageBorderFill(source.getEvenPageBorderFill(), target.getEvenPageBorderFill(), docInfoAdder);
        pageBorderFill(source.getOddPageBorderFill(), target.getOddPageBorderFill(), docInfoAdder);

        for (BatangPageInfo sourceBatangPageInfo : source.getBatangPageInfoList()) {
            batangPageInfo(sourceBatangPageInfo, target.addNewBatangPageInfo(), docInfoAdder);
        }

        if (source.getCtrlData() != null) {
            target.createCtrlData();
            target.getCtrlData().copy(source.getCtrlData());
        } else {
            target.deleteCtrlData();
        }
    }

    private static void header(CtrlHeaderSectionDefine source, CtrlHeaderSectionDefine target, DocInfoAdder docInfoAdder) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.setColumnGap(source.getColumnGap());
        target.setVerticalLineAlign(source.getVerticalLineAlign());
        target.setHorizontalLineAlign(source.getHorizontalLineAlign());
        target.setDefaultTabGap(source.getDefaultTabGap());
        target.setNumberParaShapeId(source.getNumberParaShapeId());
        target.setPageStartNumber(source.getPageStartNumber());
        target.setImageStartNumber(source.getImageStartNumber());
        target.setTableStartNumber(source.getTableStartNumber());
        target.setEquationStartNumber(source.getEquationStartNumber());
        target.setDefaultLanguage(source.getDefaultLanguage());
    }

    private static void pageDef(PageDef source, PageDef target, DocInfoAdder docInfoAdder) {
        target.setPaperWidth(source.getPaperWidth());
        target.setPaperHeight(source.getPaperHeight());
        target.setLeftMargin(source.getLeftMargin());
        target.setRightMargin(source.getRightMargin());
        target.setTopMargin(source.getTopMargin());
        target.setBottomMargin(source.getBottomMargin());
        target.setHeaderMargin(source.getHeaderMargin());
        target.setFooterMargin(source.getFooterMargin());
        target.setGutterMargin(source.getGutterMargin());
        target.getProperty().setValue(source.getProperty().getValue());
    }

    private static void footEndNoteShape(FootEndNoteShape source, FootEndNoteShape target, DocInfoAdder docInfoAdder) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.getUserSymbol().fromUTF16LEString(source.getUserSymbol().toUTF16LEString());
        target.getBeforeDecorativeLetter().fromUTF16LEString(source.getBeforeDecorativeLetter().toUTF16LEString());
        target.getAfterDecorativeLetter().fromUTF16LEString(source.getAfterDecorativeLetter().toUTF16LEString());
        target.setStartNumber(source.getStartNumber());
        target.setDivideLineLength(source.getDivideLineLength());
        target.setDivideLineTopMargin(source.getDivideLineTopMargin());
        target.setDivideLineBottomMargin(source.getDivideLineBottomMargin());
        target.setBetweenNotesMargin(source.getBetweenNotesMargin());
        target.setDivideLineSort(source.getDivideLineSort());
        target.setDivideLineThickness(source.getDivideLineThickness());
        target.getDivideLineColor().setValue(source.getDivideLineColor().getValue());
        target.setUnknown(source.getUnknown());
    }

    private static void pageBorderFill(PageBorderFill source, PageBorderFill target, DocInfoAdder docInfoAdder) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.setLeftGap(source.getLeftGap());
        target.setRightGap(source.getRightGap());
        target.setTopGap(source.getTopGap());
        target.setBottomGap(source.getBottomGap());

        if (source.getBorderFillId() == 0) {
            target.setBorderFillId(0);
        } else {
            target.setBorderFillId(docInfoAdder.forBorderFill().processById(source.getBorderFillId()));
        }
    }

    private static void batangPageInfo(BatangPageInfo source, BatangPageInfo target, DocInfoAdder docInfoAdder) {
        listHeader(source.getListHeader(), target.getListHeader(), docInfoAdder);
        ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
    }

    private static void listHeader(ListHeaderForBatangPage source, ListHeaderForBatangPage target, DocInfoAdder docInfoAdder) {
        target.setParaCount(source.getParaCount());
        target.getProperty().setValue(source.getProperty().getValue());
        target.setTextWidth(source.getTextWidth());
        target.setTextHeight(source.getTextHeight());
    }
}

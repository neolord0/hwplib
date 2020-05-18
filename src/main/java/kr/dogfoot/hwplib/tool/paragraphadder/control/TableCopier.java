package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.GsoHeaderProperty;
import kr.dogfoot.hwplib.object.bodytext.control.table.*;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphCopier;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class TableCopier {
    public static void copy(ControlTable source, ControlTable target, DocInfoAdder docInfoAdder) {
        header(source.getHeader(), target.getHeader());
        caption(source, target, docInfoAdder);
        table(source.getTable(), target.getTable(), docInfoAdder);
        rows(source, target, docInfoAdder);
    }

    private static void header(CtrlHeaderGso source, CtrlHeaderGso target) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.setyOffset(source.getyOffset());
        target.setxOffset(source.getxOffset());
        target.setWidth(source.getWidth());
        target.setHeight(source.getHeight());
        target.setzOrder(source.getzOrder());
        target.setOutterMarginLeft(source.getOutterMarginLeft());
        target.setOutterMarginRight(source.getOutterMarginRight());
        target.setOutterMarginTop(source.getOutterMarginTop());
        target.setOutterMarginBottom(source.getOutterMarginBottom());
        target.setInstanceId(source.getInstanceId());
        target.setPreventPageDivide(source.isPreventPageDivide());
        target.setExplanation(source.getExplanation());
    }

    private static void caption(ControlTable source, ControlTable target, DocInfoAdder docInfoAdder) {
        if (source.getCaption() != null) {
            target.createCaption();
            CaptionCopier.copy(source.getCaption(), target.getCaption(), docInfoAdder);
        }
    }

    private static void table(Table source, Table target, DocInfoAdder docInfoAdder) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.setRowCount(source.getRowCount());
        target.setColumnCount(source.getColumnCount());
        target.setCellSpacing(source.getCellSpacing());
        target.setLeftInnerMargin(source.getLeftInnerMargin());
        target.setRightInnerMargin(source.getRightInnerMargin());
        target.setTopInnerMargin(source.getTopInnerMargin());
        target.setBottomInnerMargin(source.getBottomInnerMargin());
        for (Integer cellCountOfRow : source.getCellCountOfRowList()) {
            target.addCellCountOfRow(cellCountOfRow);
        }
        target.setBorderFillId(docInfoAdder.forBorderFill().processById(source.getBorderFillId()));
        for (ZoneInfo zoneInfo : source.getZoneInfoList()) {
            zoneInfo(zoneInfo, target.addNewZoneInfo(), docInfoAdder);
        }
    }

    private static void zoneInfo(ZoneInfo source, ZoneInfo target, DocInfoAdder docInfoAdder) {
        target.setStartColumn(source.getStartColumn());
        target.setStartRow(source.getStartRow());
        target.setEndColumn(source.getEndColumn());
        target.setEndRow(source.getEndRow());
        target.setBorderFillId(docInfoAdder.forBorderFill().processById(source.getBorderFillId()));
    }

    private static void rows(ControlTable source, ControlTable target, DocInfoAdder docInfoAdder) {
        for(Row row : source.getRowList()) {
            row(row, target.addNewRow(), docInfoAdder);
        }
    }

    private static void row(Row source, Row target, DocInfoAdder docInfoAdder) {
        for (Cell cell : source.getCellList()) {
            cell(cell, target.addNewCell(), docInfoAdder);
        }
    }

    private static void cell(Cell source, Cell target, DocInfoAdder docInfoAdder) {
        listHeader(source.getListHeader(), target.getListHeader(), docInfoAdder);
        ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
    }

    private static void listHeader(ListHeaderForCell source, ListHeaderForCell target, DocInfoAdder docInfoAdder) {
        target.setParaCount(source.getParaCount());
        target.getProperty().setValue(source.getProperty().getValue());
        target.setColIndex(source.getColIndex());
        target.setRowIndex(source.getRowIndex());
        target.setColSpan(source.getColSpan());
        target.setRowSpan(source.getRowSpan());
        target.setWidth(source.getWidth());
        target.setHeight(source.getHeight());
        target.setLeftMargin(source.getLeftMargin());
        target.setRightMargin(source.getRightMargin());
        target.setTopMargin(source.getTopMargin());
        target.setBottomMargin(source.getBottomMargin());
        target.setBorderFillId(docInfoAdder.forBorderFill().processById(source.getBorderFillId()));
        target.setTextWidth(source.getTextWidth());
        target.setFieldName(source.getFieldName());
    }
}

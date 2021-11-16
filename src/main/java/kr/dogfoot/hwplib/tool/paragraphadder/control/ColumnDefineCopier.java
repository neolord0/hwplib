package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlColumnDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderColumnDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.columndefine.ColumnInfo;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class ColumnDefineCopier {
    public static void copy(ControlColumnDefine source, ControlColumnDefine target, DocInfoAdder docInfoAdder) {
        header(source.getHeader(), target.getHeader(), docInfoAdder);
        if (source.getCtrlData() != null) {
            target.createCtrlData();
            target.getCtrlData().copy(source.getCtrlData());
        } else {
            target.deleteCtrlData();
        }
    }

    private static void header(CtrlHeaderColumnDefine source, CtrlHeaderColumnDefine target, DocInfoAdder docInfoAdder) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.setGapBetweenColumn(source.getGapBetweenColumn());
        target.setProperty2(source.getProperty2());

        for (ColumnInfo info : source.getColumnInfoList()) {
            ColumnInfo ci = target.addNewColumnInfo();
            ci.setGap(info.getGap());
            ci.setWidth(info.getWidth());
        }

        target.setDivideLineSort(source.getDivideLineSort());
        target.setDivideLineThickness(source.getDivideLineThickness());
        target.getDivideLineColor().setValue(source.getDivideLineColor().getValue());
    }
}

package kr.dogfoot.hwplib.tool.blankfilemaker;

import kr.dogfoot.hwplib.object.bodytext.control.ControlColumnDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderColumnDefine;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderThickness;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;

public class ColumnDefineAdder {
    public static void add(Paragraph paragraph) {
        ControlColumnDefine columnDefine = (ControlColumnDefine) paragraph.addNewControl(ControlType.ColumnDefine);
        header(columnDefine.getHeader());
    }

    private static void header(CtrlHeaderColumnDefine header) {
        header.getProperty().setValue(4100);
        header.setGapBetweenColumn(0);
        header.setProperty2(0);
        header.setDivideLineSort(BorderType.None);
        header.setDivideLineThickness(BorderThickness.MM0_1);
        header.getDivideLineColor().setValue(0);
    }
}

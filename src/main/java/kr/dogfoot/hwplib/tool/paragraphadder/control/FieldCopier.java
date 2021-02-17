package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class FieldCopier {
    public static void copy(ControlField source, ControlField target, DocInfoAdder docInfoAdder) {
        target.getHeader().copy(source.getHeader());
        if (source.getCtrlData() != null) {
            target.createCtrlData();
            target.getCtrlData().copy(source.getCtrlData());
        } else {
            target.deleteCtrlData();
        }
    }
}

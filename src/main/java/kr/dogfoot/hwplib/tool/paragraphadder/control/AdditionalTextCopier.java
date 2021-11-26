package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlAdditionalText;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderAdditionalText;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class AdditionalTextCopier {
    public static void copy(ControlAdditionalText source, ControlAdditionalText target, DocInfoAdder docInfoAdder) {
        header(source.getHeader(), target.getHeader(), docInfoAdder);
        CtrlDataCopier.copy(source, target, docInfoAdder);
    }

    private static void header(CtrlHeaderAdditionalText source, CtrlHeaderAdditionalText target, DocInfoAdder docInfoAdder) {
        target.getMainText().copy(source.getMainText());
        target.getSubText().copy(source.getSubText());
        target.setPosition(source.getPosition());
        target.setFsizeratio(source.getFsizeratio());
        target.setOption(source.getOption());
        target.setStyleId((docInfoAdder == null) ? source.getStyleId() : docInfoAdder.forStyle().processById((int) source.getStyleId()));
        target.setAlignment(source.getAlignment());
    }
}

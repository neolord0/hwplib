package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlEquation;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.equation.EQEdit;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class EquationCopier {
    public static void copy(ControlEquation source, ControlEquation target, DocInfoAdder docInfoAdder) {
        CtrlHeaderGso sourceH = source.getHeader();
        CtrlHeaderGso targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);

        caption(source, target, docInfoAdder);

        EQEdit sourceEE = source.getEQEdit();
        EQEdit targetEE = target.getEQEdit();
        targetEE.copy(sourceEE);
    }

    private static void caption(ControlEquation source, ControlEquation target, DocInfoAdder docInfoAdder) {
        if (source.getCaption() != null) {
            target.createCaption();
            CaptionCopier.copy(source.getCaption(), target.getCaption(), docInfoAdder);
        } else {
            target.deleteCaption();
        }
    }
}

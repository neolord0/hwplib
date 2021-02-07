package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlEquation;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.equation.EQEdit;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class EquationCopier {
    public static void copy(ControlEquation source, ControlEquation target, DocInfoAdder docInfoAdder) {
        header(source.getHeader(), target.getHeader());
        caption(source, target, docInfoAdder);
        eqEdit(source.getEQEdit(), target.getEQEdit(), docInfoAdder);
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

    private static void caption(ControlEquation source, ControlEquation target, DocInfoAdder docInfoAdder) {
        if (source.getCaption() != null) {
            target.createCaption();
            CaptionCopier.copy(source.getCaption(), target.getCaption(), docInfoAdder);
        }
    }

    private static void eqEdit(EQEdit source, EQEdit target, DocInfoAdder docInfoAdder) {
        target.setProperty(source.getProperty());
        target.setScript(source.getScript());
        target.setLetterSize(source.getLetterSize());
        target.getLetterColor().setValue(source.getLetterColor().getValue());
        target.setBaseLine(source.getBaseLine());
        target.setUnknown(source.getUnknown());
        target.setVersionInfo(source.getVersionInfo());
        target.setFontName(source.getFontName());
    }
}

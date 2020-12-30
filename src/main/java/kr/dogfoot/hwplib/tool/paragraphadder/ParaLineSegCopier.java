package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;

/**
 * Paragraph의 ParaLingSeg 객체를 복사하는 기능을 포함하는 클래스.
 *
 * @author neolord
 */
public class ParaLineSegCopier {
    public static void copy(ParaLineSeg source, ParaLineSeg target) {
        for (LineSegItem lsi : source.getLineSegItemList()) {
            copyLineSegItem(lsi, target.addNewLineSegItem());
        }
    }

    private static void copyLineSegItem(LineSegItem source, LineSegItem target) {
        target.setTextStartPosition(source.getTextStartPosition());
        target.setLineVerticalPosition(source.getLineVerticalPosition());
        target.setLineHeight(source.getLineHeight());
        target.setTextPartHeight(source.getTextPartHeight());
        target.setDistanceBaseLineToLineVerticalPosition(source.getDistanceBaseLineToLineVerticalPosition());
        target.setLineSpace(source.getLineSpace());
        target.setStartPositionFromColumn(source.getStartPositionFromColumn());
        target.setSegmentWidth(source.getSegmentWidth());
        target.getTag().setValue(source.getTag().getValue());
    }
}

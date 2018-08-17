package kr.dogfoot.hwplib.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;

public class ParaLineSegCopyer {
	public static void copy(ParaLineSeg source, ParaLineSeg target) {
		for (LineSegItem lsi : source.getLineSegItemList()) {
			copyLineSegItem(lsi, target.addNewLineSegItem());
		}
	}

	private static void copyLineSegItem(LineSegItem source, LineSegItem target) {
		target.setTextStartPositon(source.getTextStartPositon());
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

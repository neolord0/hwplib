package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.paragraph.header.ParaHeader;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class ParaHeaderCopyer {
	public static void copy(ParaHeader source, ParaHeader target, DocInfoAdder docInfoAdder) {
		target.setLastInList(source.isLastInList());
		target.setCharacterCount(source.getCharacterCount());
		target.getControlMask().setValue(source.getControlMask().getValue());
		target.setParaShapeId(docInfoAdder.forParaShape().processById(source.getParaShapeId()));
		target.setStyleId((short) docInfoAdder.forStyle().processById(source.getStyleId()));
		target.getDivideSort().setValue(source.getDivideSort().getValue());
		target.setCharShapeCount(source.getCharShapeCount());
		target.setRangeTagCount(source.getRangeTagCount());
		target.setLineAlignCount(source.getLineAlignCount());
		target.setInstanceID(0);
		target.setIsMergedByTrack(source.getIsMergedByTrack());
	}
}

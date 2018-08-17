package kr.dogfoot.hwplib.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.CharPositonShapeIdPair;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.paragraphadder.docinfo.DocInfoAdder;

public class ParaCharShapeCopyer {
	public static void copy(ParaCharShape source, ParaCharShape target, DocInfoAdder docInfoAdder) {
		for (CharPositonShapeIdPair cpsp : source.getPositonShapeIdPairList()) {
			target.addParaCharShape(cpsp.getPositon(), docInfoAdder.forCharShape().processById((int) cpsp.getShapeId()));
		}
	}
}

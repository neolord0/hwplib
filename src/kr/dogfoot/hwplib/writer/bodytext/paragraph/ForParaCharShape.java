package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import java.io.IOException;

import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.CharPositonShapeIdPair;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForParaCharShape {
	public static void write(ParaCharShape pcs, StreamWriter sw) throws IOException {
		if (pcs == null) {
			return;
		}
		
		recordHeader(pcs, sw);
		
		for (CharPositonShapeIdPair cpsip : pcs.getPositonShapeIdPairList()) {
			charPositonShapeIdPair(cpsip, sw);
		}
	}

	private static void recordHeader(ParaCharShape pcs, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.PARA_CHAR_SHAPE, sw.getCurrentParagraphLevel() + 1, getSize(pcs));
	}

	private static int getSize(ParaCharShape pcs) {
		return pcs.getPositonShapeIdPairList().size() * 8;
	}


	private static void charPositonShapeIdPair(CharPositonShapeIdPair cpsip,
			StreamWriter sw) throws IOException {
		sw.writeUInt4(cpsip.getPositon());
		sw.writeUInt4(cpsip.getShapeId());
	}
}

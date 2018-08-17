package kr.dogfoot.hwplib.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.bindata.EmbeddedBinaryData;

public class ForEmbeddedBinaryData {
	public static int addAndCopy(int sourceId, DocInfoAdder docInfoAdder) {
		EmbeddedBinaryData source = docInfoAdder.getSourceHWPFile().getBinData().getEmbeddedBinaryDataList().get(sourceId);
		EmbeddedBinaryData target = docInfoAdder.getTargetHWPFile().getBinData().addNewEmbeddedBinaryData();
		
		target.setName(source.getName());
		target.setData(source.getData());
		
		return docInfoAdder.getTargetHWPFile().getBinData().getEmbeddedBinaryDataList().size() - 1;
	}
}

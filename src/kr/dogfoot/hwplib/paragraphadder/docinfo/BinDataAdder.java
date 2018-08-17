package kr.dogfoot.hwplib.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.BinData;

public class BinDataAdder {
	private DocInfoAdder docInfoAdder;

	public BinDataAdder(DocInfoAdder docInfoAdder) {
		this.docInfoAdder = docInfoAdder;
	}

	public int processById(int sourceID) {
		BinData source = docInfoAdder.getSourceHWPFile().getDocInfo().getBinDataList().get(sourceID);
		return addAndCopy(source);
	}

	private int addAndCopy(BinData source) {
		BinData target = docInfoAdder.getTargetHWPFile().getDocInfo().addNewBinData();
		target.getProperty().setValue(source.getProperty().getValue());
		target.setAbsolutePathForLink(source.getAbsolutePathForLink());
		target.setRelativePathForLink(source.getRelativePathForLink());
		target.setBinDataID(ForEmbeddedBinaryData.addAndCopy(source.getBinDataID(), docInfoAdder));
		target.setExtensionForEmbedding(source.getExtensionForEmbedding());

		return docInfoAdder.getTargetHWPFile().getDocInfo().getBinDataList().size() - 1;
	}
}

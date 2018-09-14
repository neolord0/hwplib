package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class ParapraphCopyer {
	private DocInfoAdder docInfoAdder;
	private Paragraph source;
	private Paragraph target;

	public ParapraphCopyer(DocInfoAdder docInfoAdder) {
		this.docInfoAdder = docInfoAdder;
	}

	public void copy(Paragraph source, Paragraph target) throws Exception {
		this.source = source;
		this.target = target;

		copyHeader();
		copyText();
		copyCharShape();
		copyLineSeg();
		copyRangeTag();
		copyControlList();
		copyMemoList();
	}

	private void copyHeader() {
		if (source.getHeader() != null) {
			ParaHeaderCopyer.copy(source.getHeader(), target.getHeader(), docInfoAdder);
		}
	}

	private void copyText() throws Exception {
		if (source.getText() != null) {
			target.createText();
			ParaTextCopyer.copy(source.getText(), target.getText());
		}
	}

	private void copyCharShape() {
		if (source.getCharShape() != null) {
			target.createCharShape();
			ParaCharShapeCopyer.copy(source.getCharShape(), target.getCharShape(), docInfoAdder);
		}
	}

	private void copyLineSeg() {
		if (source.getLineSeg() != null) {
			target.createLineSeg();
			ParaLineSegCopyer.copy(source.getLineSeg(), target.getLineSeg());
		}
	}

	private void copyRangeTag() throws Exception {
		if (source.getRangeTag() != null) {
			target.createRangeTag();
			ParaRangeTagCopyer.copy(source.getRangeTag(), target.getRangeTag());
		}
	}

	private void copyControlList() {
		// not yet implemented
	}

	private void copyMemoList() {
		// not yet implemented
	}
}

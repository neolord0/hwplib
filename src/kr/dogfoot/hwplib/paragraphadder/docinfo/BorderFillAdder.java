package kr.dogfoot.hwplib.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.BorderFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.EachBorder;

public class BorderFillAdder {
	private DocInfoAdder docInfoAdder;

	public BorderFillAdder(DocInfoAdder docInfoAdder) {
		this.docInfoAdder = docInfoAdder;
	}

	public int processById(int sourceId) {
		BorderFill source = docInfoAdder.getSourceHWPFile().getDocInfo().getBorderFillList().get(sourceId - 1);
		int index = findFromTarget(source);
		if (index == -1) {
			index = addAndCopy(source);
		}
		return index;
	}

	private int findFromTarget(BorderFill source) {
		int count = docInfoAdder.getTargetHWPFile().getDocInfo().getBorderFillList().size();
		for (int index = 0; index < count; index++) {
			BorderFill target = docInfoAdder.getTargetHWPFile().getDocInfo().getBorderFillList().get(index);
			if (equal(source, target)) {
				return index;
			}
		}
		return -1;
	}

	private boolean equal(BorderFill source, BorderFill target) {
		if (source.getProperty().getValue() == target.getProperty().getValue()
				&& equalEachBorder(source.getLeftBorder(), target.getLeftBorder())
				&& equalEachBorder(source.getRightBorder(), target.getRightBorder())
				&& equalEachBorder(source.getTopBorder(), target.getTopBorder())
				&& equalEachBorder(source.getBottomBorder(), target.getBottomBorder())
				&& source.getDiagonalSort() == target.getDiagonalSort()
				&& source.getDiagonalThickness() == target.getDiagonalThickness()
				&& source.getDiagonalColor().getValue() == target.getDiagonalColor().getValue()
				&& ForFillInfo.equal(source.getFillInfo(), target.getFillInfo())) {
			return true;
		}
		return false;
	}

	private boolean equalEachBorder(EachBorder source, EachBorder target) {
		if (source.getType() == target.getType() && source.getThickness() == target.getThickness()
				&& source.getColor().getValue() == target.getColor().getValue()) {
			return true;
		}
		return false;
	}

	private int addAndCopy(BorderFill source) {
		BorderFill target = docInfoAdder.getTargetHWPFile().getDocInfo().addNewBorderFill();
		target.getProperty().setValue(source.getProperty().getValue());
		copyEachBorder(source.getLeftBorder(), target.getLeftBorder());
		copyEachBorder(source.getRightBorder(), target.getRightBorder());
		copyEachBorder(source.getTopBorder(), target.getTopBorder());
		copyEachBorder(source.getBottomBorder(), target.getBottomBorder());
		target.setDiagonalSort(source.getDiagonalSort());
		target.setDiagonalThickness(source.getDiagonalThickness());
		target.getDiagonalColor().setValue(source.getDiagonalColor().getValue());
		ForFillInfo.copy(source.getFillInfo(), target.getFillInfo(), docInfoAdder);
		return docInfoAdder.getTargetHWPFile().getDocInfo().getBorderFillList().size() - 1;
	}

	private void copyEachBorder(EachBorder source, EachBorder target) {
		target.setType(source.getType());
		target.setThickness(source.getThickness());
		target.getColor().setValue(source.getColor().getValue());
	}

	public boolean equalById(int sourceId, int targetId) {
		BorderFill source = docInfoAdder.getSourceHWPFile().getDocInfo().getBorderFillList().get(sourceId - 1);
		BorderFill target = docInfoAdder.getTargetHWPFile().getDocInfo().getBorderFillList().get(targetId - 1);
		return equal(source, target);
	}
}

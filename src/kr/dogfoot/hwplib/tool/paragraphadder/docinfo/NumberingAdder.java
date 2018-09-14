package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.Numbering;
import kr.dogfoot.hwplib.object.docinfo.numbering.LevelNumbering;
import kr.dogfoot.hwplib.object.docinfo.numbering.ParagraphHeadInfo;

public class NumberingAdder {
	private DocInfoAdder docInfoAdder;

	public NumberingAdder(DocInfoAdder docInfoAdder) {
		this.docInfoAdder = docInfoAdder;
	}

	public int processById(int sourceId) {
		Numbering source = docInfoAdder.getSourceHWPFile().getDocInfo().getNumberingList().get(sourceId);
		int index = findFromTarget(source);
		if (index == -1) {
			index = addAndCopy(source);
		}
		return index;
	}

	private int findFromTarget(Numbering source) {
		int count = docInfoAdder.getTargetHWPFile().getDocInfo().getNumberingList().size();
		for (int index = 0; index < count; index++) {
			Numbering target = docInfoAdder.getTargetHWPFile().getDocInfo().getNumberingList().get(index);
			if (equal(source, target)) {
				return index;
			}
		}
		return -1;
	}

	private boolean equal(Numbering source, Numbering target) {
		if (equalLevelNumberingList(source, target) && source.getStartNumber() == target.getStartNumber()
				&& equalStartNumbersForLevel(source, target)) {
			return true;
		}
		return false;
	}

	private boolean equalLevelNumberingList(Numbering source, Numbering target) {
		for (int level = 0; level < 7; level++) {
			try {
				if (equalLevelNumbering(source.getLevelNumbering(level), target.getLevelNumbering(level))) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	private boolean equalLevelNumbering(LevelNumbering source, LevelNumbering target) {
		if (equalParagraphHeadInfo(source.getParagraphHeadInfo(), target.getParagraphHeadInfo())
				&& source.getNumberFormat().equals(target.getNumberFormat())) {
			return true;
		}
		return false;
	}

	private boolean equalParagraphHeadInfo(ParagraphHeadInfo source, ParagraphHeadInfo target) {
		if (source.getProperty().getValue() == target.getProperty().getValue()
				&& source.getCorrectionValueForWidth() == target.getCorrectionValueForWidth()
				&& source.getDistanceFromBody() == target.getDistanceFromBody() && docInfoAdder.forCharShape()
						.equalById((int) source.getCharShapeID(), (int) target.getCharShapeID())) {
			return true;
		}
		return false;
	}

	private boolean equalStartNumbersForLevel(Numbering source, Numbering target) {
		for (int level = 0; level < 7; level++) {
			try {
				if (source.getStartNumberForLevel(level) != target.getStartNumberForLevel(level)) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	private int addAndCopy(Numbering source) {
		Numbering target = docInfoAdder.getTargetHWPFile().getDocInfo().addNewNumbering();
		int level;
		for (level = 0; level < 7; level++) {
			try {
				copyLevelNumbering(source.getLevelNumbering(level), target.getLevelNumbering(level));
			} catch (Exception e) {
			}
		}
		target.setStartNumber(source.getStartNumber());
		for (level = 0; level < 7; level++) {
			try {
				target.setStartNumberForLevel(source.getStartNumberForLevel(level), level);
			} catch (Exception e) {
			}
		}

		return docInfoAdder.getTargetHWPFile().getDocInfo().getNumberingList().size() - 1;
	}

	private void copyLevelNumbering(LevelNumbering source, LevelNumbering target) {
		copyParagraphHeadInfo(source.getParagraphHeadInfo(), target.getParagraphHeadInfo());
		target.setNumberFormat(source.getNumberFormat());
	}

	private void copyParagraphHeadInfo(ParagraphHeadInfo source, ParagraphHeadInfo target) {
		target.getProperty().setValue(source.getProperty().getValue());
		target.setCorrectionValueForWidth(source.getCorrectionValueForWidth());
		target.setDistanceFromBody(source.getDistanceFromBody());
		target.setCharShapeID(docInfoAdder.forCharShape().processById((int) source.getCharShapeID()));
	}

	public boolean equalById(int sourceId, int targetId) {
		Numbering source = docInfoAdder.getSourceHWPFile().getDocInfo().getNumberingList().get(sourceId);
		Numbering target = docInfoAdder.getTargetHWPFile().getDocInfo().getNumberingList().get(targetId);
		
		return equal(source, target);
	}
}

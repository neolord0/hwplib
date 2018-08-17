package kr.dogfoot.hwplib.paragraphadder.docinfo;

import java.util.ArrayList;

import kr.dogfoot.hwplib.object.docinfo.TabDef;
import kr.dogfoot.hwplib.object.docinfo.tabdef.TabInfo;

public class TabDefAdder {
	private DocInfoAdder docInfoAdder;

	public TabDefAdder(DocInfoAdder docInfoAdder) {
		this.docInfoAdder = docInfoAdder;
	}

	public int processById(int sourceId) {
		TabDef source = docInfoAdder.getSourceHWPFile().getDocInfo().getTabDefList().get(sourceId);
		int index = findFromTarget(source);
		if (index == -1) {
			index = addAndCopy(source);
		}
		return index;
	}

	private int findFromTarget(TabDef source) {
		int count = docInfoAdder.getTargetHWPFile().getDocInfo().getTabDefList().size();
		for (int index = 0; index < count; index++) {
			TabDef target = docInfoAdder.getTargetHWPFile().getDocInfo().getTabDefList().get(index);
			if (equal(source, target)) {
				return index;
			}
		}
		return -1;
	}

	private boolean equal(TabDef source, TabDef target) {
		if (source.getProperty().getValue() == target.getProperty().getValue()
				&& equalTabInfoList(source.getTabInfoList(), target.getTabInfoList())) {
			return true;
		}
		return false;
	}

	private boolean equalTabInfoList(ArrayList<TabInfo> source, ArrayList<TabInfo> target) {
		if (source.size() == target.size()) {
			int count = source.size();
			for (int index = 0; index < count; index++) {
				if (equalTabInfo(source.get(index), target.get(index)) == false) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private boolean equalTabInfo(TabInfo source, TabInfo target) {
		if (source.getPosition() == target.getPosition() && source.getTabSort() == target.getTabSort()
				&& source.getFillSort() == target.getFillSort()) {
			return true;
		}
		return false;
	}

	private int addAndCopy(TabDef source) {
		TabDef target = docInfoAdder.getTargetHWPFile().getDocInfo().addNewTabDef();
		target.getProperty().setValue(source.getProperty().getValue());
		for (TabInfo sourceTabInfo : source.getTabInfoList()) {
			TabInfo targetTabInfo = target.addNewTabInfo();
			copyTabInfo(sourceTabInfo, targetTabInfo);
		}

		return docInfoAdder.getTargetHWPFile().getDocInfo().getTabDefList().size() - 1;
	}

	private void copyTabInfo(TabInfo source, TabInfo target) {
		target.setPosition(source.getPosition());
		target.setTabSort(source.getTabSort());
		target.setFillSort(source.getFillSort());
	}

	public boolean equalById(int sourceId, int targetId) {
		TabDef source = docInfoAdder.getSourceHWPFile().getDocInfo().getTabDefList().get(sourceId);
		TabDef target = docInfoAdder.getTargetHWPFile().getDocInfo().getTabDefList().get(targetId);

		return equal(source, target);
	}
}

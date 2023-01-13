package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.TabDef;
import kr.dogfoot.hwplib.object.docinfo.tabdef.TabInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * DocInfo에 TabDef을 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class TabDefAdder {
    private DocInfoAdder docInfoAdder;
    private HashMap<Integer, Integer> idMatchingMap;

    public TabDefAdder(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
        idMatchingMap = new HashMap<Integer, Integer>();
    }

    public int processById(int sourceId) {
        if (docInfoAdder.getSourceHWPFile() == docInfoAdder.getTargetHWPFile()) {
            return sourceId;
        }

        Integer targetID = idMatchingMap.get(sourceId);
        if (targetID != null) {
            return targetID;
        }

        TabDef source = docInfoAdder.getSourceHWPFile().getDocInfo().getTabDefList().get(sourceId);
        int id = findFromTarget(source);
        if (id == -1) {
            id = addAndCopy(source);
        }
        idMatchingMap.put(sourceId, id);
        return id;
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
        return source.getProperty().getValue() == target.getProperty().getValue()
                && equalTabInfoList(source.getTabInfoList(), target.getTabInfoList());
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
        return source.getPosition() == target.getPosition() && source.getTabSort() == target.getTabSort()
                && source.getFillSort() == target.getFillSort();
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

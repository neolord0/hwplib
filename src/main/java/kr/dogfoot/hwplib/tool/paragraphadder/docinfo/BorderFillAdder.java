package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.BorderFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.EachBorder;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * DocInfo에 BorderFill를 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class BorderFillAdder {
    private DocInfoAdder docInfoAdder;
    private HashMap<Integer, Integer> idMatchingMap;

    public BorderFillAdder(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
        idMatchingMap = new HashMap<Integer, Integer>();
    }

    public int processById(int sourceId) {
        if (docInfoAdder.getSourceHWPFile() == docInfoAdder.getTargetHWPFile()) {
            return sourceId;
        }

        if (idMatchingMap.containsKey(sourceId)) {
            return idMatchingMap.get(sourceId);
        } else {
            BorderFill source = null;
            try {
                source = docInfoAdder.getSourceHWPFile().getDocInfo().getBorderFillList().get(sourceId - 1);
            } catch (Exception e) {
                return sourceId;
            }
            int id = findFromTarget(source);
            if (id == -1) {
                id = addAndCopy(source);
            }
            idMatchingMap.put(sourceId, id);
            return id;
        }
    }

    private int findFromTarget(BorderFill source) {
        int count = docInfoAdder.getTargetHWPFile().getDocInfo().getBorderFillList().size();
        for (int index = 0; index < count; index++) {
            BorderFill target  = docInfoAdder.getTargetHWPFile().getDocInfo().getBorderFillList().get(index);
            if (equal(source, target)) {
                return index + 1;
            }
        }
        return -1;
    }

    private boolean equal(BorderFill source, BorderFill target) {
        if (source == null || target == null) {
            return source == target;
        }

        return source.getProperty().getValue() == target.getProperty().getValue()
                && equalEachBorder(source.getLeftBorder(), target.getLeftBorder())
                && equalEachBorder(source.getRightBorder(), target.getRightBorder())
                && equalEachBorder(source.getTopBorder(), target.getTopBorder())
                && equalEachBorder(source.getBottomBorder(), target.getBottomBorder())
                && equalEachBorder(source.getDiagonalBorder(), target.getDiagonalBorder())
                && ForFillInfo.equal(source.getFillInfo(), target.getFillInfo());
    }

    private boolean equalEachBorder(EachBorder source, EachBorder target) {
        return source.getType() == target.getType() && source.getThickness() == target.getThickness()
                && source.getColor().getValue() == target.getColor().getValue();
    }

    private int addAndCopy(BorderFill source) {
        BorderFill target = docInfoAdder.getTargetHWPFile().getDocInfo().addNewBorderFill();
        target.getProperty().setValue(source.getProperty().getValue());
        copyEachBorder(source.getLeftBorder(), target.getLeftBorder());
        copyEachBorder(source.getRightBorder(), target.getRightBorder());
        copyEachBorder(source.getTopBorder(), target.getTopBorder());
        copyEachBorder(source.getBottomBorder(), target.getBottomBorder());
        copyEachBorder(source.getDiagonalBorder(), target.getDiagonalBorder());
        ForFillInfo.copy(source.getFillInfo(), target.getFillInfo(), docInfoAdder);
        return docInfoAdder.getTargetHWPFile().getDocInfo().getBorderFillList().size();
    }

    private void copyEachBorder(EachBorder source, EachBorder target) {
        target.setType(source.getType());
        target.setThickness(source.getThickness());
        target.getColor().setValue(source.getColor().getValue());
    }

    public boolean equalById(int sourceId, int targetId) {
        if (sourceId == 0 || targetId == 0) {
            return sourceId == targetId;
        }
        BorderFill source = getBorderFill(docInfoAdder.getSourceHWPFile().getDocInfo().getBorderFillList(), sourceId - 1);
        BorderFill target = getBorderFill(docInfoAdder.getTargetHWPFile().getDocInfo().getBorderFillList(), targetId - 1);
        return equal(source, target);
    }

    private BorderFill getBorderFill(ArrayList<BorderFill> borderFillList, int index) {
        int count = borderFillList.size();
        if (count == 0) {
            return null;
        }
        if (index >= count) {
            return borderFillList.get(count - 1);
        } else if (index < 0) {
            return borderFillList.get(0);
        } else {
            return borderFillList.get(index);
        }
    }
}

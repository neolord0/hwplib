package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.Numbering;
import kr.dogfoot.hwplib.object.docinfo.numbering.LevelNumbering;
import kr.dogfoot.hwplib.object.docinfo.numbering.ParagraphHeadInfo;

/**
 * DocInfo에 Numbering을 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class NumberingAdder {
    private DocInfoAdder docInfoAdder;

    public NumberingAdder(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
    }

    public int processById(int sourceId) {
        // id == index + 1
        Numbering source = docInfoAdder.getSourceHWPFile().getDocInfo().getNumberingList().get(sourceId - 1);
        int id = findFromTarget(source);
        if (id == -1) {
            id = addAndCopy(source);
        }
        return id;
    }

    private int findFromTarget(Numbering source) {
        int count = docInfoAdder.getTargetHWPFile().getDocInfo().getNumberingList().size();
        for (int index = 0; index < count; index++) {
            Numbering target = docInfoAdder.getTargetHWPFile().getDocInfo().getNumberingList().get(index);
            if (equal(source, target)) {
                return index + 1;
            }
        }
        return -1;
    }

    private boolean equal(Numbering source, Numbering target) {
        return equalLevelNumberingList(source, target) && source.getStartNumber() == target.getStartNumber();
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
        return equalParagraphHeadInfo(source.getParagraphHeadInfo(), target.getParagraphHeadInfo())
                && source.getNumberFormat().equals(target.getNumberFormat())
                && source.getStartNumber() == target.getStartNumber();
    }

    private boolean equalParagraphHeadInfo(ParagraphHeadInfo source, ParagraphHeadInfo target) {
        return source.getProperty().getValue() == target.getProperty().getValue()
                && source.getCorrectionValueForWidth() == target.getCorrectionValueForWidth()
                && source.getDistanceFromBody() == target.getDistanceFromBody() && docInfoAdder.forCharShape()
                .equalById((int) source.getCharShapeID(), (int) target.getCharShapeID());
    }


    private int addAndCopy(Numbering source) {
        Numbering target = docInfoAdder.getTargetHWPFile().getDocInfo().addNewNumbering();
        int level;
        for (level = 0; level < 10; level++) {
            try {
                copyLevelNumbering(source.getLevelNumbering(level), target.getLevelNumbering(level));
            } catch (Exception e) {
            }
        }
        target.setStartNumber(source.getStartNumber());

        return docInfoAdder.getTargetHWPFile().getDocInfo().getNumberingList().size();
    }

    private void copyLevelNumbering(LevelNumbering source, LevelNumbering target) {
        copyParagraphHeadInfo(source.getParagraphHeadInfo(), target.getParagraphHeadInfo());
        target.getNumberFormat().copy(source.getNumberFormat());
        target.setStartNumber(source.getStartNumber());
    }

    private void copyParagraphHeadInfo(ParagraphHeadInfo source, ParagraphHeadInfo target) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.setCorrectionValueForWidth(source.getCorrectionValueForWidth());
        target.setDistanceFromBody(source.getDistanceFromBody());
        target.setCharShapeID(docInfoAdder.forCharShape().processById((int) source.getCharShapeID()));
    }

    public boolean equalById(int sourceId, int targetId) {
        Numbering source = docInfoAdder.getSourceHWPFile().getDocInfo().getNumberingList().get(sourceId - 1);
        Numbering target = docInfoAdder.getTargetHWPFile().getDocInfo().getNumberingList().get(targetId - 1);

        return equal(source, target);
    }
}

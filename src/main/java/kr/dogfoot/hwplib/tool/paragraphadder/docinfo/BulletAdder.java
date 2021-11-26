package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.Bullet;
import kr.dogfoot.hwplib.object.docinfo.numbering.ParagraphHeadInfo;

/**
 * DocInfo에 Bullet을 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class BulletAdder {
    private DocInfoAdder docInfoAdder;

    public BulletAdder(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
    }

    public int processById(int sourceId) {
        if (docInfoAdder.getSourceHWPFile() == docInfoAdder.getTargetHWPFile()) {
            return sourceId;
        }

        // id == index + 1
        Bullet source = docInfoAdder.getSourceHWPFile().getDocInfo().getBulletList().get(sourceId - 1);
        int id = findFromTarget(source);
        if (id == -1) {
            id = addAndCopy(source);
        }
        return id;
    }

    private int findFromTarget(Bullet source) {
        int count = docInfoAdder.getTargetHWPFile().getDocInfo().getBulletList().size();
        for (int index = 0; index < count; index++) {
            Bullet target = docInfoAdder.getTargetHWPFile().getDocInfo().getBulletList().get(index);
            if (equal(source, target)) {
                return index + 1;
            }
        }
        return -1;
    }

    private boolean equal(Bullet source, Bullet target) {
        return equalParagraphHeadInfo(source.getParagraphHeadInfo(), target.getParagraphHeadInfo())
                && source.getBulletChar().equals(target.getBulletChar());
    }

    private boolean equalParagraphHeadInfo(ParagraphHeadInfo source, ParagraphHeadInfo target) {
        return source.getProperty().getValue() == target.getProperty().getValue()
                && source.getCorrectionValueForWidth() == target.getCorrectionValueForWidth()
                && source.getDistanceFromBody() == target.getDistanceFromBody()
                && docInfoAdder.forCharShape().equalById((int) source.getCharShapeID(), (int) target.getCharShapeID());
    }

    private int addAndCopy(Bullet source) {
        Bullet target = docInfoAdder.getTargetHWPFile().getDocInfo().addNewBullet();
        copyParagraphHeadInfo(source.getParagraphHeadInfo(), target.getParagraphHeadInfo());
        target.getBulletChar().copy(source.getBulletChar());

        return docInfoAdder.getTargetHWPFile().getDocInfo().getBulletList().size();
    }

    private void copyParagraphHeadInfo(ParagraphHeadInfo source, ParagraphHeadInfo target) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.setCorrectionValueForWidth(source.getCorrectionValueForWidth());
        target.setDistanceFromBody(source.getDistanceFromBody());
        target.setCharShapeID(docInfoAdder.forCharShape().processById((int) source.getCharShapeID()));
    }

    public boolean equalById(int sourceId, int targetId) {
        Bullet source;
        Bullet target;
        try {
            source = docInfoAdder.getSourceHWPFile().getDocInfo().getBulletList().get(sourceId - 1);
        } catch (Exception e) {
            source = null;
        }
        try {
            target = docInfoAdder.getTargetHWPFile().getDocInfo().getBulletList().get(targetId - 1);
        } catch (Exception e) {
            target = null;
        }
        if (source == null && target == null) {
            return sourceId == targetId;
        } else if (source == null || target == null) {
            return false;
        } else {
            return equal(source, target);
        }
    }
}

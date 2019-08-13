package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.Style;

/**
 * DocInfo에 Style을 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class StyleAdder {
    private DocInfoAdder docInfoAdder;

    public StyleAdder(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
    }

    public int processById(int sourceId) {
        Style source = docInfoAdder.getSourceHWPFile().getDocInfo().getStyleList().get(sourceId);
        int index = findFromTarget(source, sourceId);
        if (index == -1) {
            index = addAndCopy(source, sourceId);
        }
        return index;
    }

    private int findFromTarget(Style source, int sourceId) {
        int count = docInfoAdder.getTargetHWPFile().getDocInfo().getStyleList().size();
        for (int index = 0; index < count; index++) {
            Style target = docInfoAdder.getTargetHWPFile().getDocInfo().getStyleList().get(index);
            if (equal(source, target, sourceId, index)) {
                return index;
            }
        }
        return -1;
    }

    private boolean equal(Style source, Style target, int sourceId, int targetId) {
        return source.getHangulName().equals(target.getHangulName())
                && source.getEnglishName().equals(target.getEnglishName())
                && source.getProeprty().getValue() == target.getProeprty().getValue()
                && equalNextStyleId(source.getNextStyleId(), target.getNextStyleId(), sourceId, targetId)
                && source.getLanguageId() == target.getLanguageId()
                && docInfoAdder.forParaShape().equalById(source.getParaShapeId(), target.getParaShapeId())
                && docInfoAdder.forCharShape().equalById(source.getCharShapeId(), target.getCharShapeId());
    }

    private boolean equalNextStyleId(short sourceNextStyleId, short targetNextStyleId, int sourceId, int targetId) {
        if (sourceNextStyleId == sourceId && targetNextStyleId == targetId) {
            return true;
        } else if (sourceNextStyleId == sourceId || targetNextStyleId == targetId) {
            return false;
        }
        return equalById(sourceNextStyleId, targetNextStyleId);
    }

    private int addAndCopy(Style source, int sourceId) {
        Style target = docInfoAdder.getTargetHWPFile().getDocInfo().addNewStyle();
        int targetId = docInfoAdder.getTargetHWPFile().getDocInfo().getStyleList().size() - 1;
        target.setHangulName(source.getHangulName());
        target.setEnglishName(source.getEnglishName());
        target.getProeprty().setValue(source.getProeprty().getValue());
        if (source.getNextStyleId() == sourceId) {
            target.setNextStyleId((short) targetId);
        } else {
            target.setNextStyleId((short) processById(source.getNextStyleId()));
        }
        target.setLanguageId(source.getLanguageId());
        target.setParaShapeId(docInfoAdder.forParaShape().processById(source.getParaShapeId()));
        target.setCharShapeId(docInfoAdder.forCharShape().processById(source.getCharShapeId()));
        return targetId;
    }

    public boolean equalById(short sourceId, short targetId) {
        Style source = docInfoAdder.getSourceHWPFile().getDocInfo().getStyleList().get(sourceId);
        Style target = docInfoAdder.getTargetHWPFile().getDocInfo().getStyleList().get(targetId);
        return equal(source, target, sourceId, targetId);
    }
}

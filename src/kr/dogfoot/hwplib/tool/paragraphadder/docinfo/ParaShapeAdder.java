package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.ParaShape;

/**
 * DocInfo에 ParaShape을 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class ParaShapeAdder {
    private DocInfoAdder docInfoAdder;

    public ParaShapeAdder(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
    }

    public int processById(int sourceId) {
        ParaShape source = docInfoAdder.getSourceHWPFile().getDocInfo().getParaShapeList().get(sourceId);
        int index = findFromTarget(source);
        if (index == -1) {
            index = addAndCopy(source);
        }
        return index;
    }

    private int findFromTarget(ParaShape source) {
        int count = docInfoAdder.getTargetHWPFile().getDocInfo().getParaShapeList().size();
        for (int index = 0; index < count; index++) {
            ParaShape target = docInfoAdder.getTargetHWPFile().getDocInfo().getParaShapeList().get(index);
            if (equal(source, target)) {
                return index;
            }
        }
        return -1;
    }

    private boolean equal(ParaShape source, ParaShape target) {
        return source.getProperty1().getValue() == target.getProperty1().getValue()
                && source.getLeftMargin() == target.getLeftMargin()
                && source.getRightMargin() == target.getRightMargin() && source.getIndent() == target.getIndent()
                && source.getTopParaSpace() == target.getTopParaSpace()
                && source.getBottomParaSpace() == target.getBottomParaSpace()
                && source.getLineSpace() == target.getLineSpace()
                && docInfoAdder.forTabDef().equalById(source.getTabDefId(), target.getTabDefId())
                && equalParaHead(source, target)
                && docInfoAdder.forBorderFill().equalById(source.getBorderFillId(), target.getBorderFillId())
                && source.getLeftBorderSpace() == target.getLeftBorderSpace()
                && source.getRightBorderSpace() == target.getRightBorderSpace()
                && source.getTopBorderSpace() == target.getTopBorderSpace()
                && source.getBottomBorderSpace() == target.getBottomBorderSpace()
                && source.getProperty2().getValue() == target.getProperty2().getValue()
                && source.getProperty3().getValue() == target.getProperty3().getValue()
                && source.getLineSpace2() == target.getLineSpace2();
    }

    private boolean equalParaHead(ParaShape source, ParaShape target) {
        if (source.getProperty1().getParaHeadShape() == target.getProperty1().getParaHeadShape()) {
            switch (source.getProperty1().getParaHeadShape()) {
                case None:
                    return true;
                case Numbering:
                case Outline:
                    return docInfoAdder.forNumbering().equalById(source.getParaHeadId(), target.getParaHeadId());
                case Bullet:
                    return docInfoAdder.forBullet().equalById(source.getParaHeadId(), target.getParaHeadId());
            }
        }
        return false;
    }

    private int addAndCopy(ParaShape source) {
        ParaShape target = docInfoAdder.getTargetHWPFile().getDocInfo().addNewParaShape();
        target.getProperty1().setValue(source.getProperty1().getValue());
        target.setLeftMargin(source.getLeftMargin());
        target.setRightMargin(source.getRightMargin());
        target.setIndent(source.getIndent());
        target.setTopParaSpace(source.getTopParaSpace());
        target.setBottomParaSpace(source.getBottomParaSpace());
        target.setLineSpace(source.getLineSpace());
        target.setTabDefId(docInfoAdder.forTabDef().processById(source.getTabDefId()));
        setParaHead(source, target);
        target.setBorderFillId(docInfoAdder.forBorderFill().processById(source.getBorderFillId()));
        target.setLeftBorderSpace(source.getLeftBorderSpace());
        target.setRightBorderSpace(source.getRightBorderSpace());
        target.setTopBorderSpace(source.getTopBorderSpace());
        target.setBottomBorderSpace(source.getBottomBorderSpace());
        target.getProperty2().setValue(source.getProperty2().getValue());
        target.getProperty3().setValue(source.getProperty3().getValue());
        target.setLineSpace2(source.getLineSpace2());

        return docInfoAdder.getTargetHWPFile().getDocInfo().getParaShapeList().size() - 1;
    }

    private void setParaHead(ParaShape source, ParaShape target) {
        switch (source.getProperty1().getParaHeadShape()) {
            case None:
                target.setParaHeadId(0);
                break;
            case Numbering:
            case Outline:
                target.setParaHeadId(docInfoAdder.forNumbering().processById(source.getParaHeadId()));
                break;
            case Bullet:
                target.setParaHeadId(docInfoAdder.forBullet().processById(source.getParaHeadId()));
                break;
        }
    }

    public boolean equalById(int sourceId, int targetId) {
        ParaShape source = docInfoAdder.getSourceHWPFile().getDocInfo().getParaShapeList().get(sourceId);
        ParaShape target = docInfoAdder.getTargetHWPFile().getDocInfo().getParaShapeList().get(targetId);
        return equal(source, target);
    }
}

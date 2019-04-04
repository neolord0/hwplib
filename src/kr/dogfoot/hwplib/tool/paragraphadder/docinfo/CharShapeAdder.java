package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.CharShape;
import kr.dogfoot.hwplib.object.docinfo.charshape.*;

/**
 * DocInfo에 CharShape을 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class CharShapeAdder {
    private DocInfoAdder docInfoAdder;

    public CharShapeAdder(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
    }

    public int processById(int sourceId) {
        CharShape source = docInfoAdder.getSourceHWPFile().getDocInfo().getCharShapeList().get(sourceId);
        int index = findFromTarget(source);
        if (index == -1) {
            index = addAndCopy(source);
        }
        return index;
    }

    private int findFromTarget(CharShape source) {
        int count = docInfoAdder.getTargetHWPFile().getDocInfo().getCharShapeList().size();
        for (int index = 0; index < count; index++) {
            CharShape target = docInfoAdder.getTargetHWPFile().getDocInfo().getCharShapeList().get(index);
            if (equal(source, target)) {
                return index;
            }
        }
        return -1;
    }

    public boolean equal(CharShape source, CharShape target) {
        return equalFaceNameIds(source.getFaceNameIds(), target.getFaceNameIds())
                && equalRatios(source.getRatios(), target.getRatios())
                && equalCharSpaces(source.getCharSpaces(), target.getCharSpaces())
                && equalRelativeSizes(source.getRelativeSizes(), target.getRelativeSizes())
                && equalCharOffsets(source.getCharOffsets(), target.getCharOffsets())
                && source.getBaseSize() == target.getBaseSize()
                && source.getProperty().getValue() == target.getProperty().getValue()
                && source.getShadowGap1() == target.getShadowGap1() && source.getShadowGap2() == target.getShadowGap2()
                && source.getCharColor().getValue() == target.getCharColor().getValue()
                && source.getUnderLineColor().getValue() == target.getUnderLineColor().getValue()
                && source.getShadeColor().getValue() == target.getShadeColor().getValue()
                && source.getShadowColor().getValue() == target.getShadowColor().getValue()
                && docInfoAdder.forBorderFill().equalById(source.getBorderFillId(), target.getBorderFillId())
                && source.getStrikeLineColor().getValue() == target.getStrikeLineColor().getValue();
    }

    private boolean equalFaceNameIds(FaceNameIds source, FaceNameIds target) {
        return docInfoAdder.forFaceName().equalByHangulId(source.getHangul(), target.getHangul())
                && docInfoAdder.forFaceName().equalByLatinId(source.getLatin(), target.getLatin())
                && docInfoAdder.forFaceName().equalByHanjaId(source.getHanja(), target.getHanja())
                && docInfoAdder.forFaceName().equalByJapaneseId(source.getJapanese(), target.getJapanese())
                && docInfoAdder.forFaceName().equalByOtherId(source.getOther(), target.getOther())
                && docInfoAdder.forFaceName().equalBySymbolId(source.getSymbol(), target.getSymbol())
                && docInfoAdder.forFaceName().equalByUserId(source.getUser(), target.getUser());
    }

    private boolean equalRatios(Ratios source, Ratios target) {
        short[] sourceArray = source.getArray();
        short[] targetArray = target.getArray();
        if (sourceArray.length == targetArray.length) {
            for (int index = 0; index < 7; index++) {
                if (sourceArray[index] != targetArray[index]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean equalCharSpaces(CharSpaces source, CharSpaces target) {
        byte[] sourceArray = source.getArray();
        byte[] targetArray = target.getArray();
        if (sourceArray.length == targetArray.length) {
            for (int index = 0; index < 7; index++) {
                if (sourceArray[index] != targetArray[index]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean equalRelativeSizes(RelativeSizes source, RelativeSizes target) {
        short[] sourceArray = source.getArray();
        short[] targetArray = target.getArray();
        if (sourceArray.length == targetArray.length) {
            for (int index = 0; index < 7; index++) {
                if (sourceArray[index] != targetArray[index]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean equalCharOffsets(CharOffsets source, CharOffsets target) {
        byte[] sourceArray = source.getArray();
        byte[] targetArray = target.getArray();
        if (sourceArray.length == targetArray.length) {
            for (int index = 0; index < 7; index++) {
                if (sourceArray[index] != targetArray[index]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private int addAndCopy(CharShape source) {
        CharShape target = docInfoAdder.getTargetHWPFile().getDocInfo().addNewCharShape();
        copyFaceNameIds(source.getFaceNameIds(), target.getFaceNameIds());
        copyRatios(source.getRatios(), target.getRatios());
        copyCharSpaces(source.getCharSpaces(), target.getCharSpaces());
        copyRelativeSizes(source.getRelativeSizes(), target.getRelativeSizes());
        copyCharOffsets(source.getCharOffsets(), target.getCharOffsets());
        target.setBaseSize(source.getBaseSize());
        target.getProperty().setValue(source.getProperty().getValue());
        target.setShadowGap1(source.getShadowGap1());
        target.setShadowGap2(source.getShadowGap2());
        target.getCharColor().setValue(source.getCharColor().getValue());
        target.getUnderLineColor().setValue(source.getUnderLineColor().getValue());
        target.getShadeColor().setValue(source.getShadeColor().getValue());
        target.getShadowColor().setValue(source.getShadowColor().getValue());
        target.setBorderFillId(docInfoAdder.forBorderFill().processById(source.getBorderFillId()));
        target.getStrikeLineColor().setValue(source.getStrikeLineColor().getValue());

        return docInfoAdder.getTargetHWPFile().getDocInfo().getCharShapeList().size() - 1;
    }

    private void copyFaceNameIds(FaceNameIds source, FaceNameIds target) {
        target.setHangul(docInfoAdder.forFaceName().processByHangulId(source.getHangul()));
        target.setLatin(docInfoAdder.forFaceName().processByLatinId(source.getLatin()));
        target.setHanja(docInfoAdder.forFaceName().processByHanjaId(source.getHanja()));
        target.setJapanese(docInfoAdder.forFaceName().processByJapaneseId(source.getJapanese()));
        target.setOther(docInfoAdder.forFaceName().processByOtherId(source.getOther()));
        target.setSymbol(docInfoAdder.forFaceName().processBySymbolId(source.getSymbol()));
        target.setUser(docInfoAdder.forFaceName().processByUserId(source.getUser()));
    }

    private void copyRatios(Ratios source, Ratios target) {
        target.setHangul(source.getHangul());
        target.setLatin(source.getLatin());
        target.setHanja(source.getHanja());
        target.setJapanese(source.getJapanese());
        target.setOther(source.getOther());
        target.setSymbol(source.getSymbol());
        target.setUser(source.getUser());
    }

    private void copyCharSpaces(CharSpaces source, CharSpaces target) {
        target.setHangul(source.getHangul());
        target.setLatin(source.getLatin());
        target.setHanja(source.getHanja());
        target.setJapanese(source.getJapanese());
        target.setOther(source.getOther());
        target.setSymbol(source.getSymbol());
        target.setUser(source.getUser());
    }

    private void copyRelativeSizes(RelativeSizes source, RelativeSizes target) {
        target.setHangul(source.getHangul());
        target.setLatin(source.getLatin());
        target.setHanja(source.getHanja());
        target.setJapanese(source.getJapanese());
        target.setOther(source.getOther());
        target.setSymbol(source.getSymbol());
        target.setUser(source.getUser());
    }

    private void copyCharOffsets(CharOffsets source, CharOffsets target) {
        target.setHangul(source.getHangul());
        target.setLatin(source.getLatin());
        target.setHanja(source.getHanja());
        target.setJapanese(source.getJapanese());
        target.setOther(source.getOther());
        target.setSymbol(source.getSymbol());
        target.setUser(source.getUser());
    }

    public boolean equalById(int sourceId, int targetId) {
        CharShape source = docInfoAdder.getSourceHWPFile().getDocInfo().getCharShapeList().get(sourceId);
        CharShape target = docInfoAdder.getTargetHWPFile().getDocInfo().getCharShapeList().get(targetId);

        return equal(source, target);
    }
}

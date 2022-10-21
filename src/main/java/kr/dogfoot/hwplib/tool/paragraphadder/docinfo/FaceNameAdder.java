package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.FaceName;
import kr.dogfoot.hwplib.object.docinfo.facename.FontTypeInfo;
import kr.dogfoot.hwplib.util.StringUtil;

import java.util.ArrayList;

/**
 * DocInfo에 FaceName을 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class FaceNameAdder {
    private DocInfoAdder docInfoAdder;

    public FaceNameAdder(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
    }

    public int processByHangulId(int sourceId) {
        if (docInfoAdder.getSourceHWPFile() == docInfoAdder.getTargetHWPFile()) {
            return sourceId;
        }

        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getHangulFaceNameList(), sourceId);
        ArrayList<FaceName> targetArray = docInfoAdder.getTargetHWPFile().getDocInfo().getHangulFaceNameList();
        return process(source, targetArray);
    }

    private FaceName getFaceName(ArrayList<FaceName> faceNameList, int index) {
        int count = faceNameList.size();
        if (index >= count) {
            return faceNameList.get(count - 1);
        } else {
            return faceNameList.get(index);
        }
    }

    private int process(FaceName source, ArrayList<FaceName> targetArray) {
        int index = find(source, targetArray);
        if (index == -1) {
            index = addAndCopy(source, targetArray);
        }
        return index;
    }

    private int find(FaceName source, ArrayList<FaceName> targetArray) {
        int count = targetArray.size();
        for (int index = 0; index < count; index++) {
            FaceName target = targetArray.get(index);
            if (equal(source, target)) {
                return index;
            }
        }
        return -1;
    }

    private boolean equal(FaceName source, FaceName target) {
        return source.getProperty().getValue() == target.getProperty().getValue()
                && source.getName().equals(target.getName())
                && source.getSubstituteFontType() == target.getSubstituteFontType()
                && equalNullableString(source.getSubstituteFontName(), target.getSubstituteFontName())
                && equalFontTypeInfo(source.getFontTypeInfo(), target.getFontTypeInfo())
                && StringUtil.equals(source.getBaseFontName(), target.getBaseFontName());
    }

    private boolean equalNullableString(String source, String target) {
        if (source == null && target == null) {
            return true;
        }
        return source.equals(target);
    }

    private boolean equalFontTypeInfo(FontTypeInfo source, FontTypeInfo target) {
        return source.getFontType() == target.getFontType() && source.getSerifType() == target.getSerifType()
                && source.getThickness() == target.getThickness() && source.getRatio() == target.getRatio()
                && source.getContrast() == target.getContrast()
                && source.getStrokeDeviation() == target.getStrokeDeviation()
                && source.getCharacterStrokeType() == target.getCharacterStrokeType()
                && source.getCharacterShape() == target.getCharacterShape()
                && source.getMiddleLine() == target.getMiddleLine() && source.getxHeight() == target.getxHeight();
    }

    private int addAndCopy(FaceName source, ArrayList<FaceName> targetArray) {
        FaceName target = new FaceName();
        targetArray.add(target);

        target.getProperty().setValue(source.getProperty().getValue());
        target.setName(source.getName());
        target.setSubstituteFontType(source.getSubstituteFontType());
        target.setSubstituteFontName(source.getSubstituteFontName());
        copyFontTypeInfo(source.getFontTypeInfo(), target.getFontTypeInfo());
        target.setBaseFontName(source.getBaseFontName());

        return targetArray.size() - 1;
    }

    private void copyFontTypeInfo(FontTypeInfo source, FontTypeInfo target) {
        target.setFontType(source.getFontType());
        target.setSerifType(source.getSerifType());
        target.setThickness(source.getThickness());
        target.setRatio(source.getRatio());
        target.setContrast(source.getContrast());
        target.setStrokeDeviation(source.getStrokeDeviation());
        target.setCharacterStrokeType(source.getCharacterStrokeType());
        target.setCharacterShape(source.getCharacterShape());
        target.setMiddleLine(source.getMiddleLine());
        target.setxHeight(source.getxHeight());
    }

    public int processByLatinId(int sourceId) {
        if (docInfoAdder.getSourceHWPFile() == docInfoAdder.getTargetHWPFile()) {
            return sourceId;
        }

        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getEnglishFaceNameList(), sourceId);
        ArrayList<FaceName> targetArray = docInfoAdder.getTargetHWPFile().getDocInfo().getEnglishFaceNameList();
        return process(source, targetArray);
    }

    public int processByHanjaId(int sourceId) {
        if (docInfoAdder.getSourceHWPFile() == docInfoAdder.getTargetHWPFile()) {
            return sourceId;
        }

        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getHanjaFaceNameList(), sourceId);
        ArrayList<FaceName> targetArray = docInfoAdder.getTargetHWPFile().getDocInfo().getHanjaFaceNameList();
        return process(source, targetArray);
    }

    public int processByJapaneseId(int sourceId) {
        if (docInfoAdder.getSourceHWPFile() == docInfoAdder.getTargetHWPFile()) {
            return sourceId;
        }

        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getJapaneseFaceNameList(), sourceId);
        ArrayList<FaceName> targetArray = docInfoAdder.getTargetHWPFile().getDocInfo().getJapaneseFaceNameList();
        return process(source, targetArray);
    }

    public int processByOtherId(int sourceId) {
        if (docInfoAdder.getSourceHWPFile() == docInfoAdder.getTargetHWPFile()) {
            return sourceId;
        }

        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getEtcFaceNameList(), sourceId);
        ArrayList<FaceName> targetArray = docInfoAdder.getTargetHWPFile().getDocInfo().getEtcFaceNameList();
        return process(source, targetArray);
    }

    public int processBySymbolId(int sourceId) {
        if (docInfoAdder.getSourceHWPFile() == docInfoAdder.getTargetHWPFile()) {
            return sourceId;
        }

        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getSymbolFaceNameList(), sourceId);
        ArrayList<FaceName> targetArray = docInfoAdder.getTargetHWPFile().getDocInfo().getSymbolFaceNameList();
        return process(source, targetArray);
    }

    public int processByUserId(int sourceId) {
        if (docInfoAdder.getSourceHWPFile() == docInfoAdder.getTargetHWPFile()) {
            return sourceId;
        }

        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getUserFaceNameList(), sourceId);
        ArrayList<FaceName> targetArray = docInfoAdder.getTargetHWPFile().getDocInfo().getUserFaceNameList();
        return process(source, targetArray);
    }

    public boolean equalByHangulId(int sourceId, int targetId) {
        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getHangulFaceNameList(), sourceId);
        FaceName target = getFaceName(docInfoAdder.getTargetHWPFile().getDocInfo().getHangulFaceNameList(), targetId);
        return equal(source, target);
    }

    public boolean equalByLatinId(int sourceId, int targetId) {
        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getEnglishFaceNameList(), sourceId);
        FaceName target = getFaceName(docInfoAdder.getTargetHWPFile().getDocInfo().getEnglishFaceNameList(), targetId);
        return equal(source, target);
    }

    public boolean equalByHanjaId(int sourceId, int targetId) {
        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getHanjaFaceNameList(), sourceId);
        FaceName target = getFaceName(docInfoAdder.getTargetHWPFile().getDocInfo().getHanjaFaceNameList(), targetId);
        return equal(source, target);
    }

    public boolean equalByJapaneseId(int sourceId, int targetId) {
        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getJapaneseFaceNameList(), sourceId);
        FaceName target = getFaceName(docInfoAdder.getTargetHWPFile().getDocInfo().getJapaneseFaceNameList(), targetId);
        return equal(source, target);
    }

    public boolean equalByOtherId(int sourceId, int targetId) {
        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getEtcFaceNameList(), sourceId);
        FaceName target = getFaceName(docInfoAdder.getTargetHWPFile().getDocInfo().getEtcFaceNameList(), targetId);
        return equal(source, target);
    }

    public boolean equalBySymbolId(int sourceId, int targetId) {
        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getSymbolFaceNameList(), sourceId);
        FaceName target = getFaceName(docInfoAdder.getTargetHWPFile().getDocInfo().getSymbolFaceNameList(), targetId);
        return equal(source, target);
    }

    public boolean equalByUserId(int sourceId, int targetId) {
        FaceName source = getFaceName(docInfoAdder.getSourceHWPFile().getDocInfo().getUserFaceNameList(), sourceId);
        FaceName target = getFaceName(docInfoAdder.getTargetHWPFile().getDocInfo().getUserFaceNameList(), targetId);
        return equal(source, target);
    }
}

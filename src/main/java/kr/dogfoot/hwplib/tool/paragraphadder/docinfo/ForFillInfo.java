package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.*;
import kr.dogfoot.hwplib.object.etc.Color4Byte;

import java.util.ArrayList;

/**
 * FillInfo 객체를 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class ForFillInfo {
    public static boolean equal(FillInfo source, FillInfo target) {
        if (source.getType().getValue() == target.getType().getValue()) {
            FillType fillType = source.getType();
            if (fillType.hasPatternFill()
                    && equalPatternFill(source.getPatternFill(), target.getPatternFill()) == false) {
                return false;
            }
            if (fillType.hasGradientFill()
                    && equalGradientFill(source.getGradientFill(), target.getGradientFill()) == false) {
                return false;
            }
            return !fillType.hasImageFill() || equalImageFill(source.getImageFill(), target.getImageFill()) != false;
        }
        return false;
    }

    private static boolean equalPatternFill(PatternFill source, PatternFill target) {
        return source.getBackColor().getValue() == target.getBackColor().getValue()
                && source.getPatternColor().getValue() == target.getPatternColor().getValue()
                && source.getPatternType() == target.getPatternType();
    }

    private static boolean equalGradientFill(GradientFill source, GradientFill target) {
        return source.getGradientType() == target.getGradientType() && source.getStartAngle() == target.getStartAngle()
                && source.getCenterX() == target.getCenterX() && source.getCenterY() == target.getCenterY()
                && source.getBlurringDegree() == target.getBlurringDegree()
                && equalArrayInteger(source.getChangePointList(), target.getChangePointList())
                && equalArrayColor4Byte(source.getColorList(), target.getColorList())
                && source.getBlurringCenter() == target.getBlurringCenter();

    }

    private static boolean equalArrayInteger(ArrayList<Integer> source, ArrayList<Integer> target) {
        if (source.size() == target.size()) {
            int count = source.size();
            for (int index = 0; index < count; index++) {
                if (source.get(index) != target.get(index)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean equalArrayColor4Byte(ArrayList<Color4Byte> source, ArrayList<Color4Byte> target) {
        if (source.size() == target.size()) {
            int count = source.size();
            for (int index = 0; index < count; index++) {
                if (source.get(index).getValue() != target.get(index).getValue()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean equalImageFill(ImageFill source, ImageFill target) {
        return source.getImageFillType() == target.getImageFillType()
                && equalPictureInfo(source.getPictureInfo(), target.getPictureInfo());
    }

    private static boolean equalPictureInfo(PictureInfo source, PictureInfo target) {
        /* && source.getBinItemID() == target.getBinItemID() 비교불가 */
        return source.getBrightness() == target.getBrightness() && source.getContrast() == target.getContrast()
                && source.getEffect() == target.getEffect();
    }

    public static void copy(FillInfo source, FillInfo target, DocInfoAdder docInfoAdder) {
        target.getType().setValue(source.getType().getValue());
        FillType fillType = source.getType();
        if (fillType.hasPatternFill() && source.getPatternFill() != null) {
            target.createPatternFill();
            copyPatternFill(source.getPatternFill(), target.getPatternFill());
        }
        if (fillType.hasGradientFill() && source.getGradientFill() != null) {
            target.createGradientFill();
            copyGradientFill(source.getGradientFill(), target.getGradientFill());
        }
        if (fillType.hasImageFill() && source.getImageFill() != null) {
            target.createImageFill();
            copyImageFill(source.getImageFill(), target.getImageFill(), docInfoAdder);
        }
    }

    private static void copyPatternFill(PatternFill source, PatternFill target) {
        target.getBackColor().setValue(source.getBackColor().getValue());
        target.getPatternColor().setValue(source.getPatternColor().getValue());
        target.setPatternType(source.getPatternType());
    }

    private static void copyGradientFill(GradientFill source, GradientFill target) {
        target.setGradientType(source.getGradientType());
        target.setStartAngle(source.getStartAngle());
        target.setCenterX(source.getCenterX());
        target.setCenterY(source.getCenterY());
        target.setBlurringDegree(source.getBlurringDegree());
        for (Integer changePoint : source.getChangePointList()) {
            target.getChangePointList().add(new Integer(changePoint.intValue()));
        }
        for (Color4Byte color : source.getColorList()) {
            Color4Byte newColor = new Color4Byte();
            newColor.setValue(color.getValue());
            target.getColorList().add(newColor);
        }
        target.setBlurringDegree(source.getBlurringDegree());
    }

    private static void copyImageFill(ImageFill source, ImageFill target, DocInfoAdder docInfoAdder) {
        target.setImageFillType(source.getImageFillType());
        copyPictureInfo(source.getPictureInfo(), target.getPictureInfo(), docInfoAdder);
    }

    private static void copyPictureInfo(PictureInfo source, PictureInfo target, DocInfoAdder docInfoAdder) {
        target.setBrightness(source.getBrightness());
        target.setContrast(source.getContrast());
        target.setEffect(source.getEffect());
        target.setBinItemID(docInfoAdder.forBinData().processById(source.getBinItemID()));
    }
}

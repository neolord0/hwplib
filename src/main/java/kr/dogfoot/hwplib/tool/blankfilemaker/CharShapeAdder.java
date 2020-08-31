package kr.dogfoot.hwplib.tool.blankfilemaker;

import kr.dogfoot.hwplib.object.docinfo.CharShape;
import kr.dogfoot.hwplib.object.docinfo.DocInfo;

public class CharShapeAdder {
    public static void add(DocInfo docInfo) {
        charShape1(docInfo.addNewCharShape());
        charShape2(docInfo.addNewCharShape());
        charShape3(docInfo.addNewCharShape());
        charShape4(docInfo.addNewCharShape());
        charShape5(docInfo.addNewCharShape());
    }

    private static void charShape1(CharShape charShape) {
        charShape.getFaceNameIds().setForAll(1);
        charShape.getRatios().setForAll((short) 100);
        charShape.getCharSpaces().setForAll((byte) 0);
        charShape.getRelativeSizes().setForAll((short) 100);;
        charShape.getCharOffsets().setForAll((byte) 0);
        charShape.setBaseSize(1000);
        charShape.getProperty().setValue(0);
        charShape.setShadowGap1((byte) 10);
        charShape.setShadowGap2((byte) 10);
        charShape.getCharColor().setValue(0);
        charShape.getUnderLineColor().setValue(0);
        charShape.getShadeColor().setValue(-1);
        charShape.getShadowColor().setValue(11711154);
        charShape.setBorderFillId(2);
        charShape.getStrikeLineColor().setValue(0);
    }

    private static void charShape2(CharShape charShape) {
        charShape.getFaceNameIds().setForAll(0);
        charShape.getRatios().setForAll((short) 100);
        charShape.getCharSpaces().setForAll((byte) 0);
        charShape.getRelativeSizes().setForAll((short) 100);;
        charShape.getCharOffsets().setForAll((byte) 0);
        charShape.setBaseSize(1000);
        charShape.getProperty().setValue(0);
        charShape.setShadowGap1((byte) 10);
        charShape.setShadowGap2((byte) 10);
        charShape.getCharColor().setValue(0);
        charShape.getUnderLineColor().setValue(0);
        charShape.getShadeColor().setValue(-1);
        charShape.getShadowColor().setValue(11711154);
        charShape.setBorderFillId(2);
        charShape.getStrikeLineColor().setValue(0);
    }

    private static void charShape3(CharShape charShape) {
        charShape.getFaceNameIds().setForAll(0);
        charShape.getRatios().setForAll((short) 100);
        charShape.getCharSpaces().setForAll((byte) 0);
        charShape.getRelativeSizes().setForAll((short) 100);;
        charShape.getCharOffsets().setForAll((byte) 0);
        charShape.setBaseSize(900);
        charShape.getProperty().setValue(0);
        charShape.setShadowGap1((byte) 10);
        charShape.setShadowGap2((byte) 10);
        charShape.getCharColor().setValue(0);
        charShape.getUnderLineColor().setValue(0);
        charShape.getShadeColor().setValue(-1);
        charShape.getShadowColor().setValue(11711154);
        charShape.setBorderFillId(2);
        charShape.getStrikeLineColor().setValue(0);
    }

    private static void charShape4(CharShape charShape) {
        charShape.getFaceNameIds().setForAll(1);
        charShape.getRatios().setForAll((short) 100);
        charShape.getCharSpaces().setForAll((byte) 0);
        charShape.getRelativeSizes().setForAll((short) 100);;
        charShape.getCharOffsets().setForAll((byte) 0);
        charShape.setBaseSize(900);
        charShape.getProperty().setValue(0);
        charShape.setShadowGap1((byte) 10);
        charShape.setShadowGap2((byte) 10);
        charShape.getCharColor().setValue(0);
        charShape.getUnderLineColor().setValue(0);
        charShape.getShadeColor().setValue(-1);
        charShape.getShadowColor().setValue(11711154);
        charShape.setBorderFillId(2);
        charShape.getStrikeLineColor().setValue(0);
    }

    private static void charShape5(CharShape charShape) {
        charShape.getFaceNameIds().setForAll(0);
        charShape.getRatios().setForAll((short) 100);
        charShape.getCharSpaces().setForAll((byte) -5);
        charShape.getRelativeSizes().setForAll((short) 100);;
        charShape.getCharOffsets().setForAll((byte) 0);
        charShape.setBaseSize(900);
        charShape.getProperty().setValue(0);
        charShape.setShadowGap1((byte) 10);
        charShape.setShadowGap2((byte) 10);
        charShape.getCharColor().setValue(0);
        charShape.getUnderLineColor().setValue(0);
        charShape.getShadeColor().setValue(-1);
        charShape.getShadowColor().setValue(11711154);
        charShape.setBorderFillId(2);
        charShape.getStrikeLineColor().setValue(0);
    }
}

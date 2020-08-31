package kr.dogfoot.hwplib.tool.blankfilemaker;

import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.docinfo.Numbering;
import kr.dogfoot.hwplib.object.docinfo.numbering.LevelNumbering;

public class NumberingAdder {
    public static void add(DocInfo docInfo) {
        numbering1(docInfo.addNewNumbering());
    }

    private static void numbering1(Numbering numbering) {
        try {
            LevelNumbering levelNumbering = numbering.getLevelNumbering(1);
            levelNumbering.getParagraphHeadInfo().getProperty().setValue(12);
            levelNumbering.getParagraphHeadInfo().setCorrectionValueForWidth(0);
            levelNumbering.getParagraphHeadInfo().setDistanceFromBody(50);
            levelNumbering.getParagraphHeadInfo().setCharShapeID(-1);
            levelNumbering.setNumberFormat("^1.");
            levelNumbering.setStartNumber(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            LevelNumbering levelNumbering = numbering.getLevelNumbering(2);
            levelNumbering.getParagraphHeadInfo().getProperty().setValue(268);
            levelNumbering.getParagraphHeadInfo().setCorrectionValueForWidth(0);
            levelNumbering.getParagraphHeadInfo().setDistanceFromBody(50);
            levelNumbering.getParagraphHeadInfo().setCharShapeID(-1);
            levelNumbering.setNumberFormat("^2.");
            levelNumbering.setStartNumber(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            LevelNumbering levelNumbering = numbering.getLevelNumbering(3);
            levelNumbering.getParagraphHeadInfo().getProperty().setValue(12);
            levelNumbering.getParagraphHeadInfo().setCorrectionValueForWidth(0);
            levelNumbering.getParagraphHeadInfo().setDistanceFromBody(50);
            levelNumbering.getParagraphHeadInfo().setCharShapeID(-1);
            levelNumbering.setNumberFormat("^3)");
            levelNumbering.setStartNumber(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            LevelNumbering levelNumbering = numbering.getLevelNumbering(4);
            levelNumbering.getParagraphHeadInfo().getProperty().setValue(268);
            levelNumbering.getParagraphHeadInfo().setCorrectionValueForWidth(0);
            levelNumbering.getParagraphHeadInfo().setDistanceFromBody(50);
            levelNumbering.getParagraphHeadInfo().setCharShapeID(-1);
            levelNumbering.setNumberFormat("^4)");
            levelNumbering.setStartNumber(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            LevelNumbering levelNumbering = numbering.getLevelNumbering(5);
            levelNumbering.getParagraphHeadInfo().getProperty().setValue(12);
            levelNumbering.getParagraphHeadInfo().setCorrectionValueForWidth(0);
            levelNumbering.getParagraphHeadInfo().setDistanceFromBody(50);
            levelNumbering.getParagraphHeadInfo().setCharShapeID(-1);
            levelNumbering.setNumberFormat("(^5)");
            levelNumbering.setStartNumber(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            LevelNumbering levelNumbering = numbering.getLevelNumbering(6);
            levelNumbering.getParagraphHeadInfo().getProperty().setValue(268);
            levelNumbering.getParagraphHeadInfo().setCorrectionValueForWidth(0);
            levelNumbering.getParagraphHeadInfo().setDistanceFromBody(50);
            levelNumbering.getParagraphHeadInfo().setCharShapeID(-1);
            levelNumbering.setNumberFormat("(^6)");
            levelNumbering.setStartNumber(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            LevelNumbering levelNumbering = numbering.getLevelNumbering(7);
            levelNumbering.getParagraphHeadInfo().getProperty().setValue(44);
            levelNumbering.getParagraphHeadInfo().setCorrectionValueForWidth(0);
            levelNumbering.getParagraphHeadInfo().setDistanceFromBody(50);
            levelNumbering.getParagraphHeadInfo().setCharShapeID(-1);
            levelNumbering.setNumberFormat("^7");
            levelNumbering.setStartNumber(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            LevelNumbering levelNumbering = numbering.getLevelNumbering(8);
            levelNumbering.getParagraphHeadInfo().getProperty().setValue(0);
            levelNumbering.getParagraphHeadInfo().setCorrectionValueForWidth(0);
            levelNumbering.getParagraphHeadInfo().setDistanceFromBody(0);
            levelNumbering.getParagraphHeadInfo().setCharShapeID(0);
            levelNumbering.setNumberFormat(null);
            levelNumbering.setStartNumber(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            LevelNumbering levelNumbering = numbering.getLevelNumbering(9);
            levelNumbering.getParagraphHeadInfo().getProperty().setValue(0);
            levelNumbering.getParagraphHeadInfo().setCorrectionValueForWidth(0);
            levelNumbering.getParagraphHeadInfo().setDistanceFromBody(0);
            levelNumbering.getParagraphHeadInfo().setCharShapeID(0);
            levelNumbering.setNumberFormat(null);
            levelNumbering.setStartNumber(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            LevelNumbering levelNumbering = numbering.getLevelNumbering(10);
            levelNumbering.getParagraphHeadInfo().getProperty().setValue(0);
            levelNumbering.getParagraphHeadInfo().setCorrectionValueForWidth(0);
            levelNumbering.getParagraphHeadInfo().setDistanceFromBody(0);
            levelNumbering.getParagraphHeadInfo().setCharShapeID(0);
            levelNumbering.setNumberFormat(null);
            levelNumbering.setStartNumber(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package kr.dogfoot.hwplib.tool.blankfilemaker;

import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.docinfo.FaceName;
import kr.dogfoot.hwplib.object.docinfo.facename.FontTypeInfo;

public class FaceNameAdder {
    public static void add(DocInfo docInfo) {
        hangulFaceName(docInfo);
        englishFaceName(docInfo);
        hanjaFaceName(docInfo);
        japaneseFaceName(docInfo);
        etcFaceName(docInfo);
        symbolFaceName(docInfo);
        userFaceName(docInfo);
    }


    private static void hangulFaceName(DocInfo docInfo) {
        setFaceName1(docInfo.addNewHangulFaceName());
        setFaceName2(docInfo.addNewHangulFaceName());
    }

    private static void setFaceName1(FaceName faceName) {
        faceName.getProperty().setValue((short) 97);
        faceName.setName("함초롬돋움");
        faceName.setSubstituteFontType(null);
        faceName.setSubstituteFontName(null);

        FontTypeInfo fontTypeInfo = faceName.getFontTypeInfo();
        fontTypeInfo.setFontType((short) 2);
        fontTypeInfo.setSerifType((short) 3);
        fontTypeInfo.setThickness((short) 5);
        fontTypeInfo.setRatio((short) 4);
        fontTypeInfo.setContrast((short) 0);
        fontTypeInfo.setStrokeDeviation((short) 1);
        fontTypeInfo.setCharacterStrokeType((short) 1);
        fontTypeInfo.setCharacterShape((short) 1);
        fontTypeInfo.setMiddleLine((short) 1);
        fontTypeInfo.setxHeight((short) 1);

        faceName.setBaseFontName("HCR Dotum");
    }

    private static void setFaceName2(FaceName faceName) {
        faceName.getProperty().setValue((short) 97);
        faceName.setName("함초롬바탕");
        faceName.setSubstituteFontType(null);
        faceName.setSubstituteFontName(null);

        FontTypeInfo fontTypeInfo = faceName.getFontTypeInfo();
        fontTypeInfo.setFontType((short) 2);
        fontTypeInfo.setSerifType((short) 3);
        fontTypeInfo.setThickness((short) 5);
        fontTypeInfo.setRatio((short) 4);
        fontTypeInfo.setContrast((short) 0);
        fontTypeInfo.setStrokeDeviation((short) 1);
        fontTypeInfo.setCharacterStrokeType((short) 1);
        fontTypeInfo.setCharacterShape((short) 1);
        fontTypeInfo.setMiddleLine((short) 1);
        fontTypeInfo.setxHeight((short) 1);

        faceName.setBaseFontName("HCR Batang");
    }

    private static void englishFaceName(DocInfo docInfo) {
        setFaceName1(docInfo.addNewEnglishFaceName());
        setFaceName2(docInfo.addNewEnglishFaceName());
    }

    private static void hanjaFaceName(DocInfo docInfo) {
        setFaceName1(docInfo.addNewHanjaFaceName());
        setFaceName2(docInfo.addNewHanjaFaceName());
    }

    private static void japaneseFaceName(DocInfo docInfo) {
        setFaceName1(docInfo.addNewJapaneseFaceName());
        setFaceName2(docInfo.addNewJapaneseFaceName());
    }

    private static void etcFaceName(DocInfo docInfo) {
        setFaceName1(docInfo.addNewEtcFaceName());
        setFaceName2(docInfo.addNewEtcFaceName());
    }

    private static void symbolFaceName(DocInfo docInfo) {
        setFaceName1(docInfo.addNewSymbolFaceName());
        setFaceName2(docInfo.addNewSymbolFaceName());
    }

    private static void userFaceName(DocInfo docInfo) {
        setFaceName1(docInfo.addNewUserFaceName());
        setFaceName2(docInfo.addNewUserFaceName());
    }
}

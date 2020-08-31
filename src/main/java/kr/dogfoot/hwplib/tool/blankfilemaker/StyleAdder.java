package kr.dogfoot.hwplib.tool.blankfilemaker;

import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.docinfo.Style;

public class StyleAdder {
    public static void add(DocInfo docInfo) {
        style1(docInfo.addNewStyle());
        style2(docInfo.addNewStyle());
        style3(docInfo.addNewStyle());
        style4(docInfo.addNewStyle());
        style5(docInfo.addNewStyle());
        style6(docInfo.addNewStyle());
        style7(docInfo.addNewStyle());
        style8(docInfo.addNewStyle());
        style9(docInfo.addNewStyle());
        style10(docInfo.addNewStyle());
        style11(docInfo.addNewStyle());
        style12(docInfo.addNewStyle());
        style13(docInfo.addNewStyle());
        style14(docInfo.addNewStyle());
    }

    private static void style1(Style style) {
        style.setHangulName("바탕글");
        style.setEnglishName("Normal");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 0);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(3);
        style.setCharShapeId(0);
    }

    private static void style2(Style style) {
        style.setHangulName("본문");
        style.setEnglishName("Body");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 1);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(11);
        style.setCharShapeId(0);
    }

    private static void style3(Style style) {
        style.setHangulName("개요 1");
        style.setEnglishName("Outline 1");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 2);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(10);
        style.setCharShapeId(0);
    }

    private static void style4(Style style) {
        style.setHangulName("개요 2");
        style.setEnglishName("Outline 2");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 3);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(9);
        style.setCharShapeId(0);
    }

    private static void style5(Style style) {
        style.setHangulName("개요 3");
        style.setEnglishName("Outline 3");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 4);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(8);
        style.setCharShapeId(0);
    }

    private static void style6(Style style) {
        style.setHangulName("개요 4");
        style.setEnglishName("Outline 4");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 5);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(7);
        style.setCharShapeId(0);
    }

    private static void style7(Style style) {
        style.setHangulName("개요 5");
        style.setEnglishName("Outline 5");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 6);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(6);
        style.setCharShapeId(0);
    }

    private static void style8(Style style) {
        style.setHangulName("개요 6");
        style.setEnglishName("Outline 6");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 7);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(5);
        style.setCharShapeId(0);
    }

    private static void style9(Style style) {
        style.setHangulName("개요 7");
        style.setEnglishName("Outline 7");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 8);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(4);
        style.setCharShapeId(0);
    }

    private static void style10(Style style) {
        style.setHangulName("쪽 번호");
        style.setEnglishName("Page Number");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 9);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(3);
        style.setCharShapeId(1);
    }

    private static void style11(Style style) {
        style.setHangulName("머리말");
        style.setEnglishName("Header");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 10);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(2);
        style.setCharShapeId(2);
    }

    private static void style12(Style style) {
        style.setHangulName("각주");
        style.setEnglishName("Footnote");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 11);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(1);
        style.setCharShapeId(3);
    }

    private static void style13(Style style) {
        style.setHangulName("미주");
        style.setEnglishName("Endnote");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 12);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(1);
        style.setCharShapeId(3);
    }

    private static void style14(Style style) {
        style.setHangulName("메모");
        style.setEnglishName("Memo");
        style.getProeprty().setValue((short) 0);
        style.setNextStyleId((short) 13);
        style.setLanguageId((short) 1042);
        style.setParaShapeId(0);
        style.setCharShapeId(4);
    }
}

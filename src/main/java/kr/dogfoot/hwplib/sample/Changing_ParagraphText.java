package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharNormal;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharType;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Changing_ParagraphText {
    private static final String source1 = "안녕하세요.";
    private static final String target1 = "Hello.";
    private static final String source2 = "이것은 샘플입니다.";
    private static final String target2 = "This is Sample.";

    public static void main(String[] args) throws Exception {
        String filename = "sample_hwp" + File.separator + "test-change-paragraph-text.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            Section s = hwpFile.getBodyText().getSectionList().get(0);
            int count = s.getParagraphCount();
            for (int index = 0; index < count; index++) {
                changeParagraphText(hwpFile.getBodyText().getSectionList().get(0).getParagraph(index));
            }

            String filename2 = "sample_hwp" + File.separator + "edit_test-change-paragraph-text.hwp";
            HWPWriter.toFile(hwpFile, filename2);
        }
    }

    private static void changeParagraphText(Paragraph paragraph) throws UnsupportedEncodingException {
        ArrayList<HWPChar> newCharList = getNewCharList(paragraph.getText().getCharList());
        changeNewCharList(paragraph, newCharList);
        removeLineSeg(paragraph);
        removeCharShapeExceptFirstOne(paragraph);
    }

    public static ArrayList<HWPChar> getNewCharList(ArrayList<HWPChar> oldList) throws UnsupportedEncodingException {
        ArrayList<HWPChar> newList = new ArrayList<HWPChar>();
        ArrayList<HWPChar> listForText = new ArrayList<HWPChar>();
        for (HWPChar ch : oldList) {
            if (ch.getType() == HWPCharType.Normal) {
                listForText.add(ch);
            } else {
                if (listForText.size() > 0) {
                    String text = toString(listForText);
                    listForText.clear();
                    String newText = changeText(text);

                    newList.addAll(toHWPCharList(newText));
                }
                newList.add(ch);
            }
        }

        if (listForText.size() > 0) {
            String text = toString(listForText);
            listForText.clear();
            String newText = changeText(text);

            newList.addAll(toHWPCharList(newText));
        }
        return newList;
    }

    private static String toString(ArrayList<HWPChar> listForText) throws UnsupportedEncodingException {
        StringBuffer sb = new StringBuffer();
        for (HWPChar ch : listForText) {
            HWPCharNormal chn = (HWPCharNormal) ch;
            sb.append(chn.getCh());
        }
        return sb.toString();
    }

    private static String changeText(String text) {
        if (source1.equals(text)) {
            return target1;
        } else if (source2.equals(text)) {
            return target2;
        }
        return null;
    }

    private static ArrayList<HWPChar> toHWPCharList(String text) {
        ArrayList<HWPChar> list = new ArrayList<HWPChar>();
        int count = text.length();
        for (int index = 0; index < count; index++) {
            HWPCharNormal chn = new HWPCharNormal();
            chn.setCode((short) text.codePointAt(index));
            list.add(chn);
        }
        return list;
    }

    private static void changeNewCharList(Paragraph paragraph, ArrayList<HWPChar> newCharList) {
        paragraph.getText().getCharList().clear();
        for (HWPChar ch : newCharList) {
            paragraph.getText().getCharList().add(ch);
        }
        paragraph.getHeader().setCharacterCount(newCharList.size());
    }

    private static void removeLineSeg(Paragraph paragraph) {
        paragraph.deleteLineSeg();
    }


    private static void removeCharShapeExceptFirstOne(Paragraph paragraph) {
        int size = paragraph.getCharShape().getPositonShapeIdPairList().size();
        if (size > 1) {
            for (int index = 0; index < size - 1; index++) {
                paragraph.getCharShape().getPositonShapeIdPairList().remove(1);
            }
            paragraph.getHeader().setCharShapeCount(1);
        }
    }


}
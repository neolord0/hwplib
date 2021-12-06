package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.CharPositionShapeIdPair;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharNormal;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;

import java.util.ArrayList;

public class ParaTextSetter {

    public static void changeText(Paragraph p, int startIndex, int endIndex, String text) {
        String text2 = replaceCRLF(text);
        deleteOriginChar(p.getText(), startIndex, endIndex);
        insertChar(p.getText(), startIndex, text2);
        adjustParaCharShape(p.getCharShape(), startIndex, endIndex, text2);
        deleteLineSeg(p);
    }

    private static String replaceCRLF(String text) {
        StringBuffer sb = new StringBuffer();
        int len = text.length();
        for (int index = 0; index < len; index++) {
            char ch = text.charAt(index);
            if (ch == '\r') {
                if (index + 1 < len && text.charAt(index + 1) == '\n') {
                    index++;
                }
                sb.append('\r');
            } else if (ch == '\n') {
                if (index + 1 < len && text.charAt(index + 1) == '\r') {
                    index++;
                }
                sb.append('\r');
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private static void deleteOriginChar(ParaText paraText, int startIndex, int endIndex) {
        for (int index = startIndex; index <= endIndex; index++) {
            paraText.getCharList().remove(startIndex);
        }
    }

    private static void insertChar(ParaText paraText, int startIndex, String text) {
        int len = text.length();
        for (int index = 0; index < len; index++) {
            HWPCharNormal ch = new HWPCharNormal();
            ch.setCode((short) text.codePointAt(index));
            paraText.getCharList().add(startIndex + index, ch);
        }
    }

    private static void adjustParaCharShape(ParaCharShape paraCharShape, int startIndex, int endIndex, String text) {
        int len = text.length();
        ArrayList<CharPositionShapeIdPair> list = paraCharShape.getPositonShapeIdPairList();
        ArrayList<CharPositionShapeIdPair> deleteItems = new ArrayList<CharPositionShapeIdPair>();
        for (CharPositionShapeIdPair cpsip : list) {
            if (cpsip.getPosition() < startIndex) {
                continue;
            } else if (cpsip.getPosition() >= startIndex && cpsip.getPosition() <= endIndex) {
                deleteItems.add(cpsip);
            } else if (cpsip.getPosition() < endIndex) {
                int oldLen = endIndex - startIndex + 1;
                cpsip.setPosition(cpsip.getPosition() + oldLen - len);
            }
        }
        for (CharPositionShapeIdPair cpsip : deleteItems) {
            list.remove(cpsip);
        }
    }

    private static void deleteLineSeg(Paragraph p) {
        p.deleteLineSeg();
    }


    /**
     * 문단에 텍스트를 from 위치부터 삭제한다.
     *
     * @param p    문단
     * @param from 삭제할 시작 위치
     */
    public static void deleteParaTextFrom(Paragraph p, int from) {
        int leftCtrlCount = 0;
        int leftCharSize = 0;
        if (p.getText() != null) {
            for (int charIndex = 0; charIndex < from; charIndex++) {
                HWPChar hwpChar = p.getText().getCharList().get(charIndex);
                if (hwpChar.getType() == HWPCharType.ControlExtend) {
                    leftCtrlCount++;
                }
                leftCharSize += hwpChar.getCharSize();
            }
            int deleteCharCount = p.getText().getCharList().size() - from - 1;
            for (int index = 0; index < deleteCharCount; index++) {
                p.getText().getCharList().remove(from);
            }
        }
        if (p.getControlList() != null) {
            int deleteCtrlCount = p.getControlList().size() - leftCtrlCount;
            for (int index = 0; index < deleteCtrlCount; index++) {
                p.getControlList().remove(leftCtrlCount);
            }
        }

        ArrayList<CharPositionShapeIdPair> deletings = new ArrayList<>();
        for (CharPositionShapeIdPair cpsip : p.getCharShape().getPositonShapeIdPairList()) {
            if (cpsip.getPosition() > leftCharSize) {
                deletings.add(cpsip);
            }
        }
        for (CharPositionShapeIdPair cpsip : deletings) {
            p.getCharShape().getPositonShapeIdPairList().remove(cpsip);
        }
    }

    /**
     * 문단에 텍스트를 to 위치까지 삭제한다.
     *
     * @param p  문단
     * @param to 삭제할 끝 위치
     */
    public static void deleteParaTextTo(Paragraph p, int to) {
        int deleteCtrlCount = 0;
        int deleteCharSize = 0;
        if (p.getText() != null) {
            for (int charIndex = 0; charIndex < to + 1 && charIndex < p.getText().getCharList().size() - 1; charIndex++) {
                HWPChar hwpChar = p.getText().getCharList().get(charIndex);
                if (hwpChar.getType() == HWPCharType.ControlExtend) {
                    deleteCtrlCount++;
                }
            }

            for (int index = 0; index < to + 1; index++) {
                if (p.getText().getCharList().size() == 1) {
                    break;
                }
                deleteCharSize += p.getText().getCharList().get(0).getCharSize();
                p.getText().getCharList().remove(0);
            }
        }
        if (p.getControlList() != null) {
            for (int index = 0; index < deleteCtrlCount; index++) {
                p.getControlList().remove(0);
            }
        }

        ArrayList<CharPositionShapeIdPair> deletings = new ArrayList<>();
        for (CharPositionShapeIdPair cpsip : p.getCharShape().getPositonShapeIdPairList()) {
            if (cpsip.getPosition() != 0) {
                if (cpsip.getPosition() < to + 1) {
                    deletings.add(cpsip);
                } else {
                    cpsip.setPosition(cpsip.getPosition() - deleteCharSize);
                }
            }
        }
        for (CharPositionShapeIdPair cpsip : deletings) {
            p.getCharShape().getPositonShapeIdPairList().remove(cpsip);
        }
    }

    /**
     * 문단 para1 끝에 문단 para2을 병합한다.
     *
     * @param para1 문단1
     * @param para2 문단2
     */
    public static void mergeParagraph(Paragraph para1, Paragraph para2) {
        int para1CharSize = para1.getText().getCharSize();
        para1.getText().getCharList().remove(para1.getText().getCharList().size() - 1);
        para1CharSize -= 1;


        if (para2.getText() != null && para2.getText().getCharList().size() > 0) {
            if (para1.getText() == null) {
                para1.createText();
            }
            for (HWPChar hwpChar : para2.getText().getCharList()) {
                para1.getText().getCharList().add(hwpChar);
            }
        }

        if (para2.getControlList() != null && para2.getControlList().size() > 0) {
            if (para1.getControlList() == null) {
                para1.createControlList();
            }
            for (Control control : para2.getControlList()) {
                para1.getControlList().add(control);
            }
        }

        if (para2.getCharShape() != null && para2.getCharShape().getPositonShapeIdPairList().size() > 0) {
            if (para1.getCharShape() == null) {
                para1.createCharShape();
            }
            for (CharPositionShapeIdPair cpsip : para2.getCharShape().getPositonShapeIdPairList()) {
                cpsip.setPosition(cpsip.getPosition() + para1CharSize);
                para1.getCharShape().getPositonShapeIdPairList().add(cpsip);
            }
        }
    }

}

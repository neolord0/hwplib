package kr.dogfoot.hwplib.tool.textextractor;

import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharNormal;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 문단 리스트를 위한 텍스트 추출기 객체
 *
 * @author neolord
 */
public class ForParagraphList {
    /**
     * 문단 리스트에서 텍스트를 추출한다.
     *
     * @param paragraphList 문단 리스트
     * @param tem           텍스트 추출 방법
     * @param sb            추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(ParagraphListInterface paragraphList,
                               TextExtractMethod tem, StringBuffer sb) throws UnsupportedEncodingException {
        if (paragraphList == null) {
            return;
        }
        for (Paragraph p : paragraphList) {
            paragraph(p, tem, sb);
        }
    }

    /**
     * startIndex 순번 부터 끝 순번 까지의 문단의 텍스트를 추출한다.
     *
     * @param p          문단
     * @param startIndex 시작 순번
     * @param tem        텍스트 추출 방법
     * @param sb         추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(Paragraph p, int startIndex,
                               TextExtractMethod tem, StringBuffer sb) throws UnsupportedEncodingException {
        ParaText pt = p.getText();
        if (pt != null) {
            extract(p, startIndex, pt.getCharList().size() - 1, tem, sb);
        }
    }

    /**
     * startIndex 순번 부터 endIndex 순번 까지의 문단의 텍스트를 추출한다.
     *
     * @param p          문단
     * @param startIndex 시작 순번
     * @param endIndex   끝 순번
     * @param tem        텍스트 추출 방법
     * @param sb         추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(Paragraph p, int startIndex, int endIndex,
                               TextExtractMethod tem, StringBuffer sb) throws UnsupportedEncodingException {
        ArrayList<Control> controlList = new ArrayList<Control>();
        ParaText pt = p.getText();
        if (pt != null) {
            int controlIndex = 0;

            int charCount = pt.getCharList().size();
            for (int charIndex = 0; charIndex < charCount; charIndex++) {
                HWPChar ch = pt.getCharList().get(charIndex);
                switch (ch.getType()) {
                    case Normal:
                        if (startIndex <= charIndex && charIndex <= endIndex) {
                            normalText(ch, sb);
                        }
                        break;
                    case ControlExtend:
                        if (startIndex <= charIndex && charIndex <= endIndex) {
                            if (tem == TextExtractMethod.InsertControlTextBetweenParagraphText) {
                                sb.append("\n");
                                ForControl.extract(
                                        p.getControlList().get(controlIndex), tem,
                                        sb);
                            } else {
                                controlList.add(p.getControlList()
                                        .get(controlIndex));
                            }
                        }
                        controlIndex++;
                        break;
                    default:
                        break;
                }
            }
        }
        if (tem == TextExtractMethod.AppendControlTextAfterParagraphText) {
            sb.append("\n");
            controls(controlList, tem, sb);
        }
    }

    /**
     * 문단의 텍스트를 추출한다.
     *
     * @param p   문단
     * @param tem 텍스트 추출 방법
     * @param sb  추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    public static void paragraph(Paragraph p, TextExtractMethod tem,
                                  StringBuffer sb) throws UnsupportedEncodingException {
        ParaText pt = p.getText();
        if (pt != null) {
            int controlIndex = 0;
            for (HWPChar ch : pt.getCharList()) {
                switch (ch.getType()) {
                    case Normal:
                        normalText(ch, sb);
                        break;
                    case ControlExtend:
                        if (tem == TextExtractMethod.InsertControlTextBetweenParagraphText) {
                            sb.append("\n");
                            ForControl.extract(
                                    p.getControlList().get(controlIndex), tem, sb);
                            controlIndex++;
                        }
                        break;
                    default:
                        break;
                }
            }
            sb.append("\n");
        }
        if (tem == TextExtractMethod.AppendControlTextAfterParagraphText) {
            controls(p.getControlList(), tem, sb);
        }
    }

    /**
     * 일반 문자에서 문자를 추출한다.
     *
     * @param ch 한글 문자
     * @param sb 추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void normalText(HWPChar ch, StringBuffer sb) throws UnsupportedEncodingException {
        sb.append(((HWPCharNormal) ch).getCh());
    }

    /**
     * 컨트롤 리스트에 포함된 컨트롤에서 텍스트를 추출한다.
     *
     * @param controlList 컨트롤 리스트
     * @param tem         텍스트 추출 방법
     * @param sb          추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void controls(ArrayList<Control> controlList,
                                 TextExtractMethod tem, StringBuffer sb) throws UnsupportedEncodingException {
        if (controlList != null) {
            for (Control c : controlList) {
                ForControl.extract(c, tem, sb);
            }
        }
    }

}

package kr.dogfoot.hwplib.tool.textextractor;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharNormal;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.tool.textextractor.paraHead.ParaHeadMaker;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ForParagraph {
    public static final int ParaStart = -1;
    public static final int ParaEnd = 0xffff;

    /**
     * startIndex 순번 부터 끝 순번 까지의 문단의 텍스트를 추출한다.
     *
     * @param p             문단
     * @param startIndex    시작 순번
     * @param tem           텍스트 추출 방법
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(Paragraph p,
                               int startIndex,
                               TextExtractMethod tem,
                               ParaHeadMaker paraHeadMaker,
                               StringBuffer sb) throws UnsupportedEncodingException {
        extract(p,
                startIndex, ParaEnd,
                false,
                new TextExtractOption(tem),
                paraHeadMaker,
                sb);
    }

    /**
     * startIndex 순번 부터 끝 순번 까지의 문단의 텍스트를 추출한다.
     *
     * @param p             문단
     * @param startIndex    시작 순번
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(Paragraph p,
                               int startIndex,
                               TextExtractOption option,
                               ParaHeadMaker paraHeadMaker,
                               StringBuffer sb) throws UnsupportedEncodingException {
        extract(p,
                startIndex, ParaEnd,
                false,
                option,
                paraHeadMaker,
                sb);
    }

    /**
     * startIndex 순번 부터 endIndex 순번 까지의 문단의 텍스트를 추출한다.
     *
     * @param p             문단
     * @param startIndex    시작 순번
     * @param endIndex      끝 순번
     * @param tem           텍스트 추출 방법
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(Paragraph p,
                               int startIndex,
                               int endIndex,
                               TextExtractMethod tem,
                               ParaHeadMaker paraHeadMaker,
                               StringBuffer sb) throws UnsupportedEncodingException {
        extract(p,
                startIndex, endIndex,
                false,
                new TextExtractOption(tem),
                paraHeadMaker,
                sb);
    }

    /**
     * 문단의 텍스트를 추출한다.
     *
     * @param p             문단
     * @param tem           텍스트 추출 방법
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(Paragraph p,
                                 TextExtractMethod tem,
                                 ParaHeadMaker paraHeadMaker,
                                 StringBuffer sb) throws UnsupportedEncodingException {
        extract(p,
                ParaStart, ParaEnd,
                false,
                new TextExtractOption(tem),
                paraHeadMaker,
                sb);
    }

    /**
     * startIndex 순번 부터 endIndex 순번 까지의 문단의 텍스트를 추출한다.
     *
     * @param p             문단
     * @param startIndex    시작 순번
     * @param endIndex      끝 순번
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(Paragraph p,
                               int startIndex,
                               int endIndex,
                               boolean appendLF,
                               TextExtractOption option,
                               ParaHeadMaker paraHeadMaker,
                               StringBuffer sb) throws UnsupportedEncodingException {
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
                    case ControlChar:
                    case ControlInline:
                        if (startIndex <= charIndex && charIndex <= endIndex) {
                            if (option.isWithControlChar()) {
                                controlText(ch, sb);
                            }
                        }
                        break;
                    case ControlExtend:
                        if (startIndex <= charIndex && charIndex <= endIndex) {
                            if (option.getMethod() == TextExtractMethod.InsertControlTextBetweenParagraphText) {
                                sb.append("\n");
                                ForControl.extract(p.getControlList().get(controlIndex),
                                        option,
                                        paraHeadMaker,
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

            if (appendLF && option.isAppendEndingLF()) {
                sb.append("\n");
            }
        }

        if (option.getMethod() == TextExtractMethod.AppendControlTextAfterParagraphText) {
            controls(controlList, option, paraHeadMaker, sb);
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

    private static void controlText(HWPChar ch, StringBuffer sb) {
        switch (ch.getCode()) {
            case 9:
                sb.append("\t");
                break;
            case 10:
                sb.append("\r\n");
                break;
            case 24:
                sb.append("_");
                break;
        }
    }

    /**
     * 컨트롤 리스트에 포함된 컨트롤에서 텍스트를 추출한다.
     *
     * @param controlList   컨트롤 리스트
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void controls(ArrayList<Control> controlList,
                                 TextExtractOption option,
                                 ParaHeadMaker paraHeadMaker,
                                 StringBuffer sb) throws UnsupportedEncodingException {

        if (controlList != null) {
            for (Control c : controlList) {
                ForControl.extract(c, option, paraHeadMaker, sb);
            }
        }
    }
}


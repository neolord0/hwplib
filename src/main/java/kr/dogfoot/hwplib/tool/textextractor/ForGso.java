package kr.dogfoot.hwplib.tool.textextractor;

import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.tool.textextractor.paraHead.ParaHeadMaker;

import java.io.UnsupportedEncodingException;

/**
 * 그리기 개체을 위한 텍스트 추출기 객체
 *
 * @author neolord
 */
public class ForGso {
    /**
     * 그리기 개체에서 텍스트를 추출한다.
     *
     * @param gc            그리기 개체 컨트롤
     * @param tem           텍스트 추출 방법
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(GsoControl gc,
                               TextExtractMethod tem,
                               ParaHeadMaker paraHeadMaker,
                               StringBuilder sb) throws UnsupportedEncodingException {
        extract(gc, new TextExtractOption(tem), paraHeadMaker, sb);
    }

    /**
     * 그리기 개체에서 텍스트를 추출한다.
     *
     * @param gc            그리기 개체 컨트롤
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(GsoControl gc,
                               TextExtractOption option,
                               ParaHeadMaker paraHeadMaker,
                               StringBuilder sb) throws UnsupportedEncodingException {
        switch (gc.getGsoType()) {
            case Line:
                break;
            case Rectangle:
                rectangle((ControlRectangle) gc, option, paraHeadMaker, sb);
                break;
            case Ellipse:
                ellipse((ControlEllipse) gc, option, paraHeadMaker, sb);
                break;
            case Arc:
                arc((ControlArc) gc, option, paraHeadMaker, sb);
                break;
            case Polygon:
                polygon((ControlPolygon) gc, option, paraHeadMaker, sb);
                break;
            case Curve:
                curve((ControlCurve) gc, option, paraHeadMaker, sb);
                break;
            case Picture:
                break;
            case OLE:
                break;
            case Container:
                container((ControlContainer) gc, option, paraHeadMaker, sb);
                break;
            default:
                break;
        }
    }

    /**
     * 사각형 개체에서 텍스트를 추출한다.
     *
     * @param rectangle     사각형 개체
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void rectangle(ControlRectangle rectangle,
                                  TextExtractOption option,
                                  ParaHeadMaker paraHeadMaker,
                                  StringBuilder sb) throws UnsupportedEncodingException {
        textBox(rectangle.getTextBox(), option, paraHeadMaker, sb);
    }

    /**
     * 글상자 객체에서 텍스트를 추출한다.
     *
     * @param textBox       글상자 객체
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void textBox(TextBox textBox,
                                TextExtractOption option,
                                ParaHeadMaker paraHeadMaker,
                                StringBuilder sb) throws UnsupportedEncodingException {
        if (textBox == null) {
            return;
        }

        ForParagraphList.extract(textBox.getParagraphList(), option, paraHeadMaker, sb);
    }

    /**
     * 타원 개체에서 텍스트를 추출한다.
     *
     * @param ellipse       타원 개체
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void ellipse(ControlEllipse ellipse,
                                TextExtractOption option,
                                ParaHeadMaker paraHeadMaker,
                                StringBuilder sb) throws UnsupportedEncodingException {
        textBox(ellipse.getTextBox(), option, paraHeadMaker, sb);
    }

    /**
     * 호 개체에서 텍스트를 추출한다.
     *
     * @param arc           호 개체
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void arc(ControlArc arc,
                            TextExtractOption option,
                            ParaHeadMaker paraHeadMaker,
                            StringBuilder sb) throws UnsupportedEncodingException {
        textBox(arc.getTextBox(), option, paraHeadMaker, sb);
    }

    /**
     * 다각형 개체에서 텍스트를 추출한다.
     *
     * @param polygon       다각형 개체
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void polygon(ControlPolygon polygon,
                                TextExtractOption option,
                                ParaHeadMaker paraHeadMaker,
                                StringBuilder sb) throws UnsupportedEncodingException {
        textBox(polygon.getTextBox(), option, paraHeadMaker, sb);
    }

    /**
     * 곡선 개체에서 텍스트를 추출한다.
     *
     * @param curve         곡선 개체
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void curve(ControlCurve curve,
                              TextExtractOption option,
                              ParaHeadMaker paraHeadMaker,
                              StringBuilder sb) throws UnsupportedEncodingException {
        textBox(curve.getTextBox(), option, paraHeadMaker, sb);
    }

    /**
     * 묶음 개체에서 텍스트를 추출한다.
     *
     * @param container     묶음 개체
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void container(ControlContainer container,
                                  TextExtractOption option,
                                  ParaHeadMaker paraHeadMaker,
                                  StringBuilder sb) throws UnsupportedEncodingException {
        for (GsoControl child : container.getChildControlList()) {
            extract(child, option, paraHeadMaker, sb);
        }
    }
}

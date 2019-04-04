package kr.dogfoot.hwplib.tool.textextractor;

import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;

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
     * @param gc  그리기 개체 컨트롤
     * @param tem 텍스트 추출 방법
     * @param sb  추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(GsoControl gc, TextExtractMethod tem,
                               StringBuffer sb) throws UnsupportedEncodingException {
        switch (gc.getGsoType()) {
            case Line:
                break;
            case Rectangle:
                rectangle((ControlRectangle) gc, tem, sb);
                break;
            case Ellipse:
                ellipse((ControlEllipse) gc, tem, sb);
                break;
            case Arc:
                arc((ControlArc) gc, tem, sb);
                break;
            case Polygon:
                polygon((ControlPolygon) gc, tem, sb);
                break;
            case Curve:
                curve((ControlCurve) gc, tem, sb);
                break;
            case Picture:
                break;
            case OLE:
                break;
            case Container:
                container((ControlContainer) gc, tem, sb);
                break;
            default:
                break;
        }
    }

    /**
     * 사각형 개체에서 텍스트를 추출한다.
     *
     * @param rectangle 사각형 개체
     * @param tem       텍스트 추출 방법
     * @param sb        추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void rectangle(ControlRectangle rectangle,
                                  TextExtractMethod tem, StringBuffer sb) throws UnsupportedEncodingException {
        textBox(rectangle.getTextBox(), tem, sb);
    }

    /**
     * 글상자 객체에서 텍스트를 추출한다.
     *
     * @param textBox 글상자 객체
     * @param tem     텍스트 추출 방법
     * @param sb      추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void textBox(TextBox textBox, TextExtractMethod tem,
                                StringBuffer sb) throws UnsupportedEncodingException {
        if (textBox != null) {
            ForParagraphList.extract(textBox.getParagraphList(), tem, sb);
        }
    }

    /**
     * 타원 개체에서 텍스트를 추출한다.
     *
     * @param ellipse 타원 개체
     * @param tem     텍스트 추출 방법
     * @param sb      추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void ellipse(ControlEllipse ellipse, TextExtractMethod tem,
                                StringBuffer sb) throws UnsupportedEncodingException {
        textBox(ellipse.getTextBox(), tem, sb);
    }

    /**
     * 호 개체에서 텍스트를 추출한다.
     *
     * @param arc 호 개체
     * @param tem 텍스트 추출 방법
     * @param sb  추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void arc(ControlArc arc, TextExtractMethod tem,
                            StringBuffer sb) throws UnsupportedEncodingException {
        textBox(arc.getTextBox(), tem, sb);
    }

    /**
     * 다각형 개체에서 텍스트를 추출한다.
     *
     * @param polygon 다각형 개체
     * @param tem     텍스트 추출 방법
     * @param sb      추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void polygon(ControlPolygon polygon, TextExtractMethod tem,
                                StringBuffer sb) throws UnsupportedEncodingException {
        textBox(polygon.getTextBox(), tem, sb);
    }

    /**
     * 곡선 개체에서 텍스트를 추출한다.
     *
     * @param curve 곡선 개체
     * @param tem   텍스트 추출 방법
     * @param sb    추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void curve(ControlCurve curve, TextExtractMethod tem,
                              StringBuffer sb) throws UnsupportedEncodingException {
        textBox(curve.getTextBox(), tem, sb);
    }

    /**
     * 묶음 개체에서 텍스트를 추출한다.
     *
     * @param container 묶음 개체
     * @param tem       텍스트 추출 방법
     * @param sb        추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void container(ControlContainer container,
                                  TextExtractMethod tem, StringBuffer sb) throws UnsupportedEncodingException {
        for (GsoControl child : container.getChildControlList()) {
            extract(child, tem, sb);
        }
    }
}

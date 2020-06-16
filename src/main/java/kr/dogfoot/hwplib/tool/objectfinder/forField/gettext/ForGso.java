package kr.dogfoot.hwplib.tool.objectfinder.forField.gettext;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.tool.objectfinder.forField.ForParagraphList;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;

import java.io.UnsupportedEncodingException;

/**
 * 그리기 개체에서 필드 객체를 찾는 기능을 포함하는 클래스
 *
 * @author neolord
 */
public class ForGso {
    /**
     * 그리기 개체에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param gc         그리기 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    public static String getFieldText(GsoControl gc, ControlType fieldType,
                                      String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        switch (gc.getGsoType()) {
            case Line:
                break;
            case Rectangle:
                return rectangle((ControlRectangle) gc, fieldType, fieldName,
                        temInField);
            case Ellipse:
                return ellipse((ControlEllipse) gc, fieldType, fieldName,
                        temInField);
            case Arc:
                return arc((ControlArc) gc, fieldType, fieldName, temInField);
            case Polygon:
                return polygon((ControlPolygon) gc, fieldType, fieldName,
                        temInField);
            case Curve:
                return curve((ControlCurve) gc, fieldType, fieldName, temInField);
            case Picture:
                break;
            case OLE:
                break;
            case Container:
                return container((ControlContainer) gc, fieldType, fieldName,
                        temInField);
            default:
                break;
        }
        return null;
    }

    /**
     * 사각형 개체에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param rectangle  사각형 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String rectangle(ControlRectangle rectangle,
                                    ControlType fieldType, String fieldName,
                                    TextExtractMethod temInField) throws UnsupportedEncodingException {
        return textBox(rectangle.getTextBox(), fieldType, fieldName, temInField);
    }

    /**
     * 글상자 객체에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param textBox    글상자 객체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String textBox(TextBox textBox, ControlType fieldType,
                                  String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        if (textBox == null) {
            return null;
        }
        return ForParagraphList.getFieldText(textBox.getParagraphList(), fieldType, fieldName, temInField);
    }

    /**
     * 타원 개체에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param ellipse    타원 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String ellipse(ControlEllipse ellipse,
                                  ControlType fieldType, String fieldName,
                                  TextExtractMethod temInField) throws UnsupportedEncodingException {
        return textBox(ellipse.getTextBox(), fieldType, fieldName, temInField);
    }

    /**
     * 호 개체에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param arc        호 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String arc(ControlArc arc, ControlType fieldType,
                              String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        return textBox(arc.getTextBox(), fieldType, fieldName, temInField);
    }

    /**
     * 다각형 개체에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param polygon    다각형 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String polygon(ControlPolygon polygon,
                                  ControlType fieldType, String fieldName,
                                  TextExtractMethod temInField) throws UnsupportedEncodingException {
        return textBox(polygon.getTextBox(), fieldType, fieldName, temInField);
    }

    /**
     * 곡선 개체에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param curve      곡선 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String curve(ControlCurve curve, ControlType fieldType,
                                String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        return textBox(curve.getTextBox(), fieldType, fieldName, temInField);
    }

    /**
     * 묶음 개체에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param container  컨테이터 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String container(ControlContainer container,
                                    ControlType fieldType, String fieldName,
                                    TextExtractMethod temInField) throws UnsupportedEncodingException {
        for (GsoControl child : container.getChildControlList()) {
            String text = getFieldText(child, fieldType, fieldName, temInField);
            if (text != null) {
                return text;
            }
        }
        return null;
    }
}

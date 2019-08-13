package kr.dogfoot.hwplib.tool.objectfinder.forField.gettext;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.tool.objectfinder.forField.ForParagraphList;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 그리기 개체에서 이름이 같은 모든 필드 객체를 찾는 기능을 포함하는 클래스
 *
 * @author neolord
 */
public class ForGsoWithAllField {
    /**
     * 그리기 개체에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param gc         그리기 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    public static void getFieldText(GsoControl gc, ControlType fieldType,
                                    String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        switch (gc.getGsoType()) {
            case Line:
                break;
            case Rectangle:
                rectangle((ControlRectangle) gc, fieldType, fieldName,
                        temInField, textList);
                break;
            case Ellipse:
                ellipse((ControlEllipse) gc, fieldType, fieldName,
                        temInField, textList);
                break;
            case Arc:
                arc((ControlArc) gc, fieldType, fieldName, temInField, textList);
                break;
            case Polygon:
                polygon((ControlPolygon) gc, fieldType, fieldName,
                        temInField, textList);
            case Curve:
                curve((ControlCurve) gc, fieldType, fieldName, temInField, textList);
                break;
            case Picture:
                break;
            case OLE:
                break;
            case Container:
                container((ControlContainer) gc, fieldType, fieldName,
                        temInField, textList);
                break;
            default:
                break;
        }
    }

    /**
     * 사각형 개체에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param rectangle  사각형 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void rectangle(ControlRectangle rectangle,
                                  ControlType fieldType, String fieldName,
                                  TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        textBox(rectangle.getTextBox(), fieldType, fieldName, temInField, textList);
    }

    /**
     * 글상자 객체에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param textBox    글상자 객체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void textBox(TextBox textBox, ControlType fieldType,
                                String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        ForParagraphList.getAllFieldText(textBox.getParagraphList(), fieldType, fieldName, temInField, textList);
    }

    /**
     * 타원 개체에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param ellipse    타원 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void ellipse(ControlEllipse ellipse,
                                ControlType fieldType, String fieldName,
                                TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        textBox(ellipse.getTextBox(), fieldType, fieldName, temInField, textList);
    }

    /**
     * 호 개체에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param arc        호 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void arc(ControlArc arc, ControlType fieldType,
                            String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        textBox(arc.getTextBox(), fieldType, fieldName, temInField, textList);
    }

    /**
     * 다각형 개체에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param polygon    다각형 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void polygon(ControlPolygon polygon,
                                ControlType fieldType, String fieldName,
                                TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        textBox(polygon.getTextBox(), fieldType, fieldName, temInField, textList);
    }

    /**
     * 곡선 개체에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param curve      곡선 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void curve(ControlCurve curve, ControlType fieldType,
                              String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        textBox(curve.getTextBox(), fieldType, fieldName, temInField, textList);
    }

    /**
     * 묶음 개체에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param container  컨테이터 개체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void container(ControlContainer container,
                                  ControlType fieldType, String fieldName,
                                  TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        for (GsoControl child : container.getChildControlList()) {
            getFieldText(child, fieldType, fieldName, temInField, textList);
        }
    }
}

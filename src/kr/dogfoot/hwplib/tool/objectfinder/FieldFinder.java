package kr.dogfoot.hwplib.tool.objectfinder;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.tool.objectfinder.forField.ForParagraphList;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 필드 객체를 찾는 기능을 포함하는 클래스
 *
 * @author neolord
 */
public class FieldFinder {
    /**
     * 누름틀 컨트롤(ClickHere 필드)을 찾아 텍스트를 반환한다.
     *
     * @param hwpFile    한글 파일 객체
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    public static String getClickHereText(HWPFile hwpFile, String fieldName, TextExtractMethod temInField)
            throws UnsupportedEncodingException {
        String strText = null;
        for (Section s : hwpFile.getBodyText().getSectionList()) {
            strText = ForParagraphList.getFieldText(s, ControlType.FIELD_CLICKHERE, fieldName, temInField);
            if (strText != null) {
                break;
            }
        }
        return strText;
    }

    /**
     * 파일 안에 이름이 같은 모든 누름틀 컨트롤(ClickHere 필드)을 찾아 텍스트를 리스트에 추가한다.
     *
     * @param hwpFile    한글 파일 객체
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 택스트의 텍스트 추출 방법
     * @return 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    public static ArrayList<String> getAllClickHereText(HWPFile hwpFile, String fieldName, TextExtractMethod temInField)
            throws UnsupportedEncodingException {
        ArrayList<String> textList = new ArrayList<String>();
        for (Section s : hwpFile.getBodyText().getSectionList()) {
            ForParagraphList.getAllFieldText(s, ControlType.FIELD_CLICKHERE, fieldName, temInField, textList);
        }

        return textList;
    }

    /**
     * 누름틀 컨트롤(ClickHere 필드)를 찾아 텍스트를 설정한다.
     *
     * @param hwpFile   한글 파일 객체
     * @param fieldName 필드 이름
     * @param textList  택스트 리스트
     * @return 필드 설정 결과값
     * @throws Exception
     */
    public static SetFieldResult setClickHereText(HWPFile hwpFile, String fieldName, ArrayList<String> textList) {
        if (textList.size() == 0) {
            return SetFieldResult.ETCError;
        }
        TextBuffer textBuffer = new TextBuffer(textList);
        for (Section s : hwpFile.getBodyText().getSectionList()) {
            if (ForParagraphList.setFieldText(s, ControlType.FIELD_CLICKHERE, fieldName,
                    textBuffer) == SetFieldResult.NotEnoughText) {
                return SetFieldResult.NotEnoughText;
            }
        }
        if (textBuffer.usedAll()) {
            return SetFieldResult.SetAllText;
        } else if (textBuffer.notUsed()) {
            return SetFieldResult.NotFound;
        }
        return SetFieldResult.TextRemains;
    }

    /**
     * 필드 컨트롤을 찾아 텍스트를 반환한다.
     *
     * @param hwpFile    한글 파일 객체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 택스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    public static String getFieldText(HWPFile hwpFile, ControlType fieldType, String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        String strText = null;
        for (Section s : hwpFile.getBodyText().getSectionList()) {
            strText = ForParagraphList.getFieldText(s, fieldType, fieldName, temInField);
            if (strText != null) {
                break;
            }
        }
        return strText;
    }

    /**
     * 파일 안에 이름이 같은 모든 필드를 찾아 텍스트를 리스트에 추가한다.
     *
     * @param hwpFile    한글 파일 객체
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 택스트의 텍스트 추출 방법
     * @return 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    public static ArrayList<String> getAllFieldText(HWPFile hwpFile, ControlType fieldType, String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        ArrayList<String> textList = new ArrayList<String>();
        for (Section s : hwpFile.getBodyText().getSectionList()) {
            ForParagraphList.getAllFieldText(s, fieldType, fieldName, temInField, textList);
        }
        return textList;
    }

    /**
     * 필드를 찾아 텍스트를 설정한다.
     *
     * @param hwpFile   한글 파일 객체
     * @param fieldType 필드 타입
     * @param fieldName 필드 이름
     * @param textList  택스트 리스트
     * @return 필드 설정 결과값
     */
    public static SetFieldResult setFieldText(HWPFile hwpFile, ControlType fieldType, String fieldName,
                                              ArrayList<String> textList) {
        if (fieldType.isField() == false || textList.size() == 0) {
            return SetFieldResult.ETCError;
        }

        TextBuffer textBuffer = new TextBuffer(textList);
        for (Section s : hwpFile.getBodyText().getSectionList()) {
            if (ForParagraphList.setFieldText(s, fieldType, fieldName, textBuffer) == SetFieldResult.NotEnoughText) {
                return SetFieldResult.NotEnoughText;
            }
        }
        if (textBuffer.usedAll()) {
            return SetFieldResult.SetAllText;
        } else if (textBuffer.notUsed()) {
            return SetFieldResult.NotFound;
        }
        return SetFieldResult.TextRemains;
    }
}

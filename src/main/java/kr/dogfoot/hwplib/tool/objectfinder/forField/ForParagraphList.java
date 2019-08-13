package kr.dogfoot.hwplib.tool.objectfinder.forField;

import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.tool.objectfinder.SetFieldResult;
import kr.dogfoot.hwplib.tool.objectfinder.TextBuffer;
import kr.dogfoot.hwplib.tool.objectfinder.forField.gettext.ForControl;
import kr.dogfoot.hwplib.tool.objectfinder.forField.gettext.ForControlWithAllField;
import kr.dogfoot.hwplib.tool.paragraphadder.ParaTextSetter;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 문단리스트, 문단에서 필드 객체를 찾는 기능을 포함하는 클래스
 *
 * @author neolord
 */
public class ForParagraphList {
    /**
     * 문단리스트에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param paragraphList 문단리스트
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param temInField    필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    public static String getFieldText(ParagraphListInterface paragraphList, ControlType fieldType, String fieldName,
                                      TextExtractMethod temInField) throws UnsupportedEncodingException {
        if (paragraphList == null) {
            return null;
        }
        ControlField cf = null;
        StringBuffer sb = new StringBuffer();
        int startFieldIndex = -1;
        int endFieldIndex = -1;
        for (Paragraph p : paragraphList) {
            if (cf == null) {
                cf = findField(p, fieldType, fieldName);
                if (cf != null) {
                    int indexOfControl = p.getControlIndex(cf);
                    startFieldIndex = p.getText().getCharIndexFromExtendCharIndex(indexOfControl);
                    endFieldIndex = p.getText().getInlineCharIndex(startFieldIndex + 1, (short) 0x04);
                    if (endFieldIndex != -1) {
                        getParaText(p, startFieldIndex + 1, endFieldIndex - 1, temInField, sb);
                        return sb.toString();
                    } else {
                        getParaText(p, startFieldIndex + 1, temInField, sb);
                    }
                }
            } else {
                sb.append("\n");
                if (p.getText() != null) {
                    endFieldIndex = p.getText().getInlineCharIndex(0, (short) 0x04);
                    if (endFieldIndex != -1) {
                        getParaText(p, 0, endFieldIndex - 1, temInField, sb);
                    } else {
                        getParaText(p, 0, temInField, sb);
                    }
                }
            }
            if (endFieldIndex != -1) {
                break;
            }
        }
        if (cf == null) {
            return getFieldTextForControl(paragraphList, fieldType, fieldName, temInField);
        }
        return sb.toString();
    }

    /**
     * 문단리스트에서 이름이 같은 모든 필드 객체의 텍스트를 찾아 텍스트를 리스트에 추가한다.
     *
     * @param paragraphList 문단리스트
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param temInField    필드 안에 텍스트의 텍스트 추출 방법
     * @param textList      반환할 필드 텍스트 리스트
     */
    public static void getAllFieldText(ParagraphListInterface paragraphList, ControlType fieldType, String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        if (paragraphList == null) {
            return;
        }
        ControlField startField = null;
        StringBuffer sb = new StringBuffer();
        int startFieldIndex = -1;
        int endFieldIndex = -1;
        for (Paragraph p : paragraphList) {
            if (startField == null) {
                startField = findField(p, fieldType, fieldName);
                if (startField != null) {
                    int indexOfControl = p.getControlIndex(startField);
                    startFieldIndex = p.getText().getCharIndexFromExtendCharIndex(indexOfControl);
                    endFieldIndex = p.getText().getInlineCharIndex(startFieldIndex + 1, (short) 0x04);
                    if (endFieldIndex != -1) {
                        getParaText(p, startFieldIndex + 1, endFieldIndex - 1, temInField, sb);

                        textList.add(sb.toString());
                        sb.setLength(0);
                        startField = null;
                    } else {
                        getParaText(p, startFieldIndex + 1, temInField, sb);
                    }
                }
            } else {
                sb.append("\n");
                if (p.getText() != null) {
                    endFieldIndex = p.getText().getInlineCharIndex(0, (short) 0x04);
                    if (endFieldIndex != -1) {
                        getParaText(p, 0, endFieldIndex - 1, temInField, sb);

                        textList.add(sb.toString());
                        sb.setLength(0);
                        startField = null;
                    } else {
                        getParaText(p, 0, temInField, sb);
                    }
                }
            }
        }
        getAllFieldTextForControl(paragraphList, fieldType, fieldName, temInField, textList);
    }

    /**
     * 문단에 포함된 필드 컨트롤을 찾는다.
     *
     * @param p         문단
     * @param fieldType 필드 타입
     * @param fieldName 필드 이름
     * @return 필드 컨트롤
     */
    private static ControlField findField(Paragraph p, ControlType fieldType, String fieldName) {
        if (p.getControlList() == null) {
            return null;
        }
        for (Control c : p.getControlList()) {
            if (c.getType() == fieldType) {
                ControlField cf = (ControlField) c;
                if (cf.getName() != null && cf.getName().equals(fieldName)) {
                    return cf;
                }
            }
        }
        return null;
    }

    /**
     * 문단 리스트에 포함된 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param paragraphList 문단 리스트
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param temInField    필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String getFieldTextForControl(ParagraphListInterface paragraphList, ControlType fieldType,
                                                 String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        for (Paragraph p : paragraphList) {
            ArrayList<Control> controlList = p.getControlList();
            if (controlList != null) {
                for (Control c : controlList) {
                    String text = ForControl.getFieldText(c, fieldType, fieldName, temInField);
                    if (text != null) {
                        return text;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 문단 리스트에 포함된 컨트롤에서 이름이 같은 모든 필드 객체의 텍스트를 찾아 텍스트를 리스트에 추가한다.
     *
     * @param paragraphList 문단 리스트
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param temInField    필드 안에 텍스트의 텍스트 추출 방법
     * @param textList      반환할 필드 텍스트 리스트
     */
    private static void getAllFieldTextForControl(ParagraphListInterface paragraphList, ControlType fieldType, String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        for (Paragraph p : paragraphList) {
            ArrayList<Control> controlList = p.getControlList();
            if (controlList != null) {
                for (Control c : controlList) {
                    ForControlWithAllField.getFieldText(c, fieldType, fieldName, temInField, textList);
                }
            }
        }
    }

    /**
     * startIndex 순번 부터 endIndex 순번 까지의 문단의 텍스트를 반환한다.
     *
     * @param p          문단
     * @param startIndex 시작 순번
     * @param endIndex   끝 순번
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param sb         필드 텍스트가 저장될 StringBuffer
     * @throws UnsupportedEncodingException
     */
    private static void getParaText(Paragraph p, int startIndex, int endIndex, TextExtractMethod temInField,
                                    StringBuffer sb) throws UnsupportedEncodingException {
        kr.dogfoot.hwplib.tool.textextractor.ForParagraphList.extract(p, startIndex, endIndex, temInField, sb);
    }

    /**
     * startIndex 순번 부터 끝 까지의 문단의 텍스트를 반환한다.
     *
     * @param p          문단
     * @param startIndex 시작 순번
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param sb         필드 텍스트가 저장될 StringBuffer
     * @throws UnsupportedEncodingException
     */
    private static void getParaText(Paragraph p, int startIndex, TextExtractMethod temInField, StringBuffer sb)
            throws UnsupportedEncodingException {
        kr.dogfoot.hwplib.tool.textextractor.ForParagraphList.extract(p, startIndex, temInField, sb);
    }

    /**
     * 문단리스트에 포함된 필드 객체의 텍스트를 설정한다.
     *
     * @param paragraphList 문단 리스트
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param textBuffer    텍스트
     * @return 필드 설정 결과값
     */
    public static SetFieldResult setFieldText(ParagraphListInterface paragraphList, ControlType fieldType,
                                              String fieldName, TextBuffer textBuffer) {
        if (paragraphList == null) {
            return SetFieldResult.InProcess;
        }
        ControlField cf = null;
        int startFieldIndex = -1;
        int endFieldIndex = -1;
        for (Paragraph p : paragraphList) {
            cf = findField(p, fieldType, fieldName);
            if (cf != null) {
                int indexOfControl = p.getControlIndex(cf);
                startFieldIndex = p.getText().getCharIndexFromExtendCharIndex(indexOfControl);
                endFieldIndex = p.getText().getInlineCharIndex(startFieldIndex + 1, (short) 0x04);
                if (endFieldIndex != -1) {
                    if (textBuffer.hasNext() == true) {
                        ParaTextSetter.changeText(p, startFieldIndex + 1, endFieldIndex - 1, textBuffer.nextText());
                    } else {
                        return SetFieldResult.NotEnoughText;
                    }
                }
            }

            if (setFieldTextForControls(p, fieldType, fieldName, textBuffer) == SetFieldResult.NotEnoughText) {
                return SetFieldResult.NotEnoughText;
            }
        }
        return SetFieldResult.InProcess;
    }

    /**
     * 문단에 포함된 컨트롤에서 필드 객체의 텍스트를 설정한다.
     *
     * @param p          문단
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param textBuffer 텍스트 버퍼
     * @return 필드 설정 결과값
     */
    private static SetFieldResult setFieldTextForControls(Paragraph p, ControlType fieldType, String fieldName,
                                                          TextBuffer textBuffer) {
        ArrayList<Control> controlList = p.getControlList();
        if (controlList != null) {
            for (Control c : controlList) {
                if (kr.dogfoot.hwplib.tool.objectfinder.forField.settext.ForControl.setFieldText(c, fieldType,
                        fieldName, textBuffer) == SetFieldResult.NotEnoughText) {
                    return SetFieldResult.NotEnoughText;
                }
            }
        }
        return SetFieldResult.InProcess;
    }
}

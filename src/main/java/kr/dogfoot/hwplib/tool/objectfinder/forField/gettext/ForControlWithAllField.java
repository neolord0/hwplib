package kr.dogfoot.hwplib.tool.objectfinder.forField.gettext;

import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.tool.objectfinder.forField.ForParagraphList;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 컨트롤에서 이름이 같은 모든 필드 객체를 찾는 기능을 포함하는 클래스
 *
 * @author neolord
 */
public class ForControlWithAllField {
    /**
     * 컨트롤 속에 있는 이름이 같은 모든 필드를 찾아 텍스트를 리스트에 추가한다.
     *
     * @param c          컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     */
    public static void getFieldText(Control c, ControlType fieldType, String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        if (c.isField()) {
        } else {
            switch (c.getType()) {
                case Table:
                    table((ControlTable) c, fieldType, fieldName, temInField, textList);
                    break;
                case Gso:
                    ForGsoWithAllField.getFieldText((GsoControl) c, fieldType,
                            fieldName, temInField, textList);
                    break;
                case Equation:
                    break;
                case SectionDefine:
                    break;
                case ColumnDefine:
                    break;
                case Header:
                    header((ControlHeader) c, fieldType, fieldName,
                            temInField, textList);
                    break;
                case Footer:
                    footer((ControlFooter) c, fieldType, fieldName,
                            temInField, textList);
                    break;
                case Footnote:
                    footnote((ControlFootnote) c, fieldType, fieldName,
                            temInField, textList);
                    break;
                case Endnote:
                    endnote((ControlEndnote) c, fieldType, fieldName,
                            temInField, textList);
                case AutoNumber:
                    break;
                case NewNumber:
                    break;
                case PageHide:
                    break;
                case PageOddEvenAdjust:
                    break;
                case PageNumberPositon:
                    break;
                case IndexMark:
                    break;
                case Bookmark:
                    break;
                case OverlappingLetter:
                    break;
                case AdditionalText:
                    break;
                case HiddenComment:
                    hiddenComment((ControlHiddenComment) c, fieldType,
                            fieldName, temInField, textList);
                    break;
                default:
                    break;
            }
        }
    }


    /**
     * 표 컨트롤에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param table      표 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void table(ControlTable table, ControlType fieldType,
                              String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        for (Row r : table.getRowList()) {
            for (Cell c : r.getCellList()) {
                ForParagraphList.getAllFieldText(
                        c.getParagraphList(), fieldType, fieldName, temInField, textList);
            }
        }
    }

    /**
     * 머리말 컨트롤에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param header     머리말 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void header(ControlHeader header, ControlType fieldType,
                               String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        ForParagraphList.getAllFieldText(header.getParagraphList(),
                fieldType, fieldName, temInField, textList);
    }


    /**
     * 꼬리말 컨트롤에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param footer     꼬리말 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void footer(ControlFooter footer, ControlType fieldType,
                               String fieldName, TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        ForParagraphList.getAllFieldText(footer.getParagraphList(),
                fieldType, fieldName, temInField, textList);
    }

    /**
     * 각주 컨트롤에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param footnote   각주 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void footnote(ControlFootnote footnote,
                                 ControlType fieldType, String fieldName,
                                 TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        ForParagraphList.getAllFieldText(footnote.getParagraphList(),
                fieldType, fieldName, temInField, textList);
    }

    /**
     * 미주 컨트롤에서 필드 객체의 텍스트를 찾아 리스트에 추가한다.
     *
     * @param endnote    미주 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @param textList   반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void endnote(ControlEndnote endnote,
                                ControlType fieldType, String fieldName,
                                TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        ForParagraphList.getAllFieldText(endnote.getParagraphList(),
                fieldType, fieldName, temInField, textList);
    }

    /**
     * 숨은 설명 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param hiddenComment 숨은 설명 컨트롤 숨
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param temInField    필드 안에 텍스트의 텍스트 추출 방법
     * @param textList      반환할 필드 텍스트 리스트
     * @throws UnsupportedEncodingException
     */
    private static void hiddenComment(ControlHiddenComment hiddenComment,
                                      ControlType fieldType, String fieldName,
                                      TextExtractMethod temInField, ArrayList<String> textList) throws UnsupportedEncodingException {
        ForParagraphList.getAllFieldText(hiddenComment.getParagraphList(),
                fieldType, fieldName, temInField, textList);
    }
}

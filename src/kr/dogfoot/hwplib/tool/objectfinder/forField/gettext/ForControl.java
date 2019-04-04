package kr.dogfoot.hwplib.tool.objectfinder.forField.gettext;

import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.tool.objectfinder.forField.ForParagraphList;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;

import java.io.UnsupportedEncodingException;

/**
 * 컨트롤에서 필드 객체를 찾는 기능을 포함하는 클래스
 *
 * @author neolord
 */
public class ForControl {
    /**
     * 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param c          컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    public static String getFieldText(Control c, ControlType fieldType,
                                      String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        if (c.isField()) {
        } else {
            switch (c.getType()) {
                case Table:
                    return table((ControlTable) c, fieldType, fieldName, temInField);
                case Gso:
                    return ForGso.getFieldText((GsoControl) c, fieldType,
                            fieldName, temInField);
                case Equation:
                    break;
                case SectionDefine:
                    break;
                case ColumnDefine:
                    break;
                case Header:
                    return header((ControlHeader) c, fieldType, fieldName,
                            temInField);
                case Footer:
                    return footer((ControlFooter) c, fieldType, fieldName,
                            temInField);
                case Footnote:
                    return footnote((ControlFootnote) c, fieldType, fieldName,
                            temInField);
                case Endnote:
                    return endnote((ControlEndnote) c, fieldType, fieldName,
                            temInField);
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
                    return hiddenComment((ControlHiddenComment) c, fieldType,
                            fieldName, temInField);
                default:
                    break;
            }
        }
        return null;
    }

    /**
     * 표 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param table      표 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String table(ControlTable table, ControlType fieldType,
                                String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        for (Row r : table.getRowList()) {
            for (Cell c : r.getCellList()) {
                String text = ForParagraphList.getFieldText(
                        c.getParagraphList(), fieldType, fieldName, temInField);
                if (text != null) {
                    return text;
                }
            }
        }
        return null;
    }

    /**
     * 머리말 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param header     머리말 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String header(ControlHeader header, ControlType fieldType,
                                 String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        return ForParagraphList.getFieldText(header.getParagraphList(),
                fieldType, fieldName, temInField);
    }

    /**
     * 꼬리말 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param footer     꼬리말 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String footer(ControlFooter footer, ControlType fieldType,
                                 String fieldName, TextExtractMethod temInField) throws UnsupportedEncodingException {
        return ForParagraphList.getFieldText(footer.getParagraphList(),
                fieldType, fieldName, temInField);
    }

    /**
     * 각주 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param footnote   각주 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String footnote(ControlFootnote footnote,
                                   ControlType fieldType, String fieldName,
                                   TextExtractMethod temInField) throws UnsupportedEncodingException {
        return ForParagraphList.getFieldText(footnote.getParagraphList(),
                fieldType, fieldName, temInField);
    }

    /**
     * 미주 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param endnote    미주 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param temInField 필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String endnote(ControlEndnote endnote,
                                  ControlType fieldType, String fieldName,
                                  TextExtractMethod temInField) throws UnsupportedEncodingException {
        return ForParagraphList.getFieldText(endnote.getParagraphList(),
                fieldType, fieldName, temInField);
    }

    /**
     * 숭은 설명 컨트롤에서 필드 객체의 텍스트를 찾아 반환한다.
     *
     * @param hiddenComment 숨은 설명 컨트롤 숨
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param temInField    필드 안에 텍스트의 텍스트 추출 방법
     * @return 필드 텍스트
     * @throws UnsupportedEncodingException
     */
    private static String hiddenComment(ControlHiddenComment hiddenComment,
                                        ControlType fieldType, String fieldName,
                                        TextExtractMethod temInField) throws UnsupportedEncodingException {
        return ForParagraphList.getFieldText(hiddenComment.getParagraphList(),
                fieldType, fieldName, temInField);
    }
}

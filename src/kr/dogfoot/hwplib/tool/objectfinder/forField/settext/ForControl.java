package kr.dogfoot.hwplib.tool.objectfinder.forField.settext;

import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.tool.objectfinder.SetFieldResult;
import kr.dogfoot.hwplib.tool.objectfinder.TextBuffer;
import kr.dogfoot.hwplib.tool.objectfinder.forField.ForParagraphList;

/**
 * 컨트롤에 포함된 필드의 텍스트를 설정하는 기능을 포함한 클래스
 *
 * @author 박성균
 */
public class ForControl {
    /**
     * 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
     *
     * @param c          컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param textBuffer 텍스트 버퍼
     * @return 필드 설정 결과값
     */
    public static SetFieldResult setFieldText(Control c, ControlType fieldType, String fieldName,
                                              TextBuffer textBuffer) {
        if (c.isField()) {
        } else {
            switch (c.getType()) {
                case Table:
                    return table((ControlTable) c, fieldType, fieldName, textBuffer);
                case Gso:
                    return ForGso.setFieldText((GsoControl) c, fieldType, fieldName, textBuffer);
                case Equation:
                    break;
                case SectionDefine:
                    break;
                case ColumnDefine:
                    break;
                case Header:
                    return header((ControlHeader) c, fieldType, fieldName, textBuffer);
                case Footer:
                    return footer((ControlFooter) c, fieldType, fieldName, textBuffer);
                case Footnote:
                    return footnote((ControlFootnote) c, fieldType, fieldName, textBuffer);
                case Endnote:
                    return endnote((ControlEndnote) c, fieldType, fieldName, textBuffer);
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
                    return hiddenComment((ControlHiddenComment) c, fieldType, fieldName, textBuffer);
                default:
                    break;
            }
        }
        return SetFieldResult.InProcess;
    }

    /**
     * 표 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
     *
     * @param table      표 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param textBuffer 텍스트 버퍼
     * @return 필드 설정 결과값
     */
    private static SetFieldResult table(ControlTable table, ControlType fieldType, String fieldName,
                                        TextBuffer textBuffer) {
        for (Row r : table.getRowList()) {
            for (Cell c : r.getCellList()) {
                if (ForParagraphList.setFieldText(c.getParagraphList(), fieldType, fieldName,
                        textBuffer) == SetFieldResult.NotEnoughText) {
                    return SetFieldResult.NotEnoughText;
                }
            }
        }
        return SetFieldResult.InProcess;
    }

    /**
     * 머리말 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
     *
     * @param header     머리말 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param textBuffer 텍스트 버퍼
     * @return 필드 설정 결과값
     */
    private static SetFieldResult header(ControlHeader header, ControlType fieldType, String fieldName,
                                         TextBuffer textBuffer) {
        return ForParagraphList.setFieldText(header.getParagraphList(), fieldType, fieldName, textBuffer);
    }

    /**
     * 꼬리말 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
     *
     * @param footer     꼬리말 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param textBuffer 텍스트 버퍼
     * @return 필드 설정 결과값
     */
    private static SetFieldResult footer(ControlFooter footer, ControlType fieldType, String fieldName,
                                         TextBuffer textBuffer) {
        return ForParagraphList.setFieldText(footer.getParagraphList(), fieldType, fieldName, textBuffer);
    }

    /**
     * 각주 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
     *
     * @param footnote   각주 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param textBuffer 텍스트 버퍼
     * @return 필드 설정 결과값
     */
    private static SetFieldResult footnote(ControlFootnote footnote, ControlType fieldType, String fieldName,
                                           TextBuffer textBuffer) {
        return ForParagraphList.setFieldText(footnote.getParagraphList(), fieldType, fieldName, textBuffer);
    }

    /**
     * 미주 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
     *
     * @param endnote    미주 컨트롤
     * @param fieldType  필드 타입
     * @param fieldName  필드 이름
     * @param textBuffer 텍스트 버퍼
     * @return 필드 설정 결과값
     */
    private static SetFieldResult endnote(ControlEndnote endnote, ControlType fieldType, String fieldName,
                                          TextBuffer textBuffer) {
        return ForParagraphList.setFieldText(endnote.getParagraphList(), fieldType, fieldName, textBuffer);
    }

    /**
     * 숨은 설명 컨트롤에 포함된 필드의 텍스트를 찾아 설정한다.
     *
     * @param hiddenComment 숨은 설명 컨트롤
     * @param fieldType     필드 타입
     * @param fieldName     필드 이름
     * @param textBuffer    텍스트 버퍼
     * @return 필드 설정 결과값
     */
    private static SetFieldResult hiddenComment(ControlHiddenComment hiddenComment, ControlType fieldType,
                                                String fieldName, TextBuffer textBuffer) {
        return ForParagraphList.setFieldText(hiddenComment.getParagraphList(), fieldType, fieldName, textBuffer);
    }
}

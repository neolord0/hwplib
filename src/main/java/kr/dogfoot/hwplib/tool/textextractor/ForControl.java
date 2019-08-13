package kr.dogfoot.hwplib.tool.textextractor;

import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;

import java.io.UnsupportedEncodingException;

/**
 * 컨트롤을 위한 텍스트 추출기 객체
 *
 * @author neolord
 */
public class ForControl {
    /**
     * 컨트롤에서 텍스트를 추출한다.
     *
     * @param c   컨트롤
     * @param tem 텍스트 추출 방법
     * @param sb  추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(Control c, TextExtractMethod tem, StringBuffer sb) throws UnsupportedEncodingException {
        if (c.isField()) {
        } else {
            switch (c.getType()) {
                case Table:
                    table((ControlTable) c, tem, sb);
                    break;
                case Gso:
                    ForGso.extract((GsoControl) c, tem, sb);
                    break;
                case Equation:
                    equation((ControlEquation) c, sb);
                    break;
                case SectionDefine:
                    break;
                case ColumnDefine:
                    break;
                case Header:
                    header((ControlHeader) c, tem, sb);
                    break;
                case Footer:
                    footer((ControlFooter) c, tem, sb);
                    break;
                case Footnote:
                    footnote((ControlFootnote) c, tem, sb);
                    break;
                case Endnote:
                    endnote((ControlEndnote) c, tem, sb);
                    break;
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
                    additionalText((ControlAdditionalText) c, sb);
                    break;
                case HiddenComment:
                    hiddenComment((ControlHiddenComment) c, tem, sb);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 표 컨트롤에서 텍스트를 추출한다
     *
     * @param table 표 컨트롤
     * @param tem   텍스트 추출 방법
     * @param sb    추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void table(ControlTable table, TextExtractMethod tem,
                              StringBuffer sb) throws UnsupportedEncodingException {
        for (Row r : table.getRowList()) {
            for (Cell c : r.getCellList()) {
                ForParagraphList.extract(c.getParagraphList(), tem, sb);
            }
        }
    }

    /**
     * 수식 컨트롤에서 텍스트를 추출한다
     *
     * @param equation 수식 컨트롤 객체
     * @param sb       추출된 텍스트를 저정할 StringBuffer 객체
     */
    private static void equation(ControlEquation equation, StringBuffer sb) {
        sb.append(equation.getEQEdit().getScript()).append("\n");
    }

    /**
     * 머리말 컨트롤에서 텍스트를 추출한다.
     *
     * @param header 머리말 컨트롤
     * @param tem    텍스트 추출 방법
     * @param sb     추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void header(ControlHeader header, TextExtractMethod tem,
                               StringBuffer sb) throws UnsupportedEncodingException {
        ForParagraphList.extract(header.getParagraphList(), tem, sb);
    }

    /**
     * 꼬리말 컨트롤에서 텍스트를 추출한다.
     *
     * @param footer 꼬리말 컨트롤
     * @param tem    텍스트 추출 방법
     * @param sb     추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void footer(ControlFooter footer, TextExtractMethod tem,
                               StringBuffer sb) throws UnsupportedEncodingException {
        ForParagraphList.extract(footer.getParagraphList(), tem, sb);
    }

    /**
     * 각주 컨트롤에서 텍스트를 추출한다.
     *
     * @param footnote 각주 컨트롤
     * @param tem      텍스트 추출 방법
     * @param sb       추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void footnote(ControlFootnote footnote,
                                 TextExtractMethod tem, StringBuffer sb) throws UnsupportedEncodingException {
        ForParagraphList.extract(footnote.getParagraphList(), tem, sb);
    }

    /**
     * 미주 컨트롤에서 텍스트를 추출한다.
     *
     * @param endnote 미주 컨트롤
     * @param tem     텍스트 추출 방법
     * @param sb      추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void endnote(ControlEndnote endnote, TextExtractMethod tem,
                                StringBuffer sb) throws UnsupportedEncodingException {
        ForParagraphList.extract(endnote.getParagraphList(), tem, sb);
    }

    /**
     * 덧말 컨트롤에서 텍스트를 추출한다.
     *
     * @param additionalText 덧말 컨트롤
     * @param sb             추출된 텍스트를 저정할 StringBuffer 객체
     */
    private static void additionalText(ControlAdditionalText additionalText,
                                       StringBuffer sb) {
        sb.append(additionalText.getHeader().getMainText()).append("\n");
        sb.append(additionalText.getHeader().getSubText()).append("\n");
    }

    /**
     * 숨은 설명 컨트롤에서 텍스트를 추출한다.
     *
     * @param hiddenComment 숨은 설명 컨트롤
     * @param tem           텍스트 추출 방법
     * @param sb            추출된 텍스트를 저정할 StringBuffer 객체
     * @throws UnsupportedEncodingException
     */
    private static void hiddenComment(ControlHiddenComment hiddenComment,
                                      TextExtractMethod tem, StringBuffer sb) throws UnsupportedEncodingException {
        ForParagraphList.extract(hiddenComment.getParagraphList(), tem, sb);
    }
}

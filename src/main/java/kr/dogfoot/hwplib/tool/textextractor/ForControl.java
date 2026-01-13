package kr.dogfoot.hwplib.tool.textextractor;

import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.tool.textextractor.paraHead.ParaHeadMaker;

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
     * @param c             컨트롤
     * @param tem           텍스트 추출 방법
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(Control c,
                               TextExtractMethod tem,
                               ParaHeadMaker paraHeadMaker,
                               StringBuilder sb) throws UnsupportedEncodingException {
        extract(c, new TextExtractOption(tem), paraHeadMaker, sb);
    }

    /**
     * 컨트롤에서 텍스트를 추출한다.
     *
     * @param c             컨트롤
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    public static void extract(Control c,
                               TextExtractOption option,
                               ParaHeadMaker paraHeadMaker,
                               StringBuilder sb) throws UnsupportedEncodingException {
        if (c.isField()) {
        } else {
            switch (c.getType()) {
                case Table:
                    table((ControlTable) c, option, paraHeadMaker, sb);
                    break;
                case Gso:
                    ForGso.extract((GsoControl) c, option, paraHeadMaker, sb);
                    break;
                case Equation:
                    equation((ControlEquation) c, sb);
                    break;
                case SectionDefine:
                    break;
                case ColumnDefine:
                    break;
                case Header:
                    header((ControlHeader) c, option, paraHeadMaker, sb);
                    break;
                case Footer:
                    footer((ControlFooter) c, option, paraHeadMaker, sb);
                    break;
                case Footnote:
                    footnote((ControlFootnote) c, option, paraHeadMaker, sb);
                    break;
                case Endnote:
                    endnote((ControlEndnote) c, option, paraHeadMaker, sb);
                    break;
                case AutoNumber:
                    break;
                case NewNumber:
                    break;
                case PageHide:
                    break;
                case PageOddEvenAdjust:
                    break;
                case PageNumberPosition:
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
                    hiddenComment((ControlHiddenComment) c, option, paraHeadMaker, sb);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 표 컨트롤에서 텍스트를 추출한다
     *
     * @param table         표 컨트롤
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void table(ControlTable table,
                              TextExtractOption option,
                              ParaHeadMaker paraHeadMaker,
                              StringBuilder sb) throws UnsupportedEncodingException {
        for (Row r : table.getRowList()) {
            for (Cell c : r.getCellList()) {
                ForParagraphList.extract(c.getParagraphList(), option, paraHeadMaker, sb);
            }
        }
    }

    /**
     * 수식 컨트롤에서 텍스트를 추출한다
     *
     * @param equation 수식 컨트롤 객체
     * @param sb       추출된 텍스트를 저정할 StringBuilder 객체
     */
    private static void equation(ControlEquation equation, StringBuilder sb) {
        sb.append(equation.getEQEdit().getScript().toUTF16LEString()).append("\n");
    }

    /**
     * 머리말 컨트롤에서 텍스트를 추출한다.
     *
     * @param header        머리말 컨트롤
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void header(ControlHeader header,
                               TextExtractOption option,
                               ParaHeadMaker paraHeadMaker,
                               StringBuilder sb) throws UnsupportedEncodingException {
        ForParagraphList.extract(header.getParagraphList(), option, paraHeadMaker, sb);
    }

    /**
     * 꼬리말 컨트롤에서 텍스트를 추출한다.
     *
     * @param footer        꼬리말 컨트롤
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void footer(ControlFooter footer,
                               TextExtractOption option,
                               ParaHeadMaker paraHeadMaker,
                               StringBuilder sb) throws UnsupportedEncodingException {
        ForParagraphList.extract(footer.getParagraphList(), option, paraHeadMaker, sb);
    }

    /**
     * 각주 컨트롤에서 텍스트를 추출한다.
     *
     * @param footnote      각주 컨트롤
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void footnote(ControlFootnote footnote,
                                 TextExtractOption option,
                                 ParaHeadMaker paraHeadMaker,
                                 StringBuilder sb) throws UnsupportedEncodingException {
        ForParagraphList.extract(footnote.getParagraphList(), option, paraHeadMaker, sb);
    }

    /**
     * 미주 컨트롤에서 텍스트를 추출한다.
     *
     * @param endnote       미주 컨트롤
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void endnote(ControlEndnote endnote,
                                TextExtractOption option,
                                ParaHeadMaker paraHeadMaker,
                                StringBuilder sb) throws UnsupportedEncodingException {
        ForParagraphList.extract(endnote.getParagraphList(), option, paraHeadMaker, sb);
    }

    /**
     * 덧말 컨트롤에서 텍스트를 추출한다.
     *
     * @param additionalText 덧말 컨트롤
     * @param sb             추출된 텍스트를 저정할 StringBuilder 객체
     */
    private static void additionalText(ControlAdditionalText additionalText,
                                       StringBuilder sb) {
        sb.append(additionalText.getHeader().getMainText()).append("\n");
        sb.append(additionalText.getHeader().getSubText()).append("\n");
    }

    /**
     * 숨은 설명 컨트롤에서 텍스트를 추출한다.
     *
     * @param hiddenComment 숨은 설명 컨트롤
     * @param option        추출 옵션
     * @param paraHeadMaker 문단 번호/글머리표 생성기
     * @param sb            추출된 텍스트를 저정할 StringBuilder 객체
     * @throws UnsupportedEncodingException
     */
    private static void hiddenComment(ControlHiddenComment hiddenComment,
                                      TextExtractOption option,
                                      ParaHeadMaker paraHeadMaker,
                                      StringBuilder sb) throws UnsupportedEncodingException {
        ForParagraphList.extract(hiddenComment.getParagraphList(), option, paraHeadMaker, sb);
    }
}

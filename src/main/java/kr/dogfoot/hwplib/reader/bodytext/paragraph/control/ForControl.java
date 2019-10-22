package kr.dogfoot.hwplib.reader.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 컨트롤을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForControl {
    /**
     * 컨트롤의 종류에 따라 컨트롤을 읽는다.
     *
     * @param c  컨트롤 객체
     * @param sr 스트림 리더
     * @throws Exception
     */
    public static void read(Control c, StreamReader sr) throws Exception {
        if (ControlType.isField(c.getType().getCtrlId())) { // 필드
            field(c, sr);
            return;
        }
        switch (c.getType()) {
            case Table: // 표
                table(c, sr);
                break;
            case Equation: // 수식
                equation(c, sr);
                break;
            case SectionDefine: // 구역 정의
                sectionDefine(c, sr);
                break;
            case ColumnDefine: // 단 정의
                columnDefine(c, sr);
                break;
            case Header: // 머리말
                header(c, sr);
                break;
            case Footer: // 꼬리말
                footer(c, sr);
                break;
            case Footnote: // 각주
                footnote(c, sr);
                break;
            case Endnote: // 미주
                endnote(c, sr);
                break;
            case AutoNumber: // 자동 번호
                autoNumber(c, sr);
                break;
            case NewNumber: // 새 번호 지정
                newNumber(c, sr);
                break;
            case PageHide: // 감추기
                pageHide(c, sr);
                break;
            case PageOddEvenAdjust:
                pageOddEvenAdjust(c, sr);
                break;
            case PageNumberPositon: // 쪽 번호 위치
                pageNumberPositon(c, sr);
                break;
            case IndexMark: // 찾아보기 표식
                indexMark(c, sr);
                break;
            case Bookmark: // 책갈피
                bookmark(c, sr);
                break;
            case OverlappingLetter: // 글자 겹침
                overlappingLetter(c, sr);
                break;
            case AdditionalText: // 덧말
                additionalText(c, sr);
                break;
            case HiddenComment: // 숨은 설명
                hiddenComment(c, sr);
                break;
            default:
                break;
        }
    }

    /**
     * 필드 컨트를을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void field(Control c, StreamReader sr) throws IOException {
        ForControlField.read((ControlField) c, sr);
    }

    /**
     * 표 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void table(Control c, StreamReader sr) throws Exception {
        ForControlTable fct = new ForControlTable();
        fct.read((ControlTable) c, sr);
    }

    /**
     * 한글 수식 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void equation(Control c, StreamReader sr) throws Exception {
        ForControlEquation fce = new ForControlEquation();
        fce.read((ControlEquation) c, sr);
    }

    /**
     * 구역 정의 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void sectionDefine(Control c, StreamReader sr)
            throws Exception {
        ForControlSectionDefine fcsd = new ForControlSectionDefine();
        fcsd.read((ControlSectionDefine) c, sr);
    }

    /**
     * 단 정의 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void columnDefine(Control c, StreamReader sr)
            throws IOException {
        ForControlColumnDefine.read((ControlColumnDefine) c, sr);
    }

    /**
     * 머리말 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void header(Control c, StreamReader sr) throws Exception {
        ForControlHeader fch = new ForControlHeader();
        fch.read((ControlHeader) c, sr);
    }

    /**
     * 꼬리말 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void footer(Control c, StreamReader sr) throws Exception {
        ForControlFooter fcf = new ForControlFooter();
        fcf.read((ControlFooter) c, sr);
    }

    /**
     * 각주 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void footnote(Control c, StreamReader sr) throws Exception {
        ForControlFootnote fcf = new ForControlFootnote();
        fcf.read((ControlFootnote) c, sr);
    }

    /**
     * 미주 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void endnote(Control c, StreamReader sr) throws Exception {
        ForControlEndnote fce = new ForControlEndnote();
        fce.read((ControlEndnote) c, sr);
    }

    /**
     * 자동 번호 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void autoNumber(Control c, StreamReader sr)
            throws IOException {
        ForControlAutoNumber.read((ControlAutoNumber) c, sr);
    }

    /**
     * 새 번호 지정 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void newNumber(Control c, StreamReader sr)
            throws IOException {
        ForControlNewNumber.read((ControlNewNumber) c, sr);
    }

    /**
     * 감추기 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void pageHide(Control c, StreamReader sr) throws IOException {
        ForControlPageHide.read((ControlPageHide) c, sr);
    }

    /**
     * 홀/짝수 조정 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void pageOddEvenAdjust(Control c, StreamReader sr) throws IOException {
        ForControlPageOddEvenAdjust.read((ControlPageOddEvenAdjust) c, sr);
    }

    /**
     * 쪽 번호 위치 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void pageNumberPositon(Control c, StreamReader sr)
            throws IOException {
        ForControlPageNumberPosition.read((ControlPageNumberPosition) c, sr);
    }

    /**
     * 찾아보기 표식 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void indexMark(Control c, StreamReader sr)
            throws IOException {
        ForControlIndexMark.read((ControlIndexMark) c, sr);
    }

    /**
     * 책갈피 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void bookmark(Control c, StreamReader sr) throws Exception {
        ForControlBookmark.read((ControlBookmark) c, sr);
    }

    /**
     * 글자 겹침 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void overlappingLetter(Control c, StreamReader sr)
            throws IOException {
        ForControlOverlappingLetter.read((ControlOverlappingLetter) c, sr);
    }

    /**
     * 덧말 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void additionalText(Control c, StreamReader sr)
            throws IOException {
        ForControlAdditionalText.read((ControlAdditionalText) c, sr);
    }

    /**
     * 숨은 설명 컨트롤을 읽는다.
     *
     * @param c  컨트롤
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void hiddenComment(Control c, StreamReader sr)
            throws Exception {
        ForControlHiddenComment fchc = new ForControlHiddenComment();
        fchc.read((ControlHiddenComment) c, sr);
    }
}

package kr.dogfoot.hwplib.tool.objectfinder;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;

import java.util.ArrayList;

/**
 * 원하는 컨트롤을 찾기 위한 객체
 *
 * @author neolord
 */
public class ControlFinder {
    /**
     * 조건 필터
     */
    private ControlFilter filter;
    /**
     * 결과 리스트
     */
    private ArrayList<Control> resultList;
    /**
     * 현재 구역 객체
     */
    private Section currentSection;
    /**
     * 현재 문단 객체
     */
    private Paragraph currentParagraph;

    /**
     * 생성자
     */
    private ControlFinder() {
    }

    /**
     * 원하는 조건에 맞는 컨트롤을 찾는다.
     *
     * @param hwpFile 한글 파일객체
     * @param filter  조건 필터
     * @return 원하는 조건에 맞는 컨트롤 리스트
     */
    public static ArrayList<Control> find(HWPFile hwpFile,
                                          ControlFilter filter) {
        ControlFinder finder = new ControlFinder();
        return finder.go(hwpFile, filter);
    }

    /**
     * 한글 파일 객체에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param hwpFile 한글 파일 객체
     * @param filter  조건 필터
     * @return 조건에 맞는 컨트롤 리스트
     */
    private ArrayList<Control> go(HWPFile hwpFile, ControlFilter filter) {
        resultList = new ArrayList<Control>();
        this.filter = filter;

        for (Section s : hwpFile.getBodyText().getSectionList()) {
            currentSection = s;
            forParagraphList(s);
        }

        return resultList;
    }

    /**
     * 문단 리스트에서 원하는 조건에 맞는 컨트롤를 찾는다
     *
     * @param paraList 문단 리스트
     */
    private void forParagraphList(ParagraphListInterface paraList) {
        for (Paragraph p : paraList) {
            currentParagraph = p;
            forParagraph(p);
        }
    }

    /**
     * 문단에서 원하는 조건에 맞는 컨트롤를 찾는다
     *
     * @param p 문단
     */
    private void forParagraph(Paragraph p) {
        if (p.getControlList() == null) {
            return;
        }
        for (Control c : p.getControlList()) {
            if (filter.isMatched(c, currentParagraph, currentSection)) {
                resultList.add(c);
            }
            forParagraphInControl(c);
        }
    }

    /**
     * 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param c 컨트롤
     */
    private void forParagraphInControl(Control c) {
        switch (c.getType()) {
            case Table:
                forTable((ControlTable) c);
                break;
            case Gso:
                forGso((GsoControl) c);
                break;
            case Equation:
                break;
            case SectionDefine:
                break;
            case ColumnDefine:
                break;
            case Header:
                forHeader((ControlHeader) c);
                break;
            case Footer:
                forFooter((ControlFooter) c);
                break;
            case Footnote:
                forFootnote((ControlFootnote) c);
                break;
            case Endnote:
                forEndnote((ControlEndnote) c);
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
                break;
            case HiddenComment:
                forHiddenComment((ControlHiddenComment) c);
                break;
            default:
                break;
        }
    }

    /**
     * 표 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param table 표 컨트롤
     */
    private void forTable(ControlTable table) {
        for (Row r : table.getRowList()) {
            for (Cell c : r.getCellList()) {
                forParagraphList(c.getParagraphList());
            }
        }
    }

    /**
     * 머리글 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param header 머리글 컨트롤
     */
    private void forHeader(ControlHeader header) {
        forParagraphList(header.getParagraphList());
    }

    /**
     * 바닥글 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param footer 바닥글 컨트롤
     */
    private void forFooter(ControlFooter footer) {
        forParagraphList(footer.getParagraphList());
    }

    /**
     * 각주 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param footnote 각주 컨트롤
     */
    private void forFootnote(ControlFootnote footnote) {
        forParagraphList(footnote.getParagraphList());
    }

    /**
     * 미주 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param endnote 미주 컨트롤
     */
    private void forEndnote(ControlEndnote endnote) {
        forParagraphList(endnote.getParagraphList());
    }

    /**
     * 숨은 설명 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param hiddenComment 숨은 설명 컨트롤
     */
    private void forHiddenComment(ControlHiddenComment hiddenComment) {
        forParagraphList(hiddenComment.getParagraphList());
    }

    /**
     * 그리기 객체 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param gc 그리기 객체 컨트롤
     */
    private void forGso(GsoControl gc) {
        switch (gc.getGsoType()) {
            case Line:
                break;
            case Rectangle:
                forRectangle((ControlRectangle) gc);
                break;
            case Ellipse:
                forEllipse((ControlEllipse) gc);
                break;
            case Arc:
                forArc((ControlArc) gc);
                break;
            case Polygon:
                forPolygon((ControlPolygon) gc);
                break;
            case Curve:
                forCurve((ControlCurve) gc);
                break;
            case Picture:
                break;
            case OLE:
                break;
            case Container:
                forContainer((ControlContainer) gc);
                break;
            default:
                break;
        }

    }

    /**
     * 사각형 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param rectangle 사각형 컨트롤
     */
    private void forRectangle(ControlRectangle rectangle) {
        forParagraphList(rectangle.getTextBox().getParagraphList());
    }

    /**
     * 타원 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param ellipse 타원 컨트롤
     */
    private void forEllipse(ControlEllipse ellipse) {
        forParagraphList(ellipse.getTextBox().getParagraphList());
    }

    /**
     * 호 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param arc 호 컨트롤
     */
    private void forArc(ControlArc arc) {
        forParagraphList(arc.getTextBox().getParagraphList());
    }

    /**
     * 다각형 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param polygon 다각형 컨트롤
     */
    private void forPolygon(ControlPolygon polygon) {
        forParagraphList(polygon.getTextBox().getParagraphList());
    }

    /**
     * 곡선 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param curve 곡선 컨트롤
     */
    private void forCurve(ControlCurve curve) {
        forParagraphList(curve.getTextBox().getParagraphList());
    }

    /**
     * 묶음 컨트롤 안에 문단에서 원하는 조건에 맞는 컨트롤를 찾는다.
     *
     * @param container 묶음 컨트롤
     */
    private void forContainer(ControlContainer container) {
        for (GsoControl child : container.getChildControlList()) {
            forGso(child);
        }
    }
}

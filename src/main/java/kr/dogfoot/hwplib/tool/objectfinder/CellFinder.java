package kr.dogfoot.hwplib.tool.objectfinder;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;

import java.util.ArrayList;

/**
 * 필드명이 일치하는 샐을 찾는 기능을 하는 객체.
 *
 * @author neolord
 */
public class CellFinder {
    /**
     * 결과가 저장되는 셀 리스트
     */
    private ArrayList<Cell> cellList;
    /**
     * 찾고자하는 필드명
     */
    private String fieldName;

    /**
     * 생성자
     *
     * @param fieldName 필드명
     */
    private CellFinder(String fieldName) {
        cellList = new ArrayList<Cell>();
        this.fieldName = fieldName;
    }

    /**
     * 표 안에서 필드명이 일치하는 셀들을 반환한다.
     *
     * @param table     표 컨트롤
     * @param fieldName 필드명
     * @return 셀 리스트
     */
    public static ArrayList<Cell> findAll(ControlTable table, String fieldName) {
        CellFinder finder = new CellFinder(fieldName);
        finder.find(table);
        return finder.cellList;
    }

    /**
     * 파일 내에서 필드명이 일치하는 셀들을 반환한다.
     *
     * @param hwpFile   한글 파일 객체
     * @param fieldName 필드명
     * @return 셀 리스트
     */
    public static ArrayList<Cell> findAll(HWPFile hwpFile, String fieldName) {
        CellFinder finder = new CellFinder(fieldName);
        for (Section s : hwpFile.getBodyText().getSectionList()) {
            finder.forParagraphList(s);
        }
        return finder.cellList;
    }

    /**
     * 표 안에서 필드명이 일치하는 셀들을 찾는다.
     *
     * @param table 표 컨트롤
     */
    public void find(ControlTable table) {
        for (Row row : table.getRowList()) {
            for (Cell cell : row.getCellList()) {
                if (matchFieldName(cell, fieldName)) {
                    cellList.add(cell);
                }
            }
        }
    }

    /**
     * 셀의 필드명이 원하는 필드명과 일치하는지 비교한다.
     *
     * @param cell      셀
     * @param fieldName 필드명
     * @return 셀의 필드명이 원하는 필드명과 일치하는지 여부
     */
    private boolean matchFieldName(Cell cell, String fieldName) {
        return cell != null
                && cell.getListHeader().getFieldName() != null
                && cell.getListHeader().getFieldName().equals(fieldName);
    }

    /**
     * 문단리스트에서 필드명이 일치하는 셀들을 찾는다.
     *
     * @param paragraphs 문단 리스트
     */
    private void forParagraphList(ParagraphListInterface paragraphs) {
        for (Paragraph p : paragraphs) {
            if (p.getControlList() != null) {
                for (Control c : p.getControlList()) {
                    forControl(c);
                }
            }
        }
    }

    /**
     * 다양한 종류의 컨트롤 내에서 필드명이 일치하는 셀들을 찾는다.
     *
     * @param c 컨트롤 객체
     */
    private void forControl(Control c) {
        switch (c.getType()) {
            case Table:
                find((ControlTable) c);
                break;
            case Gso:
                forGso((GsoControl) c);
                break;
            case Header: {
                ControlHeader header = (ControlHeader) c;
                forParagraphList(header.getParagraphList());
            }
            break;
            case Footer: {
                ControlFooter footer = (ControlFooter) c;
                forParagraphList(footer.getParagraphList());
            }
            break;
            case Footnote: {
                ControlFootnote footnote = (ControlFootnote) c;
                forParagraphList(footnote.getParagraphList());
            }
            break;
            case Endnote: {
                ControlEndnote endnote = (ControlEndnote) c;
                forParagraphList(endnote.getParagraphList());
            }
            break;
            case HiddenComment: {
                ControlHiddenComment comment = (ControlHiddenComment) c;
                forParagraphList(comment.getParagraphList());
            }
            break;
            default:
                break;
        }
    }

    /**
     * 다양한 그리기 객체 내에서 필드명이 일치하는 셀들을 찾는다.
     *
     * @param gso 그리기 객체
     */
    private void forGso(GsoControl gso) {
        switch (gso.getGsoType()) {
            case Rectangle: {
                ControlRectangle rectangle = (ControlRectangle) gso;
                forTextBox(rectangle.getTextBox());
            }
            break;
            case Ellipse: {
                ControlEllipse ellipse = (ControlEllipse) gso;
                forTextBox(ellipse.getTextBox());
            }
            break;
            case Arc: {
                ControlArc arc = (ControlArc) gso;
                forTextBox(arc.getTextBox());
            }
            break;
            case Polygon: {
                ControlPolygon polygon = (ControlPolygon) gso;
                forTextBox(polygon.getTextBox());
            }
            break;
            case Curve: {
                ControlCurve curve = (ControlCurve) gso;
                forTextBox(curve.getTextBox());
            }
            break;
            case Container: {
                ControlContainer container = (ControlContainer) gso;
                for (Control c : container.getChildControlList()) {
                    forControl(c);
                }
            }
            break;
            default:
                break;
        }
    }

    /**
     * 그리기 객체의 텍스트 박스에서 필드명이 일치하는 셀들을 찾는다.
     *
     * @param textBox 그리기 객체의 텍스트 박스
     */
    private void forTextBox(TextBox textBox) {
        if (textBox != null) {
            forParagraphList(textBox.getParagraphList());
        }
    }
}

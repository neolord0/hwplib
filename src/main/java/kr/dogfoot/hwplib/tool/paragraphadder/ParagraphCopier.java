package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;
import kr.dogfoot.hwplib.tool.paragraphadder.control.*;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

/**
 * Paragraph 객체를 복사하는 기능을 포함하는 클래스.
 *
 * @author neolord
 */
public class ParagraphCopier {
    public static void listCopy(ParagraphList source, ParagraphList target, DocInfoAdder docInfoAdder) {
        ParagraphCopier copier = new ParagraphCopier(docInfoAdder);
        for (Paragraph p : source) {
            try {
                copier.copy(p, target.addNewParagraph());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private DocInfoAdder docInfoAdder;
    private Paragraph source;
    private Paragraph target;

    public ParagraphCopier(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
    }

    public void copy(Paragraph source, Paragraph target) throws Exception {
        this.source = source;
        this.target = target;

        copyHeader();
        copyText();
        copyCharShape();
        copyLineSeg();
        copyRangeTag();
        copyControlList();
        copyMemoList();
    }

    private void copyHeader() {
        if (source.getHeader() != null) {
            ParaHeaderCopier.copy(source.getHeader(), target.getHeader(), docInfoAdder);
        }
    }

    private void copyText() throws Exception {
        if (source.getText() != null) {
            target.createText();
            ParaTextCopier.copy(source.getText(), target.getText());
        }
    }

    private void copyCharShape() {
        if (source.getCharShape() != null) {
            target.createCharShape();
            ParaCharShapeCopier.copy(source.getCharShape(), target.getCharShape(), docInfoAdder);
        }
    }

    private void copyLineSeg() {
        if (source.getLineSeg() != null) {
            target.createLineSeg();
            ParaLineSegCopier.copy(source.getLineSeg(), target.getLineSeg());
        }
    }

    private void copyRangeTag() throws Exception {
        if (source.getRangeTag() != null) {
            target.createRangeTag();
            ParaRangeTagCopier.copy(source.getRangeTag(), target.getRangeTag());
        }
    }

    private void copyControlList() {
        if (source.getControlList() == null) {
            return;
        }
        for (Control c : source.getControlList()) {
            if (c.isField()) {
                FieldCopier.copy((ControlField) c, (ControlField) target.addNewControl(((ControlField) c).getHeader().getCtrlId()), docInfoAdder);
            } else {
                switch (c.getType()) {
                    case Table:
                        TableCopier.copy((ControlTable) c, (ControlTable) target.addNewControl(ControlType.Table), docInfoAdder);
                        break;
                    case Gso:
                        GsoCopier.copy((GsoControl) c, (GsoControl) target.addNewGsoControl(((GsoControl) c).getGsoType()), docInfoAdder);
                        break;
                    case Equation:
                        EquationCopier.copy((ControlEquation) c, (ControlEquation) target.addNewControl(ControlType.Equation), docInfoAdder);
                        break;
                    case SectionDefine:
                        break;
                    case ColumnDefine:
                        ColumnDefineCopier.copy((ControlColumnDefine) c, (ControlColumnDefine) target.addNewControl(ControlType.ColumnDefine), docInfoAdder);
                        break;
                    case Header:
                        break;
                    case Footer:
                        break;
                    case Footnote:
                        break;
                    case Endnote:
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
                        OverlappingLetterCopier.copy((ControlOverlappingLetter) c, (ControlOverlappingLetter) target.addNewControl(ControlType.OverlappingLetter), docInfoAdder);  // 신규 추가
                        break;
                    case AdditionalText:
                        break;
                    case HiddenComment:
                        break;
                }
            }
        }
    }

    private void copyMemoList() {
        // not yet implemented
    }
}

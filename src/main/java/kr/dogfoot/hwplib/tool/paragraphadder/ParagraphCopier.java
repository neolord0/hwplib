package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;
import kr.dogfoot.hwplib.tool.paragraphadder.control.TableCopier;
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
            switch (c.getType()) {
                case Table:
                    TableCopier.copy((ControlTable) c, (ControlTable) target.addNewControl(ControlType.Table), docInfoAdder);
                    break;
                case Gso:
                    break;
                case Equation:
                    break;
                case SectionDefine:
                    break;
                case ColumnDefine:
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
                    break;
                case AdditionalText:
                    break;
                case HiddenComment:
                    break;
                case FIELD_UNKNOWN:
                    break;
                case FIELD_DATE:
                    break;
                case FIELD_DOCDATE:
                    break;
                case FIELD_PATH:
                    break;
                case FIELD_BOOKMARK:
                    break;
                case FIELD_MAILMERGE:
                    break;
                case FIELD_CROSSREF:
                    break;
                case FIELD_FORMULA:
                    break;
                case FIELD_CLICKHERE:
                    break;
                case FIELD_SUMMARY:
                    break;
                case FIELD_USERINFO:
                    break;
                case FIELD_HYPERLINK:
                    break;
                case FIELD_REVISION_SIGN:
                    break;
                case FIELD_REVISION_DELETE:
                    break;
                case FIELD_REVISION_ATTACH:
                    break;
                case FIELD_REVISION_CLIPPING:
                    break;
                case FIELD_REVISION_THINKING:
                    break;
                case FIELD_REVISION_PRAISE:
                    break;
                case FIELD_REVISION_LINE:
                    break;
                case FIELD_REVISION_SIMPLECHANGE:
                    break;
                case FIELD_REVISION_HYPERLINK:
                    break;
                case FIELD_REVISION_LINEATTACH:
                    break;
                case FIELD_REVISION_LINELINK:
                    break;
                case FIELD_REVISION_LINETRANSFER:
                    break;
                case FIELD_REVISION_RIGHTMOVE:
                    break;
                case FIELD_REVISION_LEFTMOVE:
                    break;
                case FIELD_REVISION_TRANSFER:
                    break;
                case FIELD_REVISION_SIMPLEINSERT:
                    break;
                case FIELD_REVISION_SPLIT:
                    break;
                case FIELD_REVISION_CHANGE:
                    break;
                case FIELD_MEMO:
                    break;
                case FIELD_PRIVATE_INFO_SECURITY:
                    break;
            }
        }
    }

    private void copyMemoList() {
        // not yet implemented
    }
}

package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.CharPositionShapeIdPair;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharType;
import kr.dogfoot.hwplib.tool.paragraphadder.control.GsoCopier;
import kr.dogfoot.hwplib.tool.paragraphadder.control.TableCopier;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class ParagraphMerger {
    private DocInfoAdder docInfoAdder;
    private Paragraph source;
    private Paragraph target;
    private boolean hasSectionDefine;
    private boolean hasColumnDefine;

    public ParagraphMerger(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
    }

    public void merge(Paragraph source, Paragraph target) throws Exception {
        this.source = source;
        this.target = target;

        hasSectionDefine = false;
        hasColumnDefine = false;

        removeLastParaBreakCharFromTarget();
        copyControlList();
        moveCharShape();
        moveText();
        deleteLineSeg();
        deleteRangeTag();
        copyMemoList();
    }


    private void removeLastParaBreakCharFromTarget() {
        if (target.getText() == null) {
            return;
        }

        int count = target.getText().getCharList().size();
        if (count > 0) {
            HWPChar lastChar = target.getText().getCharList().get(count - 1);
            if (lastChar.getType() == HWPCharType.ControlChar && lastChar.getCode() == 13/*para break*/) {
                target.getText().getCharList().remove(count - 1);
            }
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
                    GsoCopier.copy((GsoControl) c, (GsoControl) target.addNewGsoControl(((GsoControl) c).getGsoType()), docInfoAdder);
                    break;
                case SectionDefine:
                    hasSectionDefine = true;
                    break;
                case ColumnDefine:
                    hasColumnDefine = true;
                    break;
                    /*
                case Equation:
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
                     */
            }
        }
    }

    private void moveCharShape() {
        if (source.getCharShape() == null) {
            return;
        }

        int count;

        if (target.getText() == null) {
            count = 0;
        } else {
            count = target.getText().getCharLength();
        }

        int start = 0;
        if (hasSectionDefine) {
            start += 8;
        }
        if (hasColumnDefine) {
            start += 8;
        }

        if (target.getCharShape() == null) {
            target.createCharShape();
        }
        for (CharPositionShapeIdPair cpsp : source.getCharShape().getPositonShapeIdPairList()) {
            if (cpsp.getPosition() == 0) {
                target.getCharShape().addParaCharShape(cpsp.getPosition() + count, docInfoAdder.forCharShape().processById((int) cpsp.getShapeId()));
            } else {
                target.getCharShape().addParaCharShape(cpsp.getPosition() + count - start, docInfoAdder.forCharShape().processById((int) cpsp.getShapeId()));
            }
        }
    }


    private void moveText() throws Exception {
        if (source.getText() == null) {
            return;
        }
        if (target.getText() == null) {
            target.createText();
        }
        ParaTextCopier.copy(source.getText(), target.getText());
    }


    private void deleteLineSeg() {
        target.deleteLineSeg();
    }

    private void deleteRangeTag() throws Exception {
        target.deleteRangeTag();
    }

    private void copyMemoList() {
        // not yet implemented
    }

}

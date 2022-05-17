package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.CharPositionShapeIdPair;
import kr.dogfoot.hwplib.object.bodytext.paragraph.header.ParaHeader;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.memo.Memo;
import kr.dogfoot.hwplib.object.bodytext.paragraph.rangetag.RangeTagItem;
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
    private boolean includingSectionInfo;
    private boolean excludedSectionDefine;

    public ParagraphCopier(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
    }

    public void copy(Paragraph source, Paragraph target) throws Exception {
        this.source = source;
        this.target = target;
        this.includingSectionInfo = false;

        copyHeader();
        copyText();
        copyCharShape();
        copyLineSeg();
        copyRangeTag();
        copyControlList();
        copyMemoList();
    }

    public void copyIncludingSectionInfo(Paragraph source, Paragraph target) throws Exception {
        this.source = source;
        this.target = target;
        this.includingSectionInfo = true;

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
            ParaHeader sourceH = source.getHeader();
            ParaHeader targetH = target.getHeader();

            targetH.setLastInList(sourceH.isLastInList());
            targetH.setCharacterCount(sourceH.getCharacterCount());
            targetH.getControlMask().setValue(sourceH.getControlMask().getValue());
            targetH.setParaShapeId((docInfoAdder == null) ? sourceH.getParaShapeId() : docInfoAdder.forParaShape().processById(sourceH.getParaShapeId()));
            targetH.setStyleId((docInfoAdder == null) ? sourceH.getStyleId() : (short) docInfoAdder.forStyle().processById(sourceH.getStyleId()));
            targetH.getDivideSort().setValue(sourceH.getDivideSort().getValue());
            targetH.setCharShapeCount(sourceH.getCharShapeCount());
            targetH.setRangeTagCount(sourceH.getRangeTagCount());
            targetH.setLineAlignCount(sourceH.getLineAlignCount());
            targetH.setInstanceID(0);
            targetH.setIsMergedByTrack(sourceH.getIsMergedByTrack());
        }
    }

    private void copyText() throws Exception {
        if (source.getText() != null) {
            target.createText();
            excludedSectionDefine = ParaTextCopier.copy(source.getText(), target.getText(), includingSectionInfo);
        }
    }

    private void copyCharShape() {
        if (source.getCharShape() != null) {
            target.createCharShape();

            for (CharPositionShapeIdPair cpsp : source.getCharShape().getPositonShapeIdPairList()) {
                if (excludedSectionDefine == true && cpsp.getPosition() > 0)  {
                    target.getCharShape().addParaCharShape(cpsp.getPosition() - 8, (docInfoAdder == null) ? cpsp.getShapeId() : docInfoAdder.forCharShape().processById((int) cpsp.getShapeId()));
                } else {
                    target.getCharShape().addParaCharShape(cpsp.getPosition(), (docInfoAdder == null) ? cpsp.getShapeId() : docInfoAdder.forCharShape().processById((int) cpsp.getShapeId()));
                }
            }
        }
    }

    private void copyLineSeg() {
        if (source.getLineSeg() != null) {
            target.createLineSeg();
            for (LineSegItem lsi : source.getLineSeg().getLineSegItemList()) {
                target.getLineSeg().getLineSegItemList().add(lsi.clone());
            }
        }
    }

    private void copyRangeTag() throws Exception {
        if (source.getRangeTag() != null) {
            target.createRangeTag();
            for (RangeTagItem rti : source.getRangeTag().getRangeTagItemList()) {
                target.getRangeTag().getRangeTagItemList().add(rti.clone());
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
                case Equation:
                    EquationCopier.copy((ControlEquation) c, (ControlEquation) target.addNewControl(ControlType.Equation), docInfoAdder);
                    break;
                case SectionDefine:
                    if (includingSectionInfo) {
                        SectionDefineCopier.copy((ControlSectionDefine) c, (ControlSectionDefine) target.addNewControl(ControlType.SectionDefine), docInfoAdder);
                    }
                    break;
                case ColumnDefine:
                    ETCControlCopier.copyColumnDefine((ControlColumnDefine) c, (ControlColumnDefine) target.addNewControl(ControlType.ColumnDefine), docInfoAdder);
                    break;
                case Header:
                    if (includingSectionInfo) {
                        ETCControlCopier.copyHeader((ControlHeader) c, (ControlHeader) target.addNewControl(ControlType.Header), docInfoAdder);
                    }
                    break;
                case Footer:
                    if (includingSectionInfo) {
                        ETCControlCopier.copyFooter((ControlFooter) c, (ControlFooter) target.addNewControl(ControlType.Footer), docInfoAdder);
                    }
                    break;
                case Footnote:
                    ETCControlCopier.copyFootnote((ControlFootnote) c, (ControlFootnote) target.addNewControl(ControlType.Footnote), docInfoAdder);
                    break;
                case Endnote:
                    ETCControlCopier.copyEndnote((ControlEndnote) c, (ControlEndnote) target.addNewControl(ControlType.Endnote), docInfoAdder);
                    break;
                case AutoNumber:
                    ETCControlCopier.copyAutoNumber((ControlAutoNumber) c, (ControlAutoNumber) target.addNewControl(ControlType.AutoNumber), docInfoAdder);
                    break;
                case NewNumber:
                    ETCControlCopier.copyNewNumber((ControlNewNumber) c, (ControlNewNumber) target.addNewControl(ControlType.NewNumber), docInfoAdder);
                    break;
                case PageHide:
                    ETCControlCopier.copyPageHide((ControlPageHide) c, (ControlPageHide) target.addNewControl(ControlType.PageHide), docInfoAdder);
                    break;
                case PageOddEvenAdjust:
                    ETCControlCopier.copyPageOddEvenAdjust((ControlPageOddEvenAdjust) c, (ControlPageOddEvenAdjust) target.addNewControl(ControlType.PageOddEvenAdjust), docInfoAdder);
                    break;
                case PageNumberPosition:
                    ETCControlCopier.copyPageNumberPosition((ControlPageNumberPosition) c, (ControlPageNumberPosition) target.addNewControl(ControlType.PageNumberPosition), docInfoAdder);
                    break;
                case IndexMark:
                    ETCControlCopier.copyIndexMark((ControlIndexMark) c, (ControlIndexMark) target.addNewControl(ControlType.IndexMark), docInfoAdder);
                    break;
                case Bookmark:
                    ETCControlCopier.copyBookmark((ControlBookmark) c, (ControlBookmark) target.addNewControl(ControlType.IndexMark), docInfoAdder);
                    break;
                case OverlappingLetter:
                    OverlappingLetterCopier.copy((ControlOverlappingLetter) c, (ControlOverlappingLetter) target.addNewControl(ControlType.OverlappingLetter), docInfoAdder);  // 신규 추가
                    break;
                case AdditionalText:
                    AdditionalTextCopier.copy((ControlAdditionalText) c, (ControlAdditionalText) target.addNewControl(ControlType.AdditionalText), docInfoAdder);
                    break;
                case HiddenComment:
                    ETCControlCopier.copyHiddenComment((ControlHiddenComment) c, (ControlHiddenComment) target.addNewControl(ControlType.HiddenComment), docInfoAdder);
                    break;
                case Form:
                    ETCControlCopier.copyForm((ControlForm) c, (ControlForm) target.addNewControl(ControlType.Form), docInfoAdder);
                    break;
                case FIELD_UNKNOWN:
                case FIELD_DATE:
                case FIELD_DOCDATE:
                case FIELD_PATH:
                case FIELD_BOOKMARK:
                case FIELD_MAILMERGE:
                case FIELD_CROSSREF:
                case FIELD_FORMULA:
                case FIELD_CLICKHERE:
                case FIELD_SUMMARY:
                case FIELD_USERINFO:
                case FIELD_HYPERLINK:
                case FIELD_REVISION_SIGN:
                case FIELD_REVISION_DELETE:
                case FIELD_REVISION_ATTACH:
                case FIELD_REVISION_CLIPPING:
                case FIELD_REVISION_THINKING:
                case FIELD_REVISION_PRAISE:
                case FIELD_REVISION_LINE:
                case FIELD_REVISION_SIMPLECHANGE:
                case FIELD_REVISION_HYPERLINK:
                case FIELD_REVISION_LINEATTACH:
                case FIELD_REVISION_LINELINK:
                case FIELD_REVISION_LINETRANSFER:
                case FIELD_REVISION_RIGHTMOVE:
                case FIELD_REVISION_LEFTMOVE:
                case FIELD_REVISION_TRANSFER:
                case FIELD_REVISION_SIMPLEINSERT:
                case FIELD_REVISION_SPLIT:
                case FIELD_REVISION_CHANGE:
                case FIELD_MEMO:
                case FIELD_PRIVATE_INFO_SECURITY:
                case FIELD_TABLEOFCONTENTS:
                    ETCControlCopier.copyField((ControlField) c, (ControlField) target.addNewControl(((ControlField) c).getHeader().getCtrlId()), docInfoAdder);
                    break;
            }
        }
    }

    private void copyMemoList() {
        copyMemoList(source, target, docInfoAdder);
    }

    public static void copyMemoList(Paragraph source, Paragraph target, DocInfoAdder docInfoAdder) {
        if (source.getMemoList() == null) {
            return;
        }

        if (target.getMemoList() != null) {
            target.getMemoList().clear();
        }

        for (Memo memo : source.getMemoList()) {
            Memo cloned = target.addNewMemo();
            cloned.getMemoList().copy(memo.getMemoList());
            cloned.getListHeader().copy(memo.getListHeader());
            ParagraphCopier.listCopy(memo.getParagraphList(), cloned.getParagraphList(), docInfoAdder);
        }
    }
}

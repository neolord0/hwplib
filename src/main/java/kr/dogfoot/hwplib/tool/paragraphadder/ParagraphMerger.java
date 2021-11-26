package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.CharPositionShapeIdPair;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharControlExtend;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharType;
import kr.dogfoot.hwplib.tool.paragraphadder.control.*;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class ParagraphMerger {
    private DocInfoAdder docInfoAdder;
    private Paragraph source;
    private Paragraph target;
    private int targetCharPosition;
    private int sourceCharPosition;
    private int sourceCharShapeIndex;
    private int sourceControlIndex;

    public ParagraphMerger() {
        this.docInfoAdder = null;
    }

    public ParagraphMerger(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
    }

    public void merge(Paragraph source, Paragraph target) throws Exception {
        this.source = source;
        this.target = target;

        removeLastParaBreakCharFromTarget();

        moveTextAndCharShapeAndControl();

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

    private void moveTextAndCharShapeAndControl() {
        targetCharPosition = target.getText().getCharSize();
        sourceCharPosition = 0;
        sourceCharShapeIndex = 0;
        sourceControlIndex = 0;

        for (HWPChar hwpChar : source.getText().getCharList()) {
            switch (hwpChar.getType()) {
                case Normal:
                    moveCharAndCharShape(hwpChar);
                    break;
                case ControlChar:
                    moveCharAndCharShape(hwpChar);
                    break;
                case ControlInline:
                    moveCharAndCharShape(hwpChar);
                    break;
                case ControlExtend:
                    moveExtendChar((HWPCharControlExtend) hwpChar);
                    break;
            }

            sourceCharPosition += hwpChar.getCharSize();
        }
    }

    private void moveCharAndCharShape(HWPChar hwpChar) {
        target.getText().getCharList().add(hwpChar);
        moveCharSpace();
        targetCharPosition += hwpChar.getCharSize();
    }

    private void moveCharSpace() {
        if (sourceCharShapeIndex < source.getCharShape().getPositonShapeIdPairList().size()) {
            CharPositionShapeIdPair cpsip = source.getCharShape().getPositonShapeIdPairList().get(sourceCharShapeIndex);
            if (cpsip.getPosition() <= sourceCharPosition) {
                target.getCharShape().addParaCharShape(targetCharPosition, (docInfoAdder == null) ? cpsip.getShapeId() : docInfoAdder.forCharShape().processById((int) cpsip.getShapeId()));
                sourceCharShapeIndex++;
            }
        }
    }

    private void moveExtendChar(HWPCharControlExtend hwpChar) {
        if (canMoveExtendChar(hwpChar)) {
            target.getText().getCharList().add(hwpChar);
            moveCharSpace();
            targetCharPosition += hwpChar.getCharSize();
            moveControl(source.getControlList().get(sourceControlIndex));
        }
        sourceControlIndex++;
    }

    private boolean canMoveExtendChar(HWPCharControlExtend hwpChar) {
        if (hwpChar.getCode() == 3              // 필드 시작(누름틀, 하이퍼링크, 블록 책갈피, 표 계산식 ...)
                || hwpChar.getCode() == 11      // 그리기 개체/표/수식/양식 개체
                || hwpChar.getCode() == 15      // 숨은 설명
                || hwpChar.getCode() == 16      // 머리말/꼬리말
                || hwpChar.getCode() == 17      // 각주/미주
                || hwpChar.getCode() == 18      // 자동번호(각주, 표 등)
                || hwpChar.getCode() == 21      // 페이지 컨트롤(감추기, 새 번호로 시작 등)
                || hwpChar.getCode() == 22      // 책갈피/찾아보기 표식
                || hwpChar.getCode() == 23) {   // 덧말/글자 겹침
            return true;
        }
        return false;
    }

    private void moveControl(Control sourceControl) {
        if (target.getControlList() == null) {
            target.createControlList();
        }

        switch (sourceControl.getType()) {
            case Table:
                TableCopier.copy((ControlTable) sourceControl, (ControlTable) target.addNewControl(ControlType.Table), docInfoAdder);
                break;
            case Gso:
                GsoCopier.copy((GsoControl) sourceControl, target.addNewGsoControl(((GsoControl) sourceControl).getGsoType()), docInfoAdder);
                break;
            case Equation:
                EquationCopier.copy((ControlEquation) sourceControl, (ControlEquation) target.addNewControl(ControlType.Equation), docInfoAdder);
                break;
            case Header:
                ETCControlCopier.copyHeader((ControlHeader) sourceControl, (ControlHeader) target.addNewControl(ControlType.Header), docInfoAdder);
                break;
            case Footer:
                ETCControlCopier.copyFooter((ControlFooter) sourceControl, (ControlFooter) target.addNewControl(ControlType.Footer), docInfoAdder);
                break;
            case Footnote:
                ETCControlCopier.copyFootnote((ControlFootnote) sourceControl, (ControlFootnote) target.addNewControl(ControlType.Footnote), docInfoAdder);
                break;
            case Endnote:
                ETCControlCopier.copyEndnote((ControlEndnote) sourceControl, (ControlEndnote) target.addNewControl(ControlType.Endnote), docInfoAdder);
                break;
            case AutoNumber:
                ETCControlCopier.copyAutoNumber((ControlAutoNumber) sourceControl, (ControlAutoNumber) target.addNewControl(ControlType.AutoNumber), docInfoAdder);
                break;
            case NewNumber:
                ETCControlCopier.copyNewNumber((ControlNewNumber) sourceControl, (ControlNewNumber) target.addNewControl(ControlType.NewNumber), docInfoAdder);
                break;
            case PageHide:
                ETCControlCopier.copyPageHide((ControlPageHide) sourceControl, (ControlPageHide) target.addNewControl(ControlType.PageHide), docInfoAdder);
                break;
            case PageOddEvenAdjust:
                ETCControlCopier.copyPageOddEvenAdjust((ControlPageOddEvenAdjust) sourceControl, (ControlPageOddEvenAdjust) target.addNewControl(ControlType.PageOddEvenAdjust), docInfoAdder);
                break;
            case PageNumberPositon:
                ETCControlCopier.copyPageNumberPosition((ControlPageNumberPosition) sourceControl, (ControlPageNumberPosition) target.addNewControl(ControlType.PageNumberPositon), docInfoAdder);
                break;
            case IndexMark:
                ETCControlCopier.copyIndexMark((ControlIndexMark) sourceControl, (ControlIndexMark) target.addNewControl(ControlType.IndexMark), docInfoAdder);
                break;
            case Bookmark:
                ETCControlCopier.copyBookmark((ControlBookmark) sourceControl, (ControlBookmark) target.addNewControl(ControlType.IndexMark), docInfoAdder);
                break;
            case OverlappingLetter:
                OverlappingLetterCopier.copy((ControlOverlappingLetter) sourceControl, (ControlOverlappingLetter) target.addNewControl(ControlType.OverlappingLetter), docInfoAdder);  // 신규 추가
                break;
            case AdditionalText:
                AdditionalTextCopier.copy((ControlAdditionalText) sourceControl, (ControlAdditionalText) target.addNewControl(ControlType.AdditionalText), docInfoAdder);
                break;
            case HiddenComment:
                ETCControlCopier.copyHiddenComment((ControlHiddenComment) sourceControl, (ControlHiddenComment) target.addNewControl(ControlType.HiddenComment), docInfoAdder);
                break;
            case Form:
                ETCControlCopier.copyForm((ControlForm) sourceControl, (ControlForm) target.addNewControl(ControlType.Form), docInfoAdder);
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
                ETCControlCopier.copyField((ControlField) sourceControl, (ControlField) target.addNewControl(((ControlField) sourceControl).getHeader().getCtrlId()), docInfoAdder);
                break;
        }
    }

    private void deleteLineSeg() {
        target.deleteLineSeg();
    }

    private void deleteRangeTag() throws Exception {
        target.deleteRangeTag();
    }

    private void copyMemoList() {
        ParagraphCopier.copyMemoList(source, target, docInfoAdder);
    }

}

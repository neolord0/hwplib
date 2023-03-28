package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.*;
import kr.dogfoot.hwplib.object.bodytext.control.footnoteendnote.ListHeaderForFootnodeEndnote;
import kr.dogfoot.hwplib.object.bodytext.control.form.FormObject;
import kr.dogfoot.hwplib.object.bodytext.control.headerfooter.ListHeaderForHeaderFooter;
import kr.dogfoot.hwplib.object.bodytext.control.hiddencomment.ListHeaderForHiddenComment;
import kr.dogfoot.hwplib.object.bodytext.paragraph.memo.Memo;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphCopier;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

import java.nio.charset.StandardCharsets;

public class ETCControlCopier {
    public static void copyAutoNumber(ControlAutoNumber source, ControlAutoNumber target, DocInfoAdder docInfoAdder) {
        CtrlHeaderAutoNumber sourceH = source.getHeader();
        CtrlHeaderAutoNumber targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);
    }

    public static void copyColumnDefine(ControlColumnDefine source, ControlColumnDefine target, DocInfoAdder docInfoAdder) {
        CtrlHeaderColumnDefine sourceH = source.getHeader();
        CtrlHeaderColumnDefine targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);
    }

    public static void copyEndnote(ControlEndnote source, ControlEndnote target, DocInfoAdder docInfoAdder) {
        CtrlHeaderEndnote sourceH = source.getHeader();
        CtrlHeaderEndnote targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);

        ListHeaderForFootnodeEndnote sourceLH = source.getListHeader();
        ListHeaderForFootnodeEndnote targetLH = target.getListHeader();
        targetLH.copy(sourceLH);

        ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
    }

    public static void copyField(ControlField source, ControlField target, DocInfoAdder docInfoAdder) {
        CtrlHeaderField sourceH = source.getHeader();
        CtrlHeaderField targetH = target.getHeader();
        targetH.copy(sourceH);
        CtrlDataCopier.copy(source, target, docInfoAdder);

        if (isMemo(source)) {
            Memo sourceMemo = getSourceMemo(sourceH.getMemoIndex(), docInfoAdder);
            if (sourceMemo != null) {
                long newMemoIndex = addMemoToTarget(sourceMemo, docInfoAdder);
                setNewMemoIndex(targetH, newMemoIndex);
            }
        }
    }

    private static boolean isMemo(ControlField source) {
        return source.getHeader().getCommand().toUTF16LEString().startsWith("MEMO");
    }

    private static Memo getSourceMemo(int memoIndex, DocInfoAdder docInfoAdder) {
        if (docInfoAdder.getSourceHWPFile().getBodyText().getMemoList() != null) {
            for (Memo memo : docInfoAdder.getSourceHWPFile().getBodyText().getMemoList()) {
                if (memo.getMemoList().getMemoIndex() == memoIndex) {
                    return memo;
                }
            }
        }
        return null;
    }

    private static long addMemoToTarget(Memo sourceMemo, DocInfoAdder docInfoAdder) {
        long maxMemoIndex = 0;
        if (docInfoAdder.getTargetHWPFile().getBodyText().getMemoList() != null) {
            for (Memo memo : docInfoAdder.getTargetHWPFile().getBodyText().getMemoList()) {
                maxMemoIndex = Math.max(maxMemoIndex, memo.getMemoList().getMemoIndex());
            }
        }
        maxMemoIndex += 1;

        Memo clonedMemo = sourceMemo.clone();
        clonedMemo.getMemoList().setMemoIndex(maxMemoIndex);
        docInfoAdder.getTargetHWPFile().getBodyText().getMemoList().add(clonedMemo);
        return maxMemoIndex;
    }


    private static void setNewMemoIndex(CtrlHeaderField targetH, long newMemoIndex) {
        String[] commands = targetH.getCommand().toUTF16LEString().split("/");
        commands[2] = Long.toString(newMemoIndex);
        targetH.getCommand().setBytes(stringJoin("/", commands).getBytes(StandardCharsets.UTF_16LE));
        targetH.setMemoIndex((int) newMemoIndex);
    }

    private static String stringJoin(String s, String[] array) {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < array.length; index++) {
            if (index != array.length-1) {
                sb.append(array[index]).append(s);
            } else {
                sb.append(array[index]);
            }
        }
        return sb.toString();
    }

    public static void copyFooter(ControlFooter source, ControlFooter target, DocInfoAdder docInfoAdder) {
        CtrlHeaderFooter sourceH = source.getHeader();
        CtrlHeaderFooter targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);

        ListHeaderForHeaderFooter sourceLH = source.getListHeader();
        ListHeaderForHeaderFooter targetLH = target.getListHeader();
        targetLH.copy(sourceLH);

        ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
    }

    public static void copyFootnote(ControlFootnote source, ControlFootnote target, DocInfoAdder docInfoAdder) {
        CtrlHeaderFootnote sourceH = source.getHeader();
        CtrlHeaderFootnote targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);

        ListHeaderForFootnodeEndnote sourceLH = source.getListHeader();
        ListHeaderForFootnodeEndnote targetLH = target.getListHeader();
        targetLH.copy(sourceLH);

        ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
    }

    public static void copyHeader(ControlHeader source, ControlHeader target, DocInfoAdder docInfoAdder) {
        CtrlHeaderHeader sourceH = source.getHeader();
        CtrlHeaderHeader targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);

        ListHeaderForHeaderFooter sourceLH = source.getListHeader();
        ListHeaderForHeaderFooter targetLH = target.getListHeader();
        targetLH.copy(sourceLH);

        ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
    }

    public static void copyIndexMark(ControlIndexMark source, ControlIndexMark target, DocInfoAdder docInfoAdder) {
        CtrlHeaderIndexMark sourceH = source.getHeader();
        CtrlHeaderIndexMark targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);
    }

    public static void copyNewNumber(ControlNewNumber source, ControlNewNumber target, DocInfoAdder docInfoAdder) {
        CtrlHeaderNewNumber sourceH = source.getHeader();
        CtrlHeaderNewNumber targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);
    }

    public static void copyPageHide(ControlPageHide source, ControlPageHide target, DocInfoAdder docInfoAdder) {
        CtrlHeaderPageHide sourceH = source.getHeader();
        CtrlHeaderPageHide targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);
    }

    public static void copyPageNumberPosition(ControlPageNumberPosition source, ControlPageNumberPosition target, DocInfoAdder docInfoAdder) {
        CtrlHeaderPageNumberPosition sourceH = source.getHeader();
        CtrlHeaderPageNumberPosition targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);
    }

    public static void copyPageOddEvenAdjust(ControlPageOddEvenAdjust source, ControlPageOddEvenAdjust target, DocInfoAdder docInfoAdder) {
        CtrlHeaderPageOddEvenAdjust sourceH = source.getHeader();
        CtrlHeaderPageOddEvenAdjust targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);
    }

    public static void copyBookmark(ControlBookmark source, ControlBookmark target, DocInfoAdder docInfoAdder) {
        CtrlHeaderBookmark sourceH = source.getHeader();
        CtrlHeaderBookmark targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);
    }

    public static void copyHiddenComment(ControlHiddenComment source, ControlHiddenComment target, DocInfoAdder docInfoAdder) {
        CtrlHeader sourceH = source.getHeader();
        CtrlHeader targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);

        ListHeaderForHiddenComment sourceLH = source.getListHeader();
        ListHeaderForHiddenComment targetLH = target.getListHeader();
        targetLH.copy(sourceLH);

        ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
    }

    public static void copyForm(ControlForm source, ControlForm target, DocInfoAdder docInfoAdder) {
        CtrlHeaderGso sourceH = source.getHeader();
        CtrlHeaderGso targetH = target.getHeader();
        targetH.copy(sourceH);

        CtrlDataCopier.copy(source, target, docInfoAdder);

        FormObject sourceFO = source.getFormObject();
        FormObject targetFO = target.getFormObject();
        targetFO.copy(sourceFO);
    }
}

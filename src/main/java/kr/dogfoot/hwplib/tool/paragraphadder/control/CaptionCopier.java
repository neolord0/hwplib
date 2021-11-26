package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.Caption;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.ListHeaderForCaption;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphCopier;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class CaptionCopier {
    public static void copy(Caption source, Caption target, DocInfoAdder docInfoAdder) {
        ListHeaderForCaption sourceLH = source.getListHeader();
        ListHeaderForCaption targetLH = target.getListHeader();
        targetLH.copy(sourceLH);

        ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
    }
}

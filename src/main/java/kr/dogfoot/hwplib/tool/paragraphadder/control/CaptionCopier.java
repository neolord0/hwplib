package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.Caption;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.ListHeaderCaptionProperty;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.ListHeaderForCaption;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.ListHeaderProperty;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphCopier;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class CaptionCopier {
     public static void copy(Caption source, Caption target, DocInfoAdder docInfoAdder) {
          listHeader(source.getListHeader(), target.getListHeader(), docInfoAdder);
          ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
     }

     private static void listHeader(ListHeaderForCaption source, ListHeaderForCaption target, DocInfoAdder docInfoAdder) {
          target.setParaCount(source.getParaCount());
          target.getProperty().setValue(source.getProperty().getValue());
          target.getCaptionProperty().setValue(source.getCaptionProperty().getValue());
          target.setCaptionWidth(source.getCaptionWidth());
          target.setSpaceBetweenCaptionAndFrame(source.getSpaceBetweenCaptionAndFrame());
          target.setTextWidth(source.getTextWidth());
     }
}

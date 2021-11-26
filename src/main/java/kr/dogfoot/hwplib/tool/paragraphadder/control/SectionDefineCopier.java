package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.*;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphCopier;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class SectionDefineCopier {
    public static void copy(ControlSectionDefine source, ControlSectionDefine target, DocInfoAdder docInfoAdder) {
        header(source.getHeader(), target.getHeader(), docInfoAdder);
        CtrlDataCopier.copy(source, target, docInfoAdder);

        PageDef sourcePD = source.getPageDef();
        PageDef targetPD = target.getPageDef();
        targetPD.copy(sourcePD);

        footEndNoteShape(source.getFootNoteShape(), target.getFootNoteShape());
        footEndNoteShape(source.getEndNoteShape(), target.getEndNoteShape());
        pageBorderFill(source.getBothPageBorderFill(), target.getBothPageBorderFill(), docInfoAdder);
        pageBorderFill(source.getEvenPageBorderFill(), target.getEvenPageBorderFill(), docInfoAdder);
        pageBorderFill(source.getOddPageBorderFill(), target.getOddPageBorderFill(), docInfoAdder);

        for (BatangPageInfo sourceBatangPageInfo : source.getBatangPageInfoList()) {
            batangPageInfo(sourceBatangPageInfo, target.addNewBatangPageInfo(), docInfoAdder);
        }
    }

    private static void header(CtrlHeaderSectionDefine source, CtrlHeaderSectionDefine target, DocInfoAdder docInfoAdder) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.setColumnGap(source.getColumnGap());
        target.setVerticalLineAlign(source.getVerticalLineAlign());
        target.setHorizontalLineAlign(source.getHorizontalLineAlign());
        target.setDefaultTabGap(source.getDefaultTabGap());
        target.setNumberParaShapeId((docInfoAdder == null) ? source.getNumberParaShapeId() : docInfoAdder.forParaShape().processById(source.getNumberParaShapeId()));
        target.setPageStartNumber(source.getPageStartNumber());
        target.setImageStartNumber(source.getImageStartNumber());
        target.setTableStartNumber(source.getTableStartNumber());
        target.setEquationStartNumber(source.getEquationStartNumber());
        target.setDefaultLanguage(source.getDefaultLanguage());
    }

    private static void footEndNoteShape(FootEndNoteShape source, FootEndNoteShape target) {
        target.copy(source);
    }

    private static void pageBorderFill(PageBorderFill source, PageBorderFill target, DocInfoAdder docInfoAdder) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.setLeftGap(source.getLeftGap());
        target.setRightGap(source.getRightGap());
        target.setTopGap(source.getTopGap());
        target.setBottomGap(source.getBottomGap());

        if (source.getBorderFillId() == 0) {
            target.setBorderFillId(0);
        } else {
            target.setBorderFillId((docInfoAdder == null) ? source.getBorderFillId() : docInfoAdder.forBorderFill().processById(source.getBorderFillId()));
        }
    }

    private static void batangPageInfo(BatangPageInfo source, BatangPageInfo target, DocInfoAdder docInfoAdder) {
        ListHeaderForBatangPage sourceLH = source.getListHeader();
        ListHeaderForBatangPage targetLH = target.getListHeader();
        targetLH.copy(sourceLH);

        ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
    }
}

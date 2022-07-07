package kr.dogfoot.hwplib.tool.textextractor.paraHead;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.docinfo.Bullet;
import kr.dogfoot.hwplib.object.docinfo.Numbering;
import kr.dogfoot.hwplib.object.docinfo.ParaShape;
import kr.dogfoot.hwplib.object.docinfo.numbering.LevelNumbering;
import kr.dogfoot.hwplib.util.StringUtil;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class ParaHeadMaker {
    private HWPFile hwpFile;
    private ControlSectionDefine sectionDefine;
    private OutLineNumber outlineNumber;
    private ParaNumber paraNumber;

    public ParaHeadMaker(HWPFile hwpFile) {
        this.hwpFile = hwpFile;
        setSectionDefine(hwpFile.getBodyText().getSectionList().get(0));
        outlineNumber = new OutLineNumber();
        paraNumber = new ParaNumber();
    }

    public void startSection(Section section) {
        setSectionDefine(section);
        outlineNumber = new OutLineNumber();
    }

    public void endSection() {
        outlineNumber = null;
    }


    private void setSectionDefine(Section section) {
        if (section.getParagraphCount() > 0 && section.getParagraph(0).getControlList().size() > 0) {
            Control firstControl = section.getParagraph(0).getControlList().get(0);
            if (firstControl.getType() == ControlType.SectionDefine) {
                sectionDefine = (ControlSectionDefine) firstControl;
            } else {
                if (section.getParagraph(0).getControlList().size() >= 2) {
                    Control secondControl = section.getParagraph(0).getControlList().get(1);
                    if (secondControl.getType() == ControlType.SectionDefine) {
                        sectionDefine = (ControlSectionDefine) secondControl;
                    }
                }
            }
        }
    }

    public String paraHeadString(Paragraph paragraph) {
        ParaShape paraShape = hwpFile.getDocInfo().getParaShapeList().get(paragraph.getHeader().getParaShapeId());
        switch (paraShape.getProperty1().getParaHeadShape()) {
            case None:
                return "";
            case Outline:
                return outline(paraShape.getProperty1().getParaLevel());
            case Numbering:
                return numbering(paraShape.getParaHeadId(),
                        paraShape.getProperty1().getParaLevel());
            case Bullet:
                return bullet(paraShape.getParaHeadId(),
                        paraShape.getProperty1().getParaLevel());
        }
        return null;
    }

    private String outline(byte paraLevel) {
        return outlineNumber.getText(paraLevel);
        /*
        if (outlineNumber.changedParaHead(paraHeadID)) {
            outlineNumber.reset(paraHeadID, paraLevel, numbering.getStartNumber());
        } else {
            outlineNumber.increase(paraLevel);
        }

        try {
            LevelNumbering lv = numbering.getLevelNumbering(paraLevel + 1);
            return numberText(lv, paraNumber, paraLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

 */
    }

    private String numbering(int paraHeadID, byte paraLevel) {
        Numbering numbering = hwpFile.getDocInfo().getNumberingList().get(paraHeadID - 1);

        LevelNumbering lv;
        try {
            lv = numbering.getLevelNumbering(paraLevel + 1);
        } catch (Exception e) {
            e.printStackTrace();
            lv = null;
        }

        if (lv != null) {
            if (paraNumber.changedParaHead(paraHeadID)) {
                paraNumber.reset(paraHeadID, paraLevel, (int) lv.getStartNumber());
            } else {
                paraNumber.increase(paraLevel);
            }

            return numberText(lv, paraNumber, paraLevel);
        } else {
            return null;
        }
    }

    private String numberText(LevelNumbering lv, ParaNumber paraNumber, int paraLevel) {
        String format = lv.getNumberFormat().toUTF16LEString();
        String[] tokens = new String[10];
        String[] values = new String[10];
        for (int level = 0; level <= paraLevel; level++) {
            tokens[level] = "^" + (level + 1);
            values[level] = ParaHeadNumber.toString(paraNumber.value(level), lv.getParagraphHeadInfo().getProperty().getParagraphNumberFormat());
        }
        return StringUtil.replaceEach(format, tokens, values);
    }

    private String bullet(int paraHeadId, byte paraLevel) {
        if (paraHeadId > 0) {
            Bullet bullet = hwpFile.getDocInfo().getBulletList().get(paraHeadId - 1);
            return bullet.getBulletChar().toUTF16LEString();
        } else {
            return "●";
        }
    }
}

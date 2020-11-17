package kr.dogfoot.hwplib.writer.autosetter;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.header.ControlMask;
import kr.dogfoot.hwplib.object.bodytext.paragraph.header.ParaHeader;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.writer.autosetter.control.ForControl;

/**
 * 문단 객체를 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForParagraph {
    /**
     * 문단 객체를 자동 설정한다.
     *
     * @param p          문단 객체
     * @param lastInList 리스트의 마지막 인지 여부
     * @param iid        인스턴스 id
     */
    public static void autoSet(Paragraph p, boolean lastInList, InstanceID iid) {
        header(p, lastInList);
        controls(p, iid);
    }

    /**
     * 문단 헤더 레코드를 자동 설정한다.
     *
     * @param p          문단 객체
     * @param lastInList 리스트의 마지막 인지 여부
     */
    private static void header(Paragraph p, boolean lastInList) {
        ParaHeader h = p.getHeader();

        h.setLastInList(lastInList);
        setCharacterCount(h, p.getText());
        setControlMask(h.getControlMask(), p.getText());
        if (p.getCharShape() != null) {
            h.setCharShapeCount(p.getCharShape().getPositonShapeIdPairList()
                    .size());
        } else {
            h.setCharShapeCount(0);
        }
        if (p.getRangeTag() != null) {
            h.setRangeTagCount(p.getRangeTag().getRangeTagItemList().size());
        } else {
            h.setRangeTagCount(0);
        }
        if (p.getLineSeg() != null) {
            h.setLineAlignCount(p.getLineSeg().getLineSegItemList().size());
        } else {
            h.setLineAlignCount(0);
        }
        h.setInstanceID(0);
    }

    /**
     * 문단 헤더 레코드의 문자 개수를 자동 설정한다.
     *
     * @param h 문단 헤더 레코드
     * @param t 문단 텍스트 레코드
     */
    private static void setCharacterCount(ParaHeader h, ParaText t) {
        if (t != null) {
            int charCount = 0;
            for (HWPChar ch : t.getCharList()) {
                switch (ch.getType()) {
                    case Normal:
                        charCount += 1;
                        break;
                    case ControlChar:
                        charCount += 1;
                        break;
                    case ControlExtend:
                        charCount += 8;
                        break;
                    case ControlInline:
                        charCount += 8;
                        break;
                }
            }
            h.setCharacterCount(charCount);
        } else {
            h.setCharacterCount(1);
        }
    }

    /**
     * 문단 헤더 레코드의 Control Mask 부분을 자동 설정한다.
     *
     * @param cm 문단 헤더 레코드의 Control Mask
     * @param t  문단 텍스트 레코드
     */
    private static void setControlMask(ControlMask cm, ParaText t) {
        cm.setValue(0);
        if (t == null) {
            return;
        }

        for (HWPChar ch : t.getCharList()) {
            switch (ch.getCode()) {
                case 2:
                    cm.setHasSectColDef(true);
                    break;
                case 3:
                    cm.setHasFieldStart(true);
                    break;
                case 4:
                    cm.setHasFieldEnd(true);
                    break;
                case 8:
                    cm.setHasTitleMark(true);
                case 9:
                    cm.setHasTab(true);
                    break;
                case 10:
                    cm.setHasLineBreak(true);
                    break;
                case 11:
                case 13:
                    cm.setHasGsoTable(true);
                    break;
                case 15:
                    cm.setHasHiddenComment(true);
                    break;
                case 16:
                    cm.setHasHeaderFooter(true);
                    break;
                case 17:
                    cm.setHasFootnoteEndnote(true);
                    break;
                case 18:
                    cm.setHasAutoNumber(true);
                    break;
                case 21:
                    cm.setHasPageControl(true);
                    break;
                case 22:
                    cm.setHasBookmark(true);
                    break;
                case 23:
                    cm.setHasAdditionalTextOverlappingLetter(true);
                    break;
                case 24:
                    cm.setHasHyphen(true);
                    break;
                case 30:
                    cm.setHasBundleBlank(true);
                    break;
                case 31:
                    cm.setHasFixWidthBlank(true);
                    break;
            }
        }
    }

    /**
     * 문단에 포함된 컨트롤들을 자동 설정한다.
     *
     * @param p   문단
     * @param iid 인스턴스 id
     */
    private static void controls(Paragraph p, InstanceID iid) {
        if (p.getControlList() == null) {
            return;
        }

        for (Control c : p.getControlList()) {
            ForControl.autoSet(c, iid);
        }
    }
}

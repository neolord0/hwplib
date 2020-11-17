package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.paragraph.text.*;


/**
 * Paragraph의 ParaText객체를 복사하는 기능을 포함하는 클래스.
 *
 * @author neolord
 */
public class ParaTextCopier {
    public static void copy(ParaText source, ParaText target) throws Exception {
        for (HWPChar hwpChar : source.getCharList()) {
            switch (hwpChar.getType()) {
                case Normal:
                    copyNormalChar((HWPCharNormal) hwpChar, target.addNewNormalChar());
                    break;
                case ControlChar:
                    copyControlChar((HWPCharControlChar) hwpChar, target.addNewCharControlChar());
                    break;
                case ControlInline:
                    copyInlineChar((HWPCharControlInline) hwpChar, target.addNewInlineControlChar());
                    break;
                case ControlExtend:
                    if (((HWPCharControlExtend) hwpChar).isTable() ||
                            ((HWPCharControlExtend) hwpChar).isGSO()) {
                        copyExtendChar((HWPCharControlExtend) hwpChar, target.addNewExtendControlChar());
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private static void copyNormalChar(HWPCharNormal source, HWPCharNormal target) {
        target.setCode(source.getCode());
    }

    private static void copyControlChar(HWPCharControlChar source, HWPCharControlChar target) {
        target.setCode(source.getCode());
    }

    private static void copyInlineChar(HWPCharControlInline source, HWPCharControlInline target) throws Exception {
        target.setCode(source.getCode());
        target.setAddition(clonedArray(source.getAddition()));
    }

    private static byte[] clonedArray(byte[] source) {
        byte[] target = new byte[source.length];
        System.arraycopy(source, 0, target, 0, source.length);
        return target;
    }

    private static void copyExtendChar(HWPCharControlExtend source, HWPCharControlExtend target) throws Exception {
        target.setCode(source.getCode());
        target.setAddition(clonedArray(source.getAddition()));
    }
}

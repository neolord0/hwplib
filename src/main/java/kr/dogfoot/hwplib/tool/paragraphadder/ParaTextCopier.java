package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.paragraph.text.*;


/**
 * Paragraph의 ParaText객체를 복사하는 기능을 포함하는 클래스.
 *
 * @author neolord
 */
public class ParaTextCopier {
    public static boolean copy(ParaText source, ParaText target, boolean includingSectionDefine) throws Exception {
        boolean excludedSectionDefine = false;
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
                    HWPCharControlExtend ec = (HWPCharControlExtend) hwpChar;
                    if (includingSectionDefine) {
                        copyExtendChar(ec, target.addNewExtendControlChar());
                    } else {
                        if (notSectionDefine(ec)) {
                            copyExtendChar(ec, target.addNewExtendControlChar());
                        } else {
                            excludedSectionDefine = true;
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        return excludedSectionDefine;
    }

    private static boolean notSectionDefine(HWPCharControlExtend ec) {
        if (ec.isColumnDefine() ||          // 단 정의
                ec.getCode() == 3 ||        // 필드 시작(누름틀, 하이퍼링크, 블록 책갈피, 표 계산식 ...)
                ec.getCode() == 11 ||       // 그리기 개체/표/수식
                ec.getCode() == 15 ||       // 숨은 설명
                ec.getCode() == 17 ||       // 각주/미주
                ec.getCode() == 18 ||       // 자동번호(각주, 표 등)
                ec.getCode() == 21 ||       // 페이지 컨트롤(감추기,새 번호로 시작 등)
                ec.getCode() == 22 ||       // 책갈피/찾아보기 표식
                ec.getCode() == 23) {       // 덧말/글자 겹침
            return true;
        }
        return false;
    }


    private static void copyNormalChar(HWPCharNormal source, HWPCharNormal target) {
        target.setCode(source.getCode());
    }

    private static void copyControlChar(HWPCharControlChar source, HWPCharControlChar target) {
        target.setCode(source.getCode());
    }

    private static void copyInlineChar(HWPCharControlInline source, HWPCharControlInline target) throws Exception {
        target.setCode(source.getCode());
        target.setAddition(source.getAddition().clone());
    }

    private static void copyExtendChar(HWPCharControlExtend source, HWPCharControlExtend target) throws Exception {
        target.setCode(source.getCode());
        target.setAddition(source.getAddition().clone());
    }
}

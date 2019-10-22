package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.ForGsoControl;

/**
 * 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControl {
    /**
     * 컨트롤을 쓴다.
     *
     * @param c  컨트롤
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(Control c, StreamWriter sw) throws Exception {
        if (ControlType.isField(c.getType().getCtrlId())) {
            ForControlField.write((ControlField) c, sw);
            return;
        }
        switch (c.getType()) {
            case Table: // 표
                ForControlTable.write((ControlTable) c, sw);
                break;
            case Equation: // 수식
                ForControlEquation.write((ControlEquation) c, sw);
                break;
            case SectionDefine: // 구역 정의
                ForControlSectionDefine.write((ControlSectionDefine) c, sw);
                break;
            case ColumnDefine: // 단 정의
                ForControlColumnDefine.write((ControlColumnDefine) c, sw);
                break;
            case Header: // 머리말
                ForControlHeader.write((ControlHeader) c, sw);
                break;
            case Footer: // 꼬리말
                ForControlFooter.write((ControlFooter) c, sw);
                break;
            case Footnote: // 각주
                ForControlFootnote.write((ControlFootnote) c, sw);
                break;
            case Endnote: // 미주
                ForControlEndnote.write((ControlEndnote) c, sw);
                break;
            case AutoNumber: // 자동 번호
                ForControlAutoNumber.write((ControlAutoNumber) c, sw);
                break;
            case NewNumber: // 새 번호 지정
                ForControlNewNumber.write((ControlNewNumber) c, sw);
                break;
            case PageHide: // 감추기
                ForControlPageHide.write((ControlPageHide) c, sw);
                break;
            case PageOddEvenAdjust:
                ForControlPageOddEvenAdjust.write((ControlPageOddEvenAdjust) c, sw);
                break;
            case PageNumberPositon: // 쪽 번호 위치
                ForControlPageNumberPosition.write((ControlPageNumberPosition) c, sw);
                break;
            case IndexMark: // 찾아보기 표식
                ForControlIndexMark.write((ControlIndexMark) c, sw);
                break;
            case Bookmark: // 책갈피
                ForControlBookmark.write((ControlBookmark) c, sw);
                break;
            case OverlappingLetter: // 글자 겹침
                ForControlOverlappingLetter.write((ControlOverlappingLetter) c, sw);
                break;
            case AdditionalText: // 덧말
                ForControlAdditionalText.write((ControlAdditionalText) c, sw);
                break;
            case HiddenComment: // 숨은 설명
                ForControlHiddenComment.write((ControlHiddenComment) c, sw);
                break;
            case Gso:
                ForGsoControl.write((GsoControl) c, sw);
                break;
            default:
                break;
        }
    }
}

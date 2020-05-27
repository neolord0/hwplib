package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.ForControl;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.memo.ForMemo;

/**
 * 문단을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForParagraph {
    /**
     * 문단을 쓴다.
     *
     * @param p  문단
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(Paragraph p, StreamWriter sw) throws Exception {
        ForParaHeader.write(p.getHeader(), sw);

        sw.upRecordLevel();
        if (emptyText(p) == false) {
            ForParaText.write(p, sw);
        }
        ForParaCharShape.write(p.getCharShape(), sw);
        ForParaLineSeq.write(p.getLineSeg(), sw);
        ForParaRangeTag.write(p.getRangeTag(), sw);
        ForMemo.write(p.getMemoList(), sw);
        controls(p, sw);

        sw.downRecordLevel();
    }

    private static boolean emptyText(Paragraph p) {
        if (p.getHeader().getCharacterCount() <= 1) {
            ParaText paraText = p.getText();
            if (paraText == null) {
                return true;
            }

            if (paraText.getCharList().size() <= 1) {
                HWPChar hwpChar = paraText.getCharList().get(0);
                if (hwpChar.getCode() == 0xd) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 문단에 포함된 컨트롤들을 쓴다.
     *
     * @param p  문단
     * @param sw 스트림 라이터
     * @throws Exception
     */
    private static void controls(Paragraph p, StreamWriter sw) throws Exception {
        if (p.getControlList() == null) {
            return;
        }

        for (Control c : p.getControlList()) {
            ForControl.write(c, sw);
        }
    }
}

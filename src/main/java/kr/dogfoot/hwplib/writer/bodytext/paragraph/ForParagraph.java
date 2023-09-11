package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.ForControl;

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

        ForParaText.write(p, sw);
        ForParaCharShape.write(p.getCharShape(), sw);
        ForParaLineSeg.write(p.getLineSeg(), sw);
        ForParaRangeTag.write(p.getRangeTag(), sw);
        controls(p, sw);

        sw.downRecordLevel();
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

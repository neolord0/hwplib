package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

/**
 * 문단 리스트를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForParagraphList {
    /**
     * 문단 리스트를 쓴다.
     *
     * @param pl 문단 리스트
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(ParagraphListInterface pl, StreamWriter sw)
            throws Exception {
        for (Paragraph p : pl) {
            ForParagraph.write(p, sw);
        }
    }
}

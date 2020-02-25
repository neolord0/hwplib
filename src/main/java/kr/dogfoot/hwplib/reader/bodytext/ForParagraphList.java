package kr.dogfoot.hwplib.reader.bodytext;

import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.ForParagraph;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractorListener;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

/**
 * 문단 리스트를 읽는 객체
 *
 * @author neolord
 */
public class ForParagraphList {
    /**
     * 문단 리스트을 읽는다.
     *
     * @param pli 문단 리스트 객체
     * @param sr  스트림 리더
     * @throws Exception
     */
    public static void read(ParagraphListInterface pli, StreamReader sr)
            throws Exception {
        ForParagraph fp = new ForParagraph();
        sr.readRecordHeder();
        while (sr.isEndOfStream() == false) {
            Paragraph para = pli.addNewParagraph();
            fp.read(para, sr);
            if (para.getHeader().isLastInList()) {
                break;
            }
        }
    }

    /**
     * 문단 리스트에서 텍스트를 추출한다.
     * @param sr 스트림 리더
     * @param listener 텍스트 추출 리스너
     * @param tem 추출 방법
     * @throws Exception
     */
    public static void extractText(StreamReader sr, TextExtractorListener listener, TextExtractMethod tem) throws Exception {
        StringBuffer sb = new StringBuffer();

        ForParagraph fp = new ForParagraph();
        sr.readRecordHeder();
        while (sr.isEndOfStream() == false) {
            Paragraph para = new Paragraph();
            fp.read(para, sr);
            if (para.getHeader().isLastInList()) {
                break;
            }

            kr.dogfoot.hwplib.tool.textextractor.ForParagraphList.paragraph(para, tem, sb);
            listener.paragraphText(sb.toString());
            sb.setLength(0);
        }
    }
}

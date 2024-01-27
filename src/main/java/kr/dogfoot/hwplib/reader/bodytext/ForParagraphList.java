package kr.dogfoot.hwplib.reader.bodytext;

import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.ForParagraph;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractOption;
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
        sr.readRecordHeader();
        while (!sr.isEndOfStream()) {
            Paragraph para = pli.addNewParagraph();
            fp.read(para, sr);
            if (para.getHeader().isLastInList()) {
                break;
            }
        }
    }

    /**
     * 문단 리스트에서 텍스트를 추출한다.
     *
     * @param sr       스트림 리더
     * @param listener 텍스트 추출 리스너
     * @param option   옵션
     * @throws Exception
     */
    public static void extractText(StreamReader sr, TextExtractorListener listener, TextExtractOption option) throws Exception {
        StringBuffer sb = new StringBuffer();

        ForParagraph fp = new ForParagraph();
        sr.readRecordHeader();
        while (!sr.isEndOfStream()) {
            Paragraph para = new Paragraph();
            fp.read(para, sr);

            kr.dogfoot.hwplib.tool.textextractor.ForParagraph.extract(para, option, null, sb);
            listener.paragraphText(sb.toString());
            sb.setLength(0);

            if (para.getHeader().isLastInList()) {
                break;
            }
        }
    }
}

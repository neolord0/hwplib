package kr.dogfoot.hwplib.reader.bodytext;

import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.ForParagraph;
import kr.dogfoot.hwplib.util.compoundFile.StreamReader;

/**
 * 문단 리스트를 읽는 객체
 * 
 * @author neolord
 */
public class ForParagraphList {
	/**
	 * 문단 리스트을 읽는다.
	 * 
	 * @param pli
	 *            문단 리스트 객체
	 * @param sr
	 *            스트림 리더
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
}

package kr.dogfoot.hwplib.textextractor;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;

/**
 * 한글 파일에서 텍스트를 추출하는 객체
 * 
 * @author neolord
 */
public class TextExtractor {
	/**
	 * 텍스트틀 추출한다.
	 * 
	 * @param hwpFile
	 *            한글 파일 객체
	 * @param tem
	 *            추출 방법
	 * @return 추출된 문자열
	 */
	public static String extract(HWPFile hwpFile, TextExtractMethod tem) {
		StringBuffer sb = new StringBuffer();
		for (Section s : hwpFile.getBodyText().getSectionList()) {
			ForParagraphList.extract(s.getParagraphList(), tem, sb);
		}
		return sb.toString();
	}
}

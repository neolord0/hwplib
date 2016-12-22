package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.secd;

import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.BatangPageInfo;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.ListHeaderForBatangPage;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;
import kr.dogfoot.hwplib.reader.bodytext.ForParagraphList;
import kr.dogfoot.hwplib.util.compoundFile.StreamReader;

/**
 * 바탕쪽 정보을 읽기 위한 객체
 * 
 * @author neolord
 */
public class ForBatangPageInfo {
	/**
	 * 바탕쪽 정보를 읽는다.
	 * 
	 * @param bpi
	 *            바탕쪽 정보
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	public static void read(BatangPageInfo bpi, StreamReader sr)
			throws Exception {
		listHeader(bpi.getListHeader(), sr);
		paragraphList(bpi.getParagraphList(), sr);
	}

	/**
	 * 바탕쪽의 문단 리스트 헤더 레코드를 읽는다.
	 * 
	 * @param lh
	 *            바탕쪽의 문단 리스트 헤더 레코드
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	private static void listHeader(ListHeaderForBatangPage lh, StreamReader sr)
			throws Exception {
		lh.setParaCount(sr.readSInt4());
		lh.getProperty().setValue(sr.readUInt4());
		lh.setTextWidth(sr.readUInt4());
		lh.setTextHeight(sr.readUInt4());
		sr.skipToEndRecord();
	}

	/**
	 * 문단 리스트를 읽는다.
	 * 
	 * @param paragraphList
	 *            문단 리스트
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	private static void paragraphList(ParagraphList paragraphList,
			StreamReader sr) throws Exception {
		ForParagraphList.read(paragraphList, sr);
	}

}

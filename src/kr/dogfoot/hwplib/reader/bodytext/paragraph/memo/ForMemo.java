package kr.dogfoot.hwplib.reader.bodytext.paragraph.memo;

import kr.dogfoot.hwplib.object.bodytext.paragraph.memo.ListHeaderForMemo;
import kr.dogfoot.hwplib.object.bodytext.paragraph.memo.Memo;
import kr.dogfoot.hwplib.reader.bodytext.ForParagraphList;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

public class ForMemo {
	public static void read(Memo m, StreamReader sr) throws Exception {
		ForMemoList.read(m.getMemoList(), sr);
		listHeader(m.getListHeader(), sr);
		ForParagraphList.read(m.getParagraphList(), sr);
	}

	/**
	 * 바탕쪽의 문단 리스트 헤더 레코드를 읽는다.
	 * 
	 * @param listHeaderForMemo
	 *            바탕쪽의 문단 리스트 헤더 레코드
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	private static void listHeader(ListHeaderForMemo listHeaderForMemo,
			StreamReader sr) throws Exception {
		sr.readRecordHeder();

		listHeaderForMemo.setParaCount(sr.readSInt4());
		listHeaderForMemo.getProperty().setValue(sr.readUInt4());
		listHeaderForMemo.setTextWidth(sr.readUInt4());
		listHeaderForMemo.setTextHeight(sr.readUInt4());
		sr.skipToEndRecord();
	}
}

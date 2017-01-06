package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part;

import java.io.IOException;

import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.ListHeaderForTextBox;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;
import kr.dogfoot.hwplib.reader.bodytext.ForParagraphList;
import kr.dogfoot.hwplib.util.compoundFile.StreamReader;

/**
 * 글상자를 읽는다.
 * 
 * @author neolord
 */
public class ForTextBox {
	/**
	 * 글상자를 읽는다.
	 * 
	 * @param textBox
	 *            글상자
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	public static void read(TextBox textBox, StreamReader sr) throws Exception {
		listHeader(textBox.getListHeader(), sr);
		paragraphList(textBox.getParagraphList(), sr);
	}

	/**
	 * 글상자의 문단 리스트 헤더 레코드를 읽는다.
	 * 
	 * @param lh
	 *            글상자의 문단 리스트 헤더 레코드
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void listHeader(ListHeaderForTextBox lh, StreamReader sr)
			throws IOException {
		lh.setParaCount(sr.readSInt4());
		lh.getProperty().setValue(sr.readUInt4());
		lh.setLeftMargin(sr.readUInt2());
		lh.setRightMargin(sr.readUInt2());
		lh.setTopMargin(sr.readUInt2());
		lh.setBottomMargin(sr.readUInt2());
		lh.setTextWidth(sr.readUInt4());
		unknownBytes(8, sr);
		int temp = sr.readSInt4();
		if (temp == 1) {
			lh.setEditableAtFormMode(true);
		} else {
			lh.setEditableAtFormMode(false);
		}
		short temp2 = sr.readUInt1();
		if (temp2 == 0xff) {
			unknownBytes(10, sr);
			lh.setFieldName(sr.readUTF16LEString());
		}
	}

	/**
	 * 알려지지 않은 n 바이트틀 처리한다.
	 * 
	 * @param n
	 *            알려지지 않은 바이트 개수
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void unknownBytes(int n, StreamReader sr) throws IOException {
		sr.skip(n);
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

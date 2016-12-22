package kr.dogfoot.hwplib.reader.bodytext.paragraph;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharControlExtend;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPCharControlInline;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.util.compoundFile.StreamReader;

/**
 * 문단의 텍스트 레코드를 읽기 위한 객체
 * 
 * @author neolord
 */
public class ForParaText {
	/**
	 * 문단의 텍스트 레코드를 읽는다.
	 * 
	 * @param p
	 *            문단
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	public static void read(Paragraph p, StreamReader sr) throws Exception {
		p.createText();

		long size = p.getHeader().getCharacterCount() * 2;
		long read = 0;
		while (read < size) {
			read += hwpChar(p.getText(), sr);
		}
	}

	/**
	 * HWP문자를 종류에 따라 읽는다.
	 * 
	 * @param paraText
	 *            문단의 텍스트 레코드
	 * @param sr
	 *            스트림 리더
	 * @return 읽은 byte 수
	 * @throws Exception
	 */
	private static int hwpChar(ParaText paraText, StreamReader sr)
			throws Exception {
		short code = sr.readSInt2();
		switch (HWPChar.type(code)) {
		case ControlChar:
			paraText.addNewCharControlChar().setCode(code);
			return 2;
		case ControlExtend:
			extendChar(paraText.addNewExtendControlChar(), sr);
			return 16;
		case ControlInline:
			inlineChar(paraText.addNewInlineControlChar(), sr);
			return 16;
		case Normal:
			paraText.addNewNormalChar().setCh(shortToString(code));
			return 2;
		}
		return 0;
	}

	/**
	 * 2 byte 문자코드를 문자열로 변환한다.
	 * 
	 * @param code
	 *            2 byte 문자코드
	 * @return 변환된 문자열
	 * @throws UnsupportedEncodingException
	 */
	private static String shortToString(short code)
			throws UnsupportedEncodingException {
		byte[] ch = new byte[2];
		ch[0] = (byte) (code & 0xff);
		ch[1] = (byte) ((code >> 8) & 0xff);
		return new String(ch, 0, 2, "UTF-16LE");
	}

	/**
	 * 확장 컨트롤 문자을 읽는다.
	 * 
	 * @param extendChar
	 *            확장 컨트롤 문자
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void extendChar(HWPCharControlExtend extendChar,
			StreamReader sr) throws IOException {
		byte[] addition = new byte[12];
		sr.readBytes(addition);
		extendChar.setInstanceId(makeInstanceId(addition));
		sr.skip(2); // code
	}

	/**
	 * 확장 컨트롤이 가리키는 객체의 인스턴스 아이디를 만든다.
	 * 
	 * @param bytes
	 *            파일에 정장된 바이너리 배열
	 * @return 확장 컨트롤이 가리키는 객체의 인스턴스 아이디
	 */
	private static String makeInstanceId(byte[] bytes) {
		int bufferIndex = 0;
		boolean insert = false;
		byte[] buf = new byte[bytes.length];
		for (int i = bytes.length - 1; i >= 0; i--) {
			if (bytes[i] != 0) {
				insert = true;
			}

			if (insert == true) {
				buf[bufferIndex++] = bytes[i];
			}
		}

		return new String(buf, 0, bufferIndex);
	}

	/**
	 * 인라인 컨트를 문자를 읽는다.
	 * 
	 * @param inlineChar
	 *            인라인 컨트를 문자
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void inlineChar(HWPCharControlInline inlineChar,
			StreamReader sr) throws IOException {
		byte[] addition = new byte[12];
		sr.readBytes(addition);
		inlineChar.setAddition(addition);

		sr.skip(2); // code
	}
}

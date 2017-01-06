package kr.dogfoot.hwplib.reader.docinfo;

import kr.dogfoot.hwplib.object.docinfo.CharShape;
import kr.dogfoot.hwplib.object.docinfo.charshape.CharOffsets;
import kr.dogfoot.hwplib.object.docinfo.charshape.CharSpaces;
import kr.dogfoot.hwplib.object.docinfo.charshape.FaceNameIds;
import kr.dogfoot.hwplib.object.docinfo.charshape.Ratios;
import kr.dogfoot.hwplib.object.docinfo.charshape.RelativeSizes;
import kr.dogfoot.hwplib.util.compoundFile.StreamReader;

/**
 * 글자 모양 레코드를 읽기 위한 객체
 * 
 * @author neolord
 */
public class ForCharShape {
	/**
	 * 글자 모양을 읽는다.
	 * 
	 * @param cs
	 *            글자 모양 레코드
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	public static void read(CharShape cs, StreamReader sr) throws Exception {
		faceNameIds(cs.getFaceNameIds(), sr);
		ratios(cs.getRatios(), sr);
		charSpaces(cs.getCharSpaces(), sr);
		relativeSizes(cs.getRelativeSizes(), sr);
		charPositions(cs.getCharOffsets(), sr);

		cs.setBaseSize(sr.readSInt4());
		cs.getProperty().setValue(sr.readUInt4());
		cs.setShadowGap1(sr.readSInt1());
		cs.setShadowGap2(sr.readSInt1());
		cs.getCharColor().setColor(sr.readUInt4());
		cs.getUnderLineColor().setColor(sr.readUInt4());
		cs.getShadeColor().setColor(sr.readUInt4());
		cs.getShadowColor().setColor(sr.readUInt4());

		if (sr.getFileVersion().isOver(5, 0, 2, 1)) {
			cs.setBorderFillId(sr.readUInt2());
		}
		if (sr.getFileVersion().isOver(5, 0, 3, 0)) {
			cs.getStrikeLineColor().setColor(sr.readUInt4());
		}
	}

	/**
	 * 언어별 글꼴ID 부분을 읽는다.
	 * 
	 * @param fnis
	 *            언어별 글꼴ID 부분을 나타내는 객체
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	private static void faceNameIds(FaceNameIds fnis, StreamReader sr)
			throws Exception {
		int[] array = new int[7];
		for (int i = 0; i < 7; i++) {
			array[i] = sr.readUInt2();
		}
		fnis.setArray(array);
	}

	/**
	 * 언어별 장평 부분을 읽는다.
	 * 
	 * @param rs
	 *            언어별 장평 부분을 나타내는 객체
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	private static void ratios(Ratios rs, StreamReader sr) throws Exception {
		short[] array = new short[7];
		for (int i = 0; i < 7; i++) {
			array[i] = sr.readUInt1();
		}
		rs.setArray(array);
	}

	/**
	 * 언어별 자간 부분을 읽는다.
	 * 
	 * @param css
	 *            언어별 자간 부분을 나타내는 객체
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	private static void charSpaces(CharSpaces css, StreamReader sr)
			throws Exception {
		byte[] array = new byte[7];
		for (int i = 0; i < 7; i++) {
			array[i] = sr.readSInt1();
		}
		css.setArray(array);
	}

	/**
	 * 언어별 상대 크기 부분을 읽는다.
	 * 
	 * @param rss
	 *            언어별 상대 크기을 나타내는 객체
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	private static void relativeSizes(RelativeSizes rss, StreamReader sr)
			throws Exception {
		short[] array = new short[7];
		for (int i = 0; i < 7; i++) {
			array[i] = sr.readUInt1();
		}
		rss.setArray(array);
	}

	/**
	 * 언어별 글자 위치 부분을 읽는다.
	 * 
	 * @param cos
	 *            언어별 글자 위치을 나타내는 객체
	 * @param sr
	 *            스트림 리더
	 * @throws Exception
	 */
	private static void charPositions(CharOffsets cos, StreamReader sr)
			throws Exception {
		byte[] array = new byte[7];
		for (int i = 0; i < 7; i++) {
			array[i] = sr.readSInt1();
		}
		cos.setArray(array);
	}
}

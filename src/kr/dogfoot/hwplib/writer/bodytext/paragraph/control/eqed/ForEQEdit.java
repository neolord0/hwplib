package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.eqed;

import java.io.IOException;

import kr.dogfoot.hwplib.object.bodytext.control.equation.EQEdit;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

/**
 * 수식 정보 레코드를 쓰기 위한 객체
 * 
 * @author neolord
 */
public class ForEQEdit {
	/**
	 * 수식 정보 레코드를 쓴다.
	 * 
	 * @param ee
	 *            수식 정보 레코드
	 * @param sw
	 *            스트림 라이터
	 * @throws IOException
	 */
	public static void write(EQEdit ee, StreamWriter sw) throws IOException {
		recordHeader(ee, sw);

		sw.writeUInt4(ee.getProperty());
		sw.writeUTF16LEString(ee.getScript());
		sw.writeUInt4(ee.getLetterSize());
		sw.writeUInt4(ee.getLetterColor().getValue());
		sw.writeSInt2(ee.getBaseLine());
		sw.writeZero(2);
		sw.writeUTF16LEString(ee.getVersionInfo());
		if (ee.getEtcInfo() != null && ee.getEtcInfo().length() != 0) {
			sw.writeUTF16LEString(ee.getEtcInfo());
		}
	}

	/**
	 * 수식 정보 레코드의 레코드 헤더를 쓴다.
	 * 
	 * @param ee
	 *            수식 정보 레코드
	 * @param sw
	 *            스트림 라이터
	 * @throws IOException
	 */
	private static void recordHeader(EQEdit ee, StreamWriter sw)
			throws IOException {
		sw.writeRecordHeader(HWPTag.EQEDIT, getSize(ee));
	}

	/**
	 * 수식 정보 레코드의 크기를 반환한다.
	 * 
	 * @param ee
	 *            수식 정보 레코드
	 * @return 수식 정보 레코드의 크기
	 */
	private static int getSize(EQEdit ee) {
		int size = 0;
		size += 4;
		size += StringUtil.getUTF16LEStringSize(ee.getScript());
		size += 12;
		size += StringUtil.getUTF16LEStringSize(ee.getVersionInfo());
		if (ee.getEtcInfo() != null && ee.getEtcInfo().length() != 0) {
			size += StringUtil.getUTF16LEStringSize(ee.getEtcInfo());
		}
		return size;
	}
}

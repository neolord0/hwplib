package kr.dogfoot.hwplib.reader.bodytext.paragraph.control;

import java.io.IOException;

import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderField;
import kr.dogfoot.hwplib.util.compoundFile.StreamReader;

/**
 * 필드 컨트롤을 읽기 위한 객체
 * 
 * @author neolord
 */
public class ForControlField {
	/**
	 * 필드 컨트롤을 읽는다.
	 * 
	 * @param field
	 *            필드 컨트롤
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	public static void read(ControlField field, StreamReader sr)
			throws IOException {
		ctrlHeader(field.getHeader(), sr);
	}

	/**
	 * 필드 컨트롤의 컨트롤 헤더 레코드을 읽는다.
	 * 
	 * @param h
	 *            필드 컨트롤의 컨트롤 헤더
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void ctrlHeader(CtrlHeaderField h, StreamReader sr)
			throws IOException {
		h.getProperty().setValue(sr.readUInt4());
		h.setEtcProperty(sr.readUInt1());
		h.setCommand(sr.readUTF16LEString());
		h.setInstanceId(sr.readUInt4());

		unknown4Bytes(sr);
	}

	/**
	 * 알려지지 않은 4 byte을 처리한다.
	 * 
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void unknown4Bytes(StreamReader sr) throws IOException {
		sr.skip(4);
	}
}

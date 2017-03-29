package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.bookmark;

import java.io.IOException;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.CtrlData;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterItem;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterSet;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterType;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

/**
 * 임의 데이타 객체를 읽기 위한 객체
 * 
 * @author neolord
 */
public class ForCtrlData {
	/**
	 * 임의 데이터 객체를 읽는다.
	 * 
	 * @param cd
	 *            임의 데이터 객체
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	public static void read(CtrlData cd, StreamReader sr) throws IOException {
		parameterSet(cd.getParameterSet(), sr);
	}

	/**
	 * 파라메터 셋을 읽는다.
	 * 
	 * @param ps
	 *            파라메터 셋
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void parameterSet(ParameterSet ps, StreamReader sr)
			throws IOException {
		ps.setId(sr.readUInt2());
		short parameterCount = sr.readSInt2();
		sr.skip(2);

		for (int parameterIndex = 0; parameterIndex < parameterCount; parameterIndex++) {
			ParameterItem pi = ps.addNewParameterItem();
			parameterItem(pi, sr);
		}
	}

	/**
	 * 파라메터 아이템을 읽는다.
	 * 
	 * @param pi
	 *            파라메터 아이템
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void parameterItem(ParameterItem pi, StreamReader sr)
			throws IOException {
		pi.setId(sr.readUInt2());
		pi.setType(ParameterType.valueOf(sr.readUInt2()));
		paramterValue(pi, sr);
	}

	/**
	 * 파라메터 아이템의 값을 읽는다.
	 * 
	 * @param pi
	 *            파라메터 아이템
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void paramterValue(ParameterItem pi, StreamReader sr)
			throws IOException {
		switch (pi.getType()) {
		case NULL:
			break;
		case String:
			pi.setValue_BSTR(sr.readUTF16LEString());
			break;
		case Integer1:
			pi.setValue_I1(sr.readSInt1());
			break;
		case Integer2:
			pi.setValue_I2(sr.readSInt2());
			break;
		case Integer4:
			pi.setValue_I4(sr.readSInt4());
			break;
		case Integer:
			pi.setValue_I(sr.readSInt4());
			break;
		case UnsignedInteger1:
			pi.setValue_UI1(sr.readUInt1());
			break;
		case UnsignedInteger2:
			pi.setValue_UI2(sr.readUInt2());
			break;
		case UnsignedInteger4:
			pi.setValue_UI4(sr.readUInt4());
			break;
		case UnsignedInteger:
			pi.setValue_UI(sr.readUInt4());
			break;
		case ParameterSet:
			parameterSet(pi.getValue_ParameterSet(), sr);
			break;
		case Array:
			parameterArray(pi, sr);
			break;
		case BINDataID:
			pi.setValue_binData(sr.readUInt2());
			break;

		}
	}

	/**
	 * 배열 타입의 파라메터 아이템값을 읽는다.
	 * 
	 * @param pi
	 *            파라메터 아이템
	 * @param sr
	 *            스트림 리더
	 * @throws IOException
	 */
	private static void parameterArray(ParameterItem pi, StreamReader sr)
			throws IOException {
		short count = sr.readSInt2();
		pi.createValue_ParameterArray(count);
		for (int index = 0; index < count; index++) {
			parameterItem(pi.getValue_ParameterArray(index), sr);
		}

	}

}

package kr.dogfoot.hwplib.util;

public class StringUtil {
	/**
	 * 문자열(UTF-16LE)이 저장될 때 필요한 byte의 개수를 반환한다.
	 * 
	 * @param s
	 *            문자열
	 * @return 문자열(UTF-16LE)이 저장될 때 필요한 byte의 개수
	 */
	public static int getUTF16LEStringSize(String s) {
		if (s == null) {
			return 2;
		} else {
			return 2 + s.length() * 2;
		}
	}
}

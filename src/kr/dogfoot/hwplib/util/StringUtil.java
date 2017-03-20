package kr.dogfoot.hwplib.util;

public class StringUtil {
	public static int getUTF16LEStringSize(String s) {
		return 2 + s.length() * 2;
	}
}

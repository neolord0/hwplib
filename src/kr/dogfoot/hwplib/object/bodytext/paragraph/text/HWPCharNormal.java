package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

/**
 * 일반 Character
 * 
 * @author neolord
 */
public class HWPCharNormal extends HWPChar {
	/**
	 * 글자
	 */
	private String ch;

	/**
	 * 생성자
	 */
	public HWPCharNormal() {
	}

	@Override
	public HWPCharType getType() {
		return HWPCharType.Normal;
	}

	/**
	 * 글자를 반환한다.
	 * 
	 * @return 글자
	 */
	public String getCh() {
		return ch;
	}

	/**
	 * 글자를 설정한다.
	 * 
	 * @param ch
	 *            글자
	 * @throws Exception
	 *             ch의 길이가 1이 아닐 때 발생
	 */
	public void setCh(String ch) throws Exception {
		if (ch.length() != 1) {
			throw new Exception("ch's length must be 1");
		}
		this.ch = ch;
	}
}

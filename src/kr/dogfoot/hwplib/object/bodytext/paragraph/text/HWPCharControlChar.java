package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

/**
 * 문자 컨트롤 Character
 * 
 * @author neolord
 */
public class HWPCharControlChar extends HWPChar {
	/**
	 * 믄자 코드
	 */
	private int code;

	/**
	 * 생성자
	 */
	public HWPCharControlChar() {
	}

	@Override
	public HWPCharType getType() {
		return HWPCharType.ControlChar;
	}

	/**
	 * 문자 코드를 반환한다.
	 * 
	 * @return 문자 코드
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 문자 코드를 설정한다.
	 * 
	 * @param code
	 *            문자 코드
	 */
	public void setCode(int code) {
		this.code = code;
	}
}

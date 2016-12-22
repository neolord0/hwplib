package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

/**
 * 인라인 컨트롤 character
 * 
 * @author neolord
 */
public class HWPCharControlInline extends HWPChar {
	/**
	 * 믄지 코드
	 */
	private int code;
	/**
	 * 추가 정보
	 */
	private byte[] addition;

	/**
	 * 생성자
	 */
	public HWPCharControlInline() {
	}

	@Override
	public HWPCharType getType() {
		return HWPCharType.ControlInline;
	}

	/**
	 * 믄지 코드를 반환한다.
	 * 
	 * @return 믄지 코드
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 믄지 코드를 설정한다.
	 * 
	 * @param code
	 *            믄지 코드
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 추가 정보를 반환한다.
	 * 
	 * @return 추가 정보
	 */
	public byte[] getAddition() {
		return addition;
	}

	/**
	 * 추가 정보를 설정한다.
	 * 
	 * @param addition
	 *            추가 정보
	 */
	public void setAddition(byte[] addition) {
		this.addition = addition;
	}
}

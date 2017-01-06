package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

/**
 * 확장 컨트롤 Character
 * 
 * @author neolord
 */
public class HWPCharControlExtend extends HWPChar {
	/**
	 * 문자 코드
	 */
	private int code;
	/**
	 * 컨트롤 객체의 Instance Id
	 */
	private String instanceId;

	/**
	 * 생성자
	 */
	public HWPCharControlExtend() {
	}

	@Override
	public HWPCharType getType() {
		return HWPCharType.ControlExtend;
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

	/**
	 * 컨트롤 객체의 Instance Id를 반환한다.
	 * 
	 * @return 컨트롤 객체의 Instance Id
	 */
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * 컨트롤 객체의 Instance Id를 설정한다.
	 * 
	 * @param instanceId
	 *            컨트롤 객체의 Instance Id
	 */
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
}

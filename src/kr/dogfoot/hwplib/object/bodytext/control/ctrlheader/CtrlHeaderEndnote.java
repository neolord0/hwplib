package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;

/**
 * 미주(End Note) 컨트롤을 위한 컨트롤 헤더 레코드
 * 
 * @author neolord
 */
public class CtrlHeaderEndnote extends CtrlHeader {
	/**
	 * 미주 번호 ??
	 */
	private long number;

	/**
	 * 생성자
	 */
	public CtrlHeaderEndnote() {
		super(ControlType.Endnote.getCtrlId());
	}

	/**
	 * 미주 번호를 반환한다.
	 * 
	 * @return 미주 번호
	 */
	public long getNumber() {
		return number;
	}

	/**
	 * 미주 번호를 설정한다.
	 * 
	 * @param number
	 *            미주 번호
	 */
	public void setNumber(long number) {
		this.number = number;
	}
}

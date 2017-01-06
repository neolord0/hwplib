package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeader;

/**
 * 컨트롤에 대한 추상 객체
 * 
 * @author neolord
 */
public abstract class Control {
	/**
	 * 컨트롤 헤더 객체
	 */
	protected CtrlHeader header;

	/**
	 * 생성자
	 * 
	 * @param header
	 *            컨트롤 헤더 객체
	 */
	public Control(CtrlHeader header) {
		this.header = header;
	}

	/**
	 * 컨트롤 헤더 객체를 반환한다.
	 * 
	 * @return 컨트롤 헤더 객체
	 */
	public ControlType getType() {
		return ControlType.ctrlIdOf(header.getCtrlId());
	}
}

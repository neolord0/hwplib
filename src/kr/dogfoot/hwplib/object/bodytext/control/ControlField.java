package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderField;

/**
 * 필드 컨트롤
 * 
 * @author neolord
 */
public class ControlField extends Control {
	/**
	 * 생성자
	 */
	public ControlField() {
		super(new CtrlHeaderField());
	}

	/**
	 * 생성자
	 * 
	 * @param ctrlId
	 *            : ctrl header의 ctrl-id.
	 */
	public ControlField(long ctrlId) {
		super(new CtrlHeaderField(ctrlId));
	}

	/**
	 * 필드용 컨트롤 헤더를 반환한다.
	 * 
	 * @return 필드용 컨트롤 헤더
	 */
	public CtrlHeaderField getHeader() {
		return (CtrlHeaderField) header;
	}
}

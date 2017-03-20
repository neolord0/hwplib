package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

/**
 * 문자 컨트롤 Character
 * 
 * @author neolord
 */
public class HWPCharControlChar extends HWPChar {
	/**
	 * 생성자
	 */
	public HWPCharControlChar() {
	}

	@Override
	public HWPCharType getType() {
		return HWPCharType.ControlChar;
	}
}

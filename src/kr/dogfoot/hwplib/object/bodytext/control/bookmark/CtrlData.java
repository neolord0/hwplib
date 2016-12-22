package kr.dogfoot.hwplib.object.bodytext.control.bookmark;

/**
 * 북마크의 임의 데이터 레코드
 * 
 * @author neolord
 */
public class CtrlData {
	/**
	 * 임의 데이타
	 */
	private byte[] data;

	/**
	 * 생성자
	 */
	public CtrlData() {
	}

	/**
	 * 임의 데이터를 반환한다.
	 * 
	 * @return 임의 데이터
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * 임의 데이터를 설정한다.
	 * 
	 * @param data
	 *            임의 데이터
	 */
	public void setData(byte[] data) {
		this.data = data;
	}
}

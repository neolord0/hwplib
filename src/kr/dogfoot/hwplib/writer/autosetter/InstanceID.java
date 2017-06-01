package kr.dogfoot.hwplib.writer.autosetter;

/**
 * 인스턴스 id을 구하기 위한 객체
 * 
 * @author neolord
 */
public class InstanceID {
	private long id;

	public InstanceID() {
		id = 0;
	}
	/**
	 * 인스턴스 id을 반환한다.
	 * 
	 * @return 인스턴스 id
	 */
	public long get() {
		return id++;
	}
}

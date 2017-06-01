package kr.dogfoot.hwplib.object.docinfo;

import java.util.ArrayList;

import kr.dogfoot.hwplib.object.docinfo.numbering.LevelNumbering;

/**
 * 문단 번호  레코드
 * 
 * @author neolord
 */
public class Numbering {
	/**
	 * 수준(1～7)에 해당하는 문단 번호 정보 객체의 리스트
	 */
	private ArrayList<LevelNumbering> levelNumberingList;
	/**
	 * 시작 번호
	 */
	private int startNumber;
	/**
	 * 수준별 시작번호 (5.0.2.5 이상)
	 */
	private long[] startNumbersForLevel;

	/**
	 * 생성자
	 */
	public Numbering() {
		createLevelNumberings();
		startNumbersForLevel = new long[7];
	}

	/**
	 * 수준(1～7)에 해당하는 문단 번호 정보 객체를 생성한다.
	 */
	private void createLevelNumberings() {
		levelNumberingList = new ArrayList<LevelNumbering>();
		for (int index = 0; index < 7; index++) {
			LevelNumbering ln = new LevelNumbering();
			levelNumberingList.add(ln);
		}
	}

	/**
	 * level에 해당하는 문단 번호 정보 객체를 반환한다.
	 * 
	 * @param level
	 *            문단 번호 정보 객체를 얻고자 하는 수준(1~7)
	 * @return level에 해당하는 문단 번호 정보 객체
	 * @throws Exception
	 *             (level <1 || level>7) 일떼 발샐한다.
	 */
	public LevelNumbering getLevelNumbering(int level) throws Exception {
		if (level >= 1 && level <= 7) {
			return levelNumberingList.get(level - 1);
		} else {
			throw new Exception("invalid level : " + level);
		}
	}

	/**
	 * 시작 번호를 반환한다.
	 * 
	 * @return 시작 번호
	 */
	public int getStartNumber() {
		return startNumber;
	}

	/**
	 * 시작 번호를 설정한다.
	 * 
	 * @param startNumber 시작 번호
	 */
	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	/**
	 * 수준별 시작번호를 반환한다.
	 * 
	 * @param level
	 *            시작번호를 얻고자 하는 수준
	 * @return 시작번호
	 * @throws Exception
	 *             (level <1 || level>7) 일떼 발샐한다.
	 */
	public long getStartNumberForLevel(int level) throws Exception {
		if (level >= 1 && level <= 7) {
			return startNumbersForLevel[level - 1];
		} else {
			throw new Exception("invalid level : " + level);
		}
	}

	/**
	 * 수준별 시작번호를 설정한한다.
	 * 
	 * @param startNumber
	 *            수준의 시작번호
	 * @param level
	 *            시작번호를 설정하고자 하는 수준
	 * @throws Exception
	 *             (level <1 || level>7) 일떼 발샐한다.
	 */
	public void setStartNumberForLevel(long startNumber, int level)
			throws Exception {
		if (level >= 1 && level <= 7) {
			startNumbersForLevel[level - 1] = startNumber;
		} else {
			throw new Exception("invalid level : " + level);
		}
	}
}

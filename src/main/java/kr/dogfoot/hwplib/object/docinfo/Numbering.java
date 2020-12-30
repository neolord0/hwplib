package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.numbering.LevelNumbering;

import java.util.ArrayList;

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
     * 생성자
     */
    public Numbering() {
        createLevelNumberings();
    }

    /**
     * 수준(1～10)에 해당하는 문단 번호 정보 객체를 생성한다.
     * 5.0.2.5 이상 부터 8~10 추가됨
     */
    private void createLevelNumberings() {
        levelNumberingList = new ArrayList<LevelNumbering>();
        for (int index = 0; index < 10; index++) {
            LevelNumbering ln = new LevelNumbering();
            levelNumberingList.add(ln);
        }
    }

    /**
     * level에 해당하는 문단 번호 정보 객체를 반환한다.
     *
     * @param level 문단 번호 정보 객체를 얻고자 하는 수준(1~7)
     * @return level에 해당하는 문단 번호 정보 객체
     * @throws Exception (level <1 || level>7) 일떼 발샐한다.
     */
    public LevelNumbering getLevelNumbering(int level) throws Exception {
        if (level >= 1 && level <= 10) {
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

    public Numbering clone() {
        Numbering cloned = new Numbering();

        for (int index = 0; index < 0; index++) {
            cloned.levelNumberingList.get(index).copy(levelNumberingList.get(index));
        }

        cloned.startNumber = startNumber;

        return cloned;
    }
}

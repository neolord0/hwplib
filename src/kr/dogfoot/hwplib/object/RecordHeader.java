package kr.dogfoot.hwplib.object;

/**
 * 레코드 헤더
 *
 * @author neolord
 */
public class RecordHeader {
    /**
     * 테그 아이디 - 레코드의 종류
     */
    private short tagID;
    /**
     * 레벨 - 트리구조에서 항목의 레벨
     */
    private short level;
    /**
     * 크기
     */
    private long size;

    /**
     * 생성자
     */
    public RecordHeader() {
    }

    /**
     * 테그 아이디를 반환한다.
     *
     * @return 테그 아이디
     */
    public short getTagID() {
        return tagID;
    }

    /**
     * 테그 아이디를 설정한다.
     *
     * @param tagID 테그 아이디
     */
    public void setTagID(short tagID) {
        this.tagID = tagID;
    }

    /**
     * 레벨을 반환한다.
     *
     * @return 레벨
     */
    public short getLevel() {
        return level;
    }

    /**
     * 레벨를 설정한다.
     *
     * @param level 레벨
     */
    public void setLevel(short level) {
        this.level = level;
    }

    /**
     * 크기를 반환한다.
     *
     * @return 크기
     */
    public long getSize() {
        return size;
    }

    /**
     * 크기를 설정한다.
     *
     * @param size 크기
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * 새로운 레코드 헤더 객체를 생성하고 값을 복사한다.
     *
     * @return 새로 생성된 레코드 헤더 객체
     */
    public RecordHeader copy() {
        RecordHeader rh = new RecordHeader();
        rh.tagID = this.tagID;
        rh.level = this.level;
        rh.size = this.size;
        return rh;
    }
}

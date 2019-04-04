package kr.dogfoot.hwplib.writer.autosetter;

/**
 * 인스턴스 id을 구하기 위한 객체
 *
 * @author neolord
 */
public class InstanceID {
    private static final int START_OBJECT_ID = 0x5bb840e1;

    private long id;

    public InstanceID() {
        id = START_OBJECT_ID;
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

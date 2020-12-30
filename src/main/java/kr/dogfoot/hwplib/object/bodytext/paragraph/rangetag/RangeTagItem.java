package kr.dogfoot.hwplib.object.bodytext.paragraph.rangetag;

/**
 * 영역 태그 정보에 대한 객체
 *
 * @author neolord
 */
public class RangeTagItem {
    /**
     * 영역 시작
     */
    private long rangeStart;
    /**
     * 영역 끝
     */
    private long rangeEnd;
    /**
     * 태그 종류
     */
    private short sort;
    /**
     * 태그 데이타 (3byte)
     */
    private byte[] data;

    /**
     * 생성자
     */
    public RangeTagItem() {
    }

    /**
     * 영역 시작을 반환한다.
     *
     * @return 영역 시작
     */
    public long getRangeStart() {
        return rangeStart;
    }

    /**
     * 영역 시작을 설정한다.
     *
     * @param rangeStart 영역 시작
     */
    public void setRangeStart(long rangeStart) {
        this.rangeStart = rangeStart;
    }

    /**
     * 영역 끝을 반환한다.
     *
     * @return 영역 끝
     */
    public long getRangeEnd() {
        return rangeEnd;
    }

    /**
     * 영역 끝을 설정한다.
     *
     * @param rangeEnd 영역 끝
     */
    public void setRangeEnd(long rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    /**
     * 태그 종류를 반환한다.
     *
     * @return 태그 종류
     */
    public short getSort() {
        return sort;
    }

    /**
     * 태그 종류를 설정한다.
     *
     * @param sort 태그 종류
     */
    public void setSort(short sort) {
        this.sort = sort;
    }

    /**
     * 태그 데이타를 반환한다.
     *
     * @return 태그 데이타
     */
    public byte[] getData() {
        return data;
    }

    /**
     * 태그 데이타를 설정한다.
     *
     * @param data 태그 데이타
     * @throws Exception 태그 데이타가 3 bytes가 아닐 때.
     */
    public void setData(byte[] data) throws Exception {
        if (data.length != 3) {
            throw new Exception("data must be 3 bytes.");
        }
        this.data = data;
    }

    public RangeTagItem clone() {
        RangeTagItem cloned = new RangeTagItem();
        cloned.rangeStart = rangeStart;
        cloned.rangeEnd = rangeEnd;
        cloned.sort = sort;
        if (data != null) {
            cloned.data = data.clone();
        } else {
            cloned.data = null;
        }
        return cloned;
    }
}

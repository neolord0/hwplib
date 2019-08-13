package kr.dogfoot.hwplib.object.bodytext.paragraph.memo;

/**
 * 메모 리스트 레코드
 *
 * @author neolord
 */
public class MemoList {
    /**
     * 메모 인덱스
     */
    private long memoIndex;

    /**
     * 생성자
     */
    public MemoList() {
        memoIndex = 0;
    }

    /**
     * 메모 인덱스를 반환한다.
     *
     * @return 메모 인덱스
     */
    public long getMemoIndex() {
        return memoIndex;
    }

    /**
     * 메모 인덱스를 설정한다.
     *
     * @param memoIndex 메모 인덱스
     */
    public void setMemoIndex(long memoIndex) {
        this.memoIndex = memoIndex;
    }
}

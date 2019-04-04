package kr.dogfoot.hwplib.object.bodytext.paragraph.memo;

import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;

public class Memo {
    /**
     * 메모 리스트 레코드
     */
    private MemoList memoList;
    /**
     * 메모를 위한 리스트 헤더 레코드
     */
    private ListHeaderForMemo listHeader;
    /**
     * 문단 리스트
     */
    private ParagraphList paragraphList;

    /**
     * 생성자
     */
    public Memo() {
        memoList = new MemoList();
        listHeader = new ListHeaderForMemo();
        paragraphList = new ParagraphList();
    }

    /**
     * 메모 리스트 레코드를 반환한다.
     *
     * @return 메모 리스트 레코드
     */
    public MemoList getMemoList() {
        return memoList;
    }

    /**
     * 메모를 위한 리스트 헤더 레코드를 반환한다.
     *
     * @return 메모를 위한 리스트 헤더 레코드
     */
    public ListHeaderForMemo getListHeader() {
        return listHeader;
    }

    /**
     * 문단 리스트를 반환한다.
     *
     * @return 문단 리스트
     */
    public ParagraphList getParagraphList() {
        return paragraphList;
    }
}

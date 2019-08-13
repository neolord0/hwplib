package kr.dogfoot.hwplib.object.docinfo.tabdef;

import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;

/**
 * 탭 정보에 대한 객체
 *
 * @author neolord
 */
public class TabInfo {
    /**
     * 탭의 위치
     */
    private long position;
    /**
     * 탭의 종류
     */
    private TabSort tabSort;
    /**
     * 채움 종류
     */
    private BorderType fillSort;

    /**
     * 생성자
     */
    public TabInfo() {
    }

    /**
     * 탭의 위치를 반환한다.
     *
     * @return 탭의 위치
     */
    public long getPosition() {
        return position;
    }

    /**
     * 탭의 위치를 설정한다.
     *
     * @param position 탭의 위치
     */
    public void setPosition(long position) {
        this.position = position;
    }

    /**
     * 탭의 종류를 반환한다.
     *
     * @return 탭의 종류
     */
    public TabSort getTabSort() {
        return tabSort;
    }

    /**
     * 탭의 종류를 설정한다.
     *
     * @param tabSort 탭의 종류
     */
    public void setTabSort(TabSort tabSort) {
        this.tabSort = tabSort;
    }

    /**
     * 채움 종류를 반환한다.
     *
     * @return 채움 종류
     */
    public BorderType getFillSort() {
        return fillSort;
    }

    /**
     * 채움 종류를 설정한다.
     *
     * @param fillSort 채움 종류
     */
    public void setFillSort(BorderType fillSort) {
        this.fillSort = fillSort;
    }
}

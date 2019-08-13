package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

/**
 * 쪽 테두리/배경 정보에 대한 레코드
 *
 * @author neolord
 */
public class PageBorderFill {
    /**
     * 속성
     */
    private PageBorderFillProperty property;
    /**
     * 테두리/배경 위치 왼쪽 간격
     */
    private int leftGap;
    /**
     * 테두리/배경 위치 오른쪽 간격
     */
    private int rightGap;
    /**
     * 테두리/배경 위치 위쪽 간격
     */
    private int topGap;
    /**
     * 테두리/배경 위치 아래쪽 간격
     */
    private int bottomGap;
    /**
     * 참조된 테두리/배경의 id
     */
    private int borderFillId;

    /**
     * 생성자
     */
    public PageBorderFill() {
        property = new PageBorderFillProperty();
    }

    /**
     * 속성 객체를 반환한다.
     *
     * @return 속성 객체
     */
    public PageBorderFillProperty getProperty() {
        return property;
    }

    /**
     * 테두리/배경 위치 왼쪽 간격을 반환한다.
     *
     * @return 테두리/배경 위치 왼쪽 간격
     */
    public int getLeftGap() {
        return leftGap;
    }

    /**
     * 테두리/배경 위치 왼쪽 간격을 설정한다.
     *
     * @param leftGap 테두리/배경 위치 왼쪽 간격
     */
    public void setLeftGap(int leftGap) {
        this.leftGap = leftGap;
    }

    /**
     * 테두리/배경 위치 오른쪽 간격을 반환한다.
     *
     * @return 테두리/배경 위치 오른쪽 간격
     */
    public int getRightGap() {
        return rightGap;
    }

    /**
     * 테두리/배경 위치 오른쪽 간격을 설정한다.
     *
     * @param rightGap 테두리/배경 위치 오른쪽 간격
     */
    public void setRightGap(int rightGap) {
        this.rightGap = rightGap;
    }

    /**
     * 테두리/배경 위치 위쪽 간격을 반환한다.
     *
     * @return 테두리/배경 위치 위쪽 간격
     */
    public int getTopGap() {
        return topGap;
    }

    /**
     * 테두리/배경 위치 위쪽 간격을 설정한다.
     *
     * @param topGap 테두리/배경 위치 위쪽 간격
     */
    public void setTopGap(int topGap) {
        this.topGap = topGap;
    }

    /**
     * 테두리/배경 위치 아래쪽 간격을 반환한다.
     *
     * @return 테두리/배경 위치 아래쪽 간격
     */
    public int getBottomGap() {
        return bottomGap;
    }

    /**
     * 테두리/배경 위치 아래쪽 간격을 설정한다.
     *
     * @param bottomGap 테두리/배경 위치 아래쪽 간격
     */
    public void setBottomGap(int bottomGap) {
        this.bottomGap = bottomGap;
    }

    /**
     * 참조된 테두리/배경의 id를 반환한다.
     *
     * @return 참조된 테두리/배경의 id
     */
    public int getBorderFillId() {
        return borderFillId;
    }

    /**
     * 참조된 테두리/배경의 id를 설정한다.
     *
     * @param borderFillId 참조된 테두리/배경의 id
     */
    public void setBorderFillId(int borderFillId) {
        this.borderFillId = borderFillId;
    }
}

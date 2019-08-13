package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

/**
 * 용지 설정에 대한 레코드
 *
 * @author neolord
 */
public class PageDef {
    /**
     * 용지 가로 크기
     */
    private long paperWidth;
    /**
     * 용지 세로 크기
     */
    private long paperHeight;
    /**
     * 용지 왼쪽 여백
     */
    private long leftMargin;
    /**
     * 용지 오른쪽 여백
     */
    private long rightMargin;
    /**
     * 용지 위쪽 여백
     */
    private long topMargin;
    /**
     * 용지 아래쪽 여백
     */
    private long bottomMargin;
    /**
     * 머리말 여백
     */
    private long headerMargin;
    /**
     * 꼬리말 여백
     */
    private long footerMargin;
    /**
     * 제본 여백
     */
    private long gutterMargin;
    /**
     * 속성
     */
    private PageDefProperty property;

    /**
     * 생상자
     */
    public PageDef() {
        property = new PageDefProperty();
    }

    /**
     * 용지 가로 크기를 반환한다.
     *
     * @return 용지 가로 크기
     */
    public long getPaperWidth() {
        return paperWidth;
    }

    /**
     * 용지 가로 크기를 설정한다.
     *
     * @param paperWidth 용지 가로 크기
     */
    public void setPaperWidth(long paperWidth) {
        this.paperWidth = paperWidth;
    }

    /**
     * 용지 세로 크기를 반환한다.
     *
     * @return 용지 세로 크기
     */
    public long getPaperHeight() {
        return paperHeight;
    }

    /**
     * 용지 세로 크기를 설정한다.
     *
     * @param paperHeight 용지 세로 크기
     */
    public void setPaperHeight(long paperHeight) {
        this.paperHeight = paperHeight;
    }

    /**
     * 용지 왼쪽 여백의 크기를 반환한다.
     *
     * @return 용지 왼쪽 여백의 크기
     */
    public long getLeftMargin() {
        return leftMargin;
    }

    /**
     * 용지 왼쪽 여백의 크기를 설정한다.
     *
     * @param leftMargin 용지 왼쪽 여백의 크기
     */
    public void setLeftMargin(long leftMargin) {
        this.leftMargin = leftMargin;
    }

    /**
     * 용지 오른쪽 여백의 크기를 반환한다.
     *
     * @return 용지 오른쪽 여백의 크기
     */
    public long getRightMargin() {
        return rightMargin;
    }

    /**
     * 용지 오른쪽 여백의 크기를 설정한다.
     *
     * @param rightMargin 용지 오른쪽 여백의 크기
     */
    public void setRightMargin(long rightMargin) {
        this.rightMargin = rightMargin;
    }

    /**
     * 용지 위쪽 여백의 크기를 반환한다.
     *
     * @return 용지 위쪽 여백의 크기
     */
    public long getTopMargin() {
        return topMargin;
    }

    /**
     * 용지 위쪽 여백의 크기를 설정한다.
     *
     * @param topMargin 용지 위쪽 여백의 크기
     */
    public void setTopMargin(long topMargin) {
        this.topMargin = topMargin;
    }

    /**
     * 용지 아래쪽 여백의 크기를 반환한다.
     *
     * @return 용지 아래쪽 여백의 크기
     */
    public long getBottomMargin() {
        return bottomMargin;
    }

    /**
     * 용지 아래쪽 여백의 크기를 설정한다.
     *
     * @param bottomMargin 용지 아래쪽 여백의 크기
     */
    public void setBottomMargin(long bottomMargin) {
        this.bottomMargin = bottomMargin;
    }

    /**
     * 머리말 여백의 크기를 반환한다.
     *
     * @return 머리말 여백의 크기
     */
    public long getHeaderMargin() {
        return headerMargin;
    }

    /**
     * 머리말 여백의 크기를 설정한다.
     *
     * @param headerMargin 머리말 여백의 크기
     */
    public void setHeaderMargin(long headerMargin) {
        this.headerMargin = headerMargin;
    }

    /**
     * 꼬리말 여백의 크기를 반환한다.
     *
     * @return 꼬리말 여백의 크기
     */
    public long getFooterMargin() {
        return footerMargin;
    }

    /**
     * 꼬리말 여백의 크기를 설정한다.
     *
     * @param footerMargin 꼬리말 여백의 크기
     */
    public void setFooterMargin(long footerMargin) {
        this.footerMargin = footerMargin;
    }

    /**
     * 제본 여백의 크기를 반환한다.
     *
     * @return 제본 여백의 크기
     */
    public long getGutterMargin() {
        return gutterMargin;
    }

    /**
     * 제본 여백의 크기를 설정한다.
     *
     * @param gutterMargin 제본 여백의 크기
     */
    public void setGutterMargin(long gutterMargin) {
        this.gutterMargin = gutterMargin;
    }

    /**
     * 속성 객체를 반환한다.
     *
     * @return 속성 객체
     */
    public PageDefProperty getProperty() {
        return property;
    }
}

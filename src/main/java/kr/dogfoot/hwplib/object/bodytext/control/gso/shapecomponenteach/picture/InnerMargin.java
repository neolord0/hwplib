package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture;

/**
 * 안쪽 여백 정보
 *
 * @author neolord
 */
public class InnerMargin {
    /**
     * 왼쪽 여백
     */
    private int left;
    /**
     * 오른쪽 여백
     */
    private int right;
    /**
     * 위쪽 여백
     */
    private int top;
    /**
     * 아래쪽 여백
     */
    private int bottom;

    /**
     * 생성자
     */
    public InnerMargin() {
    }

    /**
     * 왼쪽 여백의 크기를 반환한다.
     *
     * @return 왼쪽 여백의 크기
     */
    public int getLeft() {
        return left;
    }

    /**
     * 왼쪽 여백의 크기를 설정한다.
     *
     * @param left 왼쪽 여백의 크기
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     * 오른쪽 여백의 크기를 반환한다.
     *
     * @return 오른쪽 여백의 크기
     */
    public int getRight() {
        return right;
    }

    /**
     * 오른쪽 여백의 크기를 설정한다.
     *
     * @param right 오른쪽 여백의 크기
     */
    public void setRight(int right) {
        this.right = right;
    }

    /**
     * 위쪽 여백의 크기를 반환한다.
     *
     * @return 위쪽 여백의 크기
     */
    public int getTop() {
        return top;
    }

    /**
     * 위쪽 여백의 크기를 설정한다.
     *
     * @param top 위쪽 여백의 크기
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * 아래쪽 여백의 크기를 반환한다.
     *
     * @return 아래쪽 여백의 크기
     */
    public int getBottom() {
        return bottom;
    }

    /**
     * 아래쪽 여백의 크기를 설정한다.
     *
     * @param bottom 아래쪽 여백의 크기
     */
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public void copy(InnerMargin from) {
        left = from.left;
        right = from.right;
        top = from.top;
        bottom = from.bottom;
    }
}

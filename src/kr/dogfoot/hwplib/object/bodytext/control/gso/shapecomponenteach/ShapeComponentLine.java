package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

/**
 * 선 개체 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentLine {
    /**
     * 시작점 x 좌표
     */
    private int startX;
    /**
     * 시작점 y 좌표
     */
    private int startY;
    /**
     * 끝점 x 좌표
     */
    private int endX;
    /**
     * 끝점 y 좌표
     */
    private int endY;
    /**
     * 선이 오른쪽이나 아래쪽 부터 시작되었는지 여부
     * <p>
     * 속성. 처음 생성 시 수직 또는 수평선일 때, 선의 방향이 언제나 오른쪽(위쪽)으로 잡힘으로 인한 현상 때문에, 방향을 바로
     * 잡아주기 위한 플래그.
     */
    private boolean startedRightOrBottom;

    /**
     * 생성자
     */
    public ShapeComponentLine() {
    }

    /**
     * 시작점 x 좌표를 반환한다.
     *
     * @return 시작점 x 좌표
     */
    public int getStartX() {
        return startX;
    }

    /**
     * 시작점 x 좌표를 설정한다.
     *
     * @param startX 시작점 x 좌표
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * 시작점 y 좌표를 반환한다.
     *
     * @return 시작점 y 좌표
     */
    public int getStartY() {
        return startY;
    }

    /**
     * 시작점 y 좌표를 설정한다.
     *
     * @param startY 시작점 y 좌표
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * 끝점 x 좌표를 반환한다.
     *
     * @return 끝점 x 좌표
     */
    public int getEndX() {
        return endX;
    }

    /**
     * 끝점 x 좌표를 설정한다.
     *
     * @param endX 끝점 x 좌표
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * 끝점 y 좌표를 반환한다.
     *
     * @return 끝점 y 좌표
     */
    public int getEndY() {
        return endY;
    }

    /**
     * 끝점 y 좌표를 설정한다.
     *
     * @param endY 끝점 y 좌표
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * 선이 오른쪽이나 아래쪽 부터 시작되었는지 여부를 반환한다.
     *
     * @return 선이 오른쪽이나 아래쪽 부터 시작되었는지 여부
     */
    public boolean isStartedRightOrBottom() {
        return startedRightOrBottom;
    }

    /**
     * 선이 오른쪽이나 아래쪽 부터 시작되었는지 여부를 설정한다.
     *
     * @param startedRightOrBottom 선이 오른쪽이나 아래쪽 부터 시작되었는지 여부
     */
    public void setStartedRightOrBottom(boolean startedRightOrBottom) {
        this.startedRightOrBottom = startedRightOrBottom;
    }
}

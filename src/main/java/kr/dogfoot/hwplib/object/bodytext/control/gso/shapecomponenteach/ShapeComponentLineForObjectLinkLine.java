package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

/**
 * 객체 연결선 컨트롤을 위한 선 개체 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentLineForObjectLinkLine {
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
     * 알 수 없는 데이터
     */
    private byte[] unknown;

    /**
     * 생성자
     */
    public ShapeComponentLineForObjectLinkLine() {
        unknown = null;
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
     * 알 수 없는 데이터를 반환한다.
     *
     * @return 알 수 없는 데이터
     */
    public byte[] getUnknown() {
        return unknown;
    }

    /**
     * 알 수 없는 데이터를 설정한다.
     *
     * @param unknown
     */
    public void setUnknown(byte[] unknown) {
        this.unknown = unknown;
    }

    public void copy(ShapeComponentLineForObjectLinkLine from) {
        startX = from.startX;
        startY = from.startY;
        endX = from.endX;
        endY = from.endY;

        if (from.unknown != null) {
            unknown = from.unknown.clone();
        } else {
            unknown = null;
        }
    }
}

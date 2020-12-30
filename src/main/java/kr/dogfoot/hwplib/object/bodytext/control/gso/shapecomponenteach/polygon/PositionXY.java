package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon;

/**
 * 좌표를 나태내는 객체
 *
 * @author neolord
 */
public class PositionXY {
    /**
     * x값
     */
    private long x;
    /**
     * y값
     */
    private long y;

    /**
     * 생성자
     */
    public PositionXY() {
    }

    /**
     * x값을 반환한다.
     *
     * @return x값
     */
    public long getX() {
        return x;
    }

    /**
     * x값을 설정한다.
     *
     * @param x x값
     */
    public void setX(long x) {
        this.x = x;
    }

    /**
     * y값을 반환한다.
     *
     * @return y값
     */
    public long getY() {
        return y;
    }

    /**
     * y값을 설정한다.
     *
     * @param y y값
     */
    public void setY(long y) {
        this.y = y;
    }

    public PositionXY clone() {
        PositionXY cloned = new PositionXY();
        cloned.copy(this);
        return cloned;
    }

    public void copy(PositionXY from) {
        x = from.x;
        y = from.y;
    }
}



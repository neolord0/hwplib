package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.objectlinkline;

public class ControlPoint {
    private long x;
    private long y;
    private int type;

    public ControlPoint() {
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void copy(ControlPoint from) {
        x = from.x;
        y = from.y;
        type = from.type;
    }
}
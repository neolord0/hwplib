package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

/**
 * 사각형 개체 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentRectangle {
    /**
     * 모서리 둥근 비율
     */
    private byte roundRate;
    /**
     * x1
     */
    private int x1;
    /**
     * y1
     */
    private int y1;
    /**
     * x2
     */
    private int x2;
    /**
     * y2
     */
    private int y2;
    /**
     * x3
     */
    private int x3;
    /**
     * y3
     */
    private int y3;
    /**
     * x4
     */
    private int x4;
    /**
     * y4
     */
    private int y4;

    /**
     * 생성자
     */
    public ShapeComponentRectangle() {
    }

    /**
     * 모서리 둗근 비율을 반환한다.
     *
     * @return 모서리 둗근 비율
     */
    public byte getRoundRate() {
        return roundRate;
    }

    /**
     * 모서리 둗근 비율을 설정한다.
     *
     * @param roundRate 모서리 둗근 비율
     */
    public void setRoundRate(byte roundRate) {
        this.roundRate = roundRate;
    }

    /**
     * x1 값을 반환한다.
     *
     * @return x1 값
     */
    public int getX1() {
        return x1;
    }

    /**
     * x1 값을 설정한다.
     *
     * @param x1 x1 값
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * y1 값을 반환한다.
     *
     * @return y1 값
     */
    public int getY1() {
        return y1;
    }

    /**
     * y1 값을 설정한다.
     *
     * @param y1 y1 값
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * x2 값을 반환한다.
     *
     * @return x2 값
     */
    public int getX2() {
        return x2;
    }

    /**
     * x2 값을 설정한다.
     *
     * @param x2 x2 값
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * y2 값을 반환한다.
     *
     * @return y2 값
     */
    public int getY2() {
        return y2;
    }

    /**
     * y2 값을 설정한다.
     *
     * @param y2 y2 값
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * x3 값을 반환한다.
     *
     * @return x3 값
     */
    public int getX3() {
        return x3;
    }

    /**
     * x3 값을 설정한다.
     *
     * @param x3 x3 값
     */
    public void setX3(int x3) {
        this.x3 = x3;
    }

    /**
     * y3 값을 반환한다.
     *
     * @return y3 값
     */
    public int getY3() {
        return y3;
    }

    /**
     * y3 값을 설정한다.
     *
     * @param y3 y3 값
     */
    public void setY3(int y3) {
        this.y3 = y3;
    }

    /**
     * x4 값을 반환한다.
     *
     * @return x4 값
     */
    public int getX4() {
        return x4;
    }

    /**
     * x4 값을 설정한다.
     *
     * @param x4 x4 값
     */
    public void setX4(int x4) {
        this.x4 = x4;
    }

    /**
     * y4 값을 반환한다.
     *
     * @return y4 값
     */
    public int getY4() {
        return y4;
    }

    /**
     * y4 값을 설정한다.
     *
     * @param y4 y4 값
     */
    public void setY4(int y4) {
        this.y4 = y4;
    }

    public void copy(ShapeComponentRectangle from) {
        roundRate = from.roundRate;
        x1 = from.x1;
        y1 = from.y1;
        x2 = from.x2;
        y2 = from.y2;
        x3 = from.x3;
        y3 = from.y3;
        x4 = from.x4;
        y4 = from.y4;
    }
}

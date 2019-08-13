package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ellipse.ShapeComponentEllipseProperty;

/**
 * 타원 개체 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentEllipse {
    /**
     * 속성
     */
    private ShapeComponentEllipseProperty property;
    /**
     * 중심 좌표의 X값
     */
    private int centerX;
    /**
     * 중심 좌표의 Y값
     */
    private int centerY;
    /**
     * 제1축 X좌표 값
     */
    private int axis1X;
    /**
     * 제1축 Y좌표 값
     */
    private int axis1Y;
    /**
     * 제2축 X좌표 값
     */
    private int axis2X;
    /**
     * 제2축 Y좌표 값
     */
    private int axis2Y;
    /**
     * start pos x
     */
    private int startX;
    /**
     * start pos y
     */
    private int startY;
    /**
     * end pos x
     */
    private int endX;
    /**
     * end pos y
     */
    private int endY;
    /**
     * start pos x2 interval of curve(effective only when it is an arc)
     */
    private int startX2;
    /**
     * start pos y2
     */
    private int startY2;
    /**
     * end pos x2
     */
    private int endX2;
    /**
     * end pos y2
     */
    private int endY2;

    /**
     * 생성자
     */
    public ShapeComponentEllipse() {
        property = new ShapeComponentEllipseProperty();
    }

    /**
     * 속성 객체를 반환한다.
     *
     * @return 속성 객체
     */
    public ShapeComponentEllipseProperty getProperty() {
        return property;
    }

    /**
     * 중심 좌표의 X값을 반환한다.
     *
     * @return 중심 좌표의 X값
     */
    public int getCenterX() {
        return centerX;
    }

    /**
     * 중심 좌표의 X값을 설정한다.
     *
     * @param centerX 중심 좌표의 X값
     */
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    /**
     * 중심 좌표의 Y값을 반환한다.
     *
     * @return 중심 좌표의 Y값
     */
    public int getCenterY() {
        return centerY;
    }

    /**
     * 중심 좌표의 Y값을 설정한다.
     *
     * @param centerY 중심 좌표의 Y값
     */
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    /**
     * 제1축 X좌표 값을 반환한다.
     *
     * @return 제1축 X좌표 값
     */
    public int getAxis1X() {
        return axis1X;
    }

    /**
     * 제1축 X좌표 값을 설정한다.
     *
     * @param axis1X 제1축 X좌표 값
     */
    public void setAxis1X(int axis1X) {
        this.axis1X = axis1X;
    }

    /**
     * 제1축 Y좌표 값을 반환한다.
     *
     * @return 제1축 Y좌표 값
     */
    public int getAxis1Y() {
        return axis1Y;
    }

    /**
     * 제1축 Y좌표 값을 설정한다.
     *
     * @param axis1Y 제1축 Y좌표 값
     */
    public void setAxis1Y(int axis1Y) {
        this.axis1Y = axis1Y;
    }

    /**
     * 제2축 X좌표 값을 반환한다.
     *
     * @return 제2축 X좌표 값
     */
    public int getAxis2X() {
        return axis2X;
    }

    /**
     * 제2축 X좌표 값을 설정한다.
     *
     * @param axis2X 제2축 X좌표 값
     */
    public void setAxis2X(int axis2X) {
        this.axis2X = axis2X;
    }

    /**
     * 제2축 Y좌표 값을 반환한다.
     *
     * @return 제2축 Y좌표 값
     */
    public int getAxis2Y() {
        return axis2Y;
    }

    /**
     * 제2축 Y좌표 값을 설정한다.
     *
     * @param axis2Y 제2축 Y좌표 값
     */
    public void setAxis2Y(int axis2Y) {
        this.axis2Y = axis2Y;
    }

    /**
     * start pos x값을 반환한다.
     *
     * @return start pos x값
     */
    public int getStartX() {
        return startX;
    }

    /**
     * start pos x값을 설정한다.
     *
     * @param startX start pos x
     */
    public void setStartX(int startX) {
        this.startX = startX;
    }

    /**
     * start pos y값을 반환한다.
     *
     * @return start pos y값
     */
    public int getStartY() {
        return startY;
    }

    /**
     * start pos y값을 설정한다.
     *
     * @param startY start pos y값
     */
    public void setStartY(int startY) {
        this.startY = startY;
    }

    /**
     * end pos x값을 반환한다.
     *
     * @return end pos x값
     */
    public int getEndX() {
        return endX;
    }

    /**
     * end pos x값을 설정한다.
     *
     * @param endX end pos x값
     */
    public void setEndX(int endX) {
        this.endX = endX;
    }

    /**
     * end pos y값을 반환한다.
     *
     * @return end pos y값
     */
    public int getEndY() {
        return endY;
    }

    /**
     * end pos y값을 설정한다.
     *
     * @param endY end pos y값
     */
    public void setEndY(int endY) {
        this.endY = endY;
    }

    /**
     * start pos x2값을 반환한다.
     *
     * @return start pos x2값
     */
    public int getStartX2() {
        return startX2;
    }

    /**
     * start pos x2값을 설정한다.
     *
     * @param startX2 start pos x2
     */
    public void setStartX2(int startX2) {
        this.startX2 = startX2;
    }

    /**
     * start pos y2값을 반환한다.
     *
     * @return start pos y2값
     */
    public int getStartY2() {
        return startY2;
    }

    /**
     * start pos y2값을 설정한다.
     *
     * @param startY2 start pos y2
     */
    public void setStartY2(int startY2) {
        this.startY2 = startY2;
    }

    /**
     * end pos x2값을 반환한다.
     *
     * @return end pos x2값
     */
    public int getEndX2() {
        return endX2;
    }

    /**
     * end pos x2값을 설정한다.
     *
     * @param endX2 end pos x2값
     */
    public void setEndX2(int endX2) {
        this.endX2 = endX2;
    }

    /**
     * end pos y2값을 반환한다.
     *
     * @return end pos y2값
     */
    public int getEndY2() {
        return endY2;
    }

    /**
     * end pos y2값을 설정한다.
     *
     * @param endY2 end pos y2값
     */
    public void setEndY2(int endY2) {
        this.endY2 = endY2;
    }
}

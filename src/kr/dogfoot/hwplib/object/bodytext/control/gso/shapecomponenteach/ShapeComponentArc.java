package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.arc.ArcBorder;

/**
 * 호 개체 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentArc {
    /**
     * 호 테두리
     */
    private ArcBorder arcBorder;
    /**
     * 타원의 중심 좌표 X값
     */
    private int centerX;
    /**
     * 타원의 중심 좌표 Y값
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
     * 생성자
     */
    public ShapeComponentArc() {
    }

    /**
     * 호 테두리 종류를 반환한다.
     *
     * @return 호 테두리 종류
     */
    public ArcBorder getArcBorder() {
        return arcBorder;
    }

    /**
     * 호 테두리 종류를 설정한다.
     *
     * @param arcBorder 호 테두리 종류
     */
    public void setArcBorder(ArcBorder arcBorder) {
        this.arcBorder = arcBorder;
    }

    /**
     * 타원의 중심 좌표 X값을 반환한다.
     *
     * @return 타원의 중심 좌표 X값
     */
    public int getCenterX() {
        return centerX;
    }

    /**
     * 타원의 중심 좌표 X값을 설정한다.
     *
     * @param centerX 타원의 중심 좌표 X값
     */
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    /**
     * 타원의 중심 좌표 Y값을 반환한다.
     *
     * @return 타원의 중심 좌표 Y값
     */
    public int getCenterY() {
        return centerY;
    }

    /**
     * 타원의 중심 좌표 Y값을 설정한다.
     *
     * @param centerY 타원의 중심 좌표 Y값
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
}

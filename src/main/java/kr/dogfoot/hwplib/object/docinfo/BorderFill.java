package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderFillProperty;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderThickness;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;
import kr.dogfoot.hwplib.object.docinfo.borderfill.EachBorder;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.FillInfo;
import kr.dogfoot.hwplib.object.etc.Color4Byte;

/**
 * 테두리/배경의 모양을 나타내는 레코드
 *
 * @author neolord
 */
public class BorderFill {
    /**
     * 속성
     */
    private BorderFillProperty property;
    /**
     * 왼쪽 선의 속성
     */
    private EachBorder leftBorder;
    /**
     * 오른쪽 선의 속성
     */
    private EachBorder rightBorder;
    /**
     * 위쪽 선의 속성
     */
    private EachBorder topBorder;
    /**
     * 아래쪽 선의 속성
     */
    private EachBorder bottomBorder;
    /**
     * 대각선 종류
     */
    private BorderType diagonalSort;
    /**
     * 대각선 굵기
     */
    private BorderThickness diagonalThickness;
    /**
     * 대각선 색상
     */
    private Color4Byte diagonalColor;
    /**
     * 채우기 정보
     */
    private FillInfo fillInfo;

    /**
     * 생성자
     */
    public BorderFill() {
        property = new BorderFillProperty();
        leftBorder = new EachBorder();
        rightBorder = new EachBorder();
        topBorder = new EachBorder();
        bottomBorder = new EachBorder();
        diagonalColor = new Color4Byte();
        fillInfo = new FillInfo();
    }

    /**
     * 테두리/배경의 속성 객체를 반환한다.
     *
     * @return 테두리/배경의 속성 객체
     */
    public BorderFillProperty getProperty() {
        return property;
    }

    /**
     * 왼쪽 선의 속성 객체를 반환한다.
     *
     * @return 왼쪽 선의 속성 객체
     */
    public EachBorder getLeftBorder() {
        return leftBorder;
    }

    /**
     * 오른쪽 선의 속성 객체를 반환한다.
     *
     * @return 오른쪽 선의 속성 객체
     */
    public EachBorder getRightBorder() {
        return rightBorder;
    }

    /**
     * 위쪽 선의 속성 객체를 반환한다.
     *
     * @return 위쪽 선의 속성 객체
     */
    public EachBorder getTopBorder() {
        return topBorder;
    }

    /**
     * 아래쪽 선의 속성 객체를 반환한다.
     *
     * @return 아래쪽 선의 속성 객체
     */
    public EachBorder getBottomBorder() {
        return bottomBorder;
    }

    /**
     * 대각선의 종류를 반환한다.
     *
     * @return 대각선의 종류
     */
    public BorderType getDiagonalSort() {
        return diagonalSort;
    }

    /**
     * 대각선의 종류를 설정한다.
     *
     * @param diagonalSort 대각선의 종류
     */
    public void setDiagonalSort(BorderType diagonalSort) {
        this.diagonalSort = diagonalSort;
    }

    /**
     * 대각선의 두께를 반환한다.
     *
     * @return 대각선의 두께
     */
    public BorderThickness getDiagonalThickness() {
        return diagonalThickness;
    }

    /**
     * 대각선의 두께를 설정한다.
     *
     * @param diagonalThickness 대각선의 두께
     */
    public void setDiagonalThickness(BorderThickness diagonalThickness) {
        this.diagonalThickness = diagonalThickness;
    }

    /**
     * 대각선의 색상 객체를 반환한다.
     *
     * @return 대각선의 색상 객체
     */
    public Color4Byte getDiagonalColor() {
        return diagonalColor;
    }

    /**
     * 채우기 정보 객체를 반환한다.
     *
     * @return 채우기 정보 객체
     */
    public FillInfo getFillInfo() {
        return fillInfo;
    }

    public BorderFill clone() {
        BorderFill cloned = new BorderFill();
        cloned.property.copy(property);
        cloned.leftBorder.copy(leftBorder);
        cloned.rightBorder.copy(rightBorder);
        cloned.topBorder.copy(topBorder);
        cloned.bottomBorder.copy(bottomBorder);
        cloned.diagonalSort = diagonalSort;
        cloned.diagonalThickness = diagonalThickness;
        cloned.diagonalColor.copy(diagonalColor);
        cloned.fillInfo.copy(fillInfo);
        return cloned;
    }
}

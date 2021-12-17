package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderFillProperty;
import kr.dogfoot.hwplib.object.docinfo.borderfill.EachBorder;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.FillInfo;

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
     * 대각선의 속성
     */
    private EachBorder diagonalBorder;
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
        diagonalBorder = new EachBorder();
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
     * 대각선의 속성 객체를 반환한다.
     *
     * @return 아래쪽 선의 속성 객체
     */
    public EachBorder getDiagonalBorder() {
        return diagonalBorder;
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
        cloned.diagonalBorder.copy(diagonalBorder);
        cloned.fillInfo.copy(fillInfo);
        return cloned;
    }
}

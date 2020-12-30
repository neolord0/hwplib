package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.GsoHeaderProperty;

/**
 * 그리기 개체을 위한 컨트롤 헤더 레코드
 *
 * @author neolord
 */
public class CtrlHeaderGso extends CtrlHeader {
    /**
     * 속성
     */
    private GsoHeaderProperty property;
    /**
     * 세로 오프셋 값
     */
    private long yOffset;
    /**
     * 가로 오프셋 값
     */
    private long xOffset;
    /**
     * 오브젝트의 폭
     */
    private long width;
    /**
     * 오브젝트의 높이
     */
    private long height;
    /**
     * z-order
     */
    private int zOrder;
    /**
     * 오브젝트의 바깥 왼쪾 여백
     */
    private int outterMarginLeft;
    /**
     * 오브젝트의 바깥 오른쪽 여백
     */
    private int outterMarginRight;
    /**
     * 오브젝트의 바깥 위쪽 여백
     */
    private int outterMarginTop;
    /**
     * 오브젝트의 바깥 아래쪽 여백
     */
    private int outterMarginBottom;
    /**
     * 문서 내 각 개체에 대한 고유 아이디
     */
    private long instanceId;
    /**
     * 쪽나눔 방지 on(1) / off(0)
     */
    private boolean preventPageDivide;
    /**
     * 개체 설명문
     */
    private String explanation;

    /**
     * 생성자
     */
    public CtrlHeaderGso() {
        super(ControlType.Gso.getCtrlId());

        property = new GsoHeaderProperty();
    }

    /**
     * 생성자
     *
     * @param controlType 컨트롤 타입
     */
    public CtrlHeaderGso(ControlType controlType) {
        super(controlType.getCtrlId());

        property = new GsoHeaderProperty();
    }

    /**
     * 그리기 객체 컨트롤의 속성 객체를 반환한다.
     *
     * @return 그리기 객체 컨트롤의 속성 객체
     */
    public GsoHeaderProperty getProperty() {
        return property;
    }

    /**
     * 세로 오프셋 값을 반환한다.
     *
     * @return 세로 오프셋 값
     */
    public long getyOffset() {
        return yOffset;
    }

    /**
     * 세로 오프셋 값을 설정한다.
     *
     * @param yOffset 세로 오프셋 값
     */
    public void setyOffset(long yOffset) {
        this.yOffset = yOffset;
    }

    /**
     * 가로 오프셋 값을 반환한다.
     *
     * @return 가로 오프셋 값
     */
    public long getxOffset() {
        return xOffset;
    }

    /**
     * 가로 오프셋 값을 설정한다.
     *
     * @param xOffset 가로 오프셋 값
     */
    public void setxOffset(long xOffset) {
        this.xOffset = xOffset;
    }

    /**
     * 오브젝트의 폭을 반환한다.
     *
     * @return 오브젝트의 폭
     */
    public long getWidth() {
        return width;
    }

    /**
     * 오브젝트의 폭를 설정한다.
     *
     * @param width 오브젝트의 폭
     */
    public void setWidth(long width) {
        this.width = width;
    }

    /**
     * 오브젝트의 높이를 반환한다.
     *
     * @return 오브젝트의 높이
     */
    public long getHeight() {
        return height;
    }

    /**
     * 오브젝트의 높이를 설정한다.
     *
     * @param height 오브젝트의 높이
     */
    public void setHeight(long height) {
        this.height = height;
    }

    /**
     * z-order을 반환한다.
     *
     * @return z-order
     */
    public int getzOrder() {
        return zOrder;
    }

    /**
     * z-order을 설정한다.
     *
     * @param zOrder z-order
     */
    public void setzOrder(int zOrder) {
        this.zOrder = zOrder;
    }

    /**
     * 오브젝트의 바깥 왼쪾 여백을 반환한다.
     *
     * @return 오브젝트의 바깥 왼쪾 여백
     */
    public int getOutterMarginLeft() {
        return outterMarginLeft;
    }

    /**
     * 오브젝트의 바깥 왼쪾 여백을 설정한다.
     *
     * @param outterMarginLeft 오브젝트의 바깥 왼쪾 여백
     */
    public void setOutterMarginLeft(int outterMarginLeft) {
        this.outterMarginLeft = outterMarginLeft;
    }

    /**
     * 오브젝트의 바깥 오른쪽 여백을 반환한다.
     *
     * @return 오브젝트의 바깥 오른쪽 여백
     */
    public int getOutterMarginRight() {
        return outterMarginRight;
    }

    /**
     * 오브젝트의 바깥 오른쪽 여백을 설정한다.
     *
     * @param outterMarginRight 오브젝트의 바깥 오른쪽 여백
     */
    public void setOutterMarginRight(int outterMarginRight) {
        this.outterMarginRight = outterMarginRight;
    }

    /**
     * 오브젝트의 바깥 위쪽 여백을 반환한다.
     *
     * @return 오브젝트의 바깥 위쪽 여백
     */
    public int getOutterMarginTop() {
        return outterMarginTop;
    }

    /**
     * 오브젝트의 바깥 위쪽 여백을 설정한다.
     *
     * @param outterMarginTop 오브젝트의 바깥 위쪽 여백
     */
    public void setOutterMarginTop(int outterMarginTop) {
        this.outterMarginTop = outterMarginTop;
    }

    /**
     * 오브젝트의 바깥 아래쪽 여백을 반환한다.
     *
     * @return 오브젝트의 바깥 아래쪽 여백
     */
    public int getOutterMarginBottom() {
        return outterMarginBottom;
    }

    /**
     * 오브젝트의 바깥 아래쪽 여백을 설정한다.
     *
     * @param outterMarginBottom 오브젝트의 바깥 아래쪽 여백
     */
    public void setOutterMarginBottom(int outterMarginBottom) {
        this.outterMarginBottom = outterMarginBottom;
    }

    /**
     * 문서 내 각 개체에 대한 고유 아이디를 반환한다.
     *
     * @return 문서 내 각 개체에 대한 고유 아이디
     */
    public long getInstanceId() {
        return instanceId;
    }

    /**
     * 문서 내 각 개체에 대한 고유 아이디를 설정한다.
     *
     * @param instanceId 문서 내 각 개체에 대한 고유 아이디
     */
    public void setInstanceId(long instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * 쪽나눔 방지를 반환한다.
     *
     * @return 쪽나눔 방지
     */
    public boolean isPreventPageDivide() {
        return preventPageDivide;
    }

    /**
     * 쪽나눔 방지를 설정한다.
     *
     * @param preventPageDivide 쪽나눔 방지
     */
    public void setPreventPageDivide(boolean preventPageDivide) {
        this.preventPageDivide = preventPageDivide;
    }

    /**
     * 개체 설명문을 반환한다.
     *
     * @return 개체 설명문
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * 개체 설명문을 설정한다.
     *
     * @param explanation 개체 설명문
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public void copy(CtrlHeader from) {
        CtrlHeaderGso from2 = (CtrlHeaderGso) from;
        property.copy(from2.property);
        yOffset = from2.yOffset;
        xOffset = from2.xOffset;
        width = from2.width;
        height = from2.height;
        zOrder = from2.zOrder;
        outterMarginLeft = from2.outterMarginLeft;
        outterMarginRight = from2.outterMarginRight;
        outterMarginTop = from2.outterMarginTop;
        outterMarginBottom = from2.outterMarginBottom;
        instanceId = from2.instanceId;
        preventPageDivide = from2.preventPageDivide;
        explanation = from2.explanation;
    }
}

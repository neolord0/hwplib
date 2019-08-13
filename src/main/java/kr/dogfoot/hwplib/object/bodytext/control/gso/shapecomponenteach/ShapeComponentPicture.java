package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineInfoProperty;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture.InnerMargin;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture.PictureEffect;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.PictureInfo;
import kr.dogfoot.hwplib.object.etc.Color4Byte;

/**
 * 그림 개체 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentPicture {
    /**
     * 테두리 색
     */
    private Color4Byte borderColor;
    /**
     * 테두리 두꼐
     */
    private int borderThickness;
    /**
     * 테두리 속성
     */
    private LineInfoProperty borderProperty;
    /**
     * left,top 좌표
     */
    private PositionXY leftTop;
    /**
     * right,top 좌표
     */
    private PositionXY rightTop;
    /**
     * left, bottom 좌표
     */
    private PositionXY leftBottom;
    /**
     * right, bottom 좌표
     */
    private PositionXY rightBottom;
    /**
     * 자르기 한 후 사각형의 left좌표
     */
    private int leftAfterCutting;
    /**
     * 자르기 한 후 사각형의 top좌표
     */
    private int topAfterCutting;
    /**
     * 자르기 한 후 사각형의 right좌표
     */
    private int rightAfterCutting;
    /**
     * 자르기 한 후 사각형의 bottom좌표
     */
    private int bottomAfterCutting;
    /**
     * 안쪽 여백 정보
     */
    private InnerMargin innerMargin;
    /**
     * 그림 정보
     */
    private PictureInfo pictureInfo;
    /**
     * 테두리 투명도
     */
    private short borderTransparency;
    /**
     * 문서 내 각 개체에 대한 고유 아이디
     */
    private long instanceId;
    /**
     * 그림 효과 정보
     */
    private PictureEffect pictureEffect;
    /**
     * 이미지 너비 (??)
     */
    private long imageWidth;
    /**
     * 이미지 높이 (??)
     */
    private long imageHeight;

    /**
     * 생성자
     */
    public ShapeComponentPicture() {
        borderColor = new Color4Byte();
        borderProperty = new LineInfoProperty();
        leftTop = new PositionXY();
        rightTop = new PositionXY();
        leftBottom = new PositionXY();
        rightBottom = new PositionXY();
        innerMargin = new InnerMargin();
        pictureInfo = new PictureInfo();
        pictureEffect = new PictureEffect();
    }

    /**
     * 테두리 색상 객체를 반환한다.
     *
     * @return 테두리 색상 객체
     */
    public Color4Byte getBorderColor() {
        return borderColor;
    }

    /**
     * 테두리 두꼐를 반환한다.
     *
     * @return 테두리 두꼐
     */
    public int getBorderThickness() {
        return borderThickness;
    }

    /**
     * 테두리 두꼐를 설정한다.
     *
     * @param borderThickness 테두리 두꼐
     */
    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
    }

    /**
     * 테두리 선의 속성 객체를 반환한다.
     *
     * @return 테두리 선의 속성 객체
     */
    public LineInfoProperty getBorderProperty() {
        return borderProperty;
    }

    /**
     * left,top 좌표 객체를 반환한다.
     *
     * @return left, top 좌표 객체
     */
    public PositionXY getLeftTop() {
        return leftTop;
    }

    /**
     * right,top 좌표 객체를 반환한다.
     *
     * @return right, top 좌표 객체
     */
    public PositionXY getRightTop() {
        return rightTop;
    }

    /**
     * left, bottom 좌표 객체를 반환한다.
     *
     * @return left, bottom 좌표 객체
     */
    public PositionXY getLeftBottom() {
        return leftBottom;
    }

    /**
     * right, bottom 좌표 객체를 반환한다.
     *
     * @return right, bottom 좌표 객체
     */
    public PositionXY getRightBottom() {
        return rightBottom;
    }

    /**
     * 자르기 한 후 사각형의 left좌표를 반환한다.
     *
     * @return 자르기 한 후 사각형의 left좌표
     */
    public int getLeftAfterCutting() {
        return leftAfterCutting;
    }

    /**
     * 자르기 한 후 사각형의 left좌표를 설정한다.
     *
     * @param leftAfterCutting 자르기 한 후 사각형의 left좌표
     */
    public void setLeftAfterCutting(int leftAfterCutting) {
        this.leftAfterCutting = leftAfterCutting;
    }

    /**
     * 자르기 한 후 사각형의 top좌표를 반환한다.
     *
     * @return 자르기 한 후 사각형의 top좌표
     */
    public int getTopAfterCutting() {
        return topAfterCutting;
    }

    /**
     * 자르기 한 후 사각형의 top좌표를 설정한다.
     *
     * @param topAfterCutting 자르기 한 후 사각형의 top좌표
     */
    public void setTopAfterCutting(int topAfterCutting) {
        this.topAfterCutting = topAfterCutting;
    }

    /**
     * 자르기 한 후 사각형의 right좌표를 반환한다.
     *
     * @return 자르기 한 후 사각형의 right좌표
     */
    public int getRightAfterCutting() {
        return rightAfterCutting;
    }

    /**
     * 자르기 한 후 사각형의 right좌표를 설정한다.
     *
     * @param rightAfterCutting 자르기 한 후 사각형의 right좌표
     */
    public void setRightAfterCutting(int rightAfterCutting) {
        this.rightAfterCutting = rightAfterCutting;
    }

    /**
     * 자르기 한 후 사각형의 bottom좌표를 반환한다.
     *
     * @return 자르기 한 후 사각형의 bottom좌표
     */
    public int getBottomAfterCutting() {
        return bottomAfterCutting;
    }

    /**
     * 자르기 한 후 사각형의 bottom좌표를 설정한다.
     *
     * @param bottomAfterCutting 자르기 한 후 사각형의 bottom좌표
     */
    public void setBottomAfterCutting(int bottomAfterCutting) {
        this.bottomAfterCutting = bottomAfterCutting;
    }

    /**
     * 안쪽 여백 정보 객체를 반환한다.
     *
     * @return 안쪽 여백 정보 객체
     */
    public InnerMargin getInnerMargin() {
        return innerMargin;
    }

    /**
     * 그림 정보 객체를 반환한다.
     *
     * @return 그림 정보 객체
     */
    public PictureInfo getPictureInfo() {
        return pictureInfo;
    }

    /**
     * 테두리 투명도를 반환한다.
     *
     * @return 테두리 투명도
     */
    public short getBorderTransparency() {
        return borderTransparency;
    }

    /**
     * 테두리 투명도를 설정한다.
     *
     * @param borderTransparency 테두리 투명도
     */
    public void setBorderTransparency(short borderTransparency) {
        this.borderTransparency = borderTransparency;
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
     * 그림 효과 정보 객체를 반환한다.
     *
     * @return 그림 효과 정보 객체
     */
    public PictureEffect getPictureEffect() {
        return pictureEffect;
    }

    /**
     * 이미지 폭을 반환한다.(??)
     *
     * @return 이미지 폭
     */
    public long getImageWidth() {
        return imageWidth;
    }

    /**
     * 이미지 폭을 설정한다. (??)
     *
     * @param imageWidth 이미지 폭
     */
    public void setImageWidth(long imageWidth) {
        this.imageWidth = imageWidth;
    }

    /**
     * 이미지 높이를 반환한다. (??)
     *
     * @return 이미지 높이
     */
    public long getImageHeight() {
        return imageHeight;
    }

    /**
     * 이미지 높이를 설정한다. (??)
     *
     * @param imageHeight 이미지 높이
     */
    public void setImageHeight(long imageHeight) {
        this.imageHeight = imageHeight;
    }
}

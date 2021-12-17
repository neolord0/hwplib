package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;
import kr.dogfoot.hwplib.object.etc.Color4Byte;
import kr.dogfoot.hwplib.object.etc.HWPString;

import java.util.ArrayList;

public class ShapeComponentTextArt {
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
     * 내용
     */
    private HWPString content;
    /**
     * 글꼴이름
     */
    private HWPString fontName;
    /**
     * 글꼴스타일
     */
    private HWPString fontStyle;
    /**
     * 글꼴 타입 = 1:TTF/OTF, 2:HTF
     */
    private int fontType;
    /**
     * 글맵시 모양
     */
    private int textArtShape;
    /**
     * 줄 간격
     */
    private int lineSpace;
    /**
     * 글자 간격
     */
    private int charSpace;
    /**
     * 문단 정렬 = 0:왼쪽, 1:오른쪽, 2:중앙, 3:양끝, 4:양끝(끝줄 포함)
     */
    private int paraAlignment;
    /**
     * 그림자 타입 = 0: 없음, 1:비연속
     */
    private int shadowType;
    /**
     * 그림자 x offset
     */
    private int shadowOffsetX;
    /**
     * 그림자 y offset
     */
    private int shadowOffsetY;
    /**
     * 그림자 색상
     */
    private Color4Byte shadowColor;
    /**
     * outline list ??
     */
    private ArrayList<PositionXY> outlinePointList;

    public ShapeComponentTextArt() {
        content = new HWPString();
        fontName = new HWPString();
        fontStyle = new HWPString();
        shadowColor = new Color4Byte();
        outlinePointList = new ArrayList<>();
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

    /**
     * 내용을 반환한다.
     *
     * @return 내용
     */
    public HWPString getContent() {
        return content;
    }

    /**
     * 글꼴 이름을 반환한다.
     *
     * @return 글꼴 이름
     */
    public HWPString getFontName() {
        return fontName;
    }

    /**
     * 글꼴 스타일을 반환한다.
     *
     * @return 글꼴 스타일
     */
    public HWPString getFontStyle() {
        return fontStyle;
    }

    /**
     * 글꼴 타입을 반환한다.
     *
     * @return 글꼴 타입 = 1:TTF/OTF, 2:HTF
     */
    public int getFontType() {
        return fontType;
    }

    /**
     * 글꼴 타입을 설정한다.
     *
     * @param fontType 글꼴 타입 = 1:TTF/OTF, 2:HTF
     */
    public void setFontType(int fontType) {
        this.fontType = fontType;
    }

    /**
     * 글맵시 모양을 반환한다.
     *
     * @return 글맵시 모양
     */
    public int getTextArtShape() {
        return textArtShape;
    }

    /**
     * 글맵시 모양을 설정한다.
     *
     * @param textArtShape 글맵시 모양
     */
    public void setTextArtShape(int textArtShape) {
        this.textArtShape = textArtShape;
    }

    /**
     * 줄 간격을 반환한다.
     *
     * @return 줄 간격
     */
    public int getLineSpace() {
        return lineSpace;
    }

    /**
     * 줄 간격을 설정한다.
     *
     * @param lineSpace 줄 간격
     */
    public void setLineSpace(int lineSpace) {
        this.lineSpace = lineSpace;
    }

    /**
     * 글자 간격을 반환한다.
     *
     * @return 글자 간격
     */
    public int getCharSpace() {
        return charSpace;
    }

    /**
     * 글자 간격을 설정한다.
     *
     * @param charSpace 글자 간격
     */
    public void setCharSpace(int charSpace) {
        this.charSpace = charSpace;
    }

    /**
     * 문단 정렬을 반환한다.
     *
     * @return 문단 정렬 = 0:왼쪽, 1:오른쪽, 2:중앙, 3:양끝, 4:양끝(끝줄 포함)
     */
    public int getParaAlignment() {
        return paraAlignment;
    }

    /**
     * 문단 정렬을 설정한다.
     *
     * @param paraAlignment 문단 정렬 = 0:왼쪽, 1:오른쪽, 2:중앙, 3:양끝, 4:양끝(끝줄 포함)
     */
    public void setParaAlignment(int paraAlignment) {
        this.paraAlignment = paraAlignment;
    }

    /**
     * 그림자 타입을 반환한다.
     *
     * @return 그림자 타입 = 0: 없음, 1:비연속
     */
    public int getShadowType() {
        return shadowType;
    }

    /**
     * 그림자 타입을 설정한다.
     *
     * @param shadowType 그림자 타입 = 0: 없음, 1:비연속
     */
    public void setShadowType(int shadowType) {
        this.shadowType = shadowType;
    }

    /**
     * 그림자 x 오프셋을 반환한다.
     *
     * @return 그림자 x 오프셋
     */
    public int getShadowOffsetX() {
        return shadowOffsetX;
    }

    /**
     * 그림자 x 오프셋을 설정한다.
     *
     * @param shadowOffsetX 그림자 x 오프셋
     */
    public void setShadowOffsetX(int shadowOffsetX) {
        this.shadowOffsetX = shadowOffsetX;
    }

    /**
     * 그림자 y 오프셋을 반환한다.
     *
     * @return 그림자 y 오프셋
     */
    public int getShadowOffsetY() {
        return shadowOffsetY;
    }

    /**
     * 그림자 y 오프셋을 설정한다.
     *
     * @param shadowOffsetY 그림자 y 오프셋
     */
    public void setShadowOffsetY(int shadowOffsetY) {
        this.shadowOffsetY = shadowOffsetY;
    }

    /**
     * 그림자 색상을 반환한다.
     *
     * @return 그림자 색상
     */
    public Color4Byte getShadowColor() {
        return shadowColor;
    }

    /**
     * outline list을 반환한다.
     *
     * @return outline list
     */
    public ArrayList<PositionXY> getOutlinePointList() {
        return outlinePointList;
    }

    public void copy(ShapeComponentTextArt from) {
        x1 = from.x1;
        y1 = from.y1;
        x2 = from.x2;
        y2 = from.y2;
        x3 = from.x3;
        y3 = from.y3;
        x4 = from.x4;
        y4 = from.y4;
        content.copy(from.content);
        fontName.copy(from.fontName);
        fontStyle.copy(from.fontStyle);
        fontType = from.fontType;
        textArtShape = from.textArtShape;
        lineSpace = from.lineSpace;
        charSpace = from.charSpace;
        paraAlignment = from.paraAlignment;
        shadowType = from.shadowType;
        shadowOffsetX = from.shadowOffsetX;
        shadowOffsetY = from.shadowOffsetY;
        shadowColor.copy(from.shadowColor);
        for (PositionXY positionXY : from.outlinePointList) {
            PositionXY clonedPositionXY = new PositionXY();
            clonedPositionXY.copy(positionXY);

            outlinePointList.add(clonedPositionXY);
        }
    }
}

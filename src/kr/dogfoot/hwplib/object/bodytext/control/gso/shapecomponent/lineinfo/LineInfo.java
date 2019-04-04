package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo;

import kr.dogfoot.hwplib.object.etc.Color4Byte;

/**
 * 테두리 선 정보
 *
 * @author neolord
 */
public class LineInfo {
    /**
     * 선 색상
     */
    private Color4Byte color;
    /**
     * 선 굵기
     */
    private int thickness;
    /**
     * 속성
     */
    private LineInfoProperty property;
    /**
     * outline style
     */
    private OutlineStyle outlineStyle;

    /**
     * 생성자
     */
    public LineInfo() {
        color = new Color4Byte();
        property = new LineInfoProperty();
    }

    /**
     * 선 색상 객체를 반환한다.
     *
     * @return 선 색상 객체
     */
    public Color4Byte getColor() {
        return color;
    }

    /**
     * 선 굵기를 반환한다.
     *
     * @return 선 굵기
     */
    public int getThickness() {
        return thickness;
    }

    /**
     * 선 굵기를 설정한다.
     *
     * @param thickness 선 굵기
     */
    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    /**
     * 속성 객체를 반환한다.
     *
     * @return 속성 객체
     */
    public LineInfoProperty getProperty() {
        return property;
    }

    /**
     * outline style를 반환한다.
     *
     * @return outline style
     */
    public OutlineStyle getOutlineStyle() {
        return outlineStyle;
    }

    /**
     * outline style를 설정한다.
     *
     * @param outlineStyle outline style
     */
    public void setOutlineStyle(OutlineStyle outlineStyle) {
        this.outlineStyle = outlineStyle;
    }
}

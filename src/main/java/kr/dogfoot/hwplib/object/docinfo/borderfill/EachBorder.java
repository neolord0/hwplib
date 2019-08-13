package kr.dogfoot.hwplib.object.docinfo.borderfill;

import kr.dogfoot.hwplib.object.etc.Color4Byte;

/**
 * 테두리/배경 객체에서 4방향의 각각의 선을 나타내는 객체
 *
 * @author neolord
 */
public class EachBorder {
    /**
     * 선 종류
     */
    private BorderType type;
    /**
     * 두께
     */
    private BorderThickness thickness;
    /**
     * 색상
     */
    private Color4Byte color;

    /**
     * 생성자
     */
    public EachBorder() {
        color = new Color4Byte();
    }

    /**
     * 선의 종류를 반환한다.
     *
     * @return 선의 종류
     */
    public BorderType getType() {
        return type;
    }

    /**
     * 선의 종류를 설정한다.
     *
     * @param type 선의 종류
     */
    public void setType(BorderType type) {
        this.type = type;
    }

    /**
     * 선의 두께를 반환한다.
     *
     * @return 선의 두께
     */
    public BorderThickness getThickness() {
        return thickness;
    }

    /**
     * 선의 두께를 설정한다.
     *
     * @param thickness 선의 두께
     */
    public void setThickness(BorderThickness thickness) {
        this.thickness = thickness;
    }

    /**
     * 선의 색상 객체을 반환한다.
     *
     * @return 선의 색상 객체
     */
    public Color4Byte getColor() {
        return color;
    }
}

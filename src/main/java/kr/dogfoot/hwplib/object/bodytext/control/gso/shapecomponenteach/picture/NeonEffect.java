package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture;

/**
 * 네온 효과 속성
 *
 * @author neolord
 */
public class NeonEffect {
    /**
     * 네온 투명도
     */
    private float transparency;
    /**
     * 네온 반경
     */
    private float radius;
    /**
     * 네온 색상
     */
    private ColorWithEffect color;

    /**
     * 생성자
     */
    public NeonEffect() {
        color = new ColorWithEffect();
    }

    /**
     * 네온 투명도를 반환한다.
     *
     * @return 네온 투명도
     */
    public float getTransparency() {
        return transparency;
    }

    /**
     * 네온 투명도를 설정한다.
     *
     * @param transparency 네온 투명도
     */
    public void setTransparency(float transparency) {
        this.transparency = transparency;
    }

    /**
     * 네온 반경을 반환한다.
     *
     * @return 네온 반경
     */
    public float getRadius() {
        return radius;
    }

    /**
     * 네온 반경을 설정한다.
     *
     * @param radius 네온 반경
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * 네온 색상 객체를 반환한다.
     *
     * @return 네온 색상 객체
     */
    public ColorWithEffect getColor() {
        return color;
    }

    public void copy(NeonEffect from) {
        transparency = from.transparency;
        radius = from.radius;
        color.copy(from.color);
    }
}

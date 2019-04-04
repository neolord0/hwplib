package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture;

/**
 * 부드러운 가장자리 효과 속성
 *
 * @author neolord
 */
public class SoftEdgeEffect {
    /**
     * 변경
     */
    private float radius;

    /**
     * 생성
     */
    public SoftEdgeEffect() {
    }

    /**
     * 부드러운 가장자리 반경을 반환한다.
     *
     * @return 부드러운 가장자리 반경
     */
    public float getRadius() {
        return radius;
    }

    /**
     * 부드러운 가장자리 반경을 설정한다.
     *
     * @param radius 부드러운 가장자리 반경
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }
}

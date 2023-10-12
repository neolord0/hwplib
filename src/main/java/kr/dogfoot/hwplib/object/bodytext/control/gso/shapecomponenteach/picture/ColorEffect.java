package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture;

/**
 * 색상 효과 속성
 *
 * @author neolord
 */
public class ColorEffect {
    /**
     * 색상 효과 종류 (정보 없음)
     */
    private ColorEffectSort sort;
    /**
     * 색상 효과 값
     */
    private float value;

    /**
     * 생성자
     */
    public ColorEffect() {
    }

    /**
     * 색상 효과 종류를 반환한다.
     *
     * @return 색상 효과 종류
     */
    public ColorEffectSort getSort() {
        return sort;
    }

    /**
     * 색상 효과 종류를 설정한다.
     *
     * @param sort 색상 효과 종류
     */
    public void setSort(ColorEffectSort sort) {
        this.sort = sort;
    }

    /**
     * 색상 효과 값을 반환한다.
     *
     * @return 색상 효과 값
     */
    public float getValue() {
        return value;
    }

    /**
     * 색상 효과 값를 설정한다.
     *
     * @param value 색상 효과 값
     */
    public void setValue(float value) {
        this.value = value;
    }

    public ColorEffect clone() {
        ColorEffect cloned = new ColorEffect();
        cloned.sort = sort;
        cloned.value = value;
        return cloned;
    }
}

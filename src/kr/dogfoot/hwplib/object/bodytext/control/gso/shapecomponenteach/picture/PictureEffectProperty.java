package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 그림 효과의 속성을 나태내는 객체
 *
 * @author neolord
 */
public class PictureEffectProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public PictureEffectProperty() {
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public long getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값을 설정한다.
     *
     * @param value 파일에 저장되는 정수값
     */
    public void setValue(long value) {
        this.value = value;
    }

    /**
     * 그림자 효과 유무를 반환한다. (0 bit)
     *
     * @return 그림자 효과 유무
     */
    public boolean hasShadowEffect() {
        return BitFlag.get(value, 0);
    }

    /**
     * 그림자 효과 유무를 설정한다. (0 bit)
     *
     * @param hasShadowEffect 그림자 효과 유무
     */
    public void setHasShadowEffect(boolean hasShadowEffect) {
        value = BitFlag.set(value, 0, hasShadowEffect);
    }

    /**
     * 네온 효과 유무를 반환한다. (1 bit)
     *
     * @return 네온 효과 유무
     */
    public boolean hasNeonEffect() {
        return BitFlag.get(value, 1);
    }

    /**
     * 네온 효과 유무를 설정한다. (1 bit)
     *
     * @param hasNeonEffect 네온 효과 유무
     */
    public void setHasNeonEffect(boolean hasNeonEffect) {
        value = BitFlag.set(value, 1, hasNeonEffect);
    }

    /**
     * 부드러운 가장자리 효과 유무를 반환한다. (2 bit)
     *
     * @return 부드러운 가장자리 효과 유무
     */
    public boolean hasSoftBorderEffect() {
        return BitFlag.get(value, 2);
    }

    /**
     * 부드러운 가장자리 효과 유무를 설정한다. (2 bit)
     *
     * @param hasSoftBorderEffect 부드러운 가장자리 효과 유무
     */
    public void setHasSoftBorderEffect(boolean hasSoftBorderEffect) {
        value = BitFlag.set(value, 2, hasSoftBorderEffect);
    }

    /**
     * 반사 효과 유무를 반환한다. (3 bit)
     *
     * @return 반사 효과 유무
     */
    public boolean hasReflectionEffect() {
        return BitFlag.get(value, 3);
    }

    /**
     * 반사 효과 유무를 설정한다. (3 bit)
     *
     * @param hasReflectionEffect 반사 효과 유무
     */
    public void setHasReflectionEffect(boolean hasReflectionEffect) {
        value = BitFlag.set(value, 3, hasReflectionEffect);
    }
}

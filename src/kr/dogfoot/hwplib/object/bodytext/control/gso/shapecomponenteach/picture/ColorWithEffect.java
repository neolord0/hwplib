package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture;

import java.util.ArrayList;

/**
 * 색상 효과가 포함된 색상
 *
 * @author neolord
 */
public class ColorWithEffect {
    /**
     * 색상 타입 (정보 없음)
     */
    private int type;
    /**
     * 타입에 따른 색상 값 (정보 없음)
     */
    private byte[] color;
    /**
     * 색상 효과의 리스트
     */
    private ArrayList<ColorEffect> colorEffectList;

    /**
     * 생성자
     */
    public ColorWithEffect() {
        colorEffectList = new ArrayList<ColorEffect>();
    }

    /**
     * 색상 타입을 반환한다. (정보 없음)
     *
     * @return 색상 타입
     */
    public int getType() {
        return type;
    }

    /**
     * 색상 타입을 설정한다. (정보 없음)
     *
     * @param type 색상 타입
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * 타입에 따른 색상 값을 반환한다.(정보 없음)
     *
     * @return 타입에 따른 색상 값
     */
    public byte[] getColor() {
        return color;
    }

    /**
     * 타입에 따른 색상 값을 설정한다.
     *
     * @param color 타입에 따른 색상 값
     */
    public void setColor(byte[] color) {
        this.color = color;
    }

    /**
     * 새로운 색성 효과 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 색성 효과 객체
     */
    public ColorEffect addNewColorEffect() {
        ColorEffect ce = new ColorEffect();
        colorEffectList.add(ce);
        return ce;
    }

    /**
     * 색성 효과의 리스트를 반환한다.
     *
     * @return 색성 효과의 리스트
     */
    public ArrayList<ColorEffect> getColorEffectList() {
        return colorEffectList;
    }
}

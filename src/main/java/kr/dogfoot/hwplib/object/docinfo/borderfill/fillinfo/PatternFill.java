package kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo;

import kr.dogfoot.hwplib.object.etc.Color4Byte;

/**
 * 단색 채우기 객체
 *
 * @author neolord
 */
public class PatternFill {
    /**
     * 배경색
     */
    private Color4Byte backColor;
    /**
     * 무늬색
     */
    private Color4Byte patternColor;
    /**
     * 무늬 종류
     */
    private PatternType patternType;

    /**
     * 생성자
     */
    public PatternFill() {
        backColor = new Color4Byte();
        patternColor = new Color4Byte();
    }

    /**
     * 배경색 객체를 반환한다.
     *
     * @return 배경색 객체
     */
    public Color4Byte getBackColor() {
        return backColor;
    }

    /**
     * 무늬색 객체를 반환한다.
     *
     * @return 무늬색 객체
     */
    public Color4Byte getPatternColor() {
        return patternColor;
    }

    /**
     * 무늬 종류를 반환한다.
     *
     * @return 무늬 종류
     */
    public PatternType getPatternType() {
        return patternType;
    }

    /**
     * 무늬 종류를 설정한다.
     *
     * @param patternType 무늬 종류
     */
    public void setPatternType(PatternType patternType) {
        this.patternType = patternType;
    }
}

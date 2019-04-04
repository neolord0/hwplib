package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

/**
 * 한글(HWP) 글자의 종류
 *
 * @author neolord
 */
public enum HWPCharType {
    /**
     * 일반
     */
    Normal,
    /**
     * 문자 컨트롤
     */
    ControlChar,
    /**
     * 인라인 컨트롤
     */
    ControlInline,
    /**
     * 확장 컨트롤
     */
    ControlExtend
}

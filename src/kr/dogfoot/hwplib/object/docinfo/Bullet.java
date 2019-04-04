package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.numbering.ParagraphHeadInfo;

/**
 * 글머리표에 대한 레코드
 *
 * @author neolord
 */
public class Bullet {
    /**
     * 문단 머리의 정보
     */
    private ParagraphHeadInfo paragraphHeadInfo;
    /**
     * 글머리표 문자
     */
    private String bulletChar;

    /**
     * 생성자
     */
    public Bullet() {
        paragraphHeadInfo = new ParagraphHeadInfo();
    }

    /**
     * 문단 머리의 정보에 대한 객체를 반환한다.
     *
     * @return 문단 머리의 정보에 대한 객체
     */
    public ParagraphHeadInfo getParagraphHeadInfo() {
        return paragraphHeadInfo;
    }

    /**
     * 글머리표 문자를 반환한다.
     *
     * @return 글머리표 문자
     */
    public String getBulletChar() {
        return bulletChar;
    }

    /**
     * 글머리표 문자를 설정한다.
     *
     * @param bulletChar 글머리표 문자
     */
    public void setBulletChar(String bulletChar) {
        this.bulletChar = bulletChar;
    }
}

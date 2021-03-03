package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.numbering.ParagraphHeadInfo;
import kr.dogfoot.hwplib.object.etc.HWPString;

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
    private HWPString bulletChar;

    /**
     * 생성자
     */
    public Bullet() {
        paragraphHeadInfo = new ParagraphHeadInfo();
        bulletChar = new HWPString();
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
    public HWPString getBulletChar() {
        return bulletChar;
    }

    public Bullet clone() {
        Bullet cloned = new Bullet();
        cloned.paragraphHeadInfo.copy(paragraphHeadInfo);
        cloned.bulletChar.copy(bulletChar);
        return cloned;
    }
}

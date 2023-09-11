package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.PictureInfo;
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
     * 그림 글머리표 여부
     */
    private boolean imageBullet;
    /**
     * 그림 글머리표 정보
     */
    private PictureInfo imageBulletInfo;
    /**
     * 체크 글머리표 문자
     */
    private HWPString checkBulletChar;

    /**
     * 생성자
     */
    public Bullet() {
        paragraphHeadInfo = new ParagraphHeadInfo();
        bulletChar = new HWPString();
        imageBullet = false;
        imageBulletInfo = new PictureInfo();
        checkBulletChar = new HWPString();
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

    public boolean getImageBullet() {
        return imageBullet;
    }

    public void setImageBullet(boolean imageBullet) {
        this.imageBullet = imageBullet;
    }

    public PictureInfo getImageBulletInfo() {
        return imageBulletInfo;
    }

    public HWPString getCheckBulletChar() {
        return checkBulletChar;
    }

    public Bullet clone() {
        Bullet cloned = new Bullet();
        cloned.paragraphHeadInfo.copy(paragraphHeadInfo);
        cloned.bulletChar.copy(bulletChar);
        cloned.imageBullet = imageBullet;
        cloned.imageBulletInfo.copy(imageBulletInfo);
        cloned.checkBulletChar.copy(checkBulletChar);
        return cloned;
    }
}

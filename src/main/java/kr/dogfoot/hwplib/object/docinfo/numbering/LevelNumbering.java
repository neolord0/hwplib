package kr.dogfoot.hwplib.object.docinfo.numbering;

import kr.dogfoot.hwplib.object.etc.HWPString;

/**
 * 각 수준(1~7)에 해당하는 문단 번호 정보
 *
 * @author neolord
 */
public class LevelNumbering {
    /**
     * 문단 머리 정보
     */
    private ParagraphHeadInfo paragraphHeadInfo;
    /**
     * 번호 형식
     */
    private HWPString numberFormat;
    /**
     * 수준별 시작번호 (5.0.2.5 이상)
     */
    private long startNumber;

    /**
     * 생성자
     */
    public LevelNumbering() {
        paragraphHeadInfo = new ParagraphHeadInfo();
        numberFormat = new HWPString();
    }

    /**
     * 문단 머리 정보에 대한 객체를 반환한다.
     *
     * @return 문단 머리 정보에 대한 객체
     */
    public ParagraphHeadInfo getParagraphHeadInfo() {
        return paragraphHeadInfo;
    }

    /**
     * 번호 형식을 반환한다.
     *
     * @return 번호 형식
     */
    public HWPString getNumberFormat() {
        return numberFormat;
    }

    /**
     * 수준별 시작번호를 반환한다.
     *
     * @return 수준별 시작번호
     */
    public long getStartNumber() {
        return startNumber;
    }

    /**
     * 수준별 시작번호를 설정한다.
     *
     * @param startNumber 수준별 시작번호
     */
    public void setStartNumber(long startNumber) {
        this.startNumber = startNumber;
    }

    public void copy(LevelNumbering from) {
        paragraphHeadInfo.copy(from.paragraphHeadInfo);
        numberFormat.copy(from.numberFormat);
        startNumber = from.startNumber;
    }
}



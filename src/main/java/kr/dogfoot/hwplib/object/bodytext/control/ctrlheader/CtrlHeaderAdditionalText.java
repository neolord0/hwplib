package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.additionaltext.AdditionalTextPosition;
import kr.dogfoot.hwplib.object.docinfo.parashape.Alignment;

/**
 * 덧말 컨트롤을 위한 컨트롤 헤더 레코드
 *
 * @author neolord
 */
public class CtrlHeaderAdditionalText extends CtrlHeader {
    /**
     * main text
     */
    private String mainText;
    /**
     * sub text
     */
    private String subText;
    /**
     * 덧말 위치
     */
    private AdditionalTextPosition position;
    /**
     * 폰트 크기 비율(??)
     */
    private long fsizeratio;
    /**
     * 옵션(??)
     */
    private long option;
    /**
     * Style Number
     */
    private long styleId;
    /**
     * 정령 기준
     */
    private Alignment alignment;

    /**
     * 생성자
     */
    public CtrlHeaderAdditionalText() {
        super(ControlType.AdditionalText.getCtrlId());
    }

    /**
     * main text를 반환한다.
     *
     * @return main text
     */
    public String getMainText() {
        return mainText;
    }

    /**
     * main text를 설정한다.
     *
     * @param mainText main text
     */
    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    /**
     * sub text를 반환한다.
     *
     * @return sub text
     */
    public String getSubText() {
        return subText;
    }

    /**
     * sub text를 설정한다.
     *
     * @param subText sub text
     */
    public void setSubText(String subText) {
        this.subText = subText;
    }

    /**
     * 덧말 위치 을 반환한다.
     *
     * @return 덧말 위치
     */
    public AdditionalTextPosition getPosition() {
        return position;
    }

    /**
     * 덧말 위치 를 설정한다.
     *
     * @param position 덧말 위치
     */
    public void setPosition(AdditionalTextPosition position) {
        this.position = position;
    }

    /**
     * 폰트 크기 비율(??)을 반환한다.
     *
     * @return 폰트 크기 비율(??)
     */
    public long getFsizeratio() {
        return fsizeratio;
    }

    /**
     * 폰트 크기 비율(??)을 설정한다.
     *
     * @param fsizeratio 폰트 크기 비율(??)
     */
    public void setFsizeratio(long fsizeratio) {
        this.fsizeratio = fsizeratio;
    }

    /**
     * 옵션(??)을 반환한다.
     *
     * @return 옵션(? ?)
     */
    public long getOption() {
        return option;
    }

    /**
     * 옵션(??)을 설정한다.
     *
     * @param option
     */
    public void setOption(long option) {
        this.option = option;
    }

    /**
     * Style Number를 반환한다.
     *
     * @return Style Number
     */
    public long getStyleId() {
        return styleId;
    }

    /**
     * Style Number를 설정한다.
     *
     * @param styleId Style Number
     */
    public void setStyleId(long styleId) {
        this.styleId = styleId;
    }

    /**
     * 정령 기준을 반환한다.
     *
     * @return 정령 기준
     */
    public Alignment getAlignment() {
        return alignment;
    }

    /**
     * 정령 기준을 설정한다.
     *
     * @param alignment 정령 기준
     */
    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }
}

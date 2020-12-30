package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 그리기 객체 컨트롤의 속성을 나타내는 객체
 *
 * @author neolord
 */
public class GsoHeaderProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public GsoHeaderProperty() {
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
     * 글자처럼 취급 여부을 반환한다. (0 bit)
     *
     * @return 글자처럼 취급 여부
     */
    public boolean isLikeWord() {
        return BitFlag.get(value, 0);
    }

    /**
     * 글자처럼 취급 여부를 설정한다. (0 bit)
     *
     * @param likeWord 글자처럼 취급 여부
     */
    public void setLikeWord(boolean likeWord) {
        value = BitFlag.set(value, 0, likeWord);
    }

    /**
     * 줄 간격에 영향을 줄지 여부를 반환한다. (2 bit)
     *
     * @return 줄 간격에 영향을 줄지 여부
     */
    public boolean isApplyLineSpace() {
        return BitFlag.get(value, 2);
    }

    /**
     * 줄 간격에 영향을 줄지 여부를 설정한다. (2 bit)
     *
     * @param applyLineSpace 줄 간격에 영향을 줄지 여부
     */
    public void setApplyLineSpace(boolean applyLineSpace) {
        value = BitFlag.set(value, 2, applyLineSpace);
    }

    /**
     * 세로 위치의 기준을 반환한다. (3~4 bit)
     *
     * @return 세로 위치의 기준
     */
    public VertRelTo getVertRelTo() {
        return VertRelTo.valueOf((byte) BitFlag.get(value, 3, 4));
    }

    /**
     * 세로 위치의 기준을 설정한다. (3~4 bit)
     *
     * @param vertRelTo 세로 위치의 기준
     */
    public void setVertRelTo(VertRelTo vertRelTo) {
        value = BitFlag.set(value, 3, 4, vertRelTo.getValue());
    }

    /**
     * 세로 위치의 기준에 대한 상대적인 배열방식을 반환한다. (5~7 bit)
     *
     * @return 세로 위치의 기준에 대한 상대적인 배열방식
     */
    public RelativeArrange getVertRelativeArrange() {
        return RelativeArrange.valueOf((byte) BitFlag.get(value, 5, 7));
    }

    /**
     * 세로 위치의 기준에 대한 상대적인 배열방식를 설정한다. (5~7 bit)
     *
     * @param vertRelativeArrange 세로 위치의 기준에 대한 상대적인 배열방식
     */
    public void setVertRelativeArrange(RelativeArrange vertRelativeArrange) {
        value = BitFlag.set(value, 5, 7, vertRelativeArrange.getValue());
    }

    /**
     * 가로 위치의 기준을 반환한다. (8~9 bit)
     *
     * @return 가로 위치의 기준
     */
    public HorzRelTo getHorzRelTo() {
        return HorzRelTo.valueOf((byte) BitFlag.get(value, 8, 9));
    }

    /**
     * 가로 위치의 기준을 설정한다. (8~9 bit)
     *
     * @param horzRelTo 가로 위치의 기준
     */
    public void setHorzRelTo(HorzRelTo horzRelTo) {
        value = BitFlag.set(value, 8, 9, horzRelTo.getValue());
    }

    /**
     * HorzRelTo에 대한 상대적인 배열방식을 반환한다. (10~12 bit)
     *
     * @return HorzRelTo에 대한 상대적인 배열방식
     */
    public RelativeArrange getHorzRelativeArrange() {
        return RelativeArrange.valueOf((byte) BitFlag.get(value, 10, 12));
    }

    /**
     * HorzRelTo에 대한 상대적인 배열방식을 설정한다. (10~12 bit)
     *
     * @param horzRelativeArrange HorzRelTo에 대한 상대적인 배열방식
     */
    public void setHorzRelativeArrange(RelativeArrange horzRelativeArrange) {
        value = BitFlag.set(value, 10, 12, horzRelativeArrange.getValue());
    }

    /**
     * VertRelTo이 ‘para’일 때 오브젝트의 세로 위치를 본문 영역으로 제한할지 여부를 반환한다. (13 bit)
     *
     * @return VertRelTo이 ‘para’일 때 오브젝트의 세로 위치를 본문 영역으로 제한할지 여부
     */
    public boolean isVertRelToParaLimit() {
        return BitFlag.get(value, 13);
    }

    /**
     * VertRelTo이 ‘para’일 때 오브젝트의 세로 위치를 본문 영역으로 제한할지 여부을 설정한다.
     *
     * @param vertRelToParaLimit VertRelTo이 ‘para’일 때 오브젝트의 세로 위치를 본문 영역으로 제한할지 여부
     */
    public void setVertRelToParaLimit(boolean vertRelToParaLimit) {
        value = BitFlag.set(value, 13, vertRelToParaLimit);
    }

    /**
     * 다른 오브젝트와 겹치는 것을 허용할지 여부을 반한한다. (14 bit)
     *
     * @return 다른 오브젝트와 겹치는 것을 허용할지 여부
     */
    public boolean isAllowOverlap() {
        return BitFlag.get(value, 14);
    }

    /**
     * 다른 오브젝트와 겹치는 것을 허용할지 여부을 설정한다. (14 bit)
     *
     * @param allowOverlap 다른 오브젝트와 겹치는 것을 허용할지 여부
     */
    public void setAllowOverlap(boolean allowOverlap) {
        value = BitFlag.set(value, 14, allowOverlap);
    }

    /**
     * 오브젝트 폭의 기준을 반환한다. (15~17 bit)
     *
     * @return 오브젝트 폭의 기준
     */
    public WidthCriterion getWidthCriterion() {
        return WidthCriterion.valueOf((byte) BitFlag.get(value, 15, 17));
    }

    /**
     * 오브젝트 폭의 기준을 설정한다. (15~17 bit)
     *
     * @param widthCriterion 오브젝트 폭의 기준
     */
    public void setWidthCriterion(WidthCriterion widthCriterion) {
        value = BitFlag.set(value, 15, 17, widthCriterion.getValue());
    }

    /**
     * 오브젝트 높이의 기준을 반환한다 (18~19 bit)
     *
     * @return 오브젝트 높이의 기준
     */
    public HeightCriterion getHeightCriterion() {
        return HeightCriterion.valueOf((byte) BitFlag.get(value, 18, 19));
    }

    /**
     * 오브젝트 높이의 기준을 설정한다. (18~19 bit)
     *
     * @param heightCriterion 오브젝트 높이의 기준
     */
    public void setHeightCriterion(HeightCriterion heightCriterion) {
        value = BitFlag.set(value, 18, 19, heightCriterion.getValue());
    }

    /**
     * VertRelTo이 para일 때 크기 보호 여부을 반환한다. (20 bit)
     *
     * @return VertRelTo이 para일 때 크기 보호 여부
     */
    public boolean isProtectSize() {
        return BitFlag.get(value, 20);
    }

    /**
     * VertRelTo이 para일 때 크기 보호 여부를 설정한다.
     *
     * @param protectSize VertRelTo이 para일 때 크기 보호 여부
     */
    public void setProtectSize(boolean protectSize) {
        value = BitFlag.set(value, 20, protectSize);
    }

    /**
     * 오브젝트 주위를 텍스트가 어떻게 흘러갈지 지정하는 옵션을 반환한다. (21~23 bit)
     *
     * @return 오브젝트 주위를 텍스트가 어떻게 흘러갈지 지정하는 옵션
     */
    public TextFlowMethod getTextFlowMethod() {
        return TextFlowMethod.valueOf((byte) BitFlag.get(value, 21, 23));
    }

    /**
     * 오브젝트 주위를 텍스트가 어떻게 흘러갈지 지정하는 옵션을 설정한다. (21~23 bit)
     *
     * @param textFlowMethod 오브젝트 주위를 텍스트가 어떻게 흘러갈지 지정하는 옵션
     */
    public void setTextFlowMethod(TextFlowMethod textFlowMethod) {
        value = BitFlag.set(value, 21, 23, textFlowMethod.getValue());
    }

    /**
     * 오브젝트의 좌/우 어느 쪽에 글을 배치할지 지정하는 옵션을 반환한다. (24~25 bit)
     *
     * @return 오브젝트의 좌/우 어느 쪽에 글을 배치할지 지정하는 옵션
     */
    public TextHorzArrange getTextHorzArrange() {
        return TextHorzArrange.valueOf((byte) BitFlag.get(value, 24, 25));
    }

    /**
     * 오브젝트의 좌/우 어느 쪽에 글을 배치할지 지정하는 옵션을 설정한다. (24~25 bit)
     *
     * @param textHorzArrange 오브젝트의 좌/우 어느 쪽에 글을 배치할지 지정하는 옵션
     */
    public void setTextHorzArrange(TextHorzArrange textHorzArrange) {
        value = BitFlag.set(value, 24, 25, textHorzArrange.getValue());
    }

    /**
     * 개체가 속하는 번호 범주를 반환한다. (26~28 bit)
     *
     * @return 개체가 속하는 번호 범주
     */
    public ObjectNumberSort getObjectNumberSort() {
        return ObjectNumberSort.valueOf((byte) BitFlag.get(value, 26, 28));
    }

    /**
     * 개체가 속하는 번호 범주를 설정한다. (26~28 bit)
     *
     * @param objectNumberSort 개체가 속하는 번호 범주
     */
    public void setObjectNumberSort(ObjectNumberSort objectNumberSort) {
        value = BitFlag.set(value, 26, 28, objectNumberSort.getValue());
    }

    public void copy(GsoHeaderProperty from) {
        value = from.value;
    }

}

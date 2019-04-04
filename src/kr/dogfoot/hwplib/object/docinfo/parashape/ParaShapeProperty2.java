package kr.dogfoot.hwplib.object.docinfo.parashape;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 문단 모양의 속성2 객체. (5.0.1.7 버전 이상)
 *
 * @author neolord
 */
public class ParaShapeProperty2 {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public ParaShapeProperty2() {
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
     * 한 줄로 입력 여부를 설정한다. (0~1 bit)
     *
     * @return 한 줄로 입력 여부
     */
    public boolean isInputSingleLine() {
        return BitFlag.get(value, 0) | BitFlag.get(value, 1);
    }

    /**
     * 한 줄로 입력 여부를 설정한다. (0~1 bit)
     *
     * @param inputSingleLine 한 줄로 입력 여부
     */
    public void setInputSingleLine(boolean inputSingleLine) {
        value = BitFlag.set(value, 0, inputSingleLine);
        value = BitFlag.set(value, 1, inputSingleLine);
    }

    /**
     * 한글과 영어 간격을 자동 조절 여부를 반환한다. (4 bit)
     *
     * @return 한글과 영어 간격을 자동 조절 여부
     */
    public boolean isAutoAdjustGapHangulEnglish() {
        return BitFlag.get(value, 4);
    }

    /**
     * 한글과 영어 간격을 자동 조절 여부를 설정한다. (4 bit)
     *
     * @param autoAdjustGapHangulEnglish 한글과 영어 간격을 자동 조절 여부
     */
    public void setAutoAdjustGapHangulEnglish(boolean autoAdjustGapHangulEnglish) {
        value = BitFlag.set(value, 4, autoAdjustGapHangulEnglish);
    }

    /**
     * 한글과 숫자 간격을 자동 조절 여부를 반환한다. (5 bit)
     *
     * @return 한글과 숫자 간격을 자동 조절 여부
     */
    public boolean isAutoAdjustGapHangulNumber() {
        return BitFlag.get(value, 5);
    }

    /**
     * 한글과 숫자 간격을 자동 조절 여부를 설정한다. (5 bit)
     *
     * @param autoAdjustGapHangulNumber 한글과 숫자 간격을 자동 조절 여부
     */
    public void setAutoAdjustGapHangulNumber(boolean autoAdjustGapHangulNumber) {
        value = BitFlag.set(value, 5, autoAdjustGapHangulNumber);
    }
}

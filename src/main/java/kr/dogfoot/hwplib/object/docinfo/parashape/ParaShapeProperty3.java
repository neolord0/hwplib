package kr.dogfoot.hwplib.object.docinfo.parashape;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 문단 모양의 속성3 객체. (5.0.2.5 버전 이상)
 *
 * @author neolord
 */
public class ParaShapeProperty3 {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public ParaShapeProperty3() {
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
     * 줄 간격 종류를 반환한다. (0~4 bit)
     *
     * @return 줄 간격 종류
     */
    public LineSpaceSort getLineSpaceSort() {
        return LineSpaceSort.valueOf((byte) BitFlag.get(value, 0, 4));
    }

    /**
     * 줄 간격 종류를 설정한다. (0~4 bit)
     *
     * @param lineSpaceSort 줄 간격 종류
     */
    public void setLineSpaceSort(LineSpaceSort lineSpaceSort) {
        value = BitFlag.set(value, 0, 4, lineSpaceSort.getValue());
    }

    public void copy(ParaShapeProperty3 from) {
        value = from.value;
    }
}

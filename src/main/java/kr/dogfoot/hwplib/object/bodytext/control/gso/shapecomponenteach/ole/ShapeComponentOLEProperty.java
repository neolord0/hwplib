package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ole;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * OLE 개체의 속성에 대한 객체
 *
 * @author neolord
 */
public class ShapeComponentOLEProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public ShapeComponentOLEProperty() {
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
     * DVASPECT값을 반환한다.
     *
     * @return DVASPECT값
     */
    public DVASPECT getDVASPECT() {
        return DVASPECT.valueOf((byte) BitFlag.get(value, 0, 7));
    }

    /**
     * DVASPECT값를 설정한다.
     *
     * @param dvaspect DVASPECT값
     */
    public void setDVASPECT(DVASPECT dvaspect) {
        value = BitFlag.set(value, 0, 7, dvaspect.getValue());
    }

    /**
     * moniker가 지정되었는지 여부를 반환한다.
     *
     * @return moniker가 지정되었는지 여부
     */
    public boolean isMoniker() {
        return BitFlag.get(value, 8);
    }

    /**
     * moniker가 지정되었는지 여부를 설정한다.
     *
     * @param moniker moniker가 지정되었는지 여부
     */
    public void setMoniker(boolean moniker) {
        value = BitFlag.set(value, 8, moniker);
    }

    /**
     * 베이스라인 값을 반환한다. 0은 디폴트(85%)를 뜻하고, 1～101이 0～100%를 나타낸다. 현재는 수식만이 베이스라인을 별도로
     * 가진다.
     *
     * @return 베이스라인 값
     */
    public byte getBaseLine() {
        return (byte) BitFlag.get(value, 9, 15);
    }

    /**
     * 베이스라인 값을 설정한다. 0은 디폴트(85%)를 뜻하고, 1～101이 0～100%를 나타낸다. 현재는 수식만이 베이스라인을 별도로
     * 가진다.
     *
     * @param baseLine 베이스라인 값
     */
    public void setBaseLine(byte baseLine) {
        value = BitFlag.set(value, 9, 15, baseLine);
    }

    /**
     * 개체 종류를 반환한다.
     *
     * @return 개체 종류
     */
    public ObjectSort getObjectSort() {
        return ObjectSort.valueOf((byte) BitFlag.get(value, 16, 21));
    }

    /**
     * 개체 종류를 설정한다.
     *
     * @param objectSort 개체 종류
     */
    public void setObjectSort(ObjectSort objectSort) {
        value = BitFlag.set(value, 16, 21, objectSort.getValue());
    }

    public void copy(ShapeComponentOLEProperty from) {
        value = from.value;
    }
}

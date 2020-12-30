package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ellipse;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 타원 개체의 속성을 나타내는 객체
 *
 * @author neolord
 */
public class ShapeComponentEllipseProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public ShapeComponentEllipseProperty() {
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
     * 호(ARC)로 바뀌었을 때 interval을 다시 계산해야 할 필요가 있는지 여부를 반환한다. (0 bit)
     *
     * @return 호(ARC)로 바뀌었을 때 interval을 다시 계산해야 할 필요가 있는지 여부
     */
    public boolean isRecalculateIntervalWhenChangingArc() {
        return BitFlag.get(value, 0);
    }

    /**
     * 호(ARC)로 바뀌었을 때 interval을 다시 계산해야 할 필요가 있는지 여부를 설정한다. (0 bit)
     *
     * @param recalculateIntervalWhenChanging 호(ARC)로 바뀌었을 때 interval을 다시 계산해야 할 필요가 있는지 여부
     */
    public void setRecalculateIntervalWhenChangingArc(
            boolean recalculateIntervalWhenChanging) {
        value = BitFlag.set(value, 0, recalculateIntervalWhenChanging);
    }

    /**
     * 호(ARC)로 바뀌었는지 여부를 반환한다. (1 bit)
     *
     * @return 호(ARC)로 바뀌었는지 여부
     */
    public boolean isChangeArc() {
        return BitFlag.get(value, 1);
    }

    /**
     * 호(ARC)로 바뀌었는지 여부를 설정한다. (1 bit)
     *
     * @param changeArc 호(ARC)로 바뀌었는지 여부
     */
    public void setChangeArc(boolean changeArc) {
        value = BitFlag.set(value, 1, changeArc);
    }

    /**
     * 호(ARC)의 종류를 반환한다.(정보 부족) (2~9 bit)
     *
     * @return 호(ARC)의 종류
     */
    public short getArcSort() {
        return (short) BitFlag.get(value, 2, 9);
    }

    /**
     * 호(ARC)의 종류를 설정한다. (정보 부족) (2~9 bit)
     *
     * @param arcSort 호(ARC)의 종류
     */
    public void setArcSort(short arcSort) {
        value = BitFlag.set(value, 2, 9, arcSort);
    }

    public void copy(ShapeComponentEllipseProperty from) {
        value = from.value;
    }
}

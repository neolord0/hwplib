package kr.dogfoot.hwplib.object.docinfo.borderfill;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 테두리/배경 객체의 속성
 *
 * @author neolord
 */
public class BorderFillProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 2 byte)
     */
    private int value;

    /**
     * 생성자
     */
    public BorderFillProperty() {
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public int getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값을 설정한다.
     *
     * @param value 파일에 저장되는 정수값
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 3D 효과의 유무를 반한한다.(0 bit)
     *
     * @return 3D 효과의 유무를
     */
    public boolean is3DEffect() {
        return BitFlag.get(value, 0);
    }

    /**
     * 3D 효과의 유무를 설정한다.(0 bit)
     *
     * @param _3DEffect 3D 효과의 유무
     */
    public void set3DEffect(boolean _3DEffect) {
        value = BitFlag.set(value, 0, _3DEffect);
    }

    /**
     * 그림자 효과의 유무를 반환한다. (1 bit)
     *
     * @return 그림자 효과의 유무
     */
    public boolean isShadowEffect() {
        return BitFlag.get(value, 1);
    }

    /**
     * 그림자 효과의 유무를 설정한다. (1 bit)
     *
     * @param shadowEffect
     */
    public void setShadowEffect(boolean shadowEffect) {
        value = BitFlag.set(value, 1, shadowEffect);
    }

    /**
     * Slash 대각선 모양을 반환한다.(2~4 BitFlag)
     *
     * @return Slash 대각선 모양
     */
    public SlashDiagonalShape getSlashDiagonalShape() {
        return SlashDiagonalShape.valueOf((byte) BitFlag.get(value, 2, 4));
    }

    /**
     * Slash 대각선 모양를 설정한다. (2~4 BitFlag)
     *
     * @param diagonaShape Slash 대각선 모양
     */
    public void setSlashDiagonalShape(SlashDiagonalShape diagonaShape) {
        value = BitFlag.set(value, 2, 4, diagonaShape.getValue());
    }

    /**
     * BackSlash 대각선 모양을 반환한다. (5~7 BitFlag)
     *
     * @return BackSlash 대각선 모양
     */
    public BackSlashDiagonalShape getBackSlashDiagonalShape() {
        return BackSlashDiagonalShape.valueOf((byte) BitFlag.get(value, 5, 7));
    }

    /**
     * BackSlash 대각선 모양를 설정한다. (5~7 BitFlag)
     *
     * @param diagonaShape BackSlash 대각선 모양
     */
    public void setBackSlashDiagonalShape(BackSlashDiagonalShape diagonaShape) {
        value = BitFlag.set(value, 5, 7, diagonaShape.getValue());
    }

    /**
     * Slash 대각선이 꺽은선인지 아닌지 여부를 반환한다. (8~9 BitFlag)
     *
     * @return Slash 대각선이 꺽은선인지 아닌지 여부
     */
    public boolean isBrokenSlashDiagonal() {
        return BitFlag.get(value, 8) || BitFlag.get(value, 9);
    }

    /**
     * Slash 대각선이 꺽은선인지 아닌지 여부를 설정한다. (8~9 BitFlag)
     *
     * @param brokenSlashDiagonal Slash 대각선이 꺽은선인지 아닌지 여부
     */
    public void setBrokenSlashDiagonal(boolean brokenSlashDiagonal) {
        value = BitFlag.set(value, 8, brokenSlashDiagonal);
        value = BitFlag.set(value, 9, brokenSlashDiagonal);
    }

    /**
     * BackSlash 대각선이 꺽은선인지 아닌지 여부를 반환한다. (10 bit)
     *
     * @return BackSlash 대각선이 꺽은선인지 아닌지 여부
     */
    public boolean isBrokenBackSlashDiagonal() {
        return BitFlag.get(value, 10);
    }

    /**
     * BackSlash 대각선이 꺽은선인지 아닌지 여부를 설정한다. (10 bit)
     *
     * @param brokenBackSlashDiagonal BackSlash 대각선이 꺽은선인지 아닌지 여부
     */
    public void setBrokenBackSlashDiagonal(boolean brokenBackSlashDiagonal) {
        value = BitFlag.set(value, 10, brokenBackSlashDiagonal);
    }

    /**
     * Slash 대각선의 180도 회전 여부를 반환한다. (11 bit)
     *
     * @return Slash 대각선의 180도 회전 여부
     */
    public boolean isRotateSlashDiagonal180() {
        return BitFlag.get(value, 11);
    }

    /**
     * Slash 대각선의 180도 회전 여부를 설정한다 (11 bit)
     *
     * @param rotateSlashDiagonal180 Slash 대각선의 180도 회전 여부
     */
    public void setRotateSlashDiagonal180(boolean rotateSlashDiagonal180) {
        value = BitFlag.set(value, 11, rotateSlashDiagonal180);
    }

    /**
     * BackSlash 대각선의 180도 회전 여부를 반환한다. (12 bit)
     *
     * @return BackSlash 대각선의 180도 회전 여부
     */
    public boolean isRotateBackSlashDiagonal180() {
        return BitFlag.get(value, 12);
    }

    /**
     * BackSlash 대각선의 180도 회전 여부를 설정한다. (12 bit)
     *
     * @param rotateBackSlashDiagonal180 BackSlash 대각선의 180도 회전 여부
     */
    public void setRotateBackSlashDiagonal180(boolean rotateBackSlashDiagonal180) {
        value = BitFlag.set(value, 12, rotateBackSlashDiagonal180);
    }

    /**
     * 중심선을 가졌는지 여부를 반환한다. (13 bit)
     *
     * @return 중심선을 가졌는지 여부
     */
    public boolean hasCenterLine() {
        return BitFlag.get(value, 13);
    }

    /**
     * 중심선을 가졌는지 여부를 설정한다. (13 bit)
     *
     * @param hasCenterLine 중심선을 가졌는지 여부를
     */
    public void setHasCenterLine(boolean hasCenterLine) {
        value = BitFlag.set(value, 13, hasCenterLine);
    }

    public void copy(BorderFillProperty from) {
        value = from.value;
    }
}

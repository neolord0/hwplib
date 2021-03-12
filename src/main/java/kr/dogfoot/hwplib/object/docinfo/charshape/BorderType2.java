package kr.dogfoot.hwplib.object.docinfo.charshape;

import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;

/**
 * 문자선(밑줄 or 취소선) 종류
 *
 * @author neolord
 */
public enum BorderType2 {
    /**
     * 실선
     */
    Solid((byte) 0),
    /**
     * 긴 점선 (쇄선)
     */
    Dash((byte) 1),
    /**
     * 점선
     */
    Dot((byte) 2),
    /**
     * -.-.-.-.(일점 쇄선)
     */
    DashDot((byte) 3),
    /**
     * -..-..-..(이점 쇄선)
     */
    DashDotDot((byte) 4),
    /**
     * Dash보다 긴 선분의 반복
     */
    LongDash((byte) 5),
    /**
     * Dot보다 큰 동그라미의 반복
     */
    CircleDot((byte) 6),
    /**
     * 2중선
     */
    Double((byte) 7),
    /**
     * 가는선 + 굵은선 2중선
     */
    ThinThick((byte) 8),
    /**
     * 굵은선 + 가는선 2중선
     */
    ThickThin((byte) 9),
    /**
     * 가는선 + 굵은선 + 가는선 3중선
     */
    ThinThickThin((byte) 10),
    /**
     * 물결
     */
    Wave((byte) 11),
    /**
     * 물결 2중선
     */
    DoubleWave((byte) 12),
    /**
     * 두꺼운 3D
     */
    Thick3D((byte) 13),
    /**
     * 두꺼운 3D(광원 반대)
     */
    Thick3DReverseLighting((byte) 14),
    /**
     * 3D 단선
     */
    Solid3D((byte) 15),
    /**
     * 3D 단선(광원 반대)
     */
    Solid3DReverseLighting((byte) 16);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    BorderType2(byte value) {
        this.value = value;
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public byte getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값에 해당되는 enum 값을 반환한다.
     *
     * @param value 파일에 저장되는 정수값
     * @return enum 값
     */
    public static BorderType2 valueOf(byte value) {
        for (BorderType2 bt : values()) {
            if (bt.value == value) {
                return bt;
            }
        }
        return Solid;
    }

    public BorderType toBorderType() {
        switch (this) {
            case Solid:
                return BorderType.Solid;
            case Dash:
                return BorderType.Dash;
            case Dot:
                return BorderType.Dot;
            case DashDot:
                return BorderType.DashDot;
            case DashDotDot:
                return BorderType.DashDotDot;
            case LongDash:
                return BorderType.LongDash;
            case CircleDot:
                return BorderType.CircleDot;
            case Double:
                return BorderType.Double;
            case ThinThick:
                return BorderType.ThinThick;
            case ThickThin:
                return BorderType.ThickThin;
            case ThinThickThin:
                return BorderType.ThinThickThin;
            case Wave:
                return BorderType.Wave;
            case DoubleWave:
                return BorderType.DoubleWave;
            case Thick3D:
                return BorderType.Thick3D;
            case Thick3DReverseLighting:
                return BorderType.Thick3DReverseLighting;
            case Solid3D:
                return BorderType.Solid3D;
            case Solid3DReverseLighting:
                return BorderType.Solid3DReverseLighting;
        }
        return BorderType.None;
    }
}

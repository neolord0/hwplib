package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.objectlinkline;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.arc.ArcType;

public enum LinkLineType {
    Straight_NoArrow((byte) 0),
    Straight_OneWay((byte) 1),
    Straight_Both((byte) 2),
    Stroke_NoArrow((byte) 3),
    Stoke_OneWay((byte) 4),
    Stoke_Both((byte) 5),
    Arc_NoArrow((byte) 6),
    Arc_OneWay((byte) 7),
    Arc_Both((byte) 8);


    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    LinkLineType(byte value) {
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
    public static LinkLineType valueOf(byte value) {
        for (LinkLineType llk : values()) {
            if (llk.value == value) {
                return llk;
            }
        }
        return Straight_NoArrow;
    }
}

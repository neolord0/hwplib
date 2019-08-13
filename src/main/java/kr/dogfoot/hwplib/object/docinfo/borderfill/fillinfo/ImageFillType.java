package kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo;

/**
 * 이미지 채우기 유형
 *
 * @author neolord
 */
public enum ImageFillType {
    /**
     * 바둑판식으로-모두
     */
    TileAll((byte) 0),
    /**
     * 바둑판식으로-가로/위
     */
    TileHorizonalTop((byte) 1),
    /**
     * 바둑판식으로-가로/아래
     */
    TileHorizonalBottom((byte) 2),
    /**
     * 바둑판식으로-세로/왼쪽
     */
    TileVerticalLeft((byte) 3),
    /**
     * 바둑판식으로-세로/오른쪽
     */
    TileVerticalRight((byte) 4),
    /**
     * 크기에 맞추어
     */
    FitSize((byte) 5),
    /**
     * 가운데로
     */
    Center((byte) 6),
    /**
     * 가운데 위로
     */
    CenterTop((byte) 7),
    /**
     * 가운데 아래로
     */
    CenterBottom((byte) 8),
    /**
     * 왼쪽 가운데로
     */
    LeftCenter((byte) 9),
    /**
     * 왼쪽 위로
     */
    LeftTop((byte) 10),
    /**
     * 왼쪽 아래로
     */
    LeftBottom((byte) 11),
    /**
     * 오른쪽 가운데로
     */
    RightCenter((byte) 12),
    /**
     * 오른쪽 위로
     */
    RightTop((byte) 13),
    /**
     * 오른쪽 아래로
     */
    RightBottom((byte) 14),
    /**
     * NONE
     */
    None((byte) 15);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ImageFillType(byte value) {
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
    public static ImageFillType valueOf(byte value) {
        for (ImageFillType ift : values()) {
            if (ift.value == value) {
                return ift;
            }
        }
        return None;
    }
}

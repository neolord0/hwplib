package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.textart;

public enum TextArtShape {
    PARALLELOGRAM((byte) 0),
    INVERTED_PARALLELOGRAM((byte) 1),
    INVERTED_UPWARD_CASCADE((byte) 2),
    INVERTED_DOWNWARD_CASCADE((byte) 3),
    UPWARD_CASCADE((byte) 4),
    DOWNWARD_CASCADE((byte) 5),
    REDUCE_RIGHT((byte) 6),
    REDUCE_LEFT((byte) 7),
    ISOSCELES_TRAPEZOID((byte) 8),
    INVERTED_ISOSCELES_TRAPEZOID((byte) 9),
    TOP_RIBBON_RECTANGLE((byte) 10),
    BOTTOM_RIBBON_RECTANGLE((byte) 11),
    CHEVRON_DOWN((byte) 12),
    CHEVRON((byte) 13),
    BOW_TIE((byte) 14),
    HEXAGON((byte) 15),
    WAVE1((byte) 16),
    WAVE2((byte) 17),
    WAVE3((byte) 18),
    WAVE4((byte) 19),
    LEFT_TILT_CYLINDER((byte) 20),
    RIGHT_TILT_CYLINDER((byte) 21),
    BOTTOM_WIDE_CYLINDER((byte) 22),
    TOP_WIDE_CYLINDER((byte) 23),
    THIN_CURVE_UP1((byte) 24),
    THIN_CURVE_UP2((byte) 25),
    THIN_CURVE_DOWN1((byte) 26),
    THIN_CURVE_DOWN2((byte) 27),
    INVERSED_FINGERNAIL((byte) 28),
    FINGERNAIL((byte) 29),
    GINKO_LEAF1((byte) 30),
    GINKO_LEAF2((byte) 31),
    INFLATE_RIGHT((byte) 32),
    INFLATE_LEFT((byte) 33),
    INFLATE_UP_CONVEX((byte) 34),
    INFLATE_BOTTOM_CONVEX((byte) 35),
    DEFLATE_TOP((byte) 36),
    DEFLATE_BOTTOM((byte) 37),
    DEFLATE((byte) 38),
    INFLATE((byte) 39),
    INFLATE_TOP((byte) 40),
    INFLATE_BOTTOM((byte) 41),
    RECTANGLE((byte) 42),
    LEFT_CYLINDER((byte) 43),
    CYLINDER((byte) 44),
    RIGHT_CYLINDER((byte) 45),
    CIRCLE((byte) 46),
    CURVE_DOWN((byte) 47),
    ARCH_UP((byte) 48),
    ARCH_DOWN((byte) 49),
    SINGLE_LINE_CIRCLE1((byte) 50),
    SINGLE_LINE_CIRCLE2((byte) 51),
    TRIPLE_LINE_CIRCLE1((byte) 52),
    TRIPLE_LINE_CIRCLE2((byte) 53),
    DOUBLE_LINE_CIRCLE((byte) 54);

    /**
     * 파일에 저장되는 정수값
     */
    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    TextArtShape(byte value) {
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
    public static TextArtShape valueOf(byte value) {
        for (TextArtShape tas : values()) {
            if (tas.value == value) {
                return tas;
            }
        }
        return PARALLELOGRAM;
    }
}

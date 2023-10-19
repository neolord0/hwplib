package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture;


public enum ColorEffectSort {
    Alpha(0),
    Alpha_Mod(1),
    Alpha_Off(2),
    Red(3),
    Red_Mod(4),
    Ref_Off(5),
    Green(6),
    Green_Mod(7),
    Green_Off(8),
    Blue(9),
    Blue_Mod(10),
    Blue_Off(11),
    Hue(12),
    Hue_Mod(13),
    Hue_Off(14),
    Sat(15),
    Sat_Mod(16),
    Sat_Off(17),
    Lum(18),
    Lum_Mod(19),
    Lum_Off(20),
    Shade(21),
    Tint(22),
    Gray(23),
    Comp(24),
    Gamma(25),
    Inv_Gamma(26),
    Inv(27);


    /**
     * 파일에 저장되는 정수값
     */
    private int value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ColorEffectSort(int value) {
        this.value = value;
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public int getValue() {
        return value + 500;
    }

    /**
     * 파일에 저장되는 정수값에 해당되는 enum 값을 반환한다.
     *
     * @param value 파일에 저장되는 정수값
     * @return enum 값
     */
    public static ColorEffectSort valueOf(int value) {
        for (ColorEffectSort ces : values()) {
            if (ces.value == value || ces.value + 500 == value) {
                return ces;
            }
        }
        return Alpha;
    }
}

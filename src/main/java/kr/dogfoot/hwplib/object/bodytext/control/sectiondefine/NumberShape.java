package kr.dogfoot.hwplib.object.bodytext.control.sectiondefine;

/**
 * 번호 모양
 *
 * @author neolord
 */
public enum NumberShape {
    /**
     * 1, 2, 3
     */
    Number((short) 0),
    /**
     * 동그라미 쳐진 1, 2, 3
     */
    CircledNumber((short) 1),
    /**
     * I, II, III
     */
    UppercaseRomanNumber((short) 2),
    /**
     * i, ii, iii
     */
    LowercaseRomanNumber((short) 3),
    /**
     * A, B, C
     */
    UppercaseAlphabet((short) 4),
    /**
     * a, b, c
     */
    LowercaseAlphabet((short) 5),
    /**
     * 동그라미 쳐진 A, B, C
     */
    CircledUppercaseAlphabet((short) 6),
    /**
     * 동그라미 쳐진 a, b, c
     */
    CircledLowercaseAlphabet((short) 7),
    /**
     * 가, 나, 다
     */
    Hangul((short) 8),
    /**
     * 동그라미 쳐진 가,나,다
     */
    CircledHangul((short) 9),
    /**
     * ㄱ, ㄴ, ㄷ
     */
    HangulJamo((short) 10),
    /**
     * 동그라미 쳐진 ㄱ,ㄴ,ㄷ
     */
    CircledHangulJamo((short) 11),
    /**
     * 일, 이, 삼
     */
    HangulNumber((short) 12),
    /**
     * 一, 二, 三
     */
    HanjaNumber((short) 13),
    /**
     * 동그라미 쳐진 一,二,三
     */
    CircledHanjaNumber((short) 14),
    /**
     * 갑, 을, 병, 정, 무, 기, 경, 신, 임, 계
     */
    HangulSibgan((short) 15),
    /**
     * 甲, 乙, 丙, 丁, 戊, 己, 庚, 辛, 壬, 癸
     */
    HanjaSibgan((short) 16),
    /**
     * 4가지 문자가 차례로 반복(각주/미주 전용)
     */
    Symbol((short) 0x80),
    /**
     * 사용자 지정 문자 반복
     */
    UserChar((short) 0x81);

    /**
     * 파일에 저장되는 정수값
     */
    private short value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    NumberShape(short value) {
        this.value = value;
    }

    /**
     * 파일에 저장되는 정수값을 반환한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public short getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값에 해당되는 enum 값을 반환한다.
     *
     * @param value 파일에 저장되는 정수값
     * @return enum 값
     */
    public static NumberShape valueOf(short value) {
        for (NumberShape ns : values()) {
            if (ns.value == value) {
                return ns;
            }
        }
        return Number;
    }
}

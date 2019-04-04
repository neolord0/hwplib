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
    Type0((short) 0),
    /**
     * 동그라미 쳐진 1, 2, 3
     */
    Type1((short) 1),
    /**
     * I, II, III
     */
    Type2((short) 2),
    /**
     * i, ii, iii
     */
    Type3((short) 3),
    /**
     * A, B, C
     */
    Type4((short) 4),
    /**
     * a, b, c
     */
    Type5((short) 5),
    /**
     * 동그라미 쳐진 A, B, C
     */
    Type6((short) 6),
    /**
     * 동그라미 쳐진 a, b, c
     */
    Type7((short) 7),
    /**
     * 가, 나, 다
     */
    Type8((short) 8),
    /**
     * 동그라미 쳐진 가,나,다
     */
    Type9((short) 9),
    /**
     * ㄱ, ㄴ, ㄷ
     */
    Type10((short) 10),
    /**
     * 동그라미 쳐진 ㄱ,ㄴ,ㄷ
     */
    Type11((short) 11),
    /**
     * 일, 이, 삼
     */
    Type12((short) 12),
    /**
     * 一, 二, 三
     */
    Type13((short) 13),
    /**
     * 동그라미 쳐진 一,二,三
     */
    Type14((short) 14),
    /**
     * 갑, 을, 병, 정, 무, 기, 경, 신, 임, 계
     */
    Type15((short) 15),
    /**
     * 甲, 乙, 丙, 丁, 戊, 己, 庚, 辛, 壬, 癸
     */
    Type16((short) 16),
    /**
     * 4가지 문자가 차례로 반복(각주/미주 전용)
     */
    Type128((short) 0x80),
    /**
     * 사용자 지정 문자 반복
     */
    Type129((short) 0x81);

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
        return Type0;
    }
}

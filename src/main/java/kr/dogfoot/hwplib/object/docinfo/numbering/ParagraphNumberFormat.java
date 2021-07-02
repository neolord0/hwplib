package kr.dogfoot.hwplib.object.docinfo.numbering;

public enum ParagraphNumberFormat {
    /**
     * 1, 2, 3 (무한)
     */
    Number((byte) 0),
    /**
     * 동그라미 쳐진 1, 2, 3 (1~20 반복)
     */
    CircledNumber((byte) 1),
    /**
     * I, II, III (무한)
     */
    UppercaseRomanNumber((byte) 2),
    /**
     * i, ii, iii (무한)
     */
    LowercaseRomanNumber((byte) 3),
    /**
     * A, B, C (A~Z 반복)
     */
    UppercaseAlphabet((byte) 4),
    /**
     * a, b, c (a~z 반복)
     */
    LowercaseAlphabet((byte) 5),
    /**
     * 동그라미 쳐진 A, B, C (A-Z 반복)
     */
    CircledUppercaseAlphabet((byte) 6),
    /**
     * 동그라미 쳐진 a, b, c (a-z 반복)
     */
    CircledLowercaseAlphabet((byte) 7),
    /**
     * 가, 나, 다 (가~하,거~허,고~호,구~후,그~흐,기~히 반복)
     */
    Hangul((byte) 8),
    /**
     * 동그라미 쳐진 가, 나, 다 (가~하 반복)
     */
    CircledHangul((byte) 9),
    /**
     * ㄱ, ㄴ, ㄷ (ㄱ~ㅎ 반복)
     */
    HangulJamo((byte) 10),
    /**
     * 동그라미 쳐진 ㄱ, ㄴ, ㄷ (ㄱ~ㅎ 반복)
     */
    CircledHangulJamo((byte) 11),
    /**
     * 일, 이, 삼 (일~구십구 반복)
     */
    HangulNumber((byte) 12),
    /**
     * 一, 二, 三 (一~九十九 반복)
     */
    HanjaNumber((byte) 13),
    /**
     * 동그라미 쳐진 一, 二, 三(一~十 반복)
     */
    CircledHanjaNumber((byte) 14),
    /**
     * 갑,을,병,정,무,기,경,신,임,계
     */
    SibGanHangul((byte) 15),
    /**
     * 甲,乙,丙,丁,戊,己,庚,辛,壬,癸
     */
    SibGanHanja((byte) 16);

    private byte value;

    /**
     * 생성자
     *
     * @param value 파일에 저장되는 정수값
     */
    ParagraphNumberFormat(byte value) {
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
    public static ParagraphNumberFormat valueOf(byte value) {
        for (ParagraphNumberFormat pnf : values()) {
            if (pnf.value == value) {
                return pnf;
            }
        }
        return Number;
    }
}

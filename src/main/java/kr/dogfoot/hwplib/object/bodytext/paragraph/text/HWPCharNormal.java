package kr.dogfoot.hwplib.object.bodytext.paragraph.text;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * 일반 Character
 *
 * @author neolord
 */
public class HWPCharNormal extends HWPChar {
    /**
     * 생성자
     */
    public HWPCharNormal() {
    }

    public HWPCharNormal(int code) {
        this.code = code;
    }

    /**
     * 글자의 종류을 반환한다.
     *
     * @return 글자의 타입
     */
    @Override
    public HWPCharType getType() {
        return HWPCharType.Normal;
    }

    /**
     * 글자를 반환한다.
     *
     * @return 글자
     * @throws UnsupportedEncodingException
     */
    public String getCh() throws UnsupportedEncodingException {
        return intToString(code);
    }

    /**
     * 2 byte 문자코드를 문자열로 변환한다.
     *
     * @param code 2 byte 문자코드
     * @return 변환된 문자열
     */
    private String intToString(int code) {
        byte[] ch = new byte[2];
        ch[0] = (byte) (code & 0xff);
        ch[1] = (byte) ((code >> 8) & 0xff);
        return new String(ch, 0, 2, StandardCharsets.UTF_16LE);
    }

    public HWPChar clone() {
        HWPCharNormal cloned = new HWPCharNormal();
        cloned.code = code;
        return cloned;
    }

    @Override
    public int getCharSize() {
        return 1;
    }
}

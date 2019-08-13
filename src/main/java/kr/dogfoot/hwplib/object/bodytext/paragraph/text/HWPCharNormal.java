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
     * 글자 코드
     */
    private short code;

    /**
     * 생성자
     */
    public HWPCharNormal() {
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
     * 글자 코드를 반환한다.
     *
     * @return 글자 코드
     */
    public short getCode() {
        return code;
    }

    /**
     * 글자 코드를 설정한다.
     *
     * @param code 글자 코드
     */
    public void setCode(short code) {
        this.code = code;
    }

    /**
     * 글자를 반환한다.
     *
     * @return 글자
     * @throws UnsupportedEncodingException
     */
    public String getCh() throws UnsupportedEncodingException {
        return shortToString(code);
    }

    /**
     * 2 byte 문자코드를 문자열로 변환한다.
     *
     * @param code 2 byte 문자코드
     * @return 변환된 문자열
     * @throws UnsupportedEncodingException
     */
    private String shortToString(short code)
            throws UnsupportedEncodingException {
        byte[] ch = new byte[2];
        ch[0] = (byte) (code & 0xff);
        ch[1] = (byte) ((code >> 8) & 0xff);
        return new String(ch, 0, 2, StandardCharsets.UTF_16LE);
    }
}

package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.*;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 문단의 텍스트 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForParaText {
    /**
     * 문단의 텍스트 레코드를 쓴다.
     *
     * @param p  문단
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(Paragraph p, StreamWriter sw) throws IOException {
        if (p.getText() == null) {
            return;
        }

        long size = p.getHeader().getCharacterCount() * 2;
        recordHeader(size, sw);

        realRecordSize(size, sw);

        for (HWPChar hc : p.getText().getCharList()) {
            hwpChar(hc, sw);
        }
    }

    /**
     * 문단의 텍스트 레코드의 레코드 헤더를 쓴다.
     *
     * @param size 실제 계산된 레코드 크기
     * @param sw   스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(long size, StreamWriter sw)
            throws IOException {
        if (size > 4095) {
            sw.writeRecordHeader(HWPTag.PARA_TEXT, 4095);
        } else {
            sw.writeRecordHeader(HWPTag.PARA_TEXT, (int) size);
        }
    }

    /**
     * 레코드의 크기가 4095보다 클 경우 실제 크기를 쓴다.
     *
     * @param size 실제 계산된 레코드 크기
     * @param sw   스트림 라이터
     * @throws IOException
     */
    private static void realRecordSize(long size, StreamWriter sw)
            throws IOException {
        if (size > 4095) {
            sw.writeUInt4(size);
        }
    }

    /**
     * Character을 쓴다.
     *
     * @param hc 글자 객체
     * @param sw 스트림 라이터
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    private static void hwpChar(HWPChar hc, StreamWriter sw)
            throws UnsupportedEncodingException, IOException {
        switch (hc.getType()) {
            case Normal:
                normal((HWPCharNormal) hc, sw);
                break;
            case ControlChar:
                controlChar((HWPCharControlChar) hc, sw);
                break;
            case ControlInline:
                controlInline((HWPCharControlInline) hc, sw);
                break;
            case ControlExtend:
                controlExtend((HWPCharControlExtend) hc, sw);
                break;
        }
    }

    /**
     * 일반 Character를 쓴다.
     *
     * @param hc 일반 Character
     * @param sw 스트림 라이터
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    private static void normal(HWPCharNormal hc, StreamWriter sw)
            throws UnsupportedEncodingException, IOException {
        sw.writeSInt2(hc.getCode());
    }

    /**
     * 문자 컨트롤 Character를 쓴다.
     *
     * @param hc 문자 컨트롤 Character
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void controlChar(HWPCharControlChar hc, StreamWriter sw)
            throws IOException {
        sw.writeSInt2(hc.getCode());
    }

    /**
     * 인라인 컨트롤 character을 쓴다.
     *
     * @param hc 인라인 컨트롤 character
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void controlInline(HWPCharControlInline hc, StreamWriter sw)
            throws IOException {
        sw.writeSInt2(hc.getCode());
        sw.writeBytes(hc.getAddition());
        sw.writeSInt2(hc.getCode());
    }

    /**
     * 확장 컨트롤 Character를 쓴다.
     *
     * @param hc 확장 컨트롤 Character
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void controlExtend(HWPCharControlExtend hc, StreamWriter sw)
            throws IOException {
        sw.writeSInt2(hc.getCode());
        sw.writeBytes(hc.getAddition());
        sw.writeSInt2(hc.getCode());
    }
}

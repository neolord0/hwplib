package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlAdditionalText;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderAdditionalText;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 덧말 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlAdditionalText {
    /**
     * 덧말 컨트롱을 쓴다.
     *
     * @param at 덧말 컨트롤
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ControlAdditionalText at, StreamWriter sw)
            throws IOException {
        ctrlHeader(at.getHeader(), sw);
    }

    /**
     * 덧말 컨트롤의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h  컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderAdditionalText h, StreamWriter sw)
            throws IOException {
        recordHeader(h, sw);
        sw.writeUInt4(h.getCtrlId());

        sw.writeUTF16LEString(h.getMainText());
        sw.writeUTF16LEString(h.getSubText());
        sw.writeUInt4(h.getPosition().getValue());
        sw.writeUInt4(h.getFsizeratio());
        sw.writeUInt4(h.getOption());
        sw.writeUInt4(h.getStyleId());
        sw.writeUInt4(h.getAlignment().getValue());
    }

    /**
     * 컨트롤 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param h  컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(CtrlHeaderAdditionalText h, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.CTRL_HEADER, getSize(h));
    }

    /**
     * 컨트롤 헤더 레코드의 크기를 반환한다.
     *
     * @param h 컨트롤 헤더 레코드
     * @return 컨트롤 헤더 레코드의 크기
     */
    private static int getSize(CtrlHeaderAdditionalText h) {
        int size = 0;
        size += 4;
        size += StringUtil.getUTF16LEStringSize(h.getMainText());
        size += StringUtil.getUTF16LEStringSize(h.getSubText());
        size += 20;
        return size;
    }
}

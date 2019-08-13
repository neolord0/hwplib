package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderField;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.bookmark.ForCtrlData;

import java.io.IOException;

/**
 * 필드 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlField {
    /**
     * 필드 컨트롤을 쓴다.
     *
     * @param f  필드 컨트롤
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ControlField f, StreamWriter sw)
            throws IOException {
        ctrlHeader(f.getHeader(), sw);
        sw.upRecordLevel();

        ForCtrlData.write(f.getCtrlData(), sw);

        sw.downRecordLevel();
    }

    /**
     * 필드 컨트롤의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h  필드 컨트롤의 컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderField h, StreamWriter sw)
            throws IOException {
        recordHeader(h, sw);
        sw.writeUInt4(h.getCtrlId());

        sw.writeUInt4(h.getProperty().getValue());
        sw.writeUInt1(h.getEtcProperty());
        sw.writeUTF16LEString(h.getCommand());
        sw.writeUInt4(h.getInstanceId());

        if (h.getCtrlId() == ControlType.FIELD_UNKNOWN.getCtrlId()) {
            sw.writeSInt4(h.getMemoIndex());
        } else {
            sw.writeZero(4);
        }
    }

    /**
     * 컨트롤 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param h  컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(CtrlHeaderField h, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.CTRL_HEADER, getSize(h));
    }

    /**
     * 컨트롤 헤더 레코드의 크기를 반환한다.
     *
     * @param h 컨트롤 헤더 레코드
     * @return 컨트롤 헤더 레코드의 크기
     */
    private static int getSize(CtrlHeaderField h) {
        int size = 0;
        size += 9;
        size += StringUtil.getUTF16LEStringSize(h.getCommand());
        size += 8;
        return size;
    }
}

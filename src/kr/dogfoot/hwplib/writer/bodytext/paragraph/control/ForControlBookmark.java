package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlBookmark;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderBookmark;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.bookmark.ForCtrlData;

import java.io.IOException;

/**
 * 첵갈피 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlBookmark {
    /**
     * 책갈피 컨트롤을 쓴다.
     *
     * @param b  책갈피 컨트롤
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ControlBookmark b, StreamWriter sw)
            throws IOException {
        ctrlHeader(b.getHeader(), sw);

        sw.upRecordLevel();

        ForCtrlData.write(b.getCtrlData(), sw);

        sw.downRecordLevel();
    }

    /**
     * 책갈피 컨트롤의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h  책갈피 컨트롤의 컨트롤 헤더 레코
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderBookmark h, StreamWriter sw)
            throws IOException {
        recordHeader(sw);
        sw.writeUInt4(h.getCtrlId());
    }

    /**
     * 컨트롤 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.CTRL_HEADER, 4);
    }
}

package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.binary.BitFlag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 그리기 개체의 컨트롤 헤더 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForCtrlHeaderGso {
    /**
     * 그리기 개체의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h  그리기 개체의 컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(CtrlHeaderGso h, StreamWriter sw)
            throws IOException {
        recordHeader(h, sw);
        sw.writeUInt4(h.getCtrlId());

        sw.writeUInt4(h.getProperty().getValue());
        sw.writeUInt4(h.getyOffset());
        sw.writeUInt4(h.getxOffset());
        sw.writeUInt4(h.getWidth());
        sw.writeUInt4(h.getHeight());
        sw.writeSInt4(h.getzOrder());
        sw.writeUInt2(h.getOutterMarginLeft());
        sw.writeUInt2(h.getOutterMarginRight());
        sw.writeUInt2(h.getOutterMarginTop());
        sw.writeUInt2(h.getOutterMarginBottom());
        sw.writeUInt4(h.getInstanceId());
        int temp = 0;
        temp = BitFlag.set(temp, 0, h.isPreventPageDivide());
        sw.writeSInt4(temp);
        sw.writeUTF16LEString(h.getExplanation());
    }

    /**
     * 그리기 개체의 컨트롤 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param h  그리기 개체의 컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(CtrlHeaderGso h, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.CTRL_HEADER, getSize(h));
    }

    /**
     * 그리기 개체의 컨트롤 헤더 레코드의 크기를 반환한다.
     *
     * @param h 그리기 개체의 컨트롤 헤더 레코드
     * @return 그리기 개체의 컨트롤 헤더 레코드의 크기
     */
    private static int getSize(CtrlHeaderGso h) {
        int size = 0;
        size += 44;
        size += StringUtil.getUTF16LEStringSize(h.getExplanation());
        return size;
    }
}

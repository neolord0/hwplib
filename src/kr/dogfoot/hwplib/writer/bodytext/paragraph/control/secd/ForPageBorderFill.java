package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.secd;

import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.PageBorderFill;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 쪽 테두리/배경 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForPageBorderFill {
    /**
     * 쪽 테두리/배경 레코드를 쓴다.
     *
     * @param pbf 쪽 테두리/배경 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    public static void write(PageBorderFill pbf, StreamWriter sw)
            throws IOException {
        if (pbf == null) {
            return;
        }

        recordHeader(sw);

        sw.writeUInt4(pbf.getProperty().getValue());
        sw.writeUInt2(pbf.getLeftGap());
        sw.writeUInt2(pbf.getRightGap());
        sw.writeUInt2(pbf.getTopGap());
        sw.writeUInt2(pbf.getBottomGap());
        sw.writeUInt2(pbf.getBorderFillId());
    }

    /**
     * 쪽 테두리/배경 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.PAGE_BORDER_FILL, 14);
    }
}

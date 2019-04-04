package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.secd;

import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.PageDef;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 용지 설정 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForPageDef {
    /**
     * 용지 설정 레코드를 쓴다.
     *
     * @param pd 용지 설정 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(PageDef pd, StreamWriter sw) throws IOException {
        if (pd == null) {
            return;
        }

        recordHeader(sw);

        sw.writeUInt4(pd.getPaperWidth());
        sw.writeUInt4(pd.getPaperHeight());
        sw.writeUInt4(pd.getLeftMargin());
        sw.writeUInt4(pd.getRightMargin());
        sw.writeUInt4(pd.getTopMargin());
        sw.writeUInt4(pd.getBottomMargin());
        sw.writeUInt4(pd.getHeaderMargin());
        sw.writeUInt4(pd.getFooterMargin());
        sw.writeUInt4(pd.getGutterMargin());
        sw.writeUInt4(pd.getProperty().getValue());
    }

    /**
     * 용지 설정 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.PAGE_DEF, 40);
    }
}

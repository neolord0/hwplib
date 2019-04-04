package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.secd;

import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.BatangPageInfo;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.ListHeaderForBatangPage;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.ForParagraphList;

import java.io.IOException;

/**
 * 바탕쪽 정보를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForBatangPageInfo {
    /**
     * 바탕쪽 정보를 쓴다.
     *
     * @param bpi 바탕쪽 정보
     * @param sw  스트림 라이터
     * @throws Exception
     */
    public static void write(BatangPageInfo bpi, StreamWriter sw)
            throws Exception {
        listHeader(bpi.getListHeader(), sw);
        ForParagraphList.write(bpi.getParagraphList(), sw);
    }

    /**
     * 바탕쪽 정보의 리스트 헤더 레코드를 쓴다.
     *
     * @param lh 바탕쪽 정보의 리스트 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void listHeader(ListHeaderForBatangPage lh, StreamWriter sw)
            throws IOException {
        recordHeader(sw);

        sw.writeSInt4(lh.getParaCount());
        sw.writeUInt4(lh.getProperty().getValue());
        sw.writeUInt4(lh.getTextWidth());
        sw.writeUInt4(lh.getTextHeight());
        sw.writeZero(18);
    }

    /**
     * 바탕쪽 정보의 리스트 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.LIST_HEADER, 34);
    }
}

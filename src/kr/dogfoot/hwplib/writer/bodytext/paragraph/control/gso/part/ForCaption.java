package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part;

import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.Caption;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.ListHeaderForCaption;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.ForParagraphList;

import java.io.IOException;

/**
 * 캡션 정보을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForCaption {
    /**
     * 캡션 정보를 쓴다.
     *
     * @param c  캡션 정보 객체
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(Caption c, StreamWriter sw) throws Exception {
        if (c == null) {
            return;
        }

        listHeader(c.getListHeader(), sw);
        ForParagraphList.write(c.getParagraphList(), sw);
    }

    /**
     * 캡션 정보의 리스트 헤더 레코드를 쓴다.
     *
     * @param lh 캡션 정보의 리스트 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void listHeader(ListHeaderForCaption lh, StreamWriter sw)
            throws IOException {
        recordHeader(sw);

        sw.writeSInt4(lh.getParaCount());
        sw.writeUInt4(lh.getProperty().getValue());
        sw.writeUInt4(lh.getCaptionProperty().getValue());
        sw.writeUInt4(lh.getCaptionWidth());
        sw.writeUInt2(lh.getSpaceBetweenCaptionAndFrame());
        sw.writeUInt4(lh.getTextWidth());
        sw.writeZero(8);
    }

    /**
     * 리스트 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.LIST_HEADER, 30);
    }
}

package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 문단의 레이아웃 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForParaLineSeq {
    /**
     * 문단의 레이아웃 레코드를 쓴다.
     *
     * @param pls 문단의 레이아웃 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    public static void write(ParaLineSeg pls, StreamWriter sw)
            throws IOException {
        if (pls == null) {
            return;
        }


        recordHeader(pls, sw);
        long size = getSize(pls);
        if (size > 4095) {
            sw.writeUInt4(size);
        }

        for (LineSegItem lsi : pls.getLineSegItemList()) {
            lineSegItem(lsi, sw);
        }
    }

    /**
     * 문단의 레이아웃 레코드의 레코드 헤더를 쓴다.
     *
     * @param pls 문단의 레이아웃 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(ParaLineSeg pls, StreamWriter sw)
            throws IOException {
        long size = getSize(pls);
        size = (size > 4095) ? 4095 : size;
        sw.writeRecordHeader(HWPTag.PARA_LINE_SEG, (int) size);
    }

    /**
     * 문단의 레이아웃 레코드의 크기를 반환한다.
     *
     * @param pls 문단의 레이아웃 레코드
     * @return 문단의 레이아웃 레코드의 크기
     */
    private static int getSize(ParaLineSeg pls) {
        return pls.getLineSegItemList().size() * 36;
    }

    /**
     * 한 라인의 레이아웃 정보를 쓴다.
     *
     * @param lsi 한 라인의 레이아웃 정보
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void lineSegItem(LineSegItem lsi, StreamWriter sw)
            throws IOException {
        sw.writeUInt4(lsi.getTextStartPositon());
        sw.writeSInt4(lsi.getLineVerticalPosition());
        sw.writeSInt4(lsi.getLineHeight());
        sw.writeSInt4(lsi.getTextPartHeight());
        sw.writeSInt4(lsi.getDistanceBaseLineToLineVerticalPosition());
        sw.writeSInt4(lsi.getLineSpace());
        sw.writeSInt4(lsi.getStartPositionFromColumn());
        sw.writeSInt4(lsi.getSegmentWidth());
        sw.writeUInt4(lsi.getTag().getValue());
    }
}

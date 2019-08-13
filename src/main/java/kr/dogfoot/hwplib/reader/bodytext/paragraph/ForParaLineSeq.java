package kr.dogfoot.hwplib.reader.bodytext.paragraph;

import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.LineSegItem;
import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 문단의 레이아웃 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForParaLineSeq {
    /**
     * 문단의 레이아웃 레코드를 읽는다.
     *
     * @param p  문단 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(Paragraph p, StreamReader sr) throws IOException {
        p.createLineSeg();

        long recordSize = sr.getCurrentRecordHeader().getSize();
        if (recordSize == 4095) {
            recordSize = sr.readUInt4();
        }

        ParaLineSeg pls = p.getLineSeg();
        int count = p.getHeader().getLineAlignCount();
        for (int index = 0; index < count; index++) {
            paraLineSeqItem(pls.addNewLineSegItem(), sr);
        }
    }

    /**
     * 한 라인의 레이아웃 정보를 읽는다.
     *
     * @param plsi 한 라인의 레이아웃 정보
     * @param sr   스트림 리더
     * @throws IOException
     */
    private static void paraLineSeqItem(LineSegItem plsi, StreamReader sr)
            throws IOException {
        plsi.setTextStartPositon(sr.readUInt4());
        plsi.setLineVerticalPosition(sr.readSInt4());
        plsi.setLineHeight(sr.readSInt4());
        plsi.setTextPartHeight(sr.readSInt4());
        plsi.setDistanceBaseLineToLineVerticalPosition(sr.readSInt4());
        plsi.setLineSpace(sr.readSInt4());
        plsi.setStartPositionFromColumn(sr.readSInt4());
        plsi.setSegmentWidth(sr.readSInt4());
        plsi.getTag().setValue(sr.readUInt4());
    }
}

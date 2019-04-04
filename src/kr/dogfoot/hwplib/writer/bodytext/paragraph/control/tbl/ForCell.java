package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.tbl;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterSet;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.ListHeaderForCell;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.ForParagraphList;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.bookmark.ForParameterSet;

import java.io.IOException;

/**
 * 표 컨트롤의 셀을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForCell {
    /**
     * 표 컨트롤의 셀을 쓴다.
     *
     * @param c  셀 객체
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(Cell c, StreamWriter sw) throws Exception {
        listHeader(c.getListHeader(), sw);
        ForParagraphList.write(c.getParagraphList(), sw);
    }

    /**
     * 셀의 리스트 헤더 레코드를 쓴다.
     *
     * @param lh 셀의 리스트 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void listHeader(ListHeaderForCell lh, StreamWriter sw)
            throws IOException {
        ParameterSet psFieldName = ParameterSet.createForFieldName(lh
                .getFieldName());
        recordHeader(psFieldName, sw);

        sw.writeSInt4(lh.getParaCount());
        sw.writeUInt4(lh.getProperty().getValue());
        sw.writeUInt2(lh.getColIndex());
        sw.writeUInt2(lh.getRowIndex());
        sw.writeUInt2(lh.getColSpan());
        sw.writeUInt2(lh.getRowSpan());
        sw.writeUInt4(lh.getWidth());
        sw.writeUInt4(lh.getHeight());
        sw.writeUInt2(lh.getLeftMargin());
        sw.writeUInt2(lh.getRightMargin());
        sw.writeUInt2(lh.getTopMargin());
        sw.writeUInt2(lh.getBottomMargin());
        sw.writeUInt2(lh.getBorderFillId());
        sw.writeUInt4(lh.getTextWidth());
        if (psFieldName != null) {
            short flag = 0xff;
            sw.writeUInt1(flag);

            ForParameterSet.write(psFieldName, sw);
        } else {
            short flag = 0x0;
            sw.writeUInt1(flag);
        }
        sw.writeZero(8);
    }

    /**
     * 셀의 리스트 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param psFieldName 필드 이름을 위한 파라미터 셋
     * @param sw          스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(ParameterSet psFieldName, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.LIST_HEADER, getSize(psFieldName));
    }

    /**
     * 셀의 리스트 헤더 레코드의 크기를 반환한다.
     *
     * @param psFieldName 필드 이름을 위한 파라미터 셋
     * @return 셀의 리스트 헤더 레코드의 크기
     */
    private static int getSize(ParameterSet psFieldName) {
        int size = 0;
        size += 38;

        if (psFieldName != null) {
            size += 1;
            size += ForParameterSet.getSize(psFieldName);
        } else {
            size += 1;
        }
        size += 8;
        return size;
    }
}

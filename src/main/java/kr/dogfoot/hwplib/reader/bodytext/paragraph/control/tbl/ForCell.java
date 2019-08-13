package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.tbl;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterItem;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterSet;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterType;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.ListHeaderForCell;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.bodytext.ForParagraphList;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.bookmark.ForParameterSet;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 표의 셀을 읽기 위한 객체
 *
 * @author 박성균
 */
public class ForCell {
    /**
     * 표의 셀을 읽는다.
     *
     * @param cell 표의 셀
     * @param sr   스트림 리더
     * @throws Exception
     */
    public static void read(Cell cell, StreamReader sr) throws Exception {
        if (sr.isImmediatelyAfterReadingHeader() == false) {
            sr.readRecordHeder();
        }
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.LIST_HEADER) {
            listHeader(cell.getListHeader(), sr);
        } else {
            throw new Exception("cell's list header does not exist.");
        }
        ForParagraphList.read(cell.getParagraphList(), sr);
    }

    /**
     * 셀의 문단 리스트 헤더 레코드를 읽는다.
     *
     * @param lh 셀의 문단 리스트 헤더 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void listHeader(ListHeaderForCell lh, StreamReader sr)
            throws IOException {
        lh.setParaCount(sr.readSInt4());
        lh.getProperty().setValue(sr.readUInt4());
        lh.setColIndex(sr.readUInt2());
        lh.setRowIndex(sr.readUInt2());
        lh.setColSpan(sr.readUInt2());
        lh.setRowSpan(sr.readUInt2());
        lh.setWidth(sr.readUInt4());
        lh.setHeight(sr.readUInt4());
        lh.setLeftMargin(sr.readUInt2());
        lh.setRightMargin(sr.readUInt2());
        lh.setTopMargin(sr.readUInt2());
        lh.setBottomMargin(sr.readUInt2());
        lh.setBorderFillId(sr.readUInt2());
        lh.setTextWidth(sr.readUInt4());
        if (sr.getCurrentRecordHeader().getSize() > sr
                .getCurrentPositionAfterHeader()) {
            short flag = sr.readUInt1();
            if (flag == 0xff) {
                fieldName(lh, sr);
            }
            unknownRestBytes(sr);
        }
    }

    /**
     * 필드 이름을 읽는다.
     *
     * @param lh 셀의 문단 리스트 헤더 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void fieldName(ListHeaderForCell lh, StreamReader sr) throws IOException {
        ParameterSet ps = new ParameterSet();
        ForParameterSet.read(ps, sr);

        if (ps.getId() == 0x21b) {
            for (ParameterItem pi : ps.getParameterItemList()) {
                if (pi.getId() == 0x4000 && pi.getType() == ParameterType.String) {
                    lh.setFieldName(pi.getValue_BSTR());
                }
            }
        }
    }

    /**
     * 알려지지 않은 나머지 바이트를 처리한다.
     *
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void unknownRestBytes(StreamReader sr) throws IOException {
        sr.skipToEndRecord();
    }
}

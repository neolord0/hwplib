package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.tbl;

import kr.dogfoot.hwplib.object.bodytext.control.table.Table;
import kr.dogfoot.hwplib.object.bodytext.control.table.ZoneInfo;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 표 정보 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForTable {
    /**
     * 표 정보 레코드를 읽는다.
     *
     * @param table 표 정보 레코드
     * @param sr    스트림 리더
     * @throws IOException
     */
    public static void read(Table table, StreamReader sr) throws IOException {
        table.getProperty().setValue(sr.readUInt4());
        table.setRowCount(sr.readUInt2());
        table.setColumnCount(sr.readUInt2());
        table.setCellSpacing(sr.readUInt2());
        table.setLeftInnerMargin(sr.readUInt2());
        table.setRightInnerMargin(sr.readUInt2());
        table.setTopInnerMargin(sr.readUInt2());
        table.setBottomInnerMargin(sr.readUInt2());
        for (int index = 0; index < table.getRowCount(); index++) {
            table.addCellCountOfRow(sr.readUInt2());
        }
        table.setBorderFillId(sr.readUInt2());

        if (sr.getFileVersion().isOver(5, 0, 1, 0)) {
            zoneInfo(table, sr);
        }
    }

    /**
     * zone info을 읽는다.
     *
     * @param table 표 정보 레코드
     * @param sr    스트림 리더
     * @throws IOException
     */
    private static void zoneInfo(Table table, StreamReader sr)
            throws IOException {
        int count = sr.readUInt2();
        for (int index = 0; index < count; index++) {
            ZoneInfo zi = table.addNewZoneInfo();
            zi.setStartColumn(sr.readUInt2());
            zi.setStartRow(sr.readUInt2());
            zi.setEndColumn(sr.readUInt2());
            zi.setEndRow(sr.readUInt2());
            zi.setBorderFillId(sr.readUInt2());
        }
    }
}

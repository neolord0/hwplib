package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.tbl;

import kr.dogfoot.hwplib.object.bodytext.control.table.Table;
import kr.dogfoot.hwplib.object.bodytext.control.table.ZoneInfo;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 표 정보 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForTable {
    /**
     * 표 정보 레코드를 쓴다.
     *
     * @param t  표 정보 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(Table t, StreamWriter sw) throws IOException {
        recordHeader(t, sw);

        sw.writeUInt4(t.getProperty().getValue());
        sw.writeUInt2(t.getRowCount());
        sw.writeUInt2(t.getColumnCount());
        sw.writeUInt2(t.getCellSpacing());
        sw.writeUInt2(t.getLeftInnerMargin());
        sw.writeUInt2(t.getRightInnerMargin());
        sw.writeUInt2(t.getTopInnerMargin());
        sw.writeUInt2(t.getBottomInnerMargin());

        for (int index = 0; index < t.getRowCount(); index++) {
            sw.writeUInt2(t.getCellCountOfRowList().get(index));
        }
        sw.writeUInt2(t.getBorderFillId());

        if (sw.getFileVersion().isOver(5, 0, 1, 0)) {
            zoneInfo(t, sw);
        }
    }

    /**
     * 표 정보 레코드의 레코드 헤더를 쓴다.
     *
     * @param t  표 정보 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(Table t, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.TABLE, getSize(t, sw.getFileVersion()));
    }

    /**
     * 표 정보 레코드의 크기를 반환한다.
     *
     * @param t       표 정보 레코드
     * @param version 파일 버전
     * @return 표 정보 레코드의 크기
     */
    private static int getSize(Table t, FileVersion version) {
        int size = 0;

        size += 18;
        size += 2 * t.getRowCount();
        size += 2;
        if (version.isOver(5, 0, 1, 0)) {
            size += 2;
            size += 10 * t.getZoneInfoList().size();
        }

        return size;
    }

    /**
     * zone info을 쓴다.
     *
     * @param t  표 정보 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void zoneInfo(Table t, StreamWriter sw) throws IOException {
        ArrayList<ZoneInfo> ziList = t.getZoneInfoList();
        int count = ziList.size();
        sw.writeUInt2(count);

        for (int index = 0; index < count; index++) {
            ZoneInfo zi = ziList.get(index);

            sw.writeUInt2(zi.getStartColumn());
            sw.writeUInt2(zi.getStartRow());
            sw.writeUInt2(zi.getEndColumn());
            sw.writeUInt2(zi.getEndRow());
            sw.writeUInt2(zi.getBorderFillId());
        }
    }
}

package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlColumnDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderColumnDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.columndefine.ColumnInfo;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 단 정의 컨트롤를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlColumnDefine {
    /**
     * 단 정의 컨트롤를 쓴다.
     *
     * @param cd 단 정의 컨트롤
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ControlColumnDefine cd, StreamWriter sw)
            throws IOException {
        ctrlHeader(cd.getHeader(), sw);
    }

    /**
     * 단 정의 컨트롤의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h  단 정의 컨트롤의 컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderColumnDefine h, StreamWriter sw)
            throws IOException {
        recordHeader(h, sw);
        sw.writeUInt4(h.getCtrlId());

        sw.writeUInt2(h.getProperty().getValue());
        int columnCount = h.getProperty().getColumnCount();
        boolean sameWidth = h.getProperty().isSameWidth();
        if (columnCount < 2 || sameWidth == true) {
            sw.writeUInt2(h.getGapBetweenColumn());
            sw.writeUInt2(h.getProperty2());
        } else {
            columnInfos(h, sw);
        }

        sw.writeUInt1(h.getDivideLineSort().getValue());
        sw.writeUInt1(h.getDivideLineThickness().getValue());
        sw.writeUInt4(h.getDivideLineColor().getValue());
    }

    /**
     * 컨트롤 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param h  컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(CtrlHeaderColumnDefine h, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.CTRL_HEADER, getSize(h));
    }

    /**
     * 컨트롤 헤더 레코드의 크기를 반환한다.
     *
     * @param h 컨트롤 헤더 레코드
     * @return 컨트롤 헤더 레코드의 크기
     */
    private static int getSize(CtrlHeaderColumnDefine h) {
        int size = 0;
        size += 6;

        int columnCount = h.getProperty().getColumnCount();
        boolean sameWidth = h.getProperty().isSameWidth();
        if (columnCount < 2 || sameWidth == true) {
            size += 4;
        } else {
            size += columnCount * 4;
        }
        size += 6;
        return size;
    }

    /**
     * 컨트롤 헤더 레코드의 단 정보 부분를 쓴다.
     *
     * @param h  컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void columnInfos(CtrlHeaderColumnDefine h, StreamWriter sw)
            throws IOException {
        int count = h.getProperty().getColumnCount();
        for (int index = 0; index < count; index++) {
            ColumnInfo ci = h.addNewColumnInfo();
            sw.writeUInt2(ci.getWidth());
            sw.writeUInt2(ci.getGap());
        }
    }
}

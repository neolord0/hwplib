package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.ParaShape;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 문단 모양 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForParaShape {
    /**
     * 문단 모양 레코드를 쓴다.
     *
     * @param ps 문단 모양 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ParaShape ps, StreamWriter sw) throws IOException {
        recordHeader(ps, sw);

        sw.writeUInt4(ps.getProperty1().getValue());
        sw.writeSInt4(ps.getLeftMargin());
        sw.writeSInt4(ps.getRightMargin());
        sw.writeSInt4(ps.getIndent());
        sw.writeSInt4(ps.getTopParaSpace());
        sw.writeSInt4(ps.getBottomParaSpace());
        sw.writeSInt4(ps.getLineSpace());
        sw.writeUInt2(ps.getTabDefId());
        sw.writeUInt2(ps.getParaHeadId());
        sw.writeUInt2(ps.getBorderFillId());
        sw.writeSInt2(ps.getLeftBorderSpace());
        sw.writeSInt2(ps.getRightBorderSpace());
        sw.writeSInt2(ps.getTopBorderSpace());
        sw.writeSInt2(ps.getBottomBorderSpace());
        if (sw.getFileVersion().isOver(5, 0, 1, 7)) {
            sw.writeUInt4(ps.getProperty2().getValue());
        }
        if (sw.getFileVersion().isOver(5, 0, 2, 5)) {
            sw.writeUInt4(ps.getProperty3().getValue());
            sw.writeUInt4(ps.getLineSpace2());
        }
        if (sw.getFileVersion().isOver(5, 0, 255, 255)) {
            sw.writeUInt4(ps.getUnknown());
        }
    }

    /**
     * 문단 모양 레코드의 레코드 헤더를 쓴다.
     *
     * @param ps 문단 모양 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(ParaShape ps, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.PARA_SHAPE, getSize(sw.getFileVersion()));
    }

    /**
     * 문단 모양 레코드의 크기를 반환한다.
     *
     * @param version 파일 버전
     * @return 문단 모양 레코드의 크기
     */
    private static int getSize(FileVersion version) {
        int size = 0;
        size += 42;
        if (version.isOver(5, 0, 1, 7)) {
            size += 4;
        }
        if (version.isOver(5, 0, 2, 5)) {
            size += 8;
        }
        if (version.isOver(5, 0, 255, 255)) {
            size += 4;
        }

        return size;
    }
}

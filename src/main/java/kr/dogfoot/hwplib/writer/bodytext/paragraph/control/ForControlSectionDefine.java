package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.BatangPageInfo;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.bookmark.ForCtrlData;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.secd.ForBatangPageInfo;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.secd.ForFootEndNoteShape;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.secd.ForPageBorderFill;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.secd.ForPageDef;

import java.io.IOException;

/**
 * 구역 정의 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlSectionDefine {
    /**
     * 구역 정의 컨트롤을 쓴다.
     *
     * @param sd 구역 정의 컨트롤
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(ControlSectionDefine sd, StreamWriter sw)
            throws Exception {
        ctrlHeader(sd.getHeader(), sw);

        sw.upRecordLevel();

        ForPageDef.write(sd.getPageDef(), sw);
        ForFootEndNoteShape.write(sd.getFootNoteShape(), sw);
        ForFootEndNoteShape.write(sd.getEndNoteShape(), sw);
        ForPageBorderFill.write(sd.getBothPageBorderFill(), sw);
        ForPageBorderFill.write(sd.getEvenPageBorderFill(), sw);
        ForPageBorderFill.write(sd.getOddPageBorderFill(), sw);
        batangPageInfoList(sd, sw);
        // ctrlData(sd, sw);

        sw.downRecordLevel();
    }

    /**
     * 구역 정의 컨트롤의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h  구역 정의 컨트롤의 컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderSectionDefine h, StreamWriter sw)
            throws IOException {
        recordHeader(h, sw);
        sw.writeUInt4(h.getCtrlId());

        sw.writeUInt4(h.getProperty().getValue());
        sw.writeUInt2(h.getColumnGap());
        sw.writeUInt2(h.getVerticalLineAlign());
        sw.writeUInt2(h.getHorizontalLineAlign());
        sw.writeUInt4(h.getDefaultTabGap());
        sw.writeUInt2(h.getNumberParaShapeId());
        sw.writeUInt2(h.getPageStartNumber());
        sw.writeUInt2(h.getImageStartNumber());
        sw.writeUInt2(h.getTableStartNumber());
        sw.writeUInt2(h.getEquationStartNumber());
        if (sw.getFileVersion().isOver(5, 0, 1, 2)) {
            sw.writeUInt2(h.getDefaultLanguage());
        }
        sw.writeZero(8);
    }

    /**
     * 컨트롤 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param h  컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(CtrlHeaderSectionDefine h, StreamWriter sw)
            throws IOException {
        int size = (sw.getFileVersion().isOver(5, 0, 1, 2)) ? 38 : 36;
        sw.writeRecordHeader(HWPTag.CTRL_HEADER, size);
    }

    /**
     * 바탕쪽 정보를 쓴다.
     *
     * @param sd 구역 정의 컨트롤
     * @param sw 스트림 라이터
     * @throws Exception
     */
    private static void batangPageInfoList(ControlSectionDefine sd,
                                           StreamWriter sw) throws Exception {
        for (BatangPageInfo bpi : sd.getBatangPageInfoList()) {
            ForBatangPageInfo.write(bpi, sw);
        }
    }

    /**
     * 컨트롤 데이터(??)를 쓴다.
     *
     * @param sd 구역 정의 컨트롤
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void ctrlData(ControlSectionDefine sd, StreamWriter sw)
            throws IOException {
        if (sd.getCtrlData() != null) {
            ForCtrlData.write(sd.getCtrlData(), sw);
        }
    }
}

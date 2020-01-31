package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.secd;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderSectionDefine;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 구역 정보 컨트롤의 컨트롤 헤더 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForCtrlHeaderSecd {
    /**
     * 구역 정보 컨트롤의 컨트롤 헤더 레코드를 읽는다.
     *
     * @param header 구역 정보 컨트롤의 컨트롤 헤더 레코드
     * @param sr     스트림 리더
     * @throws IOException
     */
    public static void read(CtrlHeaderSectionDefine header, StreamReader sr)
            throws IOException {
        header.getProperty().setValue(sr.readUInt4());
        header.setColumnGap(sr.readUInt2());
        header.setVerticalLineAlign(sr.readUInt2());
        header.setHorizontalLineAlign(sr.readUInt2());
        header.setDefaultTabGap(sr.readUInt4());
        header.setNumberParaShapeId(sr.readUInt2());
        header.setPageStartNumber(sr.readUInt2());
        header.setImageStartNumber(sr.readUInt2());
        header.setTableStartNumber(sr.readUInt2());
        header.setEquationStartNumber(sr.readUInt2());

        if (sr.isEndOfRecord() == false
                && sr.getFileVersion().isOver(5, 0, 1, 2)) {
            header.setDefaultLanguage(sr.readUInt2());
        }

        if (sr.isEndOfRecord() == false) {
            unknownRestBytes(sr);
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

package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.bookmark;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.CtrlData;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 임의 데이타 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForCtrlData {
    /**
     * 임의 데이터 레코드를 쓴다.
     *
     * @param cd 임의 데이터 레코드
     * @param sw 스크림 라이터
     * @throws IOException
     */
    public static void write(CtrlData cd, StreamWriter sw) throws IOException {
        if (cd == null) {
            return;
        }

        recordHeader(cd, sw);

        ForParameterSet.write(cd.getParameterSet(), sw);
    }

    /**
     * 임의 데이터 레코드의 레코드 헤더를 쓴다.
     *
     * @param cd 임의 데이터 레코드
     * @param sw 스크림 라이터
     * @throws IOException
     */
    private static void recordHeader(CtrlData cd, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.CTRL_DATA, getSize(cd));
    }

    /**
     * 임의 데이터 레코드의 크기를 반환한다.
     *
     * @param cd 임의 데이터 레코드
     * @return 임의 데이터 레코드의 크기
     */
    private static int getSize(CtrlData cd) {
        return ForParameterSet.getSize(cd.getParameterSet());
    }
}

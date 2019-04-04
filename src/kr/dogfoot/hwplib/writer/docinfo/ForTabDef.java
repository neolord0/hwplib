package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.TabDef;
import kr.dogfoot.hwplib.object.docinfo.tabdef.TabInfo;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 텝 정의 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForTabDef {
    /**
     * 탭 정의 레코드를 쓴다.
     *
     * @param td 탭 정의 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(TabDef td, StreamWriter sw) throws IOException {
        recordHeader(td, sw);

        sw.writeUInt4(td.getProperty().getValue());

        long tabInfoCount = td.getTabInfoList().size();
        sw.writeUInt4(tabInfoCount);
        if (tabInfoCount > 0) {
            tabInfos(td, sw);
        }
    }

    /**
     * 탭 정의 레코드의 레코드 헤더를 쓴다.
     *
     * @param td 탭 정의 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(TabDef td, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.TAB_DEF, getSize(td));
    }

    /**
     * 탭 정의 레코드의 크기를 반환한다.
     *
     * @param td 탭 정의 레코드
     * @return 탭 정의 레코드의 크기
     */
    private static int getSize(TabDef td) {
        int size = 0;
        size += 8;
        size += 8 * td.getTabInfoList().size();
        return size;
    }

    /**
     * 탭 정보 부분을 쓴다.
     *
     * @param td 탭 정의 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void tabInfos(TabDef td, StreamWriter sw) throws IOException {
        for (TabInfo ti : td.getTabInfoList()) {
            sw.writeUInt4(ti.getPosition());
            sw.writeUInt1(ti.getTabSort().getValue());
            sw.writeUInt1(ti.getFillSort().getValue());
            sw.writeZero(2);
        }
    }
}

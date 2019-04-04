package kr.dogfoot.hwplib.writer.bodytext.paragraph;

import kr.dogfoot.hwplib.object.bodytext.paragraph.rangetag.ParaRangeTag;
import kr.dogfoot.hwplib.object.bodytext.paragraph.rangetag.RangeTagItem;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 문서의 영역 테그 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForParaRangeTag {
    /**
     * 문서의 영역 테그 레코드를 쓴다.
     *
     * @param prt 문서의 영역 테그 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    public static void write(ParaRangeTag prt, StreamWriter sw)
            throws IOException {
        if (prt == null) {
            return;
        }

        recordHeader(prt, sw);

        for (RangeTagItem rti : prt.getRangeTagItemList()) {
            rangeTagItem(rti, sw);
        }
    }

    /**
     * 문서의 영역 테그 레코드의 레코드 헤더를 쓴다.
     *
     * @param prt 문서의 영역 테그 레코드
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(ParaRangeTag prt, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.PARA_RANGE_TAG, getSize(prt));
    }

    /**
     * 문서의 영역 테그 레코드의 크기를 반환한다.
     *
     * @param prt 문서의 영역 테그 레코드
     * @return 문서의 영역 테그 레코드의 크기
     */
    private static int getSize(ParaRangeTag prt) {
        return prt.getRangeTagItemList().size() * 12;
    }

    /**
     * 영역 태그 정보을 쓴다.
     *
     * @param rti 영역 태그 정보
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void rangeTagItem(RangeTagItem rti, StreamWriter sw)
            throws IOException {
        sw.writeUInt4(rti.getRangeStart());
        sw.writeUInt4(rti.getRangeEnd());
        sw.writeBytes(rti.getData(), 3);
        sw.writeUInt1(rti.getSort());
    }
}

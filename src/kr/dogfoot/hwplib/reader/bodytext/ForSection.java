package kr.dogfoot.hwplib.reader.bodytext;

import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.BatangPageInfo;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.secd.ForBatangPageInfo;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

/**
 * 구역 스트림을 읽기 위한 객체
 *
 * @author 박성균
 */
public class ForSection {
    /**
     * 구역 스트림을 읽는다.
     *
     * @param s  구역 객체
     * @param sr 스트림 리더
     * @throws Exception
     */
    public static void read(Section s, StreamReader sr) throws Exception {
        ForParagraphList.read(s, sr);
        if (sr.isEndOfStream() == false) {
            s.createLastBatangPageInfo();
            lastBatangPageInfo(s.getLastBatangPageInfo(), sr);
        }
    }

    /**
     * 마지막 바탕쪽을 읽는다.
     *
     * @param lastBatangPageInfo 마지막 바탕쪽 객체
     * @param sr                 스트림 리더
     * @throws Exception
     */
    private static void lastBatangPageInfo(BatangPageInfo lastBatangPageInfo,
                                           StreamReader sr) throws Exception {
        ForBatangPageInfo.read(lastBatangPageInfo, sr);
    }
}

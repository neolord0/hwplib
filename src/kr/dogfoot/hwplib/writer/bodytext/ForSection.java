package kr.dogfoot.hwplib.writer.bodytext;

import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.ForParagraphList;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.secd.ForBatangPageInfo;

/**
 * 구역을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForSection {
    /**
     * 구역을 쓴다.
     *
     * @param s  구역
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(Section s, StreamWriter sw) throws Exception {
        ForParagraphList.write(s, sw);
        if (s.getLastBatangPageInfo() != null) {
            sw.upRecordLevel();
            ForBatangPageInfo.write(s.getLastBatangPageInfo(), sw);
            sw.downRecordLevel();
        }
    }
}

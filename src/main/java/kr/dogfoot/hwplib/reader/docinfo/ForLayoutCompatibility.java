package kr.dogfoot.hwplib.reader.docinfo;

import kr.dogfoot.hwplib.object.docinfo.LayoutCompatibility;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 레이아웃 호환 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForLayoutCompatibility {
    /**
     * 호환 문서 레코드를 읽는다.
     *
     * @param lc 레이아웃 호환 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(LayoutCompatibility lc, StreamReader sr)
            throws IOException {
        lc.setLetterLevelFormat(sr.readUInt4());
        lc.setParagraphLevelFormat(sr.readUInt4());
        lc.setSectionLevelFormat(sr.readUInt4());
        lc.setObjectLevelFormat(sr.readUInt4());
        lc.setFieldLevelFormat(sr.readUInt4());
    }
}

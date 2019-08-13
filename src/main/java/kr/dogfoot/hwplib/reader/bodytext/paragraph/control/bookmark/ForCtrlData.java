package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.bookmark;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.CtrlData;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 임의 데이타 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForCtrlData {
    /**
     * 임의 데이터 객체를 읽는다.
     *
     * @param cd 임의 데이터 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(CtrlData cd, StreamReader sr) throws IOException {
        ForParameterSet.read(cd.getParameterSet(), sr);
    }
}

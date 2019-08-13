package kr.dogfoot.hwplib.reader.docinfo;

import kr.dogfoot.hwplib.object.docinfo.DocumentPropeties;
import kr.dogfoot.hwplib.object.docinfo.documentproperties.CaretPosition;
import kr.dogfoot.hwplib.object.docinfo.documentproperties.StartNumber;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 문서 속성 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForDocumentPropeties {
    /**
     * 문서 속성 레코드를 읽는다.
     *
     * @param dp 문서 속성 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(DocumentPropeties dp,
                            StreamReader sr) throws IOException {
        property(dp, sr);
        startNumber(dp.getStartNumber(), sr);
        caretPosition(dp.getCaretPosition(), sr);
    }

    /**
     * 속성 부분을 읽는다.
     *
     * @param dp 문서 속성 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void property(DocumentPropeties dp,
                                 StreamReader sr) throws IOException {
        dp.setSectionCount(sr.readUInt2());
    }

    /**
     * 시작 번호 부분을 읽는다.
     *
     * @param sn 시작 번호 부분 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void startNumber(StartNumber sn,
                                    StreamReader sr) throws IOException {
        sn.setPage(sr.readUInt2());
        sn.setFootnote(sr.readUInt2());
        sn.setEndnote(sr.readUInt2());
        sn.setPicture(sr.readUInt2());
        sn.setTable(sr.readUInt2());
        sn.setEquation(sr.readUInt2());
    }

    /**
     * 캐릿 위치 부분을 읽는다.
     *
     * @param cp 캐릿 위치 부분을 나태내는 객체
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void caretPosition(CaretPosition cp,
                                      StreamReader sr) throws IOException {
        cp.setListID(sr.readUInt4());
        cp.setParagraphID(sr.readUInt4());
        cp.setPositionInParagraph(sr.readUInt4());
    }
}

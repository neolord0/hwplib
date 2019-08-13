package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part;

import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.Caption;
import kr.dogfoot.hwplib.object.bodytext.control.gso.caption.ListHeaderForCaption;
import kr.dogfoot.hwplib.reader.bodytext.ForParagraphList;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 캡션 정보을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForCaption {
    /**
     * 캡션 정보을 읽는다.
     *
     * @param caption 캡션 정보
     * @param sr      스트림 리더
     * @throws Exception
     */
    public static void read(Caption caption, StreamReader sr) throws Exception {
        listHeader(caption.getListHeader(), sr);
        ForParagraphList.read(caption.getParagraphList(), sr);
    }

    /**
     * 캡션 정보의 문단 리스트 헤더 레코드를 읽는다.
     *
     * @param listHeader 캡션 정보의 문단 리스트 헤더 레코드
     * @param sr         스트림 리더
     * @throws IOException
     */
    private static void listHeader(ListHeaderForCaption listHeader,
                                   StreamReader sr) throws IOException {
        listHeader.setParaCount(sr.readSInt4());
        listHeader.getProperty().setValue(sr.readUInt4());
        listHeader.getCaptionProperty().setValue(sr.readUInt4());
        listHeader.setCaptionWidth(sr.readUInt4());
        listHeader.setSpaceBetweenCaptionAndFrame(sr.readUInt2());
        listHeader.setTextWidth(sr.readUInt4());
        unknown8bytes(sr);
    }

    /**
     * 알려지지 않은 8 바이트를 처리한다.
     *
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void unknown8bytes(StreamReader sr) throws IOException {
        sr.skip(8);
    }
}

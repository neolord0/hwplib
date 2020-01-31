package kr.dogfoot.hwplib.reader.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlOverlappingLetter;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderOverlappingLetter;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 글자 겹침 컨트롤을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForControlOverlappingLetter {
    /**
     * 글자 겹침 컨트롤을 읽는다.
     *
     * @param tcps 글자 겹침 컨트롤
     * @param sr   스트림 리더
     * @throws IOException
     */
    public static void read(ControlOverlappingLetter tcps, StreamReader sr)
            throws IOException {
        ctrlHeader(tcps.getHeader(), sr);
    }

    /**
     * 글자 겹침 컨트롤의 컨트롤 헤더 레코드을 읽는다.
     *
     * @param header 글자 겹침 컨트롤의 컨트롤 헤더 레코드
     * @param sr     스트림 리더
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderOverlappingLetter header,
                                   StreamReader sr) throws IOException {
        overlappingLetters(header, sr);

        if (sr.isEndOfRecord() == false) {
            header.setBorderType(sr.readUInt1());
            header.setInternalFontSize(sr.readSInt1());
            header.setExpendInsideLetter(sr.readUInt1());

            charShapeIds(header, sr);
        }
    }

    /**
     * 겹침 글자 부분을 읽는다.
     *
     * @param header 글자 겹침 컨트롤의 컨트롤 헤더 레코드
     * @param sr     스트림 리더
     * @throws IOException
     */
    private static void overlappingLetters(CtrlHeaderOverlappingLetter header,
                                           StreamReader sr) throws IOException {
        int count = sr.readUInt2();
        for (int index = 0; index < count; index++) {
            String letter = sr.readWChar();
            header.addOverlappingLetter(letter);
        }
    }

    /**
     * 글자 모양 부분을 읽는다.
     *
     * @param header 글자 겹침 컨트롤의 컨트롤 헤더 레코드
     * @param sr     스트림 리더
     * @throws IOException
     */
    private static void charShapeIds(CtrlHeaderOverlappingLetter header,
                                     StreamReader sr) throws IOException {
        short count = sr.readUInt1();
        for (short i = 0; i < count; i++) {
            long charShapeId = sr.readUInt4();
            header.addCharShapeId(charShapeId);
        }
    }
}

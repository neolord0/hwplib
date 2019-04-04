package kr.dogfoot.hwplib.writer.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlOverlappingLetter;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderOverlappingLetter;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 글자 겹침 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForControlOverlappingLetter {
    /**
     * 글자 겹침 컨트롤을 쓴다.
     *
     * @param ol 글자 겹침 컨트롤
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(ControlOverlappingLetter ol, StreamWriter sw)
            throws IOException {
        ctrlHeader(ol.getHeader(), sw);
    }

    /**
     * 글자 겹침 컨트롤의 컨트롤 헤더 레코드를 쓴다.
     *
     * @param h  글자 겹침 컨트롤의 컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void ctrlHeader(CtrlHeaderOverlappingLetter h,
                                   StreamWriter sw) throws IOException {
        recordHeader(h, sw);
        sw.writeUInt4(h.getCtrlId());

        overlappingLetters(h, sw);

        sw.writeUInt1(h.getBorderType());
        sw.writeSInt1(h.getInternalFontSize());
        sw.writeUInt1(h.getExpendInsideLetter());

        charShapeIds(h, sw);
    }

    /**
     * 컨트롤 헤더 레코드의 레코드 헤더를 쓴다.
     *
     * @param h  컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(CtrlHeaderOverlappingLetter h,
                                     StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.CTRL_HEADER, getSize(h));
    }

    /**
     * 컨트롤 헤더 레코드의 크기를 반환한다.
     *
     * @param h 컨트롤 헤더 레코드
     * @return 컨트롤 헤더 레코드의 크기
     */
    private static int getSize(CtrlHeaderOverlappingLetter h) {
        int size = 0;
        size += 4;

        size += 2;
        size += h.getOverlappingLetterList().size() * 2;

        size += 3;

        size += 1;
        size += h.getCharShapeIdList().size() * 4;

        return size;
    }

    /**
     * 겹침 글자 부분을 쓴다.
     *
     * @param h  컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void overlappingLetters(CtrlHeaderOverlappingLetter h,
                                           StreamWriter sw) throws IOException {
        sw.writeUInt2(h.getOverlappingLetterList().size());
        for (String letter : h.getOverlappingLetterList()) {
            sw.writeWChar(letter);
        }
    }

    /**
     * 글자 모양 부분을 쓴다.
     *
     * @param h  컨트롤 헤더 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void charShapeIds(CtrlHeaderOverlappingLetter h,
                                     StreamWriter sw) throws IOException {
        sw.writeUInt1((short) h.getCharShapeIdList().size());
        for (long charShapeId : h.getCharShapeIdList()) {
            sw.writeUInt4(charShapeId);
        }
    }
}

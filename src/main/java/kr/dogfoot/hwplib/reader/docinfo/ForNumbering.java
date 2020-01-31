package kr.dogfoot.hwplib.reader.docinfo;

import kr.dogfoot.hwplib.object.docinfo.Numbering;
import kr.dogfoot.hwplib.object.docinfo.numbering.LevelNumbering;
import kr.dogfoot.hwplib.object.docinfo.numbering.ParagraphHeadInfo;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 문단 번호 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForNumbering {
    /**
     * 문단 번호 레코드를 읽는다.
     *
     * @param n  문단 번호 레코드
     * @param sr 스트림 리더
     * @throws Exception
     */
    public static void read(Numbering n, StreamReader sr) throws Exception {
        levelNumberingsFor1To7(n, sr);
        n.setStartNumber(sr.readUInt2());

        if (sr.isEndOfRecord() == false && sr.getFileVersion().isOver(5, 0, 2, 5)) {
            startNumbersFor1To7(n, sr);
        }

        if (sr.isEndOfRecord() == false) {
            levelNumberingsFor8To10(n, sr);
            startNumbersFor8To10(n, sr);
        }
    }

    /**
     * 1～7 수준에 해당하는 문단 번호 정보 부분을 읽는다.
     *
     * @param n  문단 번호 레코드
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void levelNumberingsFor1To7(Numbering n, StreamReader sr)
            throws Exception {
        for (int level = 1; level <= 7; level++) {
            levelNumbering(n.getLevelNumbering(level), sr);
        }
    }

    /**
     * 하나의 레벨에 해당하는 문단 번호 정보을 읽는다.
     *
     * @param ln 하나의 레벨에 해당하는 문단 번호 정보
     * @param sr 스트림 리더
     * @throws IOException
     */
    private static void levelNumbering(LevelNumbering ln, StreamReader sr)
            throws IOException {
        paragraphHeadInfo(ln.getParagraphHeadInfo(), sr);
        ln.setNumberFormat(sr.readUTF16LEString());
    }


    /**
     * 문단 머리 정보 부분을 읽는다.
     *
     * @param phi 문단 머리 정보 부분을 나타내는 객체
     * @param sr  스트림 리더
     * @throws IOException
     */
    public static void paragraphHeadInfo(ParagraphHeadInfo phi, StreamReader sr)
            throws IOException {
        phi.getProperty().setValue(sr.readUInt4());
        phi.setCorrectionValueForWidth(sr.readUInt2());
        phi.setDistanceFromBody(sr.readUInt2());
        phi.setCharShapeID(sr.readUInt4());
    }

    /**
     * 1～7 수준의 시작번호 부분을 읽는다.
     *
     * @param n  문단 번호 레코드
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void startNumbersFor1To7(Numbering n, StreamReader sr)
            throws Exception {
        for (int level = 1; level <= 7; level++) {
            n.getLevelNumbering(level).setStartNumber(sr.readUInt4());
        }
    }

    /**
     * 8～10 수준에 해당하는 문단 번호 정보 부분을 읽는다.
     *
     * @param n  문단 번호 레코드
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void levelNumberingsFor8To10(Numbering n, StreamReader sr)
            throws Exception {
        for (int level = 8; level <= 10; level++) {
            levelNumbering(n.getLevelNumbering(level), sr);
        }
    }

    /**
     * 8～10 수준의 시작번호 부분을 읽는다.
     *
     * @param n  문단 번호 레코드
     * @param sr 스트림 리더
     * @throws Exception
     */
    private static void startNumbersFor8To10(Numbering n, StreamReader sr)
            throws Exception {
        for (int level = 8; level <= 10; level++) {
            n.getLevelNumbering(level).setStartNumber(sr.readUInt4());
        }
    }
}

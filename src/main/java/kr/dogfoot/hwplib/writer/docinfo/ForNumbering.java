package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.Numbering;
import kr.dogfoot.hwplib.object.docinfo.numbering.LevelNumbering;
import kr.dogfoot.hwplib.object.docinfo.numbering.ParagraphHeadInfo;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 문단 번호 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForNumbering {
    /**
     * 문단 번호 레코드를 쓴다.
     *
     * @param n  문단 번호 레코드
     * @param sw 스트림 라이터
     * @throws Exception
     */
    public static void write(Numbering n, StreamWriter sw) throws Exception {
        recordHeader(n, sw);

        levelNumberings(n, sw);
        sw.writeUInt2(n.getStartNumber());
        if (sw.getFileVersion().isOver(5, 0, 2, 5)) {
            startNumberForLevels(n, sw);
        }
    }

    /**
     * 문단 번호 레코드의 레코드 헤더를 쓴다.
     *
     * @param n  문단 번호 레코드
     * @param sw 스트림 라이터
     * @throws Exception
     */
    private static void recordHeader(Numbering n, StreamWriter sw)
            throws Exception {
        sw.writeRecordHeader(HWPTag.NUMBERING, getSize(n, sw.getFileVersion()));
    }

    /**
     * 문단 번호 레코드의 크기를 반환한다.
     *
     * @param n       문단 번호 레코드
     * @param version 파일 버전
     * @return 문단 번호 레코드의 크기
     * @throws Exception
     */
    private static int getSize(Numbering n, FileVersion version) throws Exception {
        int size = 0;
        for (int level = 1; level <= 7; level++) {
            LevelNumbering ln = n.getLevelNumbering(level);
            size += 12 + StringUtil.getUTF16LEStringSize(ln.getNumberFormat());
        }
        size += 2;
        if (version.isOver(5, 0, 2, 5)) {
            size += 4 * 7;
        }
        return size;
    }

    /**
     * 모든 수준(1～7)에 해당하는 문단 번호 정보 부분을 쓴다.
     *
     * @param n  문단 번호 레코드
     * @param sw 스트림 라이터
     * @throws Exception
     */
    private static void levelNumberings(Numbering n, StreamWriter sw)
            throws Exception {
        for (int level = 1; level <= 7; level++) {
            levelNumbering(n.getLevelNumbering(level), sw);
        }
    }

    /**
     * 하나의 레벨에 해당하는 문단 번호 정보을 쓴다.
     *
     * @param ln 하나의 레벨에 해당하는 문단 번호 정보
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void levelNumbering(LevelNumbering ln, StreamWriter sw)
            throws IOException {
        paragraphHeadInfo(ln.getParagraphHeadInfo(), sw);
        sw.writeUTF16LEString(ln.getNumberFormat());
    }

    /**
     * 문단 머리 정보 부분을 쓴다.
     *
     * @param phi 문단 머리 정보
     * @param sw  스트림 라이터
     * @throws IOException
     */
    public static void paragraphHeadInfo(ParagraphHeadInfo phi, StreamWriter sw)
            throws IOException {
        sw.writeUInt4(phi.getProperty().getValue());
        sw.writeUInt2(phi.getCorrectionValueForWidth());
        sw.writeUInt2(phi.getDistanceFromBody());
        sw.writeUInt4(phi.getCharShapeID());
    }

    /**
     * 수준별 시작번호 부분을 쓴다.
     *
     * @param n  문단 번호 레코드
     * @param sw 스트림 라이터
     * @throws Exception
     */
    private static void startNumberForLevels(Numbering n, StreamWriter sw)
            throws Exception {
        for (int level = 1; level <= 7; level++) {
            sw.writeUInt4(n.getStartNumberForLevel(level));
        }
    }
}

package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.Bullet;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 글머리표 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForBullet {
    /**
     * 글머리표 레코드를 쓴다.
     *
     * @param b  글머리표 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(Bullet b, StreamWriter sw) throws IOException {
        recordHeader(sw);

        ForNumbering.paragraphHeadInfo(b.getParagraphHeadInfo(), sw);
        sw.writeWChar(b.getBulletChar());
        sw.writeZero(9);
    }

    /**
     * 글머리표 레코드의 레코드 헤더를 쓴다.
     *
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.BULLET, 23);
    }
}

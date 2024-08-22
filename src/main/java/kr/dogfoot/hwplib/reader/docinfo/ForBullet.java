package kr.dogfoot.hwplib.reader.docinfo;

import kr.dogfoot.hwplib.object.docinfo.Bullet;
import kr.dogfoot.hwplib.reader.docinfo.borderfill.ForFillInfo;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 글머리표 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForBullet {
    /**
     * 글머리표 레코드를 읽는다.
     *
     * @param b  글머리표 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(Bullet b, StreamReader sr) throws IOException {
        ForNumbering.paragraphHeadInfo(b.getParagraphHeadInfo(), sr);
        b.getBulletChar().setBytes(sr.readWChar());

        if (sr.isEndOfRecord()) return;


        long imageBullet = sr.readUInt4();
        if (imageBullet == 1) {
            b.setImageBullet(true);
        } else {
            b.setImageBullet(false);
        }
        ForFillInfo.pictureInfo(b.getImageBulletInfo(), sr);

        if (sr.isEndOfRecord()) return;;

        b.getCheckBulletChar().setBytes(sr.readWChar());
    }
}

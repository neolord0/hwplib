package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.Bullet;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForBullet {
	public static void write(Bullet b, StreamWriter sw) throws IOException {
		recordHeader(b, sw);
		
		ForNumbering.paragraphHeadInfo(b.getParagraphHeadInfo(), sw);
		sw.writeWChar(b.getBulletChar());
		sw.writeZero(9);
	}

	private static void recordHeader(Bullet b, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.BULLET, 1, getSize(b));
	}

	private static int getSize(Bullet b) {
		int size = 0;
		size += 12 + 2 + 9;
		return size;
	}
}

package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.Numbering;
import kr.dogfoot.hwplib.object.docinfo.numbering.LevelNumbering;
import kr.dogfoot.hwplib.object.docinfo.numbering.ParagraphHeadInfo;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForNumbering {
	public static void write(Numbering n, StreamWriter sw) throws Exception {
		recordHeader(n, sw);

		levelNumberings(n, sw);
		sw.writeUInt2(n.getStartNumber());
		if (sw.getFileVersion().isOver(5, 0, 2, 5)) {
			startNumberForLevels(n, sw);
		}
	}

	private static void recordHeader(Numbering n, StreamWriter sw)
			throws Exception {
		sw.writeRecordHeader(HWPTag.NUMBERING, 1, getSize(n, sw));
	}

	private static int getSize(Numbering n, StreamWriter sw) throws Exception {
		int size = 0;
		for (int level = 1; level <= 7; level++) {
			LevelNumbering ln = n.getLevelNumbering(level);
			size += 12 + StringUtil.getUTF16LEStringSize(ln.getNumberFormat());
		}
		size += 2;
		if (sw.getFileVersion().isOver(5, 0, 2, 5)) {
			size += 4 * 7;
		}
		return size;
	}

	private static void levelNumberings(Numbering n, StreamWriter sw)
			throws Exception {
		for (int level = 1; level <= 7; level++) {
			levelNumbering(n.getLevelNumbering(level), sw);
		}
	}

	private static void levelNumbering(LevelNumbering ln, StreamWriter sw)
			throws IOException {
		paragraphHeadInfo(ln.getParagraphHeadInfo(), sw);
		sw.writeUTF16LEString(ln.getNumberFormat());
	}

	public static void paragraphHeadInfo(ParagraphHeadInfo phi, StreamWriter sw)
			throws IOException {
		sw.writeUInt4(phi.getProperty().getValue());
		sw.writeUInt2(phi.getCorrectionValueForWidth());
		sw.writeUInt2(phi.getDistanceFromBody());
		sw.writeUInt4(phi.getCharShapeID());
	}

	private static void startNumberForLevels(Numbering n, StreamWriter sw)
			throws Exception {
		for (int level = 1; level <= 7; level++) {
			sw.writeUInt4(n.getStartNumberForLevel(level));
		}
	}
}

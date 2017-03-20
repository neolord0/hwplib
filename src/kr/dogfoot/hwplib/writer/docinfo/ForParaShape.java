package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.ParaShape;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForParaShape {
	public static void write(ParaShape ps, StreamWriter sw) throws IOException {
		recordHeader(ps, sw);

		sw.writeUInt4(ps.getProperty1().getValue());
		sw.writeSInt4(ps.getLeftMargin());
		sw.writeSInt4(ps.getRightMargin());
		sw.writeSInt4(ps.getIndent());
		sw.writeSInt4(ps.getTopParaSpace());
		sw.writeSInt4(ps.getBottomParaSpace());
		sw.writeSInt4(ps.getLineSpace());
		sw.writeUInt2(ps.getTabDefId());
		sw.writeUInt2(ps.getParaHeadId());
		sw.writeUInt2(ps.getBorderFillId());
		sw.writeSInt2(ps.getLeftBorderSpace());
		sw.writeSInt2(ps.getRightBorderSpace());
		sw.writeSInt2(ps.getTopBorderSpace());
		sw.writeSInt2(ps.getBottomBorderSpace());
		if (sw.getFileVersion().isOver(5, 0, 1, 7)) {
			sw.writeUInt4(ps.getProperty2().getValue());
		}
		if (sw.getFileVersion().isOver(5, 0, 2, 5)) {
			sw.writeUInt4(ps.getProperty3().getValue());
			sw.writeUInt4(ps.getLineSpace2());
		}
	}

	private static void recordHeader(ParaShape ps, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.PARA_SHAPE, 1, getSize(sw));
	}

	private static int getSize(StreamWriter sw) {
		int size = 0;
		size += 42;
		if (sw.getFileVersion().isOver(5, 0, 1, 7)) {
			size += 4;
		}
		if (sw.getFileVersion().isOver(5, 0, 2, 5)) {
			size += 8;
		}
		return size;
	}
}

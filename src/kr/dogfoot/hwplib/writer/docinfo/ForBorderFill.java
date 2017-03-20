package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.BorderFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.EachBorder;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.docinfo.borderfill.ForFillInfo;


public class ForBorderFill {

	public static void write(BorderFill bf, StreamWriter sw) throws IOException {
		recordHeader(bf, sw);
		
		sw.writeUInt2(bf.getProperty().getValue());
		
		writeEachBorder(bf.getLeftBorder(), sw);
		writeEachBorder(bf.getRightBorder(), sw);
		writeEachBorder(bf.getTopBorder(), sw);
		writeEachBorder(bf.getBottomBorder(), sw);
		writeDiagonalLine(bf, sw);
		
		ForFillInfo.write(bf.getFillInfo(), sw);
	}

	private static void recordHeader(BorderFill bf, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.BORDER_FILL, 1, getSize(bf));
	}

	private static int getSize(BorderFill bf) {
		int size = 0;
		size += 2;
		size += (1 + 1 + 4) * 5;
		size += ForFillInfo.getSize(bf.getFillInfo());
		return size;
	}

	private static void writeEachBorder(EachBorder eb, StreamWriter sw) throws IOException {
		sw.writeUInt1(eb.getType().getValue());
		sw.writeUInt1(eb.getThickness().getValue());
		sw.writeUInt4(eb.getColor().getColor());
	}

	private static void writeDiagonalLine(BorderFill bf, StreamWriter sw) throws IOException {
		sw.writeUInt1(bf.getDiagonalSort().getValue());
		sw.writeUInt1(bf.getDiagonalThickness().getValue());
		sw.writeUInt4(bf.getDiagonalColor().getColor());
	}
	
}

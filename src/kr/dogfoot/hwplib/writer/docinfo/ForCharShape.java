package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.CharShape;
import kr.dogfoot.hwplib.object.docinfo.charshape.CharOffsets;
import kr.dogfoot.hwplib.object.docinfo.charshape.CharSpaces;
import kr.dogfoot.hwplib.object.docinfo.charshape.FaceNameIds;
import kr.dogfoot.hwplib.object.docinfo.charshape.Ratios;
import kr.dogfoot.hwplib.object.docinfo.charshape.RelativeSizes;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForCharShape {
	public static void write(CharShape cs, StreamWriter sw) throws IOException {
		recordHeader(sw);

		faceNameIds(cs.getFaceNameIds(), sw);
		ratios(cs.getRatios(), sw);
		charSpaces(cs.getCharSpaces(), sw);
		relativeSizes(cs.getRelativeSizes(), sw);
		charPositions(cs.getCharOffsets(), sw);

		sw.writeSInt4(cs.getBaseSize());
		sw.writeUInt4(cs.getProperty().getValue());
		sw.writeSInt1(cs.getShadowGap1());
		sw.writeSInt1(cs.getShadowGap2());
		sw.writeUInt4(cs.getCharColor().getColor());
		sw.writeUInt4(cs.getUnderLineColor().getColor());
		sw.writeUInt4(cs.getShadeColor().getColor());
		sw.writeUInt4(cs.getShadowColor().getColor());

		if (sw.getFileVersion().isOver(5, 0, 2, 1)) {
			sw.writeUInt2(cs.getBorderFillId());
		}
		if (sw.getFileVersion().isOver(5, 0, 3, 0)) {
			sw.writeUInt4(cs.getStrikeLineColor().getColor());
		}
	}

	private static void recordHeader(StreamWriter sw)
			throws IOException {
		sw.writeRecordHeader(HWPTag.CHAR_SHAPE, 1, getSize(sw));
	}

	private static int getSize(StreamWriter sw) {
		int size = 0;
		size += 14 + 7 + 7 + 7 + 7;
		size += 26;
		if (sw.getFileVersion().isOver(5, 0, 2, 1)) {
			size += 2;
		}
		if (sw.getFileVersion().isOver(5, 0, 3, 0)) {
			size += 4;
		}
		return size;
	}

	private static void faceNameIds(FaceNameIds fni, StreamWriter sw)
			throws IOException {
		for (int faceNameId : fni.getArray()) {
			sw.writeUInt2(faceNameId);
		}
	}

	private static void ratios(Ratios ratios, StreamWriter sw)
			throws IOException {
		for (short ratio : ratios.getArray()) {
			sw.writeUInt1(ratio);
		}
	}

	private static void charSpaces(CharSpaces charSpaces, StreamWriter sw)
			throws IOException {
		for (byte charSpace : charSpaces.getArray()) {
			sw.writeSInt1(charSpace);
		}
	}

	private static void relativeSizes(RelativeSizes rss, StreamWriter sw) throws IOException {
		for (short rs : rss.getArray()) {
			sw.writeUInt1(rs);
		}
	}
	

	private static void charPositions(CharOffsets cos, StreamWriter sw) throws IOException {
		for (byte co : cos.getArray()) {
			sw.writeSInt1(co);
		}
	}
}

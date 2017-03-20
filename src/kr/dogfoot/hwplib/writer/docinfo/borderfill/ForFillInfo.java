package kr.dogfoot.hwplib.writer.docinfo.borderfill;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.FillInfo;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.GradientFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.ImageFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.PatternFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.PictureInfo;
import kr.dogfoot.hwplib.object.etc.Color4Byte;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForFillInfo {
	public static void write(FillInfo fi, StreamWriter sw) throws IOException {
		sw.writeUInt4(fi.getType().getValue());
		if (fi.getType().getValue() != 0) {
			if (fi.getType().hasPatternFill()) {
				writePatternFill(fi.getPatternFill(), sw);
			}
			if (fi.getType().hasGradientFill()) {
				writeGradientFill(fi.getGradientFill(), sw);
			}
			if (fi.getType().hasImageFill()) {
				writeImageFill(fi.getImageFill(), sw);
			}
			additionalProperty(fi, sw);
			unknownBytes(fi, sw);
		} else {
			sw.writeZero(4);
		}
	}

	private static void writePatternFill(PatternFill pf, StreamWriter sw)
			throws IOException {
		sw.writeUInt4(pf.getBackColor().getColor());
		sw.writeUInt4(pf.getPatternColor().getColor());
		sw.writeUInt4(pf.getPatternType().getValue());
	}

	private static void writeGradientFill(GradientFill gf, StreamWriter sw)
			throws IOException {
		sw.writeSInt1(gf.getGradientType().getValue());
		sw.writeUInt4(gf.getStartAngle());
		sw.writeUInt4(gf.getCenterX());
		sw.writeUInt4(gf.getCenterY());
		sw.writeUInt4(gf.getBlurringDegree());

		long colorCount = gf.getColorList().size();
		sw.writeUInt4(colorCount);
		if (colorCount > 2) {
			for (int cp : gf.getChangePointList()) {
				sw.writeSInt4(cp);
			}
		}
		for (Color4Byte c : gf.getColorList()) {
			sw.writeUInt4(c.getColor());
		}
	}

	private static void writeImageFill(ImageFill imf, StreamWriter sw)
			throws IOException {
		sw.writeUInt1(imf.getImageFillType().getValue());
		pictureInfo(imf.getPictureInfo(), sw);
	}

	private static void pictureInfo(PictureInfo pi, StreamWriter sw)
			throws IOException {
		sw.writeSInt1(pi.getBrightness());
		sw.writeSInt1(pi.getContrast());
		sw.writeUInt1(pi.getEffect().getValue());
		sw.writeUInt2(pi.getBinItemID());
	}

	private static void additionalProperty(FillInfo fi, StreamWriter sw)
			throws IOException {
		if (fi.getType().hasGradientFill() == true) {
			sw.writeUInt4(1);
			sw.writeUInt1(fi.getGradientFill().getBlurringCenter());
		} else {
			sw.writeUInt4(0);
		}
	}

	private static void unknownBytes(FillInfo fi, StreamWriter sw)
			throws IOException {
		if (fi.getType().hasPatternFill()) {
			sw.writeZero(1);
		}
		if (fi.getType().hasGradientFill()) {
			sw.writeZero(1);
		}
		if (fi.getType().hasImageFill()) {
			sw.writeZero(1);
		}
	}

	public static int getSize(FillInfo fi) {
		int size = 0;
		size += 4;
		if (fi.getType().getValue() != 0) {
			if (fi.getType().hasPatternFill()) {
				size += 12;
			}
			if (fi.getType().hasGradientFill()) {
				size += 17;

				size += 4;
				long colorCount = fi.getGradientFill().getColorList().size();
				if (colorCount > 2) {
					size += colorCount * 4;
				}
				size += colorCount * 4;
			}
			if (fi.getType().hasImageFill()) {
				size += 6;
			}

			// additionalProperty
			if (fi.getType().hasGradientFill() == true) {
				size += 4;
				size += 1;
			} else {
				size += 4;
			}

			// unknownBytes
			if (fi.getType().hasPatternFill()) {
				size += 1;
			}
			if (fi.getType().hasGradientFill()) {
				size += 1;
			}
			if (fi.getType().hasImageFill()) {
				size += 1;
			}
		} else {
			size += 4;
		}
		return size;
	}
}

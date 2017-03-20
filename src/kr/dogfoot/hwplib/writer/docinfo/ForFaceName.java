package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.FaceName;
import kr.dogfoot.hwplib.object.docinfo.facename.FontTypeInfo;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForFaceName {
	public static void write(FaceName fn, StreamWriter sw) throws IOException {
		recordHeader(fn, sw);

		sw.writeUInt1(fn.getProperty().getValue());
		sw.writeUTF16LEString(fn.getName());
		if (fn.getProperty().hasSubstituteFont()) {
			sw.writeUInt1(fn.getSubstituteFontType().getValue());
			sw.writeUTF16LEString(fn.getSubstituteFontName());
		}
		if (fn.getProperty().hasFontInfo()) {
			fontTypeInfo(fn.getFontTypeInfo(), sw);
		}
		if (fn.getProperty().hasBaseFont()) {
			sw.writeUTF16LEString(fn.getBaseFontName());
		}

	}

	private static void recordHeader(FaceName fn, StreamWriter sw)
			throws IOException {
		sw.writeRecordHeader(HWPTag.FACE_NAME, 1, getSize(fn));
	}

	private static int getSize(FaceName fn) {
		int size = 0;
		size += 1;

		size += StringUtil.getUTF16LEStringSize(fn.getName());
		if (fn.getProperty().hasSubstituteFont()) {
			size += 1;
			size += StringUtil.getUTF16LEStringSize(fn.getSubstituteFontName());
		}

		if (fn.getProperty().hasFontInfo()) {
			size += 10;
		}

		if (fn.getProperty().hasBaseFont()) {
			size += StringUtil.getUTF16LEStringSize(fn.getBaseFontName());
		}
		return size;
	}

	private static void fontTypeInfo(FontTypeInfo fti, StreamWriter sw)
			throws IOException {
		sw.writeUInt1(fti.getFontType());
		sw.writeUInt1(fti.getSerifType());
		sw.writeUInt1(fti.getThickness());
		sw.writeUInt1(fti.getRatio());
		sw.writeUInt1(fti.getContrast());
		sw.writeUInt1(fti.getStrokeDeviation());
		sw.writeUInt1(fti.getCharacterStrokeType());
		sw.writeUInt1(fti.getCharacterShape());
		sw.writeUInt1(fti.getMiddleLine());
		sw.writeUInt1(fti.getxHeight());
	}
}

package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.BinData;
import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataType;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForBinData {
	public static void write(BinData bd, StreamWriter sw) throws IOException {
		recordHeader(bd, sw);

		sw.writeUInt2(bd.getProperty().getValue());
		if (bd.getProperty().getType() == BinDataType.Link) {
			sw.writeUTF16LEString(bd.getAbsolutePathForLink());
			sw.writeUTF16LEString(bd.getRelativePathForLink());
		}

		if (bd.getProperty().getType() == BinDataType.Embedding
				|| bd.getProperty().getType() == BinDataType.Storage) {
			sw.writeUInt2(bd.getBinDataID());
		}
		if (bd.getProperty().getType() == BinDataType.Embedding) {
			sw.writeUTF16LEString(bd.getExtensionForEmbedding());
		}
	}

	private static void recordHeader(BinData bd, StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.BIN_DATA, 1, getSize(bd));
	}

	private static int getSize(BinData bd) {
		int size = 0;
		size += 2;
		if (bd.getProperty().getType() == BinDataType.Link) {
			size += StringUtil.getUTF16LEStringSize(bd.getAbsolutePathForLink());
			size += StringUtil.getUTF16LEStringSize(bd.getRelativePathForLink());
		}

		if (bd.getProperty().getType() == BinDataType.Embedding
				|| bd.getProperty().getType() == BinDataType.Storage) {
			size += 2;
		}
		if (bd.getProperty().getType() == BinDataType.Embedding) {
			size += StringUtil.getUTF16LEStringSize(bd.getExtensionForEmbedding());
		}
		return size;
	}
}

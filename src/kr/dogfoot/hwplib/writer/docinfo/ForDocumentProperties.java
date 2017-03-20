package kr.dogfoot.hwplib.writer.docinfo;

import java.io.IOException;

import kr.dogfoot.hwplib.object.docinfo.DocumentPropeties;
import kr.dogfoot.hwplib.object.docinfo.documentproperties.CaretPosition;
import kr.dogfoot.hwplib.object.docinfo.documentproperties.StartNumber;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForDocumentProperties {
	public static void write(DocumentPropeties dp, StreamWriter sw) throws IOException {
		recordHeader(sw);
		sectionCount(dp, sw);
		startNumber(dp.getStartNumber(), sw);
		caretPosition(dp.getCaretPosition(), sw);
	}

	private static void recordHeader(StreamWriter sw) throws IOException {
		sw.writeRecordHeader(HWPTag.DOCUMENT_PROPERTIES, 0, 26);
	}

	private static void sectionCount(DocumentPropeties dp, StreamWriter sw) throws IOException {
		sw.writeUInt2(dp.getSectionCount());
	}

	private static void startNumber(StartNumber sn, StreamWriter sw) throws IOException {
		sw.writeUInt2(sn.getPage());
		sw.writeUInt2(sn.getFootnote());
		sw.writeUInt2(sn.getEndnote());
		sw.writeUInt2(sn.getPicture());
		sw.writeUInt2(sn.getTable());
		sw.writeUInt2(sn.getEquation());
	}

	private static void caretPosition(CaretPosition cp,
			StreamWriter sw) throws IOException {
		sw.writeUInt4(cp.getListID());
		sw.writeUInt4(cp.getParagraphID());
		sw.writeUInt4(cp.getPositionInParagraph());
	}
}

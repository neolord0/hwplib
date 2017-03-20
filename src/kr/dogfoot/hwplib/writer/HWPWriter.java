package kr.dogfoot.hwplib.writer;

import java.io.IOException;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bindata.EmbeddedBinaryData;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.util.compoundFile.writer.CompoundFileWriter;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.ForSection;
import kr.dogfoot.hwplib.writer.docinfo.ForDocInfo;

public class HWPWriter {
	public static void toFile(HWPFile hwpFile, String filepath) throws Exception {
		if (hwpFile.getFileHeader().hasPassword()) { 
			throw new Exception("Files with passwords are not supported.");
		}

		HWPWriter w = new HWPWriter(hwpFile);
		w.fileHeader();
		w.docInfo();
		w.bodyText();
		w.binData();
		w.writeAndClose(filepath);
	}

	private HWPFile hwpFile;
	private CompoundFileWriter cfw;
	
	private HWPWriter(HWPFile hwpFile) {
		this.hwpFile = hwpFile;
		cfw = new CompoundFileWriter();
	}
	
	private void fileHeader() throws IOException {
		StreamWriter sw =  cfw.openCurrentStream("FileHeader", false, getVersion());
		ForFileHeader.write(hwpFile.getFileHeader(), sw);
		cfw.closeCurrentStream();
	}
	
	private FileVersion getVersion() {
		return hwpFile.getFileHeader().getVersion();
	}

	private void docInfo() throws Exception {
		StreamWriter sw =  cfw.openCurrentStream("DocInfo", isCompressed(), getVersion());
		ForDocInfo fdi = new ForDocInfo();
		fdi.write(hwpFile.getDocInfo(), sw);
		cfw.closeCurrentStream();
	}
	
	private boolean isCompressed() {
		return hwpFile.getFileHeader().isCompressed();
	}

	private void bodyText() throws IOException {
		cfw.openCurrentStorage("BodyText");		
		int index = 0;
		for(Section s : hwpFile.getBodyText().getSectionList()) {
			seciton(index, s);
		}
		
		cfw.closeCurrentStorage();
	}

	private void seciton(int index, Section s) throws IOException {
		StreamWriter sw =  cfw.openCurrentStream("Section" + index, isCompressed(), getVersion());
		ForSection
				.write(s, sw);
		cfw.closeCurrentStream();
	}

	private void binData() throws IOException {
		if (hasBinData()) {
			cfw.openCurrentStorage("BinData");
			for (EmbeddedBinaryData ebd : hwpFile.getBinData().getEmbeddedBinaryDataList()) {
				embeddedBinaryData(ebd);
			}
			cfw.closeCurrentStorage();
		}
	}

	private void embeddedBinaryData(EmbeddedBinaryData ebd) throws IOException {
		StreamWriter sw =  cfw.openCurrentStream(ebd.getName(), isCompressed(), getVersion());
		sw.writeBytes(ebd.getData());
		cfw.closeCurrentStream();
	}

	private boolean hasBinData() {
		return hwpFile.getBinData().getEmbeddedBinaryDataList().size() > 0;
	}

	private void writeAndClose(String filepath) throws IOException {
		cfw.write(filepath);
		cfw.close();
	}
}

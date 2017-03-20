package kr.dogfoot.hwplib.writer;

import java.io.IOException;

import kr.dogfoot.hwplib.object.fileheader.FileHeader;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.util.binary.BitFlag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

public class ForFileHeader {

	public static void write(FileHeader fh, StreamWriter sw) throws IOException {
		signature(sw);
		fileVersion(fh.getVersion(), sw);
		properties(fh, sw);
		zero216(sw);
	}

	private static void signature(StreamWriter sw) throws IOException {
		   byte[] signature = {0x48, 0x57, 0x50, 0x20, 0x44, 0x6F, 0x63, 0x75, 0x6D, 0x65, 0x6E, 0x74, 0x20, 0x46, 0x69, 0x6C, 0x65,
	                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
	     sw.writeBytes(signature);	
	}

	private static void fileVersion(FileVersion version, StreamWriter sw) throws IOException {
		sw.writeUInt4(version.getVersion());
	}

	private static void properties(FileHeader fh, StreamWriter sw) throws IOException {
		long properties = 0;
		properties += BitFlag.set(properties, 0, fh.isCompressed());
		properties += BitFlag.set(properties, 1, fh.hasPassword());
		properties += BitFlag.set(properties, 2, fh.isDeploymentDocument());
		properties += BitFlag.set(properties, 3, fh.isSaveScript());
		properties += BitFlag.set(properties, 4, fh.isDRMDocument());
		properties += BitFlag.set(properties, 5, fh.hasXMLTemplate());
		properties += BitFlag.set(properties, 6, fh.hasDocumentHistory());
		properties += BitFlag.set(properties, 7, fh.hasSignature());
		properties += BitFlag.set(properties, 8, fh.isEncryptPublicCertification());
		properties += BitFlag.set(properties, 9, fh.isSavePrepareSignature());
		properties += BitFlag.set(properties, 10, fh.isPublicCertificationDRMDocument());
		properties += BitFlag.set(properties, 10, fh.isCCLDocument());
		
		sw.writeUInt4(properties);
	}

	private static void zero216(StreamWriter sw) throws IOException {
		sw.writeZero(216);
	}
}

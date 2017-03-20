package kr.dogfoot.hwplib.reader;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.reader.bodytext.ForSection;
import kr.dogfoot.hwplib.reader.docinfo.ForDocInfo;
import kr.dogfoot.hwplib.util.compoundFile.reader.CompoundFileReader;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

/**
 * 한글 파일을 읽는 객체
 * 
 * @author neolord
 */
public class HWPReader {
	/**
	 * hwp 파일을 읽는다.
	 * 
	 * @param filepath
	 *            hwp파일의 경로
	 * @return HWPFile 객체
	 * @throws Exception
	 */
	public static HWPFile fromFile(String filepath) throws Exception {
		HWPReader r = new HWPReader();
		r.hwpFile = new HWPFile();
		r.cfr = new CompoundFileReader(new File(filepath));

		r.fileHeader();
		if (r.hasPassword()) {
			throw new Exception("Files with passwords are not supported.");
		}
		r.docInfo();
		r.bodyText();
		r.binData();

		r.cfr.close();
		return r.hwpFile;
	}

	/**
	 * HWP파일을 나타내는 객체
	 */
	private HWPFile hwpFile;
	/**
	 * MS Compound 파일을 읽기 위한 리더 객체
	 */
	private CompoundFileReader cfr;

	/**
	 * 생성자
	 */
	private HWPReader() {
	}

	/**
	 * FileHeader 스트림을 읽는다.
	 * 
	 * @throws Exception
	 */
	private void fileHeader() throws Exception {
		StreamReader sr = cfr.getChildStreamReader("FileHeader", false, null);
		ForFileHeader.read(hwpFile.getFileHeader(), sr);
		sr.close();
	}

	/**
	 * 암호화된 파일인지 여부를 반환한다.
	 * 
	 * @return 암호화된 파일인지 여부
	 */
	private boolean hasPassword() {
		return hwpFile.getFileHeader().hasPassword();
	}

	/**
	 * DocInfo 스트림을 읽는다.
	 * 
	 * @throws Exception
	 */
	private void docInfo() throws Exception {
		StreamReader sr = cfr.getChildStreamReader("DocInfo", isCompressed(), getVersion());
		ForDocInfo forDocInfo = new ForDocInfo();
		forDocInfo.read(hwpFile.getDocInfo(), sr);
		sr.close();
	}

	/**
	 * 압축된 파일인지 여부를 반환한다.
	 * 
	 * @return 압축된 파일인지 여부
	 */
	private boolean isCompressed() {
		return hwpFile.getFileHeader().isCompressed();
	}

	/**
	 * 파일의 버전을 반환한다.
	 * 
	 * @return 파일의 버전
	 */
	private FileVersion getVersion() {
		return hwpFile.getFileHeader().getVersion();
	}

	/**
	 * BodyText 스토리지를 읽는다.
	 * 
	 * @throws Exception
	 */
	private void bodyText() throws Exception {
		cfr.moveChildStorage("BodyText");
		int sectionCount = hwpFile.getDocInfo().getDocumentProperties()
				.getSectionCount();
		for (int i = 0; i < sectionCount; i++) {
			section(i);
		}
		cfr.moveParentStorage();
	}

	/**
	 * Section 스트림을 읽는다.
	 * 
	 * @param sectionIndex
	 *            섹션 인덱스
	 * @throws Exception
	 */
	private void section(int sectionIndex) throws Exception {
		StreamReader sr = cfr.getChildStreamReader("Section" + sectionIndex,
				isCompressed(), getVersion());
		ForSection
				.read(hwpFile.getBodyText().addNewSection(), sr);
		sr.close();
	}

	/**
	 * BinData 스토리지를 읽는다.
	 * 
	 * @throws Exception
	 */
	private void binData() throws Exception {
		if (cfr.isChildStorage("BinData")) {
			cfr.moveChildStorage("BinData");
			Set<String> ss = cfr.listChildNames();
			Iterator<String> it = ss.iterator();
			while (it.hasNext()) {
				String name = it.next();
				hwpFile.getBinData().addNewEmbeddedBinaryData(name,
						readEmbededBinaryData(name));
			}
			cfr.moveParentStorage();
		}
	}

	/**
	 * BinData 스토리지 아래에 스트림을 읽는다.
	 * 
	 * @param name
	 *            스트림 이름
	 * @return 스트림에 저장된 데이타
	 * @throws Exception
	 */
	private byte[] readEmbededBinaryData(String name) throws Exception {
		StreamReader sr = cfr.getChildStreamReader(name, false, null);
		byte[] binaryData = new byte[(int) sr.getSize()];
		sr.readBytes(binaryData);
		sr.close();
		return binaryData;
	}
}

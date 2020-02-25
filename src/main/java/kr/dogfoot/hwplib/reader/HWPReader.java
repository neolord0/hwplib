package kr.dogfoot.hwplib.reader;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.docinfo.BinData;
import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataCompress;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.reader.bodytext.ForParagraphList;
import kr.dogfoot.hwplib.reader.bodytext.ForSection;
import kr.dogfoot.hwplib.reader.docinfo.ForDocInfo;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractMethod;
import kr.dogfoot.hwplib.tool.textextractor.TextExtractorListener;
import kr.dogfoot.hwplib.util.compoundFile.reader.CompoundFileReader;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

/**
 * 한글 파일을 읽기 위한 객체
 *
 * @author neolord
 */
public class HWPReader {
    /**
     * hwp 파일을 읽는다.
     *
     * @param filepath hwp파일의 경로
     * @return HWPFile 객체
     * @throws Exception
     */
    public static HWPFile fromFile(String filepath) throws Exception {
        return fromInputStream(new FileInputStream(filepath));
    }

    /**
     * hwp 파일을 읽는다.
     *
     * @param url hwp파일의 경로
     * @return HWPFile 객체
     * @throws Exception
     */
    public static HWPFile fromURL(String url) throws Exception {
        return fromInputStream(new URL(url).openStream());
    }

    /**
     * hwp 파일을 읽는다.
     *
     * @param is hwp파일을 가리키는 Input Stream ㅒ객체
     * @return HWPFile 객체
     * @throws Exception
     */
    public static HWPFile fromInputStream(InputStream is) throws Exception {
        HWPReader r = new HWPReader();
        r.hwpFile = new HWPFile();
        r.cfr = new CompoundFileReader(is);

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
        int sectionCount = hwpFile.getDocInfo().getDocumentProperties().getSectionCount();
        for (int index = 0; index < sectionCount; index++) {
            section(index);
        }
        cfr.moveParentStorage();
    }

    /**
     * Section 스트림을 읽는다.
     *
     * @param sectionIndex 섹션 인덱스
     * @throws Exception
     */
    private void section(int sectionIndex) throws Exception {
        StreamReader sr = cfr.getChildStreamReader("Section" + sectionIndex, isCompressed(), getVersion());
        sr.setDocInfo(hwpFile.getDocInfo());
        ForSection.read(hwpFile.getBodyText().addNewSection(), sr);
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
            int id = 1;
            Set<String> ss = cfr.listChildNames();
            Iterator<String> it = ss.iterator();
            while (it.hasNext()) {
                String name = it.next();
                BinDataCompress compressMethod = getCompressMethod(id);
                hwpFile.getBinData().addNewEmbeddedBinaryData(name, readEmbededBinaryData(name, compressMethod),
                        compressMethod);

                id++;
            }
            cfr.moveParentStorage();
        }
    }

    private BinDataCompress getCompressMethod(int id) {
        BinData binData;
        try {
            binData = hwpFile.getDocInfo().getBinDataList().get(id - 1);
        } catch (Exception e) {
            binData = null;
        }
        if (binData != null) {
            return binData.getProperty().getCompress();
        }
        return BinDataCompress.ByStroageDefault;
    }

    /**
     * BinData 스토리지 아래에 스트림을 읽는다.
     *
     * @param name  스트림 이름
     * @param index 스트림 인덱스
     * @return 스트림에 저장된 데이타
     * @throws Exception
     */
    private byte[] readEmbededBinaryData(String name, BinDataCompress compressMethod) throws Exception {
        StreamReader sr = cfr.getChildStreamReader(name, isCompressBinData(compressMethod), null);
        byte[] binaryData = new byte[(int) sr.getSize()];
        sr.readBytes(binaryData);
        sr.close();
        return binaryData;
    }

    /**
     * BinData의 압축 여부를 반환한다.
     *
     * @param compressMethod 압축 방법
     * @return BinData의 압축 여부
     */
    private boolean isCompressBinData(BinDataCompress compressMethod) {
        switch (compressMethod) {
            case ByStroageDefault:
                return isCompressed();
            case Compress:
                return true;
            case NoCompress:
                return false;
        }
        return false;
    }


    /**
     * 텍스트를 추출하기 위해 hwp 파일을 읽는다.
     *
     * @param filepath hwp파일의 경로
     * @param listener 텍스트 추출 리스너
     * @param tem      추출 방법
     *     @throws Exception
     */
    public static void forExtractText(String filepath, TextExtractorListener listener, TextExtractMethod tem) throws Exception {
        forExtractText(new FileInputStream(filepath), listener, tem);
    }

    /**
     * 텍스트를 추출하기 위해 hwp 파일을 읽는다.
     *
     * @param is hwp파일을 가리키는 Input Stream ㅒ객체
     * @param listener 텍스트 추출 리스너
     * @param tem      추출 방법
     * @throws Exception
     */
    private static void forExtractText(FileInputStream is, TextExtractorListener listener, TextExtractMethod tem) throws Exception {
        HWPReader r = new HWPReader();
        r.hwpFile = new HWPFile();
        r.cfr = new CompoundFileReader(is);

        r.fileHeader();
        if (r.hasPassword()) {
            throw new Exception("Files with passwords are not supported.");
        }
        r.docInfo();
        r.extractBodyText(listener, tem);

        r.cfr.close();
    }

    /**
     * 텍스트를 추출하기 위해 hwp 파일의 bodyText 부분을 읽는다.
     *
     * @param listener 텍스트 추출 리스너
     * @param tem      추출 방법
     * @throws Exception
     */
    private void extractBodyText(TextExtractorListener listener, TextExtractMethod tem) throws Exception {
        cfr.moveChildStorage("BodyText");
        int sectionCount = hwpFile.getDocInfo().getDocumentProperties().getSectionCount();
        for (int index = 0; index < sectionCount; index++) {
            extractSectionText(index, listener, tem);
        }
        cfr.moveParentStorage();
    }

    /**
     * 텍스트를 추출하기 위해 hwp 파일의 섹션 부분을 읽는다.
     *
     * @param sectionIndex 섹션 인덱스
     * @param listener 텍스트 추출 리스너
     * @param tem      추출 방법
     * @throws Exception
     */
    private void extractSectionText(int sectionIndex, TextExtractorListener listener, TextExtractMethod tem) throws Exception {
        StreamReader sr = cfr.getChildStreamReader("Section" + sectionIndex, isCompressed(), getVersion());
        sr.setDocInfo(hwpFile.getDocInfo());
        ForParagraphList.extractText(sr, listener, tem);
        sr.close();
    }
}

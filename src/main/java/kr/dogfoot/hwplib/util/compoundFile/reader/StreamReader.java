package kr.dogfoot.hwplib.util.compoundFile.reader;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.org.apache.poi.poifs.filesystem.DocumentEntry;
import kr.dogfoot.hwplib.org.apache.poi.poifs.filesystem.DocumentInputStream;
import kr.dogfoot.hwplib.util.binary.BitFlag;
import kr.dogfoot.hwplib.util.binary.Compressor;
import kr.dogfoot.hwplib.util.binary.Obfuscation;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;

/**
 * MS Compound 파일의 스트림을 읽기 위한 객체
 *
 * @author neolord
 */
public class StreamReader {
    public static StreamReader create(DocumentEntry de, boolean compress, boolean distribution, FileVersion fileVersion) throws Exception {
        InputStream is = documentInputStream(de, distribution);
        if (compress) {
            try {
                byte[] decompressed = Compressor.decompressedBytes(is);

                return new StreamReader().init(
                        fileVersion,
                        new ByteArrayInputStream(decompressed),
                        decompressed.length);
            } catch (Exception e) {
                return new StreamReader().init(
                        fileVersion,
                        is,
                        de.getSize());
            }
        } else {
            return new StreamReader().init(
                    fileVersion,
                    is,
                    de.getSize());
        }
    }

    private static InputStream documentInputStream(DocumentEntry de, boolean distribution) throws Exception {
        InputStream is = new DocumentInputStream(de);
        if (distribution) {
            return decryptStream(is);
        } else {
            return is;
        }
    }

    private static InputStream decryptStream(InputStream is)
            throws Exception {
        Key secretKey = secretKey(is);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new CipherInputStream(is, cipher);
    }


    private static Key secretKey(InputStream is) throws IOException {
        byte[] distributionDocumentData = readDistributionDocData(is);
        int offset = 4 + (distributionDocumentData[0] & 0xF);

        byte[] keyBytes = Arrays.copyOfRange(distributionDocumentData, offset, offset + 16);
        return new SecretKeySpec(keyBytes, "AES");
    }

    private static byte[] readDistributionDocData(InputStream is) throws IOException {
        byte[] header = new byte[4];
        is.read(header, 0, 4); // record header,

        byte[] body = new byte[256];
        is.read(body, 0, 256);
        Obfuscation.transform(body);
        return body;
    }

    /**
     * 스트림을 읽기 위한 InputStream
     */
    protected InputStream is;
    /**
     * 스트림 크기
     */
    protected long size;
    /**
     * 현재까지 읽은 byte 수.
     */
    private long read;

    /**
     * 한글 레코드 헤더
     */
    private RecordHeader header;
    /**
     * 헤더를 읽은 후부터 현재까지 읽은 byte 수
     */
    private long readAfterHeader;

    /**
     * 한글 파일 버전
     */
    protected FileVersion fileVersion;

    /**
     * 문서 정보를 나타내는 객체
     */
    private DocInfo docInfo;

    /**
     * 생성자
     */
    protected StreamReader() {
        size = 0;
        read = 0;
        header = new RecordHeader();
        readAfterHeader = 0;
        docInfo = null;
    }

    private StreamReader init(FileVersion fileVersion, InputStream is, int size) {
        this.fileVersion = fileVersion;
        this.is = is;
        this.size = size;
        return this;
    }

    public void readBytes(byte[] buffer) throws IOException {
        is.read(buffer);
        forwardPosition(buffer.length);
    }

    /**
     * 현재까지 읽은 byte 수, 헤더를 읽은 후부터 현재까지 읽은 byte 수의 값을 n만큼 추가한다.
     *
     * @param n byte 수
     */
    protected void forwardPosition(long n) {
        read += n;
        readAfterHeader += n;
    }

    public byte readSInt1() throws IOException {
        byte[] buffer = readBytes(1);
        return buffer[0];
    }

    /**
     * n byte를 읽어서 byte 배열을 반환한다.
     *
     * @param n 읽을 바이트 수
     * @return 새로 읽은 byte 배열
     * @throws IOException
     */
    private byte[] readBytes(int n) throws IOException {
        byte[] buffer = new byte[n];
        readBytes(buffer);
        return buffer;
    }

    public short readUInt1() throws IOException {
        byte[] buffer = readBytes(1);
        byte[] buffer2 = { buffer[0], 0} ;
        return ByteBuffer.wrap(buffer2).order(ByteOrder.LITTLE_ENDIAN).getShort();
    }

    public short readSInt2() throws IOException {
        byte[] buffer = readBytes(2);
        return ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN)
                .getShort();
    }

    public int readUInt2() throws IOException {
        byte[] buffer = readBytes(2);
        byte[] buffer2 = { buffer[0], buffer[1], 0, 0 };
        return ByteBuffer.wrap(buffer2).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public int readSInt4() throws IOException {
        byte[] buffer = readBytes(4);
        return ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public long readUInt4() throws IOException {
        byte[] buffer = readBytes(4);
        byte[] buffer2 = { buffer[0], buffer[1], buffer[2], buffer[3], 0, 0, 0, 0 };
        return ByteBuffer.wrap(buffer2).order(ByteOrder.LITTLE_ENDIAN).getLong();
    }

    public double readDouble() throws IOException {
        byte[] buffer = readBytes(8);
        return ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN)
                .getDouble();
    }

    public float readFloat() throws IOException {
        byte[] buffer = readBytes(4);
        return ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN)
                .getFloat();
    }

    public void skip(int n) throws IOException {
        readBytes(n);
    }

    /**
     * 스트림을 읽기 위한 객체를 닫는다.
     *
     * @throws IOException
     */
    public void close() throws IOException {
        is.close();
        is = null;
    }

    /**
     * 한글 레코드 헤더를 읽어서 반환한다.
     *
     * @return 한글 레코드 헤더
     * @throws IOException
     */
    public RecordHeader readRecordHeader() throws IOException {
        if (isEndOfStream()) {
            header.setTagID((short) 0);
            header.setLevel((short) 0);
            header.setSize((short) 0);
        } else {
            long value = readUInt4();
            header.setTagID((short) BitFlag.get(value, 0, 9));
            header.setLevel((short) BitFlag.get(value, 10, 19));
            header.setSize((short) BitFlag.get(value, 20, 31));
            if (header.getSize() == 4095) {
                header.setSize(readUInt4());
            }
        }
        readAfterHeader = 0;
        return header;
    }

    /**
     * 한글 문자열을 읽어서 반환한다. 한글 문자열은 2 byte의 문자열 길이가 저장된 부분 뒤에 UTF-16LE 형태의 byte로 된
     * 문자열 부분이 따른다.
     *
     * @return 문자열
     * @throws IOException
     */
    public String readUTF16LEString() throws IOException {
        int len = readUInt2();
        if (len > 0) {
            byte[] arr = new byte[len * 2];
            readBytes(arr);
            return new String(arr, 0, arr.length, StandardCharsets.UTF_16LE);
        } else {
            return null;
        }
    }

    public byte[] readHWPString() throws IOException {
        int len = readUInt2();
        if (len > 0) {
            byte[] arr = new byte[len * 2];
            readBytes(arr);
            return arr;
        } else {
            return null;
        }
    }

    public byte[] readWChar() throws IOException {
        byte[] arr = new byte[2];
        readBytes(arr);
        return arr;
    }

    /**
     * 스트림 크기를 반환한다.
     *
     * @return 스트림 크기
     */
    public long getSize() {
        return size;
    }

    /**
     * 스트림 상의 현재 위치를 반환한다.
     *
     * @return 스트림 상의 현재 위치
     */
    public long getCurrentPosition() {
        return read;
    }

    /**
     * 현재 위치가 스트림 끝인지 여부를 반환한다.
     *
     * @return 현재 위치가 스트림 끝인지 여부
     */
    public boolean isEndOfStream() {
        return read >= size;
    }

    /**
     * 현재 레코드 헤더를 반환한다.
     *
     * @return 현재 레코드 헤더
     */
    public RecordHeader getCurrentRecordHeader() {
        return header;
    }

    /**
     * 레코드 상의 현재 위치를 반환한다.
     *
     * @return 레코드 상의 현재 위치
     */
    public long getCurrentPositionAfterHeader() {
        return readAfterHeader;
    }

    /**
     * 한글 파일 버전을 반환한다.
     *
     * @return 한글 파일 버전
     */
    public FileVersion getFileVersion() {
        return fileVersion;
    }

    /**
     * 한글 파일 버전을 설정한다.
     *
     * @param fileVersion
     */
    public void setFileVersion(FileVersion fileVersion) {
        this.fileVersion = fileVersion;
    }

    /**
     * 현재 위치가 레코드 끝인지 여부를 반환한다.
     *
     * @return 현재 위치가 레코드 끝인지 여부
     */
    public boolean isEndOfRecord() {
        return readAfterHeader >= header.getSize();
    }

    /**
     * 레코드 헤더를 읽은 직후 인지 여부를 반환한다.
     *
     * @return 레코드 헤더를 읽은 직후 인지 여부
     */
    public boolean isImmediatelyAfterReadingHeader() {
        return (readAfterHeader == 0);
    }

    public void nextRecord() {
        readAfterHeader = -1;
    }

    /**
     * 레코드 끝까지 건너뛴다.
     *
     * @throws IOException
     */
    public void skipToEndRecord() throws IOException {
        long n = getCurrentRecordHeader().getSize()
                - getCurrentPositionAfterHeader();
        if (n > 0) {
            skip((int) n);
        }
    }

    public void setDocInfo(DocInfo docInfo) {
        this.docInfo = docInfo;
    }

    public int correctParaShapeId(int oldParaShapeId) {
        if (docInfo != null) {
            return oldParaShapeId - docInfo.getIDMappings().getParaShapeCount() + docInfo.getParaShapeList().size();
        } else {
            return oldParaShapeId;
        }
    }
}

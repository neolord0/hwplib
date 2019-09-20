package kr.dogfoot.hwplib.util.compoundFile.reader;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.util.binary.BitFlag;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * MS Compound 파일의 스트림을 읽기 위한 객체
 *
 * @author neolord
 */
public abstract class StreamReader {
    /**
     * 스트림 크기
     */
    private long size;
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
    private FileVersion fileVersion;

    /**
     * 문서 정보를 나타내는 객체
     */
    private DocInfo docInfo;

    /**
     * byte 배열의 크기 만큼 byte 배열을 읽은다.
     *
     * @param buffer byte 배열
     * @throws IOException
     */
    public abstract void readBytes(byte[] buffer) throws IOException;

    /**
     * signed 1 byte 정수값을 읽어서 반환한다.
     *
     * @return signed 1 byte 정수값
     * @throws IOException
     */
    public abstract byte readSInt1() throws IOException;

    /**
     * signed 2 byte 정수값을 읽어서 반환한다.
     *
     * @return signed 2 byte 정수값
     * @throws IOException
     */
    public abstract short readSInt2() throws IOException;

    /**
     * signed 4 byte 정수값을 읽어서 반환한다.
     *
     * @return signed 4 byte 정수값
     * @throws IOException
     */
    public abstract int readSInt4() throws IOException;

    /**
     * unsigned 1 byte 정수값을 읽어서 반환한다.
     *
     * @return unsigned 1 byte 정수값
     * @throws IOException
     */
    public abstract short readUInt1() throws IOException;

    /**
     * unsigned 2 byte 정수값을 읽어서 반환한다.
     *
     * @return unsigned 2 byte 정수값
     * @throws IOException
     */
    public abstract int readUInt2() throws IOException;

    /**
     * unsigned 4 byte 정수값을 읽어서 반환한다.
     *
     * @return unsigned 4 byte 정수값
     * @throws IOException
     */
    public abstract long readUInt4() throws IOException;

    /**
     * double 값을 읽어서 반환한다.
     *
     * @return double 값
     * @throws IOException
     */
    public abstract double readDouble() throws IOException;

    /**
     * float 값을 읽어서 반환한다.
     *
     * @return float 값
     * @throws IOException
     */
    public abstract float readFloat() throws IOException;

    /**
     * n 바이트 만큼 건너뛴다.
     *
     * @param n 건너뛸 바이트 수
     * @throws IOException
     */
    public abstract void skip(long n) throws IOException;

    /**
     * 스트림을 읽기 위한 객체를 닫는다.
     *
     * @throws IOException
     */
    public abstract void close() throws IOException;

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

    /**
     * 현재까지 읽은 byte 수, 헤더를 읽은 후부터 현재까지 읽은 byte 수의 값을 n만큼 추가한다.
     *
     * @param n byte 수
     */
    protected void forwardPosition(long n) {
        read += n;
        readAfterHeader += n;
    }

    /**
     * 한글 레코드 헤더를 읽어서 반환한다.
     *
     * @return 한글 레코드 헤더
     * @throws IOException
     */
    public RecordHeader readRecordHeder() throws IOException {
        long value = readUInt4();
        header.setTagID((short) BitFlag.get(value, 0, 9));
        header.setLevel((short) BitFlag.get(value, 10, 19));
        header.setSize((short) BitFlag.get(value, 20, 31));
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

    /**
     * 한 글자를 읽어서 반환한다.
     *
     * @return 한 글자
     * @throws IOException
     */
    public String readWChar() throws IOException {
        byte[] arr = new byte[2];
        readBytes(arr);
        return new String(arr, 0, 2, StandardCharsets.UTF_16LE);
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
     * 스트림 크기를 설정한다.
     *
     * @param size 스트림 크기
     */
    protected void setSize(long size) {
        this.size = size;
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

    /**
     * 레코드 끝까지 건너뛴다.
     *
     * @throws IOException
     */
    public void skipToEndRecord() throws IOException {
        long n = getCurrentRecordHeader().getSize()
                - getCurrentPositionAfterHeader();
        if (n > 0) {
            skip(n);
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

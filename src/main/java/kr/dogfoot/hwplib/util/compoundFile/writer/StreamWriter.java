package kr.dogfoot.hwplib.util.compoundFile.writer;

import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.etc.HWPString;
import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.util.binary.BitFlag;
import kr.dogfoot.hwplib.util.binary.Compressor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/**
 * MS Compound 파일의 스트림에 내용을 저장하기 위한 객체
 *
 * @author neolord
 */
public class StreamWriter {
    /**
     * 스트림(파일) 이름
     */
    private String name;
    /**
     * 압축 여부
     */
    protected boolean compress;
    /**
     * 한글 파일 버전
     */
    private FileVersion version;
    /**
     * 임시로 쓰여지 저장될 ByteArrayOutputStream 객체
     */
    protected ByteArrayOutputStream os;
    /**
     * 현재 레코드 레벨
     */
    private int currentRecordLevel;

    private DocInfo docInfo;

    /**
     * 생성자
     *
     * @param name     스트림(파일) 이름
     * @param compress 압축 여부
     * @param version  한글 파일 버전
     */
    public StreamWriter(String name, boolean compress, FileVersion version) {
        this.name = name;
        this.compress = compress;
        this.version = version;

        os = new ByteArrayOutputStream();
        currentRecordLevel = 0;

        docInfo = null;
    }

    /**
     * 스트림(파일)을 닫는다.
     *
     * @throws IOException
     */
    public void close() throws IOException {
        os.close();
    }

    /**
     * 스트림(파일) 이름을 반환한다.
     *
     * @return 스트림(파일) 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 한글 파일 버전을 반환한다.
     *
     * @return 한글 파일 버전
     */
    public FileVersion getFileVersion() {
        return version;
    }

    /**
     * 스트림(파일)에 저장된 데이터를 읽을 수 있는 InputStream을 반환한다.
     *
     * @return 스트림(파일)에 저장된 데이터를 읽을 수 있는 InputStream
     * @throws IOException
     */
    public InputStream getDataStream() throws IOException {
        byte[] bytes = null;

        if (compress == false) {
            bytes = os.toByteArray();
        } else {
            bytes = Compressor.compress(os.toByteArray());
        }

        return new ByteArrayInputStream(bytes);
    }

    /**
     * byte 배열을 스트림(파일)에 저장한다.
     *
     * @param value byte 배열
     * @throws IOException
     */
    public void writeBytes(byte[] value) throws IOException {
        os.write(value);
    }

    /**
     * byte 배열을 count에 맟춰 스트림(파일)에 저장한다.
     *
     * @param value byte 배열
     * @param count 출력할 개수
     * @throws IOException
     */
    public void writeBytes(byte[] value, int count) throws IOException {
        if (value.length == count) {
            os.write(value);
        } else if (value.length > count) {
            for (int i = 0; i < count; i++) {
                os.write(value[i]);
            }
        } else if (value.length < count) {
            os.write(value);
            writeZero(count - value.length);
        }
    }

    /**
     * 부호있는 1 byte 정수를 스트림(파일)에 저장한다.
     *
     * @param value 부호있는 1 byte 정수값
     * @throws IOException
     */
    public void writeSInt1(byte value) throws IOException {
        byte[] buffer = new byte[1];
        buffer[0] = value;
        writeBytes(buffer);
    }

    /**
     * 부호있는 2 byte 정수를 스트림(파일)에 저장한다.
     *
     * @param value 부호있는 2 byte 정수값
     * @throws IOException
     */
    public void writeSInt2(short value) throws IOException {
        byte[] buffer = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN)
                .putShort(value).array();
        writeBytes(buffer);
    }

    /**
     * 부호있는 4 byte 정수를 스트림(파일)에 저장한다.
     *
     * @param value 부호있는 4 byte 정수값
     * @throws IOException
     */
    public void writeSInt4(int value) throws IOException {
        byte[] buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)
                .putInt(value).array();
        writeBytes(buffer);
    }

    /**
     * 부호없는 1 byte 정수를 스트림(파일)에 저장한다.
     *
     * @param value 부호있는 1 byte 정수값
     * @throws IOException
     */
    public void writeUInt1(short value) throws IOException {
        byte[] buffer = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN)
                .putShort(value).array();
        os.write(buffer, 0, 1);
    }

    /**
     * 부호없는 2 byte 정수를 스트림(파일)에 저장한다.
     *
     * @param value 부호있는 1 byte 정수값
     * @throws IOException
     */
    public void writeUInt2(int value) throws IOException {
        byte[] buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)
                .putInt(value).array();
        os.write(buffer, 0, 2);
    }

    /**
     * 부호없는 4 byte 정수를 스트림(파일)에 저장한다.
     *
     * @param value 부호있는 1 byte 정수값
     * @throws IOException
     */
    public void writeUInt4(long value) throws IOException {
        byte[] buffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN)
                .putLong(value).array();
        os.write(buffer, 0, 4);
    }

    /**
     * 배정도 실수(double)를 스트림(파일)에 저장한다.
     *
     * @param value 배정도 실수(double)값
     * @throws IOException
     */
    public void writeDouble(double value) throws IOException {
        byte[] buffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN)
                .putDouble(value).array();
        os.write(buffer, 0, 8);
    }

    /**
     * 단정도 실수(float)를 스트림(파일)에 저장한다.
     *
     * @param value 단정도 실수(float)값
     * @throws IOException
     */
    public void writeFloat(float value) throws IOException {
        byte[] buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)
                .putFloat(value).array();
        os.write(buffer, 0, 4);
    }

    /**
     * 레코드 헤더를 스트림(파일)에 저장한다.
     *
     * @param tagID 레코드의 태그 아이디
     * @param size  레코드의 크기
     * @throws IOException
     */
    public void writeRecordHeader(int tagID, long size) throws IOException {
        long header = 0;
        header = BitFlag.set(header, 0, 9, tagID);
        header = BitFlag.set(header, 10, 19, currentRecordLevel);
        header = BitFlag.set(header, 20, 31, Math.min((int) size, 4095));
        writeUInt4(header);

        if (size >= 4095) {
            writeUInt4(size);
        }
    }

    /**
     * 문자열(UTF-16LE)을 스트림(파일)에 저장한다.
     *
     * @param value 문자열
     * @throws IOException
     */
    public void writeUTF16LEString(String value) throws IOException {
        if (value == null) {
            writeUInt2(0);
        } else {
            writeUInt2(value.length());
            if (value.length() > 0) {
                writeBytes(value.getBytes(StandardCharsets.UTF_16LE));
            }
        }
    }

    public void writeHWPString(HWPString value) throws IOException {
        if (value == null || value.getBytes() == null) {
            writeUInt2(0);
        } else {
            writeUInt2(value.getBytes().length / 2);
            if (value.getBytes().length > 0) {
                writeBytes(value.getBytes());
            }
        }
    }

    /**
     * 한 문자(UTF-16LE)을 스트림(파일)에 저장한다.
     *
     * @param value 한 문자
     * @throws IOException
     */
    /*
    public void writeWChar(String value) throws IOException {
        if (value != null && value.length() > 0) {
            byte[] buffer = value.getBytes(StandardCharsets.UTF_16LE);
            if (buffer != null && buffer.length >= 2) {
                os.write(buffer, 0, 2);
            } else {
                writeZero(2);
            }
        } else {
            writeZero(2);
        }
    }

     */
    public void writeWChar(byte[] value) throws IOException {
        if (value != null && value.length >= 2) {
            os.write(value, 0, 2);
        } else {
            writeZero(2);
        }
    }

    /**
     * 0값의 byte을 지장된 개수만큼 스트림(파일)에 저장한다.
     *
     * @param number 0값의 개수
     * @throws IOException
     */
    public void writeZero(int number) throws IOException {
        if (number > 0) {
            byte[] zero = new byte[number];
            os.write(zero);
        }
    }

    /**
     * 현제 레코드의 레벨을 한단계 높인다.
     */
    public void upRecordLevel() {
        currentRecordLevel++;
    }

    /**
     * 현제 레코드의 레벨을 한단계 낮춘다.
     */
    public void downRecordLevel() {
        currentRecordLevel--;
    }


    public void setDocInfo(DocInfo docInfo) {
        this.docInfo = docInfo;
    }

    public int correctParaShapeId(int oldParaShapeId) {
        if (docInfo != null) {
            return oldParaShapeId + docInfo.getIDMappings().getParaShapeCount() - docInfo.getParaShapeList().size();
        } else {
            return oldParaShapeId;
        }
    }
}

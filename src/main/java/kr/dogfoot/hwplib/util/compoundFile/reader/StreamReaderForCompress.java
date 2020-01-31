package kr.dogfoot.hwplib.util.compoundFile.reader;

import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.DocumentInputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * 압축된 스트림을 읽기 위한 객체
 *
 * @author neolord
 */
public class StreamReaderForCompress extends StreamReader {
    /**
     * 압축 풀린 데이터를 읽기 위한 InputStream
     */
    private ByteArrayInputStream bis;

    /**
     * 생성자. 압축된 스트림을 읽어 압축을 풀어서 압축 풀린 데이터로 InputStream을 만든다.
     *
     * @param de          스트림을 가리키는 Apache POI 객체
     * @param fileVersion
     * @throws Exception
     */
    public StreamReaderForCompress(DocumentEntry de, FileVersion fileVersion)
            throws Exception {
        setByteArrayInputStream(de);
        setFileVersion(fileVersion);
    }

    /**
     * 압축된 스트림을 읽어 압축을 풀어서 압축 풀린 데이터로 InputStream을 만든다.
     *
     * @param de 스트림을 가리키는 Apache POI 객체
     * @throws Exception
     */
    private void setByteArrayInputStream(DocumentEntry de) throws Exception {
        DocumentInputStream dis = new DocumentInputStream(de);
        byte[] compressed = getCompressedBytes(dis, de.getSize());
        dis.close();
        try {
            byte[] decompressed = decompress(compressed);

            bis = new ByteArrayInputStream(decompressed);
            setSize(decompressed.length);
        } catch (Exception e) {
            bis = new ByteArrayInputStream(compressed);
            setSize(compressed.length);
        }
    }

    /**
     * 스트림에서 압축된 데이터를 읽는다.
     *
     * @param dis  스트림을 읽기 위한 Apache POI InputStream 객체
     * @param size 읽을 크기
     * @return 압축된 데이터
     * @throws IOException
     */
    private byte[] getCompressedBytes(DocumentInputStream dis, int size)
            throws IOException {
        byte[] buffer = new byte[size];
        dis.read(buffer);
        return buffer;
    }

    /**
     * 압축된 데이터를 풀어서 원본 데이터를 얻는다.
     *
     * @param compressed 압축된 데이터
     * @return 원본 데이터
     * @throws DataFormatException
     * @throws IOException
     */
    private byte[] decompress(byte[] compressed) throws Exception {
        Inflater decompressor = new Inflater(true);
        decompressor.setInput(compressed, 0, compressed.length);
        ByteArrayOutputStream bos = new ByteArrayOutputStream(compressed.length);

        // Decompress the data
        byte[] buf = new byte[8096];
        while (!decompressor.finished()) {
            int count = decompressor.inflate(buf);
            if (count > 0) {
                bos.write(buf, 0, count);
            } else {
                throw new Exception("can't decompress data");
            }
        }
        bos.close();
        return bos.toByteArray();
    }

    @Override
    public void readBytes(byte[] buffer) throws IOException {
        forwardPosition(buffer.length);
        bis.read(buffer);
    }

    @Override
    public byte readSInt1() throws IOException {
        byte[] buffer = readBytes(1);
        return buffer[0];
    }

    /**
     * n byte를 읽어서 byte 배열ㄴ을 반환한다.
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

    @Override
    public short readSInt2() throws IOException {
        byte[] buffer = readBytes(2);
        return ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN)
                .getShort();
    }

    @Override
    public int readSInt4() throws IOException {
        byte[] buffer = readBytes(4);
        return ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    @Override
    public short readUInt1() throws IOException {
        return (short) (readSInt1() & 0xff);
    }

    @Override
    public int readUInt2() throws IOException {
        return readSInt2() & 0xffff;
    }

    @Override
    public long readUInt4() throws IOException {
        return readSInt4() & 0xffffffff;
    }

    @Override
    public double readDouble() throws IOException {
        byte[] buffer = readBytes(8);
        return ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN)
                .getDouble();
    }

    @Override
    public float readFloat() throws IOException {
        byte[] buffer = readBytes(4);
        return ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN)
                .getFloat();
    }

    @Override
    public void skip(long n) throws IOException {
        readBytes((int) n);
    }

    @Override
    public void close() throws IOException {
        bis.close();
        bis = null;
    }
}

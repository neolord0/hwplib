package kr.dogfoot.hwplib.util.compoundFile.writer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.Deflater;

import kr.dogfoot.hwplib.object.fileheader.FileVersion;
import kr.dogfoot.hwplib.util.binary.BitFlag;

public class StreamWriter {
	private String name;
	private boolean compreess;
	private FileVersion version;
	private ByteArrayOutputStream os;
	
	private int currentParagraphLevel;

	public StreamWriter(String name, boolean compress, FileVersion version) {
		this.name = name;
		this.compreess = compress;
		this.version = version;
		
		os = new ByteArrayOutputStream();
		currentParagraphLevel = 0;
	}
	
	public void close() throws IOException {
		os.close();
	}

	public String getName() {
		return name;
	}
	
	public FileVersion getFileVersion() {
		return version;
	}

	public InputStream getDataStream() throws IOException {
		byte[] bytes = null;
		if (compreess == false) {
			bytes = os.toByteArray();
		} else {
			bytes = compressBytes(os.toByteArray());
		}
		return new ByteArrayInputStream(bytes);
	}

	private byte[] compressBytes(byte[] original) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Deflater compresser = new Deflater(Deflater.DEFAULT_COMPRESSION, true);
		compresser.setInput(original);
		compresser.finish();
		byte[] buf = new byte[1024];
		while (!compresser.finished()) {
			int count = compresser.deflate(buf);
			bos.write(buf, 0, count);
		}
		int zero = 0;
		bos.write(zero);
		bos.write(original.length);
		return bos.toByteArray();
	}

	public void writeBytes(byte[] buffer) throws IOException {
		os.write(buffer);
	}

	public void writeSInt1(byte value) throws IOException {
		byte[] buffer = new byte[1];
		buffer[0] = value;
		writeBytes(buffer);
	}

	public void writeSInt2(short value) throws IOException {
		byte[] buffer = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN)
				.putShort(value).array();
		writeBytes(buffer);
	}

	public void writeSInt4(int value) throws IOException {
		byte[] buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)
				.putInt(value).array();
		writeBytes(buffer);
	}

	public void writeUInt1(short value) throws IOException {
		byte[] buffer = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN)
				.putShort(value).array();
		os.write(buffer, 0, 1);
	}

	public void writeUInt2(int value) throws IOException {
		byte[] buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)
				.putInt(value).array();
		os.write(buffer, 0, 2);
	}

	public void writeUInt4(long value) throws IOException {
		byte[] buffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN)
				.putLong(value).array();
		os.write(buffer, 0, 4);
	}

	public void writeDouble(double value) throws IOException {
		byte[] buffer = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN)
				.putDouble(value).array();
		os.write(buffer, 0, 8);
	}

	public void writeFloat(float value) throws IOException {
		byte[] buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)
				.putFloat(value).array();
		os.write(buffer, 0, 4);
	}

	public void writeRecordHeader(int tagID, int level, int size)
			throws IOException {
		long header = 0;
		header = BitFlag.set(header, 0, 9, tagID);
		header = BitFlag.set(header, 10, 19, level);
		header = BitFlag.set(header, 20, 31, Math.min(size, 4095));
		writeUInt4(header);
	}

	public void writeUTF16LEString(String value) throws IOException {
		writeUInt2((int) value.length());
		if (value.length() > 0) {
			writeBytes(value.getBytes("UTF-16LE"));
		}
	}

	public void writeWChar(String value) throws IOException {
		byte[] buffer = value.getBytes("UTF-16LE");
		if (buffer != null && buffer.length > 2) {
			os.write(buffer, 0, 2);
		}
	}

	public void writeZero(int number) throws IOException {
		byte[] zero = new byte[number];
		os.write(zero);
	}

	public int getCurrentParagraphLevel() {
		return currentParagraphLevel;
	}

	public void setCurrentParagraphLevel(int currentParagraphLevel) {
		this.currentParagraphLevel = currentParagraphLevel;
	}
}

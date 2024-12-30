package kr.dogfoot.hwplib.util.binary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class Compressor {
    public static byte[] compress(byte[] original) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Deflater compresser = new Deflater(Deflater.DEFAULT_COMPRESSION, true);
        compresser.setInput(original);
        compresser.finish();
        byte[] buf = new byte[1024];
        while (!compresser.finished()) {
            int count = compresser.deflate(buf);
            bos.write(buf, 0, count);
        }
        byte[] zero = new byte[4];
        bos.write(zero);
        byte[] length = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)
                .putInt(original.length).array();
        bos.write(length);
        return bos.toByteArray();
    }

    public static byte[] decompressedBytes(InputStream is) throws IOException {
        InputStream iis = new InflaterInputStream(is, new Inflater(true));
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];
        while ((nRead = iis.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer.toByteArray();
    }
}

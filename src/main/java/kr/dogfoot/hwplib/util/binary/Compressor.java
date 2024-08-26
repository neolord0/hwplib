package kr.dogfoot.hwplib.util.binary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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

    public static byte[] decompress(byte[] compressed) throws Exception {
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


}

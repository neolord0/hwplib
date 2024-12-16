package kr.dogfoot.hwplib.util.compoundFile.reader;

import kr.dogfoot.hwplib.org.apache.poi.util.LittleEndian;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ViewModeCrypto {
    // https://groups.google.com/forum/#!msg/hwp-foss/d2KL2ypR89Q/lCTkebPcIYYJ
    private static class SRand {
        private int random_seed;

        private SRand(int seed) {
            random_seed = seed;
        }

        private int rand() {
            random_seed = (random_seed * 214013 + 2531011) & 0xFFFFFFFF;
            return (random_seed >> 16) & 0x7FFF;
        }
    }

    public static Key readKey(InputStream input) throws IOException {
        byte[] data = new byte[260];

        input.read(data, 0, 4); // TAG,
        // HWPTAG_DISTRIBUTE_DOC_DATA 확인
        // long recordHeader = LittleEndian.getUInt(data);
        // log.debug("TAG:   {}", recordHeader & 0x3FF);
        // log.debug("LEVEL: {}", (recordHeader >> 10) & 0x3FF);
        // log.debug("SIZE:  {}", (recordHeader >> 20) & 0xFFF);

        // https://groups.google.com/forum/#!msg/hwp-foss/d2KL2ypR89Q/lCTkebPcIYYJ

        input.read(data, 0, 256);

        SRand srand = new SRand(LittleEndian.getInt(data));
        byte xor = 0;
        for (int i = 0, n = 0; i < 256; i++, n--) {
            if (n == 0) {
                xor = (byte) (srand.rand() & 0xFF);
                n = (int) ((srand.rand() & 0xF) + 1);
            }
            if (i >= 4) {
                data[i] = (byte) ((data[i]) ^ (xor));
            }
        }

        int offset = 4 + (data[0] & 0xF);
        byte[] key = Arrays.copyOfRange(data, offset, offset + 16);

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        return secretKey;
    }

    public static InputStream createDecryptStream(InputStream input, Key key)
            throws IOException, NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = null;

        cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key);

        return new CipherInputStream(input, cipher);
    }
}

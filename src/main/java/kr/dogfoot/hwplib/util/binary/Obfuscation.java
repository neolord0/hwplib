package kr.dogfoot.hwplib.util.binary;

import kr.dogfoot.hwplib.org.apache.poi.util.LittleEndian;

public class Obfuscation {
    public static void transform(byte[] data) {
        if (data == null || data.length != 256) return;

        byte[] seedByte = { data[0], data[1], data[2], data[3] };
        int seed = LittleEndian.getInt(seedByte);

        Obfuscation _this = new Obfuscation(seed);

        byte value = 0;
        int number = 0;

        for (int i = 0; i < data.length; i++) {
            if (number == 0) {
                value = _this.value();
                number = _this.number();
            }

            if (i >= 4) {
                data[i] = (byte) ((data[i]) ^ (value));
            }

            number--;
        }
    }

    private int random_seed;

    private Obfuscation(int seed) {
        random_seed = seed;
    }

    private int rand() {
        random_seed = (random_seed * 214013 + 2531011) & 0xFFFFFFFF;
        return (random_seed >> 16) & 0x7FFF;
    }

    private byte value() {
        return (byte) (rand() & 0xFF);
    }

    private int number() {
        return (rand() & 0xF) + 1;
    }
}

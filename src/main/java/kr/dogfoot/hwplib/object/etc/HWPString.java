package kr.dogfoot.hwplib.object.etc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class HWPString {
    byte[] bytes;

    public HWPString() {
        bytes = null;
    }

    public HWPString(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String toUTF16LEString() {
        return new String(bytes, StandardCharsets.UTF_16LE);
    }

    public void fromUTF16LEString(String utf16LE) {
        if (utf16LE != null && utf16LE.length() > 0) {
            bytes = utf16LE.getBytes(StandardCharsets.UTF_16LE);
        }
    }

    public HWPString clone() {
        HWPString cloned = new HWPString();
        cloned.copy(this);
        return cloned;
    }

    public void copy(HWPString from) {
        bytes = from.bytes;
    }

    public int getWCharsSize() {
        if (bytes != null) {
            return 2 + bytes.length;
        }
        return 2;
    }

    public boolean equals(HWPString other) {
        return Arrays.equals(bytes, other.bytes);
    }
}

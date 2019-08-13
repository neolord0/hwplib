package kr.dogfoot.hwplib.reader.docinfo;

import kr.dogfoot.hwplib.object.docinfo.BinData;
import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataType;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 바이너리 데이타 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForBinData {
    /**
     * 바이너리 데이타 레코드를 읽는다.
     *
     * @param bd 바이너리 데이타 레코드
     * @param sr 스트림 리더
     * @throws IOException
     */
    public static void read(BinData bd, StreamReader sr)
            throws IOException {
        bd.getProperty().setValue(sr.readUInt2());
        if (bd.getProperty().getType() == BinDataType.Link) {
            bd.setAbsolutePathForLink(sr.readUTF16LEString());
            bd.setRelativePathForLink(sr.readUTF16LEString());
        }

        if (bd.getProperty().getType() == BinDataType.Embedding
                || bd.getProperty().getType() == BinDataType.Storage) {
            bd.setBinDataID(sr.readUInt2());
            bd.setExtensionForEmbedding(sr.readUTF16LEString());
        }
    }
}

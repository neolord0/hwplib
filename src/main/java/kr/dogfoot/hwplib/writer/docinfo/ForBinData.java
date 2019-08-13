package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.BinData;
import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataType;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.StringUtil;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

/**
 * 바이너리 데이타 레코드를 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForBinData {
    /**
     * 바이너리 데이타 레코드를 쓴다.
     *
     * @param bd 바이너리 데이타 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    public static void write(BinData bd, StreamWriter sw) throws IOException {
        recordHeader(bd, sw);

        sw.writeUInt2(bd.getProperty().getValue());
        if (bd.getProperty().getType() == BinDataType.Link) {
            sw.writeUTF16LEString(bd.getAbsolutePathForLink());
            sw.writeUTF16LEString(bd.getRelativePathForLink());
        }
        if (bd.getProperty().getType() == BinDataType.Embedding
                || bd.getProperty().getType() == BinDataType.Storage) {
            sw.writeUInt2(bd.getBinDataID());
            sw.writeUTF16LEString(bd.getExtensionForEmbedding());
        }
    }

    /**
     * 바이너리 데이타 레코드의 레코드 헤더를 쓴다.
     *
     * @param bd 바이너리 데이타 레코드
     * @param sw 스트림 라이터
     * @throws IOException
     */
    private static void recordHeader(BinData bd, StreamWriter sw)
            throws IOException {
        sw.writeRecordHeader(HWPTag.BIN_DATA, getSize(bd));
    }

    /**
     * 바이너리 데이타 레코드의 크기를 반환한다.
     *
     * @param bd 바이너리 데이타 레코드
     * @return 바이너리 데이타 레코드의 크기
     */
    private static int getSize(BinData bd) {
        int size = 0;
        size += 2;
        if (bd.getProperty().getType() == BinDataType.Link) {
            size += StringUtil
                    .getUTF16LEStringSize(bd.getAbsolutePathForLink());
            size += StringUtil
                    .getUTF16LEStringSize(bd.getRelativePathForLink());
        }
        if (bd.getProperty().getType() == BinDataType.Embedding
                || bd.getProperty().getType() == BinDataType.Storage) {
            size += 2;
            size += StringUtil.getUTF16LEStringSize(bd
                    .getExtensionForEmbedding());
        }
        return size;
    }
}

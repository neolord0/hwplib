package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.MemoShape;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

public class ForMemoShape {
    public static void write(MemoShape ms, StreamWriter sw) throws IOException {
        recordHeader(ms, sw);

        sw.writeUInt4(ms.getWidth());
        sw.writeSInt1(ms.getLineType().getValue());
        sw.writeSInt1(ms.getLineWidth().getValue());
        sw.writeUInt4(ms.getLineColor().getValue());
        sw.writeUInt4(ms.getFillColor().getValue());
        sw.writeUInt4(ms.getActiveColor().getValue());
        sw.writeUInt4(ms.getUnknown());
    }

    private static void recordHeader(MemoShape ms, StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.MEMO_SHAPE, 22);
    }
}

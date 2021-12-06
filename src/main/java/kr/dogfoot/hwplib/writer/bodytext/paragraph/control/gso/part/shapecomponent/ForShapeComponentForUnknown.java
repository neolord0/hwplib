package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.shapecomponent;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentUnknown;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

public class ForShapeComponentForUnknown {
    public static void write(ShapeComponentUnknown scu, StreamWriter sw) throws IOException {
        recordHeader(scu, sw);

        gsoCtrlId(scu, sw);

        sw.writeBytes(scu.getUnknown());
    }

    private static void recordHeader(ShapeComponentUnknown scu, StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT, getSize(scu));
    }

    private static long getSize(ShapeComponentUnknown scu) {
        return scu.getUnknown().length + 8;
    }

    private static void gsoCtrlId(ShapeComponentUnknown scu, StreamWriter sw) throws IOException {
        sw.writeUInt4(scu.getGsoId());
        sw.writeUInt4(scu.getGsoId());
    }

}


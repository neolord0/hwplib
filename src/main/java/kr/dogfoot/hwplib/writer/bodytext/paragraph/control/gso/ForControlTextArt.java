package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlTextArt;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentTextArt;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;

import java.io.IOException;

public class ForControlTextArt {
    public static void writeRest(ControlTextArt textArt, StreamWriter sw) throws IOException {
        sw.upRecordLevel();

        shapeComponentTextArt(textArt.getShapeComponentTextArt(), sw);

        sw.downRecordLevel();
    }

    private static void shapeComponentTextArt(ShapeComponentTextArt scta, StreamWriter sw) throws IOException {
        recordHeader(scta, sw);

        sw.writeBytes(scta.getUnknown());
    }

    private static void recordHeader(ShapeComponentTextArt scta, StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT_TEXTART, scta.getUnknown().length);
    }
}

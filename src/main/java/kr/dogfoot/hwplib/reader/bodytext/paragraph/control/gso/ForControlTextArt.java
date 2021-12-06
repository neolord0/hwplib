package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlTextArt;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentTextArt;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

public class ForControlTextArt {

    public static void readRest(ControlTextArt textArt, StreamReader sr) throws IOException {
        RecordHeader rh = sr.readRecordHeder();
        if (rh.getTagID() == HWPTag.SHAPE_COMPONENT_TEXTART) {
            shapeComponentTextArt(textArt.getShapeComponentTextArt(), sr);
        }
    }

    private static void shapeComponentTextArt(ShapeComponentTextArt scta, StreamReader sr) throws IOException {
        byte[] unknown = new byte[(int) sr.getCurrentRecordHeader().getSize()];
        sr.readBytes(unknown);

        scta.setUnknown(unknown);
    }
}

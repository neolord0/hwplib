package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlTextArt;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentTextArt;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;
import kr.dogfoot.hwplib.object.docinfo.facename.FontType;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

public class ForControlTextArt {

    public static void readRest(ControlTextArt textArt, StreamReader sr) throws IOException {
        RecordHeader rh = sr.readRecordHeader();
        if (rh.getTagID() == HWPTag.SHAPE_COMPONENT_TEXTART) {
            shapeComponentTextArt(textArt.getShapeComponentTextArt(), sr);
        }
    }

    private static void shapeComponentTextArt(ShapeComponentTextArt scta, StreamReader sr) throws IOException {
        scta.setX1(sr.readSInt4());
        scta.setY1(sr.readSInt4());
        scta.setX2(sr.readSInt4());
        scta.setY2(sr.readSInt4());
        scta.setX3(sr.readSInt4());
        scta.setY3(sr.readSInt4());
        scta.setX4(sr.readSInt4());
        scta.setY4(sr.readSInt4());
        scta.getContent().setBytes(sr.readHWPString());
        scta.getFontName().setBytes(sr.readHWPString());
        scta.getFontStyle().setBytes(sr.readHWPString());
        scta.setFontType(FontType.valueOf((byte) sr.readSInt4()));
        scta.setTextArtShape(sr.readSInt4());
        scta.setLineSpace(sr.readSInt4());
        scta.setCharSpace(sr.readSInt4());
        scta.setParaAlignment(sr.readSInt4());
        scta.setShadowType(sr.readSInt4());
        scta.setShadowOffsetX(sr.readSInt4());
        scta.setShadowOffsetY(sr.readSInt4());
        scta.getShadowColor().setValue(sr.readUInt4());

        int outlinePointCount = sr.readSInt4();
        for (int index = 0; index < outlinePointCount; index++) {
            PositionXY positionXY = new PositionXY();
            positionXY.setX(sr.readSInt4());
            positionXY.setY(sr.readSInt4());

            scta.getOutlinePointList().add(positionXY);
        }
    }
}

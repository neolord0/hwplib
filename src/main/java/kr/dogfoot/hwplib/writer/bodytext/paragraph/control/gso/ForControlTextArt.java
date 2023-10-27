package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlTextArt;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentTextArt;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;
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
        sw.writeSInt4(scta.getX1());
        sw.writeSInt4(scta.getY1());
        sw.writeSInt4(scta.getX2());
        sw.writeSInt4(scta.getY2());
        sw.writeSInt4(scta.getX3());
        sw.writeSInt4(scta.getY3());
        sw.writeSInt4(scta.getX4());
        sw.writeSInt4(scta.getY4());
        sw.writeHWPString(scta.getContent());
        sw.writeHWPString(scta.getFontName());
        sw.writeHWPString(scta.getFontStyle());
        sw.writeSInt4(scta.getFontType().getValue());
        sw.writeSInt4(scta.getTextArtShape().getValue());
        sw.writeSInt4(scta.getLineSpace());
        sw.writeSInt4(scta.getCharSpace());
        sw.writeSInt4(scta.getParaAlignment().getValue());
        sw.writeSInt4(scta.getShadowType());
        sw.writeSInt4(scta.getShadowOffsetX());
        sw.writeSInt4(scta.getShadowOffsetY());
        sw.writeUInt4(scta.getShadowColor().getValue());
        sw.writeSInt4(scta.getOutlinePointList().size());
        for (PositionXY positionXY : scta.getOutlinePointList()) {
            sw.writeUInt4(positionXY.getX());
            sw.writeUInt4(positionXY.getY());
        }
    }

    private static void recordHeader(ShapeComponentTextArt scta, StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.SHAPE_COMPONENT_TEXTART, getSize(scta));
    }

    private static long getSize(ShapeComponentTextArt scta) {
        int size = 0;
        size += 32;
        size += scta.getContent().getWCharsSize();
        size += scta.getFontName().getWCharsSize();
        size += scta.getFontStyle().getWCharsSize();
        size += 40;
        size += scta.getOutlinePointList().size() * 8;
        return size;
    }
}


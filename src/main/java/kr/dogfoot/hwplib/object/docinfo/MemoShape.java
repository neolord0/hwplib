package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderThickness;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;
import kr.dogfoot.hwplib.object.etc.Color4Byte;

public class MemoShape {
    private long width;
    private BorderType lineType;
    private BorderThickness lineWidth;
    private Color4Byte lineColor;
    private Color4Byte fillColor;
    private Color4Byte activeColor;
    private long unknown;

    public MemoShape() {
        lineType = BorderType.None;
        lineWidth = BorderThickness.MM0_1;
        lineColor = new Color4Byte();
        fillColor = new Color4Byte();
        activeColor = new Color4Byte();
        unknown = 0;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public BorderType getLineType() {
        return lineType;
    }

    public void setLineType(BorderType lineType) {
        this.lineType = lineType;
    }

    public BorderThickness getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(BorderThickness lineWidth) {
        this.lineWidth = lineWidth;
    }

    public Color4Byte getLineColor() {
        return lineColor;
    }

    public Color4Byte getFillColor() {
        return fillColor;
    }

    public Color4Byte getActiveColor() {
        return activeColor;
    }

    public long getUnknown() {
        return unknown;
    }

    public void setUnknown(long unknown) {
        this.unknown = unknown;
    }

    public MemoShape clone() {
        MemoShape cloned = new MemoShape();
        cloned.width = this.width;
        cloned.lineType = this.lineType;
        cloned.lineWidth = this.lineWidth;
        cloned.lineColor.copy(this.lineColor);
        cloned.fillColor.copy(this.fillColor);
        cloned.activeColor.copy(this.activeColor);
        cloned.unknown = this.unknown;
        return cloned;
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

public class ShapeComponentTextArt {
    /**
     * 알 수 없는 데이터
     */
    private byte[] unknown;

    public ShapeComponentTextArt() {
    }

    public byte[] getUnknown() {
        return unknown;
    }

    public void setUnknown(byte[] unknown) {
        this.unknown = unknown;
    }

    public void copy(ShapeComponentTextArt from) {
        if (from.unknown != null) {
            unknown = from.unknown.clone();
        } else {
            unknown = null;
        }
    }
}

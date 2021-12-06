package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponent;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentTextArt;

public class ShapeComponentUnknown extends ShapeComponent {
    /**
     * 알 수 없는 데이터
     */
    private byte[] unknown;

    public ShapeComponentUnknown() {
    }


    public byte[] getUnknown() {
        return unknown;
    }

    public void setUnknown(byte[] unknown) {
        this.unknown = unknown;
    }

    public void copy(ShapeComponent from) {
        setGsoId(from.getGsoId());
        ShapeComponentUnknown from2 = (ShapeComponentUnknown) from;

        if (from2.unknown != null) {
            unknown = from2.unknown.clone();
        } else {
            unknown = null;
        }
    }
}

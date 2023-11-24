package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;

public class ControlUnknown extends GsoControl {
    /**
     * 생성자
     */
    public ControlUnknown() {
        this(new CtrlHeaderGso());
    }

    public ControlUnknown(CtrlHeaderGso header) {
        super(header);
        setGsoId(GsoControlType.Unknown.getId());
    }

    @Override
    public Control clone() {
        ControlUnknown cloned = new ControlUnknown();
        cloned.copyGsoControlPart(this);
        return cloned;
    }
}

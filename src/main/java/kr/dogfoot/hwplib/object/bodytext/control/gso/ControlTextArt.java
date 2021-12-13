package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentTextArt;

/**
 * 글맵시 컨트롤
 */
public class ControlTextArt extends GsoControl {
    /**
     * 글맵시 개체 속성
     */
    private ShapeComponentTextArt shapeComponentTextArt;

    /**
     * 생성자
     */
    public ControlTextArt() {
        this(new CtrlHeaderGso());
    }

    /**
     * 생성자
     *
     * @param header 그리기 개체를 위한 컨트롤 헤더
     */
    public ControlTextArt(CtrlHeaderGso header) {
        super(header);
        setGsoId(GsoControlType.TextArt.getId());
        shapeComponentTextArt = new ShapeComponentTextArt();
    }

    public ShapeComponentTextArt getShapeComponentTextArt() {
        return shapeComponentTextArt;
    }

    @Override
    public Control clone() {
        ControlTextArt cloned = new ControlTextArt();
        cloned.copyGsoControlPart(this);

        cloned.shapeComponentTextArt.copy(shapeComponentTextArt);

        return cloned;
    }
}

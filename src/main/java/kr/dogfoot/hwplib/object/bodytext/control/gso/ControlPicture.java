package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentPicture;

/**
 * 그림 개체 컨트롤
 *
 * @author neolord
 */
public class ControlPicture extends GsoControl {
    /**
     * 그림 개체 속성
     */
    private ShapeComponentPicture shapeComponentPicture;

    /**
     * 생성자
     */
    public ControlPicture() {
        this(new CtrlHeaderGso());
    }

    /**
     * 생성자
     *
     * @param header 그리기 개체를 위한 컨트롤 헤더
     */
    public ControlPicture(CtrlHeaderGso header) {
        super(header);
        setGsoId(GsoControlType.Picture.getId());

        shapeComponentPicture = new ShapeComponentPicture();
    }

    /**
     * 그림 개체의 속성 객체를 반환한다.
     *
     * @return 그림 개체의 속성 객체
     */
    public ShapeComponentPicture getShapeComponentPicture() {
        return shapeComponentPicture;
    }

    @Override
    public Control clone() {
        ControlPicture cloned = new ControlPicture();
        cloned.copyGsoControlPart(this);
        cloned.shapeComponentPicture.copy(shapeComponentPicture);
        return cloned;
    }
}

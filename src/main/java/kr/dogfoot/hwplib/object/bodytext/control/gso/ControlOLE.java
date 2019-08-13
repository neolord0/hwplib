package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentOLE;

/**
 * OLE 개체 컨트롤
 *
 * @author neolord
 */
public class ControlOLE extends GsoControl {
    /**
     * OLE 개체 속성
     */
    private ShapeComponentOLE shapeComponentOLE;

    /**
     * 생성자
     */
    public ControlOLE() {
        this(new CtrlHeaderGso());
    }

    /**
     * 생성자
     *
     * @param header 그리기 개체를 위한 컨트롤 헤더
     */
    public ControlOLE(CtrlHeaderGso header) {
        super(header);
        setGsoId(GsoControlType.OLE.getId());

        shapeComponentOLE = new ShapeComponentOLE();
    }

    /**
     * OLE 개체의 속성 객체을 반환한다.
     *
     * @return OLE 개체의 속성 객체
     */
    public ShapeComponentOLE getShapeComponentOLE() {
        return shapeComponentOLE;
    }
}

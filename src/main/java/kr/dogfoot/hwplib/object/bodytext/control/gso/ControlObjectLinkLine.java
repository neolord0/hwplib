package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentLineForObjectLinkLine;

/**
 * 객체 연결선 컨트롤
 *
 * @author neolord
 */
public class ControlObjectLinkLine extends GsoControl {
    /**
     * 선 개체 속성
     */
    private ShapeComponentLineForObjectLinkLine shapeComponentLine;

    /**
     * 생성자
     */
    public ControlObjectLinkLine() {
        this(new CtrlHeaderGso());
    }

    /**
     * 생성자
     *
     * @param header 그리기 개체를 위한 컨트롤 헤더
     */
    public ControlObjectLinkLine(CtrlHeaderGso header) {
        super(header);
        setGsoId(GsoControlType.ObjectLinkLine.getId());

        shapeComponentLine = new ShapeComponentLineForObjectLinkLine();
    }

    /**
     * 선 개체의 속성 객체를 반환한다.
     *
     * @return 선 개체의 속성 객체
     */
    public ShapeComponentLineForObjectLinkLine getShapeComponentLine() {
        return shapeComponentLine;
    }

    @Override
    public Control clone() {
        ControlObjectLinkLine cloned =  new ControlObjectLinkLine();
        cloned.copyGsoControlPart(this);
        cloned.shapeComponentLine.copy(shapeComponentLine);
        return cloned;
    }
}

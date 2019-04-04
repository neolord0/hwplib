package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentLine;

/**
 * 선 개체 컨트롤
 *
 * @author neolord
 */
public class ControlLine extends GsoControl {
    /**
     * 선 개체 속성
     */
    private ShapeComponentLine shapeComponentLine;

    /**
     * 생성자
     */
    public ControlLine() {
        this(new CtrlHeaderGso());
    }

    /**
     * 생성자
     *
     * @param header 그리기 개체를 위한 컨트롤 헤더
     */
    public ControlLine(CtrlHeaderGso header) {
        super(header);
        setGsoId(GsoControlType.Line.getId());

        shapeComponentLine = new ShapeComponentLine();
    }

    /**
     * 선 개체의 속성 객체를 반환한다.
     *
     * @return 선 개체의 속성 객체
     */
    public ShapeComponentLine getShapeComponentLine() {
        return shapeComponentLine;
    }
}

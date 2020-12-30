package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentPolygon;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;

/**
 * 다각형 개체 컨트롤
 *
 * @author neolord
 */
public class ControlPolygon extends GsoControl {
    /**
     * 글상자
     */
    private TextBox textBox;
    /**
     * 다각형 개체 속성
     */
    private ShapeComponentPolygon shapeComponentPolygon;

    /**
     * 생성자
     */
    public ControlPolygon() {
        this(new CtrlHeaderGso());
    }

    /**
     * 생성자
     *
     * @param header 그리기 개체를 위한 컨트롤 헤더
     */
    public ControlPolygon(CtrlHeaderGso header) {
        super(header);
        setGsoId(GsoControlType.Polygon.getId());

        textBox = null;
        shapeComponentPolygon = new ShapeComponentPolygon();
    }

    /**
     * 글상자 객체를 생성한다.
     */
    public void createTextBox() {
        textBox = new TextBox();
    }

    /**
     * 글상자 객체를 삭제한다.
     */
    public void deleteTextBox() {
        textBox = null;
    }

    /**
     * 글상자 객체를 반환한다.
     *
     * @return 글상자 객체
     */
    public TextBox getTextBox() {
        return textBox;
    }

    /**
     * 다각형 개체의 속성 객체를 반환한다.
     *
     * @return 다각형 개체의 속성 객체
     */
    public ShapeComponentPolygon getShapeComponentPolygon() {
        return shapeComponentPolygon;
    }

    @Override
    public Control clone() {
        ControlPolygon cloned = new ControlPolygon();
        cloned.copyGsoControlPart(cloned);

        if (textBox != null) {
            cloned.createTextBox();
            cloned.textBox.copy(textBox);
        }

        cloned.shapeComponentPolygon.copy(shapeComponentPolygon);
        return cloned;
    }
}

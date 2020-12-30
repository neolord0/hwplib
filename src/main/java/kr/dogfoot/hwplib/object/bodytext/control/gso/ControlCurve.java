package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentCurve;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;

/**
 * 곡선 개체 컨트롤
 *
 * @author neolord
 */
public class ControlCurve extends GsoControl {
    /**
     * 글상자
     */
    private TextBox textBox;
    /**
     * 곡선 개체 속성
     */
    private ShapeComponentCurve shapeComponentCurve;

    /**
     * 생성자
     */
    public ControlCurve() {
        this(new CtrlHeaderGso());
    }

    /**
     * 생성자
     *
     * @param header 그리기 개체를 위한 컨트롤 헤더
     */
    public ControlCurve(CtrlHeaderGso header) {
        super(header);
        setGsoId(GsoControlType.Curve.getId());

        textBox = null;
        shapeComponentCurve = new ShapeComponentCurve();
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
     * 곡선 개체의 속성 객체를 반환한다.
     *
     * @return 곡선 개체의 속성 객체
     */
    public ShapeComponentCurve getShapeComponentCurve() {
        return shapeComponentCurve;
    }

    @Override
    public Control clone() {
        ControlCurve cloned = new ControlCurve();
        cloned.copyGsoControlPart(this);

        if (textBox != null) {
            cloned.createTextBox();
            cloned.textBox.copy(textBox);
        }

        cloned.shapeComponentCurve.copy(shapeComponentCurve);
        return cloned;
    }
}

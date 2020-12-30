package kr.dogfoot.hwplib.object.bodytext.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentEllipse;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;

/**
 * 타원 개체 컨트롤
 *
 * @author neolord
 */
public class ControlEllipse extends GsoControl {
    /**
     * 글상자
     */
    private TextBox textBox;
    /**
     * 타원 개체 속성
     */
    private ShapeComponentEllipse shapeComponentEllipse;

    /**
     * 생성자
     */
    public ControlEllipse() {
        this(new CtrlHeaderGso());
    }

    /**
     * 생성자
     *
     * @param header 그리기 개체를 위한 컨트롤 헤더
     */
    public ControlEllipse(CtrlHeaderGso header) {
        super(header);
        setGsoId(GsoControlType.Ellipse.getId());

        textBox = null;
        shapeComponentEllipse = new ShapeComponentEllipse();
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
     * 타원 개체의 속성 객체을 반환한다.
     *
     * @return 타원 개체의 속성 객체
     */
    public ShapeComponentEllipse getShapeComponentEllipse() {
        return shapeComponentEllipse;
    }

    @Override
    public Control clone() {
        ControlEllipse cloned = new ControlEllipse();
        cloned.copyGsoControlPart(this);

        if (textBox != null) {
            cloned.createTextBox();
            cloned.textBox.copy(textBox);
        }

        cloned.shapeComponentEllipse.copy(shapeComponentEllipse);
        return cloned;
    }
}

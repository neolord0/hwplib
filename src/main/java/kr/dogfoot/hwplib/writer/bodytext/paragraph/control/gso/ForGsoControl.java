package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso;

import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentContainer;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentNormal;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.ForCaption;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.ForCtrlHeaderGso;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.shapecomponent.ForShapeComponentForContainer;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.shapecomponent.ForShapeComponentForNormal;

import java.io.IOException;

/**
 * 그리기 개체 컨트롤을 쓰기 위한 객체
 *
 * @author neolord
 */
public class ForGsoControl {
    /**
     * 그리기 개체 컨트롤을 쓴다.
     *
     * @param gso 그리기 개체 컨트롤
     * @param sw  스트림 라이터
     * @throws Exception
     */
    public static void write(GsoControl gso, StreamWriter sw) throws Exception {
        ForCtrlHeaderGso.write(gso.getHeader(), sw);

        sw.upRecordLevel();

        ForCaption.write(gso.getCaption(), sw);
        shapeComponent(gso, sw);
        restPart(gso, sw);

        sw.downRecordLevel();
    }

    /**
     * 그리기 개체 컨트롤의 객체 공통 속성 레코드을 쓴다.
     *
     * @param gso 그리기 개체 컨트롤
     * @param sw  스트림 라이터
     * @throws IOException
     */
    private static void shapeComponent(GsoControl gso, StreamWriter sw)
            throws IOException {
        if (gso.getGsoType() == GsoControlType.Container) {
            ForShapeComponentForContainer.write(
                    (ShapeComponentContainer) gso.getShapeComponent(), sw);
        } else {
            ForShapeComponentForNormal.write(
                    (ShapeComponentNormal) gso.getShapeComponent(), sw);
        }
    }

    /**
     * 그리기 개체 컨트롤의 나머지 부분을 쓴다.
     *
     * @param gso 그리기 개체 컨트롤
     * @param sw  스트림 라이터
     * @throws Exception
     */
    private static void restPart(GsoControl gso, StreamWriter sw)
            throws Exception {
        switch (gso.getGsoType()) {
            case Line:
                ForControlLine.writeRest((ControlLine) gso, sw);
                break;
            case Rectangle:
                ForControlRectangle.writeRest((ControlRectangle) gso, sw);
                break;
            case Ellipse:
                ForControlEllipse.writeRest((ControlEllipse) gso, sw);
                break;
            case Arc:
                ForControlArc.writeRest((ControlArc) gso, sw);
                break;
            case Polygon:
                ForControlPolygon.writeRest((ControlPolygon) gso, sw);
                break;
            case Curve:
                ForControlCurve.writeRest((ControlCurve) gso, sw);
                break;
            case Picture:
                ForControlPicture.writeRest((ControlPicture) gso, sw);
                break;
            case OLE:
                ForControlOLE.writeRest((ControlOLE) gso, sw);
                break;
            case Container:
                ForControlContainer.writeRest((ControlContainer) gso, sw);
                break;
            case ObjectLinkLine:
                ForControlObjectLinkLine.writeRest((ControlObjectLinkLine) gso, sw);
                break;
        }
    }

    /**
     * 묶음 컨트롤 안에 있는 컨트롤을 쓴다.
     *
     * @param child 묶음 컨트롤 안에 있는 컨트롤
     * @param sw    스트림 라이터
     * @throws Exception
     */
    public static void writeInContainer(GsoControl child, StreamWriter sw)
            throws Exception {
        sw.upRecordLevel();

        shapeComponentInContainer(child, sw);
        restPart(child, sw);

        sw.downRecordLevel();
    }

    /**
     * 묶음 컨트롤 안에 있는 컨트롤의 객체 공통 속성 레코드을 쓴다.
     *
     * @param child 묶음 컨트롤 안에 있는 컨트롤
     * @param sw    스트림 라이터
     * @throws IOException
     */
    private static void shapeComponentInContainer(GsoControl child,
                                                  StreamWriter sw) throws IOException {
        if (child.getGsoType() == GsoControlType.Container) {
            ForShapeComponentForContainer.writeInContainer(
                    (ShapeComponentContainer) child.getShapeComponent(), sw);
        } else {
            ForShapeComponentForNormal.writeInContainer(
                    (ShapeComponentNormal) child.getShapeComponent(), sw);
        }
    }
}

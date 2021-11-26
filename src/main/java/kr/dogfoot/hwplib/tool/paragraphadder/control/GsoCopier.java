package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture.InnerMargin;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture.PictureEffect;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.ListHeaderForTextBox;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphCopier;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class GsoCopier {
    public static void copy(GsoControl source, GsoControl target, DocInfoAdder docInfoAdder) {
        GsoCommonPartCopier.copy(source, target, docInfoAdder);
        switch (source.getGsoType()) {
            case Line:
                line((ControlLine) source, (ControlLine) target, docInfoAdder);
                break;
            case Rectangle:
                rectangle((ControlRectangle) source, (ControlRectangle) target, docInfoAdder);
                break;
            case Ellipse:
                ellipse((ControlEllipse) source, (ControlEllipse) target, docInfoAdder);
                break;
            case Arc:
                arc((ControlArc) source, (ControlArc) target, docInfoAdder);
                break;
            case Polygon:
                polygon((ControlPolygon) source, (ControlPolygon) target, docInfoAdder);
                break;
            case Curve:
                curve((ControlCurve) source, (ControlCurve) target, docInfoAdder);
                break;
            case Picture:
                picture((ControlPicture) source, (ControlPicture) target, docInfoAdder);
                break;
            case OLE:
                ole((ControlOLE) source, (ControlOLE) target, docInfoAdder);
                break;
            case Container:
                container((ControlContainer) source, (ControlContainer) target, docInfoAdder);
                break;
            case ObjectLinkLine:
                objectLinkLine((ControlObjectLinkLine) source, (ControlObjectLinkLine) target, docInfoAdder);
                break;
        }
    }

    private static void line(ControlLine source, ControlLine target, DocInfoAdder docInfoAdder) {
        ShapeComponentLine sourceSCL = source.getShapeComponentLine();
        ShapeComponentLine targetSCL = target.getShapeComponentLine();
        targetSCL.copy(sourceSCL);
    }

    private static void rectangle(ControlRectangle source, ControlRectangle target, DocInfoAdder docInfoAdder) {
        if (source.getTextBox() != null) {
            target.createTextBox();
            textBox(source.getTextBox(), target.getTextBox(), docInfoAdder);
        }

        ShapeComponentRectangle sourceSCR = source.getShapeComponentRectangle();
        ShapeComponentRectangle targetSCR = target.getShapeComponentRectangle();
        targetSCR.copy(sourceSCR);
    }

    private static void textBox(TextBox source, TextBox target, DocInfoAdder docInfoAdder) {
        listHeader(source.getListHeader(), target.getListHeader());
        ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
    }

    private static void listHeader(ListHeaderForTextBox source, ListHeaderForTextBox target) {
        target.copy(source);
    }

    private static void ellipse(ControlEllipse source, ControlEllipse target, DocInfoAdder docInfoAdder) {
        if (source.getTextBox() != null) {
            target.createTextBox();
            textBox(source.getTextBox(), target.getTextBox(), docInfoAdder);
        }

        ShapeComponentEllipse sourceSCE = source.getShapeComponentEllipse();
        ShapeComponentEllipse targetSCE = target.getShapeComponentEllipse();
        targetSCE.copy(sourceSCE);
    }

    private static void arc(ControlArc source, ControlArc target, DocInfoAdder docInfoAdder) {
        if (source.getTextBox() != null) {
            target.createTextBox();
            textBox(source.getTextBox(), target.getTextBox(), docInfoAdder);
        }

        ShapeComponentArc sourceSCA = source.getShapeComponentArc();
        ShapeComponentArc targetSCA = target.getShapeComponentArc();
        targetSCA.copy(sourceSCA);
    }

    private static void polygon(ControlPolygon source, ControlPolygon target, DocInfoAdder docInfoAdder) {
        if (source.getTextBox() != null) {
            target.createTextBox();
            textBox(source.getTextBox(), target.getTextBox(), docInfoAdder);
        }

        ShapeComponentPolygon sourceSCP = source.getShapeComponentPolygon();
        ShapeComponentPolygon targetSCP = target.getShapeComponentPolygon();
        targetSCP.copy(sourceSCP);
    }

    private static void curve(ControlCurve source, ControlCurve target, DocInfoAdder docInfoAdder) {
        if (source.getTextBox() != null) {
            target.createTextBox();
            textBox(source.getTextBox(), target.getTextBox(), docInfoAdder);
        }

        ShapeComponentCurve sourceSCC = source.getShapeComponentCurve();
        ShapeComponentCurve targetSCC = target.getShapeComponentCurve();
        targetSCC.copy(sourceSCC);
    }

    private static void picture(ControlPicture source, ControlPicture target, DocInfoAdder docInfoAdder) {
        ShapeComponentPicture sourceSCP = source.getShapeComponentPicture();
        ShapeComponentPicture targetSCP = target.getShapeComponentPicture();

        targetSCP.getBorderColor().setValue(sourceSCP.getBorderColor().getValue());
        targetSCP.setBorderThickness(sourceSCP.getBorderThickness());
        targetSCP.getBorderProperty().setValue(sourceSCP.getBorderProperty().getValue());
        positionXY(sourceSCP.getLeftTop(), targetSCP.getLeftTop());
        positionXY(sourceSCP.getRightTop(), targetSCP.getRightTop());
        positionXY(sourceSCP.getLeftBottom(), targetSCP.getLeftBottom());
        positionXY(sourceSCP.getRightBottom(), targetSCP.getRightBottom());
        targetSCP.setLeftAfterCutting(sourceSCP.getLeftAfterCutting());
        targetSCP.setTopAfterCutting(sourceSCP.getTopAfterCutting());
        targetSCP.setRightAfterCutting(sourceSCP.getRightAfterCutting());
        targetSCP.setBottomAfterCutting(sourceSCP.getBottomAfterCutting());
        innerMargin(sourceSCP.getInnerMargin(), targetSCP.getInnerMargin());
        GsoCommonPartCopier.pictureInfo(sourceSCP.getPictureInfo(), targetSCP.getPictureInfo(), docInfoAdder);
        targetSCP.setBorderTransparency(sourceSCP.getBorderTransparency());
        targetSCP.setInstanceId(sourceSCP.getInstanceId());
        pictureEffect(sourceSCP.getPictureEffect(), targetSCP.getPictureEffect());
        targetSCP.setImageWidth(sourceSCP.getImageWidth());
        targetSCP.setImageHeight(sourceSCP.getImageHeight());
    }

    private static void positionXY(PositionXY source, PositionXY target) {
        target.copy(source);
    }

    private static void innerMargin(InnerMargin source, InnerMargin target) {
        target.copy(source);
    }

    private static void pictureEffect(PictureEffect source, PictureEffect target) {
        target.copy(source);
    }

    private static void ole(ControlOLE source, ControlOLE target, DocInfoAdder docInfoAdder) {
        ShapeComponentOLE sourceSCO = source.getShapeComponentOLE();
        ShapeComponentOLE targetSCO = target.getShapeComponentOLE();

        targetSCO.getProperty().setValue(sourceSCO.getProperty().getValue());
        targetSCO.setExtentWidth(sourceSCO.getExtentWidth());
        targetSCO.setExtentHeight(sourceSCO.getExtentHeight());
        targetSCO.setBinDataId((docInfoAdder == null) ? sourceSCO.getBinDataId() : docInfoAdder.forBinData().processById(sourceSCO.getBinDataId()));
        targetSCO.getBorderColor().setValue(sourceSCO.getBorderColor().getValue());
        targetSCO.setBorderThickness(sourceSCO.getBorderThickness());
        targetSCO.getBorderProperty().setValue(sourceSCO.getBorderProperty().getValue());
        targetSCO.setUnknown(sourceSCO.getUnknown());
    }

    private static void container(ControlContainer source, ControlContainer target, DocInfoAdder docInfoAdder) {
        for (GsoControl sourceChild : source.getChildControlList()) {
            GsoControl targetChild = target.addNewChildControl(sourceChild.getGsoType());

            copy(sourceChild, targetChild, docInfoAdder);
        }
    }

    private static void objectLinkLine(ControlObjectLinkLine source, ControlObjectLinkLine target, DocInfoAdder docInfoAdder) {
        ShapeComponentLineForObjectLinkLine sourceSCL = source.getShapeComponentLine();
        ShapeComponentLineForObjectLinkLine targetSCL = target.getShapeComponentLine();
        targetSCL.copy(sourceSCL);
    }
}

package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponent;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineInfoProperty;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.arc.ArcBorder;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.curve.CurveSegmentType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ellipse.ShapeComponentEllipseProperty;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ole.ShapeComponentOLEProperty;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.picture.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.ListHeaderForTextBox;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.ListHeaderProperty;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.PictureInfo;
import kr.dogfoot.hwplib.object.etc.Color4Byte;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphCopier;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

import java.util.ArrayList;

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

        targetSCL.setStartX(sourceSCL.getStartX());
        targetSCL.setStartY(sourceSCL.getStartY());
        targetSCL.setEndX(sourceSCL.getEndX());
        targetSCL.setEndY(sourceSCL.getEndY());
    }

    private static void rectangle(ControlRectangle source, ControlRectangle target, DocInfoAdder docInfoAdder) {
        if (source.getTextBox() != null) {
            target.createTextBox();
            textBox(source.getTextBox(), target.getTextBox(), docInfoAdder);
        }
        shapeComponentRectangle(source.getShapeComponentRectangle(), target.getShapeComponentRectangle());
    }

    private static void textBox(TextBox source, TextBox target, DocInfoAdder docInfoAdder) {
        listHeader(source.getListHeader(), target.getListHeader());
        ParagraphCopier.listCopy(source.getParagraphList(), target.getParagraphList(), docInfoAdder);
    }

    private static void listHeader(ListHeaderForTextBox source, ListHeaderForTextBox target) {
        target.setParaCount(source.getParaCount());
        target.getProperty().setValue(source.getProperty().getValue());
        target.setLeftMargin(source.getLeftMargin());
        target.setRightMargin(source.getRightMargin());
        target.setTopMargin(source.getTopMargin());
        target.setBottomMargin(source.getBottomMargin());
        target.setTextWidth(source.getTextWidth());
        target.setEditableAtFormMode(source.isEditableAtFormMode());
        target.setFieldName(source.getFieldName());
    }

    private static void shapeComponentRectangle(ShapeComponentRectangle source, ShapeComponentRectangle target) {
        target.setRoundRate(source.getRoundRate());
        target.setX1(source.getX1());
        target.setY1(source.getY1());
        target.setX2(source.getX2());
        target.setY2(source.getY2());
        target.setX3(source.getX3());
        target.setY3(source.getY3());
        target.setX4(source.getX4());
        target.setY4(source.getY4());
    }

    private static void ellipse(ControlEllipse source, ControlEllipse target, DocInfoAdder docInfoAdder) {
        if (source.getTextBox() != null) {
            target.createTextBox();
            textBox(source.getTextBox(), target.getTextBox(), docInfoAdder);
        }
        shapeComponentEllipse(source.getShapeComponentEllipse(), target.getShapeComponentEllipse());
    }

    private static void shapeComponentEllipse(ShapeComponentEllipse source, ShapeComponentEllipse target) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.setCenterX(source.getCenterX());
        target.setCenterY(source.getCenterY());
        target.setAxis1X(source.getAxis1X());
        target.setAxis1Y(source.getAxis1Y());
        target.setAxis2X(source.getAxis2X());
        target.setAxis2Y(source.getAxis2Y());
        target.setStartX(source.getStartX());
        target.setStartY(source.getStartY());
        target.setEndX(source.getEndX());
        target.setEndY(source.getEndY());
        target.setStartX2(source.getStartX2());
        target.setStartY2(source.getStartY2());
        target.setEndX2(source.getEndX2());
        target.setEndY2(source.getEndY2());
    }

    private static void arc(ControlArc source, ControlArc target, DocInfoAdder docInfoAdder) {
        if (source.getTextBox() != null) {
            target.createTextBox();
            textBox(source.getTextBox(), target.getTextBox(), docInfoAdder);
            shapeComponentArc(source.getShapeComponentArc(), target.getShapeComponentArc());
        }
    }

    private static void shapeComponentArc(ShapeComponentArc source, ShapeComponentArc target) {
        target.setArcBorder(source.getArcBorder());
        target.setCenterX(source.getCenterX());
        target.setCenterY(source.getCenterY());
        target.setAxis1X(source.getAxis1X());
        target.setAxis1Y(source.getAxis1Y());
        target.setAxis2X(source.getAxis2X());
        target.setAxis2Y(source.getAxis2Y());
    }

    private static void polygon(ControlPolygon source, ControlPolygon target, DocInfoAdder docInfoAdder) {
        if (source.getTextBox() != null) {
            target.createTextBox();
            textBox(source.getTextBox(), target.getTextBox(), docInfoAdder);
        }
        shapeComponentPolygon(source.getShapeComponentPolygon(), target.getShapeComponentPolygon());
    }

    private static void shapeComponentPolygon(ShapeComponentPolygon source, ShapeComponentPolygon target) {
        for (PositionXY positionXY : source.getPositionList()) {
            PositionXY targetPositionXY = target.addNewPosition();
            targetPositionXY.setX(positionXY.getX());
            targetPositionXY.setY(positionXY.getY());
        }
    }

    private static void curve(ControlCurve source, ControlCurve target, DocInfoAdder docInfoAdder) {
        if  (source.getTextBox() != null) {
            target.createTextBox();
            textBox(source.getTextBox(), target.getTextBox(), docInfoAdder);
        }
        shapeComponentCurve(source.getShapeComponentCurve(), target.getShapeComponentCurve());
    }

    private static void shapeComponentCurve(ShapeComponentCurve source, ShapeComponentCurve target) {
        for (PositionXY positionXY : source.getPositionList()) {
            positionXY(positionXY, target.addNewPosition());
        }

        for (CurveSegmentType curveSegmentType : source.getSegmentTypeList()) {
            target.addCurveSegmentType(curveSegmentType);
        }
    }

    private static void positionXY(PositionXY source, PositionXY target) {
        target.setX(source.getX());
        target.setY(source.getY());
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

    private static void innerMargin(InnerMargin source, InnerMargin target) {
        target.setLeft(source.getLeft());
        target.setRight(source.getRight());
        target.setTop(source.getTop());
        target.setBottom(source.getBottom());
    }


    private static void pictureEffect(PictureEffect source, PictureEffect target) {
        target.getProperty().setValue(source.getProperty().getValue());
        if (source.getProperty().hasShadowEffect()) {
            target.createShadowEffect();
            shadowEffect(source.getShadowEffect(), target.getShadowEffect());
        }
        if (source.getProperty().hasNeonEffect()) {
            target.createNeonEffect();
            neonEffect(source.getNeonEffect(), target.getNeonEffect());
        }
        if (source.getProperty().hasSoftBorderEffect()) {
            target.createSoftEdgeEffect();
            softEdgeEffect(source.getSoftEdgeEffect(), target.getSoftEdgeEffect());
        }
        if (source.getProperty().hasReflectionEffect()) {
            target.createReflectionEffect();
            reflectionEffect(source.getReflectionEffect(), target.getReflectionEffect());
        }
    }

    private static void shadowEffect(ShadowEffect source, ShadowEffect target) {
        target.setStyle(source.getStyle());
        target.setTransparency(source.getTransparency());
        target.setCloudy(source.getCloudy());
        target.setDirection(source.getDirection());
        target.setDistance(source.getDistance());
        target.setSort(source.getSort());
        target.setTiltAngleX(source.getTiltAngleX());
        target.setTiltAngleY(source.getTiltAngleY());
        target.setZoomRateX(source.getZoomRateX());
        target.setZoomRateY(source.getZoomRateY());
        target.setRotateWithShape(source.getRotateWithShape());

        colorWithEffect(source.getColor(), target.getColor());
    }

    private static void colorWithEffect(ColorWithEffect source, ColorWithEffect target) {
        target.setType(source.getType());
        target.setColor(source.getColor());
        for (ColorEffect sourceCE : source.getColorEffectList()) {
            ColorEffect targetCE = target.addNewColorEffect();

            targetCE.setSort(sourceCE.getSort());
            targetCE.setValue(sourceCE.getValue());
        }
    }

    private static void neonEffect(NeonEffect source, NeonEffect target) {
        target.setTransparency(source.getTransparency());
        target.setRadius(source.getRadius());
        colorWithEffect(source.getColor(), target.getColor());
    }

    private static void softEdgeEffect(SoftEdgeEffect source, SoftEdgeEffect target) {
        target.setRadius(source.getRadius());
    }

    private static void reflectionEffect(ReflectionEffect source, ReflectionEffect target) {
        target.setStyle(source.getStyle());
        target.setRadius(source.getRadius());
        target.setDirection(source.getDirection());
        target.setDistance(source.getDistance());
        target.setTiltAngleX(source.getTiltAngleX());
        target.setTiltAngleY(source.getTiltAngleY());
        target.setZoomRateX(source.getZoomRateX());
        target.setZoomRateY(source.getZoomRateY());
        target.setRotationStyle(source.getRotationStyle());
        target.setStartTransparency(source.getStartTransparency());
        target.setStartPosition(source.getStartPosition());
        target.setEndTransparency(source.getEndTransparency());
        target.setEndPosition(source.getEndPosition());
        target.setOffsetDirection(source.getOffsetDirection());
    }


    private static void ole(ControlOLE source, ControlOLE target, DocInfoAdder docInfoAdder) {
        ShapeComponentOLE sourceSCO = source.getShapeComponentOLE();
        ShapeComponentOLE targetSCO = target.getShapeComponentOLE();

        targetSCO.getProperty().setValue(sourceSCO.getProperty().getValue());
        targetSCO.setExtentWidth(sourceSCO.getExtentWidth());
        targetSCO.setExtentHeight(sourceSCO.getExtentHeight());
        targetSCO.setBinDataId(docInfoAdder.forBinData().processById(sourceSCO.getBinDataId()));
        targetSCO.getBorderColor().setValue(sourceSCO.getBorderColor().getValue());
        targetSCO.setBorderThickness(sourceSCO.getBorderThickness());
        targetSCO.getBorderProperty().setValue(sourceSCO.getBorderProperty().getValue());
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

        targetSCL.setStartX(sourceSCL.getStartX());
        targetSCL.setStartY(sourceSCL.getStartY());
        targetSCL.setEndX(sourceSCL.getEndX());
        targetSCL.setEndY(sourceSCL.getEndY());
        targetSCL.setUnknown(sourceSCL.getUnknown());
    }
}

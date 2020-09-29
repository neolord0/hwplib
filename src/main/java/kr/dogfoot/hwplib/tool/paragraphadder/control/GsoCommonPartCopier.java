package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControlType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponent;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentContainer;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentNormal;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineInfo;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineInfoProperty;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.OutlineStyle;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.renderingnfo.Matrix;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.renderingnfo.RenderingInfo;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.renderingnfo.ScaleRotateMatrixPair;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.shadowinfo.ShadowInfo;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.shadowinfo.ShadowType;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.*;
import kr.dogfoot.hwplib.object.etc.Color4Byte;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

import java.util.ArrayList;

public class GsoCommonPartCopier {
    public static void copy(GsoControl source, GsoControl target, DocInfoAdder docInfoAdder) {
        ctrlHeader(source.getHeader(), target.getHeader());
        ctrlData(source, target, docInfoAdder);
        caption(source, target, docInfoAdder);
        if (source.getGsoType() == GsoControlType.Container) {
            shapeComponentGroup((ShapeComponentContainer) source.getShapeComponent(), (ShapeComponentContainer) target.getShapeComponent());
        } else {
            shapeComponentNormal((ShapeComponentNormal) source.getShapeComponent(), (ShapeComponentNormal) target.getShapeComponent(), docInfoAdder);
        }
    }

    private static void ctrlHeader(CtrlHeaderGso source, CtrlHeaderGso target) {
        target.getProperty().setValue(source.getProperty().getValue());
        target.setyOffset(source.getyOffset());
        target.setxOffset(source.getxOffset());
        target.setWidth(source.getWidth());
        target.setHeight(source.getHeight());
        target.setzOrder(source.getzOrder());
        target.setOutterMarginLeft(source.getOutterMarginLeft());
        target.setOutterMarginRight(source.getOutterMarginRight());
        target.setOutterMarginTop(source.getOutterMarginTop());
        target.setOutterMarginBottom(source.getOutterMarginBottom());
        target.setInstanceId(source.getInstanceId());
        target.setPreventPageDivide(source.isPreventPageDivide());
        target.setExplanation(source.getExplanation());
    }

    private static void ctrlData(GsoControl source, GsoControl target, DocInfoAdder docInfoAdder) {
        if (source.getCtrlData() == null) {
            return;
        }

        target.createCtrlData();
        ParameterSetCopier.copy(source.getCtrlData().getParameterSet(), target.getCtrlData().getParameterSet(), docInfoAdder);
    }

    private static void caption(GsoControl source, GsoControl target, DocInfoAdder docInfoAdder) {
        if (source.getCaption() == null) {
            return;
        }

        target.createCaption();
        CaptionCopier.copy(source.getCaption(), target.getCaption(), docInfoAdder);
    }


    private static void shapeComponentNormal(ShapeComponentNormal source, ShapeComponentNormal target, DocInfoAdder docInfoAdder) {
        shapeComponent(source, target);

        if (source.getLineInfo() != null) {
            target.createLineInfo();
            lineInfo(source.getLineInfo(), target.getLineInfo());
        }
        if (source.getFillInfo() != null) {
            target.createFillInfo();
            fillInfo(source.getFillInfo(), target.getFillInfo(), docInfoAdder);
        }
        if (source.getShadowInfo() != null) {
            target.createShadowInfo();
            shadowInfo(source.getShadowInfo(), target.getShadowInfo());
        }
    }

    private static void shapeComponent(ShapeComponent source, ShapeComponent target) {
        target.setGsoId(source.getGsoId());
        target.setOffsetX(source.getOffsetX());
        target.setOffsetY(source.getOffsetY());
        target.setGroupingCount(source.getGroupingCount());
        target.setLocalFileVersion(source.getLocalFileVersion());
        target.setWidthAtCreate(source.getWidthAtCreate());
        target.setHeightAtCreate(source.getHeightAtCreate());
        target.setWidthAtCurrent(source.getWidthAtCurrent());
        target.setHeightAtCurrent(source.getHeightAtCurrent());
        target.setProperty(source.getProperty());
        target.setRotateAngle(source.getRotateAngle());
        target.setRotateXCenter(source.getRotateXCenter());
        target.setRotateYCenter(source.getRotateYCenter());

        renderingInfo(source.getRenderingInfo(), target.getRenderingInfo());
    }

    private static void lineInfo(LineInfo source, LineInfo target) {
        target.getColor().setValue(source.getColor().getValue());
        target.setThickness(source.getThickness());
        target.getProperty().setValue(source.getProperty().getValue());
        target.setOutlineStyle(source.getOutlineStyle());
    }

    private static void fillInfo(FillInfo source, FillInfo target, DocInfoAdder docInfoAdder) {
        target.getType().setValue(source.getType().getValue());

        if (source.getType().hasPatternFill()) {
            target.createPatternFill();

            PatternFill sourcePF = source.getPatternFill();
            PatternFill targetPF = target.getPatternFill();

            targetPF.getBackColor().setValue(sourcePF.getBackColor().getValue());
            targetPF.getPatternColor().setValue(sourcePF.getPatternColor().getValue());
            targetPF.setPatternType(sourcePF.getPatternType());
        }

        if (source.getType().hasGradientFill()) {
            target.createGradientFill();

            GradientFill sourceGF = source.getGradientFill();
            GradientFill targetGF = target.getGradientFill();

            targetGF.setGradientType(sourceGF.getGradientType());
            targetGF.setStartAngle(sourceGF.getStartAngle());
            targetGF.setCenterX(sourceGF.getCenterX());
            targetGF.setCenterY(sourceGF.getCenterY());
            targetGF.setBlurringDegree(sourceGF.getBlurringDegree());
            for (Integer point : sourceGF.getChangePointList()) {
                targetGF.addChangePoint(point);
            }
            for (Color4Byte color : sourceGF.getColorList()) {
                targetGF.addNewColor().setValue(color.getValue());
            }
            targetGF.setBlurringCenter(sourceGF.getBlurringCenter());
        }

        if (source.getType().hasImageFill()) {
            target.createImageFill();

            ImageFill sourceIF = source.getImageFill();
            ImageFill targetIF = target.getImageFill();

            targetIF.setImageFillType(sourceIF.getImageFillType());

            pictureInfo(sourceIF.getPictureInfo(), targetIF.getPictureInfo(), docInfoAdder);
        }
    }

    private static void shadowInfo(ShadowInfo source, ShadowInfo target) {
        target.setType(source.getType());
        target.getColor().setValue(source.getColor().getValue());
        target.setOffsetX(source.getOffsetX());
        target.setOffsetY(source.getOffsetY());
        target.setTransparnet(source.getTransparnet());
    }

    private static void shapeComponentGroup(ShapeComponentContainer source, ShapeComponentContainer target) {
        shapeComponent(source, target);

        for (Long childControlId :  source.getChildControlIdList()) {
            target.addChildControlId(childControlId);
        }
    }

    private static void renderingInfo(RenderingInfo source, RenderingInfo target) {
        matrix(source.getTranslationMatrix() ,target.getTranslationMatrix());

        for (ScaleRotateMatrixPair sourceMatrixPair : source.getScaleRotateMatrixPairList()) {
            ScaleRotateMatrixPair targetMatrixPair = target.addNewScaleRotateMatrixPair();

            matrix(sourceMatrixPair.getRotateMatrix(), targetMatrixPair.getRotateMatrix());
            matrix(sourceMatrixPair.getScaleMatrix(), targetMatrixPair.getScaleMatrix());
        }
    }

    private static void matrix(Matrix source, Matrix target) {
        for (int index = 0; index < 6; index++) {
            target.setValue(index, source.getValue(index));
        }
    }

    public static void pictureInfo(PictureInfo source, PictureInfo target, DocInfoAdder docInfoAdder) {
        target.setBrightness(source.getBrightness());
        target.setContrast(source.getContrast());
        target.setEffect(source.getEffect());
        target.setBinItemID(docInfoAdder.forBinData().processById(source.getBinItemID()));
    }
}


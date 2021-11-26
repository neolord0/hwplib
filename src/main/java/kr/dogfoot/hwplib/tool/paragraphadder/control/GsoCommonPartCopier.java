package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControl;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControlType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponent;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentContainer;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentNormal;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineInfo;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.shadowinfo.ShadowInfo;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.*;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class GsoCommonPartCopier {
    public static void copy(GsoControl source, GsoControl target, DocInfoAdder docInfoAdder) {
        // in container == null
        if (source.getHeader() != null) {
            ctrlHeader(source.getHeader(), target.getHeader());
        }
        CtrlDataCopier.copy(source, target, docInfoAdder);
        caption(source, target, docInfoAdder);
        if (source.getGsoType() == GsoControlType.Container) {
            shapeComponentGroup((ShapeComponentContainer) source.getShapeComponent(), (ShapeComponentContainer) target.getShapeComponent());
        } else {
            shapeComponentNormal((ShapeComponentNormal) source.getShapeComponent(), (ShapeComponentNormal) target.getShapeComponent(), docInfoAdder);
        }
    }

    private static void ctrlHeader(CtrlHeaderGso source, CtrlHeaderGso target) {
        target.copy(source);
    }

    private static void caption(GsoControl source, GsoControl target, DocInfoAdder docInfoAdder) {
        if (source.getCaption() != null) {
            target.createCaption();
            CaptionCopier.copy(source.getCaption(), target.getCaption(), docInfoAdder);
        } else {
            target.deleteCaption();
        }
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
        target.copy(source);
    }

    private static void lineInfo(LineInfo source, LineInfo target) {
        target.copy(source);
    }

    private static void fillInfo(FillInfo source, FillInfo target, DocInfoAdder docInfoAdder) {
        target.getType().setValue(source.getType().getValue());

        if (source.getType().hasPatternFill()) {
            target.createPatternFill();

            PatternFill sourcePF = source.getPatternFill();
            PatternFill targetPF = target.getPatternFill();

            targetPF.copy(sourcePF);
        }

        if (source.getType().hasGradientFill()) {
            target.createGradientFill();

            GradientFill sourceGF = source.getGradientFill();
            GradientFill targetGF = target.getGradientFill();

            targetGF.copy(sourceGF);

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
        target.copy(source);
    }

    private static void shapeComponentGroup(ShapeComponentContainer source, ShapeComponentContainer target) {
        target.copy(source);
    }

    public static void pictureInfo(PictureInfo source, PictureInfo target, DocInfoAdder docInfoAdder) {
        target.setBrightness(source.getBrightness());
        target.setContrast(source.getContrast());
        target.setEffect(source.getEffect());
        target.setBinItemID((docInfoAdder == null) ? source.getBinItemID() : docInfoAdder.forBinData().processById(source.getBinItemID()));
    }
}

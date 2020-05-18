package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.CharPositionShapeIdPair;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

/**
 * Paragraph의 ParaCharShape을 복사하는 기능을 포함하는 클래스
 *
 * @author neolord
 */
public class ParaCharShapeCopier {
    public static void copy(ParaCharShape source, ParaCharShape target, DocInfoAdder docInfoAdder) {
        for (CharPositionShapeIdPair cpsp : source.getPositonShapeIdPairList()) {
            target.addParaCharShape(cpsp.getPosition(), docInfoAdder.forCharShape().processById((int) cpsp.getShapeId()));
        }
    }
}

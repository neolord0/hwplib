package kr.dogfoot.hwplib.tool.paragraphadder;

import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.CharPositonShapeIdPair;
import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

/**
 * Paragraph의 ParaCharShape을 복사하는 기능을 포함하는 클래스
 *
 * @author neolord
 */
public class ParaCharShapeCopyer {
    public static void copy(ParaCharShape source, ParaCharShape target, DocInfoAdder docInfoAdder) {
        for (CharPositonShapeIdPair cpsp : source.getPositonShapeIdPairList()) {
            target.addParaCharShape(cpsp.getPositon(), docInfoAdder.forCharShape().processById((int) cpsp.getShapeId()));
        }
    }
}

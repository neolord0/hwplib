package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.secd;

import kr.dogfoot.hwplib.object.bodytext.control.sectiondefine.FootEndNoteShape;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderThickness;
import kr.dogfoot.hwplib.object.docinfo.borderfill.BorderType;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 각주/미주 모양 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForFootEndNoteShape {
    /**
     * 각주/미주 모양 레코드를 읽는다.
     *
     * @param fens 각주/미주 모양 레코드
     * @param sr   스트림 리더
     * @throws IOException
     */
    public static void read(FootEndNoteShape fens, StreamReader sr)
            throws IOException {
        fens.getProperty().setValue(sr.readUInt4());
        fens.setUserSymbol(sr.readWChar());
        fens.setBeforeDecorativeLetter(sr.readWChar());
        fens.setAfterDecorativeLetter(sr.readWChar());
        fens.setStartNumber(sr.readUInt2());
        fens.setDivideLineLength(sr.readUInt4());
        fens.setDivideLineTopMargin(sr.readUInt2());
        fens.setDivideLineBottomMargin(sr.readUInt2());
        fens.setBetweenNotesMargin(sr.readUInt2());
        fens.setDivideLineSort(BorderType.valueOf((byte) sr
                .readUInt1()));
        fens.setDivideLineThickness(BorderThickness.valueOf((byte) sr
                .readUInt1()));
        fens.getDivideLineColor().setValue(sr.readUInt4());

        if (sr.isEndOfRecord() == false) {
            fens.setUnknown(sr.readUInt4());
        }
    }
}

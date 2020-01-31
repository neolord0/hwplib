package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.eqed;

import kr.dogfoot.hwplib.object.bodytext.control.equation.EQEdit;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 수식 정보 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForEQEdit {
    /**
     * 수식 정보 레코드를 읽는다.
     *
     * @param eqEdit 수식 정보 레코드
     * @param sr     스트림 리더
     * @throws IOException
     */
    public static void read(EQEdit eqEdit, StreamReader sr) throws IOException {
        eqEdit.setProperty(sr.readUInt4());
        eqEdit.setScript(sr.readUTF16LEString());
        eqEdit.setLetterSize(sr.readUInt4());
        eqEdit.getLetterColor().setValue(sr.readUInt4());

        if (sr.isEndOfRecord() == false) {
            eqEdit.setBaseLine(sr.readSInt2());
        }

        if (sr.isEndOfRecord() == false) {
            eqEdit.setUnknown(sr.readUInt2());
        }

        if (sr.isEndOfRecord() == false) {
            eqEdit.setVersionInfo(sr.readUTF16LEString());
        }

        if (sr.isEndOfRecord() == false) {
            eqEdit.setFontName(sr.readUTF16LEString());
        }
    }

}

package kr.dogfoot.hwplib.reader.bodytext.paragraph.control;

import kr.dogfoot.hwplib.object.bodytext.control.ControlPageOddEvenAdjust;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

public class ForControlPageOddEvenAdjust {
    public static void read(ControlPageOddEvenAdjust pgoea, StreamReader sr) throws IOException {
        pgoea.getHeader().getProperty().setValue(sr.readUInt4());
    }
}

package kr.dogfoot.hwplib.sample;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.ControlSectionDefine;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.blankfilemaker.EmptyParagraphAdder;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

public class Inserting_Section_And_Changing_PaperSize {
    private static class Size {
        public long cx;
        public long cy;

        public Size(long cx, long cy) {
            this.cx = cx;
            this.cy = cy;
        }
    }


    public static void main(String[] args) throws Exception {
        String filename = "sample_hwp" + File.separator + "blank.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            Section section = hwpFile.getBodyText().addNewSection();
            EmptyParagraphAdder.add(section);
            Size paperSize = getPaperSize();

            ControlSectionDefine csd = (ControlSectionDefine) section.getParagraph(0).getControlList().get(0);
            csd.getPageDef().setPaperWidth(paperSize.cx);
            csd.getPageDef().setPaperHeight(paperSize.cy);

        }

        String writePath = "sample_hwp" + File.separator + "result-inserting-section-and-changing-papersize.hwp";
        HWPWriter.toFile(hwpFile, writePath);
    }

    private static Size getPaperSize() {
        // B5
        // return new Size(51592, 72852);

        // B4
        // return new Size(72852, 103180);

        // A4
        // return new Size(59528, 84188);

        // A3
        // return new Size(84188, 119052);

        // Legal
        // return new Size(61200, 100800);

        // A5
        // return new Size(41976, 59528);

        // other : coordinate's unit is mm ;
        // (coordinate * 72000.0f / 254.0f + 0.5f);
        return new Size((long) ((double) 100 * 72000.0f / 254.0f + 0.5f),
                (long) ((double) 200 * 72000.f / 254.0f + 0.5f));
    }

}

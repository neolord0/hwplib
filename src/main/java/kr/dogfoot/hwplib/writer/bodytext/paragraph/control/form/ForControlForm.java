package kr.dogfoot.hwplib.writer.bodytext.paragraph.control.form;

import kr.dogfoot.hwplib.object.bodytext.control.ControlForm;
import kr.dogfoot.hwplib.object.bodytext.control.form.FormObject;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.bodytext.paragraph.control.gso.part.ForCtrlHeaderGso;

import java.io.IOException;

public class ForControlForm {
    public static void write(ControlForm form, StreamWriter sw) throws IOException {
        ForCtrlHeaderGso.write(form.getHeader(), sw);

        sw.upRecordLevel();

        formObject(form.getFormObject(), sw);

        sw.downRecordLevel();
    }

    private static void formObject(FormObject fo, StreamWriter sw) throws IOException {
        recordHeader(fo, sw);
        sw.writeUInt4(fo.getType().getId());
        sw.writeUInt4(fo.getType().getId());
        sw.writeUInt2(fo.getProperties().getWCharsSize());
        sw.writeZero(2);
        sw.writeHWPString(fo.getProperties());
    }

    private static void recordHeader(FormObject fo, StreamWriter sw) throws IOException {
        sw.writeRecordHeader(HWPTag.FORM_OBJECT, getSize(fo));
    }

    private static long getSize(FormObject fo) {
        return 12 + fo.getProperties().getWCharsSize();
    }
}

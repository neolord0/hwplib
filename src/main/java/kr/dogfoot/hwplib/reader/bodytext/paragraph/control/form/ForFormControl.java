package kr.dogfoot.hwplib.reader.bodytext.paragraph.control.form;

import kr.dogfoot.hwplib.object.bodytext.control.ControlForm;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.form.FormObject;
import kr.dogfoot.hwplib.object.bodytext.control.form.FormObjectType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.reader.bodytext.paragraph.control.gso.part.ForCtrlHeaderGso;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ForFormControl {
    public static void read(Paragraph paragraph, StreamReader sr) throws Exception {
        CtrlHeaderGso header = ctrlHeader(sr);

        ControlForm fc = paragraph.addNewFormControl(header);
        formObject(fc.getFormObject(), sr);
    }

    private static CtrlHeaderGso ctrlHeader(StreamReader sr) throws IOException {
        CtrlHeaderGso header = new CtrlHeaderGso(ControlType.Form);
        ForCtrlHeaderGso.read(header, sr);
        return header;
    }

    private static void formObject(FormObject formObject, StreamReader sr) throws IOException {
        sr.readRecordHeader();
        if (sr.getCurrentRecordHeader().getTagID() == HWPTag.FORM_OBJECT) {
            long id = sr.readUInt4();
            long id2 = sr.readUInt4();
            formObject.setType(FormObjectType.fromUint4(id));
            sr.skip(4);

            String propertiesString = new String(sr.readHWPString(), StandardCharsets.UTF_16LE);
            formObject.getProperties().parse(propertiesString);
        }
    }
}

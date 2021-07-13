package kr.dogfoot.hwplib.object.bodytext.control.form;

import kr.dogfoot.hwplib.object.etc.HWPString;

public class FormObject {
    private FormObjectType type;
    private HWPString properties;

    public FormObject() {
        type = null;
        properties = new HWPString();
    }

    public FormObjectType getType() {
        return type;
    }

    public void setType(FormObjectType type) {
        this.type = type;
    }

    public HWPString getProperties() {
        return properties;
    }
}

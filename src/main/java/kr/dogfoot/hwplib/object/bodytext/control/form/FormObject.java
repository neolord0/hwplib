package kr.dogfoot.hwplib.object.bodytext.control.form;

import kr.dogfoot.hwplib.object.bodytext.control.form.properties.PropertySet;
import kr.dogfoot.hwplib.object.etc.HWPString;

public class FormObject {
    private FormObjectType type;
    private PropertySet properties;

    public FormObject() {
        type = null;
        properties = new PropertySet("");
    }

    public FormObjectType getType() {
        return type;
    }

    public void setType(FormObjectType type) {
        this.type = type;
    }

    public PropertySet getProperties() {
        return properties;
    }
}

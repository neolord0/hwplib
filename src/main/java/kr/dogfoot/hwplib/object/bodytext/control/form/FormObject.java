package kr.dogfoot.hwplib.object.bodytext.control.form;

import kr.dogfoot.hwplib.object.bodytext.control.form.properties.PropertySet;

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

    public void copy(FormObject from) {
        type = from.type;
        properties.copy(from.properties);
    }
}

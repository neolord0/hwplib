package kr.dogfoot.hwplib.tool.objectfinder.fieldform;

import kr.dogfoot.hwplib.object.bodytext.control.form.FormObjectType;

public class FormData {
    private String name;
    private FormObjectType type;
    private String value;

    public FormData(String name, FormObjectType type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FormObjectType getType() {
        return type;
    }

    public void setType(FormObjectType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

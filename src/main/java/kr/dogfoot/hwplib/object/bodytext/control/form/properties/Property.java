package kr.dogfoot.hwplib.object.bodytext.control.form.properties;

import kr.dogfoot.hwplib.object.etc.HWPString;

public abstract class Property {
    private String name;

    public Property() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract PropertyType getType();
}

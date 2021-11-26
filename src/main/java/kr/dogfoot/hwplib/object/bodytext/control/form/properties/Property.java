package kr.dogfoot.hwplib.object.bodytext.control.form.properties;

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

    public abstract Property clone();
}

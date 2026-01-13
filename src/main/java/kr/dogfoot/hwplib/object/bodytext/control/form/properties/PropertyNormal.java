package kr.dogfoot.hwplib.object.bodytext.control.form.properties;

public class PropertyNormal extends Property {
    private PropertyType type;
    private String value;

    public PropertyNormal(String name) {
        setName(name);
    }

    @Override
    public PropertyType getType() {
        return type;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Property clone() {
        PropertyNormal cloned = new PropertyNormal(getName());
        cloned.type = type;
        cloned.value = value;
        return cloned;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (type == PropertyType.WString) {
            sb
                    .append(getName())
                    .append(":")
                    .append(type.toString())
                    .append(":")
                    .append(value.length())
                    .append(":")
                    .append(value);
        } else {
            sb
                    .append(getName())
                    .append(":")
                    .append(type.toString())
                    .append(":")
                    .append(value);
        }
        return sb.toString();
    }
}

package kr.dogfoot.hwplib.object.bodytext.control.form.properties;

public enum PropertyType {
    NULL(""),
    Set("set"),
    WString("wstring"),
    Int("int"),
    Bool("bool");

    private String str;

    PropertyType(String str) {
        this.str = str;
    }

    public String toString() {
        return str;
    }

    public static PropertyType fromString(String str) {
        for (PropertyType pt : values()) {
            if (pt.str.equals(str)) {
                return pt;
            }
        }
        return NULL;
    }
}

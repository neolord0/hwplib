package htmltohwp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class RGBColor {
    public RGBColor(short r, short g, short b) {
        setR(r);
        setG(g);
        setB(b);
    }
    private short r, g, b;

    public short getR() {
        return r;
    }

    public void setR(short r) {
        this.r = r;
    }

    public short getG() {
        return g;
    }

    public void setG(short g) {
        this.g = g;
    }

    public short getB() {
        return b;
    }

    public void setB(short b) {
        this.b = b;
    }
}
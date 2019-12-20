import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RGBColor {
    public RGBColor(short r, short g, short b) {
        setR(r);
        setG(g);
        setB(b);
    }
    private short r, g, b;
}
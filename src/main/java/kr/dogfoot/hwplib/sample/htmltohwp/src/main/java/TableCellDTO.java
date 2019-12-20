import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TableCellDTO {
    private double width, height;
    private int type, colspan, rowspan;
    private String text;
}
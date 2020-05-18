package htmltohwp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class TableCellDTO {
    private double width, height;
    private int type, colspan, rowspan;
    private String text;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getColspan() {
        return colspan;
    }

    public void setColspan(int colspan) {
        this.colspan = colspan;
    }

    public int getRowspan() {
        return rowspan;
    }

    public void setRowspan(int rowspan) {
        this.rowspan = rowspan;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
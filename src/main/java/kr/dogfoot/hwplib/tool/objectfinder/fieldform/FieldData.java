package kr.dogfoot.hwplib.tool.objectfinder.fieldform;

import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;

public class FieldData {
    private String name;
    private FieldType type;
    private Object parent;

    private ParagraphListInterface paragraphList;
    private int startParaIndex;
    private int startCharIndex;
    private int endParaIndex;
    private int endCharIndex;

    public FieldData(String name, FieldType type, Object parent, ParagraphListInterface paragraphList) {
        this.name = name;
        this.type = type;
        this.paragraphList = paragraphList;
        this.parent = parent;

        startParaIndex = -1;
        startCharIndex = -1;
        endParaIndex = -1;
        endCharIndex = -1;
    }

    public String getName() {
        return name;
    }

    public FieldType getType() {
        return type;
    }

    public Object getParent() {
        return parent;
    }

    public ParagraphListInterface getParagraphList() {
        return paragraphList;
    }

    public int getStartParaIndex() {
        return startParaIndex;
    }

    public Paragraph getStartParagraph() {
        return paragraphList.getParagraph(startParaIndex);
    }

    public int getStartCharIndex() {
        return startCharIndex;
    }

    public void setStartPosition(int startParaIndex, int startCharIndex) {
        this.startParaIndex = startParaIndex;
        this.startCharIndex = startCharIndex;
    }

    public int getEndParaIndex() {
        return endParaIndex;
    }

    public Paragraph getEndParagraph() {
        return paragraphList.getParagraph(endParaIndex);
    }

    public int getEndCharIndex() {
        return endCharIndex;
    }

    public void setEndPosition(int endParaIndex, int endCharIndex) {
        this.endParaIndex = endParaIndex;
        this.endCharIndex = endCharIndex;
    }

    public boolean isEmptyField() {
        return ((type == FieldType.ClickHere || type == FieldType.ETC) &&
                (startParaIndex != -1 && startParaIndex == endParaIndex) &&
                endCharIndex - startCharIndex == 1);
    }
}

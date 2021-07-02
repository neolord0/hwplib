package kr.dogfoot.hwplib.tool.textextractor;

import org.apache.poi.ss.formula.functions.T;

public class TextExtractOption {
    private TextExtractMethod method;

    private boolean withControlChar;
    private boolean appendEndingLF;
    private boolean insertParaHead;

    public TextExtractOption() {
        method = TextExtractMethod.InsertControlTextBetweenParagraphText;
        withControlChar = false;
        appendEndingLF = true;
        insertParaHead = true;
    }

    public TextExtractOption(TextExtractMethod method) {
        this.method = method;
        withControlChar = false;
        appendEndingLF = true;
        insertParaHead = true;
    }

    public TextExtractOption(TextExtractOption that) {
        this.method = that.method;
        this.withControlChar = that.withControlChar;
        this.appendEndingLF = that.appendEndingLF;
    }

    public TextExtractMethod getMethod() {
        return method;
    }

    public void setMethod(TextExtractMethod method) {
        this.method = method;
    }

    public boolean isWithControlChar() {
        return withControlChar;
    }

    public void setWithControlChar(boolean withControlChar) {
        this.withControlChar = withControlChar;
    }

    public boolean isAppendEndingLF() {
        return appendEndingLF;
    }

    public void setAppendEndingLF(boolean appendEndingLF) {
        this.appendEndingLF = appendEndingLF;
    }

    public boolean isInsertParaHead() {
        return insertParaHead;
    }

    public void setInsertParaHead(boolean insertParaHead) {
        this.insertParaHead = insertParaHead;
    }
}

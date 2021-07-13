package kr.dogfoot.hwplib.tool.objectfinder.fieldfiner;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;

import java.util.ArrayList;

public class FieldFinder {
    public static ArrayList<FieldData> findAll(HWPFile hwpFile) {
        ArrayList<FieldData> result = new ArrayList();

        for (Section section : hwpFile.getBodyText().getSectionList()) {
            findInParagraphList(section, result);
        }

        return result;
    }

    public static void findInParagraphList(ParagraphListInterface paragraphList, ArrayList<FieldData> result) {
        ArrayList<FieldData> resultInParagraphList = new ArrayList<>();
        getFieldStartPosition(paragraphList, resultInParagraphList);
        for (FieldData fieldData : resultInParagraphList) {
            getFieldEndPosition(paragraphList, fieldData);
        }
        result.addAll(resultInParagraphList);

        for (Paragraph paragraph : paragraphList) {
            if (paragraph.getControlList() != null) {
                ForControl.findInControlList(paragraph.getControlList(), result);
            }
        }
    }


    private static void getFieldStartPosition(ParagraphListInterface paragraphList, ArrayList<FieldData> result) {
        int paraCount = paragraphList.getParagraphCount();
        for (int paraIndex = 0; paraIndex < paraCount; paraIndex++) {
            findStartingField(paragraphList, paraIndex,  result);
        }
    }

    private static void findStartingField(ParagraphListInterface paragraphList, int paraIndex, ArrayList<FieldData> results) {
        Paragraph p = paragraphList.getParagraph(paraIndex);
        if (p.getControlList() == null) {
            return;
        }

        int ctrlCount = p.getControlList().size();
        for (int ctrlIndex = 0; ctrlIndex < ctrlCount; ctrlIndex++) {
            Control c = p.getControlList().get(ctrlIndex);
            if (c.isField()) {
                ControlField field = (ControlField) c;

                FieldData fieldData = new FieldData(field.getName(),
                        (field.getType() == ControlType.FIELD_CLICKHERE) ? FieldType.ClickHere : FieldType.ETC,
                        paragraphList);
                fieldData.setStartPosition(paraIndex, p.getText().getCharIndexFromExtendCharIndex(ctrlIndex));

                results.add(fieldData);
            }
       }
    }

    private static void getFieldEndPosition(ParagraphListInterface paragraphList, FieldData fieldData) {
        int depth = 0;
        int paraCount = paragraphList.getParagraphCount();
        for (int paraIndex = fieldData.startParaIndex; paraIndex < paraCount; paraIndex++) {
            Paragraph p = paragraphList.getParagraph(paraIndex);
            if (p.getText() != null) {
                int startIndex = (paraIndex == fieldData.startParaIndex) ? fieldData.startCharIndex + 1 : 0;
                int charCount = p.getText().getCharList().size();
                for (int charIndex = startIndex; charIndex < charCount; charIndex++) {
                    HWPChar hwpChar = p.getText().getCharList().get(charIndex);
                    if (hwpChar.getCode() == 0x3/*field start*/) {
                        depth++;
                    } else if (hwpChar.getCode() == 0x4/*field end*/) {
                        if (depth == 0) {
                            fieldData.setEndPosition(paraIndex, charIndex);
                            return;
                        } else {
                            depth--;
                        }
                    }
                }
            }
        }
    }

    public static class FieldData {
        private String name;
        private FieldType type;

        private ParagraphListInterface paragraphList;
        private int startParaIndex;
        private int startCharIndex;
        private int endParaIndex;
        private int endCharIndex;

        public FieldData(String name, FieldType type, ParagraphListInterface paragraphList) {
            this.name = name;
            this.type = type;
            this.paragraphList = paragraphList;

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

        public ParagraphListInterface getParagraphList() {
            return paragraphList;
        }

        public int getStartParaIndex() {
            return startParaIndex;
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

        public int getEndCharIndex() {
            return endCharIndex;
        }

        public void setEndPosition(int endParaIndex, int endCharIndex) {
            this.endParaIndex = endParaIndex;
            this.endCharIndex = endCharIndex;
        }
    }

    public enum FieldType {
        ClickHere,
        Cell,
        Gso,
        ETC,
    }
}

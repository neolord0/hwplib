package kr.dogfoot.hwplib.tool.objectfinder.fieldform;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlField;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.HWPChar;

import java.util.ArrayList;

public class FieldFormFinder {
    public static Result findAll(HWPFile hwpFile) {
        Result result = new Result();

        for (Section section : hwpFile.getBodyText().getSectionList()) {
            findInParagraphList(section, result);
        }

        return result;
    }

    public static void findInParagraphList(ParagraphListInterface paragraphList, Result result) {
        ArrayList<FieldData> resultInParagraphList = new ArrayList<>();
        getFieldStartPosition(paragraphList, resultInParagraphList);
        for (FieldData fieldData : resultInParagraphList) {
            getFieldEndPosition(paragraphList, fieldData);
        }
        result.addAllFieldData(resultInParagraphList);

        for (Paragraph paragraph : paragraphList) {
            if (paragraph.getControlList() != null) {
                ForControl.findInControlList(paragraph.getControlList(), result);
            }
        }
    }


    private static void getFieldStartPosition(ParagraphListInterface paragraphList, ArrayList<FieldData> result) {
        int paraCount = paragraphList.getParagraphCount();
        for (int paraIndex = 0; paraIndex < paraCount; paraIndex++) {
            findStartingField(paragraphList, paraIndex, result);
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
                        (field.getType() == ControlType.FIELD_CLICKHERE) ? FieldData.FieldType.ClickHere : FieldData.FieldType.ETC,
                        paragraphList);
                fieldData.setStartPosition(paraIndex, p.getText().getCharIndexFromExtendCharIndex(ctrlIndex));

                results.add(fieldData);
            }
        }
    }

    private static void getFieldEndPosition(ParagraphListInterface paragraphList, FieldData fieldData) {
        int depth = 0;
        int paraCount = paragraphList.getParagraphCount();
        for (int paraIndex = fieldData.getStartParaIndex(); paraIndex < paraCount; paraIndex++) {
            Paragraph p = paragraphList.getParagraph(paraIndex);
            if (p.getText() != null) {
                int startIndex = (paraIndex == fieldData.getStartParaIndex()) ? fieldData.getStartCharIndex() + 1 : 0;
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

    public static class Result {
        private ArrayList<FieldData> fieldDataList;
        private ArrayList<FormData> formDataList;

        public Result() {
            fieldDataList = new ArrayList<>();
            formDataList = new ArrayList<>();
        }

        public void addFieldData(FieldData fieldData) {
            fieldDataList.add(fieldData);
        }

        public void addAllFieldData(ArrayList<FieldData> fieldDataList) {
            this.fieldDataList.addAll(fieldDataList);
        }

        public ArrayList<FieldData> getFieldDataList() {
            return fieldDataList;
        }

        public void addFormData(FormData formData) {
            formDataList.add(formData);
        }

        public ArrayList<FormData> getFormDataList() {
            return formDataList;
        }
    }
}
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
        return find(hwpFile, new Option(null, false, true, true, true, true));
    }

    public static Result find(HWPFile hwpFile, Option option) {
        Result result = new Result();

        for (Section section : hwpFile.getBodyText().getSectionList()) {
            try {
                findInParagraphList(section, result, option);
            } catch (StopFindException e) {
                break;
            }
        }

        return result;
    }

    public static void findInParagraphList(ParagraphListInterface paragraphList, Result result, Option option) throws StopFindException {
        StopFindException exception = null;

        if (option.nameToFind() != null && option.onlyFirst() && result.added()) {
            throw new StopFindException();
        }

        if (option.findField()) {
            ArrayList<FieldData> resultInParagraphList = new ArrayList<>();
            try {
                getFieldStartPosition(paragraphList, resultInParagraphList, option);
            } catch (StopFindException e) {
                exception = e;
            }
            for (FieldData fieldData : resultInParagraphList) {
                getFieldEndPosition(paragraphList, fieldData);
            }
            result.addAllFieldData(resultInParagraphList);
        }

        if (exception != null) {
            throw exception;
        }

        for (Paragraph paragraph : paragraphList) {
            if (paragraph.getControlList() != null) {
                ForControl.findInControlList(paragraph.getControlList(), result, option);
            }
        }
    }


    private static void getFieldStartPosition(ParagraphListInterface paragraphList, ArrayList<FieldData> result, Option option) throws StopFindException {
        int paraCount = paragraphList.getParagraphCount();
        for (int paraIndex = 0; paraIndex < paraCount; paraIndex++) {
            findStartingField(paragraphList, paraIndex, result, option);
        }
    }

    private static void findStartingField(ParagraphListInterface paragraphList, int paraIndex, ArrayList<FieldData> results, Option option) throws StopFindException {
        Paragraph p = paragraphList.getParagraph(paraIndex);
        if (p.getControlList() == null) {
            return;
        }

        int ctrlCount = p.getControlList().size();
        for (int ctrlIndex = 0; ctrlIndex < ctrlCount; ctrlIndex++) {
            Control c = p.getControlList().get(ctrlIndex);
            if (c.isField()) {
                ControlField field = (ControlField) c;
                if (option.nameToFind() != null) {
                    if (option.nameToFind().equals(field.getName())) {
                        addStartingField(paragraphList, paraIndex, results, p, ctrlIndex, field);
                        if (option.onlyFirst()) {
                            throw new StopFindException();
                        }
                    }
                } else {
                    addStartingField(paragraphList, paraIndex, results, p, ctrlIndex, field);
                }
            }
        }
    }

    private static void addStartingField(ParagraphListInterface paragraphList, int paraIndex, ArrayList<FieldData> results, Paragraph p, int ctrlIndex, ControlField field) {
        FieldData fieldData = new FieldData(field.getName(),
                (field.getType() == ControlType.FIELD_CLICKHERE) ? FieldType.ClickHere : FieldType.ETC,
                null,
                paragraphList);
        fieldData.setStartPosition(paraIndex, p.getText().getCharIndexFromExtendCharIndex(ctrlIndex));

        results.add(fieldData);
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
        private boolean added;

        public Result() {
            fieldDataList = new ArrayList<>();
            formDataList = new ArrayList<>();
            added = false;
        }

        public void addFieldData(FieldData fieldData) {
            fieldDataList.add(fieldData);
            if (fieldData != null) {
                added = true;
            }
        }

        public void addAllFieldData(ArrayList<FieldData> fieldDataList) {
            this.fieldDataList.addAll(fieldDataList);
            if (fieldDataList.size() > 0) {
                added = true;
            }
        }

        public ArrayList<FieldData> getFieldDataList() {
            return fieldDataList;
        }

        public void addFormData(FormData formData) {
            formDataList.add(formData);
            if (formData != null) {
                added = true;
            }
        }

        public ArrayList<FormData> getFormDataList() {
            return formDataList;
        }

        public boolean added() {
            return added;
        }
    }

    public static class Option {
        private String nameToFind;
        private boolean onlyFirst;

        private boolean findField;
        private boolean findGso;
        private boolean findCell;
        private boolean findForm;

        public Option(String nameToFind, boolean onlyFirst, boolean findField, boolean findGso, boolean findCell, boolean findForm) {
            this.nameToFind = nameToFind;
            this.onlyFirst = onlyFirst;
            this.findField = findField;
            this.findGso = findGso;
            this.findCell = findCell;
            this.findForm = findForm;
        }

        public String nameToFind() {
            return nameToFind;
        }

        public void nameToFind(String nameToFind) {
            this.nameToFind = nameToFind;
        }

        public boolean onlyFirst() {
            return onlyFirst;
        }

        public void onlyFirst(boolean onlyFirst) {
            this.onlyFirst = onlyFirst;
        }

        public boolean findField() {
            return findField;
        }

        public void findField(boolean findField) {
            this.findField = findField;
        }

        public boolean findGso() {
            return findGso;
        }

        public void findGso(boolean findGso) {
            this.findGso = findGso;
        }

        public boolean findCell() {
            return findCell;
        }

        public void findCell(boolean findCell) {
            this.findCell = findCell;
        }

        public boolean findForm() {
            return findForm;
        }

        public void findForm(boolean findForm) {
            this.findForm = findForm;
        }
    }

    public static class StopFindException extends Exception {
    }
}
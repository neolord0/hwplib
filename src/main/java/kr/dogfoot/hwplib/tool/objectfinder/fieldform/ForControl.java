package kr.dogfoot.hwplib.tool.objectfinder.fieldform;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlForm;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.form.FormObjectType;
import kr.dogfoot.hwplib.object.bodytext.control.form.properties.PropertyNormal;
import kr.dogfoot.hwplib.object.bodytext.control.form.properties.PropertySet;
import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;

import java.util.ArrayList;

public class ForControl {
    public static void findInControlList(ArrayList<Control> controlList, FieldFormFinder.Result result, FieldFormFinder.Option option) throws FieldFormFinder.StopFindException {
        if (option.nameToFind() != null && option.onlyFirst() && result.added()) {
            throw new FieldFormFinder.StopFindException();
        }

        for (Control control : controlList) {
            findInControl(control, result, option);
        }
    }

    private static void findInControl(Control control, FieldFormFinder.Result result, FieldFormFinder.Option option) throws FieldFormFinder.StopFindException {
        switch (control.getType()) {
            case Table:
                findInTable((ControlTable) control, result, option);
                break;
            case Gso:
                findInGso((GsoControl) control, result, option);
                break;
            case Form:
                if (option.findForm()) {
                    findInForm((ControlForm) control, result, option);
                }
                break;
        }
    }

    private static void findInTable(ControlTable table, FieldFormFinder.Result result, FieldFormFinder.Option option) throws FieldFormFinder.StopFindException {
        for (Row row : table.getRowList()) {
            for (Cell cell : row.getCellList()) {
                if (option.findCell()) {
                    String fieldName = cell.getListHeader().getFieldName();
                    if (fieldName != null && fieldName.length() > 0) {
                        if (option.nameToFind() != null) {
                            if (option.nameToFind().equals(fieldName)) {
                                result.addFieldData(fieldDataForAllParagraphs(fieldName, FieldType.Cell, cell.getParagraphList()));
                                if (option.onlyFirst()) {
                                    throw new FieldFormFinder.StopFindException();
                                }
                            }
                        } else {
                            result.addFieldData(fieldDataForAllParagraphs(fieldName, FieldType.Cell, cell.getParagraphList()));
                        }
                    }
                }

                FieldFormFinder.findInParagraphList(cell.getParagraphList(), result, option);
            }
        }
    }

    private static FieldData fieldDataForAllParagraphs(String fieldName, FieldType fieldType, ParagraphList paragraphList) {
        FieldData fieldData = new FieldData(fieldName, fieldType, paragraphList);
        fieldData.setStartPosition(0, 0);
        fieldData.setEndPosition(paragraphList.getParagraphCount() - 1, 0xffff);
        return fieldData;
    }

    private static void findInGso(GsoControl control, FieldFormFinder.Result result, FieldFormFinder.Option option) throws FieldFormFinder.StopFindException {
        switch (control.getGsoType()) {
            case Rectangle:
                findInTextBox(((ControlRectangle) control).getTextBox(), result, option);
                break;
            case Ellipse:
                findInTextBox(((ControlEllipse) control).getTextBox(), result, option);
                break;
            case Arc:
                findInTextBox(((ControlArc) control).getTextBox(), result, option);
                break;
            case Polygon:
                findInTextBox(((ControlPolygon) control).getTextBox(), result, option);
                break;
            case Curve:
                findInTextBox(((ControlCurve) control).getTextBox(), result, option);
                break;
            case Container:
                findInContainer((ControlContainer) control, result, option);
                break;
        }
    }

    private static void findInTextBox(TextBox textBox, FieldFormFinder.Result result, FieldFormFinder.Option option) throws FieldFormFinder.StopFindException {
        if (option.findGso()) {
            String fieldName = textBox.getListHeader().getFieldName();
            if (fieldName != null && fieldName.length() > 0) {
                if (option.nameToFind() != null) {
                    if (option.nameToFind().equals(fieldName)) {
                        result.addFieldData(fieldDataForAllParagraphs(fieldName, FieldType.Gso, textBox.getParagraphList()));
                        if (option.onlyFirst()) {
                            throw new FieldFormFinder.StopFindException();
                        }
                    }
                } else {
                    result.addFieldData(fieldDataForAllParagraphs(fieldName, FieldType.Gso, textBox.getParagraphList()));
                }

            }
        }

        FieldFormFinder.findInParagraphList(textBox.getParagraphList(), result, option);
    }

    private static void findInContainer(ControlContainer container, FieldFormFinder.Result result, FieldFormFinder.Option option) throws FieldFormFinder.StopFindException {
        for (Control childControl : container.getChildControlList()) {
            findInControl(childControl, result, option);
        }
    }

    private static void findInForm(ControlForm form, FieldFormFinder.Result result, FieldFormFinder.Option option) throws FieldFormFinder.StopFindException {
        if (form.getFormObject().getType() == FormObjectType.RadioButton ||
                form.getFormObject().getType() == FormObjectType.CheckBox) {
            PropertySet commonSet = (PropertySet) form.getFormObject().getProperties().getProperty("CommonSet");
            PropertyNormal name = (PropertyNormal) commonSet.getProperty("Name");

            PropertySet buttonSet = (PropertySet) form.getFormObject().getProperties().getProperty("ButtonSet");
            PropertyNormal value = (PropertyNormal) buttonSet.getProperty("Value");

            if (option.nameToFind() != null) {
                if (option.nameToFind().equals(name.getValue())) {
                    result.addFormData(new FormData(name.getValue(), form.getFormObject().getType(), value.getValue()));
                    if (option.onlyFirst()) {
                        throw new FieldFormFinder.StopFindException();
                    }
                }
            } else {
                result.addFormData(new FormData(name.getValue(), form.getFormObject().getType(), value.getValue()));
            }
        }
    }
}

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

import java.text.Normalizer;
import java.util.ArrayList;

public class ForControl {
    public static void findInControlList(ArrayList<Control> controlList, FieldFormFinder.Result result) {
        for (Control control : controlList) {
            findInControl(control, result);
        }
    }

    private static void findInControl(Control control, FieldFormFinder.Result result) {
        switch (control.getType()) {
            case Table:
                findInTable((ControlTable) control, result);
                break;
            case Gso:
                findInGso((GsoControl) control, result);
                break;
            case Form:
                findInForm((ControlForm) control, result);
                break;
        }
    }

    private static void findInTable(ControlTable table, FieldFormFinder.Result result) {
        for (Row row : table.getRowList()) {
            for (Cell cell : row.getCellList()) {
                String fieldName = cell.getListHeader().getFieldName();
                if (fieldName != null && fieldName.length() > 0) {
                    result.addFieldData(fieldDataForAllParagraphs(fieldName, FieldData.FieldType.Cell, cell.getParagraphList()));
                }

                FieldFormFinder.findInParagraphList(cell.getParagraphList(), result);
            }
        }
    }

    private static FieldData fieldDataForAllParagraphs(String fieldName, FieldData.FieldType fieldType, ParagraphList paragraphList) {
        FieldData fieldData = new FieldData(fieldName, fieldType, paragraphList);
        fieldData.setStartPosition(0, -1);
        fieldData.setEndPosition(paragraphList.getParagraphCount() - 1, 0xffff);
        return fieldData;
    }

    private static void findInGso(GsoControl control, FieldFormFinder.Result result) {
        switch (control.getGsoType()) {
            case Rectangle:
                findInTextBox(((ControlRectangle) control).getTextBox(), result);
                break;
            case Ellipse:
                findInTextBox(((ControlEllipse) control).getTextBox(), result);
                break;
            case Arc:
                findInTextBox(((ControlArc) control).getTextBox(), result);
                break;
            case Polygon:
                findInTextBox(((ControlPolygon) control).getTextBox(), result);
                break;
            case Curve:
                findInTextBox(((ControlCurve) control).getTextBox(), result);
                break;
            case Container:
                findInContainer((ControlContainer) control ,result);
                break;
        }
    }

    private static void findInTextBox(TextBox textBox, FieldFormFinder.Result result) {
        String fieldName = textBox.getListHeader().getFieldName();
        if (fieldName != null && fieldName.length() > 0) {
            result.addFieldData(fieldDataForAllParagraphs(fieldName, FieldData.FieldType.Gso, textBox.getParagraphList()));
        }

        FieldFormFinder.findInParagraphList(textBox.getParagraphList(), result);
    }

    private static void findInContainer(ControlContainer container, FieldFormFinder.Result result) {
        for (Control childControl : container.getChildControlList()) {
            findInControl(childControl, result);
        }
    }

    private static void findInForm(ControlForm form, FieldFormFinder.Result result) {
        if (form.getFormObject().getType() == FormObjectType.RadioButton ||
                form.getFormObject().getType() == FormObjectType.CheckBox) {
            PropertySet commonSet = (PropertySet) form.getFormObject().getProperties().getProperty("CommonSet");
            PropertyNormal name = (PropertyNormal) commonSet.getProperty("Name");

            PropertySet buttonSet = (PropertySet) form.getFormObject().getProperties().getProperty("ButtonSet");
            PropertyNormal value = (PropertyNormal) buttonSet.getProperty("Value");

            result.addFormData(new FormData(name.getValue(), form.getFormObject().getType(), value.getValue()));
        }
    }
}



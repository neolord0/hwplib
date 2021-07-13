package kr.dogfoot.hwplib.tool.objectfinder.fieldfiner;

import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.gso.*;
import kr.dogfoot.hwplib.object.bodytext.control.gso.textbox.TextBox;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.object.bodytext.paragraph.ParagraphList;

import java.util.ArrayList;

public class ForControl {
    public static void findInControlList(ArrayList<Control> controlList, ArrayList<FieldFinder.FieldData> result) {
        for (Control control : controlList) {
            findInControl(control, result);
        }
    }

    private static void findInControl(Control control, ArrayList<FieldFinder.FieldData> result) {
        switch (control.getType()) {
            case Table:
                findInTable((ControlTable) control, result);
                break;
            case Gso:
                findInGso((GsoControl) control, result);
                break;
        }
    }

    private static void findInTable(ControlTable table, ArrayList<FieldFinder.FieldData> result) {
        for (Row row : table.getRowList()) {
            for (Cell cell : row.getCellList()) {
                String fieldName = cell.getListHeader().getFieldName();
                if (fieldName != null && fieldName.length() > 0) {
                    result.add(fieldDataForAllParagraphs(fieldName, FieldFinder.FieldType.Cell, cell.getParagraphList()));
                }

                FieldFinder.findInParagraphList(cell.getParagraphList(), result);
            }
        }
    }

    private static FieldFinder.FieldData fieldDataForAllParagraphs(String fieldName, FieldFinder.FieldType fieldType, ParagraphList paragraphList) {
        FieldFinder.FieldData fieldData = new FieldFinder.FieldData(fieldName, fieldType, paragraphList);
        fieldData.setStartPosition(0, -1);
        fieldData.setEndPosition(paragraphList.getParagraphCount() - 1, 0xffff);
        return fieldData;
    }


    private static void findInGso(GsoControl control, ArrayList<FieldFinder.FieldData> result) {
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

    private static void findInTextBox(TextBox textBox, ArrayList<FieldFinder.FieldData> result) {
        String fieldName = textBox.getListHeader().getFieldName();
        if (fieldName != null && fieldName.length() > 0) {
            result.add(fieldDataForAllParagraphs(fieldName, FieldFinder.FieldType.Gso, textBox.getParagraphList()));
        }

        FieldFinder.findInParagraphList(textBox.getParagraphList(), result);
    }

    private static void findInContainer(ControlContainer container, ArrayList<FieldFinder.FieldData> result) {
        for (Control childControl : container.getChildControlList()) {
            findInControl(childControl, result);
        }
    }
}

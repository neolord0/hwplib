package kr.dogfoot.hwplib.tool.paragraphadder.control;

import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterItem;
import kr.dogfoot.hwplib.object.bodytext.control.bookmark.ParameterSet;
import kr.dogfoot.hwplib.tool.paragraphadder.docinfo.DocInfoAdder;

public class ParameterSetCopier {
    public static void copy(ParameterSet source, ParameterSet target, DocInfoAdder docInfoAdder) {
        target.setId(source.getId());

        for (ParameterItem item : source.getParameterItemList()) {
            copyItem(item, target.addNewParameterItem(), docInfoAdder);
        }
    }

    private static void copyItem(ParameterItem source, ParameterItem target, DocInfoAdder docInfoAdder) {
        target.setId(source.getId());
        target.setType(source.getType());
        switch (source.getType()) {
            case NULL:
                break;
            case String:
                target.setValue_BSTR(source.getValue_BSTR());
                break;
            case Integer1:
                target.setValue_I1(source.getValue_I1());
                break;
            case Integer2:
                target.setValue_I2(source.getValue_I2());
                break;
            case Integer4:
                target.setValue_I4(source.getValue_I4());
                break;
            case Integer:
                target.setValue_I(source.getValue_I());
                break;
            case UnsignedInteger1:
                target.setValue_UI1(source.getValue_UI1());
                break;
            case UnsignedInteger2:
                target.setValue_UI2(source.getValue_UI2());
                break;
            case UnsignedInteger4:
                target.setValue_UI4(source.getValue_UI4());
                break;
            case UnsignedInteger:
                target.setValue_UI(source.getValue_UI());
                break;
            case ParameterSet:
                parameterSet(source, target, docInfoAdder);
                break;
            case Array:
                array(source, target, docInfoAdder);
                break;
            case BINDataID:
                target.setValue_binData(docInfoAdder.forBinData().processById(source.getValue_binData()));
                break;
        }
    }

    private static void array(ParameterItem source, ParameterItem target, DocInfoAdder docInfoAdder) {
        int count = source.getValue_ParameterArrayCount();
        if (count == 0) {
            return;
        }

        target.createValue_ParameterArray(count);
        for (int index = 0; index < count; index++) {
            copyItem(source.getValue_ParameterArray(index), target.getValue_ParameterArray(index), docInfoAdder);
        }
    }

    private static void parameterSet(ParameterItem source, ParameterItem target, DocInfoAdder docInfoAdder) {
        if (source.getValue_ParameterSet() == null) {
            return;
        }

        target.createValue_ParameterSet();
        copy(source.getValue_ParameterSet(), target.getValue_ParameterSet(), docInfoAdder);
    }
}

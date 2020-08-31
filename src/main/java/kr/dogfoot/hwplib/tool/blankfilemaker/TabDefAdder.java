package kr.dogfoot.hwplib.tool.blankfilemaker;

import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.docinfo.TabDef;

public class TabDefAdder {
    public static void add(DocInfo docInfo) {
        tabDef1(docInfo.addNewTabDef());
        tabDef2(docInfo.addNewTabDef());
    }

    private static void tabDef1(TabDef tabDef) {
        tabDef.getProperty().setValue(0);
    }

    private static void tabDef2(TabDef tabDef) {
        tabDef.getProperty().setValue(1);
    }
}

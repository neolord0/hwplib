package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.bindata.EmbeddedBinaryData;

import java.util.ArrayList;

/**
 * DocInfo에 EmbeddedBinaryData을 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class ForEmbeddedBinaryData {
    public static int addAndCopy(int sourceId, String imageFileExt, DocInfoAdder docInfoAdder) {
        EmbeddedBinaryData source = findByName(docInfoAdder.getSourceHWPFile().getBinData().getEmbeddedBinaryDataList(), name(sourceId, imageFileExt));
        if (source != null) {
            EmbeddedBinaryData target = docInfoAdder.getTargetHWPFile().getBinData().addNewEmbeddedBinaryData();
            int targetID = docInfoAdder.getTargetHWPFile().getBinData().getEmbeddedBinaryDataList().size();
            target.setName(name(targetID, imageFileExt));
            target.setData(source.getData());
            target.setCompressMethod(source.getCompressMethod());
            return docInfoAdder.getTargetHWPFile().getBinData().getEmbeddedBinaryDataList().size();
        } else {
            return -1;
        }
    }

    private static EmbeddedBinaryData findByName(ArrayList<EmbeddedBinaryData> embeddedBinaryDataList, String name) {
        for (EmbeddedBinaryData embeddedBinaryData : embeddedBinaryDataList) {
            if (embeddedBinaryData.getName().equalsIgnoreCase(name)) {
                return embeddedBinaryData;
            }
        }
        return null;
    }

    private static String name(int binDataID, String imageFileExt) {
        return "Bin" + String.format("%04X", binDataID) + "." + imageFileExt;
    }

}

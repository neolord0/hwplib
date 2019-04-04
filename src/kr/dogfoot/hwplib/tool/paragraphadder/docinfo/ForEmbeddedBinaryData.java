package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.bindata.EmbeddedBinaryData;

/**
 * DocInfo에 EmbeddedBinaryData을 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class ForEmbeddedBinaryData {
    public static int addAndCopy(int sourceId, DocInfoAdder docInfoAdder) {
        EmbeddedBinaryData source = docInfoAdder.getSourceHWPFile().getBinData().getEmbeddedBinaryDataList().get(sourceId);
        EmbeddedBinaryData target = docInfoAdder.getTargetHWPFile().getBinData().addNewEmbeddedBinaryData();

        target.setName(source.getName());
        target.setData(source.getData());

        return docInfoAdder.getTargetHWPFile().getBinData().getEmbeddedBinaryDataList().size() - 1;
    }
}

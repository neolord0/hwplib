package kr.dogfoot.hwplib.tool.paragraphadder.docinfo;

import kr.dogfoot.hwplib.object.docinfo.BinData;

/**
 * DocInfo에 BinData를 복사하는 기능을 포함하는 클레스
 *
 * @author neolord
 */
public class BinDataAdder {
    /**
     * docInfo에 포함된 객체들의 추가를 위한 클래스 인스턴스
     */
    private DocInfoAdder docInfoAdder;

    /**
     * 생성자
     *
     * @param docInfoAdder docInfo에 포함된 객체들의 추가를 위한 클래스 인스턴스
     */
    public BinDataAdder(DocInfoAdder docInfoAdder) {
        this.docInfoAdder = docInfoAdder;
    }

    /**
     * sourceID에 해당하는 BinData객체를 처리하여 target 한긒 파일의 BinData ID를 반환한다.
     *
     * @param sourceID source BinData ID.
     * @return target한글 파일의 BinData ID
     */
    public int processById(int sourceID) {
        BinData source = docInfoAdder.getSourceHWPFile().getDocInfo().getBinDataList().get(sourceID);
        return addAndCopy(source);
    }

    /**
     * source BinData객체 를 복사하여 target 한긒 파일에 추가한다.
     *
     * @param source source BinData객체
     * @return target한글 파일의 BinData ID
     */
    private int addAndCopy(BinData source) {
        BinData target = docInfoAdder.getTargetHWPFile().getDocInfo().addNewBinData();
        target.getProperty().setValue(source.getProperty().getValue());
        target.setAbsolutePathForLink(source.getAbsolutePathForLink());
        target.setRelativePathForLink(source.getRelativePathForLink());
        target.setBinDataID(ForEmbeddedBinaryData.addAndCopy(source.getBinDataID(), docInfoAdder));
        target.setExtensionForEmbedding(source.getExtensionForEmbedding());

        return docInfoAdder.getTargetHWPFile().getDocInfo().getBinDataList().size() - 1;
    }
}

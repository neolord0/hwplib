package kr.dogfoot.hwplib.writer.autosetter;

import kr.dogfoot.hwplib.object.bodytext.BodyText;
import kr.dogfoot.hwplib.object.docinfo.DocInfo;
import kr.dogfoot.hwplib.object.docinfo.DocumentPropeties;
import kr.dogfoot.hwplib.object.docinfo.IDMappings;

/**
 * DocInfo 스트림을 쓰기 전에 자동 설정하기 위한 객체
 *
 * @author neolord
 */
public class ForDocInfo {
    /**
     * DocInfo 스트림을 자동 설정한다.
     *
     * @param di DocInfo 스트림 객체
     * @param bt BodyText 스토리지 객체
     */
    public static void autoset(DocInfo di, BodyText bt) {
        documentProperties(di.getDocumentProperties(), bt);
        idMappings(di.getIDMappings(), di);
    }

    /**
     * 문서 속성 레코드를 자동 설정한다.
     *
     * @param dp 문서 속성 레코드
     * @param bt BodyText 스토리지 객체
     */
    private static void documentProperties(DocumentPropeties dp, BodyText bt) {
        dp.setSectionCount(bt.getSectionList().size());
    }

    /**
     * 아이디 매핑 레코드를 자동 설정한다.
     *
     * @param im 아이디 매핑 레코드
     * @param di DocInfo 스트림 객체
     */
    private static void idMappings(IDMappings im, DocInfo di) {
        im.setBinDataCount(di.getBinDataList().size());
        im.setHangulFaceNameCount(di.getHangulFaceNameList().size());
        im.setEnglishFaceNameCount(di.getEnglishFaceNameList().size());
        im.setHanjaFaceNameCount(di.getHanjaFaceNameList().size());
        im.setJapaneseFaceNameCount(di.getJapaneseFaceNameList().size());
        im.setEtcFaceNameCount(di.getEtcFaceNameList().size());
        im.setSymbolFaceNameCount(di.getSymbolFaceNameList().size());
        im.setUserFaceNameCount(di.getUserFaceNameList().size());
        im.setBorderFillCount(di.getBorderFillList().size());
        im.setCharShapeCount(di.getCharShapeList().size());
        im.setTabDefCount(di.getTabDefList().size());
        im.setNumberingCount(di.getNumberingList().size());
        im.setBulletCount(di.getBulletList().size());
        im.setParaShapeCount(di.getParaShapeList().size());
        im.setStyleCount(di.getStyleList().size());
        im.setMemoShapeCount(di.getMemoShapeList().size());
        im.setTrackChangeCount(di.getTrackChange2List().size());
        im.setTrackChangeAuthorCount(di.getTrackChangeAuthorList().size());
    }
}

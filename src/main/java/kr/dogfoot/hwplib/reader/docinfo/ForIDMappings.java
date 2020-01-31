package kr.dogfoot.hwplib.reader.docinfo;

import kr.dogfoot.hwplib.object.docinfo.IDMappings;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 아이디 매핑 레코드를 읽기 위한 객체
 *
 * @author neolord
 */
public class ForIDMappings {
    /**
     * 아이디 매핑 레코드를 읽는다.
     *
     * @param idm 아이디 매핑 레코드
     * @param sr  스트림 리더
     * @throws IOException
     */
    public static void read(IDMappings idm, StreamReader sr) throws IOException {
        idm.setBinDataCount(sr.readSInt4());            // 0
        idm.setHangulFaceNameCount(sr.readSInt4());    // 1
        idm.setEnglishFaceNameCount(sr.readSInt4());    // 2
        idm.setHanjaFaceNameCount(sr.readSInt4());        // 3
        idm.setJapaneseFaceNameCount(sr.readSInt4());    // 4
        idm.setEtcFaceNameCount(sr.readSInt4());        // 5
        idm.setSymbolFaceNameCount(sr.readSInt4());    // 6
        idm.setUserFaceNameCount(sr.readSInt4());        // 7
        idm.setBorderFillCount(sr.readSInt4());        // 8
        idm.setCharShapeCount(sr.readSInt4());            // 9
        idm.setTabDefCount(sr.readSInt4());            // 10
        idm.setNumberingCount(sr.readSInt4());            // 11
        idm.setBulletCount(sr.readSInt4());            // 12
        idm.setParaShapeCount(sr.readSInt4());            // 13
        idm.setStyleCount(sr.readSInt4());                // 14

        if (sr.isEndOfRecord() == false && sr.getFileVersion().isOver(5, 0, 2, 1)) {
            idm.setMemoShapeCount(sr.readSInt4());            // 15
        }

        if (sr.isEndOfRecord() == false && sr.getFileVersion().isOver(5, 0, 3, 2)) {
            idm.setTrackChangeCount(sr.readSInt4());        // 16
            idm.setTrackChangeAuthorCount(sr.readSInt4());    // 17
        }
    }
}

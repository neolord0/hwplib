package kr.dogfoot.hwplib.writer.docinfo;

import kr.dogfoot.hwplib.object.docinfo.*;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.object.etc.UnknownRecord;
import kr.dogfoot.hwplib.util.compoundFile.writer.StreamWriter;
import kr.dogfoot.hwplib.writer.ForUnknown;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 문서 정보(DocInfo) 스트림을 쓰기 위한 객체
 *
 * @author 박성균
 */
public class ForDocInfo {
    /**
     * 문서 정보 객체
     */
    private DocInfo docInfo;
    /**
     * 스트림 라이터
     */
    private StreamWriter sw;

    /**
     * 생성자
     */
    public ForDocInfo() {
    }

    /**
     * 문서 정보(DocInfo) 스트림을 쓴다.
     *
     * @param docInfo 문서 정보 객체
     * @param sw      스트림 라이터
     * @throws Exception
     */
    public void write(DocInfo docInfo, StreamWriter sw) throws Exception {
        this.docInfo = docInfo;
        this.sw = sw;

        documentProerties();
        idMappings();

        sw.upRecordLevel();

        binData();
        faceName();
        borderFill();
        charShape();
        tabDef();
        numbering();
        bullet();
        paraShape();
        style();

        sw.downRecordLevel();

        docData();

        sw.upRecordLevel();

        forbiddenChar();

        sw.downRecordLevel();

        distributeDocData();
        compatibleDocument();

        sw.upRecordLevel();

        layoutCompatibility();
        trackChange();
        memoShape();
        trackChange2();
        trackChangeAuthor();

        sw.downRecordLevel();
    }

    /**
     * 문서 속성 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void documentProerties() throws IOException {
        DocumentPropeties dp = docInfo.getDocumentProperties();
        if (dp == null) {
            return;
        }
        ForDocumentProperties.write(dp, sw);
    }

    /**
     * 아이디 매핑 헤더 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void idMappings() throws IOException {
        IDMappings im = docInfo.getIDMappings();
        if (im == null) {
            return;
        }
        ForIDMappings.write(im, sw);
    }

    /**
     * 바이너리 데이터 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void binData() throws IOException {
        for (BinData bd : docInfo.getBinDataList()) {
            ForBinData.write(bd, sw);
        }
    }

    /**
     * 글꼴 레코드들을 쓴다.
     *
     * @throws IOException
     */
    private void faceName() throws IOException {
        faceNameList(docInfo.getHangulFaceNameList());
        faceNameList(docInfo.getEnglishFaceNameList());
        faceNameList(docInfo.getHanjaFaceNameList());
        faceNameList(docInfo.getJapaneseFaceNameList());
        faceNameList(docInfo.getEtcFaceNameList());
        faceNameList(docInfo.getSymbolFaceNameList());
        faceNameList(docInfo.getUserFaceNameList());
    }

    /**
     * 글꼴 리스트를 쓴다.
     *
     * @param faceNameList 글꼴 리스트
     * @throws IOException
     */
    private void faceNameList(ArrayList<FaceName> faceNameList)
            throws IOException {
        for (FaceName fa : faceNameList) {
            ForFaceName.write(fa, sw);
        }
    }

    /**
     * 테두리/배경 레코드들을 쓴다.
     *
     * @throws IOException
     */
    private void borderFill() throws IOException {
        for (BorderFill bf : docInfo.getBorderFillList()) {
            ForBorderFill.write(bf, sw);
        }
    }

    /**
     * 글자 모양 레코드들을 쓴다.
     *
     * @throws IOException
     */
    private void charShape() throws IOException {
        for (CharShape cs : docInfo.getCharShapeList()) {
            ForCharShape.write(cs, sw);
        }
    }

    /**
     * 탭 정의 레코드들을 쓴다.
     *
     * @throws IOException
     */
    private void tabDef() throws IOException {
        for (TabDef td : docInfo.getTabDefList()) {
            ForTabDef.write(td, sw);
        }
    }

    /**
     * 문단 번호 레코드들을 쓴다.
     *
     * @throws Exception
     */
    private void numbering() throws Exception {
        for (Numbering n : docInfo.getNumberingList()) {
            ForNumbering.write(n, sw);
        }
    }

    /**
     * 글머리표 레코드들을 쓴다.
     *
     * @throws IOException
     */
    private void bullet() throws IOException {
        for (Bullet b : docInfo.getBulletList()) {
            ForBullet.write(b, sw);
        }
    }

    /**
     * 문단 모양 레코드들을 쓴다.
     *
     * @throws IOException
     */
    private void paraShape() throws IOException {
        for (ParaShape ps : docInfo.getParaShapeList()) {
            ForParaShape.write(ps, sw);
        }
    }

    /**
     * 스타일 레코드들을 쓴다.
     *
     * @throws IOException
     */
    private void style() throws IOException {
        for (Style s : docInfo.getStyleList()) {
            ForStyle.write(s, sw);
        }
    }

    /**
     * 문서 임의의 데이터 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void docData() throws IOException {
        if (docInfo.getDocData() != null) {
            ForUnknown.write(docInfo.getDocData(), HWPTag.DOC_DATA, sw);
        }
    }

    /**
     * 금칙처리 문자 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void forbiddenChar() throws IOException {
        if (docInfo.getForbiddenChar() != null) {
            ForUnknown.write(docInfo.getForbiddenChar(), HWPTag.FORBIDDEN_CHAR,
                    sw);
        }
    }

    /**
     * 배포용 문서 데이터 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void distributeDocData() throws IOException {
        if (docInfo.getDistributeDocData() != null) {
            ForUnknown.write(docInfo.getDistributeDocData(),
                    HWPTag.DISTRIBUTE_DOC_DATA, sw);
        }
    }

    /**
     * 호환 문서 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void compatibleDocument() throws IOException {
        if (docInfo.getCompatibleDocument() != null) {
            ForCompatibleDocument.write(docInfo.getCompatibleDocument(), sw);
        }
    }

    /**
     * 레이아웃 호환성 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void layoutCompatibility() throws IOException {
        if (docInfo.getLayoutCompatibility() != null) {
            ForLayoutCompatibility.write(docInfo.getLayoutCompatibility(), sw);
        }
    }

    /**
     * 변경 추적 정보 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void trackChange() throws IOException {
        if (docInfo.getTrackChange() != null) {
            ForUnknown.write(docInfo.getTrackChange(), HWPTag.TRACKCHANGE, sw);
        }
    }

    /**
     * 메모 모양 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void memoShape() throws IOException {
        for (UnknownRecord memoShape : docInfo.getMemoShapeList()) {
            ForUnknown.write(memoShape, HWPTag.MEMO_SHAPE, sw);
        }
    }

    /**
     * 변경 추적 내용 및 모양 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void trackChange2() throws IOException {
        for (UnknownRecord trackChange2 : docInfo.getTrackChange2List()) {
            ForUnknown.write(trackChange2, HWPTag.TRACK_CHANGE, sw);
        }
    }

    /**
     * 변경 추적 작성자 레코드를 쓴다.
     *
     * @throws IOException
     */
    private void trackChangeAuthor() throws IOException {
        for (UnknownRecord trackChangeAuthor : docInfo
                .getTrackChangeAuthorList()) {
            ForUnknown.write(trackChangeAuthor, HWPTag.TRACK_CHANGE_AUTHOR, sw);
        }
    }
}

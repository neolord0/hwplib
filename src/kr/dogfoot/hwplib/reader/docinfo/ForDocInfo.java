package kr.dogfoot.hwplib.reader.docinfo;

import kr.dogfoot.hwplib.object.docinfo.*;
import kr.dogfoot.hwplib.object.etc.HWPTag;
import kr.dogfoot.hwplib.object.etc.UnknownRecord;
import kr.dogfoot.hwplib.reader.ForUnknown;
import kr.dogfoot.hwplib.util.compoundFile.reader.StreamReader;

import java.io.IOException;

/**
 * 문서 정보(DocInfo) 스트림을 읽기 위한 객체
 *
 * @author neolord
 */
public class ForDocInfo {
    /**
     * 문서 정보 스트림을 나타내는 객체
     */
    private DocInfo docInfo;
    /**
     * 스트림 리더
     */
    private StreamReader sr;

    /**
     * 생성자
     */
    public ForDocInfo() {
    }

    /**
     * 문서 정보(DocInfo) 스트림를 읽는다.
     *
     * @param di 문서 정보 스트림을 나타내는 객체
     * @param sr 스트림 리더
     * @throws Exception
     */
    public void read(DocInfo di, StreamReader sr) throws Exception {
        this.sr = sr;
        this.docInfo = di;

        while (sr.isEndOfStream() == false) {
            sr.readRecordHeder();
            recordBody();
        }
    }

    /**
     * 이미 읽은 레코드 헤더에 따른 레코드 내용을 읽는다.
     *
     * @throws Exception
     */
    private void recordBody() throws Exception {
        switch (sr.getCurrentRecordHeader().getTagID()) {
            case HWPTag.DOCUMENT_PROPERTIES:
                documentProerties(docInfo.getDocumentProperties());
                break;
            case HWPTag.ID_MAPPINGS:
                idMappings(docInfo.getIDMappings());
                break;
            case HWPTag.BIN_DATA:
                binData();
                break;
            case HWPTag.FACE_NAME:
                faceName();
                break;
            case HWPTag.BORDER_FILL:
                borderFill();
                break;
            case HWPTag.CHAR_SHAPE:
                charShape();
                break;
            case HWPTag.TAB_DEF:
                tabDef();
                break;
            case HWPTag.NUMBERING:
                numbering();
                break;
            case HWPTag.BULLET:
                bullet();
                break;
            case HWPTag.PARA_SHAPE:
                paraShape();
                break;
            case HWPTag.STYLE:
                style();
                break;
            case HWPTag.DOC_DATA:
                docData();
                break;
            case HWPTag.FORBIDDEN_CHAR:
                forbiddenChar();
                break;
            case HWPTag.DISTRIBUTE_DOC_DATA:
                distributeDocData();
                break;
            case HWPTag.COMPATIBLE_DOCUMENT:
                compatibleDocument();
                break;
            case HWPTag.LAYOUT_COMPATIBILITY:
                layoutCompatibility();
                break;
            case HWPTag.TRACKCHANGE:
                trackChange();
                break;
            case HWPTag.MEMO_SHAPE:
                memoShape();
                break;
            case HWPTag.TRACK_CHANGE:
                trackChange2();
                break;
            case HWPTag.TRACK_CHANGE_AUTHOR:
                trackChangeAuthor();
                break;
        }
    }

    /**
     * 문서 속성 레코드를 읽는다.
     *
     * @param dp 읽은 내용을 저장할 객체
     * @throws IOException
     */
    private void documentProerties(DocumentPropeties dp) throws IOException {
        ForDocumentPropeties.read(dp, sr);
    }

    /**
     * 아이디 매핑 헤더 레코드를 읽는다.
     *
     * @param im 읽은 내용을 저장할 객체
     * @throws IOException
     */
    private void idMappings(IDMappings im) throws IOException {
        ForIDMappings.read(im, sr);
    }

    /**
     * 바이너리 데이터 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void binData() throws IOException {
        BinData bd = docInfo.addNewBinData();
        ForBinData.read(bd, sr);
    }

    /**
     * 글꼴 레코드를 읽는다.
     *
     * @throws Exception
     */
    private void faceName() throws Exception {
        FaceName fn = new FaceName();
        ForFaceName.read(fn, sr);
        addFaceNameByIDMappings(fn);
    }

    /**
     * 글꼴 레코드 객체를 아이디 매핑 레코드의 글꼴 개수에 따라 추가한다.
     *
     * @param fn 글꼴 레코드 객체
     * @throws Exception
     */
    private void addFaceNameByIDMappings(FaceName fn) throws Exception {
        IDMappings idm = docInfo.getIDMappings();
        if (docInfo.getHangulFaceNameList().size() < idm
                .getHangulFaceNameCount()) {
            docInfo.getHangulFaceNameList().add(fn);
        } else if (docInfo.getEnglishFaceNameList().size() < idm
                .getEnglishFaceNameCount()) {
            docInfo.getEnglishFaceNameList().add(fn);
        } else if (docInfo.getHanjaFaceNameList().size() < idm
                .getHanjaFaceNameCount()) {
            docInfo.getHanjaFaceNameList().add(fn);
        } else if (docInfo.getJapaneseFaceNameList().size() < idm
                .getJapaneseFaceNameCount()) {
            docInfo.getJapaneseFaceNameList().add(fn);
        } else if (docInfo.getEtcFaceNameList().size() < idm
                .getEtcFaceNameCount()) {
            docInfo.getEtcFaceNameList().add(fn);
        } else if (docInfo.getSymbolFaceNameList().size() < idm
                .getSymbolFaceNameCount()) {
            docInfo.getSymbolFaceNameList().add(fn);
        } else if (docInfo.getUserFaceNameList().size() < idm
                .getUserFaceNameCount()) {
            docInfo.getUserFaceNameList().add(fn);
        } else {
            throw new Exception("Count of FaceName is greater than ID Mappings");
        }
    }

    /**
     * 테두리/배경 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void borderFill() throws IOException {
        BorderFill bf = docInfo.addNewBorderFill();
        ForBorderFill.read(bf, sr);
    }

    /**
     * 글자 모양 레코드를 읽는다.
     *
     * @throws Exception
     */
    private void charShape() throws Exception {
        CharShape cs = docInfo.addNewCharShape();
        ForCharShape.read(cs, sr);
    }

    /**
     * 탭 정의 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void tabDef() throws IOException {
        TabDef td = docInfo.addNewTabDef();
        ForTabDef.read(td, sr);
    }

    /**
     * 문단 번호 레코드를 읽는다.
     *
     * @throws Exception
     */
    private void numbering() throws Exception {
        Numbering n = docInfo.addNewNumbering();
        ForNumbering.read(n, sr);
    }

    /**
     * 글머리표 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void bullet() throws IOException {
        Bullet b = docInfo.addNewBullet();
        ForBullet.read(b, sr);
    }

    /**
     * 문단 모양 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void paraShape() throws IOException {
        ParaShape ps = docInfo.addNewParaShape();
        ForParaShape.read(ps, sr);
    }

    /**
     * 스타일 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void style() throws IOException {
        Style s = docInfo.addNewStyle();
        ForStyle.read(s, sr);
    }

    /**
     * 문서 임의의 데이터 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void docData() throws IOException {
        docInfo.createDocData(sr.getCurrentRecordHeader());
        ForUnknown.read(docInfo.getDocData(), sr);
    }

    /**
     * 배포용 문서 데이터 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void distributeDocData() throws IOException {
        docInfo.createDistributeDocData(sr.getCurrentRecordHeader());
        ForUnknown.read(docInfo.getDistributeDocData(), sr);
    }

    /**
     * 호환 문서 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void compatibleDocument() throws IOException {
        docInfo.createCompatibleDocument();
        ForCompatibleDocument.read(docInfo.getCompatibleDocument(), sr);
    }

    /**
     * 레이아웃 호환성 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void layoutCompatibility() throws IOException {
        docInfo.createLayoutCompatibility();
        ForLayoutCompatibility.read(docInfo.getLayoutCompatibility(), sr);
    }

    /**
     * 변경 추적 정보 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void trackChange() throws IOException {
        docInfo.createTrackChange(sr.getCurrentRecordHeader());
        ForUnknown.read(docInfo.getTrackChange(), sr);
    }

    /**
     * 메모 모양 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void memoShape() throws IOException {
        UnknownRecord ur = docInfo.addNewMemoShape(sr.getCurrentRecordHeader());
        ForUnknown.read(ur, sr);
    }

    /**
     * 금칙처리 문자 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void forbiddenChar() throws IOException {
        docInfo.createForbiddenChar(sr.getCurrentRecordHeader());
        ForUnknown.read(docInfo.getForbiddenChar(), sr);
    }

    /**
     * 변경 추적 내용 및 모양 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void trackChange2() throws IOException {
        UnknownRecord ur = docInfo.addNewTrackChange2(sr
                .getCurrentRecordHeader());
        ForUnknown.read(ur, sr);
    }

    /**
     * 변경 추적 작성자 레코드를 읽는다.
     *
     * @throws IOException
     */
    private void trackChangeAuthor() throws IOException {
        UnknownRecord ur = docInfo.addNewTrackChangeAuthor(sr
                .getCurrentRecordHeader());
        ForUnknown.read(ur, sr);
    }
}

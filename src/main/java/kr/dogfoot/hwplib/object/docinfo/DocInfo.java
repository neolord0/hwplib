package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.RecordHeader;
import kr.dogfoot.hwplib.object.etc.UnknownRecord;

import java.util.ArrayList;

/**
 * 문서 정보를 나타내는 객체. HWP파일 내의 "DocInfo" stream에 저장된다.
 *
 * @author neolord
 */
public class DocInfo {
    /**
     * 문서 속성
     */
    private DocumentPropeties documentProperties;
    /**
     * 아이디 매핑 헤더
     */
    private IDMappings idMappings;
    /**
     * 바이너리 데이터 리스트
     */
    private ArrayList<BinData> binDataList;
    /**
     * 한글 글꼴 리스트
     */
    private ArrayList<FaceName> hangulFaceNameList;
    /**
     * 영어 글꼴 리스트
     */
    private ArrayList<FaceName> englishFaceNameList;
    /**
     * 한자 글꼴 리스트
     */
    private ArrayList<FaceName> hanjaFaceNameList;
    /**
     * 일어 글꼴 리스트
     */
    private ArrayList<FaceName> japaneseFaceNameList;
    /**
     * 기타 글꼴 리스트
     */
    private ArrayList<FaceName> etcFaceNameList;
    /**
     * 기호 글꼴 리스트
     */
    private ArrayList<FaceName> symbolFaceNameList;
    /**
     * 사용자 글꼴 리스트
     */
    private ArrayList<FaceName> userFaceNameList;
    /**
     * 테두리/배경 리스트
     */
    private ArrayList<BorderFill> borderFillList;
    /**
     * 글자 모양 리스트
     */
    private ArrayList<CharShape> charShapeList;
    /**
     * 탭 정의 리스트
     */
    private ArrayList<TabDef> tabDefList;
    /**
     * 문단 번호 리스트
     */
    private ArrayList<Numbering> numberingList;
    /**
     * 글머리표 리스트
     */
    private ArrayList<Bullet> bulletList;
    /**
     * 문단 모양 리스트
     */
    private ArrayList<ParaShape> paraShapeList;
    /**
     * 스타일 리스트
     */
    private ArrayList<Style> styleList;
    /**
     * 문서 임의의 데이터
     */
    private UnknownRecord docData;
    /**
     * 배포용 문서 데이터
     */
    private UnknownRecord distributeDocData;
    /**
     * 호환 문서
     */
    private CompatibleDocument compatibleDocument;
    /**
     * 레이아웃 호환성
     */
    private LayoutCompatibility layoutCompatibility;
    /**
     * 변경 추적 정보
     */
    private UnknownRecord trackChange;
    /**
     * 메모 모양 리스트
     */
    private ArrayList<UnknownRecord> memoShapeList;
    /**
     * 금칙처리 문자
     */
    private UnknownRecord forbiddenChar;
    /**
     * 변경 추적 내용 및 모양
     */
    private ArrayList<UnknownRecord> trackChange2List;
    /**
     * 변경 추적 작성자
     */
    private ArrayList<UnknownRecord> trackChangeAuthorList;

    /**
     * 생성자
     */
    public DocInfo() {
        documentProperties = new DocumentPropeties();
        idMappings = new IDMappings();
        binDataList = new ArrayList<BinData>();
        hangulFaceNameList = new ArrayList<FaceName>();
        englishFaceNameList = new ArrayList<FaceName>();
        hanjaFaceNameList = new ArrayList<FaceName>();
        japaneseFaceNameList = new ArrayList<FaceName>();
        etcFaceNameList = new ArrayList<FaceName>();
        symbolFaceNameList = new ArrayList<FaceName>();
        userFaceNameList = new ArrayList<FaceName>();
        borderFillList = new ArrayList<BorderFill>();
        charShapeList = new ArrayList<CharShape>();
        tabDefList = new ArrayList<TabDef>();
        numberingList = new ArrayList<Numbering>();
        bulletList = new ArrayList<Bullet>();
        paraShapeList = new ArrayList<ParaShape>();
        styleList = new ArrayList<Style>();
        docData = null;
        distributeDocData = null;
        compatibleDocument = null;
        layoutCompatibility = null;
        trackChange = null;
        memoShapeList = new ArrayList<UnknownRecord>();
        forbiddenChar = null;
        trackChange2List = new ArrayList<UnknownRecord>();
        trackChangeAuthorList = new ArrayList<UnknownRecord>();
    }

    /**
     * 문서 속성 객체를 반환한다.
     *
     * @return 문서 속성 객체
     */
    public DocumentPropeties getDocumentProperties() {
        return documentProperties;
    }

    /**
     * 아이디 매핑 헤더 객체를 반환한다.
     *
     * @return 아이디 매핑 헤더 객체
     */
    public IDMappings getIDMappings() {
        return idMappings;
    }

    /**
     * 새로운 바이너리 데이터 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 바이너리 데이터 객체
     */
    public BinData addNewBinData() {
        BinData bd = new BinData();
        binDataList.add(bd);
        return bd;
    }

    /**
     * 바이너리 데이터 객체 리스트를 반환한다.
     *
     * @return 바이너리 데이터 객체 리스트
     */
    public ArrayList<BinData> getBinDataList() {
        return binDataList;
    }

    /**
     * 새로운 한글 글꼴 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 한글 글꼴 객체
     */
    public FaceName addNewHangulFaceName() {
        FaceName fn = new FaceName();
        hangulFaceNameList.add(fn);
        return fn;
    }

    /**
     * 한글 글꼴 객체 리스트를 반환한다.
     *
     * @return 한글 글꼴 객체 리스트
     */
    public ArrayList<FaceName> getHangulFaceNameList() {
        return hangulFaceNameList;
    }

    /**
     * 새로운 영어 글꼴 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 영어 글꼴 객체
     */
    public FaceName addNewEnglishFaceName() {
        FaceName fn = new FaceName();
        englishFaceNameList.add(fn);
        return fn;
    }

    /**
     * 영어 글꼴 객체 리스트를 반환한다.
     *
     * @return 영어 글꼴 객체 리스트
     */
    public ArrayList<FaceName> getEnglishFaceNameList() {
        return englishFaceNameList;
    }

    /**
     * 새로운 한자 글꼴 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 한자 글꼴 객체
     */
    public FaceName addNewHanjaFaceName() {
        FaceName fn = new FaceName();
        hanjaFaceNameList.add(fn);
        return fn;
    }

    /**
     * 한자 글꼴 객체 리스트를 반환한다.
     *
     * @return 한자 글꼴 객체 리스트
     */
    public ArrayList<FaceName> getHanjaFaceNameList() {
        return hanjaFaceNameList;
    }

    /**
     * 새로운 일본어 글꼴 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 일어 글꼴 객체
     */
    public FaceName addNewJapaneseFaceName() {
        FaceName fn = new FaceName();
        japaneseFaceNameList.add(fn);
        return fn;
    }

    /**
     * 일본어 글꼴 객체 리스트를 반환한다.
     *
     * @return 일본어 글꼴 객체 리스트
     */
    public ArrayList<FaceName> getJapaneseFaceNameList() {
        return japaneseFaceNameList;
    }

    /**
     * 새로운 기타 글꼴 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 기타 글꼴 객체
     */
    public FaceName addNewEtcFaceName() {
        FaceName fn = new FaceName();
        etcFaceNameList.add(fn);
        return fn;
    }

    /**
     * 기타 글꼴 객체 리스트를 반환한다.
     *
     * @return 기타 글꼴 객체 리스트
     */
    public ArrayList<FaceName> getEtcFaceNameList() {
        return etcFaceNameList;
    }

    /**
     * 새로운 기호 글꼴 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 기호 글꼴 객체
     */
    public FaceName addNewSymbolFaceName() {
        FaceName fn = new FaceName();
        symbolFaceNameList.add(fn);
        return fn;
    }

    /**
     * 기호 글꼴 객체 리스트를 반환한다.
     *
     * @return 기호 글꼴 객체 리스트
     */
    public ArrayList<FaceName> getSymbolFaceNameList() {
        return symbolFaceNameList;
    }

    /**
     * 새로운 사용자 글꼴 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생섣된 사용자 글꼴 객체
     */
    public FaceName addNewUserFaceName() {
        FaceName fn = new FaceName();
        userFaceNameList.add(fn);
        return fn;
    }

    /**
     * 사용자 글꼴 객체 리스트를 반환한다.
     *
     * @return 사용자 글꼴 객체 리스트
     */
    public ArrayList<FaceName> getUserFaceNameList() {
        return userFaceNameList;
    }

    /**
     * 새로운 테두리/배경 객체를 생성하고 리스트체에 추가한다.
     *
     * @return 새로 생성된 테두리/배경 객체
     */
    public BorderFill addNewBorderFill() {
        BorderFill bf = new BorderFill();
        borderFillList.add(bf);
        return bf;
    }

    /**
     * 테두리/배경 객체 리스트를 반환한다.
     *
     * @return 테두리/배경 객체 리스트
     */
    public ArrayList<BorderFill> getBorderFillList() {
        return borderFillList;
    }

    /**
     * 새로운 글자 모양 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 글자 모양 객체
     */
    public CharShape addNewCharShape() {
        CharShape cs = new CharShape();
        charShapeList.add(cs);
        return cs;
    }

    /**
     * 글자 모양 객체 리스트를 반환한다.
     *
     * @return 글자 모양 객체 리스트
     */
    public ArrayList<CharShape> getCharShapeList() {
        return charShapeList;
    }

    /**
     * 새로운 탭 정의 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 탭 정의 객체
     */
    public TabDef addNewTabDef() {
        TabDef td = new TabDef();
        tabDefList.add(td);
        return td;
    }

    /**
     * 탭 정의 객체 리스트를 반환한다.
     *
     * @return 탭 정의 객체 리스트
     */
    public ArrayList<TabDef> getTabDefList() {
        return tabDefList;
    }

    /**
     * 새로운 문단 번호 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 문단 번호 객체
     */
    public Numbering addNewNumbering() {
        Numbering n = new Numbering();
        numberingList.add(n);
        return n;
    }

    /**
     * 문단 번호 객체 리스트를 반환한다.
     *
     * @return 문단 번호 객체 리스트
     */
    public ArrayList<Numbering> getNumberingList() {
        return numberingList;
    }

    /**
     * 새로운 글머리표 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 글머리표 객체
     */
    public Bullet addNewBullet() {
        Bullet b = new Bullet();
        bulletList.add(b);
        return b;
    }

    /**
     * 글머리표 객체 리스트를 반환한다.
     *
     * @return 글머리표 객체 리스트
     */
    public ArrayList<Bullet> getBulletList() {
        return bulletList;
    }

    /**
     * 새로운 문단 모양 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 문단 모양 객체
     */
    public ParaShape addNewParaShape() {
        ParaShape ps = new ParaShape();
        paraShapeList.add(ps);
        return ps;
    }

    /**
     * 문단 모양 객체 리스트를 반환한다.
     *
     * @return 문단 모양 객체 리스트
     */
    public ArrayList<ParaShape> getParaShapeList() {
        return paraShapeList;
    }

    /**
     * 새로운 스타일 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 스타일 객체
     */
    public Style addNewStyle() {
        Style s = new Style();
        styleList.add(s);
        return s;
    }

    /**
     * 스타일 객체 리스트를 반환한다.
     *
     * @return 스타일 객체 리스트
     */
    public ArrayList<Style> getStyleList() {
        return styleList;
    }

    /**
     * 문서 임의의 데이터 객체를 생성한다.
     *
     * @param rh 레코드 헤더
     */
    public void createDocData(RecordHeader rh) {
        docData = new UnknownRecord(rh);
    }

    /**
     * 문서 임의의 데이터 객체를 삭제한다.
     */
    public void deleteDocData() {
        docData = null;
    }

    /**
     * 문서 임의의 데이터 객체를 반환한다.
     *
     * @return 문서 임의의 데이터 객체
     */
    public UnknownRecord getDocData() {
        return docData;
    }

    /**
     * 배포용 문서 데이터 객체를 생성한다.
     *
     * @param rh 레코드 헤더
     */
    public void createDistributeDocData(RecordHeader rh) {
        distributeDocData = new UnknownRecord(rh);
    }

    /**
     * 배포용 문서 데이터 객체를 삭제한다.
     */
    public void deleteDistributeDocData() {
        distributeDocData = null;
    }

    /**
     * 배포용 문서 데이터 객체를 반환한다.
     *
     * @return 배포용 문서 데이터 객체
     */
    public UnknownRecord getDistributeDocData() {
        return distributeDocData;
    }

    /**
     * 호환 문서 객체를 생성한다.
     */
    public void createCompatibleDocument() {
        compatibleDocument = new CompatibleDocument();
    }

    /**
     * 호환 문서 객체를 삭제한다.
     */
    public void deleteCompatibleDocument() {
        compatibleDocument = null;
    }

    /**
     * 호환 문서 객체를 반환한다.
     *
     * @return 호환 문서 객체
     */
    public CompatibleDocument getCompatibleDocument() {
        return compatibleDocument;
    }

    /**
     * 레이아웃 호환성 객체를 생성한다.
     */
    public void createLayoutCompatibility() {
        layoutCompatibility = new LayoutCompatibility();
    }

    /**
     * 레이아웃 호환성 객체를 삭제한다.
     */
    public void deleteLayoutCompatibility() {
        layoutCompatibility = null;
    }

    /**
     * 레이아웃 호환성 객체를 반환한다.
     *
     * @return 레이아웃 호환성 객체
     */
    public LayoutCompatibility getLayoutCompatibility() {
        return layoutCompatibility;
    }

    /**
     * 변경 추적 정보 객체를 생성한다.
     *
     * @param rh 레코드 헤더
     */
    public void createTrackChange(RecordHeader rh) {
        trackChange = new UnknownRecord(rh);
    }

    /**
     * 변경 추적 정보 객체를 삭제한다.
     */
    public void deleteTrackChange() {
        trackChange = null;
    }

    /**
     * 변경 추적 정보 객체를 반환한다.
     *
     * @return 변경 추적 정보 객체
     */
    public UnknownRecord getTrackChange() {
        return trackChange;
    }

    /**
     * 새로운 메모 모양 객체를 생성하고 리스트에 추가한다.
     *
     * @param rh 레코드 헤더
     * @return 새로 생성된 메모 모양 객체
     */
    public UnknownRecord addNewMemoShape(RecordHeader rh) {
        UnknownRecord ur = new UnknownRecord(rh);
        memoShapeList.add(ur);
        return ur;
    }

    /**
     * 메모 모양 객체 리스트를 반환한다.
     *
     * @return 메모 모양 객체 리스트
     */
    public ArrayList<UnknownRecord> getMemoShapeList() {
        return memoShapeList;
    }

    /**
     * 금칙처리 문자 객체를 생성한다.
     *
     * @param rh 레코드 헤더
     */
    public void createForbiddenChar(RecordHeader rh) {
        forbiddenChar = new UnknownRecord(rh);
    }

    /**
     * 금칙처리 문자 객체를 삭제한다.
     */
    public void deleteForbiddenChar() {
        forbiddenChar = null;
    }

    /**
     * 금칙처리 문자 객체를 반환한다.
     *
     * @return 금칙처리 문자 객체
     */
    public UnknownRecord getForbiddenChar() {
        return forbiddenChar;
    }

    /**
     * 새로운 [변경 추적 내용 및 모양] 객체를 생성하고 리스트에 추가한다.
     *
     * @param rh 레코드 헤더
     * @return 새로 생성된 [변경 추적 내용 및 모양] 객체
     */
    public UnknownRecord addNewTrackChange2(RecordHeader rh) {
        UnknownRecord ur = new UnknownRecord(rh);
        trackChange2List.add(ur);
        return ur;
    }

    /**
     * [변경 추적 내용 및 모양] 객체 리스트를 반환한다.
     *
     * @return [변경 추적 내용 및 모양] 객체 리스트
     */
    public ArrayList<UnknownRecord> getTrackChange2List() {
        return trackChange2List;
    }

    /**
     * 새로운 [변경 추적 작성자] 객체를 생성하고 리스트에 추가한다.
     *
     * @param rh 레코드 헤더
     * @return 새로 생성된 [변경 추적 작성자] 객체
     */
    public UnknownRecord addNewTrackChangeAuthor(RecordHeader rh) {
        UnknownRecord ur = new UnknownRecord(rh);
        trackChangeAuthorList.add(ur);
        return ur;
    }

    /**
     * [변경 추적 작성자] 객체 리스트를 반환한다.
     *
     * @return [변경 추적 작성자] 객체 리스트
     */
    public ArrayList<UnknownRecord> getTrackChangeAuthorList() {
        return trackChangeAuthorList;
    }
}

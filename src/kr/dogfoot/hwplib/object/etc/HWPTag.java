package kr.dogfoot.hwplib.object.etc;

/**
 * Record의 테그 리스트
 *
 * @author neolord
 */
public class HWPTag {
    /**
     * tag 시작 값
     */
    private final static short BEGIN = 0x10;

    // for "DocInfo" stream
    /**
     * 문서 속성 tag
     */
    public final static short DOCUMENT_PROPERTIES = BEGIN;
    /**
     * 아이디 매핑 헤더 tag
     */
    public final static short ID_MAPPINGS = BEGIN + 1;
    /**
     * BinData tag
     */
    public final static short BIN_DATA = BEGIN + 2;
    /**
     * Typeface Name tag
     */
    public final static short FACE_NAME = BEGIN + 3;
    /**
     * 테두리/배경 tag
     */
    public final static short BORDER_FILL = BEGIN + 4;
    /**
     * 글자 모양 tag
     */
    public final static short CHAR_SHAPE = BEGIN + 5;
    /**
     * 탭 정의 tag
     */
    public final static short TAB_DEF = BEGIN + 6;
    /**
     * 번호 정의 tag
     */
    public final static short NUMBERING = BEGIN + 7;
    /**
     * 글머리표 tag
     */
    public final static short BULLET = BEGIN + 8;
    /**
     * 문단 모양 tag
     */
    public final static short PARA_SHAPE = BEGIN + 9;
    /**
     * 스타일 tag
     */
    public final static short STYLE = BEGIN + 10;
    /**
     * 문서의 임의의 데이터 tag
     */
    public final static short DOC_DATA = BEGIN + 11;
    /**
     * 배포용 문서 데이터 tag
     */
    public final static short DISTRIBUTE_DOC_DATA = BEGIN + 12;
    /**
     * 호환 문서 tag
     */
    public final static short COMPATIBLE_DOCUMENT = BEGIN + 14;
    /**
     * 레이아웃 호환성 tag
     */
    public final static short LAYOUT_COMPATIBILITY = BEGIN + 15;
    /**
     * 변경 추적 정보 tag
     */
    public final static short TRACKCHANGE = BEGIN + 16;
    /**
     * 메모 모양 tag
     */
    public final static short MEMO_SHAPE = BEGIN + 76;
    /**
     * 금칙처리 문자 tag
     */
    public final static short FORBIDDEN_CHAR = BEGIN + 78;
    /**
     * 변경 추적 내용 및 모양 tag
     */
    public final static short TRACK_CHANGE = BEGIN + 80;
    /**
     * 변경 추적 작성자 tag
     */
    public final static short TRACK_CHANGE_AUTHOR = BEGIN + 81;

    // for "BodyText" storages
    /**
     * 문단 헤더 tag
     */
    public final static short PARA_HEADER = BEGIN + 50;
    /**
     * 문단의 텍스트 tag
     */
    public final static short PARA_TEXT = BEGIN + 51;
    /**
     * 문단의 글자 모양 tag
     */
    public final static short PARA_CHAR_SHAPE = BEGIN + 52;
    /**
     * 문단의 레이아웃 tag
     */
    public final static short PARA_LINE_SEG = BEGIN + 53;
    /**
     * 문단의 영역 태그 tag
     */
    public final static short PARA_RANGE_TAG = BEGIN + 54;
    /**
     * 컨트롤 헤더 tag
     */
    public final static short CTRL_HEADER = BEGIN + 55;
    /**
     * 문단 리스트 헤더 tag
     */
    public final static short LIST_HEADER = BEGIN + 56;
    /**
     * 용지 설정 tag
     */
    public final static short PAGE_DEF = BEGIN + 57;
    /**
     * 각주/미주 모양 tag
     */
    public final static short FOOTNOTE_SHAPE = BEGIN + 58;
    /**
     * 쪽 테두리/배경 tag
     */
    public final static short PAGE_BORDER_FILL = BEGIN + 59;
    /**
     * 개체 tag
     */
    public final static short SHAPE_COMPONENT = BEGIN + 60;
    /**
     * 표 개체 tag
     */
    public final static short TABLE = BEGIN + 61;
    /**
     * 직선 개체 tag
     */
    public final static short SHAPE_COMPONENT_LINE = BEGIN + 62;
    /**
     * 사각형 개체 tag
     */
    public final static short SHAPE_COMPONENT_RECTANGLE = BEGIN + 63;
    /**
     * 타원 개체 tag
     */
    public final static short SHAPE_COMPONENT_ELLIPSE = BEGIN + 64;
    /**
     * 호 개체 tag
     */
    public final static short SHAPE_COMPONENT_ARC = BEGIN + 65;
    /**
     * 다각형 개체 tag
     */
    public final static short SHAPE_COMPONENT_POLYGON = BEGIN + 66;
    /**
     * 곡선 개체 tag
     */
    public final static short SHAPE_COMPONENT_CURVE = BEGIN + 67;
    /**
     * OLE 개체 tag
     */
    public final static short SHAPE_COMPONENT_OLE = BEGIN + 68;
    /**
     * 그림 개체 tag
     */
    public final static short SHAPE_COMPONENT_PICTURE = BEGIN + 69;
    /**
     * 컨테이너 개체 tag
     */
    public final static short SHAPE_COMPONENT_CONTAINER = BEGIN + 70;
    /**
     * 컨트롤 임의의 데이터 tag
     */
    public final static short CTRL_DATA = BEGIN + 71;
    /**
     * 수식 개체 tag
     */
    public final static short EQEDIT = BEGIN + 72;
    /**
     * 글맵시 tag
     */
    public final static short SHAPE_COMPONENT_TEXTART = BEGIN + 74;
    /**
     * 양식 개체 tag
     */
    public final static short FORM_OBJECT = BEGIN + 75;
    /**
     * 메모 리스트 헤더 tag
     */
    public final static short MEMO_LIST = BEGIN + 77;
    /**
     * 차트 데이터 tag
     */
    public final static short CHART_DATA = BEGIN + 79;
    /**
     * 비디오 데이터 tag
     */
    public final static short VIDEO_DATA = BEGIN + 82;
    /**
     * Unknown tag
     */
    public final static short SHAPE_COMPONENT_UNKNOWN = BEGIN + 99;
}

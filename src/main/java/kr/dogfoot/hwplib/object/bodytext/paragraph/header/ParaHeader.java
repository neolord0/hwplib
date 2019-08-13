package kr.dogfoot.hwplib.object.bodytext.paragraph.header;

/**
 * 문단 헤더 레코드
 *
 * @author neolord
 */
public class ParaHeader {
    /**
     * 문단 리스트에서 이 문단이 마지막 문단인지 여부
     */
    private boolean lastInList;
    /**
     * 텍스트가 가지고 있는 문자의 객수
     */
    private long characterCount;
    /**
     * control mask
     */
    private ControlMask controlMask;
    /**
     * 참조된 문단 모양 id
     */
    private int paraShapeId;
    /**
     * 참조된 스타일 id
     */
    private short styleId;
    /**
     * 단 나누기 종류
     */
    private DivideSort divideSort;
    /**
     * 글자 모양 정보의 개수. ParaCharShape에 글자 위치-글자 모양 쌍의 개수
     */
    private int charShapeCount;
    /**
     * range tag 정보의 개수. ParaRangeTag의 영역 태그의 개수
     */
    private int rangeTagCount;
    /**
     * 각 줄에 대한 align에 대한 정보의 개수. ParaLineSeg의 정보의 객수
     */
    private int lineAlignCount;
    /**
     * 문단 Instance ID (unique ID)
     */
    private long instanceID;
    /**
     * 변경추적 병합 문단여부. (5.0.3.2 버전 이상)
     */
    private int isMergedByTrack;

    /**
     * 생성자
     */
    public ParaHeader() {
        controlMask = new ControlMask();
        divideSort = new DivideSort();
    }

    /**
     * 문단 리스트에서 이 문단이 마지막 문단인지 여부를 반환한다.
     *
     * @return 문단 리스트에서 이 문단이 마지막 문단인지 여부
     */
    public boolean isLastInList() {
        return lastInList;
    }

    /**
     * 문단 리스트에서 이 문단이 마지막 문단인지 여부를 설정한다.
     *
     * @param lastInList 문단 리스트에서 이 문단이 마지막 문단인지 여부
     */
    public void setLastInList(boolean lastInList) {
        this.lastInList = lastInList;
    }

    /**
     * 텍스트가 가지고 있는 문자의 객수를 반환한다.
     *
     * @return 텍스트가 가지고 있는 문자의 객수
     */
    public long getCharacterCount() {
        return characterCount;
    }

    /**
     * 텍스트가 가지고 있는 문자의 객수를 설정한다.
     *
     * @param characterCount 텍스트가 가지고 있는 문자의 객수
     */
    public void setCharacterCount(long characterCount) {
        this.characterCount = characterCount;
    }

    /**
     * control mask 객체를 반환한다.
     *
     * @return control mask 객체
     */
    public ControlMask getControlMask() {
        return controlMask;
    }

    /**
     * 참조된 문단 모양 객체의 id릎 반환한다.
     *
     * @return 참조된 문단 모양 객체의 id
     */
    public int getParaShapeId() {
        return paraShapeId;
    }

    /**
     * 참조된 문단 모양 객체의 id를 설정한다.
     *
     * @param paraShapeId 참조된 문단 모양 객체의 id
     */
    public void setParaShapeId(int paraShapeId) {
        this.paraShapeId = paraShapeId;
    }

    /**
     * 참조된 스타일 객체의 Id를 반환한다.
     *
     * @return 참조된 스타일 객체의 Id
     */
    public short getStyleId() {
        return styleId;
    }

    /**
     * 참조된 스타일 객체의 Id를 설정한다.
     *
     * @param styleId 참조된 스타일 객체의 Id
     */
    public void setStyleId(short styleId) {
        this.styleId = styleId;
    }

    /**
     * 단 나누기 종류 객체를 반환한다.
     *
     * @return 단 나누기 종류 객체
     */
    public DivideSort getDivideSort() {
        return divideSort;
    }

    /**
     * 글자 모양 정보의 개수를 반환한다.
     *
     * @return 글자 모양 정보의 개수
     */
    public int getCharShapeCount() {
        return charShapeCount;
    }

    /**
     * 글자 모양 정보의 개수를 설정한다.
     *
     * @param charShapeCount 글자 모양 정보의 개수
     */
    public void setCharShapeCount(int charShapeCount) {
        this.charShapeCount = charShapeCount;
    }

    /**
     * range tag 정보의 개수를 반환한다.
     *
     * @return range tag 정보의 개수
     */
    public int getRangeTagCount() {
        return rangeTagCount;
    }

    /**
     * range tag 정보의 개수를 설정한다.
     *
     * @param rangeTagCount range tag 정보의 개수
     */
    public void setRangeTagCount(int rangeTagCount) {
        this.rangeTagCount = rangeTagCount;
    }

    /**
     * 각 줄에 대한 align에 대한 정보의 개수를 반환한다.
     *
     * @return 각 줄에 대한 align에 대한 정보의 개수
     */
    public int getLineAlignCount() {
        return lineAlignCount;
    }

    /**
     * 각 줄에 대한 align에 대한 정보의 개수를 설정한다.
     *
     * @param lineAlignCount 각 줄에 대한 align에 대한 정보의 개수.
     */
    public void setLineAlignCount(int lineAlignCount) {
        this.lineAlignCount = lineAlignCount;
    }

    /**
     * 문단의 instance id를 반환한다.
     *
     * @return 문단의 instance id
     */
    public long getInstanceID() {
        return instanceID;
    }

    /**
     * 문단의 instance id를 설정한다.
     *
     * @param instanceID 문단의 instance id
     */
    public void setInstanceID(long instanceID) {
        this.instanceID = instanceID;
    }

    /**
     * 변경추적 병합 문단여부를 반환한다. (5.0.3.2 버전 이상)
     *
     * @return 변경추적 병합 문단여부
     */
    public int getIsMergedByTrack() {
        return isMergedByTrack;
    }

    /**
     * 변경추적 병합 문단여부를 설정한다.
     *
     * @param isMergedByTrack 변경추적 병합 문단여부
     */
    public void setIsMergedByTrack(int isMergedByTrack) {
        this.isMergedByTrack = isMergedByTrack;
    }
}

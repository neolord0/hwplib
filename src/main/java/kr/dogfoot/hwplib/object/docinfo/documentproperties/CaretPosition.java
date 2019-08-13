package kr.dogfoot.hwplib.object.docinfo.documentproperties;

/**
 * 캐럿의 위치 정보
 *
 * @author neolord
 */
public class CaretPosition {
    /**
     * 리스트 아이디 - (구역 ??)
     */
    private long listID;
    /**
     * 문단 아이디
     */
    private long paragraphID;
    /**
     * 문단 내에서의 글자 단위 위치
     */
    private long positionInParagraph;

    /**
     * 생성자
     */
    public CaretPosition() {
    }

    /**
     * 리스트 아이디를 반환한다.
     *
     * @return 리스트 아이디
     */
    public long getListID() {
        return listID;
    }

    /**
     * 리스트 아이디를 설정한다.
     *
     * @param listID 리스트 아이디
     */
    public void setListID(long listID) {
        this.listID = listID;
    }

    /**
     * 문단 아이디를 반환한다.
     *
     * @return 문단 아이디
     */
    public long getParagraphID() {
        return paragraphID;
    }

    /**
     * 문단 아이디를 설정한다.
     *
     * @param paragraphID 문단 아이디
     */
    public void setParagraphID(long paragraphID) {
        this.paragraphID = paragraphID;
    }

    /**
     * 문단 내에서의 글자 단위 위치를 반환한다.
     *
     * @return 문단 내에서의 글자 단위 위치
     */
    public long getPositionInParagraph() {
        return positionInParagraph;
    }

    /**
     * 문단 내에서의 글자 단위 위치를 설정한다.
     *
     * @param positionInParagraph 문단 내에서의 글자 단위 위치
     */
    public void setPositionInParagraph(long positionInParagraph) {
        this.positionInParagraph = positionInParagraph;
    }
}

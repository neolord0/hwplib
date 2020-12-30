package kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg;

/**
 * 각 중의 align 정보에 대한 객체
 *
 * @author neolord
 */
public class LineSegItem {
    /**
     * 텍스트 시작 위치
     */
    private long textStartPosition;
    /**
     * 줄의 세로 위치
     */
    private int lineVerticalPosition;
    /**
     * 줄의 높이
     */
    private int lineHeight;
    /**
     * 텍스트 부분의 높이
     */
    private int textPartHeight;
    /**
     * 줄의 세로 위치에서 베이스라인까지 거리
     */
    private int distanceBaseLineToLineVerticalPosition;
    /**
     * 줄간격
     */
    private int lineSpace;
    /**
     * 컬럼에서의 시작 위치
     */
    private int startPositionFromColumn;
    /**
     * 세그먼트의 폭
     */
    private int segmentWidth;
    /**
     * tag 정보
     */
    private LineSegItemTag tag;

    /**
     * 생성자
     */
    public LineSegItem() {
        tag = new LineSegItemTag();
    }

    /**
     * 텍스트 시작 위치를 반환한다.
     *
     * @return 텍스트 시작 위치
     */
    public long getTextStartPosition() {
        return textStartPosition;
    }

    /**
     * 텍스트 시작 위치를 설정한다.
     *
     * @param textStartPosition 텍스트 시작 위치
     */
    public void setTextStartPosition(long textStartPosition) {
        this.textStartPosition = textStartPosition;
    }

    /**
     * 줄의 세로 위치를 반환한다.
     *
     * @return 줄의 세로 위치
     */
    public int getLineVerticalPosition() {
        return lineVerticalPosition;
    }

    /**
     * 줄의 세로 위치를 설정한다.
     *
     * @param lineVerticalPosition 줄의 세로 위치
     */
    public void setLineVerticalPosition(int lineVerticalPosition) {
        this.lineVerticalPosition = lineVerticalPosition;
    }

    /**
     * 줄의 높이를 반환한다.
     *
     * @return 줄의 높이
     */
    public int getLineHeight() {
        return lineHeight;
    }

    /**
     * 줄의 높이를 설정한다.
     *
     * @param lineHeight 줄의 높이
     */
    public void setLineHeight(int lineHeight) {
        this.lineHeight = lineHeight;
    }

    /**
     * 텍스트 부분의 높이를 반환한다.
     *
     * @return 텍스트 부분의 높이
     */
    public int getTextPartHeight() {
        return textPartHeight;
    }

    /**
     * 텍스트 부분의 높이를 설정한다.
     *
     * @param textPartHeight 텍스트 부분의 높이
     */
    public void setTextPartHeight(int textPartHeight) {
        this.textPartHeight = textPartHeight;
    }

    /**
     * 줄의 세로 위치에서 베이스라인까지 거리를 반환한다.
     *
     * @return 줄의 세로 위치에서 베이스라인까지 거리
     */
    public int getDistanceBaseLineToLineVerticalPosition() {
        return distanceBaseLineToLineVerticalPosition;
    }

    /**
     * 줄의 세로 위치에서 베이스라인까지 거리를 설정한다.
     *
     * @param distanceBaseLineToLineVerticalPosition 줄의 세로 위치에서 베이스라인까지 거리
     */
    public void setDistanceBaseLineToLineVerticalPosition(
            int distanceBaseLineToLineVerticalPosition) {
        this.distanceBaseLineToLineVerticalPosition = distanceBaseLineToLineVerticalPosition;
    }

    /**
     * 줄간격을 반환한다.
     *
     * @return 줄간격
     */
    public int getLineSpace() {
        return lineSpace;
    }

    /**
     * 줄간격을 설정한다.
     *
     * @param lineSpace 줄간격
     */
    public void setLineSpace(int lineSpace) {
        this.lineSpace = lineSpace;
    }

    /**
     * 컬럼에서의 시작 위치를 반환한다.
     *
     * @return 컬럼에서의 시작 위치
     */
    public int getStartPositionFromColumn() {
        return startPositionFromColumn;
    }

    /**
     * 컬럼에서의 시작 위치를 설정한다.
     *
     * @param startPositionFromColumn 컬럼에서의 시작 위치
     */
    public void setStartPositionFromColumn(int startPositionFromColumn) {
        this.startPositionFromColumn = startPositionFromColumn;
    }

    /**
     * 세그먼트의 폭을 반환한다.
     *
     * @return 세그먼트의 폭
     */
    public int getSegmentWidth() {
        return segmentWidth;
    }

    /**
     * 세그먼트의 폭을 설정한다.
     *
     * @param segmentWidth 세그먼트의 폭
     */
    public void setSegmentWidth(int segmentWidth) {
        this.segmentWidth = segmentWidth;
    }

    /**
     * tag 정보에 대한 객체를 반환한다.
     *
     * @return tag 정보에 대한 객체
     */
    public LineSegItemTag getTag() {
        return tag;
    }

    public LineSegItem clone() {
        LineSegItem cloned = new LineSegItem();
        cloned.textStartPosition = textStartPosition;
        cloned.lineVerticalPosition = lineVerticalPosition;
        cloned.lineHeight = lineHeight;
        cloned.textPartHeight = textPartHeight;
        cloned.distanceBaseLineToLineVerticalPosition = distanceBaseLineToLineVerticalPosition;
        cloned.lineSpace = lineSpace;
        cloned.startPositionFromColumn = startPositionFromColumn;
        cloned.segmentWidth = segmentWidth;
        cloned.tag.copy(tag);
        return cloned;
    }
}

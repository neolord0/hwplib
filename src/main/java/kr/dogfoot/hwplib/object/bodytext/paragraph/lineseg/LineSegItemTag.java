package kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 각 중의 align 정보의 태그 정보에 대한 객체
 *
 * @author neolord
 */
public class LineSegItemTag {
    /**
     * 파일에 저장되는 값 (unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public LineSegItemTag() {
    }

    /**
     * 파일에 저장되는 값을 반환한다.
     *
     * @return 파일에 저장되는 값
     */
    public long getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 값을 설정한다.
     *
     * @param value 파일에 저장되는 값
     */
    public void setValue(long value) {
        this.value = value;
    }

    /**
     * 페이지의 첫 줄인지 여부를 반환한다. (0 bit)
     *
     * @return 페이지의 첫 줄인지 여부
     */
    public boolean isFirstLineAtPage() {
        return BitFlag.get(value, 0);
    }

    /**
     * 페이지의 첫 줄인지 여부를 설정한다. (0 bit)
     *
     * @param firstLineAtPage 페이지의 첫 줄인지 여부
     */
    public void setFirstLineAtPage(boolean firstLineAtPage) {
        value = BitFlag.set(value, 0, firstLineAtPage);
    }

    /**
     * 컬럼의 첫 줄인지 여부를 반환한다. (1 bit)
     *
     * @return 컬럼의 첫 줄인지 여부
     */
    public boolean isFirstLineAtColumn() {
        return BitFlag.get(value, 1);
    }

    /**
     * 컬럼의 첫 줄인지 여부를 설정한다. (1 bit)
     *
     * @param firstLineAtColumn 컬럼의 첫 줄인지 여부
     */
    public void setFirstLineAtColumn(boolean firstLineAtColumn) {
        value = BitFlag.set(value, 1, firstLineAtColumn);
    }

    /**
     * 텍스트가 배열되지 않은 빈 세그먼트인지 여부를 반환한다. (16 bit)
     *
     * @return 텍스트가 배열되지 않은 빈 세그먼트인지 여부
     */
    public boolean isEmptySegment() {
        return BitFlag.get(value, 16);
    }

    /**
     * 텍스트가 배열되지 않은 빈 세그먼트인지 여부를 설정한다. (16 bit)
     *
     * @param emptySegment 텍스트가 배열되지 않은 빈 세그먼트인지 여부
     */
    public void setEmptySegment(boolean emptySegment) {
        value = BitFlag.set(value, 16, emptySegment);
    }

    /**
     * 줄의 첫 세그먼트인지 여부를 반환한다. (17 bit)
     *
     * @return 줄의 첫 세그먼트인지 여부
     */
    public boolean getFirstSegmentAtLine() {
        return BitFlag.get(value, 17);
    }

    /**
     * 줄의 첫 세그먼트인지 여부를 설정한다. (17 bit)
     *
     * @param firstSegmentAtLine 줄의 첫 세그먼트인지 여부
     */
    public void setFirstSegmentAtLine(boolean firstSegmentAtLine) {
        value = BitFlag.set(value, 17, firstSegmentAtLine);
    }

    /**
     * 줄의 마지막 세그먼트인지 여부를 반환한다. (18 bit)
     *
     * @return 줄의 마지막 세그먼트인지 여부
     */
    public boolean getLastSegmentAtLine() {
        return BitFlag.get(value, 18);
    }

    /**
     * 줄의 마지막 세그먼트인지 여부를 설정한다. (18 bit)
     *
     * @param lastSegmentAtLine 줄의 마지막 세그먼트인지 여부
     */
    public void setLastSegmentAtLine(boolean lastSegmentAtLine) {
        value = BitFlag.set(value, 18, lastSegmentAtLine);
    }

    /**
     * 줄의 마지막에 auto-hyphenation이 수행되었는지 여부를 반환한다. (19 bit)
     *
     * @return 줄의 마지막에 auto-hyphenation이 수행되었는지 여부
     */
    public boolean isAutoHyphenation() {
        return BitFlag.get(value, 19);
    }

    /**
     * 줄의 마지막에 auto-hyphenation이 수행되었는지 여부를 설정한다. (19 bit)
     *
     * @param autoHyphenation 줄의 마지막에 auto-hyphenation이 수행되었는지 여부
     */
    public void setAutoHyphenation(boolean autoHyphenation) {
        value = BitFlag.set(value, 19, autoHyphenation);
    }

    /**
     * indentation 적용 여부를 반환한다. (20 bit)
     *
     * @return indentation 적용 여부
     */
    public boolean isAdjustIndentation() {
        return BitFlag.get(value, 20);
    }

    /**
     * indentation 적용 여부를 설정한다. (20 bit)
     *
     * @param adjustIndentation indentation 적용 여부
     */
    public void setAdjustIndentation(boolean adjustIndentation) {
        value = BitFlag.set(value, 20, adjustIndentation);
    }

    /**
     * 문단 머리 모양 적용 여부를 반환한다. (21 bit)
     *
     * @return 문단 머리 모양 적용 여부
     */
    public boolean isAdjustBullet() {
        return BitFlag.get(value, 21);
    }

    /**
     * 문단 머리 모양 적용 여부를 설정한다. (21 bit)
     *
     * @param adjustBullet 문단 머리 모양 적용 여부
     */
    public void setAdjustBullet(boolean adjustBullet) {
        value = BitFlag.set(value, 21, adjustBullet);
    }

    /**
     * 구현상의 편의를 위한 property를 반환한다. (31 bit)
     *
     * @return 구현상의 편의를 위한 property
     */
    public boolean getBit31() {
        return BitFlag.get(value, 31);
    }

    /**
     * 구현상의 편의를 위한 property를 설정한다. (bit 31)
     *
     * @param bit31 구현상의 편의를 위한 property
     */
    public void setBit31(boolean bit31) {
        value = BitFlag.set(value, 31, bit31);
    }

    public void copy(LineSegItemTag from) {
        value = from.value;
    }
}

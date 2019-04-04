package kr.dogfoot.hwplib.object.bodytext.paragraph.header;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 문단에 포함된 컨트롤의 종류를 나타내는 객체
 *
 * @author neolord
 */
public class ControlMask {
    /**
     * 파일에 저장되는 값 (unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public ControlMask() {
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
     * 문단이 구역/단 정의 컨트롤을 가졌는지 여부를 반환한다. (2 bit)
     *
     * @return 문단이 구역/단 정의 컨트롤을 가졌는지 여부
     */
    public boolean hasSectColDef() {
        return BitFlag.get(value, 2);
    }

    /**
     * 문단이 구역/단 정의 컨트롤을 가졌는지 여부를 설정한다. (2 bit)
     *
     * @param hasSectColDef 문단이 구역/단 정의 컨트롤을 가졌는지 여부
     */
    public void setHasSectColDef(boolean hasSectColDef) {
        value = BitFlag.set(value, 2, hasSectColDef);
    }

    /**
     * 필드 시작 컨트롤을 가졌는지 여부를 반환한다. (3 bit)
     *
     * @return 필드 시작 컨트롤을 가졌는지 여부
     */
    public boolean hasFieldStart() {
        return BitFlag.get(value, 3);
    }

    /**
     * 필드 시작 컨트롤을 가졌는지 여부를 설정한다. (3 bit)
     *
     * @param hasFieldStart 필드 시작 컨트롤을 가졌는지 여부
     */
    public void setHasFieldStart(boolean hasFieldStart) {
        value = BitFlag.set(value, 3, hasFieldStart);
    }

    /**
     * 필드 끝 컨트롤을 가졌는지 여부를 반환한다. (4 bit)
     *
     * @return 필드 끝 컨트롤을 가졌는지 여부
     */
    public boolean hasFieldEnd() {
        return BitFlag.get(value, 4);
    }

    /**
     * 필드 끝 컨트롤을 가졌는지 여부를 설정한다. (4 bit)
     *
     * @param hasFieldEnd 필드 끝 컨트롤을 가졌는지 여부
     */
    public void setHasFieldEnd(boolean hasFieldEnd) {
        value = BitFlag.set(value, 4, hasFieldEnd);
    }

    /**
     * Title Mark를 가졌는지 여부를 반환한다.
     *
     * @return Title Mark를 가졌는지 여부
     */
    public boolean hasTitleMark() {
        return BitFlag.get(value, 8);
    }

    /**
     * Title Mark를 가졌는지 여부를 설정한다.
     *
     * @param hasTitleMark Title Mark를 가졌는지 여부
     */
    public void setHasTitleMark(boolean hasTitleMark) {
        value = BitFlag.set(value, 8, hasTitleMark);

    }

    /**
     * 탭을 가졌는지 여부를 반환한다. (9 bit)
     *
     * @return 탭을 가졌는지 여부
     */
    public boolean hasTab() {
        return BitFlag.get(value, 9);
    }

    /**
     * 탭을 가졌는지 여부를 설정한다. (9 bit)
     *
     * @param hasTab 탭을 가졌는지 여부
     */
    public void setHasTab(boolean hasTab) {
        value = BitFlag.set(value, 9, hasTab);
    }

    /**
     * 강제 줄 나눔을 가졌는지 여부를 반환한다. (10 bit)
     *
     * @return 강제 줄 나눔을 가졌는지 여부
     */
    public boolean hasLineBreak() {
        return BitFlag.get(value, 10);
    }

    /**
     * 강제 줄 나눔을 가졌는지 여부를 설정한다. (10 bit)
     *
     * @param hasLineBreak 강제 줄 나눔을 가졌는지 여부
     */
    public void setHasLineBreak(boolean hasLineBreak) {
        value = BitFlag.set(value, 10, hasLineBreak);
    }

    /**
     * 그리기 객체 또는 표 객체를 가졌는지 여부를 반환한다. (11 bit)
     *
     * @return 그리기 객체 또는 표 객체를 가졌는지 여부
     */
    public boolean hasGsoTable() {
        return BitFlag.get(value, 11);
    }

    /**
     * 그리기 객체 또는 표 객체를 가졌는지 여부를 설정한다. (11 bit)
     *
     * @param hasObjectTable 그리기 객체 또는 표 객체를 가졌는지 여부
     */
    public void setHasGsoTable(boolean hasObjectTable) {
        value = BitFlag.set(value, 11, hasObjectTable);
    }

    /**
     * 문단 나누기를 가졌는지 여부를 반환한다. (13 bit)
     *
     * @return 문단 나누기를 가졌는지 여부
     */
    public boolean hasParaBreak() {
        return BitFlag.get(value, 13);
    }

    /**
     * 문단 나누기를 가졌는지 여부를 설정한다. (13 bit)
     *
     * @param hasParaBreak 문단 나누기를 가졌는지 여부
     */
    public void setHasParaBreak(boolean hasParaBreak) {
        value = BitFlag.set(value, 13, hasParaBreak);
    }

    /**
     * 숨은 설명을 가졌는지 여부를 반환한다. (15 bit)
     *
     * @return 숨은 설명을 가졌는지 여부
     */
    public boolean hasHiddenComment() {
        return BitFlag.get(value, 15);
    }

    /**
     * 숨은 설명을 가졌는지 여부를 설정한다. (15 bit)
     *
     * @param hasHiddenComment 숨은 설명을 가졌는지 여부
     */
    public void setHasHiddenComment(boolean hasHiddenComment) {
        value = BitFlag.set(value, 15, hasHiddenComment);
    }

    /**
     * 머리말 또는 꼬리말을 가졌는지 여부를 반환한다. (16 bit)
     *
     * @return 머리말 또는 꼬리말을 가졌는지 여부
     */
    public boolean hasHeaderFooter() {
        return BitFlag.get(value, 16);
    }

    /**
     * 머리말 또는 꼬리말을 가졌는지 여부를 설정한다. (16 bit)
     *
     * @param hasHeaderFooter 머리말 또는 꼬리말을 가졌는지 여부
     */
    public void setHasHeaderFooter(boolean hasHeaderFooter) {
        value = BitFlag.set(value, 16, hasHeaderFooter);
    }

    /**
     * 각주 또는 미주를 가졌는지 여부를 반환한다. (17 bit)
     *
     * @return 각주 또는 미주를 가졌는지 여부
     */
    public boolean hasFootnoteEndnote() {
        return BitFlag.get(value, 17);
    }

    /**
     * 각주 또는 미주를 가졌는지 여부를 설정한다. (17 bit)
     *
     * @param hasFootnoteEndnote 각주 또는 미주를 가졌는지 여부
     */
    public void setHasFootnoteEndnote(boolean hasFootnoteEndnote) {
        value = BitFlag.set(value, 17, hasFootnoteEndnote);
    }

    /**
     * 자동 번호를 가져쓴지 여부를 반환한다. (18 bit)
     *
     * @return 자동 번호를 가져쓴지 여부
     */
    public boolean hasAutoNumber() {
        return BitFlag.get(value, 18);
    }

    /**
     * 자동 번호를 가져쓴지 여부를 설정한다. (18 bit)
     *
     * @param hasAutoNumber 자동 번호를 가져쓴지 여부
     */
    public void setHasAutoNumber(boolean hasAutoNumber) {
        value = BitFlag.set(value, 18, hasAutoNumber);
    }

    /**
     * 페이지 컨트롤(감추기, 새 번호로 시작 등)을 가졌는지 여부를 반환한다. (21 bit)
     *
     * @return 페이지 컨트롤(감추기, 새 번호로 시작 등)을 가졌는지 여부
     */
    public boolean hasPageControl() {
        return BitFlag.get(value, 21);
    }

    /**
     * 페이지 컨트롤(감추기, 새 번호로 시작 등)을 가졌는지 여부를 설정한다. (21 bit)
     *
     * @param hasPageControl 페이지 컨트롤(감추기, 새 번호로 시작 등)을 가졌는지 여부
     */
    public void setHasPageControl(boolean hasPageControl) {
        value = BitFlag.set(value, 21, hasPageControl);
    }

    /**
     * 책갈피/찾이보기 표시를 가졌는지 여부를 반환한다. (22 bit)
     *
     * @return 책갈피/찾이보기 표시를 가졌는지 여부
     */
    public boolean hasBookmark() {
        return BitFlag.get(value, 22);
    }

    /**
     * 책갈피/찾이보기 표시를 가졌는지 여부를 설정한다. (22 bit)
     *
     * @param hasBookmark 책갈피/찾이보기 표시를 가졌는지 여부
     */
    public void setHasBookmark(boolean hasBookmark) {
        value = BitFlag.set(value, 22, hasBookmark);
    }

    /**
     * 덧말/글자 겹침을 가졌는지 여부를 반환한다. (23 bit)
     *
     * @return 덧말/글자 겹침를 가졌는지 여부
     */
    public boolean hasAdditionalTextOverlappingLetter() {
        return BitFlag.get(value, 23);
    }

    /**
     * 덧말/글자 겹침을 가졌는지 여부를 설정한다. (23 bit)
     *
     * @param hasAdditionalTextOverlappingLetter 덧말/글자 겹침를 가졌는지 여부
     */
    public void setHasAdditionalTextOverlappingLetter(
            boolean hasAdditionalTextOverlappingLetter) {
        value = BitFlag.set(value, 23, hasAdditionalTextOverlappingLetter);
    }

    /**
     * 하이픈을 가졌는지 여부를 반환한다. (24 bit)
     *
     * @return 하이픈을 가졌는지 여부
     */
    public boolean hasHyphen() {
        return BitFlag.get(value, 24);
    }

    /**
     * 하이픈을 가졌는지 여부를 설정한다. (24 bit)
     *
     * @param hasHyphen 하이픈을 가졌는지 여부
     */
    public void setHasHyphen(boolean hasHyphen) {
        value = BitFlag.set(value, 24, hasHyphen);
    }

    /**
     * 묶음 빈칸을 가졌는지 여부를 반환한다. (30 bit)
     *
     * @return 묶음 빈칸을 가졌는지 여부
     */
    public boolean hasBundleBlank() {
        return BitFlag.get(value, 30);
    }

    /**
     * 묶음 빈칸을 가졌는지 여부를 설정한다. (30 bit)
     *
     * @param hasBundleBlank 묶음 빈칸을 가졌는지 여부
     */
    public void setHasBundleBlank(boolean hasBundleBlank) {
        value = BitFlag.set(value, 30, hasBundleBlank);
    }

    /**
     * 고정 폭 빈칸을 가졌는지 여부를 반환한다. (31 bit)
     *
     * @return 고정 폭 빈칸을 가졌는지 여부
     */
    public boolean hasFixWidthBlank() {
        return BitFlag.get(value, 31);
    }

    /**
     * 고정 폭 빈칸을 가졌는지 여부를 설정한다. (31 bit)
     *
     * @param hasFixWidthBlank 고정 폭 빈칸을 가졌는지 여부
     */
    public void setHasFixWidthBlank(boolean hasFixWidthBlank) {
        value = BitFlag.set(value, 31, hasFixWidthBlank);
    }
}

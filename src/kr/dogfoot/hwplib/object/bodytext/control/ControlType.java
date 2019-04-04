package kr.dogfoot.hwplib.object.bodytext.control;

import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlID;

/**
 * 컨트롤 타입
 *
 * @author neolord
 */
public enum ControlType {
    /**
     * 표
     */
    Table(CtrlID.make('t', 'b', 'l', ' ')),
    /**
     * 그리기 객체(??)
     */
    Gso(CtrlID.make('g', 's', 'o', ' ')),
    /**
     * 한글 수식 객체
     */
    Equation(CtrlID.make('e', 'q', 'e', 'd')),

    /**
     * 구역 정의
     */
    SectionDefine(CtrlID.make('s', 'e', 'c', 'd')),
    /**
     * 단 정의
     */
    ColumnDefine(CtrlID.make('c', 'o', 'l', 'd')),
    /**
     * 머리말
     */
    Header(CtrlID.make('h', 'e', 'a', 'd')),
    /**
     * 꼬리말
     */
    Footer(CtrlID.make('f', 'o', 'o', 't')),
    /**
     * 각주
     */
    Footnote(CtrlID.make('f', 'n', ' ', ' ')),
    /**
     * 미주
     */
    Endnote(CtrlID.make('e', 'n', ' ', ' ')),
    /**
     * 자동번호
     */
    AutoNumber(CtrlID.make('a', 't', 'n', 'o')),
    /**
     * 새 번호 지정
     */
    NewNumber(CtrlID.make('n', 'w', 'n', 'o')),
    /**
     * 감추기
     */
    PageHide(CtrlID.make('p', 'g', 'h', 'd')),
    /**
     * 홀/짝수 조정
     */
    PageOddEvenAdjust(CtrlID.make('p', 'g', 'c', 't')),
    /**
     * 쪽 번호 위치
     */
    PageNumberPositon(CtrlID.make('p', 'g', 'n', 'p')),
    /**
     * 찾아보기 표식
     */
    IndexMark(CtrlID.make('i', 'd', 'x', 'm')),
    /**
     * 책갈피
     */
    Bookmark(CtrlID.make('b', 'o', 'k', 'm')),
    /**
     * 글자 겹침
     */
    OverlappingLetter(CtrlID.make('t', 'c', 'p', 's')),
    /**
     * 덧말
     */
    AdditionalText(CtrlID.make('t', 'd', 'u', 't')),
    /**
     * 숨은 설명
     */
    HiddenComment(CtrlID.make('t', 'c', 'm', 't')),

    FIELD_UNKNOWN(CtrlID.make('%', 'u', 'n', 'k')),
    FIELD_DATE(CtrlID.make('%', 'd', 't', 'e')),
    FIELD_DOCDATE(CtrlID.make('%', 'd', 'd', 't')),
    FIELD_PATH(CtrlID.make('%', 'p', 'a', 't')),
    FIELD_BOOKMARK(CtrlID.make('%', 'b', 'm', 'k')),
    FIELD_MAILMERGE(CtrlID.make('%', 'm', 'm', 'g')),
    FIELD_CROSSREF(CtrlID.make('%', 'x', 'r', 'f')),
    FIELD_FORMULA(CtrlID.make('%', 'f', 'm', 'u')),
    FIELD_CLICKHERE(CtrlID.make('%', 'c', 'l', 'k')),
    FIELD_SUMMARY(CtrlID.make('%', 's', 'm', 'r')),
    FIELD_USERINFO(CtrlID.make('%', 'u', 's', 'r')),
    FIELD_HYPERLINK(CtrlID.make('%', 'h', 'l', 'k')),
    FIELD_REVISION_SIGN(CtrlID.make('%', 's', 'i', 'g')),
    FIELD_REVISION_DELETE(CtrlID.make('%', '%', '*', 'd')),
    FIELD_REVISION_ATTACH(CtrlID.make('%', '%', '*', 'a')),
    FIELD_REVISION_CLIPPING(CtrlID.make('%', '%', '*', 'C')),
    FIELD_REVISION_THINKING(CtrlID.make('%', '%', '*', 'T')),
    FIELD_REVISION_PRAISE(CtrlID.make('%', '%', '*', 'P')),
    FIELD_REVISION_LINE(CtrlID.make('%', '%', '*', 'L')),
    FIELD_REVISION_SIMPLECHANGE(CtrlID.make('%', '%', '*', 'c')),
    FIELD_REVISION_HYPERLINK(CtrlID.make('%', '%', '*', 'h')),
    FIELD_REVISION_LINEATTACH(CtrlID.make('%', '%', '*', 'A')),
    FIELD_REVISION_LINELINK(CtrlID.make('%', '%', '*', 'i')),
    FIELD_REVISION_LINETRANSFER(CtrlID.make('%', '%', '*', 't')),
    FIELD_REVISION_RIGHTMOVE(CtrlID.make('%', '%', '*', 'r')),
    FIELD_REVISION_LEFTMOVE(CtrlID.make('%', '%', '*', 'l')),
    FIELD_REVISION_TRANSFER(CtrlID.make('%', '%', '*', 'n')),
    FIELD_REVISION_SIMPLEINSERT(CtrlID.make('%', '%', '*', 'e')),
    FIELD_REVISION_SPLIT(CtrlID.make('%', 's', 'p', 'l')),
    FIELD_REVISION_CHANGE(CtrlID.make('%', '%', 'm', 'r')),
    FIELD_MEMO(CtrlID.make('%', '%', 'm', 'e')),
    FIELD_PRIVATE_INFO_SECURITY(CtrlID.make('%', 'c', 'p', 'r'));

    /**
     * 컨트롤 id
     */
    private long ctrlId;

    /**
     * 생성자
     *
     * @param ctrlId 컨트롤 id
     */
    ControlType(long ctrlId) {
        this.ctrlId = ctrlId;
    }

    /**
     * 컨트롤 id를 반환한다.
     *
     * @return 컨트롤 id
     */
    public long getCtrlId() {
        return ctrlId;
    }

    /**
     * 필드 인지 여부를 반환한다.
     *
     * @return 필드 인지 여부
     */
    public boolean isField() {
        return ControlType.isField(ctrlId);
    }

    /**
     * 컨트롤 id에 해당되는 ControlType을 반환한다.
     *
     * @param ctrlId 컨트롤 id
     * @return 컨트롤 타입
     */
    public static ControlType ctrlIdOf(long ctrlId) {
        for (ControlType ct : values()) {
            if (ct.ctrlId == ctrlId) {
                return ct;
            }
        }
        return Table;
    }

    /**
     * 컨트롤 id가 필드인지 아닌지 여부를 반환한다.
     *
     * @param ctrlId 컨트롤 id
     * @return 컨트롤 id가 필드인지 아닌지 여부
     */
    public static boolean isField(long ctrlId) {
        return ctrlId == FIELD_UNKNOWN.ctrlId || ctrlId == FIELD_DATE.ctrlId || ctrlId == FIELD_DOCDATE.ctrlId
                || ctrlId == FIELD_PATH.ctrlId || ctrlId == FIELD_BOOKMARK.ctrlId || ctrlId == FIELD_MAILMERGE.ctrlId
                || ctrlId == FIELD_CROSSREF.ctrlId || ctrlId == FIELD_FORMULA.ctrlId || ctrlId == FIELD_CLICKHERE.ctrlId
                || ctrlId == FIELD_SUMMARY.ctrlId || ctrlId == FIELD_USERINFO.ctrlId || ctrlId == FIELD_HYPERLINK.ctrlId
                || ctrlId == FIELD_REVISION_SIGN.ctrlId || ctrlId == FIELD_REVISION_DELETE.ctrlId
                || ctrlId == FIELD_REVISION_ATTACH.ctrlId || ctrlId == FIELD_REVISION_CLIPPING.ctrlId
                || ctrlId == FIELD_REVISION_THINKING.ctrlId || ctrlId == FIELD_REVISION_PRAISE.ctrlId
                || ctrlId == FIELD_REVISION_LINE.ctrlId || ctrlId == FIELD_REVISION_SIMPLECHANGE.ctrlId
                || ctrlId == FIELD_REVISION_HYPERLINK.ctrlId || ctrlId == FIELD_REVISION_LINEATTACH.ctrlId
                || ctrlId == FIELD_REVISION_LINELINK.ctrlId || ctrlId == FIELD_REVISION_LINETRANSFER.ctrlId
                || ctrlId == FIELD_REVISION_RIGHTMOVE.ctrlId || ctrlId == FIELD_REVISION_LEFTMOVE.ctrlId
                || ctrlId == FIELD_REVISION_TRANSFER.ctrlId || ctrlId == FIELD_REVISION_SIMPLEINSERT.ctrlId
                || ctrlId == FIELD_REVISION_SPLIT.ctrlId || ctrlId == FIELD_REVISION_CHANGE.ctrlId
                || ctrlId == FIELD_MEMO.ctrlId || ctrlId == FIELD_PRIVATE_INFO_SECURITY.ctrlId;
    }
}

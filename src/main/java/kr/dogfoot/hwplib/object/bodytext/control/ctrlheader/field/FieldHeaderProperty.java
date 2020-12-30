package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.field;

import kr.dogfoot.hwplib.util.binary.BitFlag;

/**
 * 필드 컨트롤의 속성을 나타내는 객체
 *
 * @author neolord
 */
public class FieldHeaderProperty {
    /**
     * 파일에 저장되는 정수값(unsigned 4 byte)
     */
    private long value;

    /**
     * 생성자
     */
    public FieldHeaderProperty() {
    }

    /**
     * 파일에 저장되는 정수값을 반롼한다.
     *
     * @return 파일에 저장되는 정수값
     */
    public long getValue() {
        return value;
    }

    /**
     * 파일에 저장되는 정수값을 설정한다.
     *
     * @param value 파일에 저장되는 정수값
     */
    public void setValue(long value) {
        this.value = value;
    }

    /**
     * 읽기 전용 상태에서도 수정 가능한지 여부을 반환한다. (0 bit)
     *
     * @return 읽기 전용 상태에서도 수정 가능한지 여부
     */
    public boolean canModifyInReadOnlyState() {
        return BitFlag.get(value, 0);
    }

    /**
     * 읽기 전용 상태에서도 수정 가능한지 여부를 설정한다. (0 bit)
     *
     * @param canModifyInReadOnlyState 읽기 전용 상태에서도 수정 가능한지 여부
     */
    public void setCanModifyInReadOnlyState(boolean canModifyInReadOnlyState) {
        value = BitFlag.set(value, 0, canModifyInReadOnlyState);
    }

    /**
     * 열어보지 않은 하이퍼링크 필드 업데이트 시 글자 속성 업데이트 여부를 반환한다. (11 bit)
     *
     * @return 열어보지 않은 하이퍼링크 필드 업데이트 시 글자 속성 업데이트 여부
     */
    public boolean isUpdateTextPropertyAtUpdatingHyperlinkNotOpened() {
        return BitFlag.get(value, 11);
    }

    /**
     * 열어보지 않은 하이퍼링크 필드 업데이트 시 글자 속성 업데이트 여부를 설정한다. (11 bit)
     *
     * @param updateTextPropertyAtUpdatingHyperlinkNotOpened 열어보지 않은 하이퍼링크 필드 업데이트 시 글자 속성 업데이트 여부
     */
    public void setUpdateTextPropertyAtUpdatingHyperlinkNotOpened(
            boolean updateTextPropertyAtUpdatingHyperlinkNotOpened) {
        value = BitFlag.set(value, 11,
                updateTextPropertyAtUpdatingHyperlinkNotOpened);
    }

    /**
     * 열어본 하이퍼링크 필드 업데이트 시 글자 속성 업데이트 여부를 반환한다. (12 bit)
     *
     * @return 열어본 하이퍼링크 필드 업데이트 시 글자 속성 업데이트 여부
     */
    public boolean isUpdateTextPropertyAtUpdatingHyperlinkOpened() {
        return BitFlag.get(value, 12);
    }

    /**
     * 열어본 하이퍼링크 필드 업데이트 시 글자 속성 업데이트 여부를 설정한다. (12 bit)
     *
     * @param updateTextPropertyAtUpdatingHyperlinkOpened 열어본 하이퍼링크 필드 업데이트 시 글자 속성 업데이트 여부
     */
    public void setUpdateTextPropertyAtUpdatingHyperlinkOpened(
            boolean updateTextPropertyAtUpdatingHyperlinkOpened) {
        value = BitFlag.set(value, 12,
                updateTextPropertyAtUpdatingHyperlinkOpened);
    }

    /**
     * 생성된 하이퍼링크 필드 업데이트 시 글자 속성 업데이트 여부를 반환한다. (13 bit)
     *
     * @return 생성된 하이퍼링크 필드 업데이트 시 글자 속성 업데이트 여부
     */
    public boolean isUpdateTextPropertyAtUpdatingHyperlinkCreating() {
        return BitFlag.get(value, 13);
    }

    /**
     * 생성된 하이퍼링크 필드 업데이트 시 글자 속성 업데이트 여부를 설정한다. (13 bit)
     *
     * @param updateTextPropertyAtUpdatingHyperlinkCreating
     */
    public void setUpdateTextPropertyAtUpdatingHyperlinkCreating(
            boolean updateTextPropertyAtUpdatingHyperlinkCreating) {
        value = BitFlag.set(value, 13,
                updateTextPropertyAtUpdatingHyperlinkCreating);
    }

    /**
     * 필드 내용이 수정되었는지 여부를 반환한다. (15 bit)
     *
     * @return 필드 내용이 수정되었는지 여부
     */
    public boolean isModifiedContent() {
        return BitFlag.get(value, 15);
    }

    /**
     * 필드 내용이 수정되었는지 여부를 설정한다. (15 bit)
     *
     * @param modifiedContent 필드 내용이 수정되었는지 여부
     */
    public void setModifiedContent(boolean modifiedContent) {
        value = BitFlag.set(value, 15, modifiedContent);
    }

    public void copy(FieldHeaderProperty from) {
        value = from.value;
    }
}

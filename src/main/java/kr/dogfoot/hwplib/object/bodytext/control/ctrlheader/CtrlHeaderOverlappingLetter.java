package kr.dogfoot.hwplib.object.bodytext.control.ctrlheader;

import kr.dogfoot.hwplib.object.bodytext.control.ControlType;

import java.util.ArrayList;

/**
 * 글자 겸침 컨트롤을 위한 컨트롤 헤더 레코드
 *
 * @author neolord
 */
public class CtrlHeaderOverlappingLetter extends CtrlHeader {
    /**
     * 겹침 글자 리스트
     */
    private ArrayList<String> overlappingLetterList;
    /**
     * 테두리 타입
     */
    private short borderType;
    /**
     * 내부 글자 크기
     */
    private byte internalFontSize;
    /**
     * 테두리 내부 글자 펼침
     */
    private short expendInsideLetter;
    /**
     * 테두리 내부 글자의 글자모양 id 리스트
     */
    private ArrayList<Long> charShapeIdList;

    /**
     * 생성자
     */
    public CtrlHeaderOverlappingLetter() {
        super(ControlType.OverlappingLetter.getCtrlId());

        overlappingLetterList = new ArrayList<String>();
        charShapeIdList = new ArrayList<Long>();
    }

    /**
     * 겹쳐지는 글자를 리스트에 추가한다.
     *
     * @param overlappingLetter 겹쳐지는 글자
     */
    public void addOverlappingLetter(String overlappingLetter) {
        overlappingLetterList.add(overlappingLetter);
    }

    /**
     * 겹침 글자 리스트를 반환한다.
     *
     * @return 겹침 글자 리스트
     */
    public ArrayList<String> getOverlappingLetterList() {
        return overlappingLetterList;
    }

    /**
     * 테두리 타입을 반환한다.
     *
     * @return 테두리 타입
     */
    public short getBorderType() {
        return borderType;
    }

    /**
     * 테두리 타입를 설정한다.
     *
     * @param borderType 테두리 타입
     */
    public void setBorderType(short borderType) {
        this.borderType = borderType;
    }

    /**
     * 내부 글자 크기를 반환한다.
     *
     * @return 내부 글자 크기
     */
    public byte getInternalFontSize() {
        return internalFontSize;
    }

    /**
     * 내부 글자 크기를 설정한다.
     *
     * @param internalFontSize 내부 글자 크기
     */
    public void setInternalFontSize(byte internalFontSize) {
        this.internalFontSize = internalFontSize;
    }

    /**
     * 테두리 내부 글자 펼침을 반환한다.
     *
     * @return 테두리 내부 글자 펼침
     */
    public short getExpendInsideLetter() {
        return expendInsideLetter;
    }

    /**
     * 테두리 내부 글자 펼침을 설정한다.
     *
     * @param expendInsideLetter 테두리 내부 글자 펼침
     */
    public void setExpendInsideLetter(short expendInsideLetter) {
        this.expendInsideLetter = expendInsideLetter;
    }

    /**
     * 테두리 내부 글자의 글자모양 id를 리스트에 추가한다.
     *
     * @param charShapeId 테두리 내부 글자의 글자모양 id
     */
    public void addCharShapeId(long charShapeId) {
        charShapeIdList.add(charShapeId);
    }

    /**
     * 테두리 내부 글자의 글자모양 id 리스트를 반환한다.
     *
     * @return 테두리 내부 글자의 글자모양 id 리스트
     */
    public ArrayList<Long> getCharShapeIdList() {
        return charShapeIdList;
    }

    @Override
    public void copy(CtrlHeader from) {
        CtrlHeaderOverlappingLetter from2 = (CtrlHeaderOverlappingLetter) from;
        overlappingLetterList.clear();
        for (String str : from2.overlappingLetterList) {
            overlappingLetterList.add(str);
        }

        borderType = from2.borderType;
        internalFontSize = from2.internalFontSize;
        expendInsideLetter = from2.expendInsideLetter;

        charShapeIdList.clear();
        for (Long lng : from2.charShapeIdList) {
            charShapeIdList.add(lng);
        }
    }
}

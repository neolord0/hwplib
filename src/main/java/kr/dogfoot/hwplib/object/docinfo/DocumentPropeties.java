package kr.dogfoot.hwplib.object.docinfo;

import kr.dogfoot.hwplib.object.docinfo.documentproperties.CaretPosition;
import kr.dogfoot.hwplib.object.docinfo.documentproperties.StartNumber;

/**
 * 문서 속성를 나타내는 레코드
 *
 * @author neolord
 */
public class DocumentPropeties {
    /**
     * 구역 개수
     */
    private int sectionCount;
    /**
     * 문서 내 각종 시작번호에 대한 정보
     */
    private StartNumber startNumber;
    /**
     * 문서 내 캐럿의 위치 정보
     */
    private CaretPosition caretPosition;

    /**
     * 생성자
     */
    public DocumentPropeties() {
        startNumber = new StartNumber();
        caretPosition = new CaretPosition();
    }

    /**
     * 구역 개수를 반환한다.
     *
     * @return 구역 개수
     */
    public int getSectionCount() {
        return sectionCount;
    }

    /**
     * 구역 개수를 설정한다.
     *
     * @param sectionCount 구역 개수
     */
    public void setSectionCount(int sectionCount) {
        this.sectionCount = sectionCount;
    }

    /**
     * 문서 내 각종 시작번호에 대한 정보 객체를 반환한다.
     *
     * @return 문서 내 각종 시작번호에 대한 정보 객체
     */
    public StartNumber getStartNumber() {
        return startNumber;
    }

    /**
     * 문서 내 캐럿의 위치 정보 객체를 반환한다.
     *
     * @return 문서 내 캐럿의 위치 정보 객체
     */
    public CaretPosition getCaretPosition() {
        return caretPosition;
    }

    public void copy(DocumentPropeties from) {
        sectionCount = from.sectionCount;
        startNumber.copy(from.startNumber);
        caretPosition.copy(from.caretPosition);
    }
}

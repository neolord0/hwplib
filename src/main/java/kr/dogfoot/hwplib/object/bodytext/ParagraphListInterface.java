package kr.dogfoot.hwplib.object.bodytext;

import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;

/**
 * 문단 리스트 인터페이스
 *
 * @author neolord
 */
public interface ParagraphListInterface extends Iterable<Paragraph> {
    /**
     * 새로운 문단를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 문단
     */
    Paragraph addNewParagraph();

    /**
     * 문단 개수를 반환한다.
     *
     * @return 문단 개수
     */
    int getParagraphCount();

    /**
     * index 번째의 문단을 반환한다.
     *
     * @param index 찾고자 하는 문단의 순번
     * @return index 번째의 문단
     */
    Paragraph getParagraph(int index);
}

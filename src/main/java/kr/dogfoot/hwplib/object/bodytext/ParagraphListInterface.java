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

    /**
     * 문단 배열을 리턴한다.
     *
     * @return 문단 배열
     */
    Paragraph[] getParagraphs();

    /**
     * index 번째의 문단을 삭제한다.
     *
     * @param index 삭제할 문단의 순번
     */
    void deleteParagraph(int index);

    /**
     * 모든 문단을 삭제한다.
     */
    void deleteAllParagraphs();

    /**
     * 문단을 삽입한다.
     *
     * @param index  삽입할 위치
     * @param para   문단
     */
    void insertParagraph(int index, Paragraph para);

    /**
     * index 번째의 문단을 새로 생성하여 삽입한다.
     *
     * @param index 상입하고자 하는 문단의 순번
     * @return 새로 삽입된 문단
     */
    Paragraph insertNewParagraph(int index);
}



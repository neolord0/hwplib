package kr.dogfoot.hwplib.object.bodytext;

import java.util.ArrayList;

/**
 * 본문를 나타나는 객체. HWP파일 내에 "BodyText" storage에 저장된다.
 *
 * @author neolord
 */

public class BodyText {
    /**
     * 문서 영역(섹션) 리스트
     */
    private ArrayList<Section> sectionList;

    /**
     * 생성자
     */
    public BodyText() {
        sectionList = new ArrayList<Section>();
    }

    /**
     * 새로운 문서 영역(섹션)을 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 문서 영역(섹션)
     */
    public Section addNewSection() {
        Section s = new Section();
        sectionList.add(s);
        return s;
    }

    /**
     * 문서 영역(섹션) 리스트를 반환한다.
     *
     * @return 문서 영역(섹션) 리스트
     */
    public ArrayList<Section> getSectionList() {
        return sectionList;
    }

    public void copy(BodyText from) {
        sectionList.clear();
        for (Section section : from.sectionList) {
            sectionList.add(section.clone());
        }
    }
}

package kr.dogfoot.hwplib.object.bodytext.paragraph.rangetag;

import kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg.ParaLineSeg;

import java.util.ArrayList;

/**
 * 문단의 영역 태그에 대한 레코드
 *
 * @author neolord
 */
public class ParaRangeTag {
    /**
     * 영역 태그 정보에 대한 객체의 리스트
     */
    private ArrayList<RangeTagItem> rangeTagItemList;

    /**
     * 생성자
     */
    public ParaRangeTag() {
        rangeTagItemList = new ArrayList<RangeTagItem>();
    }

    /**
     * 새로운 영역 태그 정보의 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 영역 태그 정보에 대한 객체
     */
    public RangeTagItem addNewRangeTagItem() {
        RangeTagItem rt = new RangeTagItem();
        rangeTagItemList.add(rt);
        return rt;
    }

    /**
     * 영역 태그 정보에 대한 객체의 리스트를 반환한다.
     *
     * @return 영역 태그 정보에 대한 객체의 리스트
     */
    public ArrayList<RangeTagItem> getRangeTagItemList() {
        return rangeTagItemList;
    }

    public ParaRangeTag clone() {
        ParaRangeTag cloned = new ParaRangeTag();

        for (RangeTagItem rangeTagItem : rangeTagItemList) {
            cloned.rangeTagItemList.add(rangeTagItem.clone());
        }

        return cloned;
    }
}

package kr.dogfoot.hwplib.object.bodytext.paragraph.lineseg;

import kr.dogfoot.hwplib.object.bodytext.paragraph.charshape.ParaCharShape;

import java.util.ArrayList;

/**
 * 문단의 레이아웃 레코드
 *
 * @author neolord
 */
public class ParaLineSeg {
    /**
     * 각 줄의 align 정보의 리스트
     */
    private ArrayList<LineSegItem> lineSegItemList;

    /**
     * 생성자
     */
    public ParaLineSeg() {
        lineSegItemList = new ArrayList<LineSegItem>();
    }

    /**
     * 각 줄의 align 정보에 대한 객체를 새로 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 각 줄의 align 정보에 대한 객체
     */
    public LineSegItem addNewLineSegItem() {
        LineSegItem plsi = new LineSegItem();
        lineSegItemList.add(plsi);
        return plsi;
    }

    /**
     * 각 줄의 align 정보의 리스트를 반환한다.
     *
     * @return 각 줄의 align 정보의 리스트
     */
    public ArrayList<LineSegItem> getLineSegItemList() {
        return lineSegItemList;
    }

    public ParaLineSeg clone() {
        ParaLineSeg cloned = new ParaLineSeg();

        for (LineSegItem lineSegItem : lineSegItemList) {
            cloned.lineSegItemList.add(lineSegItem.clone());
        }

        return cloned;
    }
}

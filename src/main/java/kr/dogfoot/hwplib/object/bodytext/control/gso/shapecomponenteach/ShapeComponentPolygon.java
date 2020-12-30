package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;

import java.util.ArrayList;

/**
 * 다각형 개체 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentPolygon {
    /**
     * 좌표 리스트
     */
    private ArrayList<PositionXY> positionList;

    /**
     * 생성자
     */
    public ShapeComponentPolygon() {
        positionList = new ArrayList<PositionXY>();
    }

    /**
     * 새로운 좌표 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 좌표 객체
     */
    public PositionXY addNewPosition() {
        PositionXY p = new PositionXY();
        positionList.add(p);
        return p;
    }

    /**
     * 좌표 리스트를 반환한다.
     *
     * @return 좌표 리스트
     */
    public ArrayList<PositionXY> getPositionList() {
        return positionList;
    }

    public void copy(ShapeComponentPolygon from) {
        positionList.clear();
        for (PositionXY positionXY : from.positionList) {
            positionList.add(positionXY.clone());
        }
    }
}

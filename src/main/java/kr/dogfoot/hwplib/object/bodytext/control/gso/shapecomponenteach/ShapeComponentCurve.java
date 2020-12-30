package kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach;

import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.curve.CurveSegmentType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.polygon.PositionXY;

import java.util.ArrayList;

/**
 * 곡선 개체 속성 레코드
 *
 * @author neolord
 */
public class ShapeComponentCurve {
    /**
     * 좌표 리스트
     */
    private ArrayList<PositionXY> positionList;
    /**
     * segment type 리스트
     */
    private ArrayList<CurveSegmentType> segmentTypeList;

    /**
     * 생성자
     */
    public ShapeComponentCurve() {
        positionList = new ArrayList<PositionXY>();
        segmentTypeList = new ArrayList<CurveSegmentType>();
    }

    /**
     * 새로운 좌표 객체를 생성하고 리스트에 추가한다.
     *
     * @return 새로 생성된 좌료 객체
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

    /**
     * segment type을 리스트에 추가한다.
     *
     * @param cst segment type
     */
    public void addCurveSegmentType(CurveSegmentType cst) {
        segmentTypeList.add(cst);
    }

    /**
     * segment type 리스트를 반환한다.
     *
     * @return segment type 리스트
     */
    public ArrayList<CurveSegmentType> getSegmentTypeList() {
        return segmentTypeList;
    }

    public void copy(ShapeComponentCurve from) {
        positionList.clear();;
        for (PositionXY positionXY : from.positionList) {
            positionList.add(positionXY.clone());
        }

        segmentTypeList.clear();
        for (CurveSegmentType curveSegmentType : from.segmentTypeList) {
            segmentTypeList.add(curveSegmentType);
        }
    }
}
